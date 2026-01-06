package id.go.ojk.client.model.config.validation.segmen;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.config.Regex;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

public abstract class BaseRegexValidation extends BaseRowValidation {
	
	public BaseRegexValidation() {
		super();
	}
	
	public BaseRegexValidation(String parameter) {
		super(parameter);
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		List<SubmissionField> fields = submissionFormat.getFields();
		String[] arrSelectField = selectField.split("[|]");
		List<String> listSelectPosCode = Arrays.asList(selectPosCode.split("[|]"));
		String posCode = validationResult.getColumn(1);
		Regex regex = getRegex();

		for (String field : arrSelectField) {
			if (listSelectPosCode.contains(posCode)) {
				String fieldValueString = validationResult.getColumn(Integer.parseInt(field));
				if (StringUtils.isNotEmpty(fieldValueString)) {
					validate(regex, fieldValueString, fields.get(Integer.parseInt(field)), validationResult);
				}
			}
		}
	}
	
	protected boolean validate(Regex regex, String value, SubmissionField field, ValidationResult validationResult) {
		boolean res = true;
		if (!value.matches(regex.getPattern())) {
			validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E11_00_FORMAT, regex.getDesc()));
			res = false;
		}
		return res;
	}

	protected abstract Regex getRegex();
}