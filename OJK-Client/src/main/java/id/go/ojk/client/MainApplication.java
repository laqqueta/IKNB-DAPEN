package id.go.ojk.client;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import id.go.ojk.client.service.ApplicationUpdateService;
import id.go.ojk.client.service.ConfigService;
import id.go.ojk.client.service.PreStartService;
import id.go.ojk.client.service.SubmissionService;
import id.go.ojk.client.service.base.ApplicationContextAware;
import id.go.ojk.client.service.base.BaseService;
import id.go.ojk.client.service.context.ApplicationContextClient;
import id.go.ojk.client.service.security.SecurityService;
import id.go.ojk.client.undecorator.Undecorator;
import id.go.ojk.client.undecorator.UndecoratorScene;
import id.go.ojk.client.util.AlertUtil;
import id.go.ojk.client.util.UpdateRollBackUtil;
import id.go.ojk.client.util.fx.FxmlLoaderUtil;
import id.go.ojk.client.util.fx.FxmlLoaderUtil.AfterInitDialog;
import id.go.ojk.client.util.fx.FxmlLoaderUtil.AfterInitFxml;
import id.go.ojk.client.util.fx.FxmlLoaderUtil.BeforeReShow;
import id.go.ojk.client.vc.AboutController;
import id.go.ojk.client.vc.BaseController;
import id.go.ojk.client.vc.BaseDialogController;
import id.go.ojk.client.vc.FAQController;
import id.go.ojk.client.vc.HomeNotLoginController;
import id.go.ojk.client.vc.LoginController;
import id.go.ojk.client.vc.OpenEncryptedFileController;
import id.go.ojk.client.vc.PreparationAndSendingController;
import id.go.ojk.client.vc.ReadSubmissionDirController;
import id.go.ojk.client.vc.ReportPreparationController;
import id.go.ojk.client.vc.RootLayoutController;
import id.go.ojk.client.vc.SelectDataDatController;
import id.go.ojk.client.vc.SendingController;
import id.go.ojk.client.vc.SplashScreenController;
import id.go.ojk.client.vc.UpdateOnlineController;
import id.go.ojk.client.vc.UserOfflineManagementController;
import id.go.ojk.lib.client.ApplicationInterface;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.Tupple3;
import id.go.ojk.lib.client.model.constant.DisplayScene;
import id.go.ojk.lib.client.model.constant.OjkClientConstant;
import id.go.ojk.lib.client.model.security.UserSession;
import id.go.ojk.lib.client.service.base.Service;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.Getter;
import lombok.Setter;

public class MainApplication extends BaseService implements ApplicationInterface {
	public static final String APPLICATION_ICON = "vc/images/ojk32x32.png";
	private ApplicationContextClient appCtx;
	private Application application;
	private Stage primaryStage;
	private Undecorator primaryUndecorator;
	@Getter private BorderPane rootBorderPane;
	@Setter private DisplayScene displayScene;
	@Getter private List<BaseController> reusedControllerList = new ArrayList<>();

//	@Getter private Tupple2<BorderPane, HomeMetroController> homeUI;
	private Tupple3<BorderPane, ReportPreparationController, Stage> reportPreparationDialog;
	private Tupple2<VBox, SplashScreenController> splashScreenController;
	private Tupple3<AnchorPane, UpdateOnlineController, Stage> updateOnlineDialog;
	private Tupple2<BorderPane, SendingController> sendingUI;
	@Getter
	private Tupple2<BorderPane, PreparationAndSendingController> sendingAndPreparationUI;
	private Tupple2<BorderPane, OpenEncryptedFileController> openMasterDataUI;
	private Tupple2<BorderPane, UserOfflineManagementController> userManagementUI;
	private Tupple2<BorderPane, HomeNotLoginController> homeNotLoginUI;
	private Tupple3<AnchorPane, LoginController, Stage> loginDialogUI;

	private Tupple3<BorderPane, AboutController, Stage> aboutDialog;

	private Tupple3<AnchorPane, FAQController, Stage> faqDialogUI;

