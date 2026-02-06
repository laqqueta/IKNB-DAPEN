package id.go.ojk.client.vc;

import static id.go.ojk.lib.client.model.constant.SignatureConstant.sigKey_dataYearMonth;
import static id.go.ojk.lib.client.model.constant.SignatureConstant.sigKey_jenisPelaporan;
import static id.go.ojk.lib.client.model.constant.SignatureConstant.sigKey_memberCode;
import static id.go.ojk.lib.client.model.constant.SignatureConstant.sigKey_memberType;
import static id.go.ojk.lib.client.model.constant.SignatureConstant.sigKey_submissionFTP;
import static id.go.ojk.lib.client.model.constant.SignatureConstant.sigKey_submissionID;
import static id.go.ojk.lib.client.model.constant.SignatureConstant.sigKey_submissionTime;
import static id.go.ojk.lib.client.model.constant.SignatureConstant.sigKey_userID;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.XStream;

import id.go.ojk.client.MainApplication;
import id.go.ojk.client.service.ApplicationUpdateService;
import id.go.ojk.client.service.ConfigService;
import id.go.ojk.client.service.HttpService;
import id.go.ojk.client.service.ServiceUpload;
import id.go.ojk.client.service.SetupService;
import id.go.ojk.client.service.ftp.FtpService;
import id.go.ojk.client.service.impl.ReferenceServiceClient;
import id.go.ojk.client.service.security.SecurityService;
import id.go.ojk.client.util.AlertUtil;
import id.go.ojk.client.util.UtilDialog;
import id.go.ojk.lib.client.CollectionUtil;
import id.go.ojk.lib.client.DateUtil;
import id.go.ojk.lib.client.model.YearMonth;
import id.go.ojk.lib.client.model.bind.ProgressModel;
import id.go.ojk.lib.client.model.bind.SendingModel;
import id.go.ojk.lib.client.model.bind.StatusCallback;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.lib.client.model.security.User;
import id.go.ojk.lib.client.util.fx.JfxUtil;
import id.go.ojk.lib.client.util.fx.ProgressUtil;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.util.StringConverter;

public class SendingController extends BaseController {

	@FXML private ImageView readyfileimage;
	@FXML private TextField readyDirectoryTextField;
	@FXML private Button browseButton;
	@FXML private Button readFolderButton;

	@FXML private VBox logProcessVbox;

	@FXML private Label progressLabelBar;
	@FXML private ProgressBar progressBar;
	@FXML private Pane progressStatusPane;
	@FXML private Hyperlink sendingDirLink;

	@FXML private Button sendButton;
	@FXML private Button stopButton;

	@FXML private VBox readyToSendVbox;
	@FXML private VBox readyToSendFileVbox;

	@FXML private GridPane signaturePane;
	@FXML private Button checkSignatureButton;

	@FXML private Label submissionIDLabel;
	@FXML private Label userIdLabel;
	@FXML private Label entityTypeLabel;
	@FXML private Label entityLabel;
	@FXML private Label yearMonthReport;
	@FXML private Label submissionTime;
	
	@FXML private VBox mainVbox;
	@FXML private GridPane memberRefGridPane;
	@FXML private TextField memberRefNumberField;
	@FXML private DatePicker memberRefDateField;
	@FXML private ComboBox<String> offlineUploadReasonCombo;
	@FXML private HBox checkSignatureVbox;
	
	private SetupService setupService;
	private ConfigService configService;
	private FtpService ftpService;
	private HttpService httpService;
	private SecurityService securityService;
	private MainApplication mainApplication;
	private ReferenceServiceClient referenceServiceClient;
	private ApplicationUpdateService applicationUpdateService;

	volatile private SendingModel sendingModel;

	@FXML
	protected void initialize() {
		super.initialize();
		
		setupService = appCtx.getService(SetupService.class);
		configService = appCtx.getService(ConfigService.class);
		ftpService = appCtx.getService(FtpService.class);
		httpService = appCtx.getService(HttpService.class);
		securityService = appCtx.getService(SecurityService.class);
		mainApplication = appCtx.getService(MainApplication.class);
		referenceServiceClient = appCtx.getService(ReferenceServiceClient.class);
		applicationUpdateService = appCtx.getService(ApplicationUpdateService.class);

		if ( setupService.isClientTypeOJK() ){
			initDatePickerFormat();
			initOfflineReasonOption();			
		}
		
		sendingModel = new SendingModel(
			new ProgressModel(""){

			@Override
			public void writeProcessLog(String message, boolean showOnScreen) {
				super.writeProcessLog(message, showOnScreen);
			};
						
		});
		bindProperty();
	}
	
