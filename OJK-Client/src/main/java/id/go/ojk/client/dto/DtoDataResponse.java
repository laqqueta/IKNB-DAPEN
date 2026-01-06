package id.go.ojk.client.dto;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DtoDataResponse<D extends Serializable> extends DtoBaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SerializedName("Data")
	private D data;

}
