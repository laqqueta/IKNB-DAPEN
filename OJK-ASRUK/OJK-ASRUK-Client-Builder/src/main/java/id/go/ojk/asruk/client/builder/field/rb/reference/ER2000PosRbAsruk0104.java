package id.go.ojk.asruk.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2000PosRbAsruk0104 implements IObject<KeyValueString> {
	R_1000000000 ("1000000000", "1.Aset"),
	R_1400000000 ("1400000000", "2.Investasi"),
	R_2400000000 ("2400000000", "3.Utang"),
	R_2500000000 ("2500000000", "4.Cadangan Teknis"),
	R_3000000000 ("3000000000", "5.Ekuitas"),
	R_4101000000 ("4101000000", "6.Premi Bruto"),
	R_5401010000 ("5401010000", "7.Klaim Bruto"),
	R_0104080000 ("0104080000", "8.Beban Akuisisi"),
	R_5700000000 ("5700000000", "9.Beban Operasional"),
	R_5500000000 ("5500000000", "10.Hasil Underwriting"),
	R_5803000000 ("5803000000", "11.Laba (Rugi) Sebelum Pajak"),
	R_5805000000 ("5805000000", "12.Laba (Rugi) Setelah Pajak"),
	R_5800000000 ("5800000000", "13.Laba (Rugi) Komprehensif"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2000PosRbAsruk0104 eEnum : ER2000PosRbAsruk0104.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2000PosRbAsruk0104.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2000PosRbAsruk0104.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
}
