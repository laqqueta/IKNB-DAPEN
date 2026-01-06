package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1081Kolektibilitas implements IObject<KeyValueString> {
	R_3401 ("3401", "Lancar"),
	R_3402 ("3402", "Dalam Perhatian Khusus"),
	R_3403 ("3403", "Kurang Lancar"),
	R_3404 ("3404", "Diragukan"),
	R_3405 ("3405", "Macet"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1081Kolektibilitas eEnum : ER1081Kolektibilitas.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1081Kolektibilitas.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1081Kolektibilitas.class.getSimpleName().substring(2, 6));
	}
}
