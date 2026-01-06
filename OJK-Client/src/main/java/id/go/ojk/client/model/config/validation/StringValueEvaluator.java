package id.go.ojk.client.model.config.validation;

import id.go.ojk.client.model.validation.ValidationResult;

public class StringValueEvaluator implements ValueEvaluator<String> {

	private int fieldNumber;

	public StringValueEvaluator(int fieldNumber){
		this.fieldNumber = fieldNumber;
	}

	@Override
	public String get(ValidationResult validationResult) {
		return validationResult.getColumn(fieldNumber);
	}

}
