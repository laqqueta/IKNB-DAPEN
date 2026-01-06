package id.go.ojk.client.constant;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ESectorType {
	KONVENSIONAL (ClientConstant.KONVENSIONAL, "Konvensional"),
	SYARIAH (ClientConstant.SYARIAH, "Syariah"),
	UUS (ClientConstant.UUS, "Unit Usaha Syariah"),
	;
	
	@Getter
	private String code;
	@Getter
	private String name;
	
	public static ESectorType getEnumByCode(String code) {
		ESectorType res = null;
		for (ESectorType eEnum : ESectorType.values()) {
			if (eEnum.getCode().equals(code)) {
				res = eEnum;
				break;
			}
		}
		return res;
	}
}
