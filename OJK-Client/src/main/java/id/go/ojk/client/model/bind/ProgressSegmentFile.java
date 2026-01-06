package id.go.ojk.client.model.bind;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.validation.ValidationErrorWriter;
import id.go.ojk.lib.client.model.compression.FileIntegrity;
import id.go.ojk.lib.client.util.FormatUtil;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Getter;
import lombok.Setter;

public class ProgressSegmentFile implements ValidationErrorWriter {

	private FileIntegrity fileIntegrity;

	private final DoubleProperty persentageProgressProperty = new SimpleDoubleProperty();
	private final StringProperty persentageLabelProperty = new SimpleStringProperty();

	private final StringProperty totalProperty = new SimpleStringProperty();
	private final StringProperty totalErrorProperty = new SimpleStringProperty();

	private final BooleanProperty finishProperty = new SimpleBooleanProperty();
	private final BooleanProperty postValidationProperty = new SimpleBooleanProperty();
	private final BooleanProperty errorProperty = new SimpleBooleanProperty();

	private long totalRow;

	private ProgressPreparationAndSending progressModel;

	@Getter @Setter private Long filenameSequence;
	
	@Getter private Map<Integer, Long> rowNumPositionMap;
	@Getter private Set<Integer> errorRowNum; 
	
	public ProgressSegmentFile(FileIntegrity fileIntegrity, ProgressPreparationAndSending progressModel){
		this.progressModel = progressModel;
		setFileIntegrity(fileIntegrity);
		setPersentage(0d, false);
		setTotal(0);
		setTotalError(0l);
		rowNumPositionMap = new HashMap<>();
		errorRowNum = new HashSet<>();
	}

	//~ method
	
	public synchronized boolean addErrorRowNum(Integer rowNum){
		return errorRowNum.add(rowNum);
	}

	public long getFileSize(){
		return fileIntegrity.getLength();
	}

	private long processedSize = 0;
	public void addProcessedSize(long addProcessedSize, boolean finished, boolean waitPostValidation) {
		if ( finished ){
			this.processedSize = getFileSize();
			setPersentage(1d, waitPostValidation);
			progressModel.addProcessedFileSize(addProcessedSize, true);
		}  else {
			this.processedSize += addProcessedSize;
			if ( getFileSize() != 0 ) {
				double privPersentage = persentageProgressProperty.get();
				double persentage = (double)this.processedSize/ (double)getFileSize();
				if ( persentage > 1 )
					persentage = 1;
				
				if ( persentage > privPersentage )
					setPersentage(persentage, waitPostValidation);
			}
			progressModel.addProcessedFileSize(addProcessedSize, false);
		}
	}
	
	public long getProcessedSize() {
		return processedSize;
	}

	//~ getter setter

	public FileIntegrity getFileIntegrity() {
		return fileIntegrity;
	}
	public void setFileIntegrity(FileIntegrity fileIntegrity) {
		this.fileIntegrity = fileIntegrity;
	}

	public long getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(long totalRow) {
		this.totalRow = totalRow;
	}

	//~ DoubleProperty persentageProgressProperty;

	private DecimalFormat decimalFormat = new DecimalFormat("#.##");

	public DoubleProperty persentageProgressProperty(){
		return persentageProgressProperty;
	}

	public void setPersentage(Double persentage, boolean waitPostValidation){
		persentageProgressProperty.set(persentage);
		persentageLabelProperty.set( decimalFormat.format(persentage * 100) + "%" );
		if ( persentage == 1d ){
			setFinish(!waitPostValidation);
			setPostValidation(waitPostValidation);
			//postValidationProperty
			//setFinish(true);			
		}
	}

	//~ StringProperty persentageLabelProperty;

	public StringProperty persentageLabelProperty(){
		return persentageLabelProperty;
	}

	//~ StringProperty totalProperty;

	public StringProperty totalProperty(){
		return totalProperty;
	}

	public void setTotal(int total){
		if ( progressModel.getSubmissionData().isRunInJavaFx() ){
			Platform.runLater(new Runnable() {
			    @Override
			    public void run() {
					totalProperty.set(FormatUtil.formatWithThousandSeparator(total));
			    }
			});			
		} else {
			totalProperty.set(FormatUtil.formatWithThousandSeparator(total));
		}
	}

	//~ StringProperty totalErrorProperty;

	private long totalError;
	public StringProperty totalErrorProperty(){
		return totalErrorProperty;
	}

