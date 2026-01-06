package id.go.ojk.client.model.config.validation.condition;

import id.go.ojk.client.model.validation.ValidationResult;

public interface Condition {
	boolean test(ValidationResult validationResult);
}
