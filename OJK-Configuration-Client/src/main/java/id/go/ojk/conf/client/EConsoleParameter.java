package id.go.ojk.conf.client;

public enum EConsoleParameter {
	ROOT_FOLDER ("--rootFolder"),
	LJK_CODE ("--ljkCode"),
	ENVI_TYPE ("--enviType"),
	FTP_SERVER ("--ftpServer"),
	FTP_FOLDER ("--ftpFolder"),
	FTP_APP_FOLDER ("--ftpAppFolder"),
	RESOURCE_FOLDER ("--resourceFolder"),
	;
	private String key;
	
	private EConsoleParameter(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}
}
