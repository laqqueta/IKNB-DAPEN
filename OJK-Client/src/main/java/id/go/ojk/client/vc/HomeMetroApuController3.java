package id.go.ojk.client.vc;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class HomeMetroApuController3 extends BaseHomeMetroController {
	@FXML private Button submissionButton;
	@FXML private ImageView submissionImage;
	

	@FXML
	public void handlePenilaian(){
		mainApplication.getCustomForm().getFormApu().showPenilaian2();
		mainApplication.synchMenuToRealDisplay();
	}

	@Override
	protected void initializeCustomMenu(double with) {
		setImageFitSize(submissionImage, with*3, 1, 0);
	}

	@Override
	protected void disableCustomButton(boolean isDisable) {
		submissionButton.setDisable(isDisable);
	}

}
