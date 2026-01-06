package id.go.ojk.client.model.config.validation.field;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.util.ToStringList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("FormulaPosValidationPercent")
public class FormulaPosValidationMultiplyConst extends FormulaValidation {
	private String refPosCode;
	private String constValue;

	public FormulaPosValidationMultiplyConst(String parameter) {
		super(parameter);
	}

	public FormulaPosValidationMultiplyConst() {
		super();
	}

	@Override
	public FormulaPosValidationMultiplyConst initialized() {
		super.initialized();
		refPosCode = getStringParameter("refPosCode");
		constValue = getStringParameter("constValue");
		return this;
	}

	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		if (ToStringList.convert(refPosCode, "|").contains(validationResult.getColumn((1)))) {
			boolean result = false;
			Logger logger = LoggerFactory.getLogger(FormulaValidation.class);
			String fieldNumber = String.valueOf(field.getNumber());
			String fieldValue = validationResult.getColumn(field.getNumber());
			BigDecimal comparatorValue = arithmeticOperation(comparatorFormula, validationResult.rowSplited);
			comparatorValue = comparatorValue.multiply(new BigDecimal(constValue)).setScale(scale, RoundingMode.HALF_UP);
			result = compareValue(fieldValue, comparatorValue);
			if (!result) {
				String compareValue = fieldValue + operatorFormula + comparatorValue;
				String msg = "Kolom " + (Integer.valueOf(fieldNumber) + 1) + " " + operatorFormula.replace("==", "=")
						+ " " + constValue + " x " + getComparatorMsg();
				logger.error("{" + parameter + "}>" + fieldValue + "?" + comparatorValue);
				validationResult.errors
				.add(new ValidationError(field, ValidationErrorCode.E50_02_FORMULA, compareValue, msg));
			} else {
				logger.trace("{" + parameter + "}>" + fieldValue + "?" + comparatorValue);
			}
		}
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
