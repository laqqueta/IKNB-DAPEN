package id.go.ojk.lib.client.constant;

import org.apache.commons.lang3.StringUtils;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ESymbolMap {
	EQ("=", "#61;"),
	AMP("&", "#38;")
	;
	
	@Getter
	private String source;
	@Getter
	private String mapped;
	
	public static String encode(String str) {
		for (ESymbolMap eEnum : ESymbolMap.values()) {
			str = StringUtils.replace(str, eEnum.source, eEnum.mapped);
		}
		return str;
	}
	
	public static String decode(String str) {
		for (ESymbolMap eEnum : ESymbolMap.values()) {
			str = StringUtils.replace(str, eEnum.mapped, eEnum.source);
		}
		return str;
	}
}
