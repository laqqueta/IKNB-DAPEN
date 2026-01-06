package id.go.ojk.dppkk.client.builder.field.rb.reference;

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
public enum ER2002PosRbDppkk0300 implements IObject<KeyValueString> {
//	R_0301000000 ("0301000000", ""),
	R_0301010000 ("0301010000", "Aset Neto"),
	R_0301020000 ("0301020000", "Investasi"),
	R_0301030000 ("0301030000", "Iuran Normal Peserta"),
	R_0301040000 ("0301040000", "Iuran Sukarela Peserta"),
	R_0301050000 ("0301050000", "Iuran Normal Pemberi Kerja"),
	R_0301060000 ("0301060000", "Iuran Tambahan"),
	R_0301070000 ("0301070000", "Pembayaran Manfaat Pensiun"),
	R_0301080000 ("0301080000", "Pendapatan Investasi"),
	R_0301090000 ("0301090000", "Beban Investasi"),
	R_0301100000 ("0301100000", "Beban Operasional"),
//	R_0302000000 ("0302000000", ""),
	R_0302010000 ("0302010000", "Rasio Pendapatan investasi  (ROI)"),
	R_0302020000 ("0302020000", "Rasio Pendapatan investasi terhadap Aset (ROA)"),
	R_0302030000 ("0302030000", "Rasio beban operasional (BOPO)"),
	R_0302040000 ("0302040000", "Rasio Umur Piutang Iuran (RUPI)"),
	R_0302050000 ("0302050000", "Rasio Pendanaan khusus PPMP"),
	R_0302060000 ("0302060000", "Rasio Solvabilitas khusus PPMP"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2002PosRbDppkk0300 eEnum : ER2002PosRbDppkk0300.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2002PosRbDppkk0300.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2002PosRbDppkk0300.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static SegmentValidation genValidationNumericNegatif() {
		return UtilSegmentValidation.genRegexNumericNegative("2|3",
				UtilMetadata.genPipeRow(getObjects(), 0, 9));
	}

	public static SegmentValidation genValidationNumericDotNegatif() {
		return UtilSegmentValidation.genRegexNumericDotNegative("2|3",
				UtilMetadata.genPipeRow(getObjects(), 10, 15));
	}

	public static SegmentValidation genValidationMaxLengthDecimal() {
		return UtilSegmentValidation.genMaxLength("2|3",
				UtilMetadata.genPipeRow(getObjects(), 10, 15), 10);
	}
	
	public static FieldValidation genValidationRatio1() {
		return UtilFieldValidation.genEqualsRatio("3|2");
	}
//	
//	public static FieldValidation genValidationRatio2() {
//		return UtilFieldValidation.genEqualsPosFormula("3/2", 2, R_0302040000.key);
//	}
}
