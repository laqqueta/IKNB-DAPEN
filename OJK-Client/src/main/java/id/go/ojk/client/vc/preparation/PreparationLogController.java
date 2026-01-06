package id.go.ojk.client.vc.preparation;

import id.go.ojk.client.model.bind.ProgressSegment;
import id.go.ojk.client.model.bind.ProgressSegmentFile;
import id.go.ojk.client.vc.BaseController;
import id.go.ojk.lib.client.util.FormatUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class PreparationLogController extends BaseController {

	@FXML private GridPane parentGrid;
	@FXML private VBox detailVBox;
	@FXML private Label segmentCodeLabel;

	@FXML
	protected void initialize() {
		super.initialize();
	}
	
	public void setFormatCode(String formatCode){
		segmentCodeLabel.setText(formatCode);
	}

	public void setProgressSegment(ProgressSegment progressSegment){
		segmentCodeLabel.setText(progressSegment.getSubmissionFormat().getCode());
	}

	public void appendFilePane(ProgressSegmentFile progressSegmentFile){
		detailVBox.getChildren().add(new Label(progressSegmentFile.getFileIntegrity().getFile().getAbsolutePath()));
		String fileName = progressSegmentFile.getFileIntegrity().getFileName();
		if (fileName.endsWith(".txt")) {
			detailVBox.getChildren().add(new Label("Jumlah total " + FormatUtil.formatWithThousandSeparator(progressSegmentFile.getTotalRow())));
		} else if (fileName.endsWith(".pdf")) {
			detailVBox.getChildren().add(new Label("PDF file "));
		} else if (fileName.endsWith(".zip")) {
			detailVBox.getChildren().add(new Label("ZIP file "));
		} else {
			detailVBox.getChildren().add(new Label("File "));
		}
		
		if ( progressSegmentFile.getTotalError() != 0 ){
			detailVBox.getChildren().add(new Label("Jumlah kesalahan " + FormatUtil.formatWithThousandSeparator(progressSegmentFile.getTotalError())));			
			detailVBox.getChildren().add(new Label("Log File " + progressSegmentFile.getErrorFile().getAbsolutePath() ));		
		}
		Label separatorLabel = new Label("");
		detailVBox.getChildren().add(separatorLabel);		
	}
	
	public void setCssClass(String cssClass){
		parentGrid.getStyleClass().add(cssClass);
	}

}

