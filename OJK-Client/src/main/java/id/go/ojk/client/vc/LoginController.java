package id.go.ojk.client.vc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.XStream;

import id.go.ojk.client.MainApplication;
import id.go.ojk.client.constant.EFtpServer;
import id.go.ojk.client.constant.EReport;
import id.go.ojk.client.service.ApplicationUpdateService;
import id.go.ojk.client.service.SetupService;
import id.go.ojk.client.service.ftp.FtpService;
import id.go.ojk.client.service.security.SecurityService;
import id.go.ojk.client.util.AlertUtil;
import id.go.ojk.lib.client.model.security.UserSession;
import id.go.ojk.lib.client.util.fx.JavaFxValidationUtil;
import id.go.ojk.lib.client.vc.object.ReportValue;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class LoginController extends BaseDialogController {
	@FXML
	private TextField userNameTextField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private Button loginButton;
	@FXML
	private ProgressIndicator loginProgress;
	@FXML
	private ComboBox<ReportValue> reportComboBox = new ComboBox<>();

	private final BooleanProperty inProgressProperty = new SimpleBooleanProperty();

	// ~ initialized

	private SecurityService securityService;
	private SetupService setupService;
	private MainApplication mainApplication;
	private FtpService ftpService;
	private ApplicationUpdateService applicationUpdateService;

	@FXML
	protected void initialize() {
		super.initialize();
		securityService = appCtx.getService(SecurityService.class);
		setupService = appCtx.getService(SetupService.class);
		mainApplication = appCtx.getService(MainApplication.class);
		ftpService = appCtx.getService(FtpService.class);
		applicationUpdateService = appCtx.getService(ApplicationUpdateService.class);

//		if (SlikClientConstant.isLocalRuntime()) {
//			userNameTextField.setText(TestEnvironment.loginDialogUser);
//			passwordField.setText(TestEnvironment.loginDialogPassword);
//		}

		// SET Username & password untuk devel
//		userNameTextField.setText(TestEnvironment.loginDialogUser);
//		passwordField.setText(TestEnvironment.loginDialogPassword);

		userNameTextField.disableProperty().bind(inProgressProperty);
		passwordField.disableProperty().bind(inProgressProperty);
		loginButton.disableProperty().bind(inProgressProperty);

		// Combobox untuk list laporan
		ObservableList<ReportValue> reportValue = FXCollections.observableArrayList();
		Map<String, String> mapReport = setupService.getMapReport().entrySet().stream().sorted(Entry.comparingByValue())
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		Map<String, List<String>> mapReportBySector = setupService.getMapReportBySector();
		reportValue.add(new ReportValue("0", "Pilih Laporan :"));
		for (Entry<String, String> entry : mapReport.entrySet()) {
			List<String> listSectorCode = mapReportBySector.get(entry.getKey().split("[|]")[0]);
			if (listSectorCode != null && listSectorCode.contains(setupService.getSectorCode())) {
				reportValue.add(new ReportValue(entry.getKey(), entry.getValue()));
			}
		}
//		reportValue.add(new ReportValue("2349|LBBPRK", "Laporan Berkala BPR Konvensional"));
		reportComboBox.setItems(reportValue);
		reportComboBox.setConverter(new StringConverter<ReportValue>() {

			@Override
			public String toString(ReportValue object) {
				return object.nameProperty().get();
			}

			@Override
			public ReportValue fromString(String id) {
				return null;
				// return reportComboBox.getItems().stream().filter(ap ->
				// ap.idProperty().equals(id)).findFirst().orElse(null);
			}
		});
		reportComboBox.getSelectionModel().select(0);
		reportComboBox.visibleRowCountProperty().set(10);

		loginProgress.visibleProperty().bind(inProgressProperty);

		JavaFxValidationUtil.addMaxLengthListener(userNameTextField, 70);
		JavaFxValidationUtil.addMaxLengthListener(passwordField, 100);
	}

	@FXML
	public void handleLogin() {
		String userName = userNameTextField.getText();
		String password = passwordField.getText();
		String report = reportComboBox.getValue().idProperty().get();

		List<String> errors = new ArrayList<>();
		if (StringUtils.isEmpty(userName))
			errors.add("User ID harus diisi!");
		if (StringUtils.isEmpty(password))
			errors.add("Password harus diisi!");
		if (report.equals("0"))
			errors.add("Pilih laporan yang akan diakses!");

		if (errors.size() > 0) {
			AlertUtil.showAlertError("Kesalahan", "Kesalahan", errors);
			return;
		}

		appCtx.getExecutor().execute(() -> handleLoginReal(userName, password, report));
	}

	private void handleLoginReal(String userName, String password, String report) {
		try {
			inProgressProperty.set(true);
//			UserSession userSession = securityService.autenticateOnline(userName, password, report);
//			// try offline
//			if (!userSession.isAuthenticated()) {
//				logger.info("Offline authentication");
//			UserSession userSession = securityService.autenticateOffline(userName, password, report, true);
			UserSession userSession = securityService.authenticate(userName, password, report, true);
//			}
			if (userSession.isAuthenticated()) {
				if (userSession.getReportCode() == null) {
					AlertUtil.showAlertSafe(AlertType.ERROR, "Login Gagal", "Login Gagal",
							"Anda tidak memiliki akses aplikasi " + reportComboBox.getValue().nameProperty().get()
									+ "!");
				} else {
					handleAfterLogin(userSession);
				}
			} else if (userSession.getUser() != null) {
				AlertUtil.showAlertSafe(AlertType.ERROR, "Login Gagal", "Login Gagal",
						getErrorMessage(userSession, "User ID / Password salah!"));
			} else {
				AlertUtil.showAlertSafe(AlertType.ERROR, "Login Gagal", "Login Gagal",
						getErrorMessage(userSession, "User ID / Password salah!"));
			}

			// userSession = securityService.autenticateOnline(userName,
			// password);
			// if ( userSession.isAuthenticated() ){
			// handleAfterLogin(userSession);
			// } else {
			// if ( userSession.getAuthenticationStatus() ==
			// AuthenticationStatus.networkOffline ){
			// if ( setupService.isClientTypeOJK() ) {
			// AlertUtil.showAlertSafe(AlertType.ERROR, "Login gagal", "Login
			// gagal", "Jaringan offline");
			// handleAfterLogin(userSession);
			// return;
			// }
			//
			// Platform.runLater(new Runnable() {
			// @Override
			// public void run() {
			// if (AlertUtil.confirmDialog("Konfirmasi", "Jaringan offline",
			// "Apakah anda akan mencoba login offline?")){
			// UserSession userSession =
			// securityService.autenticateOffline(userName, password, false);
			// handleAfterLogin(userSession);
			// }
			// }
			// });
			// } else {
			// handleAfterLogin(userSession);
			// }
			// }
		} finally {
			inProgressProperty.set(false);
		}
	}
	
	private String getErrorMessage(UserSession userSession, String defaultMessage) {
		if (userSession != null) {
			String tmp = userSession.getErrorMessage();
			return StringUtils.isNotBlank(tmp) ? tmp : defaultMessage;
		}
		return defaultMessage;
	}

	private void handleAfterLogin(UserSession userSession) {
		switch (userSession.getAuthenticationStatus()) {
		case onlineAuthenticate:
		case offlineAuthenticate:
			// modif arnol : cek versi melalui FTP
			// Untuk sosialisasi baris ini di komen saja
			if (!securityService.useApi() && ftpService.isLoginFTP(EFtpServer.FTP01.name(), false)) {
				userSession.setFtpLogin(true);
				Map<String, String> clientVersion = applicationUpdateService.getClientVersion();
				XStream xstream = applicationUpdateService.xStreamUpdateHeader();
				ftpService.checkUpdate(clientVersion, xstream);
			} else if (securityService.useApi()) {
				applicationUpdateService.validateVersion();
			}

			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					mainApplication.loginSuccess(userSession);
					stage.close();

					if (!securityService.useApi()) {
						// change password if default password
						if (!securityService.isChangePassword(userSession.getUser().getUserLoginId())) {
							AlertUtil.showAlert(AlertType.INFORMATION, "Login Sukses", "Login Sukses",
									"Mohon ubah Password Anda terlebih dahulu");
							mainApplication.showChangePasswordDialog();
						}
					}
				}
			});
			break;
		case notAuthenticate:
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					String messsage = StringUtils.isEmpty(userSession.getErrorMessage()) ? "Login gagal"
							: userSession.getErrorMessage();
					AlertUtil.showAlert(AlertType.ERROR, "Login Gagal", "Login Gagal", messsage);
					reset();
				}
			});
			break;
		default:
			break;
		}
	}

	public void setStage(Stage stage) {
		super.setStage(stage);
		stage.setOnCloseRequest(e -> {
			e.consume();
			mainApplication.closeApplication();
		});
	}

	@FXML
	public void handleForgotPass() {
	  String report = reportComboBox.getValue().idProperty().get();
	  if (report.equals("0")) {
	    AlertUtil.showAlert(AlertType.ERROR, "Lupa Password", "Lupa Password", "Pilih laporan yang akan diakses");
	    return;
	  }

	  if (EReport.useLoginApi(report)) {
	    AlertUtil.showAlert(AlertType.INFORMATION, "Lupa Password", "Petunjuk Reset Password", securityService.getResetPasswordInstruction());
	    return;
	  }

		String userName = userNameTextField.getText();

		if (StringUtils.isEmpty(userName)) {
			AlertUtil.showAlert(AlertType.ERROR, "Lupa Password", "Lupa Password", "User ID harus diisi!");
			return;
		}

		if (securityService.cekUserName(userName)) {
			String password = securityService.maskingPassword(userName);
			AlertUtil.showAlertSafe(AlertType.INFORMATION, "Lupa Password", "Lupa Password",
					String.format("Password Anda : %1$s \n\n" + "Jika masih mengalami kesulitan dengan Password Anda, "
							+ "mohon download dan instal aplikasi kembali", password));
		} else {
			AlertUtil.showAlert(AlertType.ERROR, "Lupa Password", "Lupa Password",
					"User ID tidak terdaftar pada aplikasi Client Anda");
		}

		// if
		// (!setupService.getUserMap().get(userName.toLowerCase()).getUserLoginId().equals(userName.toLowerCase()))
		// {
		// AlertUtil.showAlert(AlertType.ERROR, "Lupa Password", "Lupa
		// Password", "User ID tidak terdaftar!");
		// } else {
		// AlertUtil.showAlertSafe(AlertType.INFORMATION, "Lupa Password", "Lupa
		// Password",
		// String.format("Password Anda %1$s \n"
		// + "Jika masih mengalami kesulitan dengan password Anda, "
		// + "mohon download dan instal aplikasi kembali!",
		// setupService.getUserMap().get(userName.toLowerCase()).getPassword())
		// );
		// }

		// if ( errors.size() > 0 ){
		// AlertUtil.showAlertError("Kesalahan", "Kesalahan", errors);
		// return;
		// }
	}

	@Override
	public void reset() {
		userNameTextField.setText("");
		passwordField.setText("");
	}

	@Override
	public boolean isReused() {
		return false;
	}
}