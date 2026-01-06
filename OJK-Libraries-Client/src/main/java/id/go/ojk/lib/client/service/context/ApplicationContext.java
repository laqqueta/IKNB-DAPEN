package id.go.ojk.lib.client.service.context;

import java.util.Map;

import id.go.ojk.lib.client.model.security.UserSession;
import id.go.ojk.lib.client.service.base.Service;

public interface ApplicationContext {

	public void initialize();
	
	public <T extends Service> void setService(Class<T> pClass, String name, T service);
	
	public Map<String, Service> getServiceMap();
	
	public <T extends Service> T  getService(String name, Class<T> pClass);
	
	public <T extends Service> T getService(Class<T> pClass);
	
	public void initService();

	public void shutdown();
		
}
