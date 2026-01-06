package id.go.ojk.lib.client.model.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Data
@Builder
public class SlikClientCfg {
	
	private static Logger logger = LoggerFactory.getLogger(SlikClientCfg.class);
		
	public final static String part_application = "[Application]";
	public final static String part_jvmoptions = "[JVMOptions]";
	public final static String part_jvmuseroptions = "[JVMUserOptions]";
	public final static String part_argoptions = "[ArgOptions]";
	
	public final static String key_appName = "app.name";
	public final static String key_appMainjar= "app.mainjar";
	public final static String key_appVersion = "app.version";
	public final static String key_appPreferencesId = "app.preferences.id";
	public final static String key_appMainclass = "app.mainclass";
	public final static String key_appClasspath = "app.classpath";
	public final static String key_appRuntime = "app.runtime";
	public final static String key_appIdentifier= "app.identifier";

	public final static String jvm_xms = "Xms";
	public final static String jvm_xmx = "Xmx";
	
	private File file;
	
	//[Application]
			
	private String appName;
	private String appMainjar;	
	private String appVersion;
	private String appPreferencesId;
	private String appMainclass;
	private String appClasspath;
	private String appRuntime;
	private String appIdentifier;
	
	//[JVMOptions]
	
	private int xms;
	private int xmx;
	
	//[JVMUserOptions]
	
	//[ArgOptions]
	private String argOptions;
	
	@Tolerate
	public SlikClientCfg(){
	}	
	
	public boolean isJvmSettingChange(int xms, int xmx){
		return this.xms != xms || this.xmx != xmx;
	}
	
	//~ store

	public void store() throws IOException {
		store(file);
	}

	public void store(File file) throws IOException {
		try ( FileOutputStream outputStream = new FileOutputStream(file)){
			IOUtils.write(part_application + "\r\n", outputStream);
			writeKeyValue(outputStream, key_appName, 			appName);
			writeKeyValue(outputStream, key_appMainjar, 		appMainjar);
			writeKeyValue(outputStream, key_appVersion, 		appVersion);
			writeKeyValue(outputStream, key_appPreferencesId, 	appPreferencesId);
			writeKeyValue(outputStream, key_appMainclass, 		appMainclass);
			writeKeyValue(outputStream, key_appClasspath, 		appClasspath);
			writeKeyValue(outputStream, key_appRuntime, 		appRuntime);
			writeKeyValue(outputStream, key_appIdentifier, 		appIdentifier);

			IOUtils.write("\r\n" + part_jvmoptions + "\r\n", outputStream);
			writeJvmOptions(outputStream, jvm_xms, xms + "");
			writeJvmOptions(outputStream, jvm_xmx, xmx + "");
			
			IOUtils.write("\r\n" + part_jvmuseroptions + "\r\n", outputStream);
			
			IOUtils.write("\r\n" + part_argoptions + "\r\n", outputStream);
			IOUtils.write(argOptions + "\r\n", outputStream);
		}
	}
	
	public void writeKeyValue(OutputStream outputStream, String key, String value) throws IOException {
		IOUtils.write(key + "=" + value + "\r\n", outputStream);
	}
	
	public void writeJvmOptions(OutputStream outputStream, String key, String value) throws IOException {
		IOUtils.write("-" + key + value + "m\r\n", outputStream);
	}

	//~ factory

	public static SlikClientCfg newInstance() throws IOException {
		return newInstance(new File("resources" + File.separator + "Client.cfg"));
//		return newInstance(new File("RBBClient.cfg"));
	}

	public static SlikClientCfg newInstance(File file) throws IOException {
		logger.info("ClientCfg File " + file.getAbsolutePath());
		try ( FileInputStream inputStream = new FileInputStream(file)){
			SlikClientCfg slikClientCfg = newInstance(inputStream);
			slikClientCfg.setFile(file);
			return slikClientCfg;
		}
	}
	
	public static SlikClientCfg newInstance(InputStream inputStream) throws IOException{
		
	    BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		SlikClientCfg slikClientCfg = new  SlikClientCfg();
		
	    String line = null;
	    while ( (line = br.readLine()) != null ){
	    	if ( part_application.equals(line) ){
	    		while ( true){
	    			line = br.readLine();
	    			if (StringUtils.isEmpty(line)){
	    				break;
	    			}
	    			
					String[] lineSplited = line.split("=");
					switch (lineSplited[0]) {
					case key_appName:
						slikClientCfg.setAppName(lineSplited[1]);
						break;
					case key_appMainjar:
						slikClientCfg.setAppMainjar(lineSplited[1]);
						break;
					case key_appVersion:
						slikClientCfg.setAppVersion(lineSplited[1]);
						break;
					case key_appPreferencesId:
						slikClientCfg.setAppPreferencesId(lineSplited[1]);
						break;
					case key_appMainclass:
						slikClientCfg.setAppMainclass(lineSplited[1]);
						break;
					case key_appClasspath:
						slikClientCfg.setAppClasspath(lineSplited[1]);
						break;
					case key_appRuntime:
						slikClientCfg.setAppRuntime(lineSplited[1]);
						break;
					case key_appIdentifier:
						slikClientCfg.setAppIdentifier(lineSplited[1]);
						break;
					default:
						break;
					}
	    		}	    		
	    	} else if ( part_jvmoptions.equals(line) ){
	    		while ( true){
	    			line = br.readLine();
	    			if (StringUtils.isEmpty(line)){
	    				break;
	    			}
	    			
					if (line.startsWith("-" + jvm_xms)){
						slikClientCfg.setXms(Integer.parseInt(line.substring(4, line.length()-1)));
					} else if (line.startsWith("-" + jvm_xmx)){
						slikClientCfg.setXmx(Integer.parseInt(line.substring(4, line.length()-1)));
					}
	    		}
	    	} else if ( part_jvmuseroptions.equals(line) ){
	    		while ( true){
	    			line = br.readLine();
	    			if (StringUtils.isEmpty(line)){
	    				break;
	    			}
	    		}
	    	} else if ( part_argoptions.equals(line) ){
	    		slikClientCfg.setArgOptions(br.readLine());
	    	}
	    }
	    
		return slikClientCfg;
	}
	
}
