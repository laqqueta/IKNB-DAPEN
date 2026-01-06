package id.go.ojk.client.api;

import id.go.ojk.client.dto.DtoInitUploadRequest;
import id.go.ojk.client.dto.DtoInitUploadResponse;

public class ApiInitUpload extends BaseApi<DtoInitUploadRequest> {

	public ApiInitUpload() {
		super("/UploadFile");
	}

	@Override
	public DtoInitUploadResponse sendReceive(DtoInitUploadRequest dtoRequest) {
		return sendReceive(dtoRequest, DtoInitUploadResponse.class);
	}

	@Override
	protected String getUrl() {
		return getUrlSubmission() + super.getUrl();
	}
}
