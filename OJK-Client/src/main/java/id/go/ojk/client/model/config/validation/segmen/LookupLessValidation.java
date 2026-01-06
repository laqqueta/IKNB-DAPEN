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

@XStreamAlias("LessLookupValidation")
public class LookupLessValidation extends LookupValidation {
	private int scale = 2;

	public LookupLessValidation() {
		super();
	}

	public LookupLessValidation(String parameter) {
		super(parameter);
	}

	@XStreamOmitField
	private ReferenceService referenceService = null;

	@Override
	public LookupLessValidation initialized() {
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
			if (comparatorValue.compareTo(key) < 0) {
				return arrLookupValue[i];
			}
		}
		return defaultValue;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		List<SubmissionField> fields = submissionFormat.getFields();
		if (!validateSelectPosCode(validationResult.getColumn(1))) {
			return;
		}
		String[] arrSelectField = StringUtils.split(selectField, "|");
		for (String field : arrSelectField) {
			String fieldValueString = validationResult.getColumn(Integer.parseInt(field));
			String comparator = getComparatorValue();
			if (!fieldValueString.equals(comparator)) {
				SubmissionField submissionField = fields.get(Integer.parseInt(field));
				validationResult.errors.add(
						new ValidationError(submissionField, ValidationErrorCode.E11_07_EQUAL, comparator));
			}
		}
	}
}