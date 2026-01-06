package id.go.ojk.lib.client.model.constant;

import java.util.List;

import org.apache.commons.lang3.RandomUtils;

public class OjkClientConstant {

//	public final static RuntimeEnvironment runtimeEnvironment = RuntimeEnvironment.local;
//	public final static RuntimeEnvironment runtimeEnvironment = RuntimeEnvironment.devInt;
//	public final static RuntimeEnvironment runtimeEnvironment = RuntimeEnvironment.devPub;
	public final static RuntimeEnvironment runtimeEnvironment = RuntimeEnvironment.devPubViaInt;
//	public final static RuntimeEnvironment runtimeEnvironment = RuntimeEnvironment.dev2;
//	public final static RuntimeEnvironment runtimeEnvironment = RuntimeEnvironment.prod;
//	public final static RuntimeEnvironment runtimeEnvironment = RuntimeEnvironment.prodNoF5;
	
	
	public static boolean isLocalRuntime(){
		return runtimeEnvironment == RuntimeEnvironment.local;
	}

	public static boolean isShowBuildDate(){
		return runtimeEnvironment == RuntimeEnvironment.local || 
			runtimeEnvironment == RuntimeEnvironment.devInt || 
			runtimeEnvironment == RuntimeEnvironment.devPub || 
			runtimeEnvironment == RuntimeEnvironment.devPubViaInt || 
			runtimeEnvironment == RuntimeEnvironment.dev2
			;
	}

	private static boolean skipValidation = false;
	public static boolean isSkipValidation() {
		return skipValidation && isLocalRuntime();
	}
	
//	public final static String applicationVersion	= "0.1.4"; // Industrial test mulai versi 0.1.3
//	public final static String applicationVersion	= "0.0.1";
	public static final String applicationVersion	= ConfigVersion.APPLICATION_VERSION;
	public static final String libraryVersion		= ConfigVersion.LIBRARY_VERSION;
	
	public static final String applicationBuildDate	= ConfigVersion.APP_BUILD_DATE;
	public static final String applicationBuildDateProd	= ConfigVersion.APP_BUILD_DATE_PROD;
	
//	public final static String libraryVersion		= "0.0.0";

	public static final boolean postValidationShowDetailRow = false;
	
	public static final int encAesKeyLength = 256;
	public static final int encRsaKeyLength = 2048;
	
	public static final int checkConnectionDelayMs = 1000; 
	public static final int checkConnectionRateMs = 60000;

	private static final long ftpChunkFileSize 		= 50;			//dalam mb
	private static final long defauldSplitFileSize	= 20;			//dalam mb
	
	public static long getFtpchunkfilesizeByte() {
		return ftpChunkFileSize * 1000000;
	}
	
	public static long getDefauldsplitfilesizeByte() {
		return defauldSplitFileSize;
	}
	
	//~ enviromment
		
	static List<String> getServerAddressList(boolean extranet){
		return runtimeEnvironment.getServerConfig().getConfig(extranet).getServerAddressList();
	}
	
	public static boolean isHttps(boolean extranet) {
		return runtimeEnvironment.getServerConfig().getConfig(extranet).isHttps();
	}
	
	public static int getHttpPort(boolean extranet) {
		return runtimeEnvironment.getServerConfig().getConfig(extranet).getHttpPort();
	}
	
	public static int getHttpsPort(boolean extranet) {
		return runtimeEnvironment.getServerConfig().getConfig(extranet).getHttpsPort();
	}
	
	public static String getHttpBasePath(boolean extranet) {
		return runtimeEnvironment.getServerConfig().getConfig(extranet).getHttpBasePath();
	}

	public static int getFtpsPort(ConnectionType connectionType) {
		return getFtpsPort(connectionType == ConnectionType.extranet);
	}

	public static int getFtpsPort(boolean extranet) {
		return runtimeEnvironment.getServerConfig().getConfig(extranet).getFtpsPort();
	}
		
	public static String getHttpBaseUrl(ConnectionType connectionType){
		return getHttpBaseUrl(connectionType == ConnectionType.extranet);
	}
		
	public static String getHttpBaseUrl(boolean extranet){
		ServerConfigSinggle config = runtimeEnvironment.getServerConfig().getConfig(extranet);
		String ipAddress = getServerAddress(config);
		String result = null;
		if ( config.isHttps() ){
			if ( config.getHttpsPort() == 443 ){
				result = "https://" + ipAddress + config.getHttpBasePath();							
			} else {
				result = "https://" + ipAddress + ":" + config.getHttpsPort() + config.getHttpBasePath();			

			}
		} else {
			if ( config.getHttpPort() == 80 ){
				result = "http://" + ipAddress + config.getHttpBasePath();							
			} else {
				result = "http://" + ipAddress + ":" + config.getHttpPort() + config.getHttpBasePath();			
			}
		}
		return result;
	}
	
	public static String getServerAddress(ConnectionType connectionType){
		return getServerAddress(
			runtimeEnvironment.getServerConfig().getConfig(connectionType == ConnectionType.extranet)
		);
	}

	
	public static String getServerAddress(ServerConfigSinggle config){
		List<String> serverAddressList = config.getServerAddressList();
		int random = RandomUtils.nextInt(1, serverAddressList.size());
		return serverAddressList.get(random - 1);
	}
	
}
