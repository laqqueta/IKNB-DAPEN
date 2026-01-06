package id.go.ojk.lib.client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

public class KdfUploadTest {
	
	public static void main(String args[]) throws FileNotFoundException, IOException, URISyntaxException{
		testSubmitReport();
	}
	
	//public static Map<String, Object> submitReport(HttpClient httpClient, String url, UserPassword userPassword, String memberTypeCode, String memberCode, String submissionId) throws IOException, URISyntaxException {

	public static void testSubmitReport() throws IOException, URISyntaxException {
//		SubmissionUtil.submitReport(
//			"http://localhost:8080/svc/submission/ojk/submit", 
//			UserPassword.builder().userId("ojk1").password("123456").build(), 
//			"0101", 
//			"008", 
//			"0101.008.20160601180200502"
//		);
	}

	public static void testCekSignature() throws FileNotFoundException, IOException{
//		try (InputStream inputStream = new FileInputStream("C:/slik-client/pelaporan/selesai/0101.008.20160531171531440/siap-kirim/0101.008.20160531171531440.signature")){
//			
//			Tupple3<Boolean, String, Map<String, String>> result = SubmissionUtil.cekSignature(
//				"http://localhost:8080/svc/submission/checkSignature", 
//				UserPassword.builder().userId("ojk1").password("123456").build(), 
//				inputStream
//			);	
//			System.out.println("result = " + result);
//		}
	}
	
	public static void testCekSignature2() throws FileNotFoundException, IOException, URISyntaxException{
//		try (InputStream inputStream = new FileInputStream("C:/slik-client/pelaporan/selesai/0101.008.20160601160709225/terkirim/0101.008.20160601160709225.signature")){
//			
//			Tupple3<Boolean, String, Map<String, String>> result = SubmissionUtil.cekSignature(
//				"http://localhost:8080/svc/submission/ojk/checkSignature", 
//				UserPassword.builder().userId("ojk1").password("123456").build(),
//				"0101",
//				"008",
//				inputStream
//			);	
//			System.out.println("result = " + result);
//		}
	}

	
}
