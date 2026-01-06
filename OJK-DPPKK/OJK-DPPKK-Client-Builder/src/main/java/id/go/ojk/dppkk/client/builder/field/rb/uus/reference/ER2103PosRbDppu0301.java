package id.go.ojk.dppkk.client.builder.field.rb.uus.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2103PosRbDppu0301 implements IObject<KeyValueString> {
	R_0301010000 ("0301010000", "Aset Neto"),
	R_0301020000 ("0301020000", "Investasi"),
	R_0301030000 ("0301030000", "Nilai Kini Aktuarial (Khusus PPMP)"),
//	R_0301040000 ("0301040000", "Iuran:"),
	R_0301040100 ("0301040100", "a.      Iuran Normal Peserta"),
	R_0301040200 ("0301040200", "b.      Iuran Sukarela Peserta"),
	R_0301040300 ("0301040300", "c.      Iuran Normal Pemberi Kerja"),
	R_0301040400 ("0301040400", "d.      Iuran Tambahan"),
	R_0301050000 ("0301050000", "Pembayaran Manfaat Pensiun"),
	R_0301060000 ("0301060000", "Pendapatan Investasi"),
	R_0301070000 ("0301070000", "Beban Investasi "),
	R_0301080000 ("0301080000", "Beban Operasional"),
	R_0301090000 ("0301090000", "Rasio Pendapatan investasi  (ROI)"),
	R_0301100000 ("0301100000", "Rasio Pendapatan investasi terhadap Aset (ROA)"),
	R_0301110000 ("0301110000", "Rasio Beban operasional (BOPO)"),
	R_0301120000 ("0301120000", "Rasio Umur Piutang Iuran (RUPI)"),
	R_0301130000 ("0301130000", "Rasio Pendanaan (khusus PPMP)"),
	R_0301140000 ("0301140000", "Rasio Solvabilitas (khusus PPMP)"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2103PosRbDppu0301 eEnum : ER2103PosRbDppu0301.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2103PosRbDppu0301.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2103PosRbDppu0301.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static SegmentValidation genValidationNumericNegatif() {
		return UtilSegmentValidation.genRegexNumericNegative("2|3",
				UtilMetadata.genPipeRow(getObjects(), 0, 10));
	}

	public static SegmentValidation genValidationNumericDotNegatif() {
		return UtilSegmentValidation.genRegexNumericDotNegative("2|3",
				UtilMetadata.genPipeRow(getObjects(), 11, 16));
	}
	
	public static FieldValidation genValidationRatio() {
		return UtilFieldValidation.genEqualsRatio("3|2");
	}
}
