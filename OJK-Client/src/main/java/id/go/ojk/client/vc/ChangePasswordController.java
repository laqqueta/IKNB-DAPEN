package id.go.ojk.client.vc;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.lang3.StringUtils;

import id.go.ojk.client.ClientProperties;
import id.go.ojk.client.service.UserService;
import id.go.ojk.client.service.context.ApplicationContextClient;
import id.go.ojk.client.service.security.SecurityService;
import id.go.ojk.client.util.AlertUtil;
import id.go.ojk.lib.client.model.KeyValue;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.security.User;
import id.go.ojk.lib.client.util.fx.JavaFxValidationUtil;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ChangePasswordController extends BaseDialogController {

	@FXML
	private PasswordField oldPasswordField;
	@FXML
	private PasswordField newPasswordField;
	@FXML
	private PasswordField reNewPasswordField;
	@FXML
	private Label labelMessage;
	@FXML
	private CheckBox checkBoxResetPassword;
	@FXML
	private Button buttonClose;

	@FXML
	private ProgressIndicator busyIndicator;
	private final BooleanProperty busyProperty = new SimpleBooleanProperty();

	private List<KeyValue<String, TextField>> textFields;

	private SecurityService securityService;
	private UserService userService;

	@Override
	public void setStage(Stage stage) {
		super.setStage(stage);
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent we) {
				if (!closeDialog()) {
					we.consume();
				}
			}
		});
	}

	@FXML
	@Override
	protected void initialize() {
		super.initialize();

		this.securityService = appCtx.getService(SecurityService.class);
		this.userService = appCtx.getService(UserService.class);

		textFields = new ArrayList<>();
		textFields.add(new KeyValue<>("Password Lama", oldPasswordField));
		textFields.add(new KeyValue<>("Password Baru", newPasswordField));
		textFields.add(new KeyValue<>("Konfirmasi Password Baru", reNewPasswordField));

		JavaFxValidationUtil.addMaxLengthListener(oldPasswordField, 50);
		JavaFxValidationUtil.addMaxLengthListener(newPasswordField, 50);
		JavaFxValidationUtil.addMaxLengthListener(reNewPasswordField, 50);
		String userId = securityService.getUserSession().getUser().getUserLoginId();
		User user = userService.getUser(userId);
		int pwdExpirationPeriod = ClientProperties.getInstance().getValueAsInt(ClientProperties.PWD_EXPIRATION_PERIOD, 90);
		checkBoxResetPassword.setDisable(user.isNeedChangePassword(pwdExpirationPeriod));
		buttonClose.setDisable(user.isNeedChangePassword(pwdExpirationPeriod));
		labelMessage.setVisible(user.isPasswordExpired(pwdExpirationPeriod));
		if (labelMessage.isVisible()) {
			labelMessage
					.setText("Password anda telah kadaluarsa (" + pwdExpirationPeriod + " hari masa berlaku), mohon lakukan perubahan password");
		}
		busyIndicator.visibleProperty().bind(busyProperty);
	}

	@Override
	@FXML
	public boolean closeDialog() {
		String userId = securityService.getUserSession().getUser().getUserLoginId();
		User user = userService.getUser(userId);
		if (user.isNeedChangePassword(ClientProperties.getInstance().getValueAsInt(ClientProperties.PWD_EXPIRATION_PERIOD, 90))) {
			if (AlertUtil.confirmDialog("Konfirmasi Batal Ubah Password", "Batal Ubah Password",
					"Password harus diubah terlebih dahulu!\nBatalkan dan keluar aplikasi?")) {
				Platform.exit();
				System.exit(0);
			} else {
				return false;
			}
		} else {
			super.closeDialog();
		}
		return true;
	}

	@FXML
	private void handleCheckBoxResetPassword() {
		boolean isReset = checkBoxResetPassword.isSelected();
		oldPasswordField.setDisable(isReset);
		newPasswordField.setDisable(isReset);
		reNewPasswordField.setDisable(isReset);
	}

	@FXML
	private void handleChangePassword() {
		try {
			boolean isReset = checkBoxResetPassword.isSelected();
			if (isReset) {
				resetPassword();
			} else {
				changePassword();
			}
		} catch (Exception t) {
			AlertUtil.showError(logger, "Error saat ubah passsword", t);
		}
	}

	private void resetPassword() {
		if (AlertUtil.confirmDialog("Konfirmasi Reset Password", "Reset Password",
				"Password akan di reset. Apakah anda yakin??")) {
			String userId = securityService.getUserSession().getUser().getUserLoginId();
			User user = userService.getUser(userId);

			ApplicationContextClient.getInstance().getExecutor().execute(new Runnable() {
				@Override
				public void run() {
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							busyProperty.set(true);
						}
					});

					try {
						changePasswordCallService(user.getPassword(), userId);
					} catch (Throwable t) {
						logger.error("While change server password");
						AlertUtil.showAlertSafe(AlertType.ERROR, "Kesalahan", "Kesalahan",
								"Gagal mengubah password.\nKoneksi ke server gagal!");
					} finally {
						Platform.runLater(new Runnable() {
							@Override
							public void run() {
								busyProperty.set(false);
							}
						});
					}
				}
			});
		}
	}

	private void changePassword() {
		List<String> errors = new ArrayList<>();

		JavaFxValidationUtil.validateRequired(errors, textFields);
		if (!AlertUtil.showAlertError("Kesalahan", "Kesalahan", errors)) {
			return;
		}

		if (!securityService.cekUserLoginPassword(oldPasswordField.getText())) {
			AlertUtil.showAlert(AlertType.ERROR, "Password Lama Salah", "Password Lama Salah",
					"Password Lama yang Anda masukkan salah!");
			return;
		}
		String newPassword = newPasswordField.getText();
		securityService.validateComplexPassword(errors, newPasswordField.getText());
		if (!StringUtils.equals(newPasswordField.getText(), reNewPasswordField.getText())) {
			errors.add("Password Baru tidak sama!");
		} else if (StringUtils.equals(oldPasswordField.getText(), newPassword)) {
			errors.add("Password Lama dan Password Baru tidak boleh sama!");
		}
		String userId = securityService.getUserSession().getUser().getUserLoginId();
		User user = userService.getUser(userId);
		List<String> list = user.validatePassword(newPassword);
		if (list != null && !list.isEmpty()) {
			errors.addAll(list);
		}

		if (!AlertUtil.showAlertError("Kesalahan", "Kesalahan", errors)) {
			return;
		}

		ApplicationContextClient.getInstance().getExecutor().execute(new Runnable() {
			@Override
			public void run() {
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						busyProperty.set(true);
					}
				});

				try {
					changePasswordCallService(oldPasswordField.getText(), newPasswordField.getText());
				} catch (Exception t) {
					logger.error("While change server password", t);
					AlertUtil.showAlertSafe(AlertType.ERROR, "Kesalahan", "Kesalahan",
							"Gagal mengubah password.\nKoneksi ke server gagal!");
				} finally {
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							busyProperty.set(false);
						}
					});
				}
			}
		});
	}

	private void changePasswordCallService(String oldPassword, String newPassword)
			throws NoSuchAlgorithmException, IOException, ArchiveException {
		Tupple2<Boolean, String> result = userService.changeMyPassword(oldPassword, newPassword);
		if (result.getA()) {
			AlertUtil.showAlertSafe(AlertType.INFORMATION, "Sukses", "Sukses", "Sukses mengubah password");
		} else {
			AlertUtil.showAlertSafe(AlertType.INFORMATION, "Gagal", "Gagal mengubah password", result.getB());
		}
//		boolean result = userService.changePassword(oldPassword, newPassword);
//		if (result) {
//			AlertUtil.showAlertSafe(AlertType.INFORMATION, "Sukses", "Sukses", "Sukses mengubah password");
//		} else {
//			AlertUtil.showAlertSafe(AlertType.INFORMATION, "Gagal", "Gagal", "Gagal mengubah password");
//		}
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				stage.close();
			}
		});
	}

	@Override
	public void reset() {
	}

	@Override
	public boolean isReused() {
		return false;
	}
}