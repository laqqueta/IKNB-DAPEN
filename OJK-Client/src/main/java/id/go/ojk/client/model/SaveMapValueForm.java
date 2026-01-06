package id.go.ojk.client.model;

import java.io.File;

import id.go.ojk.client.model.bind.ProgressSegment;
import id.go.ojk.client.model.validation.ValidationResult;

public class SaveMapValueForm extends SaveMapValue {
	public SaveMapValueForm(ProgressSegment progressSegment, File file) {
		super(progressSegment, file);
	}

	@Override
	protected SaveMapParam getSaveMapParam() {
		return new SaveMapParam(submissionFormat.getSavePosForm());
	}
	
	protected String getKeyMapping(ValidationResult validationResult, SaveMapParam saveMapParam) {
		String res = super.getKeyMapping(validationResult, saveMapParam);
		res = submissionFormat.getCode() + res;
		return res;
	}
}
