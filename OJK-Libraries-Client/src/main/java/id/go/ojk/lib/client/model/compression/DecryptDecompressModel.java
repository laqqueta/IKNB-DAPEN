package id.go.ojk.lib.client.model.compression;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.compress.utils.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import id.go.ojk.lib.client.CollectionUtil;
import id.go.ojk.lib.client.DateUtil;
import id.go.ojk.lib.client.model.EvenOdd;
import id.go.ojk.lib.client.model.bind.ProgressModel;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import lombok.Getter;
import lombok.Setter;

public class DecryptDecompressModel {

	private static Logger logger = LoggerFactory.getLogger(DecryptDecompressModel.class);

	//~ Ojk
	
	@Getter @Setter private String memberTypeCode;
	@Getter @Setter private String memberCode;

	//~ End Ojk
	
	@Getter @Setter private String aesKeyBase64;
	
	volatile private boolean stopProsess;
	@Getter @Setter private String suffix;
	@Getter @Setter private File sourceDir;
	@Getter @Setter private File destDir;
	
	//~ from signature
	
	@Getter @Setter FileEncryptSignature fileEncryptSignature;
	
	//~ process
	
	@Getter @Setter private List<File> sourceFiles = new ArrayList<>();
	@Getter @Setter private List<File> resultFiles = new ArrayList<>();

	private final BooleanProperty readyToProcessProperty = new SimpleBooleanProperty();
	private final BooleanProperty inProcessProperty = new SimpleBooleanProperty();

	private final ProgressModel dearchiveProgressModel = new ProgressModel(""){
		public synchronized boolean isStop() {
			return DecryptDecompressModel.this.isStopProsess();
		};
		public synchronized void setStop(boolean stop) {
			DecryptDecompressModel.this.setStopProsess(stop);
		};
		public void writeProcessLog(String message, boolean showOnScreen) {
			DecryptDecompressModel.this.writeProcessLog(message, showOnScreen);
		};
	};
	
	private final ProgressModel decryptProgressModel = new ProgressModel(""){
		
		@Override
		public synchronized boolean isStop() {
			return DecryptDecompressModel.this.isStopProsess();
		};
		
		@Override
		public synchronized void setStop(boolean stop) {
			DecryptDecompressModel.this.setStopProsess(stop);
		};
		
		@Override
		public void writeProcessLog(String message, boolean showOnScreen) {
			DecryptDecompressModel.this.writeProcessLog(message, showOnScreen);
		};
		
	};

	public DecryptDecompressModel(){
	}

	public void reset(){
		setStopProsess(false);
		setSourceDir(null);
		setDestDir(null);
		
		setFileEncryptSignature(null);
		
		setSourceFiles(new ArrayList<>());
		setResultFiles(new ArrayList<>());
		setReadyToProcess(false);
		setInProcess(false);
		dearchiveProgressModel.reset();
		decryptProgressModel.reset();
		
		logProcessVbox.getChildren().clear();
	}

	public long getSourceSize(){
		if ( CollectionUtil.isEmpty(sourceFiles) )
			return 0l;
		return sourceFiles.stream().mapToLong(e -> e.length()).sum();
	}

	//~ BooleanProperty readyToProcessProperty

	public BooleanProperty readyToProcessProperty(){
		return readyToProcessProperty;
	}

	public boolean isReadyToProcess(){
		return readyToProcessProperty.get();
	}

	public void setReadyToProcess(boolean value){
		readyToProcessProperty.set(value);
	}

	//~ BooleanProperty inProcessProperty

	public BooleanProperty inProcessProperty(){
		return inProcessProperty;
	}

	public boolean isInProcess(){
		return inProcessProperty.get();
	}

	public void setInProcess(boolean value){
		inProcessProperty.set(value);
	}


	//~ getter setter

	public ProgressModel getDearchiveProgressModel() {
		return dearchiveProgressModel;
	}
	public ProgressModel getDecryptProgressModel() {
		return decryptProgressModel;
	}

	public synchronized boolean isStopProsess() {
		return stopProsess;
	}

	public synchronized void setStopProsess(boolean stopProsess) {
		this.stopProsess = stopProsess;
	}

//	public File getSourceDir() {
//		return sourceDir;
//	}
//
//	public void setSourceDir(File sourceDir) {
//		this.sourceDir = sourceDir;
//	}

//	public File getDestDir() {
//		return destDir;
//	}
//
//	public void setDestDir(File destDir) {
//		this.destDir = destDir;
//	}

//	public List<File> getSourceFiles() {
//		return sourceFiles;
//	}
//
//	public void setSourceFiles(List<File> sourceFiles) {
//		this.sourceFiles = sourceFiles;
//	}

//	public List<File> getResultFiles() {
//		return resultFiles;
//	}
//
//	public void setResultFiles(List<File> resultFiles) {
//		this.resultFiles = resultFiles;
//	}

	//~ log

	private FileOutputStream logOutputStream = null;
	private File logFile = null;
	public void startProcess() throws FileNotFoundException{
		setInProcess(true);
		destDir.mkdirs();
		logFile = new File(destDir.getAbsolutePath() + "/" + DateUtil.formatNow() + ".log");
		logOutputStream = new FileOutputStream(logFile);
	}

	public void finish() {
		setInProcess(false);
		setStopProsess(false);
		IOUtils.closeQuietly(logOutputStream);
		logOutputStream = null;
		readyToProcessProperty().set(false);
	}

	private TextArea logProcessTextArea;
	public void setLogProcessTextArea(TextArea logProcessTextArea) {
		this.logProcessTextArea = logProcessTextArea;
	}
	
	volatile private EvenOdd evenOdd = new EvenOdd(); 
	private VBox logProcessVbox;
	public void setLogProcessVbox(VBox logProcessVbox) {
		this.logProcessVbox = logProcessVbox;
	}


	public void writeProcessLog(String message, boolean showOnScreen){
		String msg = message + "\n";
		if ( showOnScreen ){
			if ( logProcessVbox != null ){
				Label label = new Label();
	        	label.getStyleClass().add(evenOdd.nextCssClass());
	        	label.setText(message);
	        	label.setMinWidth(1000);
	        	label.setMaxWidth(Double.MAX_VALUE);    	
	        	label.setPadding(new Insets(3, 5, 3, 10));
	        	
	        	Label tmpLabel = label;
	    		Platform.runLater(new Runnable() {
	    		    @Override
	    		    public void run() {
	    		    	logProcessVbox.getChildren().add(tmpLabel);
	    		    }
	    		});
			} else if ( logProcessTextArea != null ){
				Platform.runLater(new Runnable() {
				    @Override
				    public void run() {
				    	logProcessTextArea.appendText(msg);
				    }
				});
			}			
		}

		if ( logOutputStream != null ){
			try {
				logOutputStream.write(msg.getBytes());
			} catch (IOException e) {
				logger.error("", e);
			}
		}
	}

}
