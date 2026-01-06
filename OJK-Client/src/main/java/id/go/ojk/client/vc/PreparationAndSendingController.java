package id.go.ojk.client.vc;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import id.go.ojk.client.MainApplication;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending;
import id.go.ojk.client.model.bind.ProgressSegment;
import id.go.ojk.client.model.bind.ProgressSegmentFile;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.service.ConfigService;
import id.go.ojk.client.service.SubmissionService;
import id.go.ojk.client.service.security.SecurityService;
import id.go.ojk.client.util.AlertUtil;
import id.go.ojk.client.vc.ReadSubmissionDirController.ReadSubmissionDirModel;
import id.go.ojk.lib.client.model.bind.StatusCallback;
import id.go.ojk.lib.client.model.config.ConfigString;
import id.go.ojk.lib.client.util.fx.JfxUtil;
import id.go.ojk.lib.client.util.fx.ProgressUtil;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;

public class PreparationAndSendingController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(PreparationAndSendingController.class);

	@FXML
	private ScrollPane detailFileScrollPane;
	@FXML
	private ScrollPane logProcessScrollPane;

	@FXML
	private ProgressBar validationProgressBar;
	@FXML
	private Label validationProgressLabel;
	@FXML
	private Hyperlink validationDirLink;
	@FXML
	private Pane validationProgressPane;

	@FXML
	private ProgressBar encryptionProgressBar;
	@FXML
	private Label encryptionProgressLabel;
	@FXML
	private Hyperlink encryptionDirLink;
	@FXML
	private Pane encryptionProgressPane;

	@FXML
	private ProgressBar archiveProgressBar;
	@FXML
	private Label archiveProgressLabel;
	@FXML
	private Pane archiveProgressPane;

	@FXML
	private ProgressBar sendingProgressBar;
	@FXML
	private Label sendingProgressLabel;
	@FXML
	private Hyperlink sendingDirLink;
	@FXML
	private Pane sendingProgressPane;

	@FXML
	private TextField submissionDirectoryTextField;
	@FXML
	private TextField codeSeqReport;
	@FXML
	private Button browseButton;
	@FXML
	private Button readFolderButton;
	@FXML
	private Button processButton;
	@FXML
	private Button stopButton;
	@FXML
	private CheckBox agreementCheckBox;
	@FXML
	private CheckBox sendFileCheckBox;

	@FXML
	private Label totalErrorLabel;
	@FXML
	private VBox logProcessVbox;
	@FXML
	private TabPane logTabPane;

	private ConfigService configService;
	private SecurityService securityService;
	private MainApplication mainApplication;
	public int seqReport;

	@FXML
	protected void initialize() {
		super.initialize();
		this.configService = appCtx.getService(ConfigService.class);
		this.securityService = appCtx.getService(SecurityService.class);
		this.mainApplication = appCtx.getService(MainApplication.class);
	}

	private SubmissionService submissionService;
	private ConfigString submissionSourceDir;
	private int jenisPelaporan;

	public void setServiceAndBind(SubmissionService submissionService, ConfigString submissionSourceDir) {
		this.submissionService = submissionService;
		this.submissionSourceDir = submissionSourceDir;
		bindProperty();
	}

	// RBB Version
	public void setServiceAndBind(SubmissionService submissionService, ConfigString submissionSourceDir, int jenisPelaporan) {
		this.submissionService = submissionService;
		this.submissionSourceDir = submissionSourceDir;
		this.jenisPelaporan = jenisPelaporan;
		bindProperty();
	}

	public void bindProperty() {
		ProgressPreparationAndSending progressModel = submissionService.getProgressModel();
		agreementCheckBox.selectedProperty().set(false);
		sendFileCheckBox.selectedProperty().set(false);

		totalErrorLabel.textProperty().bind(progressModel.totalErrorString());

		ProgressUtil.bindProgressModel(progressModel.getValidationProgressModel(), validationProgressPane,
				validationProgressLabel, validationProgressBar, validationDirLink);
		ProgressUtil.bindProgressModel(progressModel.getCompressionEncryptionProgressModel(), encryptionProgressPane,
				encryptionProgressLabel, encryptionProgressBar, null);
		ProgressUtil.bindProgressModel(progressModel.getArchiveProgressModel(), archiveProgressPane,
				archiveProgressLabel, archiveProgressBar, encryptionDirLink);
		ProgressUtil.bindProgressModel(progressModel.getSendingModel().getProgressModel(), sendingProgressPane,
				sendingProgressLabel, sendingProgressBar, sendingDirLink);

		progressModel.getSendingModel().sendingSuccessProperty()
				.bindBidirectional(progressModel.getSendingModel().getProgressModel().showDirProperty());
		progressModel.getSendingModel().getProgressModel()
				.updateStatus(progressModel.sendFileProperty().get() ? StatusCallback.start : StatusCallback.disable);

		submissionDirectoryTextField.editableProperty().bind(progressModel.inProcessProperty().not());
		browseButton.disableProperty().bind(progressModel.inProcessProperty());
		readFolderButton.disableProperty().bind(progressModel.inProcessProperty());

		processButton.disableProperty().bind(progressModel.inProcessProperty()
				.or(progressModel.readyToProcessProperty().not()).or(agreementCheckBox.selectedProperty().not()));
		// RBB custom
		sendFileCheckBox.disableProperty().bind(progressModel.readyToProcessProperty().not());

		stopButton.disableProperty().bind(progressModel.inProcessProperty().not());
		sendFileCheckBox.selectedProperty().bindBidirectional(progressModel.sendFileProperty());
		// sendFileCheckBox.disableProperty().bind(progressModel.sendFileEnableProperty().not()
		// .or(progressModel.getSendingModel().getProgressModel().onProcessProperty()));
		progressModel.sendFileProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				progressModel.getSendingModel().getProgressModel()
						.updateStatus(newValue ? StatusCallback.start : StatusCallback.disable);
			}
		});

		agreementCheckBox.disableProperty().bind(progressModel.readyToProcessProperty().not());

		submissionDirectoryTextField.setText(configService.getProperties(submissionSourceDir));

		logProcessVbox.getChildren().clear();
		progressModel.setLogProcessVbox(logProcessVbox);

		validationDirLink.setOnAction(e -> JfxUtil.openDir(progressModel.getValidationErrorDir()));
		encryptionDirLink.setOnAction(e -> JfxUtil.openDir(progressModel.getReadyToTransferDir()));
		sendingDirLink.setOnAction(e -> JfxUtil.openDir(progressModel.getTransferedDir()));

		logProcessVbox.heightProperty().addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<?> observable, Object oldvalue, Object newValue) {
				logProcessScrollPane.setVvalue((Double) newValue);
			}
		});
	}

	public void updateDetailFile() {
		try {
			ProgressPreparationAndSending progressModel = submissionService.getProgressModel();
			VBox vBox = new VBox();
			vBox.getStyleClass().add("background-ojk-white");
			vBox.getChildren().add(createSubmissionInfo(progressModel));
			for (ProgressSegment progressSegment : progressModel.getSegments()) {
				GridPane gridPane = createProgressSegmentPane(progressSegment);
				vBox.getChildren().add(gridPane);
				progressSegment.setPane(gridPane);
			}
			detailFileScrollPane.setContent(vBox);
		} catch (IOException e) {
			logger.error("", e);
		}
	}

	private GridPane submissionInfo;
	private SubmissionInfoController submissionInfoController;

	private GridPane createSubmissionInfo(ProgressPreparationAndSending submissionModel) throws IOException {
		if (submissionInfo == null || submissionInfoController == null) {
			FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("vc/SubmissionInfo.fxml"));
			submissionInfo = fxmlLoader.load();
			submissionInfoController = fxmlLoader.getController();
		}
		submissionInfoController.setSubmissionModel(submissionModel);

		return submissionInfo;
	}

	private GridPane createProgressSegmentPane(ProgressSegment progressSegment) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("vc/ProgressSegment.fxml"));
		GridPane gridPane = fxmlLoader.load();
		ProgressSegmentController progressSegmentController = fxmlLoader.getController();
		progressSegmentController.setProgressSegment(progressSegment);
		for (ProgressSegmentFile progressSegmentFile : progressSegment.getSegmentFiles()) {
			progressSegmentController
					.appendFilePane(createProgressSegmentFilePane(progressSegment, progressSegmentFile));
		}
		return gridPane;
	}

	private VBox createProgressSegmentFilePane(ProgressSegment progressSegment, ProgressSegmentFile progressSegmentFile)
			throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("vc/ProgressSegmentFile.fxml"));
		VBox vbox = fxmlLoader.load();

		ProgressSegmentFileController controller = fxmlLoader.getController();
		controller.set(progressSegment, progressSegmentFile, logTabPane);

		return vbox;
	}

	// ~ Listener

	@FXML
	private void handleOpen() {
		reset();

		ReadSubmissionDirController controller = mainApplication.showReadSubmissionDir(submissionService);
		ReadSubmissionDirModel readDirModel = controller.getModel();

		File submissionDir = new File(submissionDirectoryTextField.getText());
		configService.setPropertiesAndStore(submissionSourceDir, submissionDir.getAbsolutePath());

		(new Thread(() -> {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					readDirModel.setOnProcess(true);
				}
			});
			submissionService.readDirectory(submissionDir, readDirModel, jenisPelaporan);
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					updateDetailFile();
					readDirModel.setOnProcess(false);
				}
			});
		})).start();
	}

	@FXML
	private void handleBrowse() {
		DirectoryChooser directoryChooser = new DirectoryChooser();
		File submissionDir = new File(submissionDirectoryTextField.getText());
		if (submissionDir.exists() && submissionDir.isDirectory())
			directoryChooser.setInitialDirectory(submissionDir);
		submissionDir = directoryChooser.showDialog(mainApplication.getPrimaryStage());
		if (submissionDir != null) {
			submissionDirectoryTextField.setText(submissionDir.getAbsolutePath());
			handleOpen();
		}
	}

	@FXML
	private void handleProcess() {
		ValidationError error = submissionService.processSubmission();
		if (error != null)
			AlertUtil.showAlert(AlertType.ERROR, "Kesalahan", "Kesalahan", error.getDescription());
	}

	@FXML
	private void handleStop() {
		if (AlertUtil.confirmDialog("Confirmation Dialog", "", "Apakah anda yakin untuk memberhentikan proses?")) {
			submissionService.requestStop();
		}
	}

	public void ensureVisibleDetailFileScrollPane(Node node) {
		double height = detailFileScrollPane.getContent().getBoundsInLocal().getHeight();
		double y = node.getBoundsInParent().getMaxY();
		detailFileScrollPane.setVvalue(y / height);
		node.requestFocus();
	}

	@Override
	public void reset() {
		agreementCheckBox.setSelected(false);
		sendFileCheckBox.setSelected(false);
		submissionService.reset();
		logProcessVbox.getChildren().clear();
		if (logTabPane.getTabs().size() > 1) {
			logTabPane.getTabs().remove(1, logTabPane.getTabs().size());
		}

		updateDetailFile();
	}

	@Override
	public boolean isReused() {
		return true;
	}

	@Override
	public boolean isInProcess() {
		return submissionService.getProgressModel().inProcessProperty().get();
	}

}
