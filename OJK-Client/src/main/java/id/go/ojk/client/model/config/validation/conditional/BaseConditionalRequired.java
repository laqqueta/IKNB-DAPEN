package id.go.ojk.client.model.config.validation.conditional;

import com.thoughtworks.xstream.annotations.XStreamOmitField;

import id.go.ojk.lib.client.service.context.ApplicationContext;

public abstract class BaseConditionalRequired implements ConditionalRequired {

	protected String parameter;

	@Override
	public ConditionalRequired setParameter(String parameter) {
		this.parameter = parameter;
		initialized();
		return this;
	}
	
	@Override
	public String getParameter() {
		return parameter;
	}
	
	@XStreamOmitField
	protected ApplicationContext appCtx;
	
	@Override
	public void setApplicationContext(ApplicationContext appCtx) {
		this.appCtx = appCtx;
	}

}
