package id.go.ojk.client.model.config.validation.segmen;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.bind.ProgressSegment;
import id.go.ojk.client.model.bind.ProgressSegmentFile;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.service.validation.ValidationErrorWriter;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import id.go.ojk.lib.client.service.context.ApplicationContext;
import id.go.ojk.lib.client.service.validation.DebtorRow;
import lombok.Data;

/**
 * 
 * segmentCodeMap=1=>D01#1#true|2=>D02#1#false
 *
 */
@XStreamAlias("debtorCreateFacilityPostCheck")
public class DebtorCreateFacilityPostCheck extends BasePostSegmentValidation {

	private Map<Integer, DebtorSegment> segmentCodeMap;

	public DebtorCreateFacilityPostCheck(){
		super();
	}

	public DebtorCreateFacilityPostCheck(String parameter){
		super(parameter);
	}

	@Override
	public void setApplicationContext(ApplicationContext appCtx) {
		this.appCtx = appCtx;
	}

	@Override
	public DebtorCreateFacilityPostCheck initialized() {
		super.initialized();
		Map<String, String> stringMap 			= getStringMapParameter("segmentCodeMap");
		segmentCodeMap = new TreeMap<>();
		for (Entry<String, String> entry : stringMap.entrySet()) {
			segmentCodeMap.put(Integer.parseInt(entry.getKey()), new DebtorSegment(entry.getValue()));
		}

		return this;
	}
	
	@XStreamOmitField
	private Map<Integer, ProgressSegment> openErrorFile = null; 
	
	@Override
	public void validatePost(Map<String, ProgressSegment> progressSegmentMap, SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationErrorWriter validationErrorWriter) throws IOException {
		if ( !submissionData.isValidateBetweenRow() ){
			return;
		}

		try {
			openErrorFile = new HashMap<>();
			for (Entry<Integer, DebtorSegment> entry : segmentCodeMap.entrySet()) {
				DebtorSegment debtorSegment = entry.getValue();
				ProgressSegment progressSegment = progressSegmentMap.get(debtorSegment.getSegmentCode());
				List<ProgressSegmentFile> segmentFiles = progressSegment.getSegmentFiles();				
				openAppendFileError(segmentFiles);
				
				openErrorFile.put(entry.getKey(), progressSegment);
			}
			validatePostReal(progressSegmentMap, submissionData, submissionFormat);
		} finally {
			closeAllFileError();
		}

		for (Entry<Integer, ProgressSegment> entry : openErrorFile.entrySet()) {
			for (ProgressSegmentFile progressSegmentFile : entry.getValue().getSegmentFiles()) {
				progressSegmentFile.synchTotalError(); 
			}
			
			String segmentCode = entry.getValue().getSubmissionFormat().getCode();
			boolean setFinish = false;
			for (DebtorSegment debtorSegment : segmentCodeMap.values()) {
				if ( debtorSegment.getSegmentCode().equals(segmentCode) ){
					setFinish = debtorSegment.isSetFinish();
					break;
				}
			}
			if ( setFinish ){
				setFinishUi(entry.getValue(), submissionData);
			}
		}
		
	}
	
	//setFinish=true&
	
	protected void validatePostReal(Map<String, ProgressSegment> progressSegmentMap, SubmissionData submissionData, SubmissionFormat submissionFormat) throws IOException{
		for (Entry<Integer, DebtorSegment> entry : segmentCodeMap.entrySet()) {
			DebtorSegment debtorSegment = entry.getValue();
			ProgressSegment progressSegment = openErrorFile.get(entry.getKey());
			ConcurrentMap<String, DebtorRow> debtorRowMap = submissionData.getValidationRelationModel().debtorCreateStorage.get(entry.getKey());
			Set<String> cifCs = debtorRowMap.keySet();
			
			SubmissionFormat debtorSubmissionFormat = progressSegmentMap.get(debtorSegment.getSegmentCode()).getSubmissionFormat();
			SubmissionField cifSF= debtorSubmissionFormat.getFields().get(debtorSegment.getCifFieldNo());
			for (String cifC : cifCs) {
				DebtorRow debtorRow = debtorRowMap.get(cifC);
				if ( !debtorRow.isHasF() ){
					ValidationErrorWriter validationErrorWriter = progressSegment.getSegmentFiles().get(debtorRow.getFileSeq() - 1);
					ValidationError error = new ValidationError(cifSF, ValidationErrorCode.E40_20_FAC_MUST_EXIST, cifC);
					validationErrorWriter.writeError(debtorRow.getLineNumber(), error.toSinggleErrorString(debtorRow.getLineNumber()));					
				}
			}
		}
	}

	protected void closeAllFileError() {
		if ( openErrorFile == null )
			return;	
		for (Entry<Integer, ProgressSegment> entry : openErrorFile.entrySet()) {
			closeAllFileError(entry.getValue().getSegmentFiles());
		}
	}
	
	@Data
	public static class DebtorSegment {
		private String segmentCode;
		private Integer cifFieldNo;
		private boolean setFinish;
		
		public DebtorSegment(String initParam){
			String[] initParamSplited = initParam.split("#");
			segmentCode = initParamSplited[0];
			cifFieldNo = Integer.parseInt(initParamSplited[1]);
			setFinish = Boolean.parseBoolean(initParamSplited[2]);
		}
	}
	

}
