package id.go.ojk.client.vc;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.client.service.UserService;
import id.go.ojk.client.service.security.SecurityService;
import id.go.ojk.client.util.AlertUtil;
import id.go.ojk.lib.client.model.KeyValue;
import id.go.ojk.lib.client.model.bind.UserModel;
import id.go.ojk.lib.client.model.security.User;
import id.go.ojk.lib.client.util.fx.JavaFxValidationUtil;
import id.go.ojk.lib.client.util.fx.Reloadable;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class UserFormController extends BaseDialogController {

	@FXML private TextField userLoginIdField;
	@FXML private TextField userNameField;

	@FXML private PasswordField passwordField;
	@FXML private PasswordField rePasswordField;

	@FXML private Button cancelButton;
	@FXML private Button okButton;

	private SecurityService securityService;
	private UserService userService;

	@FXML
	protected void initialize() {
		super.initialize();
		this.securityService = appCtx.getService(SecurityService.class);
		this.userService = appCtx.getService(UserService.class);
		
		JavaFxValidationUtil.addMaxLengthListener(userLoginIdField, 50);
		JavaFxValidationUtil.addMaxLengthListener(userNameField, 50);
		
		JavaFxValidationUtil.addMaxLengthListener(passwordField, 20);
		JavaFxValidationUtil.addMaxLengthListener(rePasswordField, 20);
	}

	private Reloadable<User>  callback;
	public void setCallback(Reloadable<User> callback) {
		this.callback = callback;
	}

	private UserModel userModel;
	private boolean newUser = true;

	private List<KeyValue<String, TextField>> requiredFields;

	public void setUser(UserModel userModel){
		if ( userModel == null ){
			userModel = new UserModel();
			newUser = true;
			userLoginIdField.setEditable(true);
		} else {
			newUser = false;
			userLoginIdField.setEditable(false);
		}
		this.userModel = userModel;
		userLoginIdField.textProperty().bindBidirectional(userModel.userLoginIdProperty);
		userNameField.textProperty().bindBidirectional(userModel.userNameProperty);

		passwordField.textProperty().bindBidirectional(userModel.passwordProperty);
		rePasswordField.textProperty().bindBidirectional(userModel.rePasswordProperty);

		requiredFields = new ArrayList<>();
		requiredFields.add(new KeyValue<>("User ID", userLoginIdField));
		requiredFields.add(new KeyValue<>("Nama", userNameField));
		if (newUser){
			requiredFields.add(new KeyValue<>("Password", passwordField));
			requiredFields.add(new KeyValue<>("Konfirmasi password", rePasswordField));
		}
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public boolean isNewUser() {
		return newUser;
	}

	@FXML
	private void handleOk(){
		if( isNewUser() )
			handleOkNew();
		else
			handleOkEdit();
	}

	private void handleOkNew(){
		try {
			List<String> errors = new ArrayList<>();

			JavaFxValidationUtil.validateRequired(errors, requiredFields);

			if (!AlertUtil.showAlertError("Kesalahan", "Kesalahan", errors) ){
				return;
			}

			if( userService.isUserExist(userModel.userLoginIdProperty.get()) ){
				errors.add("User id " + userModel.userLoginIdProperty.get() + " sudah digunakan!");
			}

			securityService.validateComplexPassword(errors, passwordField.getText());
			if ( !StringUtils.equals( passwordField.getText() , rePasswordField.getText() ) ){
				errors.add("Password baru tidak sama!");
			}

			if ( !AlertUtil.showAlertError("Kesalahan", "Kesalahan", errors) ){
				return;
			}

			callback.reload(userService.addUserOffline(userModel.toUser()));
			AlertUtil.showAlert(AlertType.INFORMATION, "Sukses", "Sukses menambah");

			closeDialog();
		} catch (Throwable t){
			AlertUtil.showError(logger, "Error saat tambah pengguna", t);
		}
	}

	private void handleOkEdit(){
		try {
			List<String> errors = new ArrayList<>();

			JavaFxValidationUtil.validateRequired(errors, requiredFields);

			if (!AlertUtil.showAlertError("Kesalahan", "Kesalahan", errors) ){
				return;
			}

			if ( StringUtils.isNotEmpty(passwordField.getText()) || StringUtils.isNotEmpty(rePasswordField.getText()) ){
				securityService.validateComplexPassword(errors, passwordField.getText());
				if ( !StringUtils.equals( passwordField.getText() , rePasswordField.getText() ) ){
					errors.add("Password baru tidak sama!");
				}

				if ( !AlertUtil.showAlertError("Kesalahan", "Kesalahan", errors) ){
					return;
				}

			}

			callback.reload(userService.updateUserOffline(userModel.toUser()));
			AlertUtil.showAlert(AlertType.INFORMATION, "Sukses", "Sukses mengubah");
			closeDialog();
		} catch (Throwable t){
			AlertUtil.showError(logger, "Error saat ubah pengguna", t);
		}
	}

}
