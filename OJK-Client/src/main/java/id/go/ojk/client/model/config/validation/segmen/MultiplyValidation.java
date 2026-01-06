package id.go.ojk.client.model.config.validation.segmen;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("multiplyValidation")
public class MultiplyValidation extends BaseDecimalValidation {
	private String posCode;
	private String fixedValue;
	private String errorMessage;
	
	public MultiplyValidation() {
		super();
	}

	public MultiplyValidation(String parameter) {
		super(parameter);
	}

	@Override
	public MultiplyValidation initialized() {
		super.initialized();
		posCode = getStringParameter("posCode");
		fixedValue = getStringParameter("fixedValue");
		errorMessage = getStringParameter("errorMessage");
		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		Logger logger = LoggerFactory.getLogger(MultiplyValidation.class);
		List<SubmissionField> fields = submissionFormat.getFields();
		String[] arrSelectField = StringUtils.split(selectField, "|");
		String[] arrSelectPosCode = StringUtils.split(selectPosCode, "|");
		String posCode = validationResult.getColumn(1);

		for (String field : arrSelectField) {
			String fieldValueString = validationResult.getColumn(Integer.parseInt(field));
			for (int i = 0; i < arrSelectPosCode.length; i++) {
				validateValue(logger, field, arrSelectPosCode[i], posCode, fieldValueString, fields.get(Integer.parseInt(field)),
						validationResult);
			}
		}
	}

	private void validateValue(Logger logger, String field, String selectPosCode, String posCode, 
			String fieldValueString, SubmissionField submissionField, ValidationResult validationResult) {
		if (posCode.equals(selectPosCode)) {
			BigDecimal realValue = toBigDecimal(fieldValueString);
			BigDecimal expectedValue = getComparatorValue(field);
			if (realValue.compareTo(expectedValue) != 0) {
				logger.error("parameter=" + parameter + ";realValue=" + realValue + ";expectedValue=" + expectedValue);
				validationResult.errors.add(new ValidationError(submissionField, ValidationErrorCode.E11_07_EQUAL,
						replaceMacro(errorMessage)));
			}
		}
	}

	private BigDecimal getComparatorValue(String field) {
		BigDecimal res = BigDecimal.ONE;
		String[] arrPosCode = StringUtils.split(posCode, "|");
		if (arrPosCode != null) {
			for (int i = 0; i < arrPosCode.length; i++) {
				res = res.multiply(arithmeticOperation(arrPosCode[i], Integer.valueOf(field)));
			}
		}
		if (StringUtils.isNotEmpty(fixedValue)) {
			String[] arrFixedValue = StringUtils.split(fixedValue, "|");
			if (arrFixedValue != null) {
				for (int i = 0; i < arrFixedValue.length; i++) {
					res = res.multiply(toBigDecimal(arrFixedValue[i], 0));
				}
			}
		}
		return res.setScale(scale, RoundingMode.HALF_UP);
	}
}