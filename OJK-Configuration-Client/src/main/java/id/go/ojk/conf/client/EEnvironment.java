package id.go.ojk.conf.client;

import org.apache.commons.lang3.StringUtils;

public enum EEnvironment {
	DEVEL,
	PRODUCTION,
	OFFLINE,
	;
	
	public static boolean isOffline(String envi) {
		return StringUtils.isNotEmpty(envi) && envi.equals(EEnvironment.OFFLINE.name());
	}
	
	public static boolean isProduction(String envi) {
		return StringUtils.isNotEmpty(envi) && envi.equals(EEnvironment.PRODUCTION.name());
	}
}
