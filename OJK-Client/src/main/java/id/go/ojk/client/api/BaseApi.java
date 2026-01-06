package id.go.ojk.client.api;

import java.io.Serializable;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHeaders;

import id.go.ojk.client.ClientProperties;
import id.go.ojk.client.dto.DtoBaseResponse;
import id.go.ojk.client.dto.DtoLoginRequest;
import id.go.ojk.client.dto.DtoUploadRequest;
import id.go.ojk.client.service.SetupService;
import id.go.ojk.client.service.context.ApplicationContextClient;
import id.go.ojk.client.service.security.SecurityService;
import id.go.ojk.lib.client.api.DtoHttpClient;
import id.go.ojk.lib.client.api.DtoHttpRequest;
import id.go.ojk.lib.client.api.DtoHttpResponse;
import id.go.ojk.lib.client.api.HttpClient;
import id.go.ojk.lib.client.util.JsonUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BaseApi<T extends Serializable> implements IApi<T> {
	protected static final String CONTENT_TYPE_JSON = "application/json";
	protected static final String CONTENT_TYPE_MULTIPART = "multipart/form-data";
	protected static final String METHOD_GET = "GET";
	protected static final String METHOD_POST = "POST";
	protected static final String METHOD_PUT = "PUT";
	protected static final String METHOD_PATCH = "PATCH";
	protected SecurityService securityService;
	protected SetupService setupService;
	protected String path;
	
	protected BaseApi(String path) {
		try {
			this.path = path;
			this.securityService = ApplicationContextClient.getInstance().getService(SecurityService.class);
			this.setupService = ApplicationContextClient.getInstance().getService(SetupService.class);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	public boolean isNoResponse(DtoBaseResponse dtoResponse) {
		return dtoResponse == null;
	}
	
	public boolean isSucceed(DtoBaseResponse dtoResponse) {
		return dtoResponse != null && dtoResponse.getResponseCode().equals("200") && dtoResponse.isSucceed();
	}
	
	protected <R extends DtoBaseResponse> R sendReceive(T dtoRequest, Class<?> classResponse) {
		List<Integer> timeouts = getTimeout(dtoRequest);
		DtoHttpResponse dtoHttpResponse = null;
		for (int timeout : timeouts) {
 			HttpClient client = new HttpClient(getParameter(timeout));
			try {
				dtoHttpResponse = client.sendReceive(getRequest(dtoRequest));
				break;
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
		if (dtoHttpResponse == null || dtoHttpResponse.getContent() == null) {
			return null;
		}
		R res = null;
		if (dtoHttpResponse.getContentType() != null && dtoHttpResponse.getContentType().contains("json")) {
			res = JsonUtil.fromJson(dtoHttpResponse.getContent(), classResponse);
		}
		if (res != null) {
			res.setResponseCode(String.valueOf(dtoHttpResponse.getResponseCode()));
			log.debug("Response Content={}", res);
		}
		return res;
	}
	
	private List<Integer> getTimeout(T dtoRequest) {
		List<Integer> res = new ArrayList<>();
		String tmp = ClientProperties.getInstance().getValue(ClientProperties.READ_TIMEOUT, "60000");
		String[] arr = StringUtils.split(tmp, ',');
		if (dtoRequest instanceof DtoUploadRequest) {
			for (String timeout : arr) {
				res.add(Integer.valueOf(timeout));
			}
		} else {
			res = Arrays.asList(Integer.valueOf(arr[0]));
		}
		return res;
	}
	
	protected DtoHttpClient getParameter(int readTimeout) {
		DtoHttpClient res = new DtoHttpClient();
		res.setConnectTimeout(ClientProperties.getInstance().getValueAsInt(ClientProperties.CONNECT_TIMEOUT, 5000));
		res.setReadTimeout(readTimeout);
		return res;
	}
	
	protected DtoHttpRequest getRequest(T dtoRequest) {
		DtoHttpRequest res = new DtoHttpRequest();
		res.setContent(getContent(dtoRequest));
		res.setContentType(CONTENT_TYPE_JSON);
		res.setMapHeader(getMapHeader(dtoRequest));
		res.setMethod(METHOD_POST);
		res.setUrl(getUrl() + getQueryString(dtoRequest));
		return res;
	}
	
	protected String getContent(T dtoRequest) {
		return JsonUtil.toJson(dtoRequest, true);
	}
	
	protected Map<String, String> getMapHeader(T dtoRequest) {
		Map<String, String> res = new HashMap<>();
		if (dtoRequest instanceof DtoLoginRequest) {
			DtoLoginRequest dto = (DtoLoginRequest) dtoRequest;
			addBasicAuth(res, dto);
		} else {
			addBearerAuth(res);
		}
		return res;
	}
	
	protected String getQueryString(T dtoRequest) {
		log.trace("Request={}", dtoRequest);
		return "";
	}
	
	protected String getUrl() {
		return path;
	}
	
	@SneakyThrows
	protected String urlEncoded(String value) {
		if (StringUtils.isEmpty(value)) {
			return "";
		}
		return URLEncoder.encode(value, StandardCharsets.UTF_8.name());
	}

	protected String getUrlSubmission() {
		return setupService != null ? setupService.getClientUrlSubmission() : "http://157.15.77.140:8991/api";
	}

	protected String getUrlAuth() {
		return setupService != null ? setupService.getClientUrlAuth() : "http://157.15.77.140:8992/api";
	}
	
	private void addBearerAuth(Map<String, String> mapHeader) {
		if (securityService != null && securityService.getUserSession() != null) {
			addMapHeader(mapHeader, HttpHeaders.AUTHORIZATION, "Bearer " + securityService.getUserSession().getSessionId());
		} else {
			addMapHeader(mapHeader, HttpHeaders.AUTHORIZATION, "Bearer xcOgTmd4UUu9sb4+wH9BT6KEJROTgVIvlx+fOvgAn4w=");
		}
	}
	
	private void addBasicAuth(Map<String, String> mapHeader, DtoLoginRequest dtoRequest) {
		String tmp = Base64.getEncoder().encodeToString((dtoRequest.getUserId() + ":" + dtoRequest.getPassword()).getBytes());
		addMapHeader(mapHeader, HttpHeaders.AUTHORIZATION, "Basic " + tmp);
	}
	
	private void addMapHeader(Map<String, String> mapHeader, String key, String value) {
		mapHeader.put(key, value);
	}
}
