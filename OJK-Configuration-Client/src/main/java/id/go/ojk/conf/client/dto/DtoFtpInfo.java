package id.go.ojk.conf.client.dto;

public class DtoFtpInfo {
	private String ftpHost;
	private String ftpHostInternal;
	private int ftpPort;
	private String ftpUser;
	private String ftpPass;

	public DtoFtpInfo() {
	}

	public String getFtpHost() {
		return ftpHost;
	}

	public void setFtpHost(String ftpHost) {
		this.ftpHost = ftpHost;
	}

	public String getFtpHostInternal() {
		return ftpHostInternal;
	}

	public void setFtpHostInternal(String ftpHostInternal) {
		this.ftpHostInternal = ftpHostInternal;
	}

	public int getFtpPort() {
		return ftpPort;
	}

	public void setFtpPort(int ftpPort) {
		this.ftpPort = ftpPort;
	}

	public String getFtpUser() {
		return ftpUser;
	}

	public void setFtpUser(String ftpUser) {
		this.ftpUser = ftpUser;
	}

	public String getFtpPass() {
		return ftpPass;
	}

	public void setFtpPass(String ftpPass) {
		this.ftpPass = ftpPass;
	}
}
