package id.go.ojk.client.model.config.validation.segmen;

import java.io.IOException;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.bind.ProgressSegmentFile;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.lib.client.service.context.ApplicationContext;

@XStreamAlias("setFinishPostSegmentValidation")
public class SetFinishPostSegmentValidation extends BasePostSegmentValidation {
		
	public SetFinishPostSegmentValidation(){
		super();
	}

	public SetFinishPostSegmentValidation(String parameter){
		super(parameter);
	}

	@Override
	public void setApplicationContext(ApplicationContext appCtx) {
		this.appCtx = appCtx;
	}

	@Override
	public SetFinishPostSegmentValidation initialized() {
		super.initialized();
		return this;
	}
	
	@Override
	protected void validatePostReal(List<ProgressSegmentFile> segmentFiles, SubmissionData submissionData, SubmissionFormat submissionFormat) throws IOException {}

}

