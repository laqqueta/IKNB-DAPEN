package id.go.ojk.lib.client.model.constant;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Tolerate;

@Builder
public class ServerConfig {
	
	@Getter private ServerConfigSinggle internetConfig;
	@Getter private ServerConfigSinggle extranetConfig;
		
	@Tolerate
	public ServerConfig(){
	}
	
	public ServerConfigSinggle getConfig(boolean extranet){
		return extranet ? extranetConfig : internetConfig;
	}
	
}
