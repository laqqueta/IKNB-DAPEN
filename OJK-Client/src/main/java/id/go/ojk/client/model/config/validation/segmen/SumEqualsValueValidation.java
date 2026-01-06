package id.go.ojk.client.model.config.validation.segmen;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("SumEqualsValueValidation")
public class SumEqualsValueValidation extends BaseRowValidation {
	private String value;
	private int scale;

	public SumEqualsValueValidation() {
		super();
	}

	@Override
	public BaseRowValidation initialized() {
		value = getStringParameter("value");
		scale = getIntParameter("scale");
		return super.initialized();
	}
	
	public SumEqualsValueValidation(String parameter) {
		super(parameter);
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		String[] arrField = StringUtils.split(selectField, "|");
		String[] arrValue = StringUtils.split(value, "|");
		for (int i = 0; i < arrField.length; i++) {
			int column = Integer.parseInt(arrField[i]);
			BigDecimal calculated = calculateSavedValue(column, selectPosCode);
			String expectedValue = arrValue[i];
			BigDecimal comparator = toBigDecimal(expectedValue).setScale(scale, RoundingMode.HALF_UP);
			if (calculated.compareTo(comparator) != 0) {
				validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E50_09_TOTAL_PERCENT,
						column + 1, expectedValue));
			}
		}
	}

	private BigDecimal calculateSavedValue(int fieldNumber, String pos) {
		return SubmissionFormat.getSumMapPosValue(pos, String.valueOf(fieldNumber)).setScale(scale, RoundingMode.HALF_UP);
	}
}