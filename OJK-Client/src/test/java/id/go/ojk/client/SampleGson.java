package id.go.ojk.client;

import id.go.ojk.client.dto.DtoLoginResponse;
import id.go.ojk.client.dto.DtoLoginResponseData;
import id.go.ojk.lib.client.util.JsonUtil;

public class SampleGson {

	public static void main(String[] args) {
		try {
			System.out.println("<start>");
			sampleJson();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("<end>");
		}
	}
	
	private static void sampleJson() {
		DtoLoginResponseData dtoData = new DtoLoginResponseData();
		dtoData.setExpirationDate(System.currentTimeMillis());
		dtoData.setToken("token");
		dtoData.setUserName("wdg");
		dtoData.setVersionApplication("1.0.0");
		dtoData.setVersionMetadata("1.0.1");
		dtoData.setVersionReference("1.0.2");
		dtoData.setVersionSetup("1.0.2");
		DtoLoginResponse dto = new DtoLoginResponse();
//		dto.setResponseCode("0000");
		dto.setResponseMessage("succeed");
		dto.setSucceed(true);
		dto.setData(dtoData);
		String json = JsonUtil.toJson(dto, false);
		System.out.println(json);
		System.out.println(">" + JsonUtil.fromJson(json, DtoLoginResponse.class));
	}

}
