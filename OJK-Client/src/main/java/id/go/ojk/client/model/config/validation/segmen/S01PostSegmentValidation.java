package id.go.ojk.client.model.config.validation.segmen;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.bind.ProgressSegmentFile;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.client.service.validation.ValidationErrorWriter;
import id.go.ojk.lib.client.model.config.validation.segmen.model.SummaryRefRaw;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import id.go.ojk.lib.client.service.context.ApplicationContext;

@XStreamAlias("s01PostSegmentValidation")
public class S01PostSegmentValidation extends BasePostSegmentValidation {
	
	private int param1;
	
	public S01PostSegmentValidation(){
		super();
	}

	public S01PostSegmentValidation(String parameter){
		super(parameter);
	}

	@XStreamOmitField
	private ReferenceService referenceService = null;
	@Override
	public void setApplicationContext(ApplicationContext appCtx) {
		this.appCtx = appCtx;
		if ( appCtx != null ){
			this.referenceService = appCtx.getService(ReferenceService.class);
		}
	}

	@Override
	public S01PostSegmentValidation initialized() {
		super.initialized();
		this.param1 					= getIntParameter("param1");		
		return this;
	}

	@XStreamOmitField
	private DateTimeFormatter yyyyMMFormater = DateTimeFormatter.ofPattern("yyyyMM"); 
		
	@Override
	protected void validatePostReal(List<ProgressSegmentFile> segmentFiles, SubmissionData submissionData, SubmissionFormat submissionFormat) throws IOException {
		if (submissionData.getValidationRelationModel().summaryRefRawMap.size() > 0 ){
			Set<Entry<String, SummaryRefRaw>> entrySet = submissionData.getValidationRelationModel().summaryRefRawMap.entrySet();
			for (Entry<String, SummaryRefRaw> entry : entrySet) {
				String[] accountNumberCif = entry.getKey().split("[#]");
				String accountNumber = accountNumberCif[0];
				String cif = accountNumberCif[1];
				SummaryRefRaw summaryRef = entry.getValue();
				
				ValidationError validationError = new ValidationError(
					null, ValidationErrorCode.E40_02_SUMMARY_REQUIRED,
					summaryRef.getFacilityType(), cif,  accountNumber
				);
				
				ValidationErrorWriter validationErrorWriter = segmentFiles.get(segmentFiles.size() - 1);
				validationErrorWriter.writeError(null, validationError.toSinggleErrorString());
			}
		}		
	}
	
}

