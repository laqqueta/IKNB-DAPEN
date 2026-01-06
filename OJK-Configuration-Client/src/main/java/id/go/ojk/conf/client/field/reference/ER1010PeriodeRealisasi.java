package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1010PeriodeRealisasi implements IObject<KeyValueString> {
	R_1 ("1", "Untuk pengisian realisasi rencana bisnis di periode semester pertama"),
	R_2 ("2", "Untuk pengisian realisasi rencana bisnis di periode semester kedua"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1010PeriodeRealisasi eEnum : ER1010PeriodeRealisasi.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1010PeriodeRealisasi.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1010PeriodeRealisasi.class.getSimpleName().substring(2, 6));
	}
}
