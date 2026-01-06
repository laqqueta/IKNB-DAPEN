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

@XStreamAlias("sumValidation")
public class SumValidation extends BaseFormulaValidation {

	public SumValidation() {
		super();
	}

	@Override
	public BaseFormulaValidation initialized() {
		return super.initialized();
	}
	
	public SumValidation(String parameter) {
		super(parameter);
	}

	@Override
	protected void compareFormula(ValidationResult validationResult, List<SubmissionField> submissionField,
			String field, int seq, String leftFormula, String operator, String rightFormula) {
		Logger logger = LoggerFactory.getLogger(SumValidation.class);
		boolean result;
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		BigDecimal leftValue = calculateLeftValue(leftFormula, seq);
		BigDecimal rightValue = calculateRightValue(rightFormula, seq);
		String[] arrMsgError = StringUtils.split(msgError, "|");
		String msg = UtilValidation.getArray(arrMsgError, 0, "") + " " + operator.replace("==", "=") + " " + UtilValidation.getArray(arrMsgError, 1, "");
		String compareValue = genCompareScript(leftValue, rightValue, operator);

		if (leftValue != null && rightValue != null) {
			try {
				result = (boolean) engine.eval(compareValue);
				if (!result) {
					logger.error("{" + parameter + "}>" + leftValue + "?" + rightValue);
					validationResult.errors.add(new ValidationError(submissionField.get(Integer.parseInt(field)),
							ValidationErrorCode.E50_02_FORMULA, compareValue, msg));
				}
			} catch (ScriptException e) {
				logger.error(compareValue, e);
			}
		} else {
			if (leftValue == null) {
				validationResult.errors.add(new ValidationError(submissionField.get(Integer.parseInt(field)),
						ValidationErrorCode.E50_05_VALUE_NOT_FOUND, compareValue, arrMsgError[0]));
			} else {
				validationResult.errors.add(new ValidationError(submissionField.get(Integer.parseInt(field)),
						ValidationErrorCode.E50_05_VALUE_NOT_FOUND, compareValue, arrMsgError[1]));
			}
		}
	}
	
	protected BigDecimal calculateLeftValue(String leftFormula, int seq) {
		return arithmeticOperation(leftFormula, seq);
	}
	
	protected BigDecimal calculateRightValue(String rightFormula, int seq) {
		return arithmeticOperation(rightFormula, seq);
	}

	protected String genCompareScript(BigDecimal leftValue, BigDecimal rightValue, String operator) {
		return leftValue + operator + rightValue;
	}
	
	@Override
	protected BigDecimal arithmeticOperation(String formula, int seq) {
		Logger logger = LoggerFactory.getLogger(SumValidation.class);
		BigDecimal res = super.arithmeticOperation(formula, seq);
		if (res != null) {
			res = res.setScale(2, RoundingMode.HALF_UP);
		}
		logger.debug("formula=" + formula + ";seq=" + seq + ";result=" + (res != null ? res : "null"));
		return res;
	}
}