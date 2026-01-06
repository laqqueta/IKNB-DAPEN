package id.go.ojk.client.model.bind;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import org.apache.commons.compress.utils.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import id.go.ojk.client.model.config.SubmissionMetadata;
import id.go.ojk.client.service.SubmissionService;
import id.go.ojk.client.util.fx.FxmlLoaderUtil;
import id.go.ojk.client.vc.preparation.PreparationLogController;
import id.go.ojk.lib.client.exception.SlikException;
import id.go.ojk.lib.client.model.EvenOdd;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.YearMonth;
import id.go.ojk.lib.client.model.bind.ProgressModel;
import id.go.ojk.lib.client.model.bind.SendingModel;
import id.go.ojk.lib.client.model.encryption.EncryptionResult;
import id.go.ojk.lib.client.service.validation.ValidationRelationModel;
import id.go.ojk.lib.client.util.FormatUtil;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import lombok.Getter;
import lombok.Setter;

public class ProgressPreparationAndSending implements Closeable {

	private static Logger logger = LoggerFactory.getLogger(SubmissionService.class);

	private SubmissionMetadata metadata;

	//@Getter private boolean runInJavaFx = true;
	@Getter @Setter private boolean summary = false;
	@Getter @Setter private int updateEveryRowNumber = 10000;
	
	@Getter @Setter private String userId;
	@Getter @Setter private String jenisPelaporan;
	@Getter @Setter private File submissionDirectory;
	private String submissionId;
	@Getter @Setter private String submissionFTP;

	private File processDir;
	@Setter private File validationErrorDir;
	private File encryptionDir;
	private File archiveDir;

	private File finishedDir;
	private File readyToTransferDir;
	private File transferedDir;

	private final StringProperty totalErrorString = new SimpleStringProperty();
	
	@Getter @Setter private long readDirectoryTimeElapse;

	private ProgressModel validationProgressModel;
	private ProgressModel compressionEncryptionProgressModel;
	private ProgressModel archiveProgressModel;

	private final BooleanProperty readyToProcessProperty = new SimpleBooleanProperty();
	private final BooleanProperty inProcessProperty = new SimpleBooleanProperty();
	private final BooleanProperty sendFileProperty = new SimpleBooleanProperty();
	private final BooleanProperty sendFileEnableProperty = new SimpleBooleanProperty();

	private List<ProgressSegment> segments = new ArrayList<>();

	public ProgressPreparationAndSending(SubmissionMetadata metadata, boolean runInJavaFx){
		this.submissionData = new SubmissionData(true, runInJavaFx);
		this.metadata = metadata;
		
		//this.runInJavaFx = runInJavaFx;
		validationProgressModel = new ProgressModel("", runInJavaFx){
			@Override
			public void writeProcessLog(String message, boolean showOnScreen) {
				ProgressPreparationAndSending.this.writeProcessLog(message, showOnScreen);
			}
			
			@Override
			public synchronized boolean isStop() {
				return isRequestStop();
			};
		};

		compressionEncryptionProgressModel = new ProgressModel("", runInJavaFx){
			@Override
			public void writeProcessLog(String message, boolean showOnScreen) {
				ProgressPreparationAndSending.this.writeProcessLog(message, showOnScreen);
			}
			
			@Override
			public synchronized boolean isStop() {
				return isRequestStop();
			};
		};

		archiveProgressModel = new ProgressModel("", runInJavaFx){
			
			@Override
			public void writeProcessLog(String message, boolean showOnScreen) {
				ProgressPreparationAndSending.this.writeProcessLog(message, showOnScreen);
			}
			
			@Override
			public synchronized boolean isStop() {
				return isRequestStop();
			};
		};
		
		sendingModel = new SendingModel
				(
					new ProgressModel("", runInJavaFx){
						@Override
						public void writeProcessLog(String message, boolean showOnScreen) {
							ProgressPreparationAndSending.this.writeProcessLog(message, showOnScreen);
						};
						
						public synchronized boolean isStop() {
							return isRequestStop();		
						};
					}
				);

		
		validationProgressModel.setProgress(0d);
		compressionEncryptionProgressModel.setProgress(0d);
		archiveProgressModel.setProgress(0d);

	}
	
	public void setMetadata(SubmissionMetadata metadata) {
		this.metadata = metadata;
	}

	//~ other

