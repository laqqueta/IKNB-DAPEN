package id.go.ojk.client.module.lbk;

import java.io.IOException;
import java.util.concurrent.ThreadPoolExecutor;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending;
import id.go.ojk.client.model.bind.ProgressSegment;
import id.go.ojk.client.model.bind.ProgressSegmentFile;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.module.ValidationHandler;
import id.go.ojk.client.validation.IValidationContent;

public class ValidationHandlerLbk extends ValidationHandler {

	public ValidationHandlerLbk(ProgressPreparationAndSending progressModel, ProgressSegment progressSegment,
			ThreadPoolExecutor executor) {
		super(progressModel, progressSegment, executor);
	}

	@Override
	protected void validatePreHeader(ProgressSegmentFile progressSegmentFile, ValidationResult validationResult,
			int reportFormGroupCode) throws IOException {
		IValidationContent validation = new ValidationPreHeaderLbk(progressSegmentFile.getFileIntegrity().getFile(),
				getSumRow(), reportFormGroupCode, submissionFormat, validationResult);
		validation.validate();
	}
}
