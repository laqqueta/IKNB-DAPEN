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
import id.go.ojk.lib.client.model.constant.Comparation;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("compareSumColumnValidation")
public class CompareSumColumnValidation extends MapParamSegmentValidation {
	private static transient Logger logger = LoggerFactory.getLogger(CompareSumColumnValidation.class);
	private String selectField;
	private String leftFieldFormula;
	private String rightFieldFormula;
	private String operator;
	private Comparation comparation;
	private Boolean roundFull;
	private String msgError;
	private int totalRow;

	public CompareSumColumnValidation() {
		super();
	}

	public CompareSumColumnValidation(String parameter) {
		super(parameter);
	}

	@XStreamOmitField
	private ReferenceService referenceService = null;

	@Override
	public CompareSumColumnValidation initialized() {
		leftFieldFormula = getStringParameter("leftFieldFormula");
		rightFieldFormula = getStringParameter("rightFieldFormula");
		operator = getStringParameter("operator");
		selectField = getStringParameter("selectField");
		msgError = getStringParameter("msgError");
		
		switch (operator) {
		case "e":
			comparation = Comparation.e;
			break;
		case "ne":
			comparation = Comparation.ne;
			break;
		case "lt":
			comparation = Comparation.lt;
			break;
		case "lte":
			comparation = Comparation.lte;
			break;
		case "gt":
			comparation = Comparation.gt;
			break;
		case "gte":
			comparation = Comparation.gte;
			break;
		default:
			break;
		}
		
		roundFull = getBooleanParameter("roundFull");
		if(roundFull == null) {
			roundFull = false;
		}
		
		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
		List<SubmissionField> fields = submissionFormat.getFields();
		
		totalRow = submissionFormat.getTotalRow() - 1;
		
		if (validationResult.lineNumber == totalRow) {
			Double leftValue = Double.parseDouble(readFormula(leftFieldFormula, validationResult, submissionFormat));
			Double rightValue = Double.parseDouble(readFormula(rightFieldFormula, validationResult, submissionFormat));
			
			String[] msgErrorSplit = msgError.split("[|]");
			String msg = msgErrorSplit[0]+ " "+ comparation.getCode() + " "+ msgErrorSplit[1];
			
			if(!comparation.testCompareDouble(leftValue, rightValue)) {
				validationResult.errors.add(new ValidationError(fields.get(Integer.parseInt(selectField)), ValidationErrorCode.E50_10_FORMULA2, msg));
			}
			
		}
	}
	
	private String readFormula(String formula, ValidationResult validationResult, SubmissionFormat submissionFormat) {
		String officeCode = submissionFormat.getHaveOfficeCode() ? validationResult.getColumn(1) : "000";
		String posCode = submissionFormat.getHavePosCode() ? validationResult.getColumn(2) : submissionFormat.getCode();
		String keyNoSeq = officeCode + "-" + posCode;
		
		String formulaValue = "";
		String[] formulaSplit = formula.split("(?<=[-+*/()@])|(?=[-+*/()])");
		Map<Integer, String> mapFormulaSplit = new HashMap<Integer, String>();
		
		for (int i = 0; i < formulaSplit.length; i++) {
			mapFormulaSplit.put(i, formulaSplit[i]);
		}
		
		for (Entry<Integer, String> entry : mapFormulaSplit.entrySet()){
			if(entry.getValue().matches("-?\\d+")) {
				Double sumVal = 0.00;
				for (Entry<String, List<String>> entryVal : SubmissionFormat.mapPosValueLBBPRK.entrySet()){
					if(entryVal.getKey().contains(keyNoSeq)){
						try {
							sumVal += Double.parseDouble(entryVal.getValue().get(Integer.parseInt(entry.getValue())));
						} catch (NumberFormatException e) {
							
						}
					}
				}
				
				entry.setValue(Double.toString(sumVal));
			}
			
			formulaValue = formulaValue.concat(entry.getValue());
		}		
		
		if(formulaSplit.length > 1) {
			formulaValue = convertValue(formulaValue);
		}
		
		return formulaValue;
	}
	
	private String convertValue(String formulaValue) {
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
}