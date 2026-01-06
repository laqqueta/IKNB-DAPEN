package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1150JenisPinjamanSyariah implements IObject<KeyValueString> {
	R_1 ("SF:e5", "Sindikasi"),
	R_2 ("SF:e6", "Bilateral"),
	R_3 ("SF:e7", "Multilateral"),
	R_4 ("SF:e8", "Subordinasi"),
	R_5 ("SF:e9", "Dana Syirkah Temporer"),
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
		for (ER1150JenisPinjamanSyariah eEnum : ER1150JenisPinjamanSyariah.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1150JenisPinjamanSyariah.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1150JenisPinjamanSyariah.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1150JenisPinjamanSyariah[] eEnums = ER1150JenisPinjamanSyariah.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1150JenisPinjamanSyariah eEnum = ER1150JenisPinjamanSyariah.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
