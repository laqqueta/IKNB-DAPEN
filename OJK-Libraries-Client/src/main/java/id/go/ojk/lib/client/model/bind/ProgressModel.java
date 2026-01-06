package id.go.ojk.lib.client.model.bind;

import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import id.go.ojk.lib.client.model.EvenOdd;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import lombok.Getter;
import lombok.Setter;

public class ProgressModel {

	private static Logger logger = LoggerFactory.getLogger(ProgressModel.class);

	private final BooleanProperty onProcessProperty = new SimpleBooleanProperty();
	private final DoubleProperty progressBarProperty = new SimpleDoubleProperty();
	private final StringProperty progressLabelProperty = new SimpleStringProperty();
	private final BooleanProperty showDirProperty = new SimpleBooleanProperty();
	
	private String prefix;
	private long totalLength;
	private long currentLength;

	private boolean runInJavaFx = true;

	private DecimalFormat decimalFormat = new DecimalFormat("#.##");
	
	private StatusCallback statusCallback;

	public ProgressModel(String prefix, boolean runInJavaFx){
		this.prefix = prefix;
		this.runInJavaFx = runInJavaFx;
		reset();
	}

	public ProgressModel(String prefix){
		this.prefix = prefix;
		reset();
	}

	public void reset(int status){
		setTotalLength(0l);
		setStop(false);
		setShowAlertOnStop(true);
		showDirProperty.set(false);
		setProgress(0d);
		updateStatus(status);
	}

	public void reset(){
		reset(StatusCallback.start);
	}

	public long getTotalLength() {
		return totalLength;
	}
	public void setTotalLength(long totalLength) {
		this.totalLength = totalLength;
		this.currentLength = 0;
		addProgress(0);
	}

	public synchronized void addProgress(long addProgress){
		currentLength += addProgress;
		double persentage = totalLength == 0 ? 0d : (double)currentLength/(double)totalLength;
		if ( persentage > 1 )
			persentage = 1;
		setProgress(persentage);
	}

	public void setProgress(double progress){
		if ( runInJavaFx ) {
			Platform.runLater(new Runnable() {
			    @Override
			    public void run() {
					progressBarProperty.set(progress);
					progressLabelProperty.set(prefix + " " + decimalFormat.format(progress * 100) + "%");
			    }
			});
		} else {
			progressBarProperty.set(progress);
			progressLabelProperty.set(prefix + " " + decimalFormat.format(progress * 100) + "%");
		}
	}
	
	public double getProgress(){
		return progressBarProperty.get();
	}

	public BooleanProperty onProcessProperty(){
		return onProcessProperty;
	}

	public DoubleProperty progressBarProperty(){
		return progressBarProperty;
	}

	public double getProgressValue(){
		return progressBarProperty.get();
	}

	public StringProperty progressLabelProperty(){
		return progressLabelProperty;
	}

	public String getLabelValue(){
		return progressLabelProperty.get();
	}
	
	public BooleanProperty showDirProperty(){
		return showDirProperty;
	}

	public boolean isShowDir(){
		return showDirProperty.get();
	}

	public void setShowDir(boolean value){
		showDirProperty.set(value);
	}

	//~ stop process

	@Getter @Setter private boolean showAlertOnStop = true;;
	
	public synchronized void setStop(boolean stop, boolean showAlertOnStop) {
		setStop(stop);
		this.showAlertOnStop = showAlertOnStop;
	}
	
	volatile private boolean stop;
	public synchronized boolean isStop() {
		return stop;
	}
	public synchronized void setStop(boolean stop) {
		this.stop = stop;
	}

	public synchronized boolean isOnProcess() {
		return onProcessProperty.get();
	}

	public synchronized void setOnProcess(boolean onProcess) {
		onProcessProperty.set(onProcess);
	}

	//~ log process

	private TextArea logProcessTextArea;
	private Logger processLogger;
	private OutputStream logOutputStream;

	public void writeProcessLog(String message){
		writeProcessLog(message, false);
	}

	public void writeProcessLog(String message, boolean showOnScreen){
		writeToScreen(message, showOnScreen);
		String msg = message + "\n";
		if ( processLogger != null )
			processLogger.info(message);

		if ( logOutputStream != null ) {
			try {
				logOutputStream.write(msg.getBytes());
			} catch (IOException e) {
				logger.error("", e);
			}
		}
	}
	
	volatile private EvenOdd evenOdd = new EvenOdd(); 
	private VBox logProcessVbox;
	public void setLogProcessVbox(VBox logProcessVbox) {
		this.logProcessVbox = logProcessVbox;
	}

	public void writeToScreen(String message, boolean showOnScreen){
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
			} else if ( logProcessTextArea != null ) {
				String msg = message + "\n";
				if ( showOnScreen && logProcessTextArea != null ){
					if ( runInJavaFx ) {
						Platform.runLater(new Runnable() {
						    @Override
						    public void run() {
						    	logProcessTextArea.appendText(msg);
						    }
						});
					} else {
						logProcessTextArea.appendText(msg);
					}
				}				
			}
		}
	}

	public TextArea getLogProcessTextArea() {
		return logProcessTextArea;
	};
	public void setLogProcessTextArea(TextArea logProcessTextArea) {
		this.logProcessTextArea = logProcessTextArea;
	};

	public Logger getProcessLogger() {
		return processLogger;
	};
	public void setProcessLogger(Logger processLogger) {
		this.processLogger = processLogger;
	};

	public OutputStream getLogOutputStream() {
		return logOutputStream;
	};
	public void setLogOutputStream(OutputStream logOutputStream) {
		this.logOutputStream = logOutputStream;
	};

	public boolean isRunInJavaFx() {
		return runInJavaFx;
	}
	public void setRunInJavaFx(boolean runInJavaFx) {
		this.runInJavaFx = runInJavaFx;
	}

	public void updateStatus(int status){
		if ( statusCallback != null )
			statusCallback.updateStatus(status);
	}
	public void setStatusCallback(StatusCallback statusCallback) {
		this.statusCallback = statusCallback;
	}

}
