package id.go.ojk.client.vc;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class HomeMetroSaController extends BaseHomeMetroController {
	@FXML
	private Button pelaporanButton;
	@FXML
	private ImageView pelaporanImage;
	@FXML
	private Button pelaporanKoreksiButton;
	@FXML
	private ImageView pelaporanKoreksiImage;
	@FXML
	private Button pengkinianButton;
	@FXML
	private ImageView pengkinianImage;
	@FXML
	private Button pengkinianKoreksiButton;
	@FXML
	private ImageView pengkinianKoreksiImage;

	@FXML
	public void handlePelaporan() {
		mainApplication.getCustomForm().getFormSa().showPelaporan();
		mainApplication.synchMenuToRealDisplay();
	}

	@FXML
	public void handlePelaporanKoreksi() {
		mainApplication.getCustomForm().getFormSa().showPelaporanKoreksi();
		mainApplication.synchMenuToRealDisplay();
	}

	@FXML
	public void handlePengkinian() {
		mainApplication.getCustomForm().getFormSa().showPengkinian();
		mainApplication.synchMenuToRealDisplay();
	}

	@FXML
	public void handlePengkinianKoreksi() {
		mainApplication.getCustomForm().getFormSa().showPengkinianKoreksi();
		mainApplication.synchMenuToRealDisplay();
	}

	@Override
	protected void initializeCustomMenu(double with) {
		setImageFitSize(pelaporanImage, with * 3, 1, 0);
		setImageFitSize(pelaporanKoreksiImage, with * 3, 1, 0);
		setImageFitSize(pengkinianImage, with * 3, 1, 0);
		setImageFitSize(pengkinianKoreksiImage, with * 3, 1, 0);
	}

	@Override
	protected void disableCustomButton(boolean isDisable) {
		pelaporanButton.setDisable(isDisable);
		pelaporanKoreksiButton.setDisable(isDisable);
		pengkinianButton.setDisable(isDisable);
		pengkinianKoreksiButton.setDisable(isDisable);
	}
}
