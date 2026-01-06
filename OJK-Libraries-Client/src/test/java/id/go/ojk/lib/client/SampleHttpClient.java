package id.go.ojk.lib.client;

import java.net.SocketTimeoutException;

import org.apache.http.conn.ConnectTimeoutException;

import id.go.ojk.lib.client.api.DtoHttpClient;
import id.go.ojk.lib.client.api.DtoHttpRequest;
import id.go.ojk.lib.client.api.DtoHttpResponse;
import id.go.ojk.lib.client.api.HttpClient;

public class SampleHttpClient {
	
	public static void main(String[] args) {
		try {
			System.out.println("<start>");
			sendGet();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("<end>");
		}
	}
	
	private static void sendGet() throws ConnectTimeoutException, SocketTimeoutException {
		HttpClient client = new HttpClient(new DtoHttpClient());
		DtoHttpResponse dtoResponse = client.sendReceive(getRequestGet());
		System.out.println(">" + dtoResponse + ">" + new String(dtoResponse.getContent()));
	}

	private static DtoHttpRequest getRequestGet() {
		DtoHttpRequest res = new DtoHttpRequest();
		res.setContent("{\"test\":\"test123\"}");
		res.setContentType("application/json");
		res.setMethod("GET");
		res.setUrl("http://localhost:8989/login");
		return res;
	}
}
