package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1174JenisAsuransi implements IObject<KeyValueString> {
	R_1 ("JR:e01","Asuransi Atas Risiko Kegagalan Ekspor"),
	R_2 ("JR:e02","Asuransi Atas Risiko Kegagalan Bayar"),
	R_3 ("JR:e03","Asuransi Atas Investasi Yang Dilakukan Oleh Perusahaan Indonesia Di Luar Negeri"),
	R_4 ("JR:e04","Asuransi Atas Risiko Politik Di Suatu Negara Yang Menjadi Tujuan Ekspor"),
	;

	private String key;
	private String value;

	public String getKey() {
		return key;
	}

	@Override
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1174JenisAsuransi eEnum : ER1174JenisAsuransi.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER1174JenisAsuransi.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER1174JenisAsuransi.class.getSimpleName().substring(2, 6));
	}

	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1174JenisAsuransi[] eEnums = ER1174JenisAsuransi.values();
		int enumLength = eEnums.length;
		for (int i = 0; i < enumLength; i++) {
			ER1174JenisAsuransi eEnum = ER1174JenisAsuransi.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
