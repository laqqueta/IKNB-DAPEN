package id.go.ojk.client.module;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending;
import id.go.ojk.client.model.bind.ProgressSegment;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.client.service.SetupService;
import id.go.ojk.client.service.context.ApplicationContextClient;
import id.go.ojk.client.validation.BaseValidationContentHandler;
import id.go.ojk.lib.client.model.config.ConfigLocalDate;

public abstract class ValidationHandler extends BaseValidationContentHandler {
	private SetupService setupService;

	protected ValidationHandler(ProgressPreparationAndSending progressModel, ProgressSegment progressSegment,
			ThreadPoolExecutor executor) {
		super(progressModel, progressSegment, executor);
		initialized();
	}

	@Override
	public void initialized() {
		this.setupService = ApplicationContextClient.getInstance().getService(SetupService.class);
		this.referenceService = ApplicationContextClient.getInstance().getService(ReferenceService.class);
		super.initialized();
	}

	@Override
	protected LocalDate getConfig(ConfigLocalDate configLocalDate) {
		return referenceService.getConfig(configLocalDate);
	}

	@Override
	protected List<ValidationError> validateEntityTypeAndEntityCode(String entityTypeCode, String entityCode) {
		return setupService.validateEntityTypeAndEntityCode(entityTypeCode, entityCode);
	}

	@Override
	protected void validateReference(SubmissionField field, String code, List<Integer> referenceNumbers,
			List<ValidationError> errors) {
		referenceService.validate(field, code, referenceNumbers, errors);
	}
}
