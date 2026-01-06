package id.go.ojk.dplkk.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2005PosRbDplkk0600 implements IObject<KeyValueString> {
//	R_0601000000 ("0601000000", "Proyeksi Pendanaan"),
	R_0601010000 ("0601010000", "Iuran Pemberi Kerja"),
	R_0601020000 ("0601020000", "Iuran Peserta"),
	R_0601030000 ("0601030000", "Total Dana Iuran"),
//	R_0602000000 ("0602000000", "Proyeksi Jumlah Peserta "),
	R_0602010000 ("0602010000", "Peserta PPIP"),
	R_0602020000 ("0602020000", "Peserta Manfaat Lain"),
	R_0602030000 ("0602030000", "Total Peserta"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2005PosRbDplkk0600 eEnum : ER2005PosRbDplkk0600.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2005PosRbDplkk0600.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2005PosRbDplkk0600.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}

	public static SegmentValidation genValidationDanaIuran() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_0601030000.key,
				R_0601010000.key + "+" + R_0601020000.key,
				"Total Dana Iuran|Penjumlahan Proyeksi Pendanaan");
	}

	public static SegmentValidation genValidationPeserta() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_0602030000.key,
				R_0602010000.key + "+" + R_0602020000.key,
				"Total Peserta|Penjumlahan Proyeksi Jumlah Peserta");
	}
}
