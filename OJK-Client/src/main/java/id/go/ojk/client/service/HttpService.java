package id.go.ojk.client.service;

import static id.go.ojk.lib.client.model.constant.SignatureConstant.sigKey_dataYearMonth;
import static id.go.ojk.lib.client.model.constant.SignatureConstant.sigKey_submissionTime;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;

import id.go.ojk.client.service.base.BaseService;
import id.go.ojk.client.service.security.SecurityService;
import id.go.ojk.lib.client.HttpUtil;
import id.go.ojk.lib.client.exception.SlikException;
import id.go.ojk.lib.client.model.ProxyConfig;
import id.go.ojk.lib.client.model.bind.ProgressModel;
import id.go.ojk.lib.client.model.bind.SendingModel;
import id.go.ojk.lib.client.model.constant.OjkClientConstant;
import id.go.ojk.lib.client.model.constant.OjkClientUrlConstant;
import id.go.ojk.lib.client.service.context.ApplicationContext;

public class HttpService extends BaseService {

	private ConfigService configService;
	private SecurityService securityService;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		super.setApplicationContext(applicationContext);
		this.configService = applicationContext.getService(ConfigService.class);
		this.securityService = applicationContext.getService(SecurityService.class);
	}
	
	public boolean sendConnectionTest(String baseUrl, ProxyConfig proxyConfig) throws ClientProtocolException, IOException, URISyntaxException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException{
		String url = getConnectionTestUrl(baseUrl);
		logger.info("sendConnectionTest() url = " + url);
		
		BasicCookieStore cookieStore = new BasicCookieStore();
		CloseableHttpClient httpclient = buildHttpClient(proxyConfig, cookieStore);
		Map<String, Object> responseMap = HttpUtil.sendParamReturnMap(httpclient, url, HttpPost.METHOD_NAME, null, proxyConfig);
		return HttpUtil.isSuccessResponse(responseMap);
	}

	public Map<String, Object> sendHeartbeat() throws ClientProtocolException, IOException, URISyntaxException{
		logger.debug("sendHeartbeat()");
		Map<String, Object> result = HttpUtil.sendParamReturnMap(httpclient, getHeartbeatUrl(), HttpGet.METHOD_NAME, null, configService.getProxyConfig());
		if ( HttpUtil.isNeedRelogin401(result) ){
			Map<String, Object> reloginResult = securityService.relogin(false);
			if ( HttpUtil.isSuccessResponse(reloginResult) ){
				result = HttpUtil.sendParamReturnMap(httpclient, getHeartbeatUrl(), HttpGet.METHOD_NAME, null, configService.getProxyConfig());
			}
		}
		
		return result;
	}

	public Map<String, Object> testLogout() throws ClientProtocolException, IOException, URISyntaxException{
		logger.debug("testLogout()");
		Map<String, Object> result = HttpUtil.sendParamReturnMap(httpclient, getLogoutUrl(), HttpGet.METHOD_NAME, null, configService.getProxyConfig());
		return result;
	}

	public Map<String, Object> logout() throws ClientProtocolException, IOException, URISyntaxException{
		logger.debug("logout()");
		Map<String, Object> result = HttpUtil.sendParamReturnMap(httpclient, getLogoutUrl(), HttpGet.METHOD_NAME, null, configService.getProxyConfig());
		cookieStore.clear();
		return result;
	}
	
	public Map<String, Object> validateFutureDate(String dataYearMonthString, String submissionTimeString) throws ClientProtocolException, IOException {
		logger.debug("validateFutureDate()");
		Map<String, Object> input = new HashMap<>();
		input.put(sigKey_dataYearMonth, dataYearMonthString);
		input.put(sigKey_submissionTime, submissionTimeString);
		return postMapReturnJsonMap(httpclient, getSubmissionCheckFutureDateUrl(), input, configService.getProxyConfig(), true);
	}

	public Map<String, Object> sendSignature(SendingModel sendingModel) throws ClientProtocolException, IOException{
		logger.debug("sendSignature()");
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(sendingModel.getSignatureFile());
			String url = getUrlQueryString(getSubmissionSignatureUrl(), sendingModel);
			return HttpUtil.postByteReturnMap(httpclient, url, inputStream, configService.getProxyConfig());
		} finally {
			IOUtils.closeQuietly(inputStream);
		}
	}

	public Map<String, Object> checkSignature(SendingModel sendingModel) throws ClientProtocolException, IOException{
		logger.debug("checkSignature()");
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(sendingModel.getSignatureFile());			
			String url = getUrlQueryString(getSubmissionCheckSignatureUrl(), sendingModel);
			return HttpUtil.postByteReturnMap(httpclient, url, inputStream, configService.getProxyConfig());
		} finally {
			IOUtils.closeQuietly(inputStream);
		}
	}
	
	public String getUrlQueryString(String url, SendingModel sendingModel) throws ClientProtocolException, IOException{
		List<NameValuePair> nameValuePairs = new ArrayList<>();
		if ( StringUtils.isNotEmpty(sendingModel.getMemberRefNumber())  ){
			nameValuePairs.add(new BasicNameValuePair("memberRefNumber", sendingModel.getMemberRefNumber()));
			nameValuePairs.add(new BasicNameValuePair("memberRefDate", new SimpleDateFormat("yyyyMMddHHmmss").format(sendingModel.getMemberRefDate())));
			nameValuePairs.add(new BasicNameValuePair("offlineUplReasonCode", sendingModel.getOfflineUplReasonCode()));
		}
		
		return  HttpUtil.createUrlQueryString(url, nameValuePairs);
	}

	public Map<String, Object> sendReady(String submissionId) throws ClientProtocolException, IOException, URISyntaxException{
		logger.debug("sendReady()");
		return HttpUtil.sendParamReturnMap(httpclient, getSubmissionReadyUrl(), HttpPost.METHOD_NAME, "submissionId", submissionId, configService.getProxyConfig());
	}

	public Map<String, Object> cekStatusReady(String submissionId) throws ClientProtocolException, IOException, URISyntaxException{
		logger.debug("sendReady()");
		return HttpUtil.sendParamReturnMap(httpclient, getSubmissionCekStatusReadyUrl(), HttpPost.METHOD_NAME, "submissionId", submissionId, configService.getProxyConfig());
	}

	//~ initialized 
	
	public void proxyConfigChange() {
		try {
			initHttpClient(configService.getProxyConfig());
		} catch (KeyManagementException | NoSuchAlgorithmException | KeyStoreException e) {
			throw new SlikException("fail init http client", e);
		}
	}

	@Override
	public void initialize() {
		try {
			initHttpClient(configService.getProxyConfig());
		} catch (KeyManagementException | NoSuchAlgorithmException | KeyStoreException e) {
			throw new SlikException("fail init http client", e);
		}
	}

	private BasicCookieStore cookieStore = null;
	private CloseableHttpClient httpclient = null;
	public void initHttpClient(ProxyConfig proxyConfig) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException{
		if ( cookieStore == null )
			cookieStore = new BasicCookieStore();
		
		httpclient = buildHttpClient(proxyConfig, cookieStore);
	}
	
	private CloseableHttpClient buildHttpClient(ProxyConfig proxyConfig, BasicCookieStore cookieStore) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
		return HttpUtil.buildHttpClient(OjkClientConstant.isHttps(configService.isExtranetConnectionType()), proxyConfig, cookieStore);		
	}
	
	//~ post json

	public String getReturnString(String url) throws ClientProtocolException, IOException, URISyntaxException {
		HttpResponse httpResponse = HttpUtil.sendParamReturnHttpResponse(httpclient, url, HttpGet.METHOD_NAME, new ArrayList<NameValuePair>(), configService.getProxyConfig());
		return IOUtils.toString(httpResponse.getEntity().getContent());
	}

