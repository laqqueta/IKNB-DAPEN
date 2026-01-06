package id.go.ojk.client.api;

import id.go.ojk.client.dto.DtoUploadRequest;
import id.go.ojk.client.dto.DtoUploadResponse;
import id.go.ojk.lib.client.api.DtoHttpRequest;
import lombok.SneakyThrows;

public class ApiUpload extends BaseApi<DtoUploadRequest> {

	public ApiUpload() {
		super("/UploadFile");
	}

	@Override
	public DtoUploadResponse sendReceive(DtoUploadRequest dtoRequest) {
		return sendReceive(dtoRequest, DtoUploadResponse.class);
	}

	@SneakyThrows
	@Override
	protected String getQueryString(DtoUploadRequest dtoRequest) {
		StringBuilder res = new StringBuilder("?");
		res.append("AntrianId=").append(dtoRequest.getAntrianId()).append("&");
		res.append("SummaryId=").append(dtoRequest.getSummaryId()).append("&");
		res.append("Username=").append(urlEncoded(dtoRequest.getUserName()));
		return res.toString();
	}

	@Override
	protected DtoHttpRequest getRequest(DtoUploadRequest dtoRequest) {
		DtoHttpRequest res = super.getRequest(dtoRequest);
		res.setContent(dtoRequest.getFileName());
		res.setContentType(CONTENT_TYPE_MULTIPART);
		res.setMethod(METHOD_PATCH);
		res.setContentAsFile(true);
		return res;
	}

	@Override
	protected String getUrl() {
		return getUrlSubmission() + super.getUrl();
	}
}
