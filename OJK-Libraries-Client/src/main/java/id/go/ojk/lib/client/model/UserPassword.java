package id.go.ojk.lib.client.model;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Data
@Builder
public class UserPassword {
	
	private String userId;
	private String password;
	
	@Tolerate
	public UserPassword(){
	}

	public String getBasicAuthenticationHeader() throws UnsupportedEncodingException{
		String auth = userId + ":" + password;
		byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes("ISO-8859-1"));
		String authHeader = "Basic " + new String(encodedAuth);
		return authHeader;
	}
}
