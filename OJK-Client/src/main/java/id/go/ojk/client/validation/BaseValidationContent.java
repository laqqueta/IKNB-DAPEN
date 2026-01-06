package id.go.ojk.client.validation;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;
import lombok.Getter;

public abstract class BaseValidationContent implements IValidationContent {
	protected SubmissionFormat submissionFormat;
	@Getter protected ValidationResult result;
	
	public BaseValidationContent(SubmissionFormat submissionFormat, ValidationResult validationResult) {
		this.submissionFormat = submissionFormat;
		this.result = validationResult;
	}
}
