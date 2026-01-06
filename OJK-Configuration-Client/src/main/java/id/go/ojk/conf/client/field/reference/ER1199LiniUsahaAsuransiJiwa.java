package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1199LiniUsahaAsuransiJiwa implements IObject<KeyValueString> {
	R_1020 ("1020", "Ekawarsa "),
	R_1021 ("1021", "Kematian Berjangka"),
	R_1022 ("1022", "Dwiguna"),
	R_1023 ("1023", "Dwiguna Kombinasi"),
	R_1024 ("1024", "Seumur Hidup"),
	R_1025 ("1025", "Seumur Hidup Kombinasi"),
	R_1026 ("1026", "Anuitas Umum"),
	R_1027 ("1027", "Anuitas Dana Pensiun"),
	R_1028 ("1028", "Kecelakaan Diri"),
	R_1029 ("1029", "Kesehatan"),
	R_1030 ("1030", "Asuransi Jiwa Kredit"),
	R_1099 ("1099", "PAYDI"),
	R_9999 ("9999", "Lainnya"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1199LiniUsahaAsuransiJiwa eEnum : ER1199LiniUsahaAsuransiJiwa.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1199LiniUsahaAsuransiJiwa.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1199LiniUsahaAsuransiJiwa.class.getSimpleName().substring(2, 6));
	}
}