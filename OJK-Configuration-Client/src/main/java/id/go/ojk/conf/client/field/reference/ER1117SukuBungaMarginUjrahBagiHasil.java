package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1117SukuBungaMarginUjrahBagiHasil implements IObject<KeyValueString> {
	R_1 ("JK:e11", "floating interest rate"),
	R_2 ("JK:e12", "fix interest rate"),
	R_3 ("JK:e49", "margin"),
	R_4 ("JK:e51", "Ujrah"),
	R_5 ("JK:e50", "nisbah bagi hasil"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1117SukuBungaMarginUjrahBagiHasil eEnum : ER1117SukuBungaMarginUjrahBagiHasil.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1117SukuBungaMarginUjrahBagiHasil.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1117SukuBungaMarginUjrahBagiHasil.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1117SukuBungaMarginUjrahBagiHasil[] eEnums = ER1117SukuBungaMarginUjrahBagiHasil.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1117SukuBungaMarginUjrahBagiHasil eEnum = ER1117SukuBungaMarginUjrahBagiHasil.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
