package id.go.ojk.lib.client;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.net.ssl.SSLContext;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultRedirectStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import id.go.ojk.lib.client.exception.SlikException;
import id.go.ojk.lib.client.model.ProxyConfig;
import id.go.ojk.lib.client.model.SlikClientLibConfig;
import id.go.ojk.lib.client.model.UserPassword;
import id.go.ojk.lib.client.model.bind.ProgressModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class HttpUtil {
	public static final String key_status = "status";
	public static final String key_message = "message";
	public static final String key_error = "error";
	public static final String key_errors = "errors";
	public static final String key_exception = "exception";
	public static final String key_payload = "payload";

	public static Map<String, String> getMapStringPayload(Map<String, Object> responseMap, String... payloadKeys) {
		Map<String, Object> payload = getPayload(responseMap);
		HashMap<String, String> result = new HashMap<>();

		for (String payloadKey : payloadKeys) {
			result.put(payloadKey, (String) payload.get(payloadKey));
		}

		return result;
	}

	// ~ message

	public static void cekSuccessResponse(Map<String, Object> responseMap) {
		if (isSuccessResponse(responseMap))
			return;
		throw new SlikException(getMessage(responseMap));
	}

	public static boolean isSuccessResponse(Map<String, Object> responseMap) {
		if (responseMap == null)
			return false;
		Integer respCode = (Integer) responseMap.get(key_status);
		return respCode == HttpStatus.SC_OK;
	}

	@SuppressWarnings("unchecked")
	public static String getErrorMessage(Map<String, Object> responseMap) {
		if (responseMap == null)
			return "";
		String message = "";

		List<String> errors = (List<String>) responseMap.get(key_errors);
		if (!CollectionUtil.isEmpty(errors)) {
			message = StringUtils.join(errors, "\n");
		}

		if (StringUtils.isEmpty(message)) {
			message = (String) responseMap.get(key_exception);
		}

		return message;
	}

	@SuppressWarnings("unchecked")
	public static String getMessage(Map<String, Object> responseMap) {
		if (responseMap == null)
			return "";
		String message = (String) responseMap.get(key_message);
		if (StringUtils.isEmpty(message))
			message = (String) responseMap.get(key_error);
		if (StringUtils.isEmpty(message)) {
			List<String> errors = (List<String>) responseMap.get(key_errors);
			if (!CollectionUtil.isEmpty(errors)) {
				message = StringUtils.join(errors, "\n");
			}
		}
		if (StringUtils.isEmpty(message))
			message = (String) responseMap.get(key_exception);
		return message;
	}

	// ~ post json

	public static Map<String, Object> download(ProgressModel progressModel, HttpClient httpClient, String url,
			Map<String, ? extends Object> input, File tmpFile, ProxyConfig proxyConfig)
			throws IOException {
		tmpFile.getParentFile().mkdirs();
		String jsonRequest = HttpUtil.toJson(input);
		StringEntity requestEntity = new StringEntity(jsonRequest, ContentType.APPLICATION_JSON);

		// HttpPost postMethod = new HttpPost(url);
		HttpPost postMethod = createHttpPost(url, proxyConfig);

		postMethod.setEntity(requestEntity);
		HttpResponse response = httpClient.execute(postMethod);
		if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			Map<String, Object> resultMap = new HashMap<>();
			resultMap.put(key_status, HttpStatus.SC_OK);

			try (InputStream inputStream = response.getEntity().getContent();
					OutputStream outputStream = new FileOutputStream(tmpFile)) {

				if (progressModel == null) {
					IOUtils.copy(inputStream, outputStream);
				} else {
					progressModel.setTotalLength(Long.parseLong(response.getFirstHeader("Content-Length").getValue()));
					MeteredIOCopyersPararel ioCopyers = new MeteredIOCopyersPararel(progressModel);
					ioCopyers.copy(inputStream, outputStream);
				}
			}

			return resultMap;
		} else {
			return HttpUtil.jsonToMap(response);
		}
	}

	public static Map<String, Object> postMapReturnJsonMap(HttpClient httpClient, String url,
			Map<String, ? extends Object> input, ProxyConfig proxyConfig) throws IOException {
		String jsonRequest = HttpUtil.toJson(input);
		log.debug("jsonRequest={}", jsonRequest);
		return postJsonReturnMap(httpClient, url, jsonRequest, proxyConfig);
	}

	public static HttpResponse postMap(HttpClient httpClient, String url, Map<String, ? extends Object> input,
			ProxyConfig proxyConfig) throws IOException {
		String jsonRequest = HttpUtil.toJson(input);

		StringEntity requestEntity = new StringEntity(jsonRequest, ContentType.APPLICATION_JSON);

		HttpPost postMethod = createHttpPost(url, proxyConfig);

		postMethod.setEntity(requestEntity);
		return httpClient.execute(postMethod);
	}

	public static HttpResponse postJsonReturnHttpResponse(HttpClient httpClient, String url, String jsonRequest,
			UserPassword userPassword, ProxyConfig proxyConfig) throws ClientProtocolException, IOException {
		StringEntity requestEntity = new StringEntity(jsonRequest, ContentType.APPLICATION_JSON);
		HttpPost postMethod = createHttpPost(url, proxyConfig);
		if (userPassword != null) {
			postMethod.setHeader(HttpHeaders.AUTHORIZATION, userPassword.getBasicAuthenticationHeader());
		}
		postMethod.setEntity(requestEntity);
		HttpResponse response = httpClient.execute(postMethod);
		return response;
	}

	public static Map<String, Object> postJsonReturnMap(HttpClient httpClient, String url, String jsonRequest,
			ProxyConfig proxyConfig) throws ClientProtocolException, IOException {
//		StringEntity requestEntity = new StringEntity(jsonRequest, ContentType.APPLICATION_JSON);
//		
//		//HttpPost postMethod = new HttpPost(url);
//		HttpPost postMethod = createHttpPost(url, proxyConfig);
//		
//		postMethod.setEntity(requestEntity);
//		HttpResponse response = httpClient.execute(postMethod);

		HttpResponse response = postJsonReturnHttpResponse(httpClient, url, jsonRequest, proxyConfig);
		return HttpUtil.jsonToMap(response);
	}

	public static String postJsonReturnString(HttpClient httpClient, String url, String jsonRequest,
			ProxyConfig proxyConfig) throws ClientProtocolException, IOException {
		HttpResponse response = postJsonReturnHttpResponse(httpClient, url, jsonRequest, proxyConfig);
		return HttpUtil.readJson(response);
	}

	public static HttpResponse postJsonReturnHttpResponse(HttpClient httpClient, String url, String jsonRequest,
			ProxyConfig proxyConfig) throws ClientProtocolException, IOException {
		StringEntity requestEntity = new StringEntity(jsonRequest, ContentType.APPLICATION_JSON);

		HttpPost postMethod = createHttpPost(url, proxyConfig);

		postMethod.setEntity(requestEntity);
		HttpResponse response = httpClient.execute(postMethod);
		return response;
	}

	// ~ post byte

	public static Map<String, Object> postByteReturnMap(HttpClient httpClient, String url, InputStream instream,
			ProxyConfig proxyConfig) throws ClientProtocolException, IOException {
		InputStreamEntity requestEntity = new InputStreamEntity(instream);

		// HttpPost postMethod = new HttpPost(url);
		HttpPost postMethod = createHttpPost(url, proxyConfig);

		postMethod.setEntity(requestEntity);
		HttpResponse response = httpClient.execute(postMethod);
		return HttpUtil.jsonToMap(response);
	}

	public static byte[] postByteReturnByte(String url, byte[] input) throws ClientProtocolException, IOException,
			KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
		return postByteReturnByte(buildHttpClient(), url, new ByteArrayInputStream(input), null);
	}

	public static byte[] postByteReturnByte(HttpClient httpClient, String url, byte[] input, ProxyConfig proxyConfig)
			throws ClientProtocolException, IOException {
		return postByteReturnByte(httpClient, url, new ByteArrayInputStream(input), proxyConfig);
	}

	public static byte[] postByteReturnByte(HttpClient httpClient, String url, InputStream inputStream,
			ProxyConfig proxyConfig) throws ClientProtocolException, IOException {
		InputStreamEntity requestEntity = new InputStreamEntity(inputStream);

		HttpPost postMethod = createHttpPost(url, proxyConfig);

		postMethod.setEntity(requestEntity);
		HttpResponse response = httpClient.execute(postMethod);

		if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			return IOUtils.toByteArray(response.getEntity().getContent());
		} else {
			return null;
		}
	}

	// ~ post request param

	public static Map<String, Object> sendParamReturnMap(HttpClient httpClient, String url, String method, String name,
			String value, ProxyConfig proxyConfig) throws ClientProtocolException, IOException, URISyntaxException {
		List<NameValuePair> nameValuePairs = new ArrayList<>();
		if (StringUtils.isNotEmpty(name) && StringUtils.isNotEmpty(value)) {
			nameValuePairs.add(new BasicNameValuePair(name, value));
		}
		return sendParamReturnMap(httpClient, url, method, nameValuePairs, proxyConfig);
	}

	public static Map<String, Object> sendParamReturnMap(HttpClient httpClient, String url, String method,
			List<NameValuePair> nameValuePairs, ProxyConfig proxyConfig)
			throws ClientProtocolException, IOException, URISyntaxException {
		if (nameValuePairs == null)
			nameValuePairs = new ArrayList<>();

		UrlEncodedFormEntity requestEntity = new UrlEncodedFormEntity(nameValuePairs);
		HttpResponse response = null;
		if (HttpPost.METHOD_NAME.equalsIgnoreCase(method)) {

			// HttpPost postMethod = new HttpPost(url);
			HttpPost postMethod = createHttpPost(url, proxyConfig);

			postMethod.setEntity(requestEntity);
			response = httpClient.execute(postMethod);
		} else {
//			URIBuilder uriBuilder = new URIBuilder(url).addParameters(nameValuePairs);
//			URI uri = uriBuilder.build();
			// HttpGet httpGet = new HttpGet(uri);
			HttpGet httpGet = createHttpGet(url, proxyConfig);
			response = httpClient.execute(httpGet);
		}
		return HttpUtil.jsonToMap(response);
	}

	// UserPassword userPassword

	public static HttpResponse sendParamReturnHttpResponse(HttpClient httpClient, String url, String method,
			List<NameValuePair> nameValuePairs, UserPassword userPassword, ProxyConfig proxyConfig)
			throws IOException, URISyntaxException {

		UrlEncodedFormEntity requestEntity = new UrlEncodedFormEntity(nameValuePairs);
		HttpResponse response = null;
		if (HttpPost.METHOD_NAME.equalsIgnoreCase(method)) {

			HttpPost postMethod = createHttpPost(url, proxyConfig);

			postMethod.setEntity(requestEntity);
			if (userPassword != null) {
				postMethod.setHeader(HttpHeaders.AUTHORIZATION, userPassword.getBasicAuthenticationHeader());
			}
			response = httpClient.execute(postMethod);
		} else {
			URIBuilder uriBuilder = new URIBuilder(url).addParameters(nameValuePairs);
			URI uri = uriBuilder.build();
			HttpGet httpGet = createHttpGet(uri, proxyConfig);
			if (userPassword != null) {
				httpGet.setHeader(HttpHeaders.AUTHORIZATION, userPassword.getBasicAuthenticationHeader());
			}
			response = httpClient.execute(httpGet);
		}
		return response;
	}

	public static HttpResponse sendParamReturnHttpResponse(HttpClient httpClient, String url, String method,
			List<NameValuePair> nameValuePairs, ProxyConfig proxyConfig)
			throws ClientProtocolException, IOException, URISyntaxException {
		return sendParamReturnHttpResponse(httpClient, url, method, nameValuePairs, null, proxyConfig);
//		UrlEncodedFormEntity requestEntity = new UrlEncodedFormEntity(nameValuePairs);
//		HttpResponse response = null;
//		if ( HttpPost.METHOD_NAME.equalsIgnoreCase(method) ) {
//
//			//HttpPost postMethod = new HttpPost(url);
//			HttpPost postMethod = createHttpPost(url, proxyConfig);
//			
//			postMethod.setEntity(requestEntity);
//			response = httpClient.execute(postMethod);
//		} else {
//			URIBuilder uriBuilder = new URIBuilder(url).addParameters(nameValuePairs);
//			URI uri = uriBuilder.build();
//			//HttpGet httpGet = new HttpGet(uri);
//			HttpGet httpGet = createHttpGet(uri, proxyConfig);
//			response = httpClient.execute(httpGet);
//		}
//		return response;
	}

	private static RequestConfig getRequestConfig(ProxyConfig proxyConfig) {

		RequestConfig.Builder builder = RequestConfig.custom();
		if (proxyConfig != null && StringUtils.isNotEmpty(proxyConfig.getHost())) {
			HttpHost proxy = new HttpHost(proxyConfig.getHost(), proxyConfig.getPort(), "http");
			builder.setProxy(proxy);
		}
		RequestConfig requestConfig = builder.build();
		return requestConfig;
	}

	private static HttpGet createHttpGet(String url, ProxyConfig proxyConfig) {
		HttpGet httpGet = new HttpGet(url);
		httpGet.setConfig(getRequestConfig(proxyConfig));
		return httpGet;
	}

	private static HttpGet createHttpGet(URI uri, ProxyConfig proxyConfig) {
		HttpGet httpGet = new HttpGet(uri);
		httpGet.setConfig(getRequestConfig(proxyConfig));
		return httpGet;
	}

	private static HttpPost createHttpPost(String url, ProxyConfig proxyConfig) {
		HttpPost httpPost = new HttpPost(url);
		httpPost.setConfig(getRequestConfig(proxyConfig));
		return httpPost;
	}

	// ~ json

	public static String readJson(HttpResponse response) throws IOException {
		String jsonResponse = null;
		if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			jsonResponse = IOUtils.toString(response.getEntity().getContent());
		} else {
			jsonResponse = IOUtils.toString(response.getEntity().getContent());
			log.warn("HTTP status code " + response.getStatusLine().getStatusCode() + ", jsonResponse " + jsonResponse);
		}
		log.info("Json Response " + jsonResponse);
		return jsonResponse;
	}

	public static Map<String, Object> jsonToMap(HttpResponse response) throws IOException {
		String jsonResponse = readJson(response);
		if (StringUtils.isNotEmpty(jsonResponse)) {
			return jsonToMap(jsonResponse);
		}
		return null;
	}

	public static String toJson(Map<String, ? extends Object> input) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(input);
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> jsonToMap(String json) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json, HashMap.class);
	}

	public static Map<String, String> jsonToMapString(HttpResponse response) throws IOException {
		String jsonResponse = readJson(response);
		if (StringUtils.isNotEmpty(jsonResponse)) {
			return jsonToMapString(jsonResponse);
		}
		return new HashMap<>();
	}

	@SuppressWarnings("unchecked")
	public static Map<String, String> jsonToMapString(String json) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json, HashMap.class);
	}

	// ~

	public static boolean isNeedRelogin401(Map<String, Object> serverResponse) {
		if (getStatus(serverResponse) == 401)
			return true;
		else
			return false;
	}

	public static int getStatus(Map<String, Object> serverResponse) {
		return (int) serverResponse.get(key_status);
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> getPayload(Map<String, Object> serverResponse) {
		return (Map<String, Object>) serverResponse.get(key_payload);
	}

	public static CloseableHttpClient buildHttpClient(String url, ProxyConfig proxyConfig, BasicCookieStore cookieStore)
			throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
		boolean isHttps = url.toLowerCase().startsWith("https");
		return buildHttpClient(isHttps, proxyConfig, cookieStore);
	}

	public static CloseableHttpClient buildHttpClient()
			throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
		return buildHttpClient(false, null, null);
	}

	public static CloseableHttpClient buildHttpClient(boolean isHttps, ProxyConfig proxyConfig,
			BasicCookieStore cookieStore) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
		HttpClientBuilder httpClientBuilder = HttpClients.custom();
		if (cookieStore != null) {
			httpClientBuilder.setDefaultCookieStore(cookieStore);
		}
		httpClientBuilder.setRedirectStrategy(new DefaultRedirectStrategy() {
			@Override
			protected boolean isRedirectable(String method) {
				return true;
			};
		});

		// proxy username password
		if (proxyConfig != null && StringUtils.isNotEmpty(proxyConfig.getHost())
				&& StringUtils.isNotEmpty(proxyConfig.getUser())) {
			CredentialsProvider credsProvider = new BasicCredentialsProvider();
			credsProvider.setCredentials(new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT),
					new UsernamePasswordCredentials(proxyConfig.getUser(), proxyConfig.getPassword()));

			httpClientBuilder.setDefaultCredentialsProvider(credsProvider);
		}

		if (isHttps) {
			if (SlikClientLibConfig.allowUntrustCertividate) {
				SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
					public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
						return true;
					}
				}).build();
				httpClientBuilder.setSSLContext(sslContext).setSSLHostnameVerifier(new NoopHostnameVerifier());
			} else {

			}
		}

		// int timeout = 60000;
		int timeout = 5000;
		// ~ config
		RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(timeout)
				.setConnectTimeout(timeout).setSocketTimeout(timeout).build();
		httpClientBuilder.setDefaultRequestConfig(requestConfig);

//		PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
//		httpClientBuilder.setConnectionManager(connectionManager);

		return httpClientBuilder.build();
	}

	public static String createUrlQueryString(String url, List<NameValuePair> nameValuePairs) {
		return url + "?" + createQueryString(nameValuePairs);
	}

	public static String createQueryString(List<NameValuePair> nameValuePairs) {
		return nameValuePairs.stream().map(e -> {
			try {
				return e.getName() + "=" + URLEncoder.encode(e.getValue(), "UTF-8");
			} catch (Exception e1) {
				e1.printStackTrace();
				throw new SlikException("", e1);
			}
		}).collect(Collectors.joining("&"));
	}

}
