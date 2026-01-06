package id.go.ojk.client.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DtoRefreshTokenResponse extends DtoDataResponse<DtoRefreshTokenResponseData> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
