package id.go.ojk.client.model.config.validation.segmen;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("FixedValueOptionalValidation")
public class FixedValueOptionalValidation extends FixedValueValidation {

	public FixedValueOptionalValidation() {
		super();
	}

	public FixedValueOptionalValidation(String parameter) {
		super(parameter);
	}

	@Override
	public FixedValueOptionalValidation initialized() {
		super.initialized();
		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		List<SubmissionField> fields = submissionFormat.getFields();
		String[] arrSelectField = StringUtils.split(selectField, "|");
		String[] arrSelectPosCode = StringUtils.split(selectPosCode, "|");
		List<String> listValue = Arrays.asList(StringUtils.split(value, "|"));
		String posCode = validationResult.getColumn(1);

		for (String field : arrSelectField) {
			String fieldValueString = validationResult.getColumn(Integer.parseInt(field));
			for (int i = 0; i < arrSelectPosCode.length; i++) {
				if (posCode.contains(arrSelectPosCode[i])) {
					if (StringUtils.isNotEmpty(fieldValueString) && !listValue.contains(fieldValueString)) {
						SubmissionField submissionField = fields.get(Integer.parseInt(field));
						validationResult.errors.add(new ValidationError(submissionField,
								ValidationErrorCode.E11_07_EQUAL, StringUtils.replace(value, "|", " atau ")));
					}
				}
			}
		}
	}

}