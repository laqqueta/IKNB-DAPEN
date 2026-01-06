package id.go.ojk.client.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DtoLoginResponse extends DtoDataResponse<DtoLoginResponseData> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
