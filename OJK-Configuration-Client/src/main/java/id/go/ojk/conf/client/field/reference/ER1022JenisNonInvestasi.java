package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1022JenisNonInvestasi implements IObject<KeyValueString> {
	R_101 ("101", "Kas dan bank"),
	R_102 ("102", "Tagihan PPL"),
	R_103 ("103", "Premi Reasuransi"),
	R_104 ("104", "Aset Reasuransi"),
	R_105 ("105", "Tagihan klaim koasuransi"),
	R_106 ("106", "Tagihan klaim reasuransi"),
	R_107 ("107", "Tagihan Investasi"),
	R_108 ("108", "Tagihan Hasil Investasi"),
	R_109 ("109", "Properti dipakai sendiri"),
	R_110 ("110", "DAC"),
	R_111 ("111", "Aset Tetap Lain"),
	R_112 ("112", "Aset Lain"),
	;

	private String key;
	private String value;

	public String getKey() {
		return key;
	}
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1022JenisNonInvestasi eEnum : ER1022JenisNonInvestasi.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1022JenisNonInvestasi.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1022JenisNonInvestasi.class.getSimpleName().substring(2, 6));
	}
}
