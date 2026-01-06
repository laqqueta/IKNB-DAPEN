package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1148JenisAkadSuratBerhargaYangDiterbitkan implements IObject<KeyValueString> {
	R_1 ("JK:e31", "Mudharabah"),
	R_2 ("JK:e37", "Ijarah"),
	R_3 ("JK:e32", "Musyarakah"),
	R_4 ("JK:e33", "Mudharabah Musytarakah"),
	R_5 ("JK:e46", "Qardh"),
	R_6 ("JK:e48", "Akad Lainnya Berdasarkan Prinsip Syariah"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1148JenisAkadSuratBerhargaYangDiterbitkan eEnum : ER1148JenisAkadSuratBerhargaYangDiterbitkan.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1148JenisAkadSuratBerhargaYangDiterbitkan.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1148JenisAkadSuratBerhargaYangDiterbitkan.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1148JenisAkadSuratBerhargaYangDiterbitkan[] eEnums = ER1148JenisAkadSuratBerhargaYangDiterbitkan.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1148JenisAkadSuratBerhargaYangDiterbitkan eEnum = ER1148JenisAkadSuratBerhargaYangDiterbitkan.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
