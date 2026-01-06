package id.go.ojk.client.vc;

import java.util.Map;

import id.go.ojk.client.MainApplication;
import id.go.ojk.client.service.ApplicationUpdateService;
import id.go.ojk.client.service.SetupService;
import id.go.ojk.client.service.security.SecurityService;
import id.go.ojk.client.util.AlertUtil;
import id.go.ojk.lib.client.model.constant.DisplayScene;
import id.go.ojk.lib.client.model.security.AuthenticationStatus;
import id.go.ojk.lib.client.model.security.User;
import id.go.ojk.lib.client.model.security.UserSession;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import lombok.Getter;

public class RootLayoutController extends BaseController {

	@FXML
	private ProgressIndicator busyProgressIndicator;
	@FXML
	private HBox busyPane;
	private final BooleanProperty busyProperty = new SimpleBooleanProperty();

	@FXML
	private AnchorPane topAnchorPane;
	@FXML
	private Label userLoginLabel;

	@FXML
	private TabPane menuTabPane;
	@FXML
	private Tab homeTab;
	@FXML
	public Tab otherTab;

	@FXML
	private Label connectionStatusLabel;

	@FXML
	private Button userProfileButton;
	@FXML
	private Tooltip userProfileToolTip;

	@Getter
	@FXML
	public MenuItem changePasswordMenuItem;

	@FXML
	private BorderPane rootBorderPane;

	public BorderPane getRootBorderPane() {
		return rootBorderPane;
	}

	private SetupService setupService;
	private SecurityService securityService;
	private ApplicationUpdateService applicationUpdateService;
	private MainApplication mainApplication;

	@FXML
	protected void initialize() {
		super.initialize();
		setupService = appCtx.getService(SetupService.class);
		securityService = appCtx.getService(SecurityService.class);
		applicationUpdateService = appCtx.getService(ApplicationUpdateService.class);
		mainApplication = appCtx.getService(MainApplication.class);

		busyPane.visibleProperty().bindBidirectional(busyProperty);
		topAnchorPane.visibleProperty().bindBidirectional(securityService.getUserLoginModel().isLoginProperty);
		initializeTabIcon();

		userLoginLabel.textProperty().bind(securityService.getUserLoginModel().userNameProperty);

		if (setupService.isClientTypeOJK()) {
			changePasswordMenuItem.setVisible(false);
		}

	}

	private void initializeTabIcon() {
	}

	@FXML
	private void handleUserProfileClick() {
	}

	// ~ Event handler

	@FXML
	private void handleUserOfflineManagement() {
		mainApplication.showUserManagement();
		mainApplication.synchMenuToRealDisplay();
	}

	@FXML
	private void handleApplicationSetting() {
		mainApplication.showApplicationSettingDialog();
	}

	@FXML
	private void handleAbout() {
		mainApplication.showAboutDialog();
	}

	@FXML
	private void handleHelp() {
		mainApplication.showHelpDialog();
	}

	@FXML
	private void handleFAQ() {
		mainApplication.showFAQDialog();
	}

	@FXML
	private void handleUpdateOnline() {
		try {
			Map<String, Map<String, Object>> cekVersion = applicationUpdateService.cekVersion();
			mainApplication.showUpdateOnlineDialog();
		} catch (Exception e) {
			AlertUtil.showErrorSafe(logger, "", e);
		}
	}

	@FXML
	private void handleUpdateOffline() {
		mainApplication.showUpdateOfflineDialog();
	}

