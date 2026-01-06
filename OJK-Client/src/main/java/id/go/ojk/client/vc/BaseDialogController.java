package id.go.ojk.client.vc;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class BaseDialogController extends BaseController {

	protected Stage stage;

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	@FXML
	protected boolean closeDialog(){
		stage.close();
		return true;
	}

}
