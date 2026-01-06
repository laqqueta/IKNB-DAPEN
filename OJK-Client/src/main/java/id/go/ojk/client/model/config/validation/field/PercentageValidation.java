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
import id.go.ojk.client.model.config.validation.UtilValidation;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("PercentageValidation")
public class PercentageValidation extends BaseFieldFormulaValidation {
	protected int scale;

	public PercentageValidation(String parameter) {
		super(parameter);
	}
	
	public PercentageValidation() {
		super();
	}

	@Override
	public BaseFieldFormulaValidation initialized() {
		scale = getIntParameter("scale", 2);
		return super.initialized();
	}
	
	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		boolean result = false;
		Logger logger = LoggerFactory.getLogger(PercentageValidation.class);
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
		String fieldNumber = String.valueOf(field.getNumber());
		BigDecimal leftValue = arithmeticOperation(fieldNumber, validationResult.rowSplited);
		BigDecimal rightValue = calculatePercentage(validationResult.rowSplited);
		String compareValue = leftValue + operatorFormula + rightValue;

		if (leftValue != null && rightValue != null) {
			try {
				result = (boolean) engine.eval(compareValue);
				if (!result) {
					String msg = "kolom " + (field.getNumber() + 1) + " " + operatorFormula.replace("==", "=") + getComparatorMsg();
					logger.error("parameter=" + parameter + ";compare=" + compareValue);
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
		Logger logger = LoggerFactory.getLogger(PercentageValidation.class);
		BigDecimal res = super.arithmeticOperation(formula, fields);
		logger.debug("formula=" + formula + ";result=" + res);
		return res;
	}
	
	protected BigDecimal calculatePercentage(String[] fields) {
		Logger logger = LoggerFactory.getLogger(PercentageValidation.class);
		BigDecimal res = null;
		try {
			String[] ratioFormulas = StringUtils.split(comparatorFormula, "|");
			String formula1 = UtilValidation.getArray(ratioFormulas, 0, "");
			String formula2 = UtilValidation.getArray(ratioFormulas, 1, "");
			BigDecimal value1 = arithmeticOperation(formula1, fields);
			BigDecimal value2 = arithmeticOperation(formula2, fields);
			res = value1.multiply(value2);
			res = res.divide(new BigDecimal(100), scale, RoundingMode.HALF_UP);
		} catch (Exception e) {
			logger.error("formula=" + comparatorFormula,  e);
			res = null;
		}
		return res;
	}
	
	private String getComparatorMsg() {
		String res = "";
		String[] comparatorFields = StringUtils.split(comparatorFormula, "|");
		if (comparatorFields != null) {
			int len = comparatorFields.length;
			for (int i = 0; i < comparatorFields.length; i++) {
				res += getInnerMsg(comparatorFields[i]);
				if (i + 1 < len) {
					res += " x ";
				}
			}
		}
		return res;
	}
	
	private String getInnerMsg(String formula) {
		String res = "";
		String[] arr = formula.split("(?<=[-+/*])|(?=[-+/*])");
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			String str = arr[i];
			if (StringUtils.isNumeric(str)) {
				res = res + " kolom " + (Integer.valueOf(str) + 1);
			} else if (i + 1 < len) {
				res = res + " " + str + " ";
			}
		}
		return StringUtils.countMatches(res, "kolom") > 1 ? (" (" + res.trim() + ")") : res;
	}
}
