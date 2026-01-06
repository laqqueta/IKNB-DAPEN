package id.go.ojk.client.model.config.validation.field;

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

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.constant.Comparation;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("columnConditionValidation")
public class ColumnConditionValidation extends MapParamFieldValidation {
	private static Logger logger = LoggerFactory.getLogger(ColumnConditionValidation.class);
	private Integer fieldCondition;
	private String trueConditionValue;
	private String compareFieldFormula;
	private String operator;
	private String msgFormula;
	private String trueValue;
	private Boolean absolute;
	private Boolean roundFull;
	private Boolean lengthCheck;
	private String subTrueValue;
	private Integer lengthTrueValue;
	private Comparation comparation;
	private String formCode;

    private boolean isTpp;
	
	public ColumnConditionValidation() {

	}

	public ColumnConditionValidation(String parameter) {
		setParameter(parameter);
	}

	@Override
	public ColumnConditionValidation initialized() {
		fieldCondition = getIntParameter("fieldCondition");
		trueConditionValue = getStringParameter("trueConditionValue");
		msgFormula = getStringParameter("msgFormula");
		compareFieldFormula = getStringParameter("compareFieldFormula");
		operator = getStringParameter("operator");
		trueValue = getStringParameter("trueValue");
		formCode = getStringParameter("formCode");
		subTrueValue = getStringParameter("subTrueValue");
		lengthTrueValue = getIntParameter("lengthTrueValue");
		
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
		
		absolute = getBooleanParameter("absolute");
		if(absolute == null) {
			absolute = false;
		}
		
		roundFull = getBooleanParameter("roundFull");
		if(roundFull == null) {
			roundFull = false;
		}
		
		lengthCheck = getBooleanParameter("lengthCheck");
		if(lengthCheck == null) {
			lengthCheck = false;
		}
		
		return this;
	};

	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
        isTpp = submissionFormat.getReportCode().startsWith("TPP");
		String columCondition = "null"; 
		String[] trueConditionValueSplit = trueConditionValue.split("[|]");
		List<String> trueConditionValueArray = new ArrayList<String>();
		String trueConditionMsg = "";
		
		for (int i = 0; i < trueConditionValueSplit.length; i++) {
			trueConditionValueArray.add(trueConditionValueSplit[i]);
			if (i == 0) {
				trueConditionMsg = trueConditionValueSplit[i];
			} else {
				trueConditionMsg = trueConditionMsg + " / " + trueConditionValueSplit[i];
			}
		}
		
		if (formCode == null){ //columCondition jika tanpa formCode
			columCondition = isTpp ? validationResult.getRawColumn(fieldCondition)
                    : validationResult.getColumn(fieldCondition);
		}
		else{ //columCondition jika ada formCode
			for (Entry<String, List<String>> entryVal : SubmissionFormat.mapPosValueLBBPRK.entrySet()){
				if(entryVal.getKey().contains("-"+formCode+"-")){
					columCondition = entryVal.getValue().get(fieldCondition);
					break;
				}
			}
		}
		
		if (lengthCheck) {
			columCondition = Integer.toString(columCondition.length());
		}
		
