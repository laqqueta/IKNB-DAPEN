package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1145JenisBagiHasil implements IObject<KeyValueString> {
	R_1 ("JK:e49", "Margin"),
	R_2 ("JK:e50", "Bagi Hasil"),
	R_3 ("JK:e51", "Imbal Jasa"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1145JenisBagiHasil eEnum : ER1145JenisBagiHasil.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1145JenisBagiHasil.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1145JenisBagiHasil.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1145JenisBagiHasil[] eEnums = ER1145JenisBagiHasil.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1145JenisBagiHasil eEnum = ER1145JenisBagiHasil.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
