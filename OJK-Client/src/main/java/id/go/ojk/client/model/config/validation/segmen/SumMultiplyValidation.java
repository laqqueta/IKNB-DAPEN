package id.go.ojk.client.model.config.validation.segmen;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.util.ToBigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("SumMultiplyValidation")
public class SumMultiplyValidation extends BaseDecimalValidation {
	private String posCode;
	private String fixedValue;
	private String errorMessage;
	
	public SumMultiplyValidation() {
		super();
	}

	public SumMultiplyValidation(String parameter) {
		super(parameter);
	}

	@Override
	public SumMultiplyValidation initialized() {
		super.initialized();
		posCode = getStringParameter("posCode");
		fixedValue = getStringParameter("fixedValue");
		errorMessage = getStringParameter("errorMessage");
		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		Logger logger = LoggerFactory.getLogger(SumMultiplyValidation.class);
		List<SubmissionField> fields = submissionFormat.getFields();
		String[] arrSelectField = StringUtils.split(selectField, "|");
		String realPosCode = validationResult.getColumn(1);
		if (selectPosCode.equals(realPosCode)) {
			String[] arrPosCode = StringUtils.split(posCode, "|");
			String[] arrFixedValue = StringUtils.split(fixedValue, "|");
			for (String field : arrSelectField) {
				validateValue(logger, field, arrPosCode, arrFixedValue, fields.get(Integer.parseInt(field)),
						validationResult);
			}
		}
	}

	private void validateValue(Logger logger, String field, String[] arrPosCode, String[] arrFixedValue, 
			SubmissionField submissionField, ValidationResult validationResult) {
		BigDecimal realValue = toBigDecimal(validationResult.getColumn(Integer.parseInt(field)));
		BigDecimal expectedValue = getSumValue(field, arrPosCode, arrFixedValue);
		if (realValue.compareTo(expectedValue) != 0) {
			logger.error("parameter=" + parameter + ";realValue=" + realValue + ";expectedValue=" + expectedValue);
			validationResult.errors.add(new ValidationError(submissionField, ValidationErrorCode.E11_07_EQUAL,
					errorMessage));
		}
	}
	
	private BigDecimal getSumValue(String field, String[] arrPosCode, String[] arrFixedValue) {
		BigDecimal res = BigDecimal.ZERO;
		if (arrPosCode != null && arrFixedValue != null && arrPosCode.length <= arrFixedValue.length) {
			for (int i = 0; i < arrPosCode.length; i++) {
				res = res.add(getMultiplyValue(field, arrPosCode[i], arrFixedValue[i]));
			}
		}
		return res.setScale(scale, RoundingMode.HALF_UP);
	}

	private BigDecimal getMultiplyValue(String field, String posCode, String fixedValue) {
		BigDecimal calculatedValue = SubmissionFormat.getSumMapPosValue(posCode, field);
		return ToBigDecimal.convert(fixedValue, 1).multiply(calculatedValue);
	}
}