		if (trueConditionValueArray.contains(columCondition)) {
			
			String selectValue = isTpp ? validationResult.getRawColumn(fieldCondition)
                    : validationResult.getColumn(field.getNumber());
			String compareValue = "";
			
			if (compareFieldFormula == null && trueValue == null) {
				compareValue = "0";
			} 
			if (compareFieldFormula != null) {
				compareValue = readFormula(compareFieldFormula, validationResult);
			}
			
			if (trueValue != null) {
				compareMultiValue(submissionFormat, field, validationResult, selectValue, trueValue, trueConditionMsg);
			} else {
				compareResult(submissionFormat, field, validationResult, selectValue, compareValue, trueConditionMsg);				
			}
		}
	}
	
	private void compareMultiValue(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult, String selectValue, String trueValue, String trueConditionMsg) {
		String[] trueValueSplit = trueValue.split("[|]");
		List<String> trueValueArray = new ArrayList<String>();
		
		for (String val : trueValueSplit) {
			trueValueArray.add(val);
		}
		
		Double leftValue = 0.00;
		Double rightValue = 0.00;
		
		try {
			leftValue = Double.parseDouble(selectValue);
			rightValue = trueValueSplit.length == 1 ? Double.parseDouble(trueValue) : 0.00;
			
			if (lengthCheck) {
				compareResult(submissionFormat, field, validationResult, selectValue, trueValue, trueConditionMsg);
			} else {
				if (operator.equals("e")) {
					if (!trueValueArray.contains(selectValue)) {
						msgError(submissionFormat, field, validationResult, trueConditionMsg);
					}
				} else if (operator.equals("gt") || operator.equals("gte") || operator.equals("lt") || operator.equals("lte")) { 
					if (!comparation.testCompareDouble(leftValue, rightValue)) {
						msgError(submissionFormat, field, validationResult, trueConditionMsg);
					}
				} else {
					if (trueValueArray.contains(selectValue)) {
						msgError(submissionFormat, field, validationResult, trueConditionMsg);
					}
				}
			}		
		} catch (NumberFormatException e) {
			
		}	
		
	}
	
	private void compareResult(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult, String selectValue, String compareValue, String trueConditionMsg) {
		if (lengthTrueValue == null){
			try {
				Double leftValue = Double.parseDouble(selectValue);
				Double rightValue = absolute ? Math.abs(Double.parseDouble(compareValue)) : Double.parseDouble(compareValue);
				
				if (!comparation.testCompareDouble(leftValue, rightValue)) {
					if (lengthCheck) {
						String msg = trueConditionValue + " Karakter";
						validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E50_15_COLUMNCONDITION, msgFormula, submissionFormat.getFields().get(fieldCondition).getName(), msg));
					} else {
						validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E50_15_COLUMNCONDITION, msgFormula, submissionFormat.getFields().get(fieldCondition).getName(), trueConditionMsg));
					}
				}
			} catch (NumberFormatException e) {
				
			}
		}
		else{ //Validasi berdasarkan panjang karakter dan subString dari sandi referensi ex: sandi bank berawalan 60.... 
			if (!comparation.testCompareDouble(lengthTrueValue, selectValue.length())){
				String msg = lengthTrueValue + " karakter";
				validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E11_03_FIX_LENGTH, msg));
			}
			
			if (subTrueValue != null){
				String subSelectValue = selectValue;
				try {
					subSelectValue = selectValue.substring(0, 2);
				} catch (StringIndexOutOfBoundsException e) {
					
				}
				 
				if (!comparation.testCompareString(subTrueValue, subSelectValue)){
					validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E50_15_COLUMNCONDITION, msgFormula, submissionFormat.getFields().get(fieldCondition).getName(), trueConditionMsg));
				}
			}
		}
	}
	
	private String readFormula(String formula, ValidationResult validationResult) {
		String formulaValue = "";		
		String[] formulaSplit = formula.split("(?<=[-+*/()@])|(?=[-+*/()])");
		Map<Integer, String> mapFormulaSplit = new HashMap<Integer, String>();
		
		for (int i = 0; i < formulaSplit.length; i++) {
			mapFormulaSplit.put(i, formulaSplit[i]);
		}
		
		for (Entry<Integer, String> entry : mapFormulaSplit.entrySet()){
			if(entry.getValue().matches("-?\\d+")) {
				Double val = 0.00;
				try {
                    String colVal =  isTpp ? validationResult.getRawColumn(fieldCondition) :
                            validationResult.getColumn(Integer.parseInt(entry.getValue()));

					val = Double.parseDouble(colVal);
				} catch (Exception e) {
					
				}
				
				entry.setValue(Double.toString(val));
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
	
	private void msgError(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult, String trueConditionMsg){
		if(fieldCondition == 0){ // pesan error untuk validasi jika tidak bergantung pada kolom lain (hanya melalui pengecekan field flag detail)
			validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E50_16_COLUMNCONDITION2, msgFormula));
		}
		else{
			validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E50_15_COLUMNCONDITION, msgFormula, submissionFormat.getFields().get(fieldCondition).getName(), trueConditionMsg));
		}
	}
}
