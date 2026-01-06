package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1181JenisPinjaman implements IObject<KeyValueString> {
	R_1 ("SF:e5", "Sindikasi"),
	R_2 ("SF:e6", "Bilateral"),
	R_3 ("SF:e7", "Multilateral"),
	R_4 ("SF:e8", "Subordinasi"),
	;

	private String key;
	private String value;
	
	public String getKey() {
		return key;
	}
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1181JenisPinjaman eEnum : ER1181JenisPinjaman.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1181JenisPinjaman.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1181JenisPinjaman.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1181JenisPinjaman[] eEnums = ER1181JenisPinjaman.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1181JenisPinjaman eEnum = ER1181JenisPinjaman.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
