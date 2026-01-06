package id.go.ojk.client.vc;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class HomeMetroLbController extends BaseHomeMetroController {
	@FXML
	private Button rutinButton;
	@FXML
	private ImageView rutinImage;
	@FXML
	private Button perubahanButton;
	@FXML
	private ImageView perubahanImage;
	@FXML
	private Button penyesuaianButton;
	@FXML
	private ImageView penyesuaianImage;
	@FXML
	private Button penyesuaianKapButton;
	@FXML
	private ImageView penyesuaianKapImage;

	@FXML
	public void handleRutin() {
		mainApplication.getCustomForm().getFormLb().showPelaporan();
		mainApplication.synchMenuToRealDisplay();
	}

	@FXML
	public void handlePerubahan() {
		mainApplication.getCustomForm().getFormLb().showPerubahan();
		mainApplication.synchMenuToRealDisplay();
	}

	@FXML
	public void handlePenyesuaian() {
		mainApplication.getCustomForm().getFormLb().showPenyesuaian();
		mainApplication.synchMenuToRealDisplay();
	}

//	@FXML
//	public void handlePenyesuaian2() {
//		mainApplication.getCustomForm().getFormLb().showPenyesuaian2();
//		mainApplication.synchMenuToRealDisplay();
//	}
//
	@FXML
	public void handlePenyesuaianKap() {
		mainApplication.getCustomForm().getFormLb().showPenyesuaianKap();
		mainApplication.synchMenuToRealDisplay();
	}

	@Override
	protected void initializeCustomMenu(double with) {
		setImageFitSize(rutinImage, with * 3, 1, 0);
		if (perubahanImage != null) {
			setImageFitSize(perubahanImage, with * 3, 1, 0);
		}
		setImageFitSize(penyesuaianImage, with * 3, 1, 0);
		if (penyesuaianKapImage != null) {
			setImageFitSize(penyesuaianKapImage, with * 3, 1, 0);
		}
	}

	@Override
	protected void disableCustomButton(boolean isDisable) {
		rutinButton.setDisable(isDisable);
		if (perubahanButton != null) {
			perubahanButton.setDisable(isDisable);
		}
		penyesuaianButton.setDisable(isDisable);
		if (penyesuaianKapButton != null) {
			penyesuaianKapButton.setDisable(isDisable);
		}
	}

}
