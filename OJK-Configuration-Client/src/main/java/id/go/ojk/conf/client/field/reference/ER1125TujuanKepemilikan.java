package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1125TujuanKepemilikan implements IObject<KeyValueString> {
	R_1 ("TJ:e1", "Dimiliki Hingga Jatuh Tempo (Held to Maturity / HTM)"),
	R_2 ("TJ:e2", "Diperdagangkan (Held for trading / Trading)"),
	R_3 ("TJ:e3", "Tersedia Untuk Dijual (Available for Sale / AFS)"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1125TujuanKepemilikan eEnum : ER1125TujuanKepemilikan.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1125TujuanKepemilikan.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1125TujuanKepemilikan.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1125TujuanKepemilikan[] eEnums = ER1125TujuanKepemilikan.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1125TujuanKepemilikan eEnum = ER1125TujuanKepemilikan.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
