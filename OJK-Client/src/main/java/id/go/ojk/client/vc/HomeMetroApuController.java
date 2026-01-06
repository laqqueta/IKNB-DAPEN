package id.go.ojk.client.vc;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class HomeMetroApuController extends BaseHomeMetroController {
	@FXML private Button submissionButton;
	@FXML private ImageView submissionImage;
	@FXML private Button submissionButton2;
	@FXML private ImageView submissionImage2;
	@FXML private Button summarySubmissionButton;
	@FXML private ImageView summarySubmissionImage;

	@FXML
	public void handlePenilaian(){
		mainApplication.getCustomForm().getFormApu().showPenilaian();
		mainApplication.synchMenuToRealDisplay();
	}
	
	@FXML
	public void handleRencana(){
		mainApplication.getCustomForm().getFormApu().showRencana();
		mainApplication.synchMenuToRealDisplay();
	}
	
	@FXML
	public void handleRealisasi(){
		mainApplication.getCustomForm().getFormApu().showRealisasi();
		mainApplication.synchMenuToRealDisplay();
	}

	@Override
	protected void initializeCustomMenu(double with) {
		if (submissionImage != null) {
			setImageFitSize(submissionImage, with*3, 1, 0);
		}
		setImageFitSize(submissionImage2, with*3, 1, 0);
		setImageFitSize(summarySubmissionImage, with*3, 1, 0);
	}

	@Override
	protected void disableCustomButton(boolean isDisable) {
		if (submissionButton != null) {
			submissionButton.setDisable(isDisable);
		}
		submissionButton2.setDisable(isDisable);	
		summarySubmissionButton.setDisable(isDisable);
	}

}
