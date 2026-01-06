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
public enum ER2001PosRbDppkk0200 implements IObject<KeyValueString> {
//	R_0201000000 ("0201000000", ""),
	R_0201010000 ("0201010000", "Aset Neto"),
	R_0201020000 ("0201020000", "Investasi"),
	R_0201030000 ("0201030000", "Pendapatan Investasi"),
	R_0201040000 ("0201040000", "Beban Investasi"),
	R_0201050000 ("0201050000", "Beban Operasional"),
//	R_0202000000 ("0202000000", ""),
	R_0202010000 ("0202010000", "Rasio Pendapatan Investasi (ROI)"),
	R_0202020000 ("0202020000", "Rasio Pendapatan Investasi terhadap Aset (ROA)"),
	R_0202030000 ("0202030000", "Rasio Beban Operasional (BOPO)"),
	R_0202040000 ("0202040000", "Rasio Umur Piutang Iuran (RUPI)"),
	R_0202050000 ("0202050000", "Rasio Pendanaan khusus PPMP"),
	R_0202060000 ("0202060000", "Rasio Solvabilitas khusus PPMP"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2001PosRbDppkk0200 eEnum : ER2001PosRbDppkk0200.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2001PosRbDppkk0200.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2001PosRbDppkk0200.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static SegmentValidation genValidationNumericNegatif() {
		return UtilSegmentValidation.genRegexNumericNegative("2|3|4|5",
				UtilMetadata.genPipeRow(getObjects(), 0, 4));
	}

	public static SegmentValidation genValidationNumericDotNegatif() {
		return UtilSegmentValidation.genRegexNumericDotNegative("2|3|4|5",
				UtilMetadata.genPipeRow(getObjects(), 5, 10));
	}

	public static SegmentValidation genValidationMaxLengthDecimal() {
		return UtilSegmentValidation.genMaxLength("2|3|4|5",
				UtilMetadata.genPipeRow(getObjects(), 5, 10), 10);
	}
}
