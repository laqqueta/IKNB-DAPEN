package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1106StatusPerusahaanPembiayaanInfrastruktur implements IObject<KeyValueString> {
	R_1 ("EN:e4", "Terbuka"),
	R_2 ("EN:e5", "Tertutup"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1106StatusPerusahaanPembiayaanInfrastruktur eEnum : ER1106StatusPerusahaanPembiayaanInfrastruktur.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1106StatusPerusahaanPembiayaanInfrastruktur.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1106StatusPerusahaanPembiayaanInfrastruktur.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1106StatusPerusahaanPembiayaanInfrastruktur[] eEnums = ER1106StatusPerusahaanPembiayaanInfrastruktur.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1106StatusPerusahaanPembiayaanInfrastruktur eEnum = ER1106StatusPerusahaanPembiayaanInfrastruktur.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
