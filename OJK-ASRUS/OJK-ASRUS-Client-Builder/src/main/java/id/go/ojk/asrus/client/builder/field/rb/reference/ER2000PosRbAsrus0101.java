package id.go.ojk.asrus.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2000PosRbAsrus0101 implements IObject<KeyValueString> {
	R_0101010000 ("0101010000", "Aset"),
	R_0101020000 ("0101020000", "Investasi"),
	R_0101030000 ("0101030000", "Liabilitas"),
	R_0101040000 ("0101040000", "Penyisihan Teknis"),
	R_0101050000 ("0101050000", "Qardh"),
	R_0101060000 ("0101060000", "Ekuitas"),
	R_0101070000 ("0101070000", "Ujroh atas kontribusi"),
	R_0101080000 ("0101080000", "Beban Pemasaran"),
	R_0101090000 ("0101090000", "Beban Akuisisi"),
	R_0101100000 ("0101100000", "Beban Umum dan Administrasi"),
	R_0101110000 ("0101110000", "Beban Pemasaran"),
	R_0101120000 ("0101120000", "Hasil Investasi"),
	R_0101130000 ("0101130000", "Laba (Rugi) Sebelum Pajak"),
	R_0101140000 ("0101140000", "Laba (Rugi) Setelah Pajak"),
	R_0101150000 ("0101150000", "Pendapatan Komprehensif Lain"),
	;
	
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2000PosRbAsrus0101 eEnum : ER2000PosRbAsrus0101.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2000PosRbAsrus0101.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2000PosRbAsrus0101.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
}
