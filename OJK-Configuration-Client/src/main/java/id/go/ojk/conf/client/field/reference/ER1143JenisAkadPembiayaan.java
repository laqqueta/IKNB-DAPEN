package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1143JenisAkadPembiayaan implements IObject<KeyValueString> {
	R_1 ("JK:e26", "Akad Murabahah"),
	R_2 ("JK:e31", "Akad Mudharabah"),
	R_3 ("JK:e32", "Akad Musyarakah"),
	R_4 ("JK:e33", "Akad Mudharabah Musytarakah"),
	R_5 ("JK:e34", "Akad Musyarakah Mutanaqisah"),
	R_6 ("JK:e37", "Akad Ijarah/IMBT"),
	R_7 ("JK:e46", "Akad Qardh"),
	R_8 ("JK:e48", "Akad Lainnya Berdasarkan Prinsip Syariah"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1143JenisAkadPembiayaan eEnum : ER1143JenisAkadPembiayaan.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1143JenisAkadPembiayaan.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1143JenisAkadPembiayaan.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1143JenisAkadPembiayaan[] eEnums = ER1143JenisAkadPembiayaan.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1143JenisAkadPembiayaan eEnum = ER1143JenisAkadPembiayaan.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
