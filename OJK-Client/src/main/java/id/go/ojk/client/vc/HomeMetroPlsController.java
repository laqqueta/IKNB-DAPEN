package id.go.ojk.client.vc;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class HomeMetroPlsController extends BaseHomeMetroController {
	@FXML
	private Button rutinButton;
	@FXML
	private ImageView rutinImage;
	@FXML
	private Button koreksiButton;
	@FXML
	private ImageView koreksiImage;

	@FXML
	public void handleRutin() {
		mainApplication.getCustomForm().getFormPls().showPelaporan();
		mainApplication.synchMenuToRealDisplay();
	}

	@FXML
	public void handleKoreksi() {
		mainApplication.getCustomForm().getFormPls().showKoreksi();
		mainApplication.synchMenuToRealDisplay();
	}

	@Override
	protected void initializeCustomMenu(double with) {
		setImageFitSize(rutinImage, with * 3, 1, 0);
		setImageFitSize(koreksiImage, with * 3, 1, 0);
	}

	@Override
	protected void disableCustomButton(boolean isDisable) {
		rutinButton.setDisable(isDisable);
		koreksiButton.setDisable(isDisable);
	}

}
