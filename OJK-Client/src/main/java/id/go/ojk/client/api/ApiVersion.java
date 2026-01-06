package id.go.ojk.client.api;

import id.go.ojk.client.dto.DtoVersionRequest;
import id.go.ojk.client.dto.DtoVersionResponse;

public class ApiVersion extends BaseApi<DtoVersionRequest> {

	public ApiVersion() {
		super("/version");
	}

	@Override
	public DtoVersionResponse sendReceive(DtoVersionRequest dtoRequest) {
		return sendReceive(dtoRequest, DtoVersionResponse.class);
	}

	@Override
	protected String getUrl() {
		return setupService.getClientUrlSubmission() + super.getUrl();
	}
}
