package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1064JenisReasuradur implements IObject<KeyValueString> {
	R_3101 ("3101", "Reasuransi Dalam Negeri"),
	R_3102 ("3102", "Reasuransi Luar Negeri Klaster 1"),
	R_3103 ("3103", "Reasuransi Luar Negeri Klaster 2"),
	R_3104 ("3104", "Reasuransi Luar Negeri Klaster 3"),
	R_3105 ("3105", "Reasuransi Luar Negeri Klaster 4"),
	R_3106 ("3106", "Reasuransi Luar Negeri Klaster 5"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1064JenisReasuradur eEnum : ER1064JenisReasuradur.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1064JenisReasuradur.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1064JenisReasuradur.class.getSimpleName().substring(2, 6));
	}
}
