package id.go.ojk.client.vc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import id.go.ojk.client.service.context.ApplicationContextClient;

public class BaseController {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	protected ApplicationContextClient appCtx;

	protected void initialize() {
		appCtx = ApplicationContextClient.getInstance();
	}
	
	public void reset(){
	}
	
	public boolean isReused(){
		return false;
	}

	public boolean isInProcess(){
		return false;
	}
	
}
