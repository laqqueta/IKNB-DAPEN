package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1119Kualitas implements IObject<KeyValueString> {
	R_1 ("SF:e21", "Lancar"),
	R_2 ("SF:e121", "Dalam Perhatian Khusus"),
	R_3 ("SF:e91", "Kurang Lancar"),
	R_4 ("SF:e31", "Diragukan"),
	R_5 ("SF:e41", "Macet"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1119Kualitas eEnum : ER1119Kualitas.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1119Kualitas.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1119Kualitas.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1119Kualitas[] eEnums = ER1119Kualitas.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1119Kualitas eEnum = ER1119Kualitas.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
