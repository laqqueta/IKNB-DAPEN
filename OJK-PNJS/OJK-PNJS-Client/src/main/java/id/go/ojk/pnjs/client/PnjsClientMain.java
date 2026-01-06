package id.go.ojk.pnjs.client;

import id.go.ojk.client.MainApplication;
import id.go.ojk.client.util.AlertUtil;
import javafx.application.Application;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PnjsClientMain extends Application {
	private MainApplication mainApplication;

	@Override
	public void init() {
		Constant.initAppVersion();
		mainApplication = new MainApplication();
		mainApplication.init();
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			mainApplication.start(this, primaryStage);
		} catch (Exception e) {
			AlertUtil.showAlert(AlertType.ERROR, "Kesalahan", "GAGAL START");
			log.error(e.getMessage(), e);
		}
	}

	public static void main(String[] args) {
		System.setProperty("jsse.enableSNIExtension", "false");
		if (args.length > 0)
			log.error("args[0] " + args[0]);
		launch(args);
	}
}
