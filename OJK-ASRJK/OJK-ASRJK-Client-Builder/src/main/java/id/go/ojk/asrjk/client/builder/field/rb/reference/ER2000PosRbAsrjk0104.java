package id.go.ojk.asrjk.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2000PosRbAsrjk0104 implements IObject<KeyValueString> {
	R_1000000000 ("1000000000", "Aset"),
	R_1400000000 ("1400000000", "Investasi"),
	R_2400000000 ("2400000000", "Utang"),
	R_2500000000 ("2500000000", "Cadangan Teknis"),
	R_3000000000 ("3000000000", "Ekuitas"),
	R_4401000000 ("4401000000", "Premi Bruto"),
	R_0104070000 ("0104070000", "Klaim Bruto"),
	R_5402000000 ("5402000000", "Beban Akuisisi"),
	R_5500000000 ("5500000000", "Beban Operasional"),
	R_0104100000 ("0104100000", "Hasil Underwriting"),
	R_3403010000 ("3403010000", "Laba (Rugi) Sebelum Pajak"),
	R_3403020000 ("3403020000", "Laba (Rugi) Setelah Pajak"),
	R_3403040000 ("3403040000", "Laba (Rugi) Komprehensif"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2000PosRbAsrjk0104 eEnum : ER2000PosRbAsrjk0104.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2000PosRbAsrjk0104.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2000PosRbAsrjk0104.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
}
