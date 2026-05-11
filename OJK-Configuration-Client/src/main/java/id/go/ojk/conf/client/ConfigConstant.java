package id.go.ojk.conf.client;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConfigConstant {
	public static final String JDBC_URL = "jdbc:sqlserver://10.226.60.21";
	public static final String JDBC_URL_PROD_APOLO = "jdbc:sqlserver://10.226.60.18";
	public static final String JDBC_URL_PROD_CAM = "jdbc:sqlserver://10.226.60.18";
	public static final String JDBC_URL_PROD_MASTER = "jdbc:sqlserver://10.226.60.18";
	public static final String CAM_SERVICE = "http://10.224.60.44/CAMService.svc";
	public static final String CAM_SERVICE_PROD = "http://10.224.60.58:8888/CAMService.svc";

//	public static final String URL_SUBMISSTION_DEV = "http://127.0.0.1:8991/api";
//	public static final String URL_AUTH_DEV = "http://127.0.0.1:8992/api";

//	public static final String URL_SUBMISSTION_DEV = "http://157.15.77.140:8901/api";
//	public static final String URL_AUTH_DEV = "http://157.15.77.140:8900/api";

	// DAPEN DEV
	public static final String URL_SUBMISSTION_DEV = "http://157.15.77.140:6300/upload-api-DAPEN/api";
	public static final String URL_AUTH_DEV = "http://157.15.77.140:6300/auth-api-DAPEN/api";

//	public static final String URL_SUBMISSTION_DEV = "http://10.224.60.57:8981/api";
//	public static final String URL_AUTH_DEV = "http://10.224.60.57:8980/api";
//
	public static final String URL_SUBMISSTION_PROD = "http://10.226.60.18:8991/api";
	public static final String URL_AUTH_PROD = "http://10.226.60.18:8080/api";
	
//	public static final String DEV_FTP_HOST_ENTITY = "157.15.77.140";
//	public static final int DEV_FTP_ENTITY_PORT = 22442;
//	public static final String DEV_FTP_USER_ENTITY = "admfatca";
//	public static final String DEV_FTP_PWD_ENTITY = "P4$$word";
//	public static final String DEV_FTP_HOST = "157.15.77.140";
//	public static final String DEV_FTP_HOST_INTERNAL = "157.15.77.140";
//	public static final int DEV_FTP_PORT = 22442;
//	public static final String DEV_FTP_USER = "ftpuser";
//	public static final String DEV_FTP_PWD = "rxTfcpKw4gPnBGQbDS2U5N";
//	public static final String DEV_FTP_HOST_ENTITY_2 = "157.15.77.141";
//	public static final int DEV_FTP_ENTITY_PORT_2 = 889;
//	public static final String DEV_FTP_USER_ENTITY_2 = "admfatca";
//	public static final String DEV_FTP_PWD_ENTITY_2 = "P4$$word";
//	public static final String DEV_FTP_HOST_2 = "157.15.77.141";
//	public static final String DEV_FTP_HOST_INTERNAL_2 = "157.15.77.141";
//	public static final int DEV_FTP_PORT_2 = 22442;
//	public static final String DEV_FTP_USER_2 = "ftpuser";
//	public static final String DEV_FTP_PWD_2 = "rxTfcpKw4gPnBGQbDS2U5N";
	
//	public static final String DEV_FTP_HOST_ENTITY = "127.0.0.1";
//	public static final int DEV_FTP_ENTITY_PORT = 21;
//	public static final String DEV_FTP_USER_ENTITY = "admfatca";
//	public static final String DEV_FTP_PWD_ENTITY = "P4$$word";
//	public static final String DEV_FTP_HOST = "127.0.0.1";
//	public static final String DEV_FTP_HOST_INTERNAL = "127.0.0.1";
//	public static final int DEV_FTP_PORT = 21;
//	public static final String DEV_FTP_USER = "ftpuser";
//	public static final String DEV_FTP_PWD = "rxTfcpKw4gPnBGQbDS2U5N";
//	public static final String DEV_FTP_HOST_ENTITY_2 = "127.0.0.1";
//	public static final int DEV_FTP_ENTITY_PORT_2 = 889;
//	public static final String DEV_FTP_USER_ENTITY_2 = "admfatca";
//	public static final String DEV_FTP_PWD_ENTITY_2 = "P4$$word";
//	public static final String DEV_FTP_HOST_2 = "127.0.0.1";
//	public static final String DEV_FTP_HOST_INTERNAL_2 = "127.0.0.1";
//	public static final int DEV_FTP_PORT_2 = 21;
//	public static final String DEV_FTP_USER_2 = "ftpuser";
//	public static final String DEV_FTP_PWD_2 = "rxTfcpKw4gPnBGQbDS2U5N";

//	public static final String DEV_FTP_HOST_ENTITY = "10.225.60.68";
//	public static final int DEV_FTP_ENTITY_PORT = 889;
//	public static final String DEV_FTP_USER_ENTITY = "admfatca";
//	public static final String DEV_FTP_PWD_ENTITY = "P4$$word";
//	public static final String DEV_FTP_HOST = "10.225.60.68";
//	public static final String DEV_FTP_HOST_INTERNAL = "10.225.60.68";
//	public static final int DEV_FTP_PORT = 889;
//	public static final String DEV_FTP_USER = "admfatca";
//	public static final String DEV_FTP_PWD = "P4$$word";
//	public static final String DEV_FTP_HOST_ENTITY_2 = "10.225.60.68";
//	public static final int DEV_FTP_ENTITY_PORT_2 = 889;
//	public static final String DEV_FTP_USER_ENTITY_2 = "admfatca";
//	public static final String DEV_FTP_PWD_ENTITY_2 = "P4$$word";
//	public static final String DEV_FTP_HOST_2 = "10.225.60.68";
//	public static final String DEV_FTP_HOST_INTERNAL_2 = "10.225.60.68";
//	public static final int DEV_FTP_PORT_2 = 889;
//	public static final String DEV_FTP_USER_2 = "admfatca";
//	public static final String DEV_FTP_PWD_2 = "P4$$word";

	// DEV FTP Apolo
	public static final String DEV_FTP_HOST_ENTITY = "157.15.77.140";
	public static final int DEV_FTP_ENTITY_PORT = 22442;
	public static final String DEV_FTP_USER_ENTITY = "ftpuser";
	public static final String DEV_FTP_PWD_ENTITY = "rxTfcpKw4gPnBGQbDS2U5N";
	public static final String DEV_FTP_HOST = "157.15.77.140";
	public static final String DEV_FTP_HOST_INTERNAL = "157.15.77.140";
	public static final int DEV_FTP_PORT = 22442;
	public static final String DEV_FTP_USER = "ftpuser";
	public static final String DEV_FTP_PWD = "rxTfcpKw4gPnBGQbDS2U5N";
	public static final String DEV_FTP_HOST_ENTITY_2 = "157.15.77.141";
	public static final int DEV_FTP_ENTITY_PORT_2 = 22442;
	public static final String DEV_FTP_USER_ENTITY_2 = "ftpuser";
	public static final String DEV_FTP_PWD_ENTITY_2 = "rxTfcpKw4gPnBGQbDS2U5N";
	public static final String DEV_FTP_HOST_2 = "157.15.77.141";
	public static final String DEV_FTP_HOST_INTERNAL_2 = "157.15.77.141";
	public static final int DEV_FTP_PORT_2 = 22442;
	public static final String DEV_FTP_USER_2 = "ftpuser";
	public static final String DEV_FTP_PWD_2 = "rxTfcpKw4gPnBGQbDS2U5N";
	
	public static final String PROD_FTP_HOST_ENTITY = "10.225.60.68";
	public static final String PROD_FTP_HOST = "10.225.60.68";
	public static final String PROD_FTP_HOST_INTERNAL = "10.225.60.68";
	public static final String PROD_FTP_HOST_ENTITY_2 = "10.225.60.68";
	public static final String PROD_FTP_HOST_2 = "10.225.60.68";
	public static final String PROD_FTP_HOST_INTERNAL_2 = "10.225.60.68";
}
