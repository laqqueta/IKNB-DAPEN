package id.go.ojk.client.model.config.validation.segmen;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.UtilValidation;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("LookupGearingRatioValidation")
public class LookupGearingRatioValidation extends LookupValidation {
	private int scale = 2;

	public LookupGearingRatioValidation() {
		super();
	}

	public LookupGearingRatioValidation(String parameter) {
		super(parameter);
	}

	@XStreamOmitField
	private ReferenceService referenceService = null;

	@Override
	public LookupGearingRatioValidation initialized() {
		super.initialized();
		scale = getIntParameter("scale");
		return this;
	}

	@Override
	protected String getComparatorValue() {
		BigDecimal comparatorValue = UtilValidation.calculateColumn(SubmissionFormat.mapPosValue, comparatorRowCode,
				comparatorField, scale);
		String[] arrLookupKey = StringUtils.split(lookupKey, "|");
		String[] arrLookupValue = StringUtils.split(lookupValue, "|");
		for (int i = 0; i < arrLookupKey.length; i++) {
			BigDecimal key = UtilValidation.toBigDecimal(arrLookupKey[i]);
			if (i == 1) {
				if (comparatorValue.compareTo(key) >= 0) {
					return arrLookupValue[i];
				}
			} else {
				if (comparatorValue.compareTo(key) < 0) {
					return arrLookupValue[i];
				}
			}
		}
		return defaultValue;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		if (!validateSelectPosCode(validationResult.getColumn(1))) {
			return;
		}
		List<SubmissionField> fields = submissionFormat.getFields();
		String[] arrSelectField = StringUtils.split(selectField, "|");
		for (String field : arrSelectField) {
			String currentValue = validationResult.getColumn(Integer.parseInt(field));
			String comparatorValue = getComparatorValue();
			if (!currentValue.equals(comparatorValue)) {
				SubmissionField submissionField = fields.get(Integer.parseInt(field));
				validationResult.errors.add(
						new ValidationError(submissionField, ValidationErrorCode.E11_07_EQUAL, comparatorValue));
			}
		}
	}
}