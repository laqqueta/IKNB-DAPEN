package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1084JenisUtang implements IObject<KeyValueString> {
	R_2701 ("2701", "Utang Komisi"),
	R_2702 ("2702", "Utang Ujroh Reasuransi"),
	R_2703 ("2703", "Utang Klaim"),
	R_2704 ("2704", "Utang Reasuransi"),
	R_2705 ("2705", "Utang Ujroh kepada Perusahaan-Dana Tabaru"),
	R_2706 ("2706", "Utang Ujroh kepada Perusahaan-DIP"),
	R_2707 ("2707", "Utang Bagi Hasil"),
	R_2708 ("2708", "Utang Penarikan Dana Investasi-DIP-Akad Wakalah Bil Ujrah"),
	R_2709 ("2709", "Utang Penarikan Dana Investasi-DIP-Akad Mudharabah"),
	R_2710 ("2710", "Utang Komisi"),
	R_2711 ("2711", "Utang Ujrah Reasuransi"),
	R_2712 ("2712", "Utang Pajak"),
	R_2713 ("2713", "Utang Zakat"),
	R_2714 ("2714", "Utang Ujroh/Fee Pengelolaan Dana"),
	R_2715 ("2715", "Utang Bagi Hasil"),
	R_2716 ("2716", "Utang Penarikan Dana Investasi  "),
	R_2717 ("2717", "Utang Lain"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1084JenisUtang eEnum : ER1084JenisUtang.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1084JenisUtang.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1084JenisUtang.class.getSimpleName().substring(2, 6));
	}
}
