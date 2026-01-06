package id.go.ojk.client.vc;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.apache.commons.compress.utils.IOUtils;

import id.go.ojk.client.MainApplication;
import id.go.ojk.client.model.bind.ProgressSegment;
import id.go.ojk.client.model.bind.ProgressSegmentFile;
import id.go.ojk.lib.client.util.FormatUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class ProgressSegmentFileController extends BaseController {

	@FXML
	private AnchorPane progressPane;
	@FXML
	private HBox finishPane;
	@FXML
	private HBox waitPostValidationPane;

	@FXML
	private Label filePathLabel;
	@FXML
	private ProgressBar progressBar;
	@FXML
	private Label progressLabel;
	@FXML
	private Label totalDescriptionLabel;
	@FXML
	private Label totalLabel;
	@FXML
	private Button errorButton;

	@FXML
	protected void initialize() {
		super.initialize();
	}

	private ProgressSegment progressSegment;
	private ProgressSegmentFile progressSegmentFile;
	private TabPane logTabPane;

	public void set(ProgressSegment progressSegment, ProgressSegmentFile progressSegmentFile, TabPane logTabPane) {
		this.progressSegment = progressSegment;
		this.progressSegmentFile = progressSegmentFile;
		this.logTabPane = logTabPane;

		progressPane.visibleProperty().bind(
				progressSegmentFile.finishProperty().not().and(progressSegmentFile.postValidationProperty().not()));
		waitPostValidationPane.visibleProperty().bind(progressSegmentFile.postValidationProperty());
		finishPane.visibleProperty().bindBidirectional(progressSegmentFile.finishProperty());

		filePathLabel.setText(progressSegmentFile.getFileIntegrity().getFile().getAbsolutePath());
		progressBar.progressProperty().bindBidirectional(progressSegmentFile.persentageProgressProperty());
		progressLabel.textProperty().bindBidirectional(progressSegmentFile.persentageLabelProperty());
		
		String fileName = progressSegmentFile.getFileIntegrity().getFileName();
		if (fileName.endsWith(".txt")) {
			totalDescriptionLabel.setText("Jumlah total " + progressSegment.getSubmissionFormat().getName());
			totalLabel.textProperty().bindBidirectional(progressSegmentFile.totalProperty());
		} else if (fileName.endsWith(".pdf")) {
			totalDescriptionLabel.setText("Validasi");
			totalLabel.setText("PDF file");
		} else if (fileName.endsWith(".zip")) {
			totalDescriptionLabel.setText("Validasi");
			totalLabel.setText("Zip file");
		} else {
			totalDescriptionLabel.setText("Validasi");
			totalLabel.setText("File");
		}
		errorButton.textProperty().bindBidirectional(progressSegmentFile.totalErrorProperty());

		errorButton.visibleProperty().bind(progressSegmentFile.errorProperty());
		errorButton.setOnAction(e -> {
			Tab errorTab = createTab();
			if (!logTabPane.getTabs().contains(errorTab)) {
				logTabPane.getTabs().add(errorTab);
			}
			logTabPane.getSelectionModel().select(errorTab);
		});
	}

	private Tab errorTab;
	private AnchorPane errorPage;

	private Hyperlink fileHyperlink;
	private Label totalErrorLabel;
	private TextArea errorTextArea;

	private long lengthLimit = 500000;

	private Tab createTab() {
		if (errorTab == null) {
			int elementAt = progressSegment.getSegmentFiles().indexOf(progressSegmentFile);
			errorTab = new Tab();
			errorTab.setClosable(true);
			errorTab.setText("Log Validasi-" + progressSegment.getSubmissionFormat().getCode() + "-" + (elementAt + 1));

			FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("vc/ValidationErrorTab.fxml"));
			File errorFile = progressSegmentFile.getErrorFile();
			FileInputStream fis = null;
			RandomAccessFile randomAccessFile = null;
			try {
				fis = new FileInputStream(errorFile);
				errorPage = fxmlLoader.load();

				fileHyperlink = (Hyperlink) errorPage.lookup("#fileHyperlink");
				totalErrorLabel = (Label) errorPage.lookup("#totalErrorLabel");
				errorTextArea = (TextArea) errorPage.lookup("#errorTextArea");

				fileHyperlink.setText(errorFile.getName());
				fileHyperlink.setOnAction(e -> {
					File fileToOpen = null;
					if (errorFile.length() <= 50000000)
						fileToOpen = errorFile;
					else
						fileToOpen = errorFile.getParentFile();
					try {
						Desktop.getDesktop().open(fileToOpen);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				});
				totalErrorLabel.setText(FormatUtil.formatWithThousandSeparator(progressSegmentFile.getTotalError()));

				String content = "";
				if (errorFile.length() <= lengthLimit) {
					content = new String(IOUtils.toByteArray(fis));
				} else {
					randomAccessFile = new RandomAccessFile(progressSegmentFile.getErrorFile(), "r");
					randomAccessFile.seek(errorFile.length() - lengthLimit);
					String line = null;
					StringBuilder builder = new StringBuilder();

					boolean startAppend = false;
					int visibleRowCount = 0;
					while ((line = randomAccessFile.readLine()) != null) {
						if (line.startsWith("RECORD")) {
							visibleRowCount++;
						}
						if (startAppend) {
							builder.append(line).append("\n");
						} else if (line.startsWith("RECORD")) {
							startAppend = true;
							builder.append(line).append("\n");
						}
					}
					builder.insert(0, "Menampilkan baris error " + visibleRowCount + " terakhir!\nBuka direktori kesalahan atau buka file .err untuk melihat detil kesalahan.\n");

					content = builder.toString();
				}
				errorTextArea.setText(content);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				IOUtils.closeQuietly(fis);
				IOUtils.closeQuietly(randomAccessFile);
			}
			errorTab.setContent(errorPage);
		}
		return errorTab;
	}

}
