package id.go.ojk.client.service.validation;

import java.util.HashSet;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

public class ValidationRelation {

	private String relationTo;
	private SubmissionField submissionField;
	private HashSet<String> reference;

	public ValidationRelation(String relationTo, SubmissionField submissionField, HashSet<String> reference){
		this.relationTo = relationTo;
		this.submissionField = submissionField;
		this.reference = reference;
	}

	public String getRelationTo() {
		return relationTo;
	};

	public SubmissionField getSubmissionField() {
		return submissionField;
	};

	public HashSet<String> getReference() {
		return reference;
	};

	//~ method

	public boolean validate(ValidationResult validationResult) {
		String value = validationResult.getColumn(submissionField.getNumber());
		boolean contain = reference.contains(value);
		if( !contain ){
			validationResult.errors.add(new ValidationError(submissionField, ValidationErrorCode.E40_00_RELATION, relationTo));
		}
		return contain;
	}

}
