package id.go.ojk.client.model.config.validation.segmen;

import java.util.List;
import java.util.Map.Entry;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("comparePosValidation")
public class CompareAndOrPosValidation extends BaseRowValidation {
	private String leftFormula;
	private String rightFormula;
	private String operator;
	private Boolean joinOfficeOnly;
	private String msgError;

	public CompareAndOrPosValidation() {
		super();
	}

	public CompareAndOrPosValidation(String parameter) {
		super(parameter);
	}

	@Override
	public CompareAndOrPosValidation initialized() {
		super.initialized();
		leftFormula = getStringParameter("leftFormula");
		rightFormula = getStringParameter("rightFormula");
		operator = getStringParameter("operator");
		msgError = getStringParameter("msgError");
		
		joinOfficeOnly = getBooleanParameter("joinOfficeOnly");
		if(joinOfficeOnly == null) {
			joinOfficeOnly = false;
		}
		
		switch (operator) {
		case "OR":
			operator = "||";
			break;
		case "AND":
			operator = "&&";
			break;
		default:
			break;
		}
		
		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
		List<SubmissionField> fields = submissionFormat.getFields();		
		String officeCode = validationResult.getColumn(1);
		String posCode = validationResult.getColumn(2);
		
		if (officeCode.equals("000") && joinOfficeOnly) {
			if (posCode.equals(selectPosCode)) {
				String leftValue = toFormula(leftFormula, officeCode, validationResult, submissionFormat);
				String rightValue = toFormula(rightFormula, officeCode, validationResult, submissionFormat);
				
				if (!converValue(leftValue + operator + rightValue)) {
					validationResult.errors.add(new ValidationError(fields.get(Integer.parseInt(selectField)), ValidationErrorCode.E50_10_FORMULA2, msgError));
				}
			}
		}		
	}
	
	private String toFormula(String formula, String officeCode, ValidationResult validationResult, SubmissionFormat submissionFormat) {
		String formulaString = "";
		String[] formulaSplit = formula.split("[|]");
		
		for (String val : formulaSplit) {
			String valPosSplit[] = val.split("[:]");
			
			if (valPosSplit.length > 1) {
				String posKey = valPosSplit[0];
				String seq = valPosSplit[1];
				String posKeyNoSeq = officeCode + "-" + posKey;
				Double sumVal = 0.00;
				
				for (Entry<String, List<String>> entryVal : SubmissionFormat.mapPosValueLBBPRK.entrySet()){
					if(entryVal.getKey().contains(posKeyNoSeq)){
						try {
							sumVal += Double.parseDouble(entryVal.getValue().get(Integer.parseInt(seq)));
						} catch (NumberFormatException e) {
							e.printStackTrace();
						} catch (NullPointerException e) {
							e.printStackTrace();
						}
					}
				}
				
				formulaString = formulaString.concat(Double.toString(sumVal));				
			} else {
				if(val.matches("-?\\d+")) {
					formulaString = formulaString.concat(val);
				} else {
					formulaString = formulaString.concat(operationCode(val));
				}
			}
		}
		
		return formulaString;
	}
	
	private Boolean converValue(String formula) {
		Boolean result = null;
		
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		
		try {
			result = (Boolean) engine.eval(formula);
		} catch (ScriptException e) {
			result = false;
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	private String operationCode(String operation) {
		String code = "";
		switch (operation) {
		case "e":
			code = "==";
			break;
		case "ne":
			code = "!=";
			break;
		case "lt":
			code = "<";
			break;
		case "lte":
			code = "<=";
			break;
		case "gt":
			code = ">";
			break;
		case "gte":
			code = ">=";
			break;
		default:
			break;
		}
		
		return code;
	}
}