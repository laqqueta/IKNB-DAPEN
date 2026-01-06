package id.go.ojk.client.validation;

import java.util.List;

import id.go.ojk.client.model.validation.ValidationError;

public interface IValidationFile<F> extends IValidation {
	List<ValidationError> getListValidationError();
	List<F> getListFile();
}
