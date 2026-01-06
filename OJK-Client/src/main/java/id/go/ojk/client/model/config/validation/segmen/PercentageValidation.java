package id.go.ojk.client.model.config.validation.segmen;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.validation.UtilValidation;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("ratioValidation")
public class PercentageValidation extends BaseFormulaValidation {

	public PercentageValidation() {
		super();
	}
	
	public PercentageValidation(String parameter) {
		super(parameter);
	}

	@Override
	protected void compareFormula(ValidationResult validationResult, List<SubmissionField> submissionField,
			String field, int seq, String leftFormula, String operator, String rightFormula) {
		Logger logger = LoggerFactory.getLogger(PercentageValidation.class);
		boolean result;
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		String[] MsgError = StringUtils.split(msgError, "|");
		BigDecimal leftValue = arithmeticOperation(leftFormula, seq);
		BigDecimal rightValue = calculatePercentage(rightFormula, seq);
		String msg = UtilValidation.getArray(MsgError, 0, "") + " " + operator + " " + UtilValidation.getArray(MsgError, 1, "");
		String compareValue = leftValue + operator + rightValue;

		if (leftValue != null && rightValue != null) {
			try {
				result = (boolean) engine.eval(compareValue);
				if (!result) {
					logger.error("leftFormula=" + leftFormula + ";rightFormula=" + rightFormula + ";compare=" + compareValue);
					validationResult.errors.add(new ValidationError(submissionField.get(Integer.parseInt(field)),
							ValidationErrorCode.E50_02_FORMULA, compareValue, msg));
				}
			} catch (ScriptException e) {
				logger.error(compareValue, e);
			}
		} else {
			if (leftValue == null) {
				validationResult.errors.add(new ValidationError(submissionField.get(Integer.parseInt(field)),
						ValidationErrorCode.E50_05_VALUE_NOT_FOUND, compareValue, MsgError[0]));
			} else {
				validationResult.errors.add(new ValidationError(submissionField.get(Integer.parseInt(field)),
						ValidationErrorCode.E50_05_VALUE_NOT_FOUND, compareValue, MsgError[1]));
			}
		}
	}

	@Override
	protected BigDecimal arithmeticOperation(String formula, int seq) {
		Logger logger = LoggerFactory.getLogger(PercentageValidation.class);
		BigDecimal res = super.arithmeticOperation(formula, seq);
		logger.debug("formula=" + formula + ";seq=" + seq + ";result=" + (res != null ? res : "null"));
		return res;
	}
	
	protected BigDecimal calculatePercentage(String formula, int seq) {
		Logger logger = LoggerFactory.getLogger(PercentageValidation.class);
		BigDecimal res = null;
		try {
			String[] ratioFormulas = StringUtils.split(formula, "|");
			String formula1 = UtilValidation.getArray(ratioFormulas, 0, "");
			String formula2 = UtilValidation.getArray(ratioFormulas, 1, "");
			BigDecimal value1 = arithmeticOperation(formula1, seq);
			BigDecimal value2 = arithmeticOperation(formula2, seq);
			res = value1.multiply(value2);
			res = res.divide(new BigDecimal(100), 0, RoundingMode.HALF_UP);
		} catch (Exception e) {
			logger.error("formula=" + formula,  e);
			res = null;
		}
		return res;
	}
}