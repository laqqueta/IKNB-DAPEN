package id.go.ojk.lib.client.model.constant;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Tolerate;

@Builder
public class ServerConfigSinggle {
	
	@Getter private List<String> serverAddressList;	
	@Getter public boolean https;
	@Getter public int httpPort;
	@Getter public int httpsPort;
	@Getter public String httpBasePath;
	@Getter public int ftpsPort;
	
	@Tolerate
	public ServerConfigSinggle(){
	}
	
}
