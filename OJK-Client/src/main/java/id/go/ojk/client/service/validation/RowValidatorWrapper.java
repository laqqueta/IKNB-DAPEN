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

public class RowValidatorWrapper implements RowValidator {
	
	private RowValidator innerRowValidator;
	
	public RowValidatorWrapper(RowValidator innerRowValidator){
		this.innerRowValidator = innerRowValidator;
	}
			
	@Override
	public void initilized(){
	}
	
	@Override
	public void cleanUp() {
		innerRowValidator.cleanUp();
	}

	
	@Override
	public SubmissionFormat getSubmissionFormat() {
		return innerRowValidator.getSubmissionFormat();
	}

	@Override
	public void validateRow(SubmissionData submissionData, ValidationResult validationResult) {
		innerRowValidator.validateRow(submissionData, validationResult);
	}
	
	@Override
	public void validateSimpleValidation(SubmissionField field, ValidationResult validationResult){
		innerRowValidator.validateSimpleValidation(field, validationResult);
	}
	
	@Override
	public boolean validateField(SubmissionField field, ValidationResult validationResult){
		return innerRowValidator.validateField(field, validationResult);
	}

	@Override
	public boolean validateFields(Map<Integer, Boolean> validationResultCache, int[] fieldNumbers, ValidationResult validationResult){
		return innerRowValidator.validateFields(validationResultCache, fieldNumbers, validationResult);
	}

	@Override
	public void validateField(SubmissionField field, ValidationResult validationResult, String value){
		innerRowValidator.validateField(field, validationResult, value);
	}
	
	@Override
	public void validateReference(SubmissionField field, String code, List<Integer> referenceNumbers, List<ValidationError> errors){
		innerRowValidator.validateReference(field, code, referenceNumbers, errors);
	}
	
	@Override
	public void validateReferencePerSegment(SubmissionField field, String code, List<Integer> referenceNumbers, List<ValidationError> errors) {
		innerRowValidator.validateReferencePerSegment(field, code, referenceNumbers, errors);
	}

	
	@Override
	public Tupple2<RequiredCondition, String>  analizeRequiredCondition(SubmissionField field, ValidationResult validationResult){
		return innerRowValidator.analizeRequiredCondition(field, validationResult);
	}
	
	@Override
	public boolean validateFields(Map<Integer, Boolean> validationResultCache, int fieldNumber, ValidationResult validationResult){
		return innerRowValidator.validateFields(validationResultCache, fieldNumber, validationResult);
	}


}
