package id.go.ojk.client.dto;

import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DtoChangePasswordRequest extends DtoBaseRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SerializedName("UserId")
	private String userId;
	@SerializedName("Passowrd")
	private String password;
	@SerializedName("NewPassowrd")
	private String newPassword;

}
