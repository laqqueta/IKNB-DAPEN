package id.go.ojk.client.service.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.lib.client.model.config.MessageConfig;
import id.go.ojk.lib.client.service.base.Service;
import id.go.ojk.lib.client.service.context.ApplicationContext;

public class BaseService implements Service, ApplicationContextAware {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void initialize() {

	}

	@Override
	public void shutdown() {

	}

	protected ApplicationContext appContext;
	protected ReferenceService referenceService;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.appContext = applicationContext;
		this.referenceService = applicationContext.getService(ReferenceService.class);
	}
	
	//~ message 
	
	public String getMessage(MessageConfig messageConfig){
		return referenceService.getMessage(messageConfig);
	}
	
	public String getMessage(MessageConfig messageConfig, Object[] args){
		return referenceService.getMessage(messageConfig, args);
	}

}
