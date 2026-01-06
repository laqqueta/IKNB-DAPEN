package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1083JenisPenilaian implements IObject<KeyValueString> {
	R_3301 ("3301", "Nilai pasar"),
	R_3302 ("3302", "Nilai Perolehan "),
	R_3303 ("3303", "Nilai Apraisal"),
	R_3304 ("3304", "Nilai Setelah Amortisasi"),
	R_3305 ("3305", "Lainnya"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1083JenisPenilaian eEnum : ER1083JenisPenilaian.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1083JenisPenilaian.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1083JenisPenilaian.class.getSimpleName().substring(2, 6));
	}
}
