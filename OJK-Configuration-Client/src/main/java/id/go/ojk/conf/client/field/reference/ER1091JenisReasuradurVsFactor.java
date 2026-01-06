package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1091JenisReasuradurVsFactor implements IObject<KeyValueString> {
	R_3101 ("3101", "2.80"),
	R_3102 ("3102", "2.80"),
	R_3103 ("3103", "4.00"),
	R_3104 ("3104", "6.00"),
	R_3105 ("3105", "12.00"),
	R_3106 ("3106", "15.00"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1091JenisReasuradurVsFactor eEnum : ER1091JenisReasuradurVsFactor.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1091JenisReasuradurVsFactor.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1091JenisReasuradurVsFactor.class.getSimpleName().substring(2, 6));
	}
}
