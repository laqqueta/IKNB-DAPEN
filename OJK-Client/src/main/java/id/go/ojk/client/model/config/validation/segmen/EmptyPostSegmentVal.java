package id.go.ojk.client.model.config.validation.segmen;

import java.io.IOException;
import java.util.Map;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.bind.ProgressSegment;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.validation.ValidationErrorWriter;
import id.go.ojk.lib.client.model.constant.SegmentValidationType;
import id.go.ojk.lib.client.service.context.ApplicationContext;

/**
 * hanya untuk menandai agar tidak menutup file error
 *
 */
@XStreamAlias("emptyPostSegmentVal")
public class EmptyPostSegmentVal extends MapParamSegmentValidation {
		
	public EmptyPostSegmentVal(){
		super();
	}

	public EmptyPostSegmentVal(String parameter){
		super(parameter);
	}

	@Override
	public void setApplicationContext(ApplicationContext appCtx) {
		this.appCtx = appCtx;
	}

	@Override
	public EmptyPostSegmentVal initialized() {
		return this;
	}
	
	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
		//do nothing
	}
	
	@Override
	public void validatePost(Map<String, ProgressSegment> progressSegmentMap, SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationErrorWriter validationErrorWriter) throws IOException {
		//do nothing
	}
			
	@Override
	public SegmentValidationType getSegmentValidationType() {
		return SegmentValidationType.P;
	}	
	

}

