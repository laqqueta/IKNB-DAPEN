package id.go.ojk.lib.client.api;

import java.io.File;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.SSLContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HttpClient {
	private final DtoHttpClient parameter;

	public HttpClient(DtoHttpClient parameter) {
		this.parameter = parameter;
	}

	public DtoHttpResponse sendReceive(DtoHttpRequest dtoRequest) throws ConnectTimeoutException, SocketTimeoutException {
		log.info("Request={}", dtoRequest);
		DtoHttpResponse res = null;
		String url = dtoRequest.getUrl();
		try (CloseableHttpClient httpClient = getHttpClient(url.toLowerCase().startsWith("https"))) {
			HttpUriRequest request = getRequest(dtoRequest);
			HttpResponse response = httpClient.execute(request);
			res = getResponse(response);
		} catch (ConnectTimeoutException e) {
			throw new ConnectTimeoutException(e.getMessage());
		} catch (SocketTimeoutException e) {
			throw new SocketTimeoutException(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			res = new DtoHttpResponse();
			res.setResponseCode(503);
		}
		log.info("Response={}", res);
		return res;
	}
	
	@SneakyThrows
	private DtoHttpResponse getResponse(HttpResponse response) {
		DtoHttpResponse res = new DtoHttpResponse();
		if (response.getEntity() != null) {
			res.setContent(EntityUtils.toString(response.getEntity()));
			if (response.getEntity().getContentType() != null) {
				res.setContentType(response.getEntity().getContentType().getValue());
			}
		}
		if (response.getStatusLine() != null) {
			res.setResponseCode(response.getStatusLine().getStatusCode());
		}
		return res;
	}

	private HttpUriRequest getRequest(DtoHttpRequest dtoRequest) {
		if (dtoRequest.isGet()) {
			return getHttpGet(dtoRequest);
		} else if (dtoRequest.isPatch()) {
			return getHttpPatch(dtoRequest);
		} else if (dtoRequest.isPost()) {
			return getHttpPost(dtoRequest);
		} else if (dtoRequest.isPut()) {
			return getHttpPut(dtoRequest);
		}
		return null;
	}
	
	@SneakyThrows
	private HttpGet getHttpGet(DtoHttpRequest dtoRequest) {
		HttpGet res = new HttpGet(dtoRequest.getUrl());
		res.setConfig(getRequestConfig());
		res.setHeaders(getHeader(dtoRequest.getMapHeader()));
		return res;
	}
	
	@SneakyThrows
	private HttpPost getHttpPost(DtoHttpRequest dtoRequest) {
		HttpPost res = new HttpPost(dtoRequest.getUrl());
		res.setConfig(getRequestConfig());
		res.setEntity(getEntity(dtoRequest));
		res.setHeaders(getHeader(dtoRequest.getMapHeader()));
		return res;
	}

	@SneakyThrows
	private HttpPut getHttpPut(DtoHttpRequest dtoRequest) {
		HttpPut res = new HttpPut(dtoRequest.getUrl());
		res.setConfig(getRequestConfig());
		res.setEntity(getEntity(dtoRequest));
		res.setHeaders(getHeader(dtoRequest.getMapHeader()));
		return res;
	}

	@SneakyThrows
	private HttpPatch getHttpPatch(DtoHttpRequest dtoRequest) {
		HttpPatch res = new HttpPatch(dtoRequest.getUrl());
		res.setConfig(getRequestConfig());
		res.setEntity(getEntity(dtoRequest));
		res.setHeaders(getHeader(dtoRequest.getMapHeader()));
		return res;
	}
	
	@SneakyThrows
	private HttpEntity getEntity(DtoHttpRequest dtoRequest) {
		if (dtoRequest.isContentAsFile()) {
			final MultipartEntityBuilder builder = MultipartEntityBuilder.create();
			builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
			File file = new File(dtoRequest.getContent());
			return builder.addBinaryBody("file", file, ContentType.DEFAULT_BINARY, file.getName()).build();
		} else {
			if (dtoRequest.hasContent()) {
				return new StringEntity(dtoRequest.getContent(), getContentType(dtoRequest.getContentType()));
			}
		}
		return null;
	}
	
	private ContentType getContentType(String contentType) {
		if (StringUtils.isEmpty(contentType)) {
			return ContentType.TEXT_PLAIN;
		}
		String tmp = contentType.toLowerCase();
		if (tmp.contains("json")) {
			return ContentType.APPLICATION_JSON;
		} else if (tmp.contains("xml")) {
			return ContentType.APPLICATION_XML;
		}
		return ContentType.TEXT_PLAIN;
	}

	@SneakyThrows
	private CloseableHttpClient getHttpClient(boolean isSsl) {
		if (isSsl) {
			TrustStrategy acceptingTrustStrategy = (cert, authType) -> true;
			SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy).build();
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);

			Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
					.register("https", sslsf).register("http", new PlainConnectionSocketFactory()).build();

			BasicHttpClientConnectionManager connectionManager = new BasicHttpClientConnectionManager(
					socketFactoryRegistry);
			return HttpClients.custom().setSSLSocketFactory(sslsf).setConnectionManager(connectionManager).build();
		} else {
			return HttpClients.createDefault();
		}
	}
	
	private RequestConfig getRequestConfig() {
		return RequestConfig.custom()
				  .setConnectTimeout(parameter.getConnectTimeout())
				  .setConnectionRequestTimeout(parameter.getConnectTimeout())
				  .setSocketTimeout(parameter.getReadTimeout()).build();		
	}
	
	private Header[] getHeader(Map<String, String> mapHeader) {
		if (mapHeader == null || mapHeader.isEmpty()) {
			return new Header[0];
		}
		List<Header> res = new ArrayList<>();
		Iterator<Entry<String, String>> iterator = mapHeader.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, String> entry = iterator.next();
			res.add(new BasicHeader(entry.getKey(), entry.getValue()));
		}
		return res.toArray(new Header[res.size()]);
	}
}
