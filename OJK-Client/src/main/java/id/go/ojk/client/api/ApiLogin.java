package id.go.ojk.client.api;

import java.util.Date;

import id.go.ojk.client.dto.DtoLoginRequest;
import id.go.ojk.client.dto.DtoLoginResponse;
import id.go.ojk.lib.client.api.DtoHttpRequest;
import id.go.ojk.lib.client.constant.LogTemplate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApiLogin extends BaseApi<DtoLoginRequest> {

	public ApiLogin() {
		super("/login");
	}

	@Override
	public DtoLoginResponse sendReceive(DtoLoginRequest dtoRequest) {
		DtoLoginResponse res = sendReceive(dtoRequest, DtoLoginResponse.class);
		if (res != null && res.getResponseCode().equals("200") && res.isSucceed()) {
			log.info(LogTemplate.SESSION_2, res.getData().getToken(), new Date(res.getData().getExpirationDateMillis()));
			
		}
		return res;
	}

	@Override
	protected DtoHttpRequest getRequest(DtoLoginRequest dtoRequest) {
		DtoHttpRequest res = super.getRequest(dtoRequest);
		res.setContent(null);
		res.setContentType(null);
		return res;
	}

	@Override
	protected String getUrl() {
		return getUrlAuth() + super.getUrl();
	}
}
