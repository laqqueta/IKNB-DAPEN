package id.go.ojk.lib.client.model.security;

import java.time.LocalDateTime;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.lib.client.model.DtoVersion;
import lombok.Data;

@Data
public class UserSession {

	private User user;
	private String plainPassword;
	private AuthenticationStatus authenticationStatus = AuthenticationStatus.notAuthenticate;
	private String sessionId;
	private long sessionExpirationDate;
	private LocalDateTime loginDate;
	private String errorMessage;
	private Map<String, Object> loginOnlineResponse;
	private Boolean ftpLogin = false;
	private String reportCode;
	private DtoVersion version;

	public UserSession(){
	}

	public UserSession(User user, AuthenticationStatus authenticationStatus, String sessionId, LocalDateTime loginDate){
		this.user = user;
		this.authenticationStatus = authenticationStatus;
		this.sessionId = sessionId;
		this.loginDate = loginDate;
	}

	//~ method

	public boolean isAuthenticated(){
		switch (authenticationStatus) {
		case onlineAuthenticate:
		case offlineAuthenticate:
			return true;
		default:
			return false;
		}
	}

	public boolean isOnline(){
		return authenticationStatus == AuthenticationStatus.onlineAuthenticate;
	}
	
	public boolean hasOnlineSession() {
		return StringUtils.isNotEmpty(sessionId) && !sessionId.equalsIgnoreCase("offline");
	}
}
