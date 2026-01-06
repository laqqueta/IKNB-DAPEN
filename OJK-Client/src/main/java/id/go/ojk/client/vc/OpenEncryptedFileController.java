package id.go.ojk.client.vc;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import id.go.ojk.client.MainApplication;
import id.go.ojk.client.service.ConfigService;
import id.go.ojk.client.service.DecryptDecompressService;
import id.go.ojk.client.util.AlertUtil;
import id.go.ojk.lib.client.model.bind.FinishCallback;
import id.go.ojk.lib.client.model.compression.DecryptDecompressModel;
import id.go.ojk.lib.client.model.config.ConfigString;
import id.go.ojk.lib.client.util.fx.JfxUtil;
import id.go.ojk.lib.client.util.fx.ProgressUtil;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;

public class OpenEncryptedFileController extends BaseController {
//	private SetupService setupService;
	private ConfigService configService;
	private DecryptDecompressService decryptDecompressService;
	private MainApplication mainApplication;

	@FXML private VBox logProcessVbox;

	@FXML private TextField sourceDirectoryTextField;
	@FXML private Button browseSourceButton;
	@FXML private Button readFolderButton;

	@FXML private TextField destDirectoryTextField;
	@FXML private Button browseDestButton;

	@FXML private Button processButton;
	@FXML private Button stopButton;

	@FXML private VBox sourceFileVBox;
	@FXML private VBox resultFileVBox;

	@FXML private ProgressBar dearchiveProgressBar;
	@FXML private Label dearchiveProgressLabel;
	@FXML private Pane dearchiveStatusPane;

	@FXML private ProgressBar decryptProgressBar;
	@FXML private Label decryptProgressLabel;
	@FXML private Pane decryptStatusPane;
	@FXML private Hyperlink decryptDirLink;

	private DecryptDecompressModel model;

	@FXML
	protected void initialize() {
		super.initialize();
//		setupService = appCtx.getService(SetupService.class);
		configService = appCtx.getService(ConfigService.class);
		decryptDecompressService = appCtx.getService(DecryptDecompressService.class);
		mainApplication = appCtx.getService(MainApplication.class);
		
		model = new DecryptDecompressModel();
		bindProperty();
	}

	private void bindProperty(){
		model.setLogProcessVbox(logProcessVbox);

		ProgressUtil.bindProgressModel(model.getDearchiveProgressModel(), dearchiveStatusPane, dearchiveProgressLabel, dearchiveProgressBar, null);
		ProgressUtil.bindProgressModel(model.getDecryptProgressModel(), decryptStatusPane, decryptProgressLabel, decryptProgressBar, decryptDirLink);
		decryptDirLink.setOnAction(e -> JfxUtil.openDir(model.getDestDir()));
		
		browseSourceButton.disableProperty().bind(model.inProcessProperty());
		readFolderButton.disableProperty().bind(model.inProcessProperty());
		browseDestButton.disableProperty().bind(model.inProcessProperty());
		processButton.disableProperty().bind(model.inProcessProperty().or(model.readyToProcessProperty().not()));
		stopButton.disableProperty().bind(model.inProcessProperty().not());

		sourceDirectoryTextField.disableProperty().bind(model.inProcessProperty());
		destDirectoryTextField.disableProperty().bind(model.inProcessProperty());
	}

	private String suffix;
	private ConfigString sourceConfig;
	private ConfigString destConfig;

	public void init (String suffix, ConfigString sourceConfig, ConfigString destConfig){
		this.suffix = suffix;
		this.sourceConfig = sourceConfig;
		this.destConfig = destConfig;

		sourceDirectoryTextField.setText(configService.getProperties(sourceConfig));
		destDirectoryTextField.setText(configService.getProperties(destConfig));
	}
	
	public void beforeReshow(){
		sourceDirectoryTextField.setText(configService.getProperties(sourceConfig));
		destDirectoryTextField.setText(configService.getProperties(destConfig));
	}

