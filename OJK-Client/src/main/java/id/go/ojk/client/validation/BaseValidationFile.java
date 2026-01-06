package id.go.ojk.client.validation;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.vc.ReadSubmissionDirController.ReadSubmissionDirModel;

public abstract class BaseValidationFile<F> implements IValidationFile<F>{
	protected ReadSubmissionDirModel readDirModel;
	private List<ValidationError> listValidationError = new ArrayList<>();
	
	protected void logError(ValidationError error) {
		getListValidationError().add(error);
		if (readDirModel != null) {
			readDirModel.logError(error);
		}
	}

	@Override
	public List<ValidationError> getListValidationError() {
		return listValidationError;
	}
}