	@Getter private RootLayoutController rootLayoutController;
	private volatile boolean startupErrorHandled = false;
	// ~ Service
	private SubmissionService submissionService;
	// RBB Version
//	private SubmissionService submissionServiceRBB2;
//	private SubmissionService submissionServiceRBB3;
//	private SubmissionService submissionServiceRBB4;
//	// LBBPRK Version
//	private SubmissionService submissionServiceLBBPRK1;
//	private SubmissionService submissionServiceLBBPRK2;
//	private SubmissionService submissionServiceLBBPRK3;
//	private SubmissionService submissionServiceLBBPRK4;
	private SubmissionService summarySubmissionService;
	private ApplicationUpdateService applicationUpdateService;
	private SecurityService securityService;
//	private WindowLauncher manualViewer;
	
	@Getter
	private Tupple2<BorderPane, PreparationAndSendingController> summaryDataUI;
	private Tupple2<BorderPane, OpenEncryptedFileController> openErrorFileUI;

	@Getter private CustomForm customForm;
	@Override
	public void init() {
		try {
			splashScreenController = FxmlLoaderUtil.loadFxml("vc/SplashScreen.fxml");
		} catch (IOException e) {
			logger.error("Fail init ", e);
			AlertUtil.showErrorSafe(logger, "gagal load screen", e);
		}
	}

	@Override
	public void start(Application application, final Stage stage) throws Exception {
		this.application = application;
		appCtx = ApplicationContextClient.getInstance();
		appCtx.setService(MainApplication.class, "mainApplication", this);
		Map<String, Service> serviceMap = appCtx.getServiceMap();
		Set<Entry<String, Service>> entrySet = serviceMap.entrySet();

		final Task<ObservableList<String>> friendTask = new Task<ObservableList<String>>() {
			@Override
			protected ObservableList<String> call() throws InterruptedException {
				ObservableList<String> initProcess = FXCollections.<String>observableArrayList();
				try {
					updateMessage("Memulai aplikasi client slik");

					int counter = 0;
					int totalStage = serviceMap.size() + 1;
					for (Entry<String, Service> entry : entrySet) {
						String message = "inisiasi " + entry.getKey();
						updateMessage(message);

						Service service = entry.getValue();
						if (service instanceof ApplicationContextAware) {
							((ApplicationContextAware) service).setApplicationContext(appCtx);
						}
						if (service instanceof Service) {
							((Service) service).initialize();
						}

						initProcess.add(message);
						updateProgress(++counter, totalStage);
					}

					updateMessage("inisiasi tampilan utama");
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							prepareMainUI();
						}
					});

					updateMessage("Inisiasi Sukses");
				} catch (Throwable t) {
					logger.error("", t);
					handleErrorStartup(t);
					// System.exit(-1);
				}
				return initProcess;
			}
		};

		try {
			splashScreenController.getB().showSplash(stage, friendTask, () -> showMainUI());
		} catch (Throwable e) {
			logger.error("", e);
			handleErrorStartup(e);
			// AlertUtil.showErrorSafe(logger, "error", e);
			// System.exit(-1);
		}
		PreStartService preStartService = appCtx.getService(PreStartService.class);
		preStartService.cekDataData(this);
		new Thread(friendTask).start();
	}

	public interface InitCompletionHandler {
		public void complete();
	}

	private void prepareMainUI() {
		try {
			primaryStage = new Stage(StageStyle.DECORATED);
			primaryStage
					.setTitle("Aplikasi Pelaporan - Reporting (v" + OjkClientConstant.applicationVersion + ")");

			FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("vc/RootLayout.fxml"));
			Region root = (Region) fxmlLoader.load();
			rootLayoutController = fxmlLoader.getController();
			rootBorderPane = rootLayoutController.getRootBorderPane();

			final UndecoratorScene undecoratorScene = new UndecoratorScene(primaryStage, root);
			undecoratorScene.addStylesheet(MainApplication.class.getResource("vc/ojk.css").toExternalForm());

			// Application icons
			Image image = new Image(MainApplication.class.getResourceAsStream(APPLICATION_ICON));
			primaryStage.getIcons().addAll(image);

			primaryStage.setScene(undecoratorScene);
			primaryStage.sizeToScene();
			primaryStage.toFront();

			// Set minimum size based on client area's minimum sizes
			primaryUndecorator = undecoratorScene.getUndecorator();
			primaryStage.setMinWidth(primaryUndecorator.getMinWidth());
			primaryStage.setMinHeight(primaryUndecorator.getMinHeight());

			primaryStage.setOnCloseRequest(e -> {
				e.consume();
				this.closeApplication();
			});
			customForm = new CustomForm(appContext, this);
//			showHome();
//			customForm.showHome(userSession);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			handleErrorStartup(e);
		}
	}

	private void showMainUI() {
		try {
			primaryStage.show();
			primaryUndecorator.switchMaximize();

			// logout lock screeen
			showHomeNotLogin();
			showLogin();
			rootLayoutController.logout();

			// if ( SlikClientConstant.isLocalRuntime())
			// testUI();

			synchMenuToRealDisplay();
		} catch (Exception e) {
			logger.error("", e);
			handleErrorStartup(e);
			// System.exit(0);
		}
	}

