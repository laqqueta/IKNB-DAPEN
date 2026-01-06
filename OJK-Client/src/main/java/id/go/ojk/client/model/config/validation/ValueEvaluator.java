package id.go.ojk.client.model.config.validation;

import id.go.ojk.client.model.validation.ValidationResult;

public interface ValueEvaluator<T> {
	T get(ValidationResult validationResult);
}