	@FXML
	private void handleMainMenu() {
		if (appCtx == null)
			return;
		DisplayScene displayScene = mainApplication.getDisplayScene();
		if (displayScene == null || homeTab.isSelected()) {
			if (securityService.isLogin()) {
				mainApplication.getCustomForm().showHome(securityService.getUserSession());
			} else {
				mainApplication.showHomeNotLogin();
			}
		} else {
			switch (displayScene) {
			case preparationAndSending:
				mainApplication.showSendingAndPreparation();
				break;
			case sending:
				mainApplication.showSending();
				break;
			case summaryData:
				mainApplication.showSummaryData();
				break;
			case openErrorFile:
				mainApplication.showOpenErrorFile();
				break;
			case openMasterData:
				mainApplication.showOpenMasterData();
				break;
			case userOfflineManagement:
				mainApplication.showUserManagement();
				break;
//			case pelaporanPreparationRbb:
//				mainApplication.getCustomForm().getFormRbb().showPelaporanData();
//				break;
//			case perubahanPreparationRbb:
//				mainApplication.getCustomForm().getFormRbb().showPelaporanData();
//				break;
//			case penyesuaianPreparationRbb:
//				mainApplication.getCustomForm().getFormRbb().showPelaporanData();
//				break;
//			case realisasiPreparationRbb:
//				mainApplication.getCustomForm().getFormRbb().showRealisasiData();
//				break;
//			case pengawasanPreparationRbb:
//				mainApplication.getCustomForm().getFormRbb().showPengawasanData();
//				break;
//			case rutinPreparationLb:
//				mainApplication.getCustomForm().getFormLb().showPelaporan();
//				break;
//			case perubahanPreparationLb:
//				mainApplication.getCustomForm().getFormLb().showPerubahan();
//				break;
//			case penyesuaianPreparationLb:
//				mainApplication.getCustomForm().getFormLb().showPenyesuaian();
//				break;
//			case penyesuaianKapPreparationLb:
//				mainApplication.getCustomForm().getFormLb().showPenyesuaianKap();
//				break;
//			case pelaporanPreparationSa:
//				mainApplication.getCustomForm().getFormSa().showPelaporan();
//				break;
//			case pelaporanKoreksiPreparationSa:
//				mainApplication.getCustomForm().getFormSa().showPelaporanKoreksi();
//				break;
//			case pengkinianPreparationSa:
//				mainApplication.getCustomForm().getFormSa().showPengkinian();
//				break;
//			case pengkinianKoreksiPreparationSa:
//				mainApplication.getCustomForm().getFormSa().showPengkinianKoreksi();
//				break;
			default:
				mainApplication.getCustomForm().handleMainMenu();
				break;
			}
		}
	}

	@FXML
	private void handleLogout() {
		mainApplication.userLogout();
	}

	@FXML
	private void handleChangePassword() {
	  if(securityService.useApi()) {
	    AlertUtil.showAlert(AlertType.INFORMATION, "Ubah Password", "Petunjuk Perubahan Password", securityService.getChangePasswordInstruction());
	  } else {
	    mainApplication.showChangePasswordDialog();
	  }
	}

	// ~ Other

	public void synchMenuToRealDisplay(DisplayScene displayScene) {
		if (displayScene == null) {
			menuTabPane.getSelectionModel().select(homeTab);
			return;
		}
		switch (displayScene) {
		case homeNotLogin:
		case home:
			menuTabPane.getSelectionModel().select(homeTab);
			break;
		case sending:
		case summaryData:
		case openErrorFile:
		case openMasterData:
		case userOfflineManagement:
		case preparationAndSending:
			syncTab(displayScene);
			break;
		default:
			if (DisplayScene.isCustom(displayScene)) {
				syncTab(displayScene);
			} else {
				menuTabPane.getSelectionModel().select(homeTab);
			}
			break;
		}
	}
	
	private void syncTab(DisplayScene displayScene) {
		if (menuTabPane.getTabs().size() == 1) {
			menuTabPane.getTabs().add(otherTab);
		}
		menuTabPane.getSelectionModel().select(otherTab);
		otherTab.setText(displayScene.getName());
	}

	public void setBusy(boolean value) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				busyProperty.set(value);
			}
		});
	}

	public void logout() {
		menuTabPane.getTabs().remove(otherTab);
		menuTabPane.getSelectionModel().select(homeTab);
		otherTab.setText("");
		otherTab.setDisable(true);
	}

	public void loginSuccess(UserSession userSession) {
		User user = userSession.getUser();
		otherTab.setText("");
		otherTab.setDisable(false);
		logger.info("User " + user.getUserLoginId() + " logged!!!");
		// updateConnectionStatus(userSession.getAuthenticationStatus() ==
		// AuthenticationStatus.onlineAuthenticate);
		if (userSession.getAuthenticationStatus() == AuthenticationStatus.onlineAuthenticate) {
			updateConnectionStatus(true);
//		} else if (ftpService.isLoginFTP(false)) {
		} else if (userSession.getFtpLogin() && !securityService.useApi()) {
			updateConnectionStatus(true);
		} else {
			updateConnectionStatus(false);
		}
	}

	public void updateConnectionStatus(Boolean connectionStatus) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				if (connectionStatus == null) {
					connectionStatusLabel.setText("...");
				} else if (connectionStatus) {
					connectionStatusLabel.setText("Terhubung");
				} else {
					connectionStatusLabel.setText("Tidak Terhubung");
				}

			}
		});
	}

}
