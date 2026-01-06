package id.go.ojk.client.vc;

import id.go.ojk.client.MainApplication;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.client.service.SetupService;
import id.go.ojk.client.service.ftp.FtpService;
import id.go.ojk.lib.client.model.security.User;
import id.go.ojk.lib.client.model.security.UserSession;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class HomeMetroController extends BaseController {

	@FXML private Button submissionButton;
	@FXML private Button submissionButton1;
	@FXML private Button submissionButton2;
	@FXML private Button sendingButton;	
	@FXML private Button summarySubmissionButton;
	@FXML private Button openErrorFileButton;
	
	@FXML private Button openMasterDataButton;
	@FXML private Button webSlikButton;

	@FXML private Button helpButton;
	@FXML private Button faqButton;

	@FXML private Button userOfflineMaintenanceMenu;
	@FXML private Button applicationSettingButton;
	@FXML private Button updateOnline;
	@FXML private Button updateOffline;
	
	@FXML private Label userNameLabel;
	@FXML private Label userRole;
	@FXML private Label memberNameLabel;
	@FXML private Label memberTypeLabel;

	@FXML private ImageView onlineImage;
	@FXML private ImageView offlineImage;
	
//	@FXML private Pane separatorPane1;
	@FXML private Pane separatorPane2;
	@FXML private Pane separatorPane3;
	
	@FXML private ScrollPane scrollPane;
	@FXML private VBox centerVbox;
	@FXML private ImageView submissionImage;
	@FXML private ImageView submissionImage1;
	@FXML private ImageView submissionImage2;
//	@FXML private ImageView openMasterDataImage;
	@FXML private ImageView helpImage;
	@FXML private ImageView userInfoImage;
	@FXML private AnchorPane userInfoPane;
	
	@FXML private ImageView sendingImage;
	@FXML private ImageView summarySubmissionImage;
	@FXML private ImageView slikWebImage;
	@FXML private ImageView faqImage;
	@FXML private ImageView userManagementImage;
	@FXML private ImageView applicationSettingImage;

	@FXML private ImageView openErrorFileImage;
	@FXML private ImageView updateOnlineImage;
	@FXML private ImageView updateOfflineImage;

	@FXML private VBox userLoginVbox; //(89, 12)
	@FXML private VBox memberLoginVbox; //(18, 14)
	
	@FXML private BorderPane mainBorderPane;
	
	@FXML private Label ojkHomeNameLabel;
	@FXML private Label ojkAddressLabel;
	@FXML private Label phoneLabel;
	@FXML private Label faxLabel;
	@FXML private Label emailLabel;

	private SetupService setupService;
	private ReferenceService referenceService;
	private MainApplication mainApplication;
	private FtpService ftpService;
	
	@FXML
	protected void initialize() {
		super.initialize();
		this.setupService = appCtx.getService(SetupService.class);
		this.referenceService = appCtx.getService(ReferenceService.class);
		this.mainApplication = appCtx.getService(MainApplication.class);
		this.ftpService = appCtx.getService(FtpService.class);
				
		scrollPane.viewportBoundsProperty().addListener(new ChangeListener<Bounds>() {
			public void changed(ObservableValue<? extends Bounds> observable, Bounds oldValue, Bounds newValue) {
				
				double newValueDouble = newValue.getWidth();
				centerVbox.setPrefWidth(newValueDouble);
				centerVbox.setMinWidth(newValueDouble);
				centerVbox.setMaxWidth(newValueDouble);
				
				double with = (newValueDouble - ((5*9)))/(double)22 ;
				
				double viewportHeight = scrollPane.getViewportBounds().getHeight();
				double otherHeight = 20 + 30 + (4 * 5) + 80 + 20;
				double calculateHeight = otherHeight + (with * 3 * 3);				
				if ( calculateHeight > viewportHeight ){
					with = (viewportHeight - otherHeight)/(3 * 3); 
				}
				
				setImageFitSize(submissionImage, with*3, 2, 5);
				setImageFitSize(submissionImage1, with*3, 1, 0);
				setImageFitSize(submissionImage2, with*3, 1, 0);
				setImageFitSize(summarySubmissionImage, with*3, 1, 0);
//				setImageFitSize(openMasterDataImage, with*3, 1, 0);
				setImageFitSize(helpImage, with*3, 1, 0);
				
				setImageFitSize(userInfoImage, with*3, 2, 5);
				setRegionSize(userInfoPane, with*3, 2, 6);

				double heightUserInfo = with*3;
				double withUserInfo = heightUserInfo * 2;
				AnchorPane.setLeftAnchor(userLoginVbox, (withUserInfo/10d) * 3);
				AnchorPane.setTopAnchor(userLoginVbox, (heightUserInfo/10d));
				
				AnchorPane.setLeftAnchor(memberLoginVbox, (withUserInfo/10d));
				AnchorPane.setBottomAnchor(memberLoginVbox, (heightUserInfo/10d));
				
				setImageFitSize(sendingImage, with*3, 2, 5);
				setImageFitSize(slikWebImage, with * 3, 2, 5);
				setImageFitSize(faqImage, with*3, 1, 0);
				setImageFitSize(userManagementImage, with*3, 1, 0);
				setImageFitSize(applicationSettingImage, with*3, 1, 0);

				setImageFitSize(openErrorFileImage, with*3, 1, 0);
				setImageFitSize(updateOnlineImage, with*3, 1, 0);
				setImageFitSize(updateOfflineImage, with*3, 1, 0);
				
//				setRegionSize(separatorPane1, with, 1, 0);
//				setRegionSize(separatorPane2, with, 1, 0);
//				setRegionSize(separatorPane3, with, 1, 0);
			}
		});
			
		ojkHomeNameLabel.setText(referenceService.getMessage(ReferenceService.messageConfig_ojkHomeName, null));
		ojkAddressLabel.setText(referenceService.getMessage(ReferenceService.messageConfig_ojkAddress, null));
		phoneLabel.setText(referenceService.getMessage(ReferenceService.messageConfig_ojkPhone, null));
		faxLabel.setText(referenceService.getMessage(ReferenceService.messageConfig_ojkFax, null));
		emailLabel.setText(referenceService.getMessage(ReferenceService.messageConfig_ojkEmail, null));
		
		logout();
	}
	
	private void setImageFitSize(ImageView imageView, double height, double withRasio, double withCorrection){
		imageView.setFitHeight(height);
		imageView.setFitWidth((height * withRasio) + withCorrection);
	}
	
	private void setRegionSize(Region region, double height, double withRasio, double withCorrection){		
		region.setPrefHeight(height);
		region.setMinHeight(height);
		region.setMaxHeight(height);
		
		double with = (height * withRasio) + withCorrection;
		region.setPrefWidth(with);
		region.setMinWidth(with);
		region.setMaxWidth(with);
	}

	@FXML
	public void handleSubmission(){
		mainApplication.showSendingAndPreparation();
		mainApplication.synchMenuToRealDisplay();
	}
	
	@FXML
	public void handlePelaporanRB(){
		mainApplication.getCustomForm().getFormRbb().showPelaporanData();
		mainApplication.synchMenuToRealDisplay();
	}
	
	@FXML
	public void handlePerubahanRB(){
		mainApplication.getCustomForm().getFormRbb().showPelaporanData();
		mainApplication.synchMenuToRealDisplay();
	}
	
	@FXML
	public void handlePenyesuaianRB(){
		mainApplication.getCustomForm().getFormRbb().showPelaporanData();
		mainApplication.synchMenuToRealDisplay();
	}
	
	@FXML
	public void handleRealisasiRB(){
		mainApplication.getCustomForm().getFormRbb().showRealisasiData();
		mainApplication.synchMenuToRealDisplay();
	}

	@FXML
	public void handleSending(){
		mainApplication.showSending();
		mainApplication.synchMenuToRealDisplay();
	}

	@FXML
	public void handleSummarySubmission(){
		mainApplication.showSummaryData();
		mainApplication.synchMenuToRealDisplay();
	}

	@FXML
	public void handleOpenErrorFile(){
		mainApplication.showOpenErrorFile();
		mainApplication.synchMenuToRealDisplay();
	}

	@FXML
	public void handleOpenMasterData(){
		mainApplication.showOpenMasterData();
		mainApplication.synchMenuToRealDisplay();
	}

	@FXML
	public void handleWebSlik(){
		mainApplication.showWebSlik();
	}

	@FXML
	public void handleHelp(){
//		mainApplication.showHelpDialog();
		mainApplication.showManual();
	}

	@FXML
	public void handleFAQ(){
//		mainApplication.showFAQDialog();
		mainApplication.showFaqApolo();
	}

	@FXML
	public void handleUserOfflineMaintenance(){
		mainApplication.showUserManagement();
		mainApplication.synchMenuToRealDisplay();
	}
	
	@FXML
	public void handleApplicationSetting(){
		mainApplication.showApplicationSettingDialog();
	}
	
	// Test Cangkang
	@FXML
	public void handleReportPreparationDialog() {
		mainApplication.showReportPreparationDialog();
	}

	@FXML
	public void handleUpdateOnline(){
		mainApplication.showUpdateOnlineDialog();
	}

	@FXML
	public void handleUpdateOffline(){
		mainApplication.showUpdateOfflineDialog();
	}

	public void logout(){
		reset();	
	}	
	
	public void synchSummaryMenu(){
		boolean isAllowSendSummary = setupService.isAllowSendSummary();
		if ( isAllowSendSummary )
			summarySubmissionButton.setDisable(false);
		else 
			summarySubmissionButton.setDisable(true);
	}


	public void loginSuccess(UserSession userSession){
		//boolean isAllowSendSummary = setupService.isAllowSendSummary();
		User user = userSession.getUser();
		
		userNameLabel.setText(user.getUserName());
		userRole.setText(user.getRole().getDescription());
		memberNameLabel.setText(setupService.getMemberName());
		memberTypeLabel.setText(setupService.getMemberTypeName());
//		if (userSession.isOnline()){
//		if (ftpService.isLoginFTP(false)) {
		if (userSession.getFtpLogin().booleanValue() || userSession.isOnline()) {
			onlineImage.setVisible(true);			
		} else {
			offlineImage.setVisible(true);			
		}

		
		switch (user.getRole()) {
		case ljkOnline:
			submissionButton.setDisable(false);
			if( userSession.isOnline() )
				sendingButton.setDisable(false);	
			synchSummaryMenu();
			
			openErrorFileButton.setDisable(false);
			
			openMasterDataButton.setDisable(false);

			userOfflineMaintenanceMenu.setDisable(false);
			if( userSession.isOnline() )
				updateOnline.setDisable(false);
			break;
		case ljkOffline:
			submissionButton.setDisable(false);
			updateOnline.setDisable(false); // enable
			sendingButton.setDisable(false); // enable
			synchSummaryMenu();
			
			openErrorFileButton.setDisable(false);
			
			openMasterDataButton.setDisable(false);
			break;
		case ojk:
			sendingButton.setDisable(false);;	
			updateOnline.setDisable(false);
			updateOffline.setDisable(true);
			
			openErrorFileButton.setDisable(false);
			
			openMasterDataButton.setDisable(false);
			break;
		default:
			break;
		}
	}

	@Override
	public void reset(){
		submissionButton.setDisable(true);
		sendingButton.setDisable(true);;	
		summarySubmissionButton.setDisable(true);
		openErrorFileButton.setDisable(true);
		
		openMasterDataButton.setDisable(true);

		userOfflineMaintenanceMenu.setDisable(true);
		updateOnline.setDisable(true);
		
		userNameLabel.setText("");
		userRole.setText("");
		memberNameLabel.setText("");
		memberTypeLabel.setText("");
		onlineImage.setVisible(false);
		offlineImage.setVisible(false);
	}
	
	@Override
	public boolean isReused(){
		return true;
	}

}
