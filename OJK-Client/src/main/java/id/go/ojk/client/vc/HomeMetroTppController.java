package id.go.ojk.client.vc;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class HomeMetroTppController extends BaseHomeMetroController {
	@FXML private Button rencanaBtn;
	@FXML private ImageView rencanaImg;
	@FXML private Button realisasiBtn;
	@FXML private ImageView realisasiImg;
	@FXML private Button penilaianBtn;
	@FXML private ImageView penilaianImg;

	@FXML
	public void handlePenilaian(){
		mainApplication.getCustomForm().getFormTpp().showPenilaianResiko();
		mainApplication.synchMenuToRealDisplay();
	}
	
	@FXML
	public void handleRencana(){
		mainApplication.getCustomForm().getFormTpp().showRencana();
		mainApplication.synchMenuToRealDisplay();
	}
	
	@FXML
	public void handleRealisasi(){
		mainApplication.getCustomForm().getFormTpp().showRealisasi();
		mainApplication.synchMenuToRealDisplay();
	}

	@Override
	protected void initializeCustomMenu(double with) {
		setImageFitSize(rencanaImg, with*3, 1, 0);
		setImageFitSize(realisasiImg, with*3, 1, 0);
		setImageFitSize(penilaianImg, with*3, 1, 0);
	}

	@Override
	protected void disableCustomButton(boolean isDisable) {
		rencanaBtn.setDisable(isDisable);
		realisasiBtn.setDisable(isDisable);
		penilaianBtn.setDisable(isDisable);
	}

}
