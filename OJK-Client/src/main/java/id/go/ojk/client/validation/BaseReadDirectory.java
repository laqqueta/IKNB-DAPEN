package id.go.ojk.client.validation;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.module.tpp.EReportTpp;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import id.go.ojk.client.constant.EReport;
import id.go.ojk.client.db.util.Formatter;
import id.go.ojk.client.model.ReportInfo;
import id.go.ojk.client.model.SaveMapValueForm;
import id.go.ojk.client.model.ValidFile;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending;
import id.go.ojk.client.model.bind.ProgressSegment;
import id.go.ojk.client.model.bind.ProgressSegmentFile;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.SubmissionMetadata;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.module.apu.EReportApu;
import id.go.ojk.client.module.bpjs.EReportBpjs;
import id.go.ojk.client.module.lb.EReportLb;
import id.go.ojk.client.module.lbk.EReportLbk;
import id.go.ojk.client.module.pls.EReportPls;
import id.go.ojk.client.module.rb.EReportRb;
import id.go.ojk.client.module.sa.EReportSa;
import id.go.ojk.client.module.tl.EReportTl;
import id.go.ojk.client.util.AlertUtil;
import id.go.ojk.client.vc.ReadSubmissionDirController.ReadSubmissionDirModel;
import id.go.ojk.lib.client.EncryptionUtil;
import id.go.ojk.lib.client.TimeCounter;
import id.go.ojk.lib.client.model.compression.FileIntegrity;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import id.go.ojk.lib.client.util.JsonUtil;
import javafx.scene.control.Alert.AlertType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BaseReadDirectory implements IReadDirectory {
	private final Logger logger = LoggerFactory.getLogger(BaseReadDirectory.class);
	private File submissionDir;
	private String memberCode;
	private String memberTypeCode;
	private ReportInfo reportInfo;
	protected boolean runOnClient = false;
	private ProgressPreparationAndSending mainProgress;
	protected ReadSubmissionDirModel readDirModel;

	protected abstract IValidationFile<ValidFile> initValidationFileName(List<File> files, 
			List<SubmissionFormat> listSubmissionFormat, ProgressPreparationAndSending childProgress);
	
	public File getSubmissionDir() {
		return submissionDir;
	}

	public void setSubmissionDir(File submissionDir) {
		this.submissionDir = submissionDir;
	}

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public String getMemberTypeCode() {
		return memberTypeCode;
	}

	public void setMemberTypeCode(String memberTypeCode) {
		this.memberTypeCode = memberTypeCode;
	}

	public ReportInfo getReportInfo() {
		return reportInfo;
	}

	public void setReportInfo(ReportInfo reportInfo) {
		this.reportInfo = reportInfo;
	}

	public void setReportInfo(String reportCode, int reportMenuCode) {
		this.reportInfo = getReportInfo(reportCode, reportMenuCode);
		logger.info("ReportCode={}; reportMenuCode={}; reportInfo={}", reportCode, reportMenuCode, JsonUtil.toJson(reportInfo, true));
	}

	public boolean isRunOnClient() {
		return runOnClient;
	}

	public void setRunOnClient(boolean runOnClient) {
		this.runOnClient = runOnClient;
	}

	public ProgressPreparationAndSending getMainProgress() {
		return mainProgress;
	}

	public void setMainProgress(ProgressPreparationAndSending mainProgress) {
		this.mainProgress = mainProgress;
	}

	public ReadSubmissionDirModel getReadDirModel() {
		return readDirModel;
	}

	public void setReadDirModel(ReadSubmissionDirModel readDirModel) {
		this.readDirModel = readDirModel;
	}

	protected void clearFormData() {
	  SubmissionFormat.mapPosValueForm.clear();
	}

	protected void saveFormData(ProgressSegment progressSegment, File file) {
	  SaveMapValueForm smv = new SaveMapValueForm(progressSegment, file);
	  SubmissionFormat.mapPosValueForm.putAll(smv.getMapping());
	}

	protected void setFileChecksum(ReadSubmissionDirModel readDirModel, double progressMultiplier, FileIntegrity fileIntegrity) {
	  StopWatch sw = new StopWatch();
	  sw.start();
	  String checksum = EncryptionUtil.getFileChecksum(readDirModel, progressMultiplier, fileIntegrity.getFile());
	  sw.stop();
	  log.info("Checksum completed in {}", Formatter.formatMillis(sw.getTime()));
	  fileIntegrity.setChecksum(checksum);
	}

	@Override
	public List<ValidationError> readDirectory() {
		List<ValidationError> res = new ArrayList<ValidationError>();
		try {
			TimeCounter timeCounter = new TimeCounter();
			SubmissionMetadata metadata = mainProgress.getMetadata();
			ProgressPreparationAndSending childProgress = new ProgressPreparationAndSending(metadata,
					mainProgress.getSubmissionData().isRunInJavaFx());
			childProgress.setSubmissionDirectory(submissionDir);
			ValidationDirectory validationDirectory = new ValidationDirectory(submissionDir, readDirModel);
			if (validationDirectory.validate()) {
				List<File> files = validationDirectory.getListFile();
				IValidationFile<ValidFile> validationFileName = 
						initValidationFileName(files, metadata.getFormats(), childProgress);
				if (!validationFileName.validate()) {
					res.addAll(validationFileName.getListValidationError());
				}
			} else {
				res.addAll(validationDirectory.getListValidationError());
			}
			clearFormData();
			if (res.isEmpty()) {
				readDirModel.setTotalLength(childProgress.getTotalFileSize().longValue());
				readDirAndChecksum(childProgress);
				if (!readDirModel.isStop()) {
					mainProgress.readyToProcess(childProgress);
				} else {
					String message = "Proses dihentikan";
					res.add(new ValidationError(null, ValidationErrorCode.E01_01_DATA_NOT_READY));
					AlertUtil.showAlertSafe(AlertType.INFORMATION, "Informasi", "Informasi", message);
				}
			}
			if (res.isEmpty()) {
				readDirModel.writeProcessLog("Baca direktori Sukses dalam " + timeCounter.getTimeElapseFormated());
				mainProgress.setReadDirectoryTimeElapse(timeCounter.getTimeElapse());
				mainProgress.setReadyToProcess(true);
			} else {
				readDirModel.writeProcessLog("Baca direktori Gagal, detail cek tab Error");
			}
		} finally {
			readDirModel.setOnProcess(false);
		}
		return res;
	}
	
	protected void readDirAndChecksum(ProgressPreparationAndSending childProgress) {
	  for (ProgressSegment progressSegment : childProgress.getSegments()) {
      for (ProgressSegmentFile progressSegmentFile : progressSegment.getSegmentFiles()) {
        if (readDirModel.isStop()) {
          break;
        }
        FileIntegrity fileIntegrity = progressSegmentFile.getFileIntegrity();
        if (runOnClient) {
          readDirModel.writeProcessLog("Baca file " + fileIntegrity.getFile());
          setFileChecksum(readDirModel, 1, fileIntegrity);
        }
        saveFormData(progressSegment, fileIntegrity.getFile());
      }
    }
	}
	
	private ReportInfo getReportInfo(String reportCode, int reportMenuCode) {
		ReportInfo res = null;
		if (EReport.isLb(reportCode)) {
			res = EReportLb.getReportInfo(reportCode, reportMenuCode);
		} else if (EReport.isLbk(reportCode)) {
			res = EReportLbk.getReportInfo(reportCode, reportMenuCode);
		} else if (EReport.isSa(reportCode)) {
			res = EReportSa.getReportInfo(reportCode, reportMenuCode);
		} else if (EReport.isApu(reportCode)) {
			res = EReportApu.getReportInfo(reportCode, reportMenuCode);
		} else if (EReport.isTl(reportCode)) {
			res = EReportTl.getReportInfo(reportCode, reportMenuCode);
		} else if (EReport.isPls(reportCode)) {
			res = EReportPls.getReportInfo(reportCode, reportMenuCode);
		} else if (EReport.isTpp(reportCode)) {
			res = EReportTpp.getReportInfo(reportCode, reportMenuCode);
		} else if (EReport.isBpjsKs(reportCode)) {
		  res = EReportBpjs.getReportInfo(reportCode, reportMenuCode);
		} else if (EReport.isBpjsTk(reportCode)) {
      res = EReportBpjs.getReportInfo(reportCode, reportMenuCode);
    } else {
			res = EReportRb.getReportInfo(reportCode, reportMenuCode);
		}
		return res;
	}
}
