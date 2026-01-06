package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1085LiniUsahaAsuransiJiwa implements IObject<KeyValueString> {
	R_1001 ("1001", "Ekawarsa "),
	R_1002 ("1002", "Kematian Berjangka Selain Ekawarsa"),
	R_1003 ("1003", "Dwiguna"),
	R_1004 ("1004", "Dwiguna Kombinasi"),
	R_1005 ("1005", "Seumur Hidup"),
	R_1006 ("1006", "Seumur Hidup Kombinasi"),
	R_1007 ("1007", "Anuitas Umum"),
	R_1008 ("1008", "Anuitas Dana Pensiun"),
	R_1009 ("1009", "Kecelakaan Diri"),
	R_1010 ("1010", "Kesehatan"),
	R_1011 ("1011", "Produk Lain"),
	R_1012 ("1012", "PAYDI"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1085LiniUsahaAsuransiJiwa eEnum : ER1085LiniUsahaAsuransiJiwa.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1085LiniUsahaAsuransiJiwa.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1085LiniUsahaAsuransiJiwa.class.getSimpleName().substring(2, 6));
	}
}
