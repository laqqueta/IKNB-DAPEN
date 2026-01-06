package id.go.ojk.client.vc;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class HomeMetroTlController extends BaseHomeMetroController {
	@FXML
	private Button rutinButton;
	@FXML
	private ImageView rutinImage;
	@FXML
	private Button penyesuaianButton;
	@FXML
	private ImageView penyesuaianImage;

	@FXML
	public void handleRutin() {
		mainApplication.getCustomForm().getFormTl().showPelaporan();
		mainApplication.synchMenuToRealDisplay();
	}

	@FXML
	public void handlePenyesuaian() {
		mainApplication.getCustomForm().getFormTl().showPenyesuaian();
		mainApplication.synchMenuToRealDisplay();
	}

	@Override
	protected void initializeCustomMenu(double with) {
		setImageFitSize(rutinImage, with * 3, 1, 0);
		setImageFitSize(penyesuaianImage, with * 3, 1, 0);
	}

	@Override
	protected void disableCustomButton(boolean isDisable) {
		rutinButton.setDisable(isDisable);
		penyesuaianButton.setDisable(isDisable);
	}

}