	public void reset(){
		setSubmissionDirectory(null);
		submissionData.setDataYearMonth(null, null);

		validationProgressModel.reset();
		compressionEncryptionProgressModel.reset();
		
		archiveProgressModel.reset();
		
		sendingModel.reset(sendFileProperty.get());

		segments = new ArrayList<ProgressSegment>();
		setReadyToProcess(false);
		setInProcess(false);

		this.totalFileSize = null;
		processedFileSize = 0;
		setRequestStop(false);
		setAlertRequestStop(true);
		preparationLogMap.clear();
		
		readDirectoryTimeElapse = 0;
	}

	public void readyToProcess(ProgressPreparationAndSending from){
		this.submissionDirectory = from.getSubmissionDirectory();
		submissionData.setDataYearMonth(from.getSubmissionData().getDataYear(), from.getSubmissionData().getDataMonth());
		//setDataYearMonth(from.getDataYear(), from.getDataMonth());
		segments = from.getSegments();
		setReadyToProcess(true);
		setInProcess(false);
	}

	public void addSegment(ProgressSegment progressSegment){
		segments.add(progressSegment);
	}

	//~ other

	public Integer getTotalFile() {
		return segments == null ? 0 : segments.stream().mapToInt(e -> e.getTotalFile()).sum();
	}

	private Long totalFileSize;
	public Long getTotalFileSize() {
		long tmp = segments == null ? 0l : segments.stream().mapToLong(e -> e.getTotalFileSize()).sum();
		totalFileSize = new Long(tmp);
		return totalFileSize;
	}

	private long processedFileSize = 0;

	public long getProcessedFileSize() {
		return processedFileSize;
	}

	public void setProcessedFileSize(Long processedFileSize) {
		this.processedFileSize = processedFileSize;
	}

//	public void addProcessedFileSize(long addprocessedFileSize, boolean recalculate) {
	public synchronized void addProcessedFileSize(long addprocessedFileSize, boolean recalculate) {
		if ( recalculate ) {
			this.processedFileSize = segments.stream().mapToLong(ProgressSegment::getTotalProcessedSize).sum();
		} else {
			this.processedFileSize += addprocessedFileSize;
		}
		if ( getTotalFileSize() != 0 ) {
			double persentage = (double)this.processedFileSize/ (double)getTotalFileSize();
			if ( persentage > 1 )
				persentage = 1;
			
			double privPersentage = validationProgressModel.getProgress(); 
			if ( persentage > privPersentage )
				validationProgressModel.setProgress(persentage);
//			setValidationProgress(persentage);
		}
	}

	public long getTotalError(){
		return segments.stream().mapToLong(ProgressSegment::getTotalError).sum();
	}

	//~ segments

	public List<ProgressSegment> getSegments() {
		return segments;
	}

	public void setSegments(List<ProgressSegment> segments) {
		this.segments = segments;
	}

	//~ totalErrorString

	private long totalError;
	public void addTotalError(long add){
		totalError += totalError;
		synchTotalErrorString();
	}

	public void recalcTotalErrorString(){
		totalError = getTotalError();
		synchTotalErrorString();
	}

	public void synchTotalErrorString(){
		if ( submissionData.isRunInJavaFx() ){
			Platform.runLater(new Runnable() {
			    @Override
			    public void run() {
					totalErrorString.set("Total Kesalahan : " + FormatUtil.formatWithThousandSeparator(totalError) );
			    }
			});			
		} else {
			totalErrorString.set("Total Kesalahan : " + FormatUtil.formatWithThousandSeparator(totalError) );
		}
	}

	public StringProperty totalErrorString(){
		return totalErrorString;
	}

	//~ validationProgress
	
	public ProgressModel getValidationProgressModel() {
		return validationProgressModel;
	}
	
	//~ compression and ecnryption Progress

	public ProgressModel getCompressionEncryptionProgressModel() {
		return compressionEncryptionProgressModel;
	}

	//~ archiveProgressModel

	public ProgressModel getArchiveProgressModel() {
		return archiveProgressModel;
	}
	
	//~ BooleanProperty readyToProcessProperty

	public BooleanProperty readyToProcessProperty(){
		return readyToProcessProperty;
	}

	public void setReadyToProcess(boolean readyToProcess){
		readyToProcessProperty.set(readyToProcess);
	}

	//~ BooleanProperty inProcessProperty
	
	public BooleanProperty inProcessProperty(){
		return inProcessProperty;
	}

	public void setInProcess(boolean inProcess){
		inProcessProperty.set(inProcess);
	}

	//~ BooleanProperty sendFileProperty