	private void initOfflineReasonOption(){
		Map<String, String> map = referenceServiceClient.getOnlineReference(ReferenceMetadata.R99001OfflineUploadReason.getName());
		for (Entry<String, String> entry : map.entrySet()) {
			offlineUploadReasonCombo.getItems().add(entry.getKey() + "-" + entry.getValue());
		}
	}
	
	private void initDatePickerFormat(){
		String pattern = "dd-MM-yyyy";
		StringConverter<LocalDate> converter = new StringConverter<LocalDate>() {
	            DateTimeFormatter dateFormatter = 
	                DateTimeFormatter.ofPattern(pattern);
	            @Override
	            public String toString(LocalDate date) {
	                if (date != null) {
	                    return dateFormatter.format(date);
	                } else {
	                    return "";
	                }
	            }
	            @Override
	            public LocalDate fromString(String string) {
	                if (string != null && !string.isEmpty()) {
	                    return LocalDate.parse(string, dateFormatter);
	                } else {
	                    return null;
	                }
	            }
		};             
		memberRefDateField.setConverter(converter);
		memberRefDateField.setPromptText(pattern.toLowerCase());
	}

	private void bindProperty(){
		readyDirectoryTextField.setText(configService.getProperties(ConfigService.sendindSourceDir));

		readyDirectoryTextField.disableProperty().bind(sendingModel.getProgressModel().onProcessProperty());
		browseButton.disableProperty().bind(sendingModel.getProgressModel().onProcessProperty());
		readFolderButton.disableProperty().bind(sendingModel.getProgressModel().onProcessProperty());

		sendButton.disableProperty().bind(sendingModel.signatureValidProperty().not().or(sendingModel.getProgressModel().onProcessProperty()).or( sendingModel.sendingSuccessProperty() ));
		stopButton.disableProperty().bind(sendingModel.getProgressModel().onProcessProperty().not());

		readyToSendVbox.visibleProperty().bind(sendingModel.readFileProperty());
		signaturePane.visibleProperty().bind(sendingModel.signatureValidProperty());

		logProcessVbox.getChildren().clear();
		sendingModel.getProgressModel().setLogProcessVbox(logProcessVbox);

		sendingModel.sendingSuccessProperty().bindBidirectional(sendingModel.getProgressModel().showDirProperty());
		ProgressUtil.bindProgressModel(sendingModel.getProgressModel(), progressStatusPane, progressLabelBar, progressBar, sendingDirLink);
		sendingDirLink.setOnAction( e -> JfxUtil.openDir(sendingModel.getTransferedDir()));
	}

	@FXML
	private void handleBrowse(){
    	DirectoryChooser directoryChooser = new DirectoryChooser();
    	File sourceDir = new File(readyDirectoryTextField.getText());
    	if( sourceDir.exists() && sourceDir.isDirectory() )
    		directoryChooser.setInitialDirectory(sourceDir);
    	sourceDir = directoryChooser.showDialog(mainApplication.getPrimaryStage());
    	if ( sourceDir != null ) {    		
    		readyDirectoryTextField.setText(sourceDir.getAbsolutePath());
    		handleOpen();
    	}
	}

	@FXML
	private void handleOpen(){
		//offlineUploadReasonCombo.getSelectionModel().clearSelection();
		if ( securityService.isOjkLogin() ){
			memberRefGridPane.setVisible(true);
		} else {
			readyToSendVbox.getChildren().remove(memberRefGridPane);
		}
		
		User user = securityService.getUserSession().getUser();
		sendingModel.setLoginID(user.getUserLoginId());
		
		try {
			reset();
			sendingModel.setReadyToSendDir(new File(readyDirectoryTextField.getText()));
			List<String> errors = ftpService.readReadyToSend(sendingModel);
			if ( errors.size() > 0 ){
				AlertUtil.showErrorSafe("Error", errors.stream().collect(Collectors.joining("\n")));
			} else {
				
				addReadyToSendFileVbox(sendingModel.getSignatureFile());
				addReadyToSendFileVbox(sendingModel.getSignatureFileTxt());
				
				for (File file : sendingModel.getReadyToSendFiles()) {
					addReadyToSendFileVbox(file);
				}
				sendingModel.getProgressModel().setTotalLength(sendingModel.getTotalFileSize());
				configService.setPropertiesAndStore(ConfigService.sendindSourceDir, sendingModel.getReadyToSendDir().getAbsolutePath());
				//checkSignatureButton.setDisable(false);
				setDisableCekSignatureForm(false);
				resetCekSignatureForm();
			}
		} catch (Exception e){
			AlertUtil.showErrorSafe(logger, "Error saat membaca directory", e);
		}
	}
	
