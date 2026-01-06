package id.go.ojk.client.vc;

import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.service.SubmissionService;
import id.go.ojk.client.util.AlertUtil;
import id.go.ojk.lib.client.model.bind.ProgressModel;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class ReadSubmissionDirController extends BaseDialogController {

	@FXML private Label progressLabel;
	@FXML private ProgressBar progressBar;
	
	@FXML TabPane tabPane;
	@FXML Tab processTab;
	@FXML Tab errorTab;

	@FXML private Button stopButton;
	@FXML private Button closeButton;
	@FXML private TextArea processTextArea;
	@FXML private TextArea errorTextArea;

	@FXML
	protected void initialize() {
		super.initialize();
	}

	private SubmissionService submissionService;
	public void setServiceAndBind(SubmissionService submissionService){
		this.submissionService = submissionService;
		
		tabPane.getTabs().remove(errorTab);
		
		model = new ReadSubmissionDirModel(this, true);
		progressLabel.textProperty().bindBidirectional(model.progressLabelProperty());
		progressBar.progressProperty().bindBidirectional(model.progressBarProperty());

		stopButton.disableProperty().bind(model.onProcessProperty().not());
		closeButton.disableProperty().bind(model.onProcessProperty());
	}

	@Override
	public void setStage(Stage stage) {
		super.setStage(stage);
        stage.setOnCloseRequest(
            	e -> {
            		e.consume();
            		if ( this.model != null && this.model.isOnProcess()){
            			AlertUtil.showAlert(AlertType.ERROR, "Proses sedang berjalan", "Proses scan file sedang berjalan!");
            		} else {
            			stage.close();
            		}
            	}
            );
	}

	@FXML
	public void handleClose(){
		stage.close();
	}

	@FXML
	public void handleStop(){
		if (AlertUtil.confirmDialog("Confirmation Dialog", "", "Apakah anda yakin untuk memberhentikan proses?")){
			model.setStop(true);
		}
	}

	private ReadSubmissionDirModel model;
	public ReadSubmissionDirModel getModel() {
		return model;
	}

	public static class ReadSubmissionDirModel extends ProgressModel {
		
		private boolean runInJavaFx;
		private ReadSubmissionDirController controller;

		public ReadSubmissionDirModel(ReadSubmissionDirController controller, boolean runInJavaFx){
			super("", runInJavaFx);
			this.controller = controller;;
			this.runInJavaFx = runInJavaFx;;
		}

		@Override
		public void writeProcessLog(String message, boolean showOnScreen) {
			if ( runInJavaFx ) {
				Platform.runLater(new Runnable() {
				    @Override
				    public void run() {
				    	controller.processTextArea.appendText(message + "\n");
				    }
				});				
			}
		}

		public void logError(ValidationError validationError){
			if ( runInJavaFx ) {
				Platform.runLater(new Runnable() {
				    @Override
				    public void run() {
				    	if ( controller.tabPane.getTabs().size() == 1 ){
				    		controller.tabPane.getTabs().add(controller.errorTab);
				    		controller.tabPane.getSelectionModel().select(controller.errorTab);
				    	}
				    	controller.errorTextArea.appendText(validationError.errorCode.code + "-" + validationError.description + "\n");
				    }
				});				
			}
		}
	}
	
	@Override
	public void reset(){
	}
	
	@Override
	public boolean isReused(){
		return false;
	}
}
