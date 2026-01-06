package id.go.ojk.client.api;

import java.util.Date;

import id.go.ojk.client.dto.DtoRefreshTokenRequest;
import id.go.ojk.client.dto.DtoRefreshTokenResponse;
import id.go.ojk.lib.client.constant.LogTemplate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApiRefreshToken extends BaseApi<DtoRefreshTokenRequest> {

	public ApiRefreshToken() {
		super("/refreshtoken");
	}

	@Override
	public DtoRefreshTokenResponse sendReceive(DtoRefreshTokenRequest dtoRequest) {
		DtoRefreshTokenResponse res = sendReceive(dtoRequest, DtoRefreshTokenResponse.class);
		if (res != null && res.getResponseCode().equals("200")) {
			log.info(LogTemplate.SESSION_2, res.getData().getToken(), new Date(res.getData().getExpirationDateMillis()));
		}
		return res;
	}

	@Override
	protected String getUrl() {
		return getUrlAuth() + super.getUrl();
	}
}
