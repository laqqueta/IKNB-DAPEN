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

@XStreamAlias("comparePosValidation")
public class ComparePosValidation extends BaseRowValidation {
	private static transient Logger logger = LoggerFactory.getLogger(ComparePosValidation.class);
	private String leftFormula;
	private String rightFormula;
	private String rightFieldCondition;
	private String rightFieldValue;
	private String operator;
	private Comparation comparation;
	private Boolean roundFull;
	private Boolean officeCodeErrorChecker;
	private Boolean joinOfficeOnly;
	private String msgError;

	public ComparePosValidation() {
		super();
	}

	public ComparePosValidation(String parameter) {
		super(parameter);
	}

	@XStreamOmitField
	private ReferenceService referenceService = null;

	@Override
	public ComparePosValidation initialized() {
		super.initialized();
		leftFormula = getStringParameter("leftFormula");
		rightFormula = getStringParameter("rightFormula");
		rightFieldCondition = getStringParameter("rightFieldCondition");
		rightFieldValue = getStringParameter("rightFieldValue");
		operator = getStringParameter("operator");
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
		
		officeCodeErrorChecker = getBooleanParameter("officeCodeErrorChecker");
		if(officeCodeErrorChecker == null) {
			officeCodeErrorChecker = false;
		}
		
		joinOfficeOnly = getBooleanParameter("joinOfficeOnly");
		if(joinOfficeOnly == null) {
			joinOfficeOnly = false;
		}
		
		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
		List<SubmissionField> fields = submissionFormat.getFields();
		
		String officeCode = validationResult.getColumn(1);
		String[] msgErrorSplit = msgError.split("[|]");
		String msg = msgErrorSplit[0]+ " "+ comparation.getCode() + " "+ msgErrorSplit[1] + " Sandi Kantor " + officeCode;
		
		if (!officeCode.equals("000") && !joinOfficeOnly) {
			if (submissionFormat.getHavePosCode()) {
				String posCode = validationResult.getColumn(2);
				
				if (posCode.equals(selectPosCode)) {
					Double leftValue = Double.parseDouble(readFormula(leftFormula, validationResult, submissionFormat));
					Double rightValue = null;
					
					if (rightFieldCondition == null) {
						rightValue = Double.parseDouble(readFormula(rightFormula, validationResult, submissionFormat));
					} else {
						rightValue = Double.parseDouble(readFormulaCondition(rightFormula, validationResult, submissionFormat));
					}
					
					if(!comparation.testCompareDouble(leftValue, rightValue)) {
						validationResult.errors.add(new ValidationError(fields.get(Integer.parseInt(selectField)), ValidationErrorCode.E50_10_FORMULA2, msg));
					}
				}
			}
			
			if (officeCodeErrorChecker) {
				if (!SubmissionFormat.officeCodeErrorChecker.contains(officeCode)) {
					Double leftValue = Double.parseDouble(readFormula(leftFormula, validationResult, submissionFormat));
					Double rightValue = Double.parseDouble(readFormula(rightFormula, validationResult, submissionFormat));
					
					if(!comparation.testCompareDouble(leftValue, rightValue)) {
						validationResult.errors.add(new ValidationError(fields.get(Integer.parseInt(selectField)), ValidationErrorCode.E50_10_FORMULA2, msg));
						SubmissionFormat.officeCodeErrorChecker.add(officeCode);
					}
				}
			}
		} 
		
		// Khusus untuk sandi kantor 000
		if (officeCode.equals("000") && joinOfficeOnly) {	
			if (submissionFormat.getHavePosCode()) {
				String posCode = validationResult.getColumn(2);
				
				if (posCode.equals(selectPosCode)) {
					Double leftValue = Double.parseDouble(readFormula(leftFormula, validationResult, submissionFormat));
					Double rightValue = null;
					
					if (rightFieldCondition == null) {
						rightValue = Double.parseDouble(readFormula(rightFormula, validationResult, submissionFormat));
					} else {
						rightValue = Double.parseDouble(readFormulaCondition(rightFormula, validationResult, submissionFormat));
					}
					
					if(!comparation.testCompareDouble(leftValue, rightValue)) {
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
							
						} catch (NullPointerException e) {
							
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
	
	private String readFormulaCondition(String formula, ValidationResult validationResult, SubmissionFormat submissionFormat) {
		String officeCode = submissionFormat.getHaveOfficeCode() ? validationResult.getColumn(1) : "000";		
		String formulaValue = "";
		String[] formulaSplit = formula.split("(?<=[-+*/()@])|(?=[-+*/()])");
		String[] rightFieldValueSplit = rightFieldValue.split("[|]");
		List<String> rightFieldValueArray = new ArrayList<String>();
		Map<Integer, String> mapFormulaSplit = new HashMap<Integer, String>();
		
		for (int i = 0; i < formulaSplit.length; i++) {
			mapFormulaSplit.put(i, formulaSplit[i]);
		}
		
		for (String val : rightFieldValueSplit) {
			rightFieldValueArray.add(val);
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
							if(rightFieldValueArray.contains(entryVal.getValue().get(Integer.parseInt(rightFieldCondition)))) {
								sumVal += Double.parseDouble(entryVal.getValue().get(Integer.parseInt(columnPosition)));
							}
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