	public BooleanProperty sendFileProperty(){
		return sendFileProperty;
	}

	public void setSendFile(boolean sendFile){
		sendFileProperty.set(sendFile);
	}

	public boolean isSendFile(){
		return sendFileProperty.get();
	}

	//~ BooleanProperty sendFileEnableProperty

	public BooleanProperty sendFileEnableProperty(){
		return sendFileEnableProperty;
	}

	public boolean getsendFileEnable(){
		return sendFileEnableProperty.get();
	}

	public void setSendFileEnable(boolean value){
		sendFileEnableProperty.set(value);
	}

	//~ getter setter

	public SubmissionMetadata getMetadata() {
		return metadata;
	}

	public File getProcessDir() {
		return processDir;
	}
	public void setProcessDir(File processDir) {
		this.processDir = processDir;

		String processDirPath = processDir.getAbsolutePath();

		this.validationErrorDir = new File(processDirPath + "/error");
		this.encryptionDir = new File(processDirPath + "/enkrip");
		this.archiveDir = new File(processDirPath + "/archive");
	}

	public File getValidationErrorDir() {
		return validationErrorDir;
	};

	public File getArchiveDir() {
		return archiveDir;
	}

	public File getEncryptionDir() {
		return encryptionDir;
	};

	public File getFinishedDir() {
		return finishedDir;
	};
	public void setFinishedDir(File finishedDir) {
		this.finishedDir = finishedDir;
		this.readyToTransferDir = new File(finishedDir.getAbsolutePath() + "/siap-kirim");
		this.transferedDir = new File(finishedDir.getAbsolutePath() + "/terkirim");
	};

	public File getReadyToTransferDir() {
		return readyToTransferDir;
	};
	public File getTransferedDir() {
		return transferedDir;
	};



	public String getSubmissionId() {
		return submissionId;
	}
	public void setSubmissionId(String submissionId) {
		this.submissionId = submissionId;
	}

	//~other method

	private FileOutputStream logOutputStream = null;
	private File logFile = null;
	public void startProcess() throws FileNotFoundException{
		setInProcess(true);
		processDir.mkdirs();
		logFile = new File(processDir.getAbsolutePath() + "/" + submissionId + ".log");
		logOutputStream = new FileOutputStream(logFile);
	}

	public void endProcess() {
		try {
			if ( isRequestStop() ) {
				writeProcessLog("Proses dihentikan oleh user", false);
			}
			close();
		} catch(Exception e){

		}
	}

	@Override
	public void close() throws IOException {
		setInProcess(false);
		IOUtils.closeQuietly(logOutputStream);
	}

	volatile private EvenOdd evenOdd = new EvenOdd(); 
	private VBox logProcessVbox;
	public void setLogProcessVbox(VBox logProcessVbox) {
		this.logProcessVbox = logProcessVbox;
	}

	public synchronized Label writeProcessLog(String message, boolean showInScreen){
		Label label = null;
		if ( submissionData.isRunInJavaFx()) {
	    	if ( showInScreen ){
	        	label = new Label();
	        	label.getStyleClass().add(evenOdd.nextCssClass());
	        	label.setText(message);
	        	label.setMinWidth(1500);
	        	label.setMaxWidth(Double.MAX_VALUE);    	
	        	label.setPadding(new Insets(3, 0, 3, 5));
	        	
	        	Label tmpLabel = label;
	    		Platform.runLater(new Runnable() {
	    		    @Override
	    		    public void run() {
	    		    	logProcessVbox.getChildren().add(tmpLabel);
	    		    }
	    		});    		
	    	}			
		}
		try {
			logOutputStream.write((message + "\n").getBytes());
		} catch (IOException e) {
			logger.error("", e);
		}
		return label;
	}
	
	private ConcurrentMap<String, Tupple2<GridPane, PreparationLogController>> preparationLogMap = new ConcurrentHashMap<>(); 
	public synchronized Tupple2<GridPane, PreparationLogController> writeProcessLogFile(String formatCode, ProgressSegmentFile progressSegmentFile){
		Tupple2<GridPane, PreparationLogController> preparationLog = null;
		
		if ( submissionData.isRunInJavaFx() ) {
			try {
				preparationLog = preparationLogMap.get(formatCode);
				if ( preparationLog == null ){
					preparationLog = FxmlLoaderUtil.loadFxml("vc/preparation/PreparationLog.fxml");
					preparationLog.getB().setFormatCode(formatCode);
					preparationLog.getB().setCssClass(evenOdd.nextCssClass());
					preparationLogMap.put(formatCode, preparationLog);
					
					Tupple2<GridPane, PreparationLogController> tmp = preparationLog; 
					Platform.runLater(new Runnable() {
					    @Override
					    public void run() {
							logProcessVbox.getChildren().add(tmp.getA());
					    }
					});
				}

				Tupple2<GridPane, PreparationLogController> tmp = preparationLog;
				Platform.runLater(new Runnable() {
				    @Override
				    public void run() {
				    	tmp.getB().appendFilePane(progressSegmentFile);
				    }
				});
			} catch (IOException e) {
				logger.error("", e);
			}			
		}
		
		return preparationLog;
	}

