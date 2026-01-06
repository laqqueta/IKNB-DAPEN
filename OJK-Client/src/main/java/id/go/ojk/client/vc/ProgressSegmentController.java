package id.go.ojk.client.vc;

import id.go.ojk.client.model.bind.ProgressSegment;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ProgressSegmentController extends BaseController {

	@FXML private VBox detailVBox;

	@FXML private Label segmentCodeLabel;
	@FXML private Label segmentNameLabel;

	@FXML
	protected void initialize() {
		super.initialize();
	}

	public void setProgressSegment(ProgressSegment progressSegment){
		segmentCodeLabel.setText(progressSegment.getSubmissionFormat().getCode());
		segmentNameLabel.setText(progressSegment.getSubmissionFormat().getName());
	}

	public void appendFilePane(VBox gridPane){
		detailVBox.getChildren().add(gridPane);
	}

}
