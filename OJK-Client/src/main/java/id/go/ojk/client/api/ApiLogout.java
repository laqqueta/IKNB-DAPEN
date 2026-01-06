package id.go.ojk.client.api;

import id.go.ojk.client.dto.DtoLogoutRequest;
import id.go.ojk.client.dto.DtoLogoutResponse;
import id.go.ojk.lib.client.api.DtoHttpRequest;

public class ApiLogout extends BaseApi<DtoLogoutRequest> {

	public ApiLogout() {
		super("/logout");
	}

	@Override
	public DtoLogoutResponse sendReceive(DtoLogoutRequest dtoRequest) {
		return sendReceive(dtoRequest, DtoLogoutResponse.class);
	}
	
	@Override
	protected DtoHttpRequest getRequest(DtoLogoutRequest dtoRequest) {
		DtoHttpRequest res = super.getRequest(dtoRequest);
		res.setContent(null);
		return res;
	}

	@Override
	protected String getUrl() {
		return getUrlAuth() + super.getUrl();
	}
}
