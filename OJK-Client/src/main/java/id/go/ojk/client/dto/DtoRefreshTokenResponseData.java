package id.go.ojk.client.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class DtoRefreshTokenResponseData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String token;
	private long expirationDate;

	public long getExpirationDateMillis() {
		return expirationDate * 1000;
	}
}
