package id.go.ojk.client.dto;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class DtoBaseResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String responseCode;
	@SerializedName("Message")
	private String responseMessage;
	@SerializedName("IsSuccess")
	private boolean succeed = false;

}
