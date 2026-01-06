package id.go.ojk.client.dto;

import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DtoVersionRequest extends DtoBaseRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SerializedName("MemberCode")
	private String memberCode;

}
