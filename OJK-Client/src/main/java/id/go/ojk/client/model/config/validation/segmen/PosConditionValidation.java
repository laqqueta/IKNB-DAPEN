package id.go.ojk.client.model.config.validation.segmen;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
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

@XStreamAlias("posConditionValidation")
public class PosConditionValidation extends BaseRowValidation {
	private static transient Logger logger = LoggerFactory.getLogger(ComparePosValidation.class);
	private String fieldCondition;
	private String fieldConditionPos;
	private String fieldConditionValue;
	private String fieldConditionOperator;
	private String trueValue;
	private String leftFormula;
	private String rightFormula;
	private String rightFormulaFalse;
	private String operator;
	private Comparation comparation;
	private Comparation conditionComparation;
	private String msgError;
	private String msgErrorFalse;
	private Boolean roundFull;

	public PosConditionValidation() {
		super();
	}

	public PosConditionValidation(String parameter) {
		super(parameter);
	}

	@XStreamOmitField
	private ReferenceService referenceService = null;

	@Override
	public PosConditionValidation initialized() {
		super.initialized();
		fieldCondition = getStringParameter("fieldCondition");
		fieldConditionPos = getStringParameter("fieldConditionPos");
		fieldConditionValue = getStringParameter("fieldConditionValue");
		fieldConditionOperator = getStringParameter("fieldConditionOperator");
		trueValue = getStringParameter("trueValue");
		leftFormula = getStringParameter("leftFormula");
		rightFormula = getStringParameter("rightFormula");
		rightFormulaFalse = getStringParameter("rightFormulaFalse");
		operator = getStringParameter("operator");
		msgError = getStringParameter("msgError");
		msgErrorFalse = getStringParameter("msgErrorFalse");
		
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
		
		switch (fieldConditionOperator) {
		case "e":
			conditionComparation = Comparation.e;
			break;
		case "ne":
			conditionComparation = Comparation.ne;
			break;
		case "lt":
			conditionComparation = Comparation.lt;
			break;
		case "lte":
			conditionComparation = Comparation.lte;
			break;
		case "gt":
			conditionComparation = Comparation.gt;
			break;
		case "gte":
			conditionComparation = Comparation.gte;
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
		String[] selectPosCodeSplit = selectPosCode.split("[|]");
		String[] fieldConditionValueSplit = fieldConditionValue.split("[|]");
		List<String> fieldConditionValueArray = new ArrayList<String>();
		
		String fieldValue = fieldCondition != null ? validationResult.getColumn(Integer.parseInt(fieldCondition)) : "";
		String posCode = validationResult.getColumn(2);
		String posValue = validationResult.getColumn(Integer.parseInt(selectField));
		
		for (String val : fieldConditionValueSplit) {
			fieldConditionValueArray.add(val);
		}
		
		for (String posCodeFromSplit : selectPosCodeSplit) {
			if (posCodeFromSplit.equals(posCode) && fieldConditionOperator.equals("ne") && !fieldConditionValueArray.contains(fieldValue)) {
				String msg = comparation.getDesc() + " " + msgError;
				try {
					Boolean result = comparation.testCompareDouble(Double.parseDouble(posValue), Double.parseDouble(trueValue));
					if(!result) {
						validationResult.errors.add(new ValidationError(fields.get(Integer.parseInt(selectField)), ValidationErrorCode.E50_10_FORMULA2, msg));
					}
				} catch (NumberFormatException e) {
					// TODO: handle exception
				}
			}
			
			if (posCodeFromSplit.equals(posCode) && fieldConditionPos != null) {
				String officeCode = validationResult.getColumn(1);
				String key = officeCode + "-" + fieldConditionPos;
				String conditionValue = SubmissionFormat.mapPosValueLBBPRK.get(key).get(Integer.parseInt(selectField));
				
				if (conditionComparation.testCompareDouble(Double.parseDouble(conditionValue), Double.parseDouble(fieldConditionValue))) {
					String[] msgErrorSplit = msgError.split("[|]");
					String msg = msgErrorSplit[0]+ " "+ comparation.getCode() + " "+ msgErrorSplit[1] + " Sandi Kantor " + officeCode;
					
					Double leftValue = Double.parseDouble(readFormula(leftFormula, validationResult, submissionFormat));
					Double rightValue = Double.parseDouble(readFormula(rightFormula, validationResult, submissionFormat));

					if(!comparation.testCompareDouble(leftValue, rightValue)) {
						validationResult.errors.add(new ValidationError(fields.get(Integer.parseInt(selectField)), ValidationErrorCode.E50_10_FORMULA2, msg));
					}
				} else {
					String[] msgErrorSplit = msgErrorFalse.split("[|]");
					String msg = msgErrorSplit[0]+ " "+ comparation.getCode() + " "+ msgErrorSplit[1] + " Sandi Kantor " + officeCode;
					
					Double leftValue = Double.parseDouble(readFormula(leftFormula, validationResult, submissionFormat));
					Double rightValueFalse = Double.parseDouble(readFormula(rightFormulaFalse, validationResult, submissionFormat));
					
					if(!comparation.testCompareDouble(leftValue, rightValueFalse)) {
						validationResult.errors.add(new ValidationError(fields.get(Integer.parseInt(selectField)), ValidationErrorCode.E50_10_FORMULA2, msg));
					}
				}				
			}
		}
		
	}
	
	private String readFormula(String formula, ValidationResult validationResult, SubmissionFormat submissionFormat) {
		String officeCode = submissionFormat.getHaveOfficeCode() ? validationResult.getColumn(1) : "000";		
		String formulaValue = "";
		String[] formulaSplit = formula.split("(?<=[-+*/()@])|(?=[-+*/()])");
		Map<Integer, String> mapFormulaSplit = new HashMap<Integer, String>();
		
		for (int i = 0; i < formulaSplit.length; i++) {
			mapFormulaSplit.put(i, formulaSplit[i]);
		}
		
		for (Entry<Integer, String> entry : mapFormulaSplit.entrySet()){
			String entrySplit[] = entry.getValue().split("[:]");
 			String posKey = entrySplit[0];
 			String columnPosition = null;
 			
 			try {
 				columnPosition = selectPosCode == null ? selectField : entrySplit[1];
			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO: handle exception
			}
			
			String posKeyNoSeq = officeCode + "-" + posKey;
			
			if(posKey.matches("-?\\d+")) {
				Double sumVal = 0.00;
				for (Entry<String, List<String>> entryVal : SubmissionFormat.mapPosValueLBBPRK.entrySet()){
					if(entryVal.getKey().contains(posKeyNoSeq)){
						try {
							sumVal += Double.parseDouble(entryVal.getValue().get(Integer.parseInt(columnPosition)));
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