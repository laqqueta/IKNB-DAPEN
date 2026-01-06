package id.go.ojk.client.api;

import id.go.ojk.client.dto.DtoCheckUploadRequest;
import id.go.ojk.client.dto.DtoCheckUploadResponse;
import id.go.ojk.lib.client.api.DtoHttpRequest;
import lombok.SneakyThrows;

public class ApiCheckUpload extends BaseApi<DtoCheckUploadRequest> {

	public ApiCheckUpload() {
		super("/UploadFile");
	}

	@Override
	public DtoCheckUploadResponse sendReceive(DtoCheckUploadRequest dtoRequest) {
		return sendReceive(dtoRequest, DtoCheckUploadResponse.class);
	}

	@SneakyThrows
	@Override
	protected String getQueryString(DtoCheckUploadRequest dtoRequest) {
		StringBuilder res = new StringBuilder("?");
		res.append("AntrianId=").append(dtoRequest.getAntrianId()).append("&");
		res.append("SummaryId=").append(dtoRequest.getSummaryId()).append("&");
		res.append("Username=").append(urlEncoded(dtoRequest.getUserName())).append("&");
		res.append("SignatureSign=").append(urlEncoded(dtoRequest.getSignature()));
		return res.toString();
	}

	@Override
	protected DtoHttpRequest getRequest(DtoCheckUploadRequest dtoRequest) {
		DtoHttpRequest res = super.getRequest(dtoRequest);
		res.setContent(null);
		res.setContentType(null);
		res.setMethod(METHOD_GET);
		return res;
	}

	@Override
	protected String getUrl() {
		return getUrlSubmission() + super.getUrl();
	}
}
