package id.go.ojk.client.module.rb;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.ReportInfo;
import id.go.ojk.client.model.ValidFile;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.module.ValidationFileName3;
import id.go.ojk.client.vc.ReadSubmissionDirController.ReadSubmissionDirModel;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

public class ValidationFileNameRb3 extends ValidationFileName3 {

	public ValidationFileNameRb3(List<ValidFile> files, ReportInfo reportInfo, String memberCode, String memberTypeCode,
			List<SubmissionFormat> listSubmissionFormat) {
		super(files, reportInfo, memberCode, memberTypeCode, listSubmissionFormat);
	}

	public ValidationFileNameRb3(List<ValidFile> files, ReportInfo reportInfo, String memberCode, String memberTypeCode,
			List<SubmissionFormat> listSubmissionFormat, ProgressPreparationAndSending mainProgress,
			ProgressPreparationAndSending childProgress, ReadSubmissionDirModel readDirModel) {
		super(files, reportInfo, memberCode, memberTypeCode, listSubmissionFormat, mainProgress, childProgress,
				readDirModel);
	}

	@Override
	protected List<ValidFile> listValidFileName(SubmissionFormat submissionFormat, String firstPeriodReport) {
		List<ValidFile> res = new ArrayList<>();
		if (files != null) {
			String reportCodeSector = reportInfo.getReportTypeCode();
			String formattedFileName = reportCodeSector + "-" + submissionFormat.getCode() + "-"
					+ reportInfo.getReportGroup().getDeliveryCode() + "-" + reportInfo.getReportGroup().getPeriod()
					+ "-" + firstPeriodReport + "-" + memberCode + "-" + memberTypeCode;
			for (int i = 0; i < files.size(); i++) {
				ValidFile file = files.get(i);
				if (file.getFileName().equals(formattedFileName)) {
					if (reportInfo.getReportGroup().getMenuCode() != EReportGroupRb.PENGAWASAN.getMenuCode()
							&& !file.getExtension().equals(submissionFormat.getExtention())) {
						logError(new ValidationError(null, ValidationErrorCode.E01_05_INVALID_FILE,
								"Ekstensi file '" + file.getFullFileName() + "' tidak sesuai"));
					} else {
						listFile.add(file);
						res.add(file);
						break;
					}
				}
			}
		}
		return res;
	}
}
