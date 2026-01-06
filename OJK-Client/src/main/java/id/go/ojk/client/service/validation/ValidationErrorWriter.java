package id.go.ojk.client.service.validation;

import java.io.IOException;

import id.go.ojk.client.model.validation.ValidationResult;

public interface ValidationErrorWriter {
	
	void writeError(ValidationResult value) throws IOException;
	
	void writeError(Integer rowNumber, String error) throws IOException;

}
