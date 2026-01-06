package id.go.ojk.client.service;

import static id.go.ojk.client.service.ReferenceService.messageConfig_SendFileSuccess;
import static id.go.ojk.client.service.ReferenceService.messageConfig_SendFileSuccess_header;
import static id.go.ojk.client.service.ReferenceService.messageConfig_SendFileSuccess_title;
import static id.go.ojk.client.service.ReferenceService.messageConfig_prepOkAndSendFailed;
import static id.go.ojk.client.service.ReferenceService.messageConfig_prepOkAndSendFailed_header;
import static id.go.ojk.client.service.ReferenceService.messageConfig_prepOkAndSendFailed_title;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import id.go.ojk.client.module.tpp.EReportTpp;
import org.apache.commons.lang3.StringUtils;

import id.go.ojk.client.api.ApiAbsensi;
import id.go.ojk.client.api.ApiCheckUpload;
import id.go.ojk.client.api.ApiInitUpload;
import id.go.ojk.client.api.ApiPrivateKey;
import id.go.ojk.client.api.ApiRefreshToken;
import id.go.ojk.client.api.ApiUpload;
import id.go.ojk.client.constant.EReport;
import id.go.ojk.client.constant.EReportGroup;
import id.go.ojk.client.dto.DtoAbsensiRequest;
import id.go.ojk.client.dto.DtoAbsensiResponse;
import id.go.ojk.client.dto.DtoCheckUploadRequest;
import id.go.ojk.client.dto.DtoCheckUploadResponse;
import id.go.ojk.client.dto.DtoInitUploadRequest;
import id.go.ojk.client.dto.DtoInitUploadResponse;
import id.go.ojk.client.dto.DtoPrivateKeyRequest;
import id.go.ojk.client.dto.DtoPrivateKeyResponse;
import id.go.ojk.client.dto.DtoRefreshTokenRequest;
import id.go.ojk.client.dto.DtoRefreshTokenResponse;
import id.go.ojk.client.dto.DtoUploadRequest;
import id.go.ojk.client.dto.DtoUploadResponse;
import id.go.ojk.client.model.ReportInfo;
import id.go.ojk.client.module.apu.EReportApu;
import id.go.ojk.client.module.bpjs.EReportBpjs;
import id.go.ojk.client.module.lb.EReportLb;
import id.go.ojk.client.module.lbk.EReportLbk;
import id.go.ojk.client.module.lt.EReportLt;
import id.go.ojk.client.module.pls.EReportPls;
import id.go.ojk.client.module.rb.EReportRb;
import id.go.ojk.client.module.sa.EReportSa;
import id.go.ojk.client.module.tl.EReportTl;
import id.go.ojk.client.service.context.ApplicationContextClient;
import id.go.ojk.client.service.security.SecurityService;
import id.go.ojk.client.util.AlertUtil;
import id.go.ojk.lib.client.TimeCounter;
import id.go.ojk.lib.client.model.bind.SendingModel;
import id.go.ojk.lib.client.model.bind.StatusCallback;
import id.go.ojk.lib.client.model.config.MessageConfig;
import id.go.ojk.lib.client.service.context.ApplicationContext;
import javafx.scene.control.Alert.AlertType;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServiceUpload {
	private ApplicationContext appContext = ApplicationContextClient.getInstance();
	private SetupService setupService = appContext.getService(SetupService.class);
	private SecurityService securityService = appContext.getService(SecurityService.class);
	private ReferenceService referenceService = appContext.getService(ReferenceService.class);

	public static final DateTimeFormatter LOG_TIMESTAMP_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

	public String getPrivateKey() {
		ApiPrivateKey api = new ApiPrivateKey();
		DtoPrivateKeyResponse dtoResponse = api.sendReceive(getPrivateKeyRequest());
		if (dtoResponse != null && dtoResponse.isSucceed()) {
			return dtoResponse.getData().getKey();
		}
		return "";
	}

	public void uploadReportAsync(SendingModel sendingModel, int jenisPelaporan) throws Exception {
		new Thread(() -> {
			try {
				if (uploadReport(sendingModel, jenisPelaporan)) {
					sendingModel.getProgressModel().updateStatus(StatusCallback.success);
					AlertUtil.showAlertSafe(AlertType.INFORMATION, getMessage(messageConfig_SendFileSuccess_title),
							getMessage(messageConfig_SendFileSuccess_header),
							getMessage(messageConfig_SendFileSuccess));
				} else {
					sendingModel.getProgressModel().updateStatus(StatusCallback.error);
				}

				if (sendingModel.getProgressModel().isStop() && sendingModel.getProgressModel().isShowAlertOnStop()) {
					AlertUtil.showAlertSafe(AlertType.ERROR, "Kesalahan", "Kesalahan", "Proses berhentikan");
				}
			} catch (Exception e) {
				AlertUtil.showErrorSafe(log, "Error", e);
				sendingModel.getProgressModel().updateStatus(StatusCallback.error);
			}
		}).start();
	}

	@SneakyThrows
	public boolean uploadReport(SendingModel sendingModel, int reportFormGroupCode) {
		log.info("Upload using API");
		try {
			TimeCounter timeCounter = new TimeCounter();
			if (isSessionExpired()) {
				refreshSession();
			}
			String reportCode = securityService.getUserSession().getReportCode();
			File submissionDir = sendingModel.getReadyToSendDir().getAbsoluteFile();
			if (!submissionDir.exists()) {
				sendingModel.getProgressModel().writeProcessLog("Sending - Direktori file kirim tidak ditemukan!");
				return false;
			}
			List<File> files = new ArrayList<>();
			files.addAll(Arrays.asList(submissionDir.listFiles()));
			String[] submissionFTP = StringUtils.split(files.get(0).getName(), '-');
			String dateReport = getPeriodeDate(submissionFTP[3]);
			DtoAbsensiResponse dtoAbsensiResponse = getAbsensi(reportFormGroupCode, reportCode, dateReport);
			if (dtoAbsensiResponse == null || !dtoAbsensiResponse.isSucceed()) {
				String message = dtoAbsensiResponse == null ? "Gagal melakukan absensi"
						: dtoAbsensiResponse.getResponseMessage();
				sendingModel.getProgressModel().writeProcessLog(message);
				AlertUtil.showAlertSafe(AlertType.ERROR, "Kesalahan", "Kesalahan", message);
				return false;
			}
			File etlAddFile = genEtlFile(sendingModel, reportCode, submissionFTP[4], submissionFTP[3],
					reportFormGroupCode);// new File(submissionDir + File.separator + etlInfo);
			files.add(etlAddFile);
			boolean uploadStatus = uploadFile(sendingModel, files, dtoAbsensiResponse);
			if (!uploadStatus) {
				return false;
			}
			sendingModel.getProgressModel().writeProcessLog(
					String.format("Pengiriman selesai dalam %1$s", timeCounter.getTimeElapseFormated()), true);
			sendingModel.setSendingSuccess(true);
		} finally {
			sendingModel.getProgressModel().setProgress(1);
			sendingModel.getProgressModel().setOnProcess(false);
		}
		return true;
	}

	private boolean isSessionExpired() {
		String sessionId = securityService.getUserSession().getSessionId();
		return StringUtils.isNotEmpty(sessionId)
				&& (securityService.getUserSession().getSessionExpirationDate() - 120000) <= System.currentTimeMillis();
	}

	@SneakyThrows
	private boolean uploadFile(SendingModel sendingModel, List<File> files, DtoAbsensiResponse dtoAbsensiResponse) {
		if (!sendingModel.getTransferedDir().exists()) {
			sendingModel.getTransferedDir().mkdirs();
		}
		try (PrintWriter writer = new PrintWriter(sendingModel.getTransferedDir() + File.separator + "sending.log",
				"UTF-8");) {
			double totalPercentFile = 1;
			double percentPerFile = (double) 99 / (double) files.size();
			DtoCheckUploadResponse dtoCheckUploadResponse = checkUpload(dtoAbsensiResponse, files);
			if (dtoCheckUploadResponse == null || dtoCheckUploadResponse.getData() == null
					|| dtoCheckUploadResponse.getData().isEmpty()) {
				initUpload(dtoAbsensiResponse, files);
			}
			for (File file : files) {
				if (sendingModel.getProgressModel().isStop()) {
					throw new IOException("Proses upload dihentikan");
				}
				if (dtoCheckUploadResponse != null && dtoCheckUploadResponse.isFileExist(file)) {
					log.warn("File {} already exist in server.", file.getName());
					continue;
				}
				String fileName = file.getName();
				double finalPercent = totalPercentFile;
				boolean successUpload = false;
				try {
					ApiUpload api = new ApiUpload();
					DtoUploadResponse dtoUploadResponse = api.sendReceive(getUploadRequest(dtoAbsensiResponse, file));
//			    	double percent = (file.length() * percentPerFile) + finalPercent;
					double percent = percentPerFile + finalPercent;
					sendingModel.getProgressModel().setProgress(percent / 100);
					totalPercentFile += percentPerFile;
					successUpload = dtoUploadResponse != null && dtoUploadResponse.isSucceed();
				} catch (Exception e) {
					log.error(e.getMessage(), e);
				} finally {
					writer.flush();
				}
				writeSendingLong(writer, file, successUpload);
				if (!successUpload) {
					sendingModel.getProgressModel()
							.writeProcessLog(String.format("Sending - Gagal mengirim file %1$s", fileName), false);
					log.error("File " + fileName + " gagal terkirim!!!");
					AlertUtil.showAlertSafe(AlertType.INFORMATION, getMessage(messageConfig_prepOkAndSendFailed_title),
							getMessage(messageConfig_prepOkAndSendFailed_header),
							getMessage(messageConfig_prepOkAndSendFailed));
					return false;
				} else {
					sendingModel.getProgressModel().updateStatus(StatusCallback.error);
				}
			}
			writer.flush();
			return true;
		}
	}

	private void writeSendingLong(PrintWriter writer, File file, boolean isSucceed) {
	  String timestamp = LocalDateTime.now().format(LOG_TIMESTAMP_FORMAT);
		writer.println(String.format("%1$s Sending - file name   : %2$s ", timestamp, file.getAbsolutePath()));
		writer.println(String.format("%1$s Sending - file size   : %2$s bytes", timestamp, file.length()));
		if (isSucceed) {
			writer.println(String.format("%s Sending - file status : Berhasil Terkirim!\n", timestamp));
		} else {
			writer.println(String.format("%s Sending - file status : Gagal Terkirim!\n", timestamp));
		}
	}

	private String getMessage(MessageConfig messageConfig) {
		return referenceService.getMessage(messageConfig);
	}

	private void refreshSession() {
		ApiRefreshToken api = new ApiRefreshToken();
		DtoRefreshTokenResponse dtoResponse = api.sendReceive(getRefreshTokenRequest());
		if (dtoResponse != null && dtoResponse.getResponseCode().equals("200")) {
			securityService.getUserSession().setSessionId(dtoResponse.getData().getToken());
			securityService.getUserSession().setSessionExpirationDate(dtoResponse.getData().getExpirationDate());
		}
	}

	private DtoAbsensiResponse getAbsensi(int reportFormGroupCode, String reportCode, String periodeDate) {
		ApiAbsensi apiAbsensi = new ApiAbsensi();
		DtoAbsensiRequest dtoRequest = getAbsensiRequest(reportFormGroupCode, reportCode, periodeDate);
		return apiAbsensi.sendReceive(dtoRequest);
	}

	private DtoCheckUploadResponse checkUpload(DtoAbsensiResponse dtoAbsensiResponse, List<File> files) {
		ApiCheckUpload api = new ApiCheckUpload();
		DtoCheckUploadRequest dtoRequest = getCheckUploadRequest(dtoAbsensiResponse, files);
		return api.sendReceive(dtoRequest);
	}

	private DtoInitUploadResponse initUpload(DtoAbsensiResponse dtoAbsensiResponse, List<File> files) {
		ApiInitUpload api = new ApiInitUpload();
		DtoInitUploadRequest dtoRequest = getInitUploadRequest(dtoAbsensiResponse, files);
		return api.sendReceive(dtoRequest);
	}

	private File genEtlFile(SendingModel sendingModel, String reportCode, String ljk, String fileDate,
			int reportFormGroupCode) throws IOException {
		String sectorCode = setupService.getSectorCode();
		String tmpReportCode = getReportCode(reportCode, reportFormGroupCode);
		String etlInfo = "OR-" + tmpReportCode + "-" + sectorCode + "-" + ljk + "-" + fileDate + ".txt";
		File res = new File(
				sendingModel.getReadyToSendDir().getAbsoluteFile().getAbsolutePath() + File.separator + etlInfo);
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(res));) {
			String dateNow = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
			bw.write(sendingModel.getLoginID() + "|" + dateNow + "|" + dateNow + "||client");
		}
		return res;
	}

	private String getSignature(List<File> files) {
		final String SIGN0 = ".signature.part0";
		for (File file : files) {
			if (file.getName().endsWith(SIGN0)) {
				return getSignature(file);
			}
		}
		;
		return "";
	}

	@SneakyThrows
	private String getSignature(File file) {
		try (Stream<String> stream = Files.lines(Paths.get(file.getAbsolutePath()))) {
			Optional<String> value = stream.skip(1).findFirst();
			if (value.isPresent()) {
				return value.get();
			}
		}
		return "";
	}

	private long getFileSize(List<File> files) {
		long res = 0;
		for (int i = 0; i < files.size(); i++) {
			res += files.get(i).length();
		}
		return res;
	}

	private String getReportCode(String reportCode, int reportFormGroupCode) {
		String res = reportCode;
		if (EReport.isFin(reportCode)) {
			if (EReport.isLb(reportCode)) {
				ReportInfo reportInfo = EReportLb.getReportInfo(reportCode, reportFormGroupCode);
				res = reportInfo.getReport().getSector().name();
			} else if (EReport.isLbk(reportCode)) {
				ReportInfo reportInfo = EReportLbk.getReportInfo(reportCode, reportFormGroupCode);
				res = reportInfo.getReport().getSector().name();
			}
		}
		return res;
	}

	private DtoRefreshTokenRequest getRefreshTokenRequest() {
		DtoRefreshTokenRequest res = new DtoRefreshTokenRequest();
		res.setUserId(securityService.getUserSession().getUser().getUserLoginId());
		return res;
	}

	private DtoPrivateKeyRequest getPrivateKeyRequest() {
		DtoPrivateKeyRequest res = new DtoPrivateKeyRequest();
		res.setMemberCode(setupService.getMemberCode());
		return res;
	}

	private DtoAbsensiRequest getAbsensiRequest(int reportFormGroupCode, String reportCode, String periodeDate) {
		DtoAbsensiRequest res = new DtoAbsensiRequest();
		ReportInfo reportInfo = getReportInfo(reportCode, reportFormGroupCode);
		if (reportInfo != null) {
			res.setFullEntityCode(setupService.getSectorCode() + "-" + setupService.getMemberCode());
			res.setJenisKoreksi(getJenisKoreksi(reportInfo));
			res.setPeriodCode(reportInfo.getReportGroup().getPeriod());
			res.setPeriodDate(periodeDate);
			res.setReportCode(reportInfo.getReport().getCode());
			res.setReportFormGroupCode(reportInfo.getReportTypeCode());
			res.setRutinFlag(reportInfo.getReportGroup().getDeliveryCode());
//			res.setUserName("devojk\\admin.apolo");
			res.setUserName(securityService.getUserSession().getUser().getUserLoginId());
		}
		return res;
	}

	private DtoCheckUploadRequest getCheckUploadRequest(DtoAbsensiResponse dtoAbsensiResponse, List<File> files) {
		DtoCheckUploadRequest res = new DtoCheckUploadRequest();
		res.setAntrianId(dtoAbsensiResponse.getData().getAntrianID());
		res.setSummaryId(dtoAbsensiResponse.getData().getSummaryID());
//		res.setUserName("devojk\\admin.apolo");
		res.setUserName(securityService.getUserSession().getUser().getUserLoginId());
		res.setSignature(getSignature(files));
		return res;
	}

	private DtoInitUploadRequest getInitUploadRequest(DtoAbsensiResponse dtoAbsensiResponse, List<File> files) {
		DtoInitUploadRequest res = new DtoInitUploadRequest();
		res.setAntrianId(dtoAbsensiResponse.getData().getAntrianID());
		res.setSummaryId(dtoAbsensiResponse.getData().getSummaryID());
//		res.setUserName("devojk\\admin.apolo");
		res.setUserName(securityService.getUserSession().getUser().getUserLoginId());
		res.setFolderPath(dtoAbsensiResponse.getData().getFolderPath());
		res.setTotalFile(files.size());
		res.setTotalFileSize(getFileSize(files));
		res.setSignature(getSignature(files));
		return res;
	}

	private DtoUploadRequest getUploadRequest(DtoAbsensiResponse dtoAbsensiResponse, File file) {
		DtoUploadRequest res = new DtoUploadRequest();
		res.setAntrianId(dtoAbsensiResponse.getData().getAntrianID());
		res.setSummaryId(dtoAbsensiResponse.getData().getSummaryID());
//		res.setUserName("devojk\\admin.apolo");
		res.setUserName(securityService.getUserSession().getUser().getUserLoginId());
		res.setFileName(file.getAbsolutePath());
		log.info("Upload request{}", res);
		return res;
	}

	private String getJenisKoreksi(ReportInfo reportInfo) {
		if (reportInfo.getReport().getReportGroup().equals(EReportGroup.PLS)) {
			return String.valueOf(-1);
		}
		return String.valueOf(reportInfo.getReportGroup().getRevisionCode());
	}

	private ReportInfo getReportInfo(String reportCode, int reportFormGroupCode) {
		if (EReport.isApu(reportCode)) {
			return EReportApu.getReportInfo(reportCode, reportFormGroupCode);
		} else if (EReport.isLb(reportCode)) {
			return EReportLb.getReportInfo(reportCode, reportFormGroupCode);
		} else if (EReport.isLbk(reportCode)) {
			return EReportLbk.getReportInfo(reportCode, reportFormGroupCode);
		} else if (EReport.isLt(reportCode)) {
			return EReportLt.getReportInfo(reportCode, reportFormGroupCode);
		} else if (EReport.isPls(reportCode)) {
			return EReportPls.getReportInfo(reportCode, reportFormGroupCode);
		} else if (EReport.isRb(reportCode)) {
			return EReportRb.getReportInfo(reportCode, reportFormGroupCode);
		} else if (EReport.isSa(reportCode)) {
			return EReportSa.getReportInfo(reportCode, reportFormGroupCode);
		} else if (EReport.isTl(reportCode)) {
			return EReportTl.getReportInfo(reportCode, reportFormGroupCode);
		} else if (EReport.isTpp(reportCode)) {
			return EReportTpp.getReportInfo(reportCode, reportFormGroupCode);
		} else if (EReport.isBpjsKs(reportCode) || EReport.isBpjsTk(reportCode)) {
      		return EReportBpjs.getReportInfo(reportCode, reportFormGroupCode);
    	}
		return null;
	}

	private String getPeriodeDate(String fileDate) {
		return fileDate.substring(0, 4) + "-" + fileDate.substring(4, 6) + "-" + fileDate.substring(6);// yyyy-mm-dd
	}
}