	public void setTotalError(long totalError){
		this.totalError = totalError;
		if ( progressModel.getSubmissionData().isRunInJavaFx() ){
			Platform.runLater(new Runnable() {
			    @Override
			    public void run() {
					totalErrorProperty.set("Jumlah Kesalahan : " + FormatUtil.formatWithThousandSeparator(totalError) );
					errorProperty().set(totalError > 0);
			    }
			});
		} else {
			totalErrorProperty.set("Jumlah Kesalahan : " + FormatUtil.formatWithThousandSeparator(totalError) );
			errorProperty().set(totalError > 0);			
		}
	}

	public long getTotalError(){
		return totalError;
	}

	//~ BooleanProperty finishProperty

	public BooleanProperty finishProperty(){
		return finishProperty;
	}

	public void setFinish(boolean finish){
//		Platform.runLater(new Runnable() {
//		    @Override
//		    public void run() {
//				finishProperty.set(finish);
//				if ( finish ){
//					postValidationProperty.set(false);
//				}
//		    }
//		});			

		finishProperty.set(finish);
		if ( finish ){
			postValidationProperty.set(false);
		}
	}
	
	//~ BooleanProperty postValidationProperty

	public BooleanProperty postValidationProperty(){
		return postValidationProperty;
	}

	public void setPostValidation(boolean postValidation){
		postValidationProperty.set(postValidation);
	}

	//~ BooleanProperty errorProperty
	public BooleanProperty errorProperty(){
		return errorProperty;
	}

	//~ process

	private File errorFile;
	public void setErrorFile(File errorFile) {
		this.errorFile = errorFile;
	}
	public File getErrorFile() {
		return errorFile;
	}
	
	//~ write error
	
	public void cachePosition(ValidationResult validationResult){
		rowNumPositionMap.put(validationResult.lineNumber, validationResult.bytePosition);
	}
	
	private long errorCounter = 0;
	
	public void synchTotalError(){
		setTotalError(errorCounter);
	}
	
	private FileWriter errorFileWriter;

	public void openErrorFile(boolean append) throws IOException{
		this.errorFileWriter = new FileWriter(errorFile, append);	
	}
	
	public void writeReserveErrorHeader() throws IOException{
		errorFileWriter.write(StringUtils.rightPad("", 22, ' ') + "\n");
	}
	
	public synchronized void writeErrorSort(ValidationResult value) throws IOException {
		value.sortError();
		writeError(value);
	}

	@Override
	public void writeError(ValidationResult value) throws IOException {
	  // 12/11/2025 - Usulan UAT #49 BPJS Kesehatan
	  ProgressSegment segment = this.progressModel.getSegments().stream().findFirst().orElseGet(null);
	  String res = value.toErrorString();
	  if(segment != null) {
	    res = value.toErrorString(segment.getSubmissionFormat());
	  }
	  writeError(value.lineNumber, res);
	}
	
	@Override
	public synchronized void writeError(Integer rowNumber, String error) throws IOException {
		
		if ( rowNumber == null ){
			errorCounter++;
		} else if ( addErrorRowNum(rowNumber) ){
			errorCounter++;
		}
		
		writeError(error);
	}
	
	public void writeError(String error) throws IOException {
		errorFileWriter.write(error);
	}
		
	public void closeErrorFile(){
		IOUtils.closeQuietly(errorFileWriter);
	}

	public void writeErrorHeaderAndFooter() {
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(getErrorFile(), "rw");
			raf.seek(0);
			String header = "TOTAL KESALAHAN|" + totalError;
			header = StringUtils.rightPad(header, 22, ' ') + "\n";
			raf.write( header.getBytes() );
			raf.seek(getErrorFile().length());
			raf.write("\nSELESAI".getBytes());
			raf.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 IOUtils.closeQuietly(raf);
		}
	}
	
	//~ random access original File
	
	private RandomAccessFile sourceRaf;
	
	public void openSourceRaf() throws FileNotFoundException{
		sourceRaf = new RandomAccessFile(fileIntegrity.getFile(), "r");
	}
	
	public void closeSourceRaf(){
		IOUtils.closeQuietly(sourceRaf);
	}
	
	public String readLineSource(Integer rowNum) throws IOException{
		Long position = rowNumPositionMap.get(rowNum);
		if ( position == null )
			return "";
		sourceRaf.seek(position);
		return sourceRaf.readLine();
	}

}
