package id.go.ojk.client.vc;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class HomeMetroLbkController extends BaseHomeMetroController {
	@FXML
	private Button bulananButton;
	@FXML
	private ImageView bulananImage;
	@FXML
	private Button tahunanButton;
	@FXML
	private ImageView tahunanImage;

	@FXML
	public void handleBulanan() {
		mainApplication.getCustomForm().getFormLbk().showPelaporanBulanan();
		mainApplication.synchMenuToRealDisplay();
	}

	@FXML
	public void handleTahunan() {
		mainApplication.getCustomForm().getFormLbk().showPelaporanTahunan();
		mainApplication.synchMenuToRealDisplay();
	}

	@Override
	protected void initializeCustomMenu(double with) {
		setImageFitSize(bulananImage, with * 3, 1, 0);
		setImageFitSize(tahunanImage, with * 3, 1, 0);
	}

	@Override
	protected void disableCustomButton(boolean isDisable) {
		bulananButton.setDisable(isDisable);
		tahunanButton.setDisable(isDisable);
	}

}
