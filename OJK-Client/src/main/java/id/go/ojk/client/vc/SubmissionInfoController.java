package id.go.ojk.client.vc;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending;
import id.go.ojk.lib.client.util.FormatUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SubmissionInfoController extends BaseController {

	@FXML private Label yearLabel;
	@FXML private Label monthLabel;
	@FXML private Label totalFileLabel;
	@FXML private Label totalFileSizeLabel;

	@FXML
	protected void initialize() {
		super.initialize();
	}

	public void setSubmissionModel(ProgressPreparationAndSending submissionModel){
		yearLabel.setText(StringUtils.defaultString(submissionModel.getSubmissionData().getDataYear(), ""));
		monthLabel.setText(StringUtils.defaultString(submissionModel.getSubmissionData().getDataMonth(), "")  );
		totalFileLabel.setText(FormatUtil.formatWithThousandSeparator(submissionModel.getTotalFile()));
		totalFileSizeLabel.setText(FormatUtil.formatWithThousandSeparator(submissionModel.getTotalFileSize()) + " bytes");
	}

}
