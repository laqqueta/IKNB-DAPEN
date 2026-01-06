package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1137TujuanPenerimaPinjaman implements IObject<KeyValueString> {
	R_1 ("AK:e15", "Konvensional"),
	R_2 ("AK:e16", "Syariah"),
	R_3 ("AK:e17", "Konvensional dan Syariah"),
	R_4 ("AK:e8", "Unit Usaha Syariah"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1137TujuanPenerimaPinjaman eEnum : ER1137TujuanPenerimaPinjaman.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1137TujuanPenerimaPinjaman.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1137TujuanPenerimaPinjaman.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1137TujuanPenerimaPinjaman[] eEnums = ER1137TujuanPenerimaPinjaman.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1137TujuanPenerimaPinjaman eEnum = ER1137TujuanPenerimaPinjaman.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
