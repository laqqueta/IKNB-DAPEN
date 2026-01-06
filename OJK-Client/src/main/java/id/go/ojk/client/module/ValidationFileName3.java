package id.go.ojk.client.module;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import id.go.ojk.client.model.ReportInfo;
import id.go.ojk.client.model.ValidFile;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending;
import id.go.ojk.client.model.bind.ProgressSegment;
import id.go.ojk.client.model.bind.ProgressSegmentFile;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.validation.BaseValidationFile;
import id.go.ojk.client.vc.ReadSubmissionDirController.ReadSubmissionDirModel;
import id.go.ojk.lib.client.model.compression.FileIntegrity;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

public class ValidationFileName3 extends BaseValidationFile<ValidFile> {
	private final Logger logger = LoggerFactory.getLogger(ValidationFileName3.class);
	protected List<ValidFile> files;
	protected ReportInfo reportInfo;
	protected String memberTypeCode;
	protected String memberCode;
	protected List<SubmissionFormat> listSubmissionFormat;
	protected ProgressPreparationAndSending mainProgress;
	protected ProgressPreparationAndSending childProgress;
	protected List<ValidFile> listFile = new ArrayList<>();

	public ValidationFileName3(List<ValidFile> files, ReportInfo reportInfo, String memberCode,
			String memberTypeCode, List<SubmissionFormat> listSubmissionFormat) {
		this.files = files;
		this.reportInfo = reportInfo;
		this.memberCode = memberCode;
		this.memberTypeCode = memberTypeCode;
		this.listSubmissionFormat = listSubmissionFormat;
	}

	public ValidationFileName3(List<ValidFile> files, ReportInfo reportInfo, String memberCode,
			String memberTypeCode, List<SubmissionFormat> listSubmissionFormat,
			ProgressPreparationAndSending mainProgress, ProgressPreparationAndSending childProgress,
			ReadSubmissionDirModel readDirModel) {
		this(files, reportInfo, memberCode, memberTypeCode, listSubmissionFormat);
		this.mainProgress = mainProgress;
		this.childProgress = childProgress;
		this.readDirModel = readDirModel;
	}

	@Override
	public boolean validate() {
		logger.info("Validator=" + this.getClass().getName());
		if (listSubmissionFormat != null && !listSubmissionFormat.isEmpty()) {
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
				setSubmissionFtp(firstPeriodReport);
			}
		}
		boolean res = getListValidationError().isEmpty();
		if (!res) {
			logger.error("Validation failed!!!");
		}
		return res;
	}

	public List<ValidFile> getListFile() {
		return listFile;
	}

	protected void addToSegment(SubmissionFormat submissionFormat, List<ValidFile> listValidFile) {
		if (childProgress != null && mainProgress != null) {
			ProgressSegment progressSegment = new ProgressSegment(submissionFormat,
					new ArrayList<ProgressSegmentFile>());
			for (int i = 0; i < listValidFile.size(); i++) {
				FileIntegrity fileIntegrity = new FileIntegrity(listValidFile.get(i).getFile(), null);
				ProgressSegmentFile progressSegmentFile = new ProgressSegmentFile(fileIntegrity, mainProgress);
				progressSegment.addSegmentFiles(progressSegmentFile);
			}
			childProgress.addSegment(progressSegment);
		}
	}

	protected boolean validateFormCode(List<ValidFile> listSegmentFile, SubmissionFormat submissionFormat) {
		boolean res = !listSegmentFile.isEmpty();
		if (!res) {
			logError(new ValidationError(null, ValidationErrorCode.E01_05_INVALID_FILE,
					"Form '" + submissionFormat.getCode() + "' tidak ditemukan / tidak sesuai format"));
		}
		return res;
	}

	protected List<ValidFile> listValidFileName(SubmissionFormat submissionFormat, String firstPeriodReport) {
		List<ValidFile> res = new ArrayList<>();
		if (files != null && !files.isEmpty()) {
			String firstPeriodType = files.get(0).getPart(3);
			String formattedFileName = submissionFormat.getReportCode() + "-" + submissionFormat.getCode() + "-"
					+ reportInfo.getReportGroup().getDeliveryCode() + "-" + firstPeriodType + "-" + firstPeriodReport
					+ "-" + memberCode + "-" + memberTypeCode;
			for (int i = 0; i < files.size(); i++) {
				ValidFile file = files.get(i);
				if (file.getFileName().equals(formattedFileName)) {
					if (!file.getExtension().equals(submissionFormat.getExtention())) {
						logError(new ValidationError(null, ValidationErrorCode.E01_05_INVALID_FILE,
								"Ekstensi file '" + file.getFullFileName() + "' tidak sesuai"));
					} else {
						listFile.add(file);
						res.add(file);
						break;
					}
				} else {
					logger.error(file.getFileName() + "!=" +  formattedFileName);
				}
			}
		}
		return res;
	}

	protected boolean validateFileName() {
		files.removeAll(getListFile());
		boolean res = files.isEmpty();
		if (!res) {
			logError(new ValidationError(null, ValidationErrorCode.E01_05_INVALID_FILE,
					"Nama file '" + files.stream().map(file -> file.getFullFileName()).collect(Collectors.joining(", \n"))
							+ "' tidak valid"));
		}
		return res;
	}

	protected void setSubmissionFtp(String firstPeriodReport) {
		String submissionFTP = reportInfo.getReportTypeCode() + "-" + reportInfo.getReportGroup().getDeliveryCode()
				+ "-" + reportInfo.getReportGroup().getPeriod() + "-" + firstPeriodReport + "-" + memberCode + "-"
				+ memberTypeCode;
		mainProgress.setSubmissionFTP(submissionFTP);
	}
}
