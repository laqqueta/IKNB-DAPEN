package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1184StatusLegalitas implements IObject<KeyValueString> {
	R_1 ("BJ:e133", "Sertifikat Hak Milik (SHM)"),
	R_2 ("BJ:e134", "Sertifikat Hak Guna Usaha (HGU)"),
	R_3 ("BJ:e135", "Sertifikat Hak Pakai"),
	R_4 ("BJ:e136", "Sertifikat Hak Guna Bangunan (SHGB)"),
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
		for (ER1184StatusLegalitas eEnum : ER1184StatusLegalitas.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1184StatusLegalitas.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1184StatusLegalitas.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1184StatusLegalitas[] eEnums = ER1184StatusLegalitas.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1184StatusLegalitas eEnum = ER1184StatusLegalitas.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
