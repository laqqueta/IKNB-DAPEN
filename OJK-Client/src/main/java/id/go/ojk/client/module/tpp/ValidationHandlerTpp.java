package id.go.ojk.client.module.tpp;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending;
import id.go.ojk.client.model.bind.ProgressSegment;
import id.go.ojk.client.model.bind.ProgressSegmentFile;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.module.ValidationHandler;
import id.go.ojk.client.module.apu.ValidationPreHeaderApu;
import id.go.ojk.client.validation.IValidationContent;

import java.io.IOException;
import java.util.concurrent.ThreadPoolExecutor;

public class ValidationHandlerTpp extends ValidationHandler {

	public ValidationHandlerTpp(ProgressPreparationAndSending progressModel, ProgressSegment progressSegment,
                                ThreadPoolExecutor executor) {
		super(progressModel, progressSegment, executor);
	}

	@Override
	protected void validatePreHeader(ProgressSegmentFile progressSegmentFile, ValidationResult validationResult,
			int reportFormGroupCode) throws IOException {
		IValidationContent validation = new ValidationPreHeaderTpp(progressSegmentFile.getFileIntegrity().getFile(),
				getSumRow(), reportFormGroupCode, submissionFormat, validationResult);
		validation.validate();
	}
}
