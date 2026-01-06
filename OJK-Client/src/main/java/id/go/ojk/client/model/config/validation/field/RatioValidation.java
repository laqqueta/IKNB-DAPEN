package id.go.ojk.client.model.config.validation.field;

import java.math.BigDecimal;
import java.math.RoundingMode;

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

@XStreamAlias("RatioValidation")
public class RatioValidation extends BaseFieldFormulaValidation {
	protected int scale;

	public RatioValidation(String parameter) {
		super(parameter);
	}

	public RatioValidation() {
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
		Logger logger = LoggerFactory.getLogger(RatioValidation.class);
		String fieldValue = validationResult.getColumn(field.getNumber());
		BigDecimal comparatorValue = calculateRatio(validationResult.rowSplited);

		result = compareValue(fieldValue, comparatorValue);
		if (!result) {
			String compareValue = fieldValue + operatorFormula + comparatorValue;
			String msg = "kolom " + (field.getNumber() + 1) + " " + operatorFormula.replace("==", "=") + getComparatorMsg();
			logger.error("{" + parameter + "}>" + fieldValue + "?" + comparatorValue);
			validationResult.errors
					.add(new ValidationError(field, ValidationErrorCode.E50_02_FORMULA, compareValue, msg));
		}
	}

	@Override
	protected BigDecimal arithmeticOperation(String formula, String[] fields) {
		BigDecimal res = super.arithmeticOperation(formula, fields);
		if (res != null) {
			res = res.setScale(scale, RoundingMode.HALF_UP);
		}
		return res;
	}

	protected BigDecimal calculateRatio(String[] fields) {
		Logger logger = LoggerFactory.getLogger(RatioValidation.class);
		BigDecimal res = BigDecimal.ZERO;
		try {
			String[] ratioFormulas = StringUtils.split(comparatorFormula, "|");
			String formula1 = UtilValidation.getArray(ratioFormulas, 0, "");
			String formula2 = UtilValidation.getArray(ratioFormulas, 1, "");
			BigDecimal value1 = arithmeticOperation(formula1, fields);
			BigDecimal value2 = arithmeticOperation(formula2, fields);
			if (value2 != null && value2.compareTo(BigDecimal.ZERO) != 0) {
				res = value1.divide(value2, 4, RoundingMode.HALF_UP);
			} else {
				res = BigDecimal.ZERO;
			}
			if (res != null) {
				res = res.multiply(new BigDecimal(100));
				res = res.setScale(scale, RoundingMode.HALF_UP);
			}
		} catch (Exception e) {
			logger.error("formula=" + comparatorFormula, e);
			res = BigDecimal.ZERO;
		}
		return res;
	}

	private String getComparatorMsg() {
		String res = " kolom ";
		String[] formulaSplit = comparatorFormula.split("(?<=[-+/*|])|(?=[-+/*|])");
		for (int i = 0; i < formulaSplit.length; i++) {
			String str = String.valueOf(formulaSplit[i]);
			String tmp = "";
			if (StringUtils.isNumeric(str)) {
				tmp = String.valueOf(Integer.valueOf(str) + 1);
			} else {
				tmp = " : kolom ";
			}
			res += tmp;
		}
		return res;
	}
}
