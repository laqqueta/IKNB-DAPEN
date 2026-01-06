package id.go.ojk.client.dto;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class DtoLoginRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SerializedName("UserId")
	private String userId;
	@SerializedName("Password")
	private String password;
	@SerializedName("UserTypeFlag")
	private String userTypeFlag;
	@SerializedName("MemberTypeCode")
	private String memberTypeCode;
	@SerializedName("MemberCode")
	private String memberCode;

}
