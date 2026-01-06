package id.go.ojk.client.vc;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class HomeMetroRbbController extends BaseHomeMetroController {
	@FXML private Button submissionButton;
	@FXML private ImageView submissionImage;
	@FXML private Button submissionButton2;
	@FXML private ImageView submissionImage2;
	@FXML private Button summarySubmissionButton;
	@FXML private ImageView summarySubmissionImage;

	@FXML
	public void handlePelaporan(){
		mainApplication.getCustomForm().getFormRbb().showPelaporanData();
		mainApplication.synchMenuToRealDisplay();
	}
	
	@FXML
	public void handleRealisasi(){
		mainApplication.getCustomForm().getFormRbb().showRealisasiData();
		mainApplication.synchMenuToRealDisplay();
	}
	
	@FXML
	public void handlePengawasan(){
		mainApplication.getCustomForm().getFormRbb().showPengawasanData();
		mainApplication.synchMenuToRealDisplay();
	}

	@Override
	protected void initializeCustomMenu(double with) {
		setImageFitSize(submissionImage, with*3, 1, 0);
		setImageFitSize(submissionImage2, with*3, 1, 0);
		setImageFitSize(summarySubmissionImage, with*3, 1, 0);
	}

	@Override
	protected void disableCustomButton(boolean isDisable) {
		submissionButton.setDisable(isDisable);
		submissionButton2.setDisable(isDisable);	
		summarySubmissionButton.setDisable(isDisable);
	}

}
