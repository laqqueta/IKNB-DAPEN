package id.go.ojk.client.service;

import static id.go.ojk.client.service.ReferenceService.messageConfig_prepAndSendFileSuccess;
import static id.go.ojk.client.service.ReferenceService.messageConfig_prepAndSendFileSuccess_header;
import static id.go.ojk.client.service.ReferenceService.messageConfig_prepAndSendFileSuccess_title;
import static id.go.ojk.client.service.ReferenceService.messageConfig_prepFileSuccess;
import static id.go.ojk.client.service.ReferenceService.messageConfig_prepFileSuccess_header;
import static id.go.ojk.client.service.ReferenceService.messageConfig_prepFileSuccess_title;
import static id.go.ojk.client.service.ReferenceService.messageConfig_prepOkAndSendFailed;
import static id.go.ojk.client.service.ReferenceService.messageConfig_prepOkAndSendFailed_header;
import static id.go.ojk.client.service.ReferenceService.messageConfig_prepOkAndSendFailed_title;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.compress.archivers.ArchiveException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.XStream;

import id.go.ojk.client.MainApplication;
import id.go.ojk.client.constant.ClientConstant;
import id.go.ojk.client.constant.EReport;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.SubmissionMetadata;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.module.FactoryReadDirectoryImpl;
import id.go.ojk.client.service.base.BaseService;
import id.go.ojk.client.service.encryption.EncryptionService;
import id.go.ojk.client.service.ftp.FtpService;
import id.go.ojk.client.service.security.SecurityService;
import id.go.ojk.client.service.validation.MetadataService;
import id.go.ojk.client.service.validation.MetadataService.MetadataType;
import id.go.ojk.client.service.validation.ValidationService;
import id.go.ojk.client.util.AlertUtil;
import id.go.ojk.client.validation.BaseReadDirectory;
import id.go.ojk.client.vc.ReadSubmissionDirController.ReadSubmissionDirModel;
import id.go.ojk.lib.client.DateUtil;
import id.go.ojk.lib.client.HttpUtil;
import id.go.ojk.lib.client.TimeCounter;
import id.go.ojk.lib.client.exception.SlikException;
import id.go.ojk.lib.client.model.bind.SendingModel;
import id.go.ojk.lib.client.model.bind.StatusCallback;
import id.go.ojk.lib.client.model.security.User;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import id.go.ojk.lib.client.service.context.ApplicationContext;
import javafx.application.Platform;
import javafx.scene.control.Alert.AlertType;

public class SubmissionService extends BaseService {
    private final Logger logger = LoggerFactory.getLogger(SubmissionService.class);
    private final ProgressPreparationAndSending progressModel = new ProgressPreparationAndSending(null, true);
    private Thread thread;
    private MetadataType metadataType;
    private SubmissionMetadata metadata;

    public SubmissionService(MetadataType metadataType) {
        this.metadataType = metadataType;
        progressModel.setSummary(MetadataType.normal != metadataType);
    }

    private SetupService setupService;
    private EncryptionService encryptionService;
    private ConfigService configService;
    private static SecurityService securityService;
    private ValidationService validationService;
    private FtpService ftpService;
    private MetadataService metadataService;
    private HttpService httpService;
    private ApplicationUpdateService applicationUpdateService;
    private MainApplication mainApplication;

