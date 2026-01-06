package id.go.ojk.client.vc;

import static id.go.ojk.client.service.ConfigService.connectionType;
import static id.go.ojk.client.service.ConfigService.errorDataDoneDir;
import static id.go.ojk.client.service.ConfigService.errorDataSourceDir;
import static id.go.ojk.client.service.ConfigService.masterDataDoneDir;
import static id.go.ojk.client.service.ConfigService.masterDataSourceDir;
import static id.go.ojk.client.service.ConfigService.maxErrorCount;
import static id.go.ojk.client.service.ConfigService.maxThread;
import static id.go.ojk.client.service.ConfigService.proxyHost;
import static id.go.ojk.client.service.ConfigService.proxyPassword;
import static id.go.ojk.client.service.ConfigService.proxyPort;
import static id.go.ojk.client.service.ConfigService.proxyUser;
import static id.go.ojk.client.service.ConfigService.sendindSourceDir;
import static id.go.ojk.client.service.ConfigService.splitFileSize;
import static id.go.ojk.client.service.ConfigService.submissionDoneDir;
import static id.go.ojk.client.service.ConfigService.submissionProcessDir;
import static id.go.ojk.client.service.ConfigService.submissionSourceDir;
import static id.go.ojk.client.service.ConfigService.updateOfflineFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import id.go.ojk.client.MainApplication;
import id.go.ojk.client.service.ConfigService;
import id.go.ojk.client.service.HttpService;
import id.go.ojk.client.service.SetupService;
import id.go.ojk.client.service.ftp.FtpService;
import id.go.ojk.client.service.security.SecurityService;
import id.go.ojk.client.util.AlertUtil;
import id.go.ojk.lib.client.exception.SlikException;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.lib.client.model.ProxyConfig;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.config.Config;
import id.go.ojk.lib.client.model.config.ConfigInteger;
import id.go.ojk.lib.client.model.config.ConfigLong;
import id.go.ojk.lib.client.model.config.ConfigString;
import id.go.ojk.lib.client.model.config.SlikClientCfg;
import id.go.ojk.lib.client.model.constant.ConnectionType;
import id.go.ojk.lib.client.model.constant.OjkClientConstant;
import id.go.ojk.lib.client.util.NumberUtil;
import id.go.ojk.lib.client.util.fx.RadioButtonGroup;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ApplicationSettingController extends BaseDialogController {

	@FXML
	private TextField submissionSourceDirField;
	@FXML
	private Button submissionSourceDirButton;

	@FXML
	private TextField submissionProcessDirField;
	@FXML
	private Button submissionProcessDirButton;

	@FXML
	private TextField submissionDoneDirField;
	@FXML
	private Button submissionDoneDirButton;

	@FXML
	private TextField errorDataSourceDirField;
	@FXML
	private Button errorDataSourceDirButton;

	@FXML
	private TextField errorDataDoneDirField;
	@FXML
	private Button errorDataDoneDirButton;

	@FXML
	private TextField masterDataSourceDirField;
	@FXML
	private Button masterDataSourceDirButton;

	@FXML
	private TextField masterDataDoneDirField;
	@FXML
	private Button masterDataDoneDirButton;

	@FXML
	private TextField updateOfflineFileField;
	@FXML
	private Button updateOfflineFileButton;

	@FXML
	private TextField splitFileSizeField;
	@FXML
	private TextField maxErrorCountField;
	@FXML
	private TextField maxThreadField;

	@FXML
	private VBox connectionTypeVbox;
	private RadioButtonGroup radioButtonGroup;

	@FXML
	private TextField proxyHostField;
	@FXML
	private TextField proxyPortField;
	@FXML
	private TextField proxyUserField;
	@FXML
	private PasswordField proxyPasswordField;

	@FXML
	private Button testConnectionButton;
	@FXML
	private Label testConnectionLabel;
	@FXML
	private AnchorPane testConnectionResult;
	@FXML
	private ImageView connectionUpImage;
	@FXML
	private ImageView connectionDownImage;

	@FXML
	private ScrollPane appSettingScroll;

	private final BooleanProperty testConnectionVisible = new SimpleBooleanProperty();
	private final BooleanProperty testConnectionStatus = new SimpleBooleanProperty();

	@FXML
	private GridPane busyPane;

	private SetupService setupService;
	private ConfigService configService;
	private HttpService httpService;
	private FtpService ftpService;
	private SecurityService securityService;
	private MainApplication mainApplication;

	// private boolean mustRestart;
	private SlikClientCfg slikClientCfg;
	@FXML
	private TextField minMemoryField;
	@FXML
	private TextField maxMemoryField;

	@FXML
	private VBox mainVBox;
	@FXML
	private VBox preparationAndSendingSettingVBox;
	@FXML
	private VBox openErrorFileSettingVBox;
	@FXML
	private VBox openMasterDataSettingVBox;
	@FXML
	ImageView submissionSourceDirTooltipImage;
	@FXML
	Tooltip submissionSourceDirTooltip;
	@FXML
	ImageView submissionSourceDirTooltipImage1;
	@FXML
	Tooltip submissionSourceDirTooltip1;
	@FXML
	ImageView submissionSourceDirTooltipImage11;
	@FXML
	Tooltip submissionSourceDirTooltip11;
	@FXML
	ImageView submissionSourceDirTooltipImage11111111;
	@FXML
	Tooltip submissionSourceDirTooltip11111111;

	@FXML
	protected void initialize() {
		super.initialize();
		setupService = appCtx.getService(SetupService.class);
		configService = appCtx.getService(ConfigService.class);
		httpService = appCtx.getService(HttpService.class);
		ftpService = appCtx.getService(FtpService.class);
		securityService = appCtx.getService(SecurityService.class);
		mainApplication = appCtx.getService(MainApplication.class);

		appSettingScroll.setVmax(0.4);

		initDirectorySetting(submissionSourceDirField, submissionSourceDirButton, submissionSourceDir);
		initDirectorySetting(submissionProcessDirField, submissionProcessDirButton, submissionProcessDir);
		initDirectorySetting(submissionDoneDirField, submissionDoneDirButton, submissionDoneDir);
		initDirectorySetting(errorDataSourceDirField, errorDataSourceDirButton, errorDataSourceDir);
		initDirectorySetting(errorDataDoneDirField, errorDataDoneDirButton, errorDataDoneDir);
		initDirectorySetting(masterDataSourceDirField, masterDataSourceDirButton, masterDataSourceDir);
		initDirectorySetting(masterDataDoneDirField, masterDataDoneDirButton, masterDataDoneDir);
		initFileSetting(updateOfflineFileField, updateOfflineFileButton, updateOfflineFile);

		splitFileSizeField.setText(configService.getStringProperty(ConfigService.splitFileSize, String.valueOf(OjkClientConstant.getDefauldsplitfilesizeByte())));
		addLongValidation(splitFileSizeField, 2, 1, (int) OjkClientConstant.getDefauldsplitfilesizeByte());
		maxErrorCountField.setText(configService.getStringProperty(ConfigService.maxErrorCount, "500"));
		addLongValidation(maxErrorCountField, 5, 1, 5000);
		maxThreadField.setText(configService.getStringProperty(ConfigService.maxThread, "0"));
		addLongValidation(maxThreadField, 2, 0, 99);

		radioButtonGroup = new RadioButtonGroup(connectionTypeVbox, "connectionType",
				Arrays.asList(ConnectionType.values()).stream()
						.map(e -> new KeyValueString(e.getRadioButtonId(), e.getLabel(), null))
						.collect(Collectors.toList()));
		radioButtonGroup.setSelected(configService.getProperties(connectionType).getRadioButtonId());

		proxyHostField.setText(configService.getStringProperty(ConfigService.proxyHost, ""));

		proxyPortField.setText(configService.getStringProperty(ConfigService.proxyPort, ""));
		addIntValidation(proxyPortField, 5);

		proxyUserField.setText(configService.getStringProperty(ConfigService.proxyUser, ""));
		proxyPasswordField.setText(configService.getStringProperty(ConfigService.proxyPassword, ""));

		testConnectionResult.visibleProperty().bind(testConnectionVisible);
		testConnectionLabel.visibleProperty().bind(testConnectionVisible);
		busyPane.visibleProperty().bind(busyProperty);

		proxyHostField.disableProperty().bind(radioButtonGroup.getInternetRadioButton().selectedProperty().not());
		proxyPortField.disableProperty().bind(radioButtonGroup.getInternetRadioButton().selectedProperty().not());
		proxyUserField.disableProperty().bind(radioButtonGroup.getInternetRadioButton().selectedProperty().not());
		proxyPasswordField.disableProperty().bind(radioButtonGroup.getInternetRadioButton().selectedProperty().not());

		connectionUpImage.visibleProperty().bind(testConnectionStatus);
		connectionDownImage.visibleProperty().bind(testConnectionStatus.not());

		// initialize
		try {
			slikClientCfg = SlikClientCfg.newInstance();

			minMemoryField.setText(slikClientCfg.getXms() + "");
			addIntValidation(minMemoryField, 4);
//			addIntValidation(minMemoryField, 1, 2048);

			maxMemoryField.setText(slikClientCfg.getXmx() + "");
			addIntValidation(maxMemoryField, 5);
//			addIntValidation(maxMemoryField, 1, 60000);

		} catch (IOException e) {
			logger.error("While read BprkClient.cfg", e);
			throw new SlikException("While read BprkClient.cfg", e);
		}

		if (setupService.isClientTypeOJK()) {
			mainVBox.getChildren().remove(preparationAndSendingSettingVBox);
			// mainVBox.getChildren().remove(openErrorFileSettingVBox);
			mainVBox.getChildren().remove(openMasterDataSettingVBox);
		} else {
			// mainVBox.getChildren().remove(fillerHBox);
		}
		Tooltip.install(submissionSourceDirTooltipImage, submissionSourceDirTooltip);
		Tooltip.install(submissionSourceDirTooltipImage1, submissionSourceDirTooltip1);
		Tooltip.install(submissionSourceDirTooltipImage11, submissionSourceDirTooltip11);
		Tooltip.install(submissionSourceDirTooltipImage11111111, submissionSourceDirTooltip11111111);
	}

	@Override
	public void setStage(Stage stage) {
		super.setStage(stage);
	}

	private void initDirectorySetting(TextField textField, Button button, ConfigString configString) {
		textField.setText(configService.getStringProperty(configString, ""));
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				DirectoryChooser directoryChooser = new DirectoryChooser();
				File directory = new File(textField.getText());
				if (directory.exists() && directory.isDirectory())
					directoryChooser.setInitialDirectory(directory);
				// directory = directoryChooser.showDialog(mainApplication.getPrimaryStage());
				directory = directoryChooser.showDialog(stage);
				if (directory != null) {
					textField.setText(directory.getAbsolutePath());
				}
			}
		});
	}

	private void resetSetting(TextField textField, ConfigString configString) {
		textField.setText(configString.getDefauldValue());
	}

	private void resetSetting(TextField textField, ConfigLong configLong) {
		textField.setText("" + configLong.getDefauldValue());
	}

	private void resetSetting(TextField textField, ConfigInteger configInteger) {
		textField.setText("" + configInteger.getDefauldValue());
	}

	private void initFileSetting(TextField textField, Button button, ConfigString configString) {
		textField.setText(configService.getStringProperty(configString, ""));
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				FileChooser fileChooser = new FileChooser();
				File file = new File(textField.getText());
				if (file.getParentFile().exists()) {
					fileChooser.setInitialDirectory(file.getParentFile());
					fileChooser.setInitialFileName(file.getName());
				}
				file = fileChooser.showOpenDialog(mainApplication.getPrimaryStage());
				if (file != null) {
					textField.setText(file.getAbsolutePath());
				}
			}
		});
	}

	@FXML
	private void handleClose() {
		stage.close();
	}

	@FXML
	private void handleTestConnection() {
		appCtx.getExecutor().execute(() -> handleTestConnectionReal());
	}

	private void handleTestConnectionReal() {
		try {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					setBusy(true);
					testConnectionLabel.setText("");
					testConnectionVisible.setValue(false);
				}
			});

			ConnectionType connectionType = ConnectionType.valueOf(radioButtonGroup.getSelectedId().split("_")[0]);
			ProxyConfig proxyConfig = null;
			if (connectionType == ConnectionType.internet && StringUtils.isNotEmpty(proxyHostField.getText())) {

				proxyConfig = ProxyConfig.builder().host(proxyHostField.getText())
						.port(NumberUtil.parseInteger(proxyPortField.getText(), 8080)).user(proxyUserField.getText())
						.password(proxyPasswordField.getText()).build();
			}

			// http connectiontest

			boolean success = false;
			if (httpService.sendConnectionTest(OjkClientConstant.getHttpBaseUrl(connectionType), proxyConfig)) {
				if (securityService.isOnlineLogin()) {
					try {
						success = ftpService.sendConnectionTest(connectionType, proxyConfig);
					} catch (Throwable e) {
						Platform.runLater(new Runnable() {
							@Override
							public void run() {
								testConnectionStatus.set(false);
								testConnectionLabel.setText("koneksi gagal");
								testConnectionLabel.setStyle("-fx-text-fill: red;");

								AlertUtil.showError(logger,
										"Test koneksi ke slik server sukses.\n Test pengiriman file gagal!", e);
							}
						});
					}
				} else {
					success = true;
					AlertUtil.showAlertSafe(AlertType.INFORMATION, "Test Koneksi", "Test Koneksi",
							"Test koneksi ke slik server sukses\n"
									+ "Test pengiriman file tidak dilakukan, hanya dapat dilakukan saat login online!");
				}
			}

			boolean finalSuccess = success;
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					if (finalSuccess) {
						testConnectionStatus.set(true);
						testConnectionLabel.setText("koneksi sukses");
						testConnectionLabel.setStyle("-fx-text-fill: green;");
					} else {
						testConnectionStatus.set(false);
						testConnectionLabel.setText("koneksi gagal");
						testConnectionLabel.setStyle("-fx-text-fill: red;");
					}
				}
			});

		} catch (Throwable e) {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					testConnectionStatus.set(false);
					testConnectionLabel.setText("koneksi gagal");
					testConnectionLabel.setStyle("-fx-text-fill: red;");

					AlertUtil.showError(logger, "Koneksi gagal", e);
				}
			});
		} finally {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					testConnectionVisible.setValue(true);
					setBusy(false);
				}
			});
		}
	}

	@FXML
	private void handleSave() {
		List<String> errors = new ArrayList<>();
		Map<Config<?>, String> configMap = new HashMap<>();

		readString(configMap, errors, submissionSourceDir, submissionSourceDirField);
		readString(configMap, errors, submissionProcessDir, submissionProcessDirField);
		readString(configMap, errors, submissionDoneDir, submissionDoneDirField);
		readString(configMap, errors, sendindSourceDir, sendindSourceDir.getDefaultValueAsString());
		readString(configMap, errors, errorDataSourceDir, errorDataSourceDirField);
		readString(configMap, errors, errorDataDoneDir, errorDataDoneDirField);
		readString(configMap, errors, masterDataSourceDir, masterDataSourceDirField);
		readString(configMap, errors, masterDataDoneDir, masterDataDoneDirField);
		readString(configMap, errors, updateOfflineFile, updateOfflineFileField);
		configMap.put(connectionType, ConnectionType.valueOf(radioButtonGroup.getSelectedId().split("_")[0]).name());
		readString(configMap, errors, splitFileSize, splitFileSizeField);
		readString(configMap, errors, maxErrorCount, maxErrorCountField);
		readString(configMap, errors, maxThread, maxThreadField);
		readString(configMap, errors, proxyHost, proxyHostField);

		readString(configMap, errors, proxyPort, proxyPortField);

		readString(configMap, errors, proxyUser, proxyUserField);
		readString(configMap, errors, proxyPassword, proxyPasswordField);

		if (errors.size() > 0) {
			AlertUtil.showAlert(AlertType.ERROR, "Kesalahan", "Kesalahan",
					errors.stream().collect(Collectors.joining("\n")));
		} else {
			// min
			Tupple2<Boolean, Integer> minResult = validateInt(minMemoryField, " \"Minimum Memori\" ",
					minMemoryField.getText(), 1024, true, 256, 60000);
			if (!minResult.getA())
				return;

			// max
			Tupple2<Boolean, Integer> maxResult = validateInt(maxMemoryField, " \"Maksimum Memori\" ",
					maxMemoryField.getText(), 1024, true, 512, 60000);
			if (!maxResult.getA())
				return;

			// min < max
			if (minResult.getB() >= maxResult.getB()) {
				String message = "Nilai minimum harus lebih kecil nilai maksimum!";
				AlertUtil.showAlert(AlertType.ERROR, "Kesalahan", "Kesalahan", message);
				return;
			}

			if (isJvmSettingChange()) {
				if (AlertUtil.confirmDialog("Konfirmasi Restart", "Konfirmasi Restart",
						"Perubahan yang anda lakukan harus merestart aplikasi. Apakah anda yakin?")) {
					slikClientCfg.setXms(minResult.getB());
					slikClientCfg.setXmx(maxResult.getB());

					try {
						slikClientCfg.store();
					} catch (IOException e) {
						AlertUtil.showError(logger, "Kesalahan saat simpan BprkClient.cfg", e);
					}

					configService.save(configMap);

					stage.close();
					mainApplication.restartApplication();
				}
			} else {
				configService.save(configMap);
				stage.close();
			}
		}
	}

	@FXML
	private void handleReset() {
		resetSetting(submissionSourceDirField, submissionSourceDir);
		resetSetting(submissionProcessDirField, submissionProcessDir);
		resetSetting(submissionDoneDirField, submissionDoneDir);

		resetSetting(splitFileSizeField, splitFileSize);
		resetSetting(maxErrorCountField, maxErrorCount);
		resetSetting(maxThreadField, maxThread);

		resetSetting(errorDataSourceDirField, errorDataSourceDir);
		resetSetting(errorDataDoneDirField, errorDataDoneDir);

		resetSetting(masterDataSourceDirField, masterDataSourceDir);
		resetSetting(masterDataDoneDirField, masterDataDoneDir);

		resetSetting(updateOfflineFileField, updateOfflineFile);

		minMemoryField.setText("512");
		maxMemoryField.setText("2048");

		radioButtonGroup.setSelected(connectionType.getDefauldValue().getRadioButtonId());
		resetSetting(proxyHostField, proxyHost);
		resetSetting(proxyPortField, proxyPort);
		resetSetting(proxyUserField, proxyUser);
		resetSetting(proxyPasswordField, proxyPassword);
	}

	private boolean isJvmSettingChange() {
		return slikClientCfg.isJvmSettingChange(Integer.parseInt(minMemoryField.getText()),
				Integer.parseInt(maxMemoryField.getText()));
	}

	private void readString(Map<Config<?>, String> configMap, List<String> errors, Config<?> config,
			TextField textField) {
		readString(configMap, errors, config, textField.getText());
	}

	private void readString(Map<Config<?>, String> configMap, List<String> errors, Config<?> config,
			String defaultValue) {
		config.validate(defaultValue, errors);

//		if ( config.isRequired() && StringUtils.isEmpty(valueString) ){
//			errors.add(config.getName() + " wajib diisi");
//			return;
//		}
		try {
			config.castValue(defaultValue);
		} catch (Throwable t) {
			errors.add(config.getName() + ". " + t.getMessage());
			return;
		}
		configMap.put(config, defaultValue);
	}

	private void addLongValidation(TextField textField, int maxLength, int minValue, int maxValue) {
		textField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (newValue.length() > maxLength) {
					newValue = newValue.substring(0, maxLength);
				}
				if (!newValue.matches("\\d*")) {
					newValue = newValue.replaceAll("[^\\d]", "");
				}
				newValue = newValue.replaceAll("(?<!\\d)0+(?=\\d+)", "");
				int tmp = NumberUtils.toInt(newValue, minValue);
				if (tmp < minValue) {
					tmp = minValue;
				} else if (tmp > maxValue) {
					tmp = maxValue;
				}
				textField.setText(String.valueOf(tmp));
			}
		});
	}

	private void addIntValidation(TextField textField, int maxLength) {
		textField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (newValue.length() > maxLength) {
					newValue = newValue.substring(0, maxLength);
				}
				if (!newValue.matches("\\d*")) {
					newValue = newValue.replaceAll("[^\\d]", "");
				}
				newValue = newValue.replaceAll("(?<!\\d)0+(?=\\d+)", "");
				textField.setText(newValue);
			}
		});
	}

	private Tupple2<Boolean, Integer> validateInt(TextField textField, String fieldName, String textValue, int defValue,
			boolean required, int min, int max) {
		boolean valid = true;
		int result = defValue;
		if (StringUtils.isEmpty(textValue) && required) {
			valid = false;
			String message = "Setting Memori Wajib diisi";
			AlertUtil.showAlert(AlertType.ERROR, "Kesalahan", message, message);
		}

		if (valid && StringUtils.isNotEmpty(textValue)) {
			try {
				result = Integer.parseInt(textValue);
				if (min >= 0 && result < min) {
					valid = false;
					String message = "Nilai minimum " + fieldName + " " + min;
					AlertUtil.showAlert(AlertType.ERROR, "Kesalahan", message, message);
				} else if (max >= 0 && result > max) {
					valid = false;
					String message = "Nilai maximum " + fieldName + " " + max;
					AlertUtil.showAlert(AlertType.ERROR, "Kesalahan", message, message);
				}
			} catch (Throwable t) {
				valid = false;
				String message = "Nilai harus numerik";
				AlertUtil.showAlert(AlertType.ERROR, "Kesalahan", message, message);
			}
		}

		if (!valid) {
			textField.requestFocus();
		}

		return Tupple2.<Boolean, Integer>builder().a(valid).b(result).build();
	}

	private Tupple2<Boolean, Long> validateLong(TextField textField, String textValue, long defValue, boolean required,
			long min, long max) {
		boolean valid = true;
		long result = defValue;
		if (StringUtils.isEmpty(textValue) && required) {
			valid = false;
			String message = "Setting Memori Wajib diisi";
			AlertUtil.showAlert(AlertType.ERROR, "Kesalahan", message, message);
		}

		if (valid && StringUtils.isNotEmpty(textValue)) {
			try {
				result = Integer.parseInt(textValue);
				if (min >= 0 && result < min) {
					valid = false;
					String message = "Nilai minimum " + min;
					AlertUtil.showAlert(AlertType.ERROR, "Kesalahan", message, message);
				} else if (max >= 0 && result > max) {
					valid = false;
					String message = "Nilai maximum " + max;
					AlertUtil.showAlert(AlertType.ERROR, "Kesalahan", message, message);
				}
			} catch (Throwable t) {
				valid = false;
				String message = "Nilai harus numerik";
				AlertUtil.showAlert(AlertType.ERROR, "Kesalahan", message, message);
			}
		}

		if (!valid) {
			textField.requestFocus();
		}

		return Tupple2.<Boolean, Long>builder().a(valid).b(result).build();
	}

	private final BooleanProperty busyProperty = new SimpleBooleanProperty();

	public synchronized void setBusy(boolean busy) {
		busyProperty.set(busy);
	}

	@Override
	public void reset() {
	}

	@Override
	public boolean isReused() {
		return false;
	}

}
