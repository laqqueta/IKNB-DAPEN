package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1092LiniUsaha implements IObject<KeyValueString> {
	R_1101 ("1101", "Harta Benda"),
	R_1102 ("1102", "Kendaraan Bermotor"),
	R_1103 ("1103", "Pengangkutan"),
	R_1104 ("1104", "Rangka Kapal (Marine Hull)"),
	R_1105 ("1105", "Rangka Pesawat (Aviation Hull)"),
	R_1106 ("1106", "Satelit"),
	R_1107 ("1107", "Energi Onshore (Oil and Gas)"),
	R_1108 ("1108", "Energi Offshore (Oil and Gas)"),
	R_1109 ("1109", "Rekayasa (Engineering)"),
	R_1110 ("1110", "Tanggung Gugat (Liability)"),
	R_1111 ("1111", "Kredit (Credit) "),
	R_1112 ("1112", "Aneka"),
	R_1113 ("1113", "Kesehatan"),
	R_1114 ("1114", "Kecelakaan Diri"),
	R_1115 ("1115", "Suretyship"),
	R_1120 ("1120", "Lainnya"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1092LiniUsaha eEnum : ER1092LiniUsaha.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1092LiniUsaha.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1092LiniUsaha.class.getSimpleName().substring(2, 6));
	}
}
