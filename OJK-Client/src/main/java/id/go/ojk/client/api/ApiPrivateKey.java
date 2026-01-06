package id.go.ojk.client.api;

import id.go.ojk.client.dto.DtoPrivateKeyRequest;
import id.go.ojk.client.dto.DtoPrivateKeyResponse;
import id.go.ojk.lib.client.api.DtoHttpRequest;
import lombok.SneakyThrows;

public class ApiPrivateKey extends BaseApi<DtoPrivateKeyRequest> {

	public ApiPrivateKey() {
		super("/PrivateKey");
	}

	@Override
	public DtoPrivateKeyResponse sendReceive(DtoPrivateKeyRequest dtoRequest) {
		return sendReceive(dtoRequest, DtoPrivateKeyResponse.class);
	}

	@SneakyThrows
	@Override
	protected String getQueryString(DtoPrivateKeyRequest dtoRequest) {
		StringBuilder res = new StringBuilder("?");
		res.append("memberCode=").append(urlEncoded(dtoRequest.getMemberCode()));
		return res.toString();
	}

	@Override
	protected DtoHttpRequest getRequest(DtoPrivateKeyRequest dtoRequest) {
		DtoHttpRequest res = super.getRequest(dtoRequest);
		res.setContent(null);
		res.setContentType(null);
		res.setMethod(METHOD_GET);
		res.setContentAsFile(true);
		return res;
	}

	@Override
	protected String getUrl() {
		return getUrlSubmission() + super.getUrl();
	}
}
