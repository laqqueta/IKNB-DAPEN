package id.go.ojk.lib.client.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Data
@Builder
public class ProxyConfig {
	
	private String host;
	private int port;
	private String user;
	private String password;
	
	@Tolerate
	public ProxyConfig(){
	}

}
