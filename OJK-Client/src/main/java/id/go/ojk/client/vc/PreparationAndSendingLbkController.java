package id.go.ojk.client.vc;

import id.go.ojk.client.module.lbk.EReportGroupLbk;
import id.go.ojk.client.module.rb.EReportGroupRb;
import id.go.ojk.client.service.SubmissionService;
import id.go.ojk.lib.client.model.config.ConfigString;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

public class PreparationAndSendingLbkController extends BasePreparationAndSendingController {
	@FXML
	RadioButton rutinRadio;
	@FXML
	RadioButton koreksiRadio;
	@FXML
	ToggleGroup lbkGroup;
	@FXML
	HBox boxLbkReport;

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
		}
		return res;
	}
}
