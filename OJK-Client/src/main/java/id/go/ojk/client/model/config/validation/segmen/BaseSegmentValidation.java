package id.go.ojk.client.model.config.validation.segmen;

import java.io.IOException;
import java.util.Map;

import com.thoughtworks.xstream.annotations.XStreamOmitField;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.bind.ProgressSegment;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.service.validation.ValidationErrorWriter;
import id.go.ojk.lib.client.model.constant.FormatCategoryFlag;
import id.go.ojk.lib.client.model.constant.SegmentValidationType;
import id.go.ojk.lib.client.service.context.ApplicationContext;

public abstract class BaseSegmentValidation implements SegmentValidation {

	@XStreamOmitField
	protected ApplicationContext appCtx;

	protected String parameter = "";

	public BaseSegmentValidation(){
	}

	public BaseSegmentValidation(String parameter){
		setParameter(parameter);
	}

	@Override
	public void setApplicationContext(ApplicationContext appCtx) {
		this.appCtx = appCtx;
	}

	@Override
	public BaseSegmentValidation setParameter(String parameter) {
		this.parameter = parameter;
		initialized();
		return this;
	}

	public String getParameter() {
		return parameter;
	}
	
	@Override
	public FormatCategoryFlag getFormatCategoryFlag() {
		return FormatCategoryFlag.N;
	}
	
	@Override
	public SegmentValidationType getSegmentValidationType() {
		return SegmentValidationType.R;
	}
	
	@Override
	public void validatePost(Map<String, ProgressSegment> progressSegmentMap, SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationErrorWriter validationErrorWriter) throws IOException {
	}
	
	@Override
	public void cleanUp(){
	}

	@Override
	public void load(SubmissionFormat submissionFormat) {
	}
}
