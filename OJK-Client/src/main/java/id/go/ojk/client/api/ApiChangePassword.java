package id.go.ojk.client.api;

import id.go.ojk.client.dto.DtoChangePasswordRequest;
import id.go.ojk.client.dto.DtoChangePasswordResponse;

public class ApiChangePassword extends BaseApi<DtoChangePasswordRequest> {

	public ApiChangePassword() {
		super("/change-password");
	}

	@Override
	public DtoChangePasswordResponse sendReceive(DtoChangePasswordRequest dtoRequest) {
		return sendReceive(dtoRequest, DtoChangePasswordResponse.class);
	}

	@Override
	protected String getUrl() {
		return setupService.getClientUrlAuth() + super.getUrl();
	}
}