	@FXML
	private void handleBrowseSource(){
    	DirectoryChooser directoryChooser = new DirectoryChooser();
    	File sourceDir = new File(sourceDirectoryTextField.getText());
    	if( sourceDir.exists() && sourceDir.isDirectory() )
    		directoryChooser.setInitialDirectory(sourceDir);
    	sourceDir = directoryChooser.showDialog(mainApplication.getPrimaryStage());
    	if ( sourceDir != null ) {
    		sourceDirectoryTextField.setText(sourceDir.getAbsolutePath());
    		configService.setPropertiesAndStore(sourceConfig, sourceDir.getAbsolutePath());
    		handleOpen();
    	}
	}

	@FXML
	private void handleBrowseDest(){
    	DirectoryChooser directoryChooser = new DirectoryChooser();
    	File destDir = new File(destDirectoryTextField.getText());
    	if( destDir.exists() && destDir.isDirectory() )
    		directoryChooser.setInitialDirectory(destDir);
    	destDir = directoryChooser.showDialog(mainApplication.getPrimaryStage());
    	if ( destDir != null ) {
    		configService.setPropertiesAndStore(destConfig, destDir.getAbsolutePath());
    		destDirectoryTextField.setText(destDir.getAbsolutePath());
    	}
	}

	@FXML
	private void handleOpen(){
		try {
			reset();
			model.setSuffix(suffix);
			model.setSourceDir(new File(sourceDirectoryTextField.getText()));
			model.setDestDir(new File(destDirectoryTextField.getText()));

			List<String> errors = decryptDecompressService.readSourceDirectory(model);
			if ( errors.size() > 0 ){
				AlertUtil.showErrorSafe("Kesalahan : ", errors.stream().collect(Collectors.joining("\n")));
			} else {
				configService.setPropertiesAndStore(sourceConfig, model.getSourceDir().getAbsolutePath());
				configService.setPropertiesAndStore(destConfig, model.getDestDir().getAbsolutePath());
				
				for (File file : model.getSourceFiles()) {
					addDisplayFile(sourceFileVBox, file);
				}
			}
		} catch (Throwable e) {
			AlertUtil.showErrorSafe(logger, "Gagal membuka direktori", e);
		}		
	}
	
	private void addDisplayFile(VBox vBox, File file){
		HBox hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setAlignment(Pos.CENTER_LEFT);
		hBox.getChildren().addAll(
			new ImageView(new Image(MainApplication.class.getResourceAsStream("vc/images/FileIcon_18x25.png"))),
			new Label(file.getName())
		);
		vBox.getChildren().add(hBox);
	}

	@FXML
	private void handleProcess(){
		//String base64Key = setupService.getAesStaticKeyBase64();
		model.setDestDir(new File(destDirectoryTextField.getText()));
		decryptDecompressService.decryptAndDecompress(
			model.getAesKeyBase64(),
			model,
			new FinishCallback() {
				@Override
				public void finish() {
					Platform.runLater(new Runnable() {
					    @Override
					    public void run() {
							resultFileVBox.getChildren().clear();
							for (File file : model.getResultFiles()) {
								addDisplayFile(resultFileVBox, file);
							}
							AlertUtil.showAlert(AlertType.INFORMATION, "Dekrip file sukses", "Dekrip file sukses!", "Dekrip file sukses!");
					    }
					});
				}
			}
		);
	}

	@FXML
	private void handleStop(){
		if (AlertUtil.confirmDialog("Confirmation Dialog", "", "Apakah anda yakin untuk memberhentikan proses?")){
			model.setStopProsess(true);
		}
	}

	@Override
	public void reset(){
		model.reset();
		sourceFileVBox.getChildren().clear();
		resultFileVBox.getChildren().clear();
		logProcessVbox.getChildren().clear();
	}
	
	@Override
	public boolean isReused(){
		return true;
	}

	@Override
	public boolean isInProcess(){
		return model.isInProcess();
	}

}
