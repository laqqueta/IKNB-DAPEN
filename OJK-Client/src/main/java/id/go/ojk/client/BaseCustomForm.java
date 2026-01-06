package id.go.ojk.client;

import id.go.ojk.lib.client.service.context.ApplicationContext;

public abstract class BaseCustomForm {
	protected MainApplication mainApplication;
	protected ApplicationContext appContext;
	
	protected BaseCustomForm(ApplicationContext appContext, MainApplication mainApplication) {
		this.appContext = appContext;
		this.mainApplication = mainApplication;
	}
	
	abstract void init();
}
