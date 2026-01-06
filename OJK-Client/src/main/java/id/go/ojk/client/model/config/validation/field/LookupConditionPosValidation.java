package id.go.ojk.client.model.config.validation.field;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;

@XStreamAlias("LookupConditionValidation")
public class LookupConditionPosValidation extends LookupConditionValidation {
	private String refPosCode;

	public LookupConditionPosValidation(String parameter) {
		setParameter(parameter);
	}
	
	public LookupConditionPosValidation() {
		super();
	}

	public LookupConditionPosValidation initialized() {
		super.initialized();
		refPosCode = getStringParameter("refPosCode");
		return this;
	}
	
	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		if (refPosCode.contains(validationResult.getColumn((1)))) {
			super.validate(submissionFormat, field, validationResult);
		}
	}
}
