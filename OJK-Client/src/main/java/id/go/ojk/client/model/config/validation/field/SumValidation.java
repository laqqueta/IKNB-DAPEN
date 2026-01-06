package id.go.ojk.client.model.config.validation.field;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("SumValidation")
public class SumValidation extends BaseFieldFormulaValidation {
	protected Boolean roundFull;

	public SumValidation(String parameter) {
		super(parameter);
	}
	
	public SumValidation() {
		super();
	}

	@Override
	public BaseFieldFormulaValidation initialized() {
		roundFull = getBooleanParameter("roundFull", false);
		return super.initialized();
	}
	
	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		boolean result = false;
		Logger logger = LoggerFactory.getLogger(SumValidation.class);
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
		String fieldNumber = String.valueOf(field.getNumber());
		BigDecimal leftValue = arithmeticOperation(fieldNumber, validationResult.rowSplited);
		BigDecimal rightValue = arithmeticOperation(comparatorFormula, validationResult.rowSplited);
		String compareValue = leftValue + operatorFormula + rightValue;
		String msg = "Kolom " + (Integer.valueOf(fieldNumber) + 1) + " " + operatorFormula.replace("==", "=") + " " + getComparatorMsg();

		if (leftValue != null && rightValue != null) {
			try {
				result = (boolean) engine.eval(compareValue);
				if (!result) {
					logger.error("fieldNumber=" + fieldNumber + ";comparatorFormula=" + comparatorFormula + ";compare=" + compareValue);
					validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E50_02_FORMULA, 
							compareValue, msg));
				}
			} catch (ScriptException e) {
				logger.error(compareValue, e);
			}
		} else {
			if (leftValue == null) {
				validationResult.errors.add(new ValidationError(field,
						ValidationErrorCode.E50_05_VALUE_NOT_FOUND, compareValue, fieldNumber));
			} else {
				validationResult.errors.add(new ValidationError(field,
						ValidationErrorCode.E50_05_VALUE_NOT_FOUND, compareValue, compareValue));
			}
		}
	}

	@Override
	protected BigDecimal arithmeticOperation(String formula, String[] fields) {
		Logger logger = LoggerFactory.getLogger(SumValidation.class);
		BigDecimal res = super.arithmeticOperation(formula, fields);
		if (res != null) {
			res = res.setScale(roundFull ? 0 : 2, RoundingMode.HALF_UP);
		}
		logger.debug("formula=" + formula + ";result=" + res);
		return res;
	}
	
	private String getComparatorMsg() {
		String res = " kolom ";
		String[] formulaSplit = comparatorFormula.split("(?<=[-+/*])|(?=[-+/*])");
		for (int i = 0; i < formulaSplit.length; i++) {
			String str = String.valueOf(formulaSplit[i]);
			String tmp = "";
			if (StringUtils.isNumeric(str)) {
				tmp = String.valueOf(Integer.parseInt(str) + 1);
			} else {
				tmp = " " + str + " kolom ";
			}
			res += tmp;
		}
		return res;
	}
}
