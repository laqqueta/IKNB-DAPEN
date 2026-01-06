package id.go.ojk.client.model.config.validation.segmen;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("formulaReaderValidation")
public class FormulaReaderValidation extends BaseRowValidation {
	private static transient Logger logger = LoggerFactory.getLogger(FormulaReaderValidation.class);
	private String leftFormula;
	private String rightFormula;
	private String operator;
	private String operatorFormula;	
	private String maxIndexField;
	private String msgError;
	private Double maxPrecision;
	private int totalRow;
	private boolean posExist;
	private Boolean relationForm;
	private Boolean roundFull;

	public FormulaReaderValidation() {
		super();
	}

	public FormulaReaderValidation(String parameter) {
		super(parameter);
	}

	@Override
	public FormulaReaderValidation initialized() {
		super.initialized();
		leftFormula = getStringParameter("leftFormula");
		rightFormula = getStringParameter("rightFormula");
		operator = getStringParameter("operator");
		msgError = getStringParameter("msgError");
		maxPrecision = getDoubleParameter("maxPrecision", "0");
		
		maxIndexField = getStringParameter("maxIndexField");
		if(maxIndexField == null){
			maxIndexField = "0";
		}
		
		relationForm = getBooleanParameter("relationForm");
		if(relationForm == null) {
			relationForm = false;
		}
		
		roundFull = getBooleanParameter("roundFull");
		if(roundFull == null) {
			roundFull = false;
		}
		posExist = false;
		
		switch (operator) {
		case "e":
			operatorFormula = "==";
			break;
		case "ne":
			operatorFormula = "!=";
			break;
		case "lt":
			operatorFormula = "<";
			break;
		case "lte":
			operatorFormula = "<=";
			break;
		case "gt":
			operatorFormula = ">";
			break;
		case "gte":
			operatorFormula = ">=";
			break;
		default:
			break;
		}
		
		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
		String[] SelectField = selectField.split("[|]");		
		String posCode = validationResult.getColumn(1);
		Double valMIDelimiter = Double.parseDouble(submissionFormat.getValMIDelimiter() != null ? submissionFormat.getValMIDelimiter() : "0");
		Double modalIntiValue = Double.parseDouble(SubmissionFormat.modalInti.isEmpty() ? "0" : SubmissionFormat.modalInti.get(0)); // +an
		totalRow = submissionFormat.getTotalRow()-3; //Total Row Detail		
		
		if(posCode.contains(selectPosCode)) {
			int seq = 0;
			Integer maxIndex = SelectField.length-1;
			
			if (!maxIndexField.equals("0")){
				if (modalIntiValue < valMIDelimiter){
					maxIndex = Integer.parseInt(maxIndexField);
				}
			}
			
			for (int i = 0; i <= maxIndex; i++) {
				String field = SelectField[i];
				compareFormula(validationResult, submissionFormat.getFields(), field, seq, leftFormula, operatorFormula, rightFormula);					
				seq++;					
			}
			
			posExist = true;
		}
		else{ 
			if(posExist == true && validationResult.lineNumber == 1){
				posExist = false;
			}
			if(posExist == false){					
				if(validationResult.lineNumber == totalRow){						
					validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E50_03_POS_MUST_EXIST, posExist, leftFormula));						
				}				
			}
		}			
	}
	
	private String readFormula(String formula, Integer seq) {
		Map<Integer, String> mapFormulaSplit = new HashMap<Integer, String>();
		String[] formulaSplit;
		String formulaValue;
		double multiplePosValue = 0;
		formulaValue = "";
		formulaSplit = formula.split("(?<=[-+*/()@])|(?=[-+*/()])");
		
		for (int i = 0; i < formulaSplit.length; i++) {
			mapFormulaSplit.put(i, formulaSplit[i]);
		}
		
		if(mapFormulaSplit.get(0).equals("@")){
			mapFormulaSplit.remove(0);
			for (Entry<String, Map<String, String>> entry : SubmissionFormat.mapPosValue.entrySet()){
				if(entry.getKey().contains(formulaSplit[1])){
					multiplePosValue += Double.parseDouble(entry.getValue().get(String.valueOf(seq)));
				}
			}
			formulaValue = Double.toString(multiplePosValue);
		}
		else{
			for (Entry<Integer, String> entry : mapFormulaSplit.entrySet()){
				if(SubmissionFormat.mapPosValue.containsKey(entry.getValue())){
					entry.setValue(SubmissionFormat.mapPosValue.get(entry.getValue()).get(seq.toString()));				
				}
				formulaValue = formulaValue.concat(entry.getValue());	
			}
		}
		
		if(!formulaValue.equals("null"))
			formulaValue = convertValue(formulaValue);
		
		return formulaValue;
	}
	
	private void compareFormula(ValidationResult validationResult, List<SubmissionField> submissionField, String field, Integer seq, String leftFormula, String operator, String rightFormula) {
		boolean result;
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		String[] MsgError = msgError.split("[|]");		
		String compareValue = "";
		Double leftResult = null;
		Double rightResult = null;
		
		String leftValue = readFormula(leftFormula, seq);
		String rightValue = readFormula(rightFormula, seq);	
		compareValue = leftValue + operator + rightValue;
		
		operator = operator.equals("==")? "=":operator;
		String msg = MsgError[0]+" "+operator+" "+MsgError[1];

		if(!leftValue.equals("null") && !rightValue.equals("null")) {
			try {
				if(engine.eval(leftValue).getClass() == Double.class && engine.eval(rightValue).getClass() == Double.class) {
					leftResult = (Double) engine.eval(leftValue);
					rightResult = (Double) engine.eval(rightValue);
				}
				result = (boolean) engine.eval(compareValue);
				if(!result && operator.equals("=") && Math.abs(leftResult-rightResult) > maxPrecision) {
					validationResult.errors.add(new ValidationError(submissionField.get(Integer.parseInt(field)), ValidationErrorCode.E50_02_FORMULA, compareValue, msg));
				}
				else if(!result && !operator.equals("=")) {
					validationResult.errors.add(new ValidationError(submissionField.get(Integer.parseInt(field)),
							ValidationErrorCode.E50_02_FORMULA, compareValue, msg));
				}
			} catch (ScriptException e) {
				logger.error(e.getMessage(), e);
			}
		}
		else{
			if(leftValue.equals("null")){
				validationResult.errors.add(new ValidationError(submissionField.get(Integer.parseInt(field)), ValidationErrorCode.E50_05_VALUE_NOT_FOUND, compareValue, MsgError[0]));
			}
			else{
				validationResult.errors.add(new ValidationError(submissionField.get(Integer.parseInt(field)), ValidationErrorCode.E50_05_VALUE_NOT_FOUND, compareValue, MsgError[1]));
			}
			//validationResult.errors.add(new ValidationError(submissionField.get(Integer.parseInt(field)), ValidationErrorCode.E50_02_FORMULA, compareValue, msg));			
		}
	}
	
	private String convertValue(String formulaValue){
		Double initialValue = null;
		Double finalValue = null;	
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		
		try {
			Object obj = engine.eval(formulaValue);
			initialValue = Double.valueOf(obj != null ? String.valueOf(obj) : "0");
			if(initialValue.isNaN() || initialValue.isInfinite()) { //arnol modif : jika dibagi 0 maka nilai 0
				initialValue = 0.0;
			}
			
			if(roundFull) {
				//bilangan bulat	
				finalValue = BigDecimal.valueOf(initialValue)
						.setScale(0, RoundingMode.HALF_UP)
						.doubleValue();
			} else {
				//pembulatan 2 angka dibelakang koma	
				finalValue = BigDecimal.valueOf(initialValue)
						.setScale(2, RoundingMode.HALF_UP)
						.doubleValue();
			}
		} catch (ScriptException e) {
			logger.error(e.getMessage(), e);
		}
		
		return finalValue.toString();
	}
}