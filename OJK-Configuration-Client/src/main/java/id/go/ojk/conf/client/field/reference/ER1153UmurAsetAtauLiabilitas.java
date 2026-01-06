package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1153UmurAsetAtauLiabilitas implements IObject<KeyValueString> {
	R_1 ("JW:e14", "Umur aset atau liabilitas di bawah 1 (satu) tahun (<1 tahun);"),
	R_2 ("JW:e15", "Umur aset atau liabilitas 1 (satu) sampai dengan 3 (tiga) tahun (1-3 tahun);"),
	R_3 ("JW:e16", "Umur aset atau liabilitas 3 (tiga) sampai dengan 5 (lima) tahun (3-5 tahun); atau"),
	R_4 ("JW:e17", "Umur aset atau liabilitas lebih dari 5 (lima) tahun (>5 tahun)."),
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
		for (ER1153UmurAsetAtauLiabilitas eEnum : ER1153UmurAsetAtauLiabilitas.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1153UmurAsetAtauLiabilitas.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1153UmurAsetAtauLiabilitas.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1153UmurAsetAtauLiabilitas[] eEnums = ER1153UmurAsetAtauLiabilitas.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1153UmurAsetAtauLiabilitas eEnum = ER1153UmurAsetAtauLiabilitas.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