	//~ encryption result

	private EncryptionResult encryptionResult;
	public EncryptionResult getEncryptionResult() {
		return encryptionResult;
	}
	public void setEncryptionResult(EncryptionResult encryptionResult) {
		this.encryptionResult = encryptionResult;
	}

	//~ FTP

	private final SendingModel sendingModel;
	
	public SendingModel getSendingModel() {
		return sendingModel;
	}

	public SendingModel preparaSending(){
		sendingModel.reset(sendFileProperty.get());

		sendingModel.setSubmissionId(submissionId);
		sendingModel.setReadyToSendDir(getReadyToTransferDir());
		sendingModel.setTransferedDir(getTransferedDir());

		sendingModel.setSignatureFile(encryptionResult.getSignatureReadyToSendFile());
		sendingModel.setReadyToSendFiles(encryptionResult.getEncResultFiles().stream().map(e -> e.getFile()).collect(Collectors.toList()));
		sendingModel.getProgressModel().setTotalLength( sendingModel.getTotalFileSize());

		return sendingModel;
	}

	//~ request stop

	volatile private boolean requestStop = false;
	@Getter @Setter private boolean alertRequestStop = true;

	public synchronized void setRequestStop(boolean requestStop, boolean alertRequestStop) {
		setRequestStop(requestStop);
		this.alertRequestStop = alertRequestStop;
	}

	public synchronized void setRequestStop(boolean requestStop) {
		this.requestStop = requestStop;
		sendingModel.getProgressModel().setStop(true);
	}
	public synchronized boolean isRequestStop() {
		return requestStop;
	}

	volatile SlikException slikException;
	public synchronized SlikException getSlikException() {
		return slikException;
	}
	public synchronized void setSlikException(SlikException slikException) {
		this.slikException = slikException;
		this.requestStop = true;
	}
	
	//~ relation
	
	@Getter private SubmissionData submissionData;
	
	public static class SubmissionData{
		@Getter private boolean runInJavaFx = true;
		
		@Getter @Setter private ValidationRelationModel validationRelationModel;
		
		@Getter private String dataYear;
		@Getter private String dataMonth;
		@Getter private LocalDate dataYearMonth;
		@Getter private YearMonth dataYearMonthInt;
		
		/**
		 * edit online does not validate between row
		 */
		@Getter private boolean validateBetweenRow = true;

		/**
		 * SLIK Client and Sever Validation
		 * @param validateBetweenRow
		 */
		public SubmissionData(boolean validateBetweenRow, boolean runInJavaFx){
			this.validateBetweenRow = validateBetweenRow;
			this.runInJavaFx = runInJavaFx;
		}
		
		/**
		 * Edit Online
		 * @param dataYearMonth
		 * @param validateBetweenRow
		 */
		public SubmissionData(String dataYearMonth, boolean validateBetweenRow){
			setDataYearMonth(dataYearMonth);
			this.validateBetweenRow = validateBetweenRow;
			validationRelationModel = new ValidationRelationModel();
		}

		public void setDataYearMonth(String dataYearMonth) {
			setDataYearMonth(dataYearMonth.substring(0, 4), dataYearMonth.substring(4, 6));
		}
		
		public void setDataYearMonth(String dataYear, String dataMonth) {
			this.dataYear = dataYear;
			this.dataMonth = dataMonth;
			if ( this.dataYear == null || this.dataMonth == null ){
				dataYearMonth = null;
				dataYearMonthInt = null;
			} else {
				dataYearMonth = LocalDate.of(Integer.parseInt(this.dataYear), Month.of(Integer.parseInt(this.dataMonth)), 1).with(TemporalAdjusters.lastDayOfMonth());
				dataYearMonthInt = YearMonth.from(dataYearMonth);
			}			
		}

	}

}
