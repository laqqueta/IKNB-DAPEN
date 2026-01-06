package id.go.ojk.client.validation;

import id.go.ojk.client.model.validation.ValidationResult;

public interface IValidationContent extends IValidation {
	ValidationResult getResult();
}
