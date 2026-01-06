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

@XStreamAlias("SumMultiplyValidation3")
public class SumMultiplyValidation3 extends BaseDecimalValidation {
	private String posCode;
	private String fixedValue;
	private String posCode2;
	private String fixedValue2;
	private String posCode3;
	private String fixedValue3;
	private String errorMessage;
	
	public SumMultiplyValidation3() {
		super();
	}

	public SumMultiplyValidation3(String parameter) {
		super(parameter);
	}

	@Override
	public SumMultiplyValidation3 initialized() {
		super.initialized();
		posCode = getStringParameter("posCode");
		fixedValue = getStringParameter("fixedValue");
		posCode2 = getStringParameter("posCode2");
		fixedValue2 = getStringParameter("fixedValue2");
		posCode3 = getStringParameter("posCode3");
		fixedValue3 = getStringParameter("fixedValue3");
		errorMessage = getStringParameter("errorMessage");
		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		Logger logger = LoggerFactory.getLogger(SumMultiplyValidation3.class);
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
			BigDecimal expectedValue = getSumValue(field);
			if (realValue.compareTo(expectedValue) != 0) {
				logger.error("pos=" + selectPosCode + ";col=" + field + ";realValue=" + realValue + ";expectedValue=" + expectedValue);
				validationResult.errors.add(new ValidationError(submissionField, ValidationErrorCode.E11_07_EQUAL,
						errorMessage.replace("|", " = ")));
			}
		}
	}
	
	private BigDecimal getSumValue(String field) {
		BigDecimal value1 = getMultiplyValue(field, posCode, fixedValue);
		BigDecimal value2 = getMultiplyValue(field, posCode2, fixedValue2);
		BigDecimal value3 = getMultiplyValue(field, posCode3, fixedValue3);
		return value1.add(value2).add(value3).setScale(scale, RoundingMode.HALF_UP);
	}

	private BigDecimal getMultiplyValue(String field, String posCode, String fixedValue) {
		BigDecimal res = BigDecimal.ONE;
		String[] arrPosCode = StringUtils.split(posCode, "|");
		if (arrPosCode != null) {
			for (int i = 0; i < arrPosCode.length; i++) {
				res = res.multiply(SubmissionFormat.getSumMapPosValue(arrPosCode[i], field));
			}
		}
		String[] arrFixedValue = StringUtils.split(fixedValue, "|");
		if (arrFixedValue != null) {
			for (int i = 0; i < arrFixedValue.length; i++) {
				res = res.multiply(toBigDecimal(arrFixedValue[i], 0));
			}
		}
		return res;
	}
}