//	private void testUI() {
//		loginDialogUI.getB().handleLogin();
//		if (securityService.isLogin()) {
//			showApplicationSettingDialog();
//			// showSendingAndPreparation();
//			// showOpenMasterData();
//			// showSending();
//			// showUpdateOfflineDialog();
//		}
//	}

	public DisplayScene getDisplayScene() {
		return displayScene;
	}

//	public void showHome() {
//		homeUI = initAndShowPane("vc/HomeMetro.fxml", homeUI, null, null, null);
//	}

	public void showSending() {
		sendingUI = initAndShowPane("vc/Sending.fxml", sendingUI, DisplayScene.sending, null, null);
	}

	public void showSendingAndPreparation() {
		sendingAndPreparationUI = initAndShowPane("vc/PreparationAndSending.fxml", sendingAndPreparationUI,
				DisplayScene.pelaporanPreparationRbb,
				ui -> ui.getB().setServiceAndBind(submissionService, ConfigService.submissionSourceDir), null);
	}

	public void showSummaryData() {
		summaryDataUI = initAndShowPane("vc/PreparationAndSending.fxml", summaryDataUI, DisplayScene.summaryData,
				ui -> ui.getB().setServiceAndBind(summarySubmissionService, ConfigService.summarySourceDir), null);
	}


	public void showOpenErrorFile() {
		openErrorFileUI = initAndShowPane("vc/OpenEncryptedFile.fxml", openErrorFileUI, DisplayScene.openErrorFile,
				ui -> ui.getB().init("error", ConfigService.errorDataSourceDir, ConfigService.errorDataDoneDir),
				ui -> ui.getB().beforeReshow());
	}

	public void showOpenMasterData() {
		openMasterDataUI = initAndShowPane("vc/OpenEncryptedFile.fxml", openMasterDataUI, DisplayScene.openMasterData,
				ui -> ui.getB().init("master", ConfigService.masterDataSourceDir, ConfigService.masterDataDoneDir),
				ui -> ui.getB().beforeReshow());
	}


	public void showUserManagement() {
		userManagementUI = initAndShowPane("vc/UserOfflineManagement.fxml", userManagementUI,
				DisplayScene.userOfflineManagement, e -> e.getB().reset(), null);
	}

	public void showHomeNotLogin() {
		homeNotLoginUI = initAndShowPane("vc/HomeNotLogin.fxml", homeNotLoginUI, null, null, null);
	}


	public void showLogin() {
		showHomeNotLogin();
		loginDialogUI = createDialog("vc/Login.fxml", "", StageStyle.UTILITY, Modality.APPLICATION_MODAL, null, false,
				null);
		loginDialogUI.getC().show();
	}

	public void showChangePasswordDialog() {
		createDialog("vc/ChangePassword.fxml", "Ubah Password", StageStyle.UTILITY, Modality.APPLICATION_MODAL, null,
				true, null);
	}

	public ReadSubmissionDirController showReadSubmissionDir(SubmissionService submissionService) {
		Tupple3<AnchorPane, ReadSubmissionDirController, Stage> dialogUI = null;
		dialogUI = createDialog("vc/ReadSubmissionDir.fxml", "Baca Direktori Penyampaian Laporan", StageStyle.UTILITY,
				Modality.WINDOW_MODAL, dialogUI, true, e -> e.getB().setServiceAndBind(submissionService));
		return dialogUI.getB();
	}

	public void showApplicationSettingDialog() {
		createDialog("vc/ApplicationSetting.fxml", "Pengaturan Aplikasi", StageStyle.UTILITY, Modality.WINDOW_MODAL,
				null, true, null);
	}

	public void showAboutDialog() {
		createDialog("vc/About.fxml", "Tentang APOLO Client", StageStyle.UTILITY, Modality.WINDOW_MODAL, aboutDialog,
				true, null);
	}

	public void showHelpDialog() {
		application.getHostServices().showDocument("https://apolo.ojk.go.id/DownloadDoc");
		// try {
		// if (manualViewer == null)
		// manualViewer = (WindowLauncher)
		// Class.forName("id.go.ojk.client.ui.ManualViewer").newInstance();
		// manualViewer.showWindow();
		// } catch (Throwable e) {
		// AlertUtil.showErrorSafe(logger, "", e);
		// }
	}

	public void showFAQDialog() {
		try {
			if (faqDialogUI == null) {
				Tupple2<AnchorPane, FAQController> faqUI = FxmlLoaderUtil.loadFxml("vc/FAQ.fxml");

				Rectangle2D rectangle2d = Screen.getPrimary().getVisualBounds();
				faqUI.getA().setPrefSize(rectangle2d.getWidth() / 2, rectangle2d.getHeight() - 50);

				// faqUI.getA().setMinSize(rectangle2d.getWidth()/2,
				// rectangle2d.getHeight() - 50);

				Stage stage = FxmlLoaderUtil.createDialog(primaryStage, faqUI.getA(), "FAQ", StageStyle.UNDECORATED,
						Modality.NONE, false);
				stage.setX(rectangle2d.getWidth() / 2 - 50);
				stage.setY(0);
				stage.setMinWidth(rectangle2d.getWidth() / 2);
				stage.setMinHeight(rectangle2d.getHeight() - 50);
				// stage.setResizable(false);

				faqUI.getB().setStage(stage);
				faqDialogUI = Tupple3.<AnchorPane, FAQController, Stage>builder().a(faqUI.getA()).b(faqUI.getB())
						.c(stage).build();
			}
		} catch (IOException e) {
			AlertUtil.showErrorSafe(logger, "", e);
		}
		faqDialogUI.getC().show();
		faqDialogUI.getC().toFront();
	}

	public void showFaqApolo() {
		application.getHostServices().showDocument("https://apolo.ojk.go.id/Faq/Published");
	}

	public void showWebSlik() {
		application.getHostServices().showDocument("https://apolo.ojk.go.id/Account/Login?ReturnUrl=%2f");
	}

	public void showManual() {
		application.getHostServices().showDocument("https://apolo.ojk.go.id/DownloadDoc");
	}

	public void showUpdateOnlineDialog() {
		updateOnlineDialog = createDialog("vc/UpdateOnline.fxml", "Update Online", StageStyle.UTILITY,
				Modality.APPLICATION_MODAL, null, true, null);
	}

	public void showUpdateOfflineDialog() {
		createDialog("vc/UpdateOffline.fxml", "Update Offline", StageStyle.UTILITY, Modality.APPLICATION_MODAL, null,
				true, null);
	}

	public void showReportPreparationDialog() {
		createDialog("vc/ReportPreparation.fxml", "", StageStyle.UTILITY, Modality.WINDOW_MODAL, reportPreparationDialog,
				true, null);
	}

	public void showReportPreparationRbbDialog() {
		createDialog("vc/ReportPreparationRbb.fxml", "Pelaporan Rencana Bisnis BPR", StageStyle.UTILITY,
				Modality.APPLICATION_MODAL, null, true, null);
	}

	public void showSelectDataDatDialog() {
		Tupple3<AnchorPane, SelectDataDatController, Stage> dialog = createDialog("vc/SelectDataDat.fxml", "Pilih Data",
				StageStyle.UTILITY, Modality.APPLICATION_MODAL, null, false, null);
		dialog.getC().showAndWait();
	}

	// ~ Other Util

	private <R extends Region, C extends BaseController> Tupple2<R, C> initAndShowPane(String fxmlFile,
			Tupple2<R, C> cekUI, DisplayScene pDisplayScene, AfterInitFxml<R, C> afterInitFxml,
			BeforeReShow<R, C> beforeReShow) {
		try {
			if (cekUI == null) {
				cekUI = FxmlLoaderUtil.loadFxml(fxmlFile);
				if (afterInitFxml != null) {
					afterInitFxml.init(cekUI);
				}
				if (cekUI.getB().isReused()) {
					reusedControllerList.add(cekUI.getB());
				}
			} else {
				if (beforeReShow != null) {
					beforeReShow.beforeReShow(cekUI);
				}
			}
			setCenterPane(cekUI.getA());
			if (pDisplayScene != null)
				displayScene = pDisplayScene;
		} catch (IOException e) {
			AlertUtil.showErrorSafe(logger, "", e);
		}
		return cekUI;
	}

	public <R extends Region, C extends BaseDialogController> Tupple3<R, C, Stage> createDialog(String fxmlFile,
			String title, StageStyle stageStyle, Modality modality, Tupple3<R, C, Stage> cekDialogUI, boolean show,
			AfterInitDialog<R, C, Stage> afterInitDialog) {
		return createDialog(fxmlFile, title, stageStyle, modality, cekDialogUI, show, afterInitDialog, false);
	}

	public <R extends Region, C extends BaseDialogController> Tupple3<R, C, Stage> createDialog(String fxmlFile,
			String title, StageStyle stageStyle, Modality modality, Tupple3<R, C, Stage> cekDialogUI, boolean show,
			AfterInitDialog<R, C, Stage> afterInitDialog, boolean plain) {
		try {
			if (cekDialogUI == null) {
				cekDialogUI = FxmlLoaderUtil.createDialog(primaryStage, fxmlFile, title, stageStyle, modality, false,
						plain);
				cekDialogUI.getB().setStage(cekDialogUI.getC());
				if (afterInitDialog != null) {
					afterInitDialog.init(cekDialogUI);
				}
			}
			if (show)
				cekDialogUI.getC().show();
		} catch (IOException e) {
			AlertUtil.showErrorSafe(logger, "", e);
		}
		cekDialogUI.getC().setResizable(false);
		return cekDialogUI;
	}

	public void loginSuccess(UserSession userSession) {
//		String reportCode = userSession.getReportCode();
		customForm.loginSucceed(userSession);
		rootLayoutController.loginSuccess(userSession);
		syncProgressModel(userSession); // submission
		customForm.showHome(userSession);
		rootLayoutController.synchMenuToRealDisplay(displayScene);

		// cek update if online login
		if (userSession.isOnline() && !securityService.useApi()) {
			@SuppressWarnings("unchecked")
			Map<String, Map<String, Object>> versionCheck = (Map<String, Map<String, Object>>) userSession
					.getLoginOnlineResponse().get(ApplicationUpdateService.key_versionCheck);
			if (userSession.isOnline() && applicationUpdateService.isNeedUpdate(versionCheck)) {
				forceUpdateApplication(versionCheck);
				// showUpdateOnlineDialog();
				// updateOnlineDialog.getB().doUpdate(versionCheck);
			}
		} else if (securityService.useApi()) {
			// rootLayoutController.getChangePasswordMenuItem().setVisible(false);
		}
	}

	private void syncProgressModel(UserSession userSession) {
		// submission
		submissionService.getProgressModel().setSendFile(false);
		submissionService.getProgressModel().setSendFileEnable(false);

		summarySubmissionService.getProgressModel().setSendFile(false);
		summarySubmissionService.getProgressModel().setSendFileEnable(false);

		if (securityService.getUserSession().isOnline()) {
			submissionService.getProgressModel().setSendFileEnable(true);
			summarySubmissionService.getProgressModel().setSendFileEnable(true);
		}
	}

	public void forceUpdateApplication(Map<String, Map<String, Object>> versionCheck) {
		showUpdateOnlineDialog();
		updateOnlineDialog.getB().doUpdate(versionCheck);
	}

	public void userLogout() {
		Tupple2<Boolean, List<String>> cekResult = cekRunningProcess(true);
		if (cekResult.getA()) {
			return;
		}
		appCtx.getExecutor().execute(() -> userLogoutRealSafe());
	}

	private void userLogoutReal() {
		try {
			setBusy(true);
			securityService.logout();
			logoutUI();
		} catch (Exception e) {
			AlertUtil.showAlert(AlertType.ERROR, "Koneksi terputus", "Koneksi ke server terputus!");
			logoutUI();
		} finally {
			setBusy(false);
		}
	}

	private void userLogoutRealSafe() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				userLogoutReal();
			}
		});
	}

	private void logoutUI() {
		displayScene = null;
//		homeUI.getB().logout();
		customForm.logout();
		rootLayoutController.logout();

		// reset UI state
		for (BaseController baseController : reusedControllerList) {
			baseController.reset();
		}

		showLogin();
	}

	public Tupple2<Boolean, List<String>> cekRunningProcess(boolean showAlertIfRunningProcess) {
		List<String> errors = new ArrayList<>();

		if (sendingAndPreparationUI != null && sendingAndPreparationUI.getB().isInProcess()) {
			String message = "Proses submission sedang berjalan!";
			errors.add(message);
		}

		if (summaryDataUI != null && summaryDataUI.getB().isInProcess()) {
			String message = "Proses summary submission sedang berjalan!";
			errors.add(message);
		}

		if (sendingUI != null && sendingUI.getB().isInProcess()) {
			String message = "Proses pengiriman masih berjalan!";
			errors.add(message);
		}

		if (openMasterDataUI != null && openMasterDataUI.getB().isInProcess()) {
			String message = "Proses buka data master masih berjalan!";
			errors.add(message);
		}

		if (openErrorFileUI != null && openErrorFileUI.getB().isInProcess()) {
			String message = "Proses buka data error masih berjalan!";
			errors.add(message);
		}

		Tupple2<Boolean, List<String>> result = Tupple2.<Boolean, List<String>>builder().a(errors.size() > 0).b(errors)
				.build();

		if (showAlertIfRunningProcess && result.getA()) {
			AlertUtil.showAlertError("Kesalahan", "Kesalahan", result.getB());
			String content = errors.stream().collect(Collectors.joining("\n- ", "- ", ""));
			content += "\nApakah anda akan memaksa keluar aplikasi?";
			if (AlertUtil.confirmDialog("Kesalahan", "Kesalahan", content)) {
				System.exit(-1);
			}
		}

		return result;
	}

	public void closeApplication() {
		Tupple2<Boolean, List<String>> cekResult = cekRunningProcess(true);
		if (cekResult.getA()) {
			return;
		}

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					if (securityService.isOnlineLogin() && !securityService.useApi()) {
						userLogoutReal();
					}
					appCtx.shutdown();
					primaryStage.close();
				} finally {
					System.exit(0);
				}
			}
		});
	}

	public void setCenterPane(Region region) {
		rootBorderPane.setCenter(region);
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void synchMenuToRealDisplay() {
		rootLayoutController.synchMenuToRealDisplay(displayScene);
	}

	public void setBusy(boolean value) {
		rootLayoutController.setBusy(value);
	}

	@Override
	public void initialize() {
		this.submissionService = appContext.getService("submissionService", SubmissionService.class);
		
//		// RBB Version
//		this.submissionServiceRBB2 = appContext.getService("submissionServiceRBB2", SubmissionService.class);
//		this.submissionServiceRBB3 = appContext.getService("submissionServiceRBB3", SubmissionService.class);
//		this.submissionServiceRBB4 = appContext.getService("submissionServiceRBB4", SubmissionService.class);
//		
//		// LBBPRK Version
//		this.submissionServiceLBBPRK1 = appContext.getService("submissionServiceLBBPRK1", SubmissionService.class);
//		this.submissionServiceLBBPRK2 = appContext.getService("submissionServiceLBBPRK2", SubmissionService.class);
//		this.submissionServiceLBBPRK3 = appContext.getService("submissionServiceLBBPRK3", SubmissionService.class);
//		this.submissionServiceLBBPRK4 = appContext.getService("submissionServiceLBBPRK4", SubmissionService.class);
		
		this.summarySubmissionService = appContext.getService("summarySubmissionService", SubmissionService.class);
		this.applicationUpdateService = appContext.getService(ApplicationUpdateService.class);
		this.securityService = appContext.getService(SecurityService.class);
	}

	public void restartApplication() {
		File currentDir = new File("");
		try {
			securityService.logout();
		} catch (Throwable t) {
			AlertUtil.showAlertSafe(AlertType.ERROR, "Kesalahan", "Kesalahan", "Kesalahan saat logout!");
			logger.error("", t);
		}

		logger.info("Restarting application " + currentDir.getAbsolutePath());
		try {
			Runtime.getRuntime().exec("OjkClient.exe"); // arnol modif : untuk
														// restart aplikasi
		} catch (IOException e) {
			logger.error("", e);
		}
		System.exit(0);
	}

	public synchronized void handleErrorStartup(Throwable t) {
		if (startupErrorHandled)
			return;
		startupErrorHandled = true;
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				AlertUtil.showAlert(AlertType.ERROR, "Kesalahan",
						"Aplikasi gagal startup! \n Mencoba mengembalikan ke versi sebelumnya");
				if (UpdateRollBackUtil.rollBackSafe()) {
					AlertUtil.showAlert(AlertType.INFORMATION, "Informasi", "Aplikasi akan di restart");
					restartApplication();
				}
			}
		});
	}

}
