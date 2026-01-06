package id.go.ojk.client.vc;

import id.go.ojk.client.service.SubmissionService;
import id.go.ojk.lib.client.model.config.ConfigString;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

public class PreparationAndSendingTppController extends BasePreparationAndSendingController {
	@FXML
	RadioButton rutinRadio;
	@FXML
	RadioButton koreksiRadio;

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

		switch (res) {
			case 1:
			case 2:
				res = 1;
				if (koreksiRadio.isSelected())
					res = 2;
				break;
			case 3:
			case 4:
				res = 3;
				if (koreksiRadio.isSelected())
					res = 4;
				break;
			case 5:
			case 6:
				res = 5;
				if (koreksiRadio.isSelected())
					res = 6;
				break;
		}

		return res;
	}
}
