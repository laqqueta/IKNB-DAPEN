package id.go.ojk.client.model.config.validation.field;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;

@XStreamAlias("EqualsFixedValuePosValidation")
public class EqualsFixedValuePosValidation extends EqualsFixedValueValidation {
	protected String refPosCode;

	public EqualsFixedValuePosValidation() { }

	public EqualsFixedValuePosValidation(String parameter) {
		setParameter(parameter);
	}

	@Override
	public EqualsFixedValuePosValidation initialized() {
		super.initialized();
		refPosCode = getStringParameter("refPosCode");
		return this;
	};

	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		if (refPosCode.contains(validationResult.getColumn((1)))) {
			super.validate(submissionFormat, field, validationResult);
		}
	}
}
