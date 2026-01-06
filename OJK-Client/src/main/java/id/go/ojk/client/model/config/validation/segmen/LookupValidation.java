package id.go.ojk.client.model.config.validation.segmen;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("LookupValidation")
public class LookupValidation extends BaseRowValidation {
	protected String comparatorField;
	protected String comparatorRowCode;
	protected String lookupKey;
	protected String lookupValue;
	protected String defaultValue;

	public LookupValidation() {
		super();
	}

	public LookupValidation(String parameter) {
		super(parameter);
	}

	@XStreamOmitField
	private ReferenceService referenceService = null;

	@Override
	public LookupValidation initialized() {
		super.initialized();
		comparatorField = getStringParameter("comparatorField");
		comparatorRowCode = getStringParameter("comparatorRowCode");
		lookupKey = getStringParameter("lookupKey");
		lookupValue = getStringParameter("lookupValue");
		defaultValue = getStringParameter("defaultValue");
		return this;
	}

	protected String getComparatorValue() {
		String comparatorValue = SubmissionFormat.getMapPosValue(comparatorRowCode, comparatorField);
		String[] arrLookupKey = StringUtils.split(lookupKey, "|");
		String[] arrLookupValue = StringUtils.split(lookupValue, "|");
		for (int i = 0; i < arrLookupKey.length; i++) {
			String key = arrLookupKey[i];
			if (comparatorValue.equals(key)) {
				return arrLookupValue[i];
			}
		}
		return defaultValue;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		List<SubmissionField> fields = submissionFormat.getFields();
		String[] arrSelectField = StringUtils.split(selectField, "|");
		String posCode = validationResult.getColumn(1);
		if (selectPosCode.contains(posCode)) {
			for (String field : arrSelectField) {
				String fieldValueString = validationResult.getColumn(Integer.parseInt(field));
				String comparator = getComparatorValue();
				if (!fieldValueString.equals(comparator)) {
					SubmissionField submissionField = fields.get(Integer.parseInt(field));
					validationResult.errors.add(new ValidationError(submissionField, ValidationErrorCode.E11_07_EQUAL,
							StringUtils.isEmpty(comparator) ? "kosong" : comparator));
				}
			}
		}
	}
}