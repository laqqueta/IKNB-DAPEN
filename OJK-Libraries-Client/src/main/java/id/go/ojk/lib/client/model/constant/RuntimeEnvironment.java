package id.go.ojk.lib.client.model.constant;

import java.util.Arrays;

public enum RuntimeEnvironment {
	local(
		ServerConfig.builder()
			.internetConfig(
				ServerConfigSinggle.builder()
				.serverAddressList(Arrays.asList("127.0.0.1"))	
				.https(false).httpPort(8080).httpsPort(443).httpBasePath("").ftpsPort(990)
				.build()
			)
			.extranetConfig(
				ServerConfigSinggle.builder()
				.serverAddressList(Arrays.asList("127.0.0.1"))	
				.https(false).httpPort(8080).httpsPort(443).httpBasePath("").ftpsPort(990)
				.build()
			)			
		.build()
	), 
	devInt(
		ServerConfig.builder()
			.internetConfig(
				ServerConfigSinggle.builder()
				.serverAddressList(Arrays.asList("10.208.110.29", "10.208.110.29"))	
				.https(false).httpPort(8080).httpsPort(443).httpBasePath("").ftpsPort(990)
				.build()
			)
			.extranetConfig(
				ServerConfigSinggle.builder()
				.serverAddressList(Arrays.asList("10.208.110.29", "10.208.110.29"))	
				.https(false).httpPort(8080).httpsPort(443).httpBasePath("").ftpsPort(990)
				.build()
			)
		.build()			
	),	
	devPub(
		ServerConfig.builder()
			.internetConfig(
				ServerConfigSinggle.builder()
				.serverAddressList(Arrays.asList("slikonsite.ojk.go.id"))	
				.https(true).httpPort(443).httpsPort(443).httpBasePath("/slikftp").ftpsPort(990)
				.build()
			)
			.extranetConfig(
				ServerConfigSinggle.builder()
				.serverAddressList(Arrays.asList("10.208.110.29", "10.208.110.29"))	
				.https(false).httpPort(8080).httpsPort(443).httpBasePath("").ftpsPort(990)
				.build()
			)
		.build()
	), 
	devPubViaInt(
		ServerConfig.builder()
			.internetConfig(
				ServerConfigSinggle.builder()
				.serverAddressList(Arrays.asList("10.214.110.70"))	
				.https(true).httpPort(443).httpsPort(443).httpBasePath("/slikftp").ftpsPort(990)
				.build()
			)
			.extranetConfig(
				ServerConfigSinggle.builder()
				.serverAddressList(Arrays.asList("10.214.110.70"))	
				.https(true).httpPort(443).httpsPort(443).httpBasePath("/slikftp").ftpsPort(990)
				.build()
			)
		.build()
	),
	dev2(
		ServerConfig.builder()
			.internetConfig(
				ServerConfigSinggle.builder()
				.serverAddressList(Arrays.asList("10.208.110.29", "10.208.110.29"))	
				.https(false).httpPort(8080).httpsPort(443).httpBasePath("").ftpsPort(990)
				.build()
			)
			.extranetConfig(
				ServerConfigSinggle.builder()
				.serverAddressList(Arrays.asList("10.208.110.29", "10.208.110.29"))	
				.https(false).httpPort(80).httpsPort(443).httpBasePath("").ftpsPort(990)
				.build()
			)
		.build()			
	), 
	
	//10.231.110.8
	//10.231.254.11
	prod(
		ServerConfig.builder()
			.internetConfig(
				ServerConfigSinggle.builder()
				.serverAddressList(Arrays.asList("ftpslik.ojk.go.id", "ftpslik.ojk.go.id"))	
				.https(true).httpPort(80).httpsPort(443).httpBasePath("").ftpsPort(990)
				.build()
			)
			.extranetConfig(
				ServerConfigSinggle.builder()
				.serverAddressList(Arrays.asList("10.231.254.11", "10.231.254.11"))	
				.https(false).httpPort(8080).httpsPort(443).httpBasePath("").ftpsPort(990)
				.build()
			)
		.build()			
	),

	prodNoF5(
			ServerConfig.builder()
				.internetConfig(
					ServerConfigSinggle.builder()
					.serverAddressList(Arrays.asList("10.231.110.8", "10.231.110.8"))	
					.https(false).httpPort(8085).httpsPort(443).httpBasePath("").ftpsPort(995)
					.build()
				)
				.extranetConfig(
					ServerConfigSinggle.builder()
					.serverAddressList(Arrays.asList("10.231.110.8", "10.231.110.8"))	
					.https(false).httpPort(8080).httpsPort(443).httpBasePath("").ftpsPort(990)
					.build()
				)
			.build()			
		);
	
	private ServerConfig serverConfig;
	private RuntimeEnvironment(ServerConfig serverConfig){
		this.serverConfig = serverConfig;
	}
	
	public ServerConfig getServerConfig() {
		return serverConfig;
	}
	
}
