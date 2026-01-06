package id.go.ojk.client.module.sa;

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

public class ValidationHandlerSa extends ValidationHandler {

	public static final List<EReportSa> SA_PPI_REPORTS = EReportSa
			.getByReport(Arrays.asList(EReport.SA_PPIK, EReport.SA_PPIU, EReport.SA_PPIS));

	public ValidationHandlerSa(ProgressPreparationAndSending progressModel, ProgressSegment progressSegment,
			ThreadPoolExecutor executor) {
		super(progressModel, progressSegment, executor);
	}

	@Override
	protected void validatePreHeader(ProgressSegmentFile progressSegmentFile, ValidationResult validationResult,
			int reportFormGroupCode) throws IOException {

		IValidationContent validation = null;
		boolean isSaPpiReport = this.isSaPpi(validationResult);
		if (isSaPpiReport) {
			validation = new ValidationPreHeaderSaPpi(progressSegmentFile.getFileIntegrity().getFile(), getSumRow(),
					reportFormGroupCode, submissionFormat, validationResult);
		} else {
			validation = new ValidationPreHeaderSa(progressSegmentFile.getFileIntegrity().getFile(), getSumRow(),
					reportFormGroupCode, submissionFormat, validationResult);
		}
		validation.validate();
	}

	private boolean isSaPpi(ValidationResult validationResult) {
		String code = submissionFormat.getReportCode();
		for (EReportSa report : SA_PPI_REPORTS) {
			if (report.getReportTypeCode().equals(code)) {
				return true;
			}
		}
		return false;
	}
}
