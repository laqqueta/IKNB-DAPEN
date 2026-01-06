package id.go.ojk.client.model.config.validation.field;

import com.thoughtworks.xstream.annotations.XStreamOmitField;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.lib.client.service.context.ApplicationContext;

public abstract class BaseFieldValidation implements FieldValidation {

	@XStreamOmitField
	protected ApplicationContext appCtx;

	protected String parameter;

	@Override
	public void setApplicationContext(ApplicationContext appCtx) {
		this.appCtx = appCtx;
	}

	@Override
	public BaseFieldValidation setParameter(String parameter) {
		this.parameter = parameter;
		initialized();
		return this;
	}
	
	@Override
	public String getParameter() {
		return parameter;
	}
	
	@Override
	public FieldValidation beforeValidationStart(SubmissionData submissionData) {
		return this;
	}

}
