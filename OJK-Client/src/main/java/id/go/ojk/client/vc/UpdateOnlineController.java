package id.go.ojk.client.vc;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.ClientProtocolException;

import id.go.ojk.client.MainApplication;
import id.go.ojk.client.service.ApplicationUpdateService;
import id.go.ojk.client.service.HttpService;
import id.go.ojk.client.util.AlertUtil;
import id.go.ojk.lib.client.DateUtil;
import id.go.ojk.lib.client.HttpUtil;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.bind.ProgressModel;
import id.go.ojk.lib.client.util.fx.ProgressUtil;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

public class UpdateOnlineController extends BaseDialogController {

	@FXML private ProgressBar downloadProgressBar;
	@FXML private Label downloadProgressLabel;

	@FXML private ProgressBar installProgressBar;
	@FXML private Label installProgressLabel;

	@FXML private Button closeButton;
	@FXML private Button updateButton;

	private final ProgressModel downloadProgressModel = new ProgressModel("");
	private final ProgressModel installProgressModel = new ProgressModel("");

	private final BooleanProperty checkVersionInProcessProperty = new SimpleBooleanProperty();
	private final BooleanProperty inProcessProperty = new SimpleBooleanProperty();

	@Getter @Setter private boolean forceUpdate;

	//~ service

	private HttpService httpService;
	private ApplicationUpdateService applicationUpdateService;
	private MainApplication mainApplication;

	@FXML
	protected void initialize() {
		super.initialize();
		this.httpService = appCtx.getService(HttpService.class);
		this.applicationUpdateService = appCtx.getService(ApplicationUpdateService.class);
		this.mainApplication = appCtx.getService(MainApplication.class);

		//downloadProgressModel.bind(downloadProgressBar, downloadProgressLabel);
		ProgressUtil.bindProgressModel(downloadProgressModel, null, downloadProgressLabel, downloadProgressBar, null);
		
		//installProgressModel.bind(installProgressBar, installProgressLabel);
		ProgressUtil.bindProgressModel(installProgressModel, null, installProgressLabel, installProgressBar, null);
		
		closeButton.disableProperty().bind(inProcessProperty.or(checkVersionInProcessProperty));
		updateButton.disableProperty().bind(inProcessProperty.or(checkVersionInProcessProperty));
	}

	public void setStage(Stage stage) {
		super.setStage(stage);
        this.stage.setOnCloseRequest(
            e -> {
            	e.consume();
            	handleClose();
            }
        );
	}

	@FXML
	private void handleUpdate(){
		doUpdate(null);
	}

	public void doUpdate(Map<String, Map<String, Object>> versionCheck) {
		appCtx.getExecutor().execute(new Runnable() {
			@Override
			public void run() {
				try {
					Map<String, Map<String, Object>> innerVersionCheck = versionCheck == null ? checkVersion() : versionCheck;
					if ( applicationUpdateService.isNeedUpdate(innerVersionCheck) ){
						doUpdateReal(innerVersionCheck);
					} else {
						AlertUtil.showAlertSafe(AlertType.INFORMATION, "Informasi", "Informasi", "Versi Aplikasi sudah terkini!");
					}
				} catch (Throwable t) {
					AlertUtil.showErrorSafe(logger, "Gagal update", t);
				}
			}
		});
	}

	private void doUpdateReal(Map<String, Map<String, Object>> versionCheck) throws ClientProtocolException, IOException, ArchiveException{
		try {
			setInprosessSafe(true);
			File tmpFile = new File("tmp/" + DateUtil.formatNow());

			//download
			Map<String, Object> downloadStatus = httpService.download(downloadProgressModel, httpService.getDownloadUpdateOnlineUrl(), versionCheck, tmpFile);
			HttpUtil.cekSuccessResponse(downloadStatus);

			//update
			Tupple2<Boolean, List<String>> result = applicationUpdateService.doUpdate(installProgressModel, tmpFile);
			if ( result != null ){
				if ( !result.getA() ){
					applicationUpdateService.reloadVersionSafe();				
				}

				forceUpdate = false;
				Platform.runLater(new Runnable() {
				    @Override
				    public void run() {
				    	
						if ( result.getA() ){
							Platform.runLater(new Runnable() {
							    @Override
							    public void run() {
							    	AlertUtil.showAlert(
							    		AlertType.INFORMATION, 
							    		"Aplikasi harus direstart!",
							    		"Aplikasi harus direstart!", 
							    		StringUtils.join(result.getB(), "\n")
							    	);
							    	mainApplication.restartApplication();
							    }
							});
						} else {
							final String message = StringUtils.join(result.getB(), "\n");
							AlertUtil.showAlert(AlertType.INFORMATION, "Informasi", "update selesai", "Update selesai.\n" + message);						
						}

						//closeDialog();
				    }
				});				
			}


		} finally {
			Platform.runLater(new Runnable() {
			    @Override
			    public void run() {
					closeDialog();			    	
			    }
			});

			setInprosessSafe(false);
		}
	}

	public Map<String, Map<String, Object>> checkVersion() throws ClientProtocolException, IOException, URISyntaxException {
		try {
			setChekVersionInprosessSafe(true);
			return applicationUpdateService.cekVersion();
		} finally {
			setChekVersionInprosessSafe(false);
		}
	}

	@FXML
	private void handleClose(){
    	if ( inProcessProperty.get() || checkVersionInProcessProperty.get()){
    		AlertUtil.showAlertSafe(AlertType.WARNING, "Peringatan", "Peringatan", "Sedang Proses");
    	} else {
    		stage.close();
    	}
	}

	private void setInprosessSafe(boolean value){
		Platform.runLater(new Runnable() {
		    @Override
		    public void run() {
		    	inProcessProperty.set(value);
		    }
		});
	}

	private void setChekVersionInprosessSafe(boolean value){
		Platform.runLater(new Runnable() {
		    @Override
		    public void run() {
		    	checkVersionInProcessProperty.set(value);
		    }
		});
	}

	public void resetStage(){
		downloadProgressModel.reset();
		installProgressModel.reset();
	}
	
	@Override
	public void reset(){
		resetStage();
	}
	
	@Override
	public boolean isReused(){
		return false;
	}

}
