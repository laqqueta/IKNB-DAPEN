package id.go.ojk.client.model.config.validation.field;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("FormulaValidation")
public class FormulaValidation extends BaseFieldFormulaValidation {
	protected int scale;

	public FormulaValidation(String parameter) {
		super(parameter);
	}

	public FormulaValidation() {
		super();
	}

	@Override
	public FormulaValidation initialized() {
		super.initialized();
		scale = getIntParameter("scale", 0);
		return this;
	}

	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		boolean result = false;
		Logger logger = LoggerFactory.getLogger(FormulaValidation.class);
		String fieldNumber = String.valueOf(field.getNumber());
		String fieldValue = validationResult.getColumn(field.getNumber());
		BigDecimal comparatorValue = arithmeticOperation(comparatorFormula, validationResult.rowSplited);
		result = compareValue(fieldValue, comparatorValue);
		if (!result) {
			String compareValue = fieldValue + operatorFormula + comparatorValue;
			String msg = "Kolom " + (Integer.valueOf(fieldNumber) + 1) + " " + operatorFormula.replace("==", "=")
					+ " " + getComparatorMsg();
			logger.error("{" + parameter + "}>" + fieldValue + "?" + comparatorValue);
			validationResult.errors
					.add(new ValidationError(field, ValidationErrorCode.E50_02_FORMULA, compareValue, msg));
		} else {
			logger.trace("{" + parameter + "}>" + fieldValue + "?" + comparatorValue);
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

	private String getComparatorMsg() {
		String res = "";
		String[] formulaSplit = comparatorFormula.split("(?<=[-+/*])|(?=[-+/*])");
		int len = formulaSplit.length;
		for (int i = 0; i < len; i++) {
			String str = String.valueOf(formulaSplit[i]);
			String tmp = "";
			if (StringUtils.isNumeric(str)) {
				tmp = " kolom " + String.valueOf(Integer.parseInt(str) + 1);
			} else if (i + 1 < len) {
				tmp = " " + str;
			}
			res += tmp;
		}
		return res;
	}
}
