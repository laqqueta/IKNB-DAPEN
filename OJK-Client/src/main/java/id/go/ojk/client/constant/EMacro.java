package id.go.ojk.client.constant;

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EMacro {
	EQUALS ("\\EQ", "="),
	;
	
	@Getter
	private String macro;
	@Getter
	private String replacement;
	
	public static String[] getArrMacro() {
		List<String> res = new ArrayList<>();
		for (EMacro eEnum : EMacro.values()) {
			res.add(eEnum.macro);
		}
		return res.toArray(new String[res.size()]);
	}
	
	public static String[] getArrReplacement() {
		List<String> res = new ArrayList<>();
		for (EMacro eEnum : EMacro.values()) {
			res.add(eEnum.replacement);
		}
		return res.toArray(new String[res.size()]);
	}
}
