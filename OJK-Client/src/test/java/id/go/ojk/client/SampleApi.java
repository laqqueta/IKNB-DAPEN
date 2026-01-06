package id.go.ojk.client;

import id.go.ojk.client.api.ApiAbsensi;
import id.go.ojk.client.api.ApiCheckUpload;
import id.go.ojk.client.api.ApiInitUpload;
import id.go.ojk.client.api.ApiLogin;
import id.go.ojk.client.api.ApiPrivateKey;
import id.go.ojk.client.api.ApiRefreshToken;
import id.go.ojk.client.api.ApiUpload;
import id.go.ojk.client.dto.DtoAbsensiRequest;
import id.go.ojk.client.dto.DtoAbsensiResponse;
import id.go.ojk.client.dto.DtoCheckUploadRequest;
import id.go.ojk.client.dto.DtoCheckUploadResponse;
import id.go.ojk.client.dto.DtoInitUploadRequest;
import id.go.ojk.client.dto.DtoInitUploadResponse;
import id.go.ojk.client.dto.DtoLoginRequest;
import id.go.ojk.client.dto.DtoLoginResponse;
import id.go.ojk.client.dto.DtoPrivateKeyRequest;
import id.go.ojk.client.dto.DtoPrivateKeyResponse;
import id.go.ojk.client.dto.DtoRefreshTokenRequest;
import id.go.ojk.client.dto.DtoRefreshTokenResponse;
import id.go.ojk.client.dto.DtoUploadRequest;
import id.go.ojk.client.dto.DtoUploadResponse;

public class SampleApi {
	
	public static void main(String[] args) {
		try {
			System.out.println("<end>");
			login();
//			absensi();
//			upload();
//			getPrivateKey();
//			checkUpload();
//			initUpload();
//			refreshToken();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("<end>");
		}
	}
	
	private static void login() {
		ApiLogin api = new ApiLogin();
		DtoLoginRequest dtoRequest = new DtoLoginRequest();
		dtoRequest.setMemberCode("1234");
		dtoRequest.setMemberTypeCode("01");
		dtoRequest.setPassword("dev_asuransi_jiwa@outlook.com");
		dtoRequest.setUserId("dev_asuransi_jiwa@outlook.com");
		dtoRequest.setUserTypeFlag("O");
		DtoLoginResponse dtoResponse = api.sendReceive(dtoRequest);
		System.out.println(dtoResponse);
	}
	
	private static void absensi() {
		ApiAbsensi api = new ApiAbsensi();
		DtoAbsensiRequest dtoRequest = new DtoAbsensiRequest();
		dtoRequest.setFullEntityCode("031204-2000000041");
		dtoRequest.setJenisKoreksi("-1");
		dtoRequest.setPeriodCode("M");
		dtoRequest.setPeriodDate("2024-12-31");
		dtoRequest.setReportCode("PLSAJS");
		dtoRequest.setReportFormGroupCode("PLSASRJS");
		dtoRequest.setRutinFlag("R");
		dtoRequest.setUserName("dylanwijaya7@gmail.com");
//		dtoRequest.setUsername("devojk\\admin.apolo");
		DtoAbsensiResponse dtoResponse = api.sendReceive(dtoRequest);
		System.out.println(dtoResponse);
	}
	
	private static void checkUpload() {
		ApiCheckUpload api = new ApiCheckUpload();
		DtoCheckUploadRequest dtoRequest = new DtoCheckUploadRequest();
		dtoRequest.setAntrianId(36);
		dtoRequest.setSummaryId(12074);
		dtoRequest.setUserName("devojk\\admin.apolo");
		dtoRequest.setSignature("e0XenDGrG1zDeaRbl7lBcnkRCmXJWcagywV/M2JpgPXkmk456n/q/Y=mlScUExWTxyE");
//		dtoRequest.setUserName("devojk\\admin.apolo");
		DtoCheckUploadResponse dtoResponse = api.sendReceive(dtoRequest);
		System.out.println(dtoResponse);
	}
	
	private static void initUpload() {
		ApiInitUpload api = new ApiInitUpload();
		DtoInitUploadRequest dtoRequest = new DtoInitUploadRequest();
		dtoRequest.setAntrianId(36);
		dtoRequest.setSummaryId(12074);
		dtoRequest.setUserName("devojk\\admin.apolo");
		dtoRequest.setFolderPath("D:\\PLSASRJS\\");
		dtoRequest.setTotalFile(2);
		dtoRequest.setTotalFileSize(1000);
		dtoRequest.setSignature("fafsdf");
		DtoInitUploadResponse dtoResponse = api.sendReceive(dtoRequest);
		System.out.println(dtoResponse);
	}
	
	private static void upload() {
		ApiUpload api = new ApiUpload();
		DtoUploadRequest dtoRequest = new DtoUploadRequest();
		dtoRequest.setAntrianId(36);
		dtoRequest.setSummaryId(12074);
		dtoRequest.setUserName("devojk\\admin.apolo");
		dtoRequest.setFileName("D:\\PLSASRJS-R-M-20241231-2000000041-02.zip.part0");
//		dtoRequest.setUserName("devojk\\admin.apolo");
		DtoUploadResponse dtoResponse = api.sendReceive(dtoRequest);
		System.out.println(dtoResponse);
	}
	
	private static void refreshToken() {
		ApiRefreshToken api = new ApiRefreshToken();
		DtoRefreshTokenRequest dtoRequest = new DtoRefreshTokenRequest();
		dtoRequest.setUserId("dylanwijaya7@gmail.com");
		DtoRefreshTokenResponse dtoResponse = api.sendReceive(dtoRequest);
		System.out.println(dtoResponse);
	}
	
	private static void getPrivateKey() {
		ApiPrivateKey api = new ApiPrivateKey();
		DtoPrivateKeyRequest dtoRequest = new DtoPrivateKeyRequest();
		dtoRequest.setMemberCode("2000000041");
		DtoPrivateKeyResponse dtoResponse = api.sendReceive(dtoRequest);
		System.out.println(dtoResponse);
	}
}
