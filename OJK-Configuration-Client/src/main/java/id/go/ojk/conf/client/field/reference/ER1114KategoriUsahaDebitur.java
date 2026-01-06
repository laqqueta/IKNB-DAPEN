package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1114KategoriUsahaDebitur implements IObject<KeyValueString> {
	R_1 ("EN:e16", "Usaha Besar"),
	R_2 ("EN:e17", "Usaha Mikro"),
	R_3 ("EN:e18", "Usaha Kecil"),
	R_4 ("EN:e19", "Usaha Menengah"),
	R_5 ("EN:e20", "Kategori Lainnya / Non Produktif"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1114KategoriUsahaDebitur eEnum : ER1114KategoriUsahaDebitur.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1114KategoriUsahaDebitur.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1114KategoriUsahaDebitur.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1114KategoriUsahaDebitur[] eEnums = ER1114KategoriUsahaDebitur.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1114KategoriUsahaDebitur eEnum = ER1114KategoriUsahaDebitur.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
