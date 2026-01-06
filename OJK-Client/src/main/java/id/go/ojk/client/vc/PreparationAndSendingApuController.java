package id.go.ojk.client.vc;

import id.go.ojk.client.service.SubmissionService;
import id.go.ojk.lib.client.model.config.ConfigString;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

public class PreparationAndSendingApuController extends BasePreparationAndSendingController {
	@FXML
	RadioButton rutinRadio;
	@FXML
	RadioButton koreksiRadio;
	@FXML
	RadioButton perbaikanRadio;
	@FXML
	ToggleGroup reportGroup;
	@FXML
	HBox boxReport;

	@Override
	public void setServiceAndBind(SubmissionService submissionService, ConfigString submissionSourceDir,
			int reportFormGroupCode) {
		super.setServiceAndBind(submissionService, submissionSourceDir, reportFormGroupCode);
	}

	@Override
	protected int getReportFormGroupCode() {
		int res = reportFormGroupCode;
		if (res == 1 && koreksiRadio.isSelected()) {
			res = 2;
		} else if (res == 3 && koreksiRadio.isSelected()) {
			res = 4;
		} else if (res == 5 && koreksiRadio.isSelected()) {
			res = 6;
		} else if (res == 7 && perbaikanRadio != null) {
			if (koreksiRadio.isSelected()) {
				res = 8;
			} else if (perbaikanRadio.isSelected()) {
				res = 9;
			}
		}
		return res;
	}
}
