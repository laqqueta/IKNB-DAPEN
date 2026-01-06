package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1196JenisPolis implements IObject<KeyValueString> {
	R_100 ("100", "Pertanggungan Kumpulan - Korporasi"),
	R_200 ("200", "Pertanggungan Individu - Perorangan"),
	R_300 ("300", "Pertanggungan Individu - Korporasi"),
	R_400 ("400", "Pertanggungan Kumpulan - Perorangan"),
	R_500 ("500", "Proses Pencabutan/Pengembalian Izin Usaha"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1196JenisPolis eEnum : ER1196JenisPolis.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1196JenisPolis.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1196JenisPolis.class.getSimpleName().substring(2, 6));
	}
}