	private void addReadyToSendFileVbox(File file){
		HBox hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setAlignment(Pos.CENTER_LEFT);
		hBox.getChildren().addAll(
			new ImageView(new Image(MainApplication.class.getResourceAsStream("vc/images/FileIcon_18x25.png"))),
			new Label(file.getName())
		);
		readyToSendFileVbox.getChildren().add(hBox);
	}

	@FXML
	private void handleSend(){
		try {
			if (securityService.useLoginApi() && !securityService.getUserSession().hasOnlineSession()
					&& !UtilDialog.reLogin(securityService)) {
				AlertUtil.showAlert(AlertType.ERROR, "Kesalahan", "Kesalahan", "Login Gagal");
				return;
			}
			sendingModel.getProgressModel().updateStatus(StatusCallback.start);
			int jenisPelaporan = Integer.parseInt(sendingModel.getSignatureData().get(sigKey_jenisPelaporan));
			if (securityService.useSendApi()) {
				ServiceUpload serviceUpload = new ServiceUpload();
				serviceUpload.uploadReportAsync(sendingModel, jenisPelaporan);
				
			} else {
				ftpService.uploadAsync(sendingModel, jenisPelaporan);
			}
		} catch (Exception e) {
			AlertUtil.showErrorSafe(logger, "Error saat mengirim file", e);
		}
	}
	
	private void setDisableCekSignatureForm(boolean disable){
		checkSignatureButton.setDisable(disable);
		memberRefNumberField.setEditable(!disable);
		memberRefDateField.setEditable(!disable);
		//offlineUploadReasonCombo.setEditable(!disable);
		offlineUploadReasonCombo.setDisable(disable);
	}
	
	private void resetCekSignatureForm(){
		memberRefNumberField.setText("");
		memberRefDateField.setValue(null);
		offlineUploadReasonCombo.getSelectionModel().clearSelection();
	}

