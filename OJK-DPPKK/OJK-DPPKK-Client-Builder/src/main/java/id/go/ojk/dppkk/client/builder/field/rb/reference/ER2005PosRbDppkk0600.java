package id.go.ojk.dppkk.client.builder.field.rb.reference;

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
public enum ER2005PosRbDppkk0600 implements IObject<KeyValueString> {
//	R_0601000000 ("0601000000", "Rencana Pemenuhan Rasio Pendanaan Khusus PPMP"),
	R_0601010000 ("0601010000", "Kekayaan Untuk Pendanaan"),
	R_0601020000 ("0601020000", "Nilai Kini Aktuaria"),
	R_0601030000 ("0601030000", "Kewajiban Solvabilitas"),
	R_0601040000 ("0601040000", "Surplus / Defisit "),
	R_0601050000 ("0601050000", "Rasio Pendanaan  (%)"),
	R_0601060000 ("0601060000", "Rasio Solvabilitas (%)"),
	R_0601070000 ("0601070000", "Kualitas Pendanaan"),
//	R_0602000000 ("0602000000", "Proyeksi Pendanaan"),
	R_0602010000 ("0602010000", "Iuran Normal Peserta"),
	R_0602020000 ("0602020000", "Iuran Sukarela Peserta"),
	R_0602030000 ("0602030000", "Iuran Normal Pemberi Kerja"),
	R_0602040000 ("0602040000", "Iuran Tambahan Pemberi Kerja"),
	R_0602050000 ("0602050000", "Total Dana Iuran"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2005PosRbDppkk0600 eEnum : ER2005PosRbDppkk0600.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2005PosRbDppkk0600.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2005PosRbDppkk0600.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}

	public static SegmentValidation genValidationNumericNegatif() {
		return UtilSegmentValidation.genRegexNumericNegative("2|3|4|5",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 1, 2, 3, 6, 7, 8, 9, 10, 11 }));
	}

	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumeric("2|3|4|5", R_0601070000.key);
	}

	public static SegmentValidation genValidationNumericDotNegatif() {
		return UtilSegmentValidation.genRegexNumericDotNegative("2|3|4|5", R_0601050000.key + "|" + R_0601060000.key);
	}

	public static SegmentValidation genValidationSurplus() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_0601040000.key,
				R_0601010000.key + "-" + R_0601020000.key,
				"Total Surplus/Defisit|Penjumlahan Surplus/Defisit");
	}

	public static SegmentValidation genValidationDanaIuran() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_0602050000.key,
				UtilMetadata.genPlusRow(getObjects(), 7, 10),
				"Total Dana Iuran|Penjumlahan Dana Iuran");
	}
	
	public static SegmentValidation genValidationKualitasPendanaan() {
		return UtilSegmentValidation.genFixedValue("2|3|4|5", R_0601070000.key, "1|2|3");
	}
}
