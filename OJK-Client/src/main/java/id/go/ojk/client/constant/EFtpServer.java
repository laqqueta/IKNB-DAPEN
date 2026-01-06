package id.go.ojk.client.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFtpServer {
	FTP01,
	FTP02,
	FTP_ENTITY,
	FTP_ENTITY2,
	;
	
	public static EFtpServer getEnum(String str) {
		EFtpServer res = null;
		try {
			res = EFtpServer.valueOf(str);
		} catch (Exception e) {
		}
		return res;
	}
}
