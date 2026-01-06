package id.go.ojk.client.module.tl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import id.go.ojk.client.model.ReportInfo;
import id.go.ojk.client.model.ValidFile;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.ValidationFileName3;
import id.go.ojk.client.vc.ReadSubmissionDirController.ReadSubmissionDirModel;

public class ValidationFileNameTl3 extends ValidationFileName3 {
	private final Logger logger = LoggerFactory.getLogger(ValidationFileNameTl3.class);

	public ValidationFileNameTl3(List<ValidFile> files, ReportInfo reportInfo, String memberCode, String memberTypeCode,
			List<SubmissionFormat> listSubmissionFormat) {
		super(files, reportInfo, memberCode, memberTypeCode, listSubmissionFormat);
	}

	public ValidationFileNameTl3(List<ValidFile> files, ReportInfo reportInfo, String memberCode, String memberTypeCode,
			List<SubmissionFormat> listSubmissionFormat, ProgressPreparationAndSending mainProgress,
			ProgressPreparationAndSending childProgress, ReadSubmissionDirModel readDirModel) {
		super(files, reportInfo, memberCode, memberTypeCode, listSubmissionFormat, mainProgress, childProgress,
				readDirModel);
	}

	@Override
	public boolean validate() {
		logger.info("Validator=" + this.getClass().getName());
		if (listSubmissionFormat != null && !listSubmissionFormat.isEmpty()) {
			String firstPeriodType = files.get(0).getPart(3);
			String firstPeriodReport = files.get(0).getPart(4);
			String reportTypeCode = reportInfo.getReportTypeCode();
			int menuCode = reportInfo.getReportGroup().getMenuCode();
			for (int i = 0; i < listSubmissionFormat.size(); i++) {
				SubmissionFormat submissionFormat = listSubmissionFormat.get(i);
				submissionFormat.setReportFormGroupCode(menuCode);
				String reportCodeFromMeta = (submissionFormat.getReportCode() == null ? ""
						: submissionFormat.getReportCode());
				if (reportCodeFromMeta.equals(reportTypeCode)) {
					List<ValidFile> listSegmentFile = listValidFileName(submissionFormat, firstPeriodReport);
					if (validateFormCode(listSegmentFile, submissionFormat)) {
						addToSegment(submissionFormat, listSegmentFile);
					}
				} else {
					logger.warn("reportGroupCode=" + menuCode + ">(reportCodeFromMeta=" + reportCodeFromMeta
							+ ")!=(reportCodeSector=" + reportTypeCode + ")");
				}
			}
			if (validateFileName()) {
				setSubmissionFtp(firstPeriodType, firstPeriodReport);
			}
		}
		boolean res = getListValidationError().isEmpty();
		if (!res) {
			logger.error("Validation failed!!!");
		}
		return res;
	}

	private void setSubmissionFtp(String firstPeriodType, String firstPeriodReport) {
		String reportTypeCode = reportInfo.getReportTypeCode();
		String submissionFTP = reportTypeCode + "-" + reportInfo.getReportGroup().getDeliveryCode() + "-"
				+ firstPeriodType + "-" + firstPeriodReport + "-" + memberCode + "-" + memberTypeCode;
		mainProgress.setSubmissionFTP(submissionFTP);
	}
}
