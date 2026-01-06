package id.go.ojk.client.dto;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class DtoLoginResponseData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String token;
	private long expirationDate;
	@SerializedName("UserName")
	private String userName;
	@SerializedName("VersionSetup")
	private String versionSetup;
	@SerializedName("VersionMetadata")
	private String versionMetadata;
	@SerializedName("VersionReference")
	private String versionReference;
	@SerializedName("VersionApplication")
	private String versionApplication;
	
	public long getExpirationDateMillis() {
		return expirationDate * 1000;
	}
	
}
