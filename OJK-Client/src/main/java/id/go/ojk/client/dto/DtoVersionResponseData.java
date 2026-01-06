package id.go.ojk.client.dto;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class DtoVersionResponseData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SerializedName("VersionSetup")
	private String versionSetup;
	@SerializedName("VersionMetadata")
	private String versionMetadata;
	@SerializedName("VersionReference")
	private String versionReference;
	@SerializedName("VersionApplication")
	private String versionApplication;
	
}
