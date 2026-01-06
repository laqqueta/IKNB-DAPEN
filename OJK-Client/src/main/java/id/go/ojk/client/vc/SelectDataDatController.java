package id.go.ojk.client.vc;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;

import id.go.ojk.client.MainApplication;
import id.go.ojk.client.service.PreStartService;
import id.go.ojk.client.util.AlertUtil;
import id.go.ojk.lib.client.CompressionUtil;
import id.go.ojk.lib.client.DateUtil;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SelectDataDatController extends BaseDialogController {

	@FXML private TextField dataDatFileTextField;

	@FXML private Button browseButton;
	@FXML private Button openButton;
	
	private final BooleanProperty onProcessProperty = new SimpleBooleanProperty();
	
	private MainApplication mainApplication;
	private PreStartService preStartService;

	@FXML
	protected void initialize() {
		super.initialize();
		
		mainApplication = appCtx.getService(MainApplication.class);
		preStartService = appCtx.getService(PreStartService.class);

		dataDatFileTextField.setText("");
		
		dataDatFileTextField.disableProperty().bind(onProcessProperty);
		browseButton.disableProperty().bind(onProcessProperty);
	}

	private Stage stage;
	public void setStage(Stage stage) {
		this.stage = stage;
        stage.setOnCloseRequest(
            e -> {
            	e.consume();
            	if (AlertUtil.confirmDialog("Konfirmasi menutup aplikasi", "Konfirmasi menutup aplikasi", "Aplikasi membutuhkan data.dat untuk start. Apakah anda yakin untuk menutup aplikasi?") ){
            		System.exit(0);
            	} 
            }
        );
	}

	@FXML
	private void handleBrowse(){
    	FileChooser fileChooser = new FileChooser();
    	File updateFile = new File(dataDatFileTextField.getText());
    	File updateDir = updateFile.getParentFile();
    	if( updateDir != null && updateDir.exists() && updateDir.isDirectory() )
    		fileChooser.setInitialDirectory(updateDir);
    	if ( updateFile != null && updateFile.exists() && updateFile.isFile() )
    		fileChooser.setInitialFileName(updateFile.getName());
    	updateFile = fileChooser.showOpenDialog(mainApplication.getPrimaryStage());
    	if ( updateFile != null ) {
    		dataDatFileTextField.setText(updateFile.getAbsolutePath());
    	}
	}

	@FXML
	private void handleOpen(){
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
			    	onProcessProperty.set(true);
			    }
			});

			File dataDatFile = new File(dataDatFileTextField.getText());
			if ( !dataDatFile.exists() || dataDatFile.isDirectory() ){
				AlertUtil.showAlertSafe(AlertType.ERROR, "Kesalahan", "Kesalahan", "File update tidak valid");
				return;
			}
			
			File tmpExtractDir = new File("tmp/" + DateUtil.formatNowMs());
			List<File> files = CompressionUtil.decompress(dataDatFile, tmpExtractDir);
			List<String> fileNames = files.stream().map( e -> e.getName().toLowerCase()).collect(Collectors.toList());
			
			if (!preStartService.isAllFileExist(fileNames, PreStartService.setupJarFile, PreStartService.metadataJarFile, PreStartService.referencesJarFile)){
				AlertUtil.showAlertSafe(AlertType.ERROR, "Kesalahan", "Kesalahan", "File update tidak valid");
				return;				
			} 
			
			for (File srcFile : files) {
				File destFile = new File(PreStartService.resourcesDir.getAbsolutePath() + "/" + srcFile.getName());
				destFile.delete();
				FileUtils.moveFile(srcFile, destFile);
			}
			
			Platform.runLater(new Runnable() {
			    @Override
			    public void run() {
			    	stage.close();
			    }
			});
		} catch (Throwable t) {
			AlertUtil.showErrorSafe(logger, "", t);
		} finally {
			Platform.runLater(new Runnable() {
			    @Override
			    public void run() {
			    	onProcessProperty.set(false);
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
