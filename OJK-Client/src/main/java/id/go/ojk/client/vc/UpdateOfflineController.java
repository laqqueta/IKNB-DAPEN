package id.go.ojk.client.vc;

import java.io.File;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.client.MainApplication;
import id.go.ojk.client.service.ApplicationUpdateService;
import id.go.ojk.client.service.ConfigService;
import id.go.ojk.client.util.AlertUtil;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.bind.ProgressModel;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class UpdateOfflineController extends BaseDialogController {

	@FXML private TextField updateFileTextField;

	@FXML private Button browseButton;
	@FXML private Button cancelButton;
	@FXML private Button updateButton;

	@FXML private Label progressLabel;
	@FXML private ProgressBar progressBar;

	private final ProgressModel progressModel = new ProgressModel("", true);
	
	private ConfigService configService;
	private ApplicationUpdateService applicationUpdateService;
	private MainApplication mainApplication;

	@FXML
	protected void initialize() {
		super.initialize();
		
		configService = appCtx.getService(ConfigService.class);
		applicationUpdateService = appCtx.getService(ApplicationUpdateService.class);
		mainApplication = appCtx.getService(MainApplication.class);

		updateFileTextField.setText(configService.getProperties(ConfigService.updateOfflineFile));
		progressLabel.textProperty().bindBidirectional(progressModel.progressLabelProperty());
		progressBar.progressProperty().bindBidirectional(progressModel.progressBarProperty());
		
		updateFileTextField.disableProperty().bind(progressModel.onProcessProperty());
		browseButton.disableProperty().bind(progressModel.onProcessProperty());
		cancelButton.disableProperty().bind(progressModel.onProcessProperty());
		updateButton.disableProperty().bind(progressModel.onProcessProperty());
	}

	private Stage stage;
	public void setStage(Stage stage) {
		this.stage = stage;
        stage.setOnCloseRequest(
            e -> {
            	e.consume();
            	if ( this.progressModel != null && this.progressModel.isOnProcess()){
            		AlertUtil.showAlert(AlertType.ERROR, "Proses sedang berjalan", "Proses update offline sedang berjalan!");
            	} else {
            		stage.close();
            	}
            }
        );
	}


	public ProgressModel getProgressModel() {
		return progressModel;
	}

	@FXML
	private void handleBrowse(){
		progressModel.setProgress(0d);
    	FileChooser fileChooser = new FileChooser();
    	File updateFile = new File(updateFileTextField.getText());
    	File updateDir = updateFile.getParentFile();
    	if( updateDir != null && updateDir.exists() && updateDir.isDirectory() )
    		fileChooser.setInitialDirectory(updateDir);
    	if ( updateFile != null && updateFile.exists() && updateFile.isFile() )
    		fileChooser.setInitialFileName(updateFile.getName());
    	updateFile = fileChooser.showOpenDialog(mainApplication.getPrimaryStage());
    	if ( updateFile != null ) {
    		updateFileTextField.setText(updateFile.getAbsolutePath());
    		configService.setProperties(ConfigService.updateOfflineFile, updateFile.getAbsolutePath());
    		configService.storeProperties();
    	}
	}

	@FXML
	private void handleCancel(){
		stage.close();
	}

	@FXML
	private void handleUpdate(){
		(new Thread(){
			public void run() {
				doUpdate();
			};
		}).start();
	}

	private void doUpdate(){
		try {
			Platform.runLater(new Runnable() {
			    @Override
			    public void run() {
			    	progressModel.setOnProcess(true);
			    }
			});			

			File updateFile = new File(updateFileTextField.getText());
			if ( !updateFile.exists() || updateFile.isDirectory() ){
				AlertUtil.showAlertSafe(AlertType.ERROR, "Kesalahan", "Kesalahan", "File update tidak valid");
				return;
			}

			Tupple2<Boolean, List<String>> result = applicationUpdateService.doUpdate(progressModel, updateFile);
			if ( result != null ){
				if ( result.getA() ){
					Platform.runLater(new Runnable() {
					    @Override
					    public void run() {
					    	AlertUtil.showAlert(
					    		AlertType.INFORMATION, 
					    		"Aplikasi harus direstart!", 
					    		StringUtils.join(result.getB(), "\n")
					    	);
					    	mainApplication.restartApplication();
					    }
					});
				} else {				
					final String message = StringUtils.join(result.getB(), "\n");
					Platform.runLater(new Runnable() {
					    @Override
					    public void run() {
					    	AlertUtil.showAlert(AlertType.INFORMATION, "Update Selesai!", "Update Selesai! \n" + message);
					    	stage.close();
					    }
					});
				}				
			}
		} catch (Throwable t) {
			AlertUtil.showErrorSafe(logger, "", t);
		} finally {
			Platform.runLater(new Runnable() {
			    @Override
			    public void run() {
			    	progressModel.setOnProcess(false);
			    }
			});
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
