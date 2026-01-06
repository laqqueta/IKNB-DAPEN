package id.go.ojk.client.service.context;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import id.go.ojk.client.service.base.ApplicationContextAware;
import id.go.ojk.lib.client.model.security.UserSession;
import id.go.ojk.lib.client.service.base.Service;
import id.go.ojk.lib.client.service.context.ApplicationContext;

public class ApplicationContextBase implements ApplicationContext {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	protected Map<String, Service> serviceMap = new LinkedHashMap<>();
	protected Map<Class<?>, Service> serviceMapByClass = new LinkedHashMap<>();
	private UserSession userSession;

	public void initialize(){
		
	}
	
	@Override
	public <T extends Service> void setService(Class<T> pClass, String name, T service) {
		serviceMap.put(name, service);
		if ( pClass != null)
			serviceMapByClass.put(pClass, service);
	}
	
	@Override
	public Map<String, Service> getServiceMap(){
		return serviceMap;
	}
	
	@Override
	public <T extends Service> T getService(String name, Class<T> pClass){
		return (T)serviceMap.get(name);
	}
	
	public <T extends Service> T getService(Class<T> pClass){
		return (T) serviceMapByClass.get(pClass);
	}
	
	@Override
	public void initService(){
		Set<Entry<String, Service>> entrySet = serviceMap.entrySet();
		for (Entry<String, Service> entry : entrySet) {
			Service service = entry.getValue();
			if ( service instanceof ApplicationContextAware ){
				((ApplicationContextAware) service).setApplicationContext(this);
			}
			service.initialize();
		}
	}
	@Override
	public void shutdown(){
		Set<Entry<String, Service>> entrySet = serviceMap.entrySet();
		for (Entry<String, Service> entry : entrySet) {
			Service service = entry.getValue();
			try {
				service.shutdown();
			} catch(Throwable t){
				logger.warn("Error shutdown " + service, t);
			}
		}
	}
}
