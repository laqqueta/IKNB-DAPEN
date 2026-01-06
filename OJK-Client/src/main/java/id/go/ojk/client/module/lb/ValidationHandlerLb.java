package id.go.ojk.client.module.lb;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

import id.go.ojk.client.constant.EReport;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending;
import id.go.ojk.client.model.bind.ProgressSegment;
import id.go.ojk.client.model.bind.ProgressSegmentFile;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.module.ValidationHandler;
import id.go.ojk.client.validation.IValidationContent;

public class ValidationHandlerLb extends ValidationHandler {

	public static final List<EReportLb> LB_LPEI_REPORTS = EReportLb
			.getByReport(Arrays.asList(EReport.LB_LPEIG, EReport.LB_LPEIU));

	public ValidationHandlerLb(ProgressPreparationAndSending progressModel, ProgressSegment progressSegment,
			ThreadPoolExecutor executor) {
		super(progressModel, progressSegment, executor);
	}

	@Override
	protected void validatePreHeader(ProgressSegmentFile progressSegmentFile, ValidationResult validationResult,
			int reportFormGroupCode) throws IOException {

		IValidationContent validation = null;
		boolean isLpei = this.isLpei(validationResult);
		if (isLpei) {
			validation = new ValidationPreHeaderLbLpei(progressSegmentFile.getFileIntegrity().getFile(),
					getSumRow(), reportFormGroupCode, submissionFormat, validationResult);
		} else {
			validation = new ValidationPreHeaderLb(progressSegmentFile.getFileIntegrity().getFile(),
					getSumRow(), reportFormGroupCode, submissionFormat, validationResult);
		}
		validation.validate();
	}

	private boolean isLpei(ValidationResult validationResult) {
		String code = submissionFormat.getReportCode();
		for (EReportLb report : LB_LPEI_REPORTS) {
			if (report.getReportTypeCode().equals(code)) {
				return true;
			}
		}
		return false;
	}
}
