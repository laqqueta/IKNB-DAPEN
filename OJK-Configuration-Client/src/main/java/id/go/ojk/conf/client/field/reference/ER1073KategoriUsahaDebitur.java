package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1073KategoriUsahaDebitur implements IObject<KeyValueString> {
	R_2201 ("2201", "Usaha Besar"),
	R_2202 ("2202", "Usaha Menengah"),
	R_2203 ("2203", "Usaha Kecil"),
	R_2204 ("2204", "Usaha Mikro"),
	R_2205 ("2205", "Kategori Lainnya"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1073KategoriUsahaDebitur eEnum : ER1073KategoriUsahaDebitur.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1073KategoriUsahaDebitur.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1073KategoriUsahaDebitur.class.getSimpleName().substring(2, 6));
	}
}
