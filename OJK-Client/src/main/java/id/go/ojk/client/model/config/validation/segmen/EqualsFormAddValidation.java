package id.go.ojk.client.model.config.validation.segmen;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.UtilValidation;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import lombok.extern.slf4j.Slf4j;

@XStreamAlias("EqualFormAddValidation")
@Slf4j
public class EqualsFormAddValidation extends BaseDecimalValidation {
	protected String comparatorField;
	private String comparatorRowCode;
	private String message;

	public EqualsFormAddValidation() {
		super();
	}

	public EqualsFormAddValidation(String parameter) {
		super(parameter);
	}

	@Override
	public EqualsFormAddValidation initialized() {
		super.initialized();
		comparatorRowCode = getStringParameter("comparatorRowCode");
		comparatorField = getStringParameter("comparatorField");
		message = getStringParameter("message");
		return this;
	}
	
	private BigDecimal getComparatorValue() {
		String[] arrComparatorField = StringUtils.split(comparatorField, '|');
		String[] arrComparatorRowCode = StringUtils.split(comparatorRowCode, '|');
		BigDecimal res = BigDecimal.ZERO;
		for (int i = 0; i < arrComparatorRowCode.length; i++) {
			String field = arrComparatorField[i];
			String rowCode = arrComparatorRowCode[i];
			res = res.add(SubmissionFormat.getSumMapPosFormValue(rowCode, field).setScale(scale, RoundingMode.HALF_UP));
		}
		return res;
	}

	private BigDecimal getCurrentValue(ValidationResult validationResult) {
		return UtilValidation.toBigDecimal(validationResult.getColumn(Integer.parseInt(selectField)), "0");
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		String currentRowCode = validationResult.getColumn(1);
		if (currentRowCode.equals(selectPosCode)) {
			BigDecimal comparatorValue = getComparatorValue();
			BigDecimal currentValue = getCurrentValue(validationResult);
			if (currentValue.compareTo(comparatorValue) != 0) {
				log.error("{}>{}?{}", parameter, currentValue, comparatorValue);
				List<SubmissionField> fields = submissionFormat.getFields();
				SubmissionField submissionField = fields.get(Integer.parseInt(selectField));
				validationResult.errors.add(new ValidationError(submissionField,
						ValidationErrorCode.E50_02_FORMULA, String.valueOf(comparatorValue), 
						StringUtils.replace(message, "|", "=")));
			}
		}
	}
}