package id.go.ojk.client.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import id.go.ojk.client.ClientProperties;
import id.go.ojk.client.constant.ClientConstant;
import id.go.ojk.client.service.base.BaseService;
import id.go.ojk.lib.client.model.ProxyConfig;
import id.go.ojk.lib.client.model.config.Config;
import id.go.ojk.lib.client.model.config.ConfigConnectionType;
import id.go.ojk.lib.client.model.config.ConfigInteger;
import id.go.ojk.lib.client.model.config.ConfigLong;
import id.go.ojk.lib.client.model.config.ConfigString;
import id.go.ojk.lib.client.model.constant.ConnectionType;
import id.go.ojk.lib.client.model.constant.OjkClientConstant;
import id.go.ojk.lib.client.service.context.ApplicationContext;
import id.go.ojk.lib.client.util.FileUtil;

public class ConfigService extends BaseService {

	@Override
	public void initialize() {
		loadProperties();
	}

	public static final ConfigString summarySourceDir 			= new ConfigString("summarySourceDir", 			"Direktori File Laporan Summary",		FileUtil.getCurrentPath() + "\\Pelaporan\\sumber", 				true);
	public static final ConfigString submissionSourceDir 		= new ConfigString("submissionSourceDir", 		"Direktori File Laporan",				FileUtil.getCurrentPath() + "\\Pelaporan\\sumber", 				true);
	public static final ConfigString submissionProcessDir 		= new ConfigString("submissionProcessDir", 		"Direktori File Proses",				FileUtil.getCurrentPath() + "\\Pelaporan\\proses", 				true);
	public static final ConfigString submissionDoneDir 			= new ConfigString("submissionDoneDir", 		"Direktori File Selesai Kirim",			FileUtil.getCurrentPath() + "\\Pelaporan\\selesai", 				true);
	
	public static final ConfigString sendindSourceDir 			= new ConfigString("sendindSourceDir", 			"Direktori File Akan dikirim",			FileUtil.getCurrentPath() + "\\Pelaporan\\selesai", 				true);

	public static final ConfigString errorDataSourceDir 		= new ConfigString("errorDataSourceDir", 		"Sumber Data Error Validasi Server",	FileUtil.getCurrentPath() + "\\Pelaporan\\sumber", 	true);
	public static final ConfigString errorDataDoneDir 			= new ConfigString("errorDataDoneDir", 			"Hasil Data Error Validasi Server",		FileUtil.getCurrentPath() + "\\error-validasi-server\\hasil", 	true);

	public static final ConfigString masterDataSourceDir 		= new ConfigString("masterDataSourceDir", 		"Sumber Data Master",					FileUtil.getCurrentPath() + "\\Pelaporan\\sumber", 			true);
	public static final ConfigString masterDataDoneDir 			= new ConfigString("masterDataDoneDir", 		"Hasil Data Master",					FileUtil.getCurrentPath() + "\\master-data\\hasil", 				true);

	public static final ConfigString updateOfflineFile 			= new ConfigString("updateOfflineFileDir", 		"Direktori Update Offline",				FileUtil.getCurrentPath() + "\\resources\\data.dat", 				true);

	public static final ConfigConnectionType connectionType 	= new ConfigConnectionType("connectionType", 	"Koneksi",								ConnectionType.internet,							true);
	public static final ConfigString proxyHost 					= new ConfigString("proxyHost", 				"Proxy Host",							null,												false);
	public static final ConfigInteger proxyPort 				= new ConfigInteger("proxyPort", 				"Proxy Port",							8080,												false, 1, 65000);
	public static final ConfigString proxyUser 					= new ConfigString("proxyUser", 				"Proxy User",							null,												false);
	public static final ConfigString proxyPassword 				= new ConfigString("proxyPassword", 			"Proxy Password",						null,												false);
	public static final ConfigLong splitFileSize = new ConfigLong("splitFileSize", "Ukuran Pemecahan Berkas", OjkClientConstant.getDefauldsplitfilesizeByte(),	true, 1, 1l, 100l);
	public static final ConfigLong maxThread = new ConfigLong(ClientProperties.MAX_THREAD,"Maximum Thread", 0L, true, 1, 0L, 99L);
	public static final ConfigLong validationLoopDelay = new ConfigLong(ClientProperties.VALIDATION_LOOP_DELAY,"Validation Loop Delay", 300L, true, 1, 1L, 1000L);
	public static final ConfigLong maxErrorCount = new ConfigLong(ClientProperties.MAX_ERROR_COUNT,"Maximum Error Count", 500L, false, 1, 10L, 5000L);
	public static final ConfigLong connectTimeout = new ConfigLong(ClientProperties.CONNECT_TIMEOUT,"Connect Timeout", 3000L, false, 1, 3000L, 60000L);
	public static final ConfigString readTimeout = new ConfigString(ClientProperties.READ_TIMEOUT, "Read Timeout", "60000,90000,120000", false);

	private Properties properties = new Properties();

	//~ method

	private File file = new File("resources" + File.separator + ClientConstant.CLIENT_PROPERTIES);

	public boolean loadProperties(){
		if ( file.exists() ) {
			InputStream is = null;
			try {
				is = new FileInputStream(file);
				properties.load(is);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				IOUtils.closeQuietly(is);
			}
		}
		return false;
	}

	public boolean storeProperties(){
		OutputStream out = null;
		try {
			out = new FileOutputStream(file);
			properties.store(out, "Client");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(out);
		}
		return false;
	}

	public <V> V getProperties(Config<V> config){
		return config.getValue(properties);
	}

	public <V> void setProperties(Config<V> config, V value){
		loadProperties();
		properties.setProperty(config.getKey(), config.toString(value));
	}

	public <V> boolean setPropertiesAndStore(Config<V> config, V value){
		setProperties(config, value);
		return storeProperties();
	}

	public <V> String getStringProperty(Config<V> config, String defValue){
		String stringValue = config.getValueString(properties);
		if ( stringValue == null )
			return defValue;
		return stringValue;
	}
	
	public ConnectionType geConnectionType(){
		ConnectionType result = connectionType.getValue(properties);
		return result;
	}
	
	public boolean isExtranetConnectionType(){
		return geConnectionType() == ConnectionType.extranet;
	}

	public void save(Map<Config<?>, String> newConfigMap){
		for (Entry<Config<?>, String> entry : newConfigMap.entrySet()) {
			if ( entry.getValue() != null ){
				properties.setProperty(entry.getKey().getKey(), entry.getValue());
			}
		}
		storeProperties();
		
		httpService.proxyConfigChange();
	}
	
	public String getServerAddress(){
		return OjkClientConstant.getServerAddress(geConnectionType());
	}

	public String getHttpBaseUrl(){
		return OjkClientConstant.getHttpBaseUrl(geConnectionType());
	}
	
	//~ proxy 
	
	public ProxyConfig getProxyConfig(){
		if ( ConnectionType.extranet == geConnectionType() )
			return null;
		
		//TODO cache
		String host = getProperties(proxyHost);
		if ( StringUtils.isEmpty(host) )
			return null;
		
		ProxyConfig proxyConfig = ProxyConfig.builder()
			.host(host)
			.port(getProperties(proxyPort))
			.user(getProperties(proxyUser))
			.password(getProperties(proxyPassword))
			.build();		
		return proxyConfig;
	}
	
	private HttpService httpService;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		super.setApplicationContext(applicationContext);
		this.httpService = applicationContext.getService(HttpService.class);
	}

}
