package id.go.ojk.lib.client;

import javafx.application.Application;
import javafx.stage.Stage;

public interface ApplicationInterface {
	public void init();
	public void start(Application application, final Stage stage) throws Exception;
}