//	public Map<String, Object> postMapReturnJsonMap(String url, Map<String, ? extends Object> input) throws ClientProtocolException, IOException {
//		String jsonRequest = HttpUtil.toJson(input);
//		Map<String, Object> response  = HttpUtil.postJsonReturnMap(httpclient, url, jsonRequest, configService.getProxyConfig());
//		return response;
//	}
	
	public Map<String, Object> postMapReturnJsonMap(String url, Map<String, ? extends Object> input, boolean reLoginIfNotAuthenticate) throws ClientProtocolException, IOException {
		String jsonRequest = HttpUtil.toJson(input);
		Map<String, Object> response  = HttpUtil.postJsonReturnMap(httpclient, url, jsonRequest, configService.getProxyConfig());
		if ( HttpUtil.isNeedRelogin401(response) ){
			if ( reLoginIfNotAuthenticate ){
				Map<String, Object> loginResponse = securityService.relogin(false);
				if ( HttpUtil.isSuccessResponse(loginResponse) ){
					return postMapReturnJsonMap(url, input, false);
				} else {
					return response;
				}
			}
		}

		return response;
	}
	
	public String postMapReturnString(String url, Map<String, ? extends Object> input, boolean reLoginIfNotAuthenticate) throws ClientProtocolException, IOException {
		String jsonRequest = HttpUtil.toJson(input);
		String response  = HttpUtil.postJsonReturnString(httpclient, url, jsonRequest, configService.getProxyConfig());
		return response;
	}

	public Map<String, Object> download(ProgressModel progressModel, String url, Map<String, ? extends Object> input, File tmpFile) throws ClientProtocolException, IOException {
		return HttpUtil.download(progressModel, httpclient, url, input, tmpFile, configService.getProxyConfig());
	}
	
	public Map<String, Object> postMapReturnJsonMap(HttpClient httpClient, String url, Map<String, ? extends Object> input, ProxyConfig proxyConfig, boolean reLoginIfNotAuthenticate) throws ClientProtocolException, IOException {
		String jsonRequest = HttpUtil.toJson(input);
		Map<String, Object> response = HttpUtil.postJsonReturnMap(httpClient, url, jsonRequest, proxyConfig);
		if ( HttpUtil.isNeedRelogin401(response) ){
			if ( reLoginIfNotAuthenticate ){
				Map<String, Object> loginResponse = securityService.relogin(false);
				if ( HttpUtil.isSuccessResponse(loginResponse) ){
					return postMapReturnJsonMap(httpClient, url, input, proxyConfig, false);
				} else {
					return response;
				}
			}
		}
		return response;
	}
		
	//~ url
	
	public String getSubmissionCheckFutureDateUrl(){
		return configService.getHttpBaseUrl() + "/" + OjkClientUrlConstant.PATH_SUBMISSION_CHECK_FUTUREDATE;
	}
		
	public String getSubmissionSignatureUrl(){
		return configService.getHttpBaseUrl() + "/" + OjkClientUrlConstant.PATH_SUBMISSION_SIGNATURE;
	}

	public String getSubmissionCheckSignatureUrl(){
		return configService.getHttpBaseUrl() + "/" + OjkClientUrlConstant.PATH_SUBMISSION_CHECK_SIGNATURE;
	}

	public String getSubmissionReadyUrl(){
		return configService.getHttpBaseUrl() + "/" + OjkClientUrlConstant.PATH_SUBMISSION_READY;
	}
	
	public String getSubmissionCekStatusReadyUrl(){
		return configService.getHttpBaseUrl() + "/" + OjkClientUrlConstant.PATH_SUBMISSION_CEKSTATUSREADY;
	}

	public String getCheckVersionUrl(){
		return configService.getHttpBaseUrl() + "/" + OjkClientUrlConstant.PATH_DOWNLOAD_CEKVERSION;
	}

	public String getDownloadUpdateOnlineUrl(){
		return configService.getHttpBaseUrl() + "/" + OjkClientUrlConstant.PATH_DOWNLOAD_UPDATEONLINE;
	}
	
	public String getChangePasswordUrl(){
		return configService.getHttpBaseUrl() + "/" + OjkClientUrlConstant.PATH_CHANGEPASSWORD;
	}

	public String getLoginUrl(){
		return configService.getHttpBaseUrl() + "/" + OjkClientUrlConstant.PATH_LOGIN;
	}

	public String getLogoutUrl(){
		return configService.getHttpBaseUrl() + "/" + OjkClientUrlConstant.PATH_LOGOUT;
	}
	
	public String getHeartbeatUrl(){
		return configService.getHttpBaseUrl() + "/" + OjkClientUrlConstant.PATH_CLIENTHEARTBEAT;
	}
	
	public String getConnectionTestUrl(String baseUrl){
		return baseUrl + "/" +  OjkClientUrlConstant.PATH_PUB_CONNECTIONTEST;
	}
	
	public String getOjkMemberStaticAttribute(){
		return configService.getHttpBaseUrl() + "/" + OjkClientUrlConstant.PATH_OJK_MEMBERSTATICATTRIBUTE;
	}


}
