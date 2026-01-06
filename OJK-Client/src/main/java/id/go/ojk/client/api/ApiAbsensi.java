package id.go.ojk.client.api;

import id.go.ojk.client.dto.DtoAbsensiRequest;
import id.go.ojk.client.dto.DtoAbsensiResponse;
import id.go.ojk.lib.client.api.DtoHttpRequest;
import lombok.SneakyThrows;

public class ApiAbsensi extends BaseApi<DtoAbsensiRequest> {

	public ApiAbsensi() {
		super("/Absensi");
	}

	@Override
	public DtoAbsensiResponse sendReceive(DtoAbsensiRequest dtoRequest) {
		return sendReceive(dtoRequest, DtoAbsensiResponse.class);
	}

	@SneakyThrows
	@Override
	protected String getQueryString(DtoAbsensiRequest dtoRequest) {
		StringBuilder res = new StringBuilder("?");
		res.append("FullEntityCode=").append(urlEncoded(dtoRequest.getFullEntityCode())).append("&");
		res.append("JenisKoreksi=").append(urlEncoded(dtoRequest.getJenisKoreksi())).append("&");
		res.append("PeriodCode=").append(urlEncoded(dtoRequest.getPeriodCode())).append("&");
		res.append("PeriodDate=").append(urlEncoded(dtoRequest.getPeriodDate())).append("&");
		res.append("ReportCode=").append(urlEncoded(dtoRequest.getReportCode())).append("&");
		res.append("ReportFormGroupCode=").append(urlEncoded(dtoRequest.getReportFormGroupCode())).append("&");
		res.append("RutinFlag=").append(urlEncoded(dtoRequest.getRutinFlag())).append("&");
		res.append("Username=").append(urlEncoded(dtoRequest.getUserName()));
		return res.toString();
	}

	@Override
	protected DtoHttpRequest getRequest(DtoAbsensiRequest dtoRequest) {
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
