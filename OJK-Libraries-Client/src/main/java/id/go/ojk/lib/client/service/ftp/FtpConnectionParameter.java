package id.go.ojk.lib.client.service.ftp;

import id.go.ojk.lib.client.model.ProxyConfig;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class FtpConnectionParameter {
	@Getter private String host;
	@Getter private int port;
	@Getter private String userName;
	@Getter @Setter private String password;
	
	@Getter private ProxyConfig proxyConfig;

	public FtpConnectionParameter(String host, int port, String userName, String password, ProxyConfig proxyConfig){
		this.host = host;
		this.port = port;
		this.userName = userName ;
		this.password = password;
		this.proxyConfig = proxyConfig;
	}

	public FtpConnectionParameter cloneSafe() {
		try {
			return clone();
		} catch (CloneNotSupportedException e) {
		}
		return null;
	}

	@Override
	public FtpConnectionParameter clone() throws CloneNotSupportedException {
		return new FtpConnectionParameter(host, port, userName, password, proxyConfig);
	}

}
