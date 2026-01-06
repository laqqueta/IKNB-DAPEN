package id.go.ojk.client.util;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.client.service.security.SecurityService;
import id.go.ojk.lib.client.exception.ExceptionReLogin;
import javafx.application.Platform;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.VBox;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UtilDialog {

	public static boolean reLogin(SecurityService service) {
		Dialog<String> dialog = new Dialog<>();
		dialog.setTitle("Login");
		DialogPane dialogPane = dialog.getDialogPane();
		dialogPane.setMinWidth(300);
		dialogPane.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
		TextField id = new TextField();
		id.setPromptText("Masukkan User ID");
		PasswordField password = new PasswordField();
		password.setPromptText("Masukkan Password");
		dialogPane.setContent(new VBox(8, id, password));
		dialog.setResultConverter((ButtonType button) -> {
			if (button == ButtonType.OK) {
				service.reAuthOnline(id.getText(), password.getText());
				return service.getUserSession().getSessionId();
			}
			return null;
		});
		Optional<String> result = dialog.showAndWait();
		String res = result.isPresent() ? result.get() : "";
		return StringUtils.isNotEmpty(res) && !res.equalsIgnoreCase("offline");
	}
}