    private static int reportFormGroupCode;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        super.setApplicationContext(applicationContext);
        setupService = appContext.getService(SetupService.class);
        encryptionService = appContext.getService(EncryptionService.class);
        configService = appContext.getService(ConfigService.class);
        securityService = appContext.getService(SecurityService.class);
        validationService = appContext.getService(ValidationService.class);
        ftpService = appContext.getService(FtpService.class);
        metadataService = appContext.getService(MetadataService.class);
        httpService = appContext.getService(HttpService.class);
        applicationUpdateService = appContext.getService(ApplicationUpdateService.class);
        mainApplication = appContext.getService(MainApplication.class);
    }

    public ProgressPreparationAndSending getProgressModel() {
        return progressModel;
    }

    public void reset() {
        progressModel.reset();
    }

    public List<ValidationError> readDirectory(File submissionDir, ReadSubmissionDirModel readDirModel,
                                               int reportFormGroupCode) {
        return null;
    }

    public ValidationError processSubmission() {
        if (progressModel.inProcessProperty().get()) {
            return new ValidationError(null, ValidationErrorCode.E02_00_ENTITYTYPE_CODE);
        }
        if (!progressModel.readyToProcessProperty().get()) {
            return new ValidationError(null, ValidationErrorCode.E01_01_DATA_NOT_READY);
        }

        progressModel.setInProcess(true);
        progressModel.setReadyToProcess(false);
        thread = new Thread(() -> processSubmissionThread());
        thread.start();
        return null;
    }

    // RBB Version
    public List<ValidationError> readDirectoryReport(File submissionDir, ReadSubmissionDirModel readDirModel,
                                                     int reportMenuCode) {
        SubmissionService.reportFormGroupCode = reportMenuCode;
        String reportCode = securityService.getUserSession().getReportCode();
        BaseReadDirectory res = FactoryReadDirectoryImpl.getImpl(reportCode);
        if (res != null) {
            res.setMainProgress(progressModel);
            res.setMemberCode(setupService.getMemberCode());
            res.setMemberTypeCode(getMemberTypeCode(reportCode));
            res.setReadDirModel(readDirModel);
            res.setReportInfo(reportCode, reportMenuCode);
            res.setRunOnClient(true);
            res.setSubmissionDir(submissionDir);
            return res.readDirectory();
        } else {
            AlertUtil.showAlertSafe(AlertType.ERROR, "Kesalahan", "Kesalahan", "");
            return new ArrayList<>();
        }
    }

    private String getMemberTypeCode(String reportCode) {
        String res = setupService.getMemberTypeCode();
        if (res.equals(ClientConstant.KONVENSIONAL) && EReport.isUus(reportCode)) {
            res = ClientConstant.UUS;
        }
        return res;
    }

    private void processSubmissionThread() {
        try {
            if (securityService.isOnlineLogin() && !securityService.useApi()) {
                try {
                    // check future time
                    Map<String, Object> futureDateCheck = httpService.validateFutureDate(
                            progressModel.getSubmissionData().getDataYearMonthInt().toYYYYMM(),
                            DateUtil.dateTimeFormatter.format(LocalDateTime.now()));
                    if (!HttpUtil.isSuccessResponse(futureDateCheck)) {
                        AlertUtil.showAlertSafe(AlertType.ERROR, "Kesalahan", "Kesalahan",
                                HttpUtil.getErrorMessage(futureDateCheck));
                        return;
                    }

                    // ~ cek versi
                    Map<String, Map<String, Object>> versionCheck = applicationUpdateService.cekVersion(true);

                    if (applicationUpdateService.isNeedUpdate(versionCheck)) {
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                AlertUtil.showAlert(AlertType.INFORMATION, "Update Versi",
                                        "Aplikasi client memerlukan update.\n Setelah update selesai, ulangi proses buka direktori.");
                                mainApplication.forceUpdateApplication(versionCheck);
                            }
                        });
                        return;
                    }

                } catch (Exception e) {
                    AlertUtil.showErrorSafe(logger, "Gagal cek versi aplikasi!", e);
                    return;
                }
            }

            // ~ preparation

            TimeCounter timeCounter = new TimeCounter();
            String reportCode = securityService.getUserSession().getReportCode();
            String submissionId = reportCode + "." + setupService.getMemberTypeCode() + "." + setupService.getMemberCode() + "."
                    + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));

            File processDir = new File(
                    configService.getProperties(ConfigService.submissionProcessDir) + "/" + submissionId);
            File finishedDir = new File(
                    configService.getProperties(ConfigService.submissionDoneDir) + "/" + submissionId);

            User user = securityService.getUserSession().getUser();
            // progressModel.setUserId((user.isOnlineUser() ? "" : "o-") +
            // user.getUserLoginId());
            progressModel.setUserId(user.getUserLoginId());
            progressModel.setSubmissionId(submissionId);

            progressModel.setProcessDir(processDir);
            progressModel.setFinishedDir(finishedDir);

            progressModel.startProcess();
            progressModel.writeProcessLog(String.format("Mulai submissioId %1$s, direktori proses %2$s",
                    progressModel.getSubmissionId(), progressModel.getProcessDir().getAbsolutePath()), false);

            // ~ validation

            progressModel.getValidationProgressModel().updateStatus(StatusCallback.start);
            SubmissionFormat.modalInti.clear();
            SubmissionFormat.mapPosValue.clear();
            SubmissionFormat.noSurat.clear();
            SubmissionFormat.listRincianKantor.clear();

            // mulai validasi FILE LAMPIRAN TXT DAN PDF
            validationService.validate(progressModel, reportFormGroupCode);
            progressModel.setJenisPelaporan("0" + reportFormGroupCode);
            if (cekShowDialogStop())
                return;

            progressModel.getValidationProgressModel().setProgress(1);

            if (progressModel.getTotalError() > 0) {
                progressModel.getValidationProgressModel().setShowDir(true);
                progressModel.getValidationProgressModel().updateStatus(StatusCallback.error);
                return;
            } else {
                progressModel.getValidationProgressModel().updateStatus(StatusCallback.success);
            }

            // ~ compression and encryption

            encryptionService.compressAndEncrypt(progressModel);
            if (cekShowDialogStop())
                return;

            progressModel.getArchiveProgressModel().setShowDir(true);

            progressModel.writeProcessLog(String.format(
                    "Total baca direktori, validasi, kompresi, enkripsi dan pembentukan file kirim selesai dalam %1$s",
                    timeCounter.getTimeElapseFormated(progressModel.getReadDirectoryTimeElapse())), true);

            // ~ sending

            SendingModel sendingModel = progressModel.preparaSending();
            sendingModel.setLoginID(user.getUserLoginId());

            if (progressModel.isSendFile()) {
                sendingModel.getProgressModel().setProgress(0.001);
            }

            if (progressModel.isSendFile()) {
                sendingModel.getProgressModel().updateStatus(StatusCallback.start);
                boolean uploadStatus = false;
                if (securityService.useApi()) {
                    ServiceUpload serviceUpload = new ServiceUpload();
                    try {
                        uploadStatus = serviceUpload.uploadReport(sendingModel, reportFormGroupCode);
                    } catch (SlikException e) {
                        throw e;
                    }
                } else {
                    uploadStatus = uploadFtp(sendingModel);
                }
                // if (ftpService.upload(sendingModel, false)) {
                if (uploadStatus) {
                    progressModel.getArchiveProgressModel().setShowDir(false);
                    sendingModel.setSendingSuccess(true);
                    sendingModel.getProgressModel().updateStatus(StatusCallback.success);
                    AlertUtil.showAlertSafe(AlertType.INFORMATION,
                            getMessage(messageConfig_prepAndSendFileSuccess_title),
                            getMessage(messageConfig_prepAndSendFileSuccess_header),
                            getMessage(messageConfig_prepAndSendFileSuccess));
                } else {
                    sendingModel.getProgressModel().updateStatus(StatusCallback.error);
                    AlertUtil.showAlertSafe(AlertType.INFORMATION, getMessage(messageConfig_prepOkAndSendFailed_title),
                            getMessage(messageConfig_prepOkAndSendFailed_header),
                            getMessage(messageConfig_prepOkAndSendFailed));
                }
            } else if (!progressModel.isSendFile()) {
                AlertUtil.showAlertSafe(AlertType.INFORMATION, getMessage(messageConfig_prepFileSuccess_title),
                        getMessage(messageConfig_prepFileSuccess_header), getMessage(messageConfig_prepFileSuccess));
            } else {
                sendingModel.getProgressModel().updateStatus(StatusCallback.error);
                AlertUtil.showAlertSafe(AlertType.INFORMATION, getMessage(messageConfig_prepOkAndSendFailed_title),
                        getMessage(messageConfig_prepOkAndSendFailed_header),
                        getMessage(messageConfig_prepOkAndSendFailed));
            }

            if (cekShowDialogStop())
                return;

        } catch (Exception e) {
            AlertUtil.showErrorSafe(logger, null, e);
        } finally {
            progressModel.endProcess();
        }
    }

    private boolean uploadFtp(SendingModel sendingModel) {
        if (!ftpService.isLoginFTP("FTP01", false)) {
            return false;
        }
        Map<String, String> clientVersion = applicationUpdateService.getClientVersion();
        XStream xstream = applicationUpdateService.xStreamUpdateHeader();
        if (!ftpService.checkUpdate(clientVersion, xstream)) {
            sendingModel.getProgressModel().updateStatus(StatusCallback.error);
            return false;
        }
        return ftpService.uploadFTP(sendingModel, reportFormGroupCode);
    }

    public boolean cekShowDialogStop() {
        if (progressModel.isRequestStop()) {
            if (progressModel.getSlikException() != null) {
                throw progressModel.getSlikException();
            }
            if (progressModel.isAlertRequestStop()) {
                AlertUtil.showErrorSafe(logger, "Proses diberhentikan", null);
            }
        }
        return progressModel.isRequestStop();
    }

    public void requestStop() {
        progressModel.setRequestStop(true);
    }

    @Override
    public void initialize() {
        if (setupService.isClientTypeOJK()) {
            return;
        }
        try {
            this.metadata = metadataService.getSubmissionMetadata(metadataType);
            this.progressModel.setMetadata(metadata);
            this.progressModel.reset();
        } catch (NoSuchAlgorithmException | ArchiveException | IOException e) {
            logger.error("Fail initialize SubmissionService", e);
            throw new SlikException("Fail initialize SubmissionService", e);
        }
    }

    public SubmissionMetadata getMetadata() {
        return metadata;
    }

}