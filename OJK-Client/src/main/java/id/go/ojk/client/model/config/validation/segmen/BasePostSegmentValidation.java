package id.go.ojk.client.model.config.validation.segmen;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.bind.ProgressSegment;
import id.go.ojk.client.model.bind.ProgressSegmentFile;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.validation.ValidationErrorWriter;
import id.go.ojk.lib.client.CollectionUtil;
import id.go.ojk.lib.client.model.constant.OjkClientConstant;
import id.go.ojk.lib.client.model.constant.SegmentValidationType;
import id.go.ojk.lib.client.service.context.ApplicationContext;
import javafx.application.Platform;

public abstract class BasePostSegmentValidation extends MapParamSegmentValidation {
	
	protected boolean setFinish;
	
	public BasePostSegmentValidation(){
		super();
	}

	public BasePostSegmentValidation(String parameter){
		super(parameter);
	}

	@Override
	public void setApplicationContext(ApplicationContext appCtx) {
		this.appCtx = appCtx;
	}
	
	public BasePostSegmentValidation initialized() {
		this.setFinish = getBooleanParameter("setFinish", false);
		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
		//empty on post validation 
	}
	
	@Override
	public void validatePost(Map<String, ProgressSegment> progressSegmentMap, SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationErrorWriter validationErrorWriter) throws IOException {
		if ( !submissionData.isValidateBetweenRow() ){
			return;
		}

		ProgressSegment progressSegment = progressSegmentMap.get(submissionFormat.getCode());
		List<ProgressSegmentFile> segmentFiles = progressSegment.getSegmentFiles();
		try {
			openAppendFileError(segmentFiles);
			openSourceRaf(segmentFiles);
			
			validatePostReal(segmentFiles, submissionData, submissionFormat);
		} finally {
			try {
				closeAllFileError(segmentFiles);				
			} catch (Throwable t){
				t.printStackTrace();
			}
			try {
				closeSourceRaf(segmentFiles);				
			} catch (Throwable t){
				t.printStackTrace();
			}
		}

		synchAllTotalError(progressSegmentMap, submissionFormat);
		if ( setFinish ){
			setFinishUi(progressSegment, submissionData);
		}

		//writeLogErrorHeaderFooter(progressSegmentMap, submissionFormat);
	}
	
//	protected void setFinishUi(List<ProgressSegment> progressSegments) {
//		for (ProgressSegment progressSegment : progressSegments) {
//			setFinishUi(progressSegments);
//		}
//	}
	
	protected void setFinishUi(ProgressSegment progressSegment, SubmissionData submissionData) {
		if(submissionData.isRunInJavaFx()){
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					for (ProgressSegmentFile progressSegmentFile : progressSegment.getSegmentFiles()) {
						progressSegmentFile.writeErrorHeaderAndFooter();
						progressSegmentFile.setFinish(true);
					}
				}
			});
		} else {
			for (ProgressSegmentFile progressSegmentFile : progressSegment.getSegmentFiles()) {
				progressSegmentFile.writeErrorHeaderAndFooter();
				progressSegmentFile.setFinish(true);
			}			
		}
	}
	
	protected void validatePostReal(List<ProgressSegmentFile> segmentFiles, SubmissionData submissionData, SubmissionFormat submissionFormat) throws IOException{
		//defauld no validation, override by sub class
	}
		
	@Override
	public SegmentValidationType getSegmentValidationType() {
		return SegmentValidationType.P;
	}
	
	//~ log error

	protected void synchAllTotalError(Map<String, ProgressSegment> progressSegmentMap, SubmissionFormat submissionFormat) throws IOException{
		ProgressSegment progressSegment = progressSegmentMap.get(submissionFormat.getCode());	
		for (ProgressSegmentFile progressSegmentFile : progressSegment.getSegmentFiles()) {
			progressSegmentFile.synchTotalError(); 
		}
	}
	
	protected void closeAllFileError(List<ProgressSegmentFile> segmentFiles) {
		for (ProgressSegmentFile progressSegmentFile : segmentFiles) {
			progressSegmentFile.closeErrorFile(); 
		}
	}

	protected void openAppendFileError(List<ProgressSegmentFile> segmentFiles) throws IOException{
		for (ProgressSegmentFile progressSegmentFile : segmentFiles) {
			progressSegmentFile.openErrorFile(true); 
		}
	}
	
//	protected void writeLogErrorHeaderFooter(Map<String, ProgressSegment> progressSegmentMap, SubmissionFormat submissionFormat){
//		ProgressSegment progressSegment = progressSegmentMap.get(submissionFormat.getCode());
//		for (ProgressSegmentFile progressSegmentFile : progressSegment.getSegmentFiles()) {
//			progressSegmentFile.writeErrorHeaderAndFooter();
//		}
//	}
	
	//~ source raf
	
	protected void openSourceRaf(List<ProgressSegmentFile> segmentFiles) throws IOException{
		for (ProgressSegmentFile progressSegmentFile : segmentFiles) {
			progressSegmentFile.openSourceRaf(); 
		}
	}

	protected void closeSourceRaf(List<ProgressSegmentFile> segmentFiles) {
		for (ProgressSegmentFile progressSegmentFile : segmentFiles) {
			progressSegmentFile.closeSourceRaf(); 
		}
	}
	
	protected String readLineSource(List<ProgressSegmentFile> segmentFiles, int fileSeq, Integer rowNum) throws IOException {
		return segmentFiles.get(fileSeq).readLineSource(rowNum);
	}

	protected void writeError(List<ProgressSegmentFile> segmentFiles, int fileSeq, Integer rowNum, List<ValidationError> errors) throws IOException {
		if ( CollectionUtil.isEmpty(errors) )
			return;

		ProgressSegmentFile segmentFile = segmentFiles.get(fileSeq - 1);
		String line = OjkClientConstant.postValidationShowDetailRow ? segmentFile.readLineSource(rowNum) : "";		
		segmentFile.writeError(rowNum, ValidationError.errorToString(rowNum, line, errors));
	}

}

