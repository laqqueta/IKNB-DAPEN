package id.go.ojk.conf.client;

public class DummyEnvironment {
	
	public static DummyServerConfig configTrx(String environment) {
		return configTrx(EEnvironment.valueOf(environment));
	}
	
	public static DummyServerConfig configTrx(EEnvironment eEnum) {
		DummyServerConfig serverConfig = new DummyServerConfig();
		switch (eEnum) {
		case DEVEL:
		case OFFLINE:
			serverConfig.setFtp(EFtpInfo.DEV_TRX_1.getObject());
			serverConfig.setFtp2(EFtpInfo.DEV_TRX_2.getObject());
			serverConfig.setJdbc(EJdbcInfo.DEV.getObject());
			serverConfig.setCAMService(ConfigConstant.CAM_SERVICE);
			serverConfig.setUrlAuth(ConfigConstant.URL_AUTH_DEV);
			serverConfig.setUrlSubmission(ConfigConstant.URL_SUBMISSTION_DEV);
			serverConfig.setDevMode(true);
			break;
		case PRODUCTION:
			serverConfig.setFtp(EFtpInfo.PROD_TRX_1.getObject());
			serverConfig.setFtp2(EFtpInfo.PROD_TRX_2.getObject());
			serverConfig.setJdbc(EJdbcInfo.PROD.getObject());
			serverConfig.setCAMService(ConfigConstant.CAM_SERVICE_PROD);
			serverConfig.setUrlAuth(ConfigConstant.URL_AUTH_PROD);
			serverConfig.setUrlSubmission(ConfigConstant.URL_SUBMISSTION_PROD);
			serverConfig.setDevMode(false);
			break;
		default:
			break;
		}

		return serverConfig;
	}
	
	public static DummyServerConfig config(String environment) {
		return config(EEnvironment.valueOf(environment));
	}
	
	public static DummyServerConfig config(EEnvironment eEnum) {
		DummyServerConfig serverConfig = new DummyServerConfig();
		switch (eEnum) {
		case DEVEL:
			serverConfig.setFtp(EFtpInfo.DEV_1.getObject());
			serverConfig.setFtp2(EFtpInfo.DEV_2.getObject());
			serverConfig.setJdbc(EJdbcInfo.DEV.getObject());
			serverConfig.setCAMService(ConfigConstant.CAM_SERVICE);
			serverConfig.setUrlAuth(ConfigConstant.URL_AUTH_DEV);
			serverConfig.setUrlSubmission(ConfigConstant.URL_SUBMISSTION_DEV);
			serverConfig.setDevMode(true);
		case OFFLINE:
			serverConfig.setFtp(EFtpInfo.DEV_1.getObject());
			serverConfig.setFtp2(EFtpInfo.DEV_2.getObject());
			serverConfig.setJdbc(EJdbcInfo.DEV.getObject());
			serverConfig.setCAMService(ConfigConstant.CAM_SERVICE);
			serverConfig.setUrlAuth(ConfigConstant.URL_AUTH_DEV);
			serverConfig.setUrlSubmission(ConfigConstant.URL_SUBMISSTION_DEV);
			serverConfig.setDevMode(true);
			break;
		case PRODUCTION:
			serverConfig.setFtp(EFtpInfo.PROD_1.getObject());
			serverConfig.setFtp2(EFtpInfo.PROD_2.getObject());
			serverConfig.setJdbc(EJdbcInfo.PROD.getObject());
			serverConfig.setCAMService(ConfigConstant.CAM_SERVICE_PROD);
			serverConfig.setUrlAuth(ConfigConstant.URL_AUTH_PROD);
			serverConfig.setUrlSubmission(ConfigConstant.URL_SUBMISSTION_PROD);
			serverConfig.setDevMode(false);
			break;
		default:
			break;
		}

		return serverConfig;
	}
}