	@FXML
	private void handleCheckSignature(){
		String memberRefNumber = null;
		Date memberRefDate = null;
		String offlineUplReasonCode = null;
		if( securityService.isOjkLogin() ){
			memberRefNumber = memberRefNumberField.getText();
			LocalDate memberRefLocalDate = memberRefDateField.getValue();
			String offlineUploadReason = offlineUploadReasonCombo.getValue();
			List<String> errors = new ArrayList<>();
			if ( StringUtils.isEmpty(memberRefNumber) ){
				errors.add("Nomor Surat wajib diisi");
			}
			if ( memberRefNumber.length() > 150 ){
				errors.add("Nomor Surat maksimum 150 karakter");
			}
			
			if ( memberRefLocalDate == null ){
				errors.add("Tanggal Terima File wajib diisi");
			} else {
//				if ( memberRefLocalDate.isAfter(LocalDate.now()) ){
//					errors.add("Tanggal Terima File maksimal tanggal sekarang!");
//				}
			}
			
			if ( StringUtils.isEmpty(offlineUploadReason) ){
				errors.add("Alasan Upload Offline wajib diisi");
			}
			
			if ( CollectionUtil.isNotEmpty(errors) ){
				AlertUtil.showAlertError("Kesalahan", "Kesalahan", errors);
				return;
			}
			memberRefDate = DateUtil.toDate(memberRefLocalDate);
			offlineUplReasonCode = offlineUploadReason.split("-")[0]; 
		}
		sendingModel.setMemberRefNumber(memberRefNumber);
		sendingModel.setMemberRefDate(memberRefDate);
		sendingModel.setOfflineUplReasonCode(offlineUplReasonCode);
		
//		if (securityService.getUserSession().getFtpLogin()) {
			if (ftpService.readSignatureFile(sendingModel)) {
				setDisableCekSignatureForm(true);
				HashMap<String, String> signatureData = sendingModel.getSignatureData();				
				
				submissionIDLabel.setText(signatureData.get(sigKey_submissionFTP));
				userIdLabel.setText(signatureData.get(sigKey_userID));
				entityTypeLabel.setText(signatureData.get(sigKey_memberType));
				entityLabel.setText(signatureData.get(sigKey_memberCode));
				
				YearMonth yearMonth = YearMonth.from(signatureData.get(sigKey_dataYearMonth));
				yearMonthReport.setText(yearMonth.toYYYY_MM());
				submissionTime.setText(DateUtil.format2(signatureData.get(sigKey_submissionTime)));
				
				sendingModel.setSubmissionFTP(signatureData.get(sigKey_submissionFTP));
				sendingModel.setSubmissionId(signatureData.get(sigKey_submissionID));
				
				File transferedDir = new File(configService.getProperties(ConfigService.submissionDoneDir) + "/" + sendingModel.getSubmissionId() + "/terkirim");
				sendingModel.setTransferedDir(transferedDir);
				
				sendingModel.setSignatureValid(true);
				
				Map<String, String> clientVersion = ftpService.getClientVersion(sendingModel);
				XStream xstream = applicationUpdateService.xStreamUpdateHeader();
				
				String signReportCode = signatureData.get(sigKey_submissionID).split("[.]")[0];
				String sessReportCode = securityService.getUserSession().getReportCode();
				
				if(!signReportCode.equals(sessReportCode)) {
					AlertUtil.showErrorSafe(logger, "File kirim tidak sesuai!", null);
					return;
				}
				
				if ((!securityService.useSendApi() && !ftpService.checkUpdate(clientVersion, xstream)) || 
						(securityService.useSendApi() && !applicationUpdateService.validateVersion())) {
					return;
				}
				handleSend(); // Arnol modif : cek signature & langsung kirim
			} else {
				setDisableCekSignatureForm(false);
			}
//		} else {
//			setDisableCekSignatureForm(false);
//		}
		
//		try {
//			setDisableCekSignatureForm(true);
//			//checkSignatureButton.setDisable(true);
//			Map<String, Object> responseMap = ftpService.checkSignature(sendingModel);
//			if ( HttpUtil.isSuccessResponse(responseMap) ){
//				Map<String, String> payload = (Map<String, String>) responseMap.get("payload");
//				submissionIDLabel.setText(payload.get(sigKey_submissionID));
//				userIdLabel.setText(payload.get(sigKey_userID));
//				entityTypeLabel.setText(payload.get(sigKey_memberType));
//				entityLabel.setText(payload.get(sigKey_memberCode));
//				
//				YearMonth yearMonth = YearMonth.from(payload.get(sigKey_dataYearMonth));
//				yearMonthReport.setText(yearMonth.toYYYY_MM());
//				
//				submissionTime.setText(DateUtil.format2(payload.get(sigKey_submissionTime)) );
//				sendingModel.setSubmissionId(payload.get(sigKey_submissionID));
//
//				File transferedDir = new File(configService.getProperties(ConfigService.submissionDoneDir) + "/" + sendingModel.getSubmissionId() + "/terkirim");
//				sendingModel.setTransferedDir(transferedDir);
//
//				sendingModel.setSignatureValid(true);
//			} else {
//				//AlertUtil.showErrorSafe("Gagal cek signature : ", HttpUtil.getMessage(responseMap));
//				AlertUtil.showError("Gagal cek signature : \n" + HttpUtil.getMessage(responseMap), "");
//				setDisableCekSignatureForm(false);
//			}
//		} catch (Exception e) {
//			AlertUtil.showError(logger, "Gagal cek signature ke server", e);
//			setDisableCekSignatureForm(false);
//		}
	}

	@FXML
	private void handleStop(){
		if ( AlertUtil.confirmDialog("Konfirmasi pembatalan pengiriman.", "Konfirmasi pembatalan pengiriman.", "Apakah anda yakin untuk membatalkan pengiriman?") ){
			sendingModel.stopProcess();
		}
	}
	
	@Override
	public void reset(){
		logProcessVbox.getChildren().clear();
		sendingModel.reset(true);
		readyToSendFileVbox.getChildren().clear();
	}
	
	@Override
	public boolean isReused(){
		return true;
	}
	
	@Override
	public boolean isInProcess() {
		return sendingModel.getProgressModel().isOnProcess();
	}

}
