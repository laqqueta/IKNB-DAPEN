package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1068JenisDana implements IObject<KeyValueString> {
	R_1801 ("1801", "Dana Perusahaan"),
	R_1802 ("1802", "Dana Tabarru'"),
	R_1803 ("1803", "Dana Tanahud"),
	R_1804 ("1804", "Dana Investasi Peserta-Wakalah"),
	R_1805 ("1805", "Dana Investasi Peserta-Mudharabah"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1068JenisDana eEnum : ER1068JenisDana.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1068JenisDana.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1068JenisDana.class.getSimpleName().substring(2, 6));
	}
}
