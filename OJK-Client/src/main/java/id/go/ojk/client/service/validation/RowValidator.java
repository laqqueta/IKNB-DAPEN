package id.go.ojk.client.service.validation;

import java.util.List;
import java.util.Map;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.RequiredCondition;

public interface RowValidator {
	
	void initilized();
	
	void cleanUp();
	
	SubmissionFormat getSubmissionFormat();

	void validateRow(SubmissionData submissionData, ValidationResult validationResult);
	
	void validateSimpleValidation(SubmissionField field, ValidationResult validationResult);
	
	boolean validateField(SubmissionField field, ValidationResult validationResult);

	boolean validateFields(Map<Integer, Boolean> validationResultCache, int[] fieldNumbers, ValidationResult validationResult);

	void validateField(SubmissionField field, ValidationResult validationResult, String value);
	
	void validateReference(SubmissionField field, String code, List<Integer> referenceNumbers, List<ValidationError> errors);
	
	void validateReferencePerSegment(SubmissionField field, String code, List<Integer> referenceNumbers, List<ValidationError> errors);
	
	Tupple2<RequiredCondition, String>  analizeRequiredCondition(SubmissionField field, ValidationResult validationResult);

	boolean validateFields(Map<Integer, Boolean> validationResultCache, int fieldNumber,
			ValidationResult validationResult);

}
