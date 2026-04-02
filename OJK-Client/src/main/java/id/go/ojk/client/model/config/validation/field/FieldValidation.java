package id.go.ojk.client.model.config.validation.field;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.service.context.ApplicationContext;

public interface FieldValidation extends IValidation {

	void setApplicationContext(ApplicationContext appCtx);

	FieldValidation setParameter(String parameter);
	
	String getParameter();

	FieldValidation initialized();

	void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult);

	FieldValidation beforeValidationStart(SubmissionData submissionData);

}
