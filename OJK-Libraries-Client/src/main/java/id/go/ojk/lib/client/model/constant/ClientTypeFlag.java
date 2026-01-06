package id.go.ojk.lib.client.model.constant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum ClientTypeFlag {
	I("Internal"),
	E("Member");

	private String description;
	private ClientTypeFlag(String description){
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
	public String createDescription(String memberTypeCode, String memberCode){
		return this.equals(ClientTypeFlag.I) ? "OJK" : memberTypeCode + "." + memberCode;
	}

	public static List<String> getValueList(){
		return Arrays.asList(ClientTypeFlag.values()).stream().map( e -> e.name()).collect(Collectors.toList());
	}
	
	public static boolean isInternalOjk(String param){
		return ClientTypeFlag.I.name().equals(param);
	}
		
	public static String createDescription(String clientTypeFlag, String memberTypeCode, String memberCode){
		return ClientTypeFlag.valueOf(clientTypeFlag).createDescription(memberTypeCode, memberCode);
	}

}
