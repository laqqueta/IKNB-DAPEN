package id.go.ojk.client.vc;

import id.go.ojk.client.module.rb.EReportGroupRb;
import id.go.ojk.client.service.SubmissionService;
import id.go.ojk.lib.client.model.config.ConfigString;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

public class PreparationAndSendingRbbPelaporanController extends BasePreparationAndSendingController {
	@FXML
	RadioButton rbbPelaporanRadio;
	@FXML
	RadioButton rbbPerubahanRadio;
	@FXML
	RadioButton rbbPenyesuaianRadio;
	@FXML
	ToggleGroup rbbGroup;
	@FXML
	HBox boxRbbReport;

	@Override
	public void setServiceAndBind(SubmissionService submissionService, ConfigString submissionSourceDir,
			int reportFormGroupCode) {
		boxRbbReport.setVisible(reportFormGroupCode == EReportGroupRb.PELAPORAN.getMenuCode());
		super.setServiceAndBind(submissionService, submissionSourceDir, reportFormGroupCode);
	}

	@Override
	protected int getReportFormGroupCode() {
		int res = reportFormGroupCode;
		if (res == 1) {
			if (rbbPerubahanRadio.isSelected()) {
				res = 2;
			} else if (rbbPenyesuaianRadio.isSelected()) {
				res = 3;
			}
		}
		return res;
	}
}
