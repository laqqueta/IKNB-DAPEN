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
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("conditionReaderValidation")
public class ConditionReaderValidation extends BaseRowValidation {
	private static transient Logger logger = LoggerFactory.getLogger(ConditionReaderValidation.class);
	private String condition;
	private String actionTrue;
	private String actionFalse;
	private String msgErrorTrue;
	private String msgErrorFalse;
	private String[] conditionSplit;
	private String[] actionTrueSplit;
	private String[] actionFalseSplit;
	private String[] msgErrorTrueSplit;
	private String[] msgErrorFalseSplit;
	private int totalRow;
	private boolean posExist;
	private String maxIndexField;
	private Boolean relationForm;
	private Boolean roundFull;

	public ConditionReaderValidation() {
		super();
	}

	public ConditionReaderValidation(String parameter) {
		super(parameter);
	}

	@XStreamOmitField
	private ReferenceService referenceService = null;

	@Override
	public ConditionReaderValidation initialized() {
		super.initialized();
		condition = getStringParameter("condition");
		actionTrue = getStringParameter("actionTrue");
		actionFalse = getStringParameter("actionFalse");
		msgErrorTrue = getStringParameter("msgErrorTrue");
		msgErrorFalse = getStringParameter("msgErrorFalse");
		
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
		
		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {	
		String[] SelectField = selectField.split("[|]");
		String posCode = validationResult.getColumn(1);
		Double valMIDelimiter = Double.parseDouble(submissionFormat.getValMIDelimiter()); 
		Double modalIntiValue = Double.parseDouble(SubmissionFormat.modalInti.get(0)); // +an
		conditionSplit = condition.split("[|]");
		actionTrueSplit = actionTrue.split("[|]");
		actionFalseSplit = actionFalse.split("[|]");
		msgErrorTrueSplit = msgErrorTrue.split("[|]");
		msgErrorFalseSplit = msgErrorFalse.split("[|]");
		totalRow = submissionFormat.getTotalRow()-3;
		
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
				conditionExec(validationResult, submissionFormat.getFields(), field, seq);					
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
					validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E50_03_POS_MUST_EXIST, posExist, selectPosCode));						
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
		
		if (mapFormulaSplit.get(0).equals("@")) {
			mapFormulaSplit.remove(0);
			for (Entry<String, Map<String, String>> entry : SubmissionFormat.mapPosValue.entrySet()) {
				if (entry.getKey().contains(formulaSplit[1])) {
					multiplePosValue += Double.parseDouble(entry.getValue().get(String.valueOf(seq)));
				}
			}
			formulaValue = Double.toString(multiplePosValue);
		} else {
			for (Entry<Integer, String> entry : mapFormulaSplit.entrySet()){
				if (SubmissionFormat.mapPosValue.containsKey(entry.getValue())){
					entry.setValue(SubmissionFormat.mapPosValue.get(entry.getValue()).get(seq));				
				}
				formulaValue = formulaValue.concat(entry.getValue());	
			}
		}
		
		if(!formulaValue.equals("null"))
			formulaValue = convertValue(formulaValue);
		
		return formulaValue;
	}
	
	private void conditionExec(ValidationResult validationResult, List<SubmissionField> submissionField, String field, Integer seq) {
		boolean resultCondition, resultActTrue, resultActFalse;
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		
		String leftCondition = readFormula(conditionSplit[0], seq);
		String opCondition = convertOperator(conditionSplit[1]);
		String rightCondition = readFormula(conditionSplit[2], seq);		
		String finalCondition = leftCondition + opCondition + rightCondition;	

		if(!leftCondition.equals("null") && !rightCondition.equals("null")) {
			try {
				resultCondition = (boolean) engine.eval(finalCondition);
				
				if(resultCondition) {
					String leftActTrue = readFormula(actionTrueSplit[0], seq);					
					String opActTrue = convertOperator(actionTrueSplit[1]);					
					String rightActTrue = readFormula(actionTrueSplit[2], seq);	
					String finalActTrue = leftActTrue + opActTrue + rightActTrue;
					opActTrue = opActTrue.equals("==")? "=":opActTrue;
					String msgErrActTrue = msgErrorTrueSplit[0] + " " + opActTrue + " " +msgErrorTrueSplit[1];
					
					resultActTrue = (boolean) engine.eval(finalActTrue);
					if(!resultActTrue){
						validationResult.errors.add(new ValidationError(submissionField.get(Integer.parseInt(field)), ValidationErrorCode.E50_02_FORMULA, finalActTrue, msgErrActTrue));
					}
				}				
				else{
					String leftActFalse = readFormula(actionFalseSplit[0], seq);
					String opActFalse = convertOperator(actionFalseSplit[1]);
					String rightActFalse = readFormula(actionFalseSplit[2], seq);					
					String finalActFalse = leftActFalse + opActFalse + rightActFalse;
					opActFalse = opActFalse.equals("==")? "=":opActFalse;
					String msgErrActFalse = msgErrorFalseSplit[0] + " "+ opActFalse + " " + msgErrorFalseSplit[1];
					
					resultActFalse = (boolean) engine.eval(finalActFalse);
					if(!resultActFalse){
						validationResult.errors.add(new ValidationError(submissionField.get(Integer.parseInt(field)), ValidationErrorCode.E50_02_FORMULA, finalActFalse, msgErrActFalse));
					}
				}
			} catch (ScriptException e) {
				logger.error(e.getMessage(), e);
			}
		}
	}
	
	private String convertValue(String formulaValue){
		Double initialValue = null;
		Double finalValue = null;
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		
		try {
			initialValue = (Double) engine.eval(formulaValue);
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
	
	private String convertOperator(String operator){
		switch (operator) {
		case "e":
			operator = "==";
			break;
		case "ne":
			operator = "!=";
			break;
		case "lt":
			operator = "<";
			break;
		case "lte":
			operator = "<=";
			break;
		case "gt":
			operator = ">";
			break;
		case "gte":
			operator = ">=";
			break;
		default:
			break;
		}
		
		return operator;
	}
}