package id.go.ojk.client.lab;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;

public class TestHttpProxy {

	public static void main(String args[]) throws ClientProtocolException, IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {

		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		credsProvider.setCredentials(new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT), new UsernamePasswordCredentials("corp/ext.arif", "arifpuji123"));

		HttpHost proxy = new HttpHost("inetgw-proxy.ojk.go.id", 8080, "http");

        RequestConfig config = RequestConfig.custom()
                .setProxy(proxy)
                .build();
        
		SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
			public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
				return true;
			}
		}).build();			
        
		CloseableHttpClient httpclient = HttpClients.custom()
				.setDefaultCredentialsProvider(credsProvider)
				.setSSLContext(sslContext)
				.setSSLHostnameVerifier(new NoopHostnameVerifier())
				.build();

		//HttpGet httpGet = new HttpGet("https://www.google.co.id");
		
		HttpGet httpGet = new HttpGet("https://202.124.203.175/slikftp");
		
		httpGet.setConfig(config);
		
		CloseableHttpResponse response = httpclient.execute(httpGet);

		System.out.println("response.getStatusLine() = " + response.getStatusLine());
		System.out.println(IOUtils.toString(response.getEntity().getContent()));
	}

}
