package id.go.ojk.dppks.client.builder.field.rb.reference;

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
public enum ER2009PosRbDppks0801 implements IObject<KeyValueString> {
	R_0801010000 ("0801010000", "Kekayaan Untuk Pendanaan"),
	R_0801020000 ("0801020000", "Nilai Kini Aktuaria"),
	R_0801030000 ("0801030000", "Kewajiban Solvabilitas"),
	R_0801040000 ("0801040000", "Surplus / Defisit"),
	R_0801050000 ("0801050000", "Rasio Pendanaan  (%)"),
	R_0801060000 ("0801060000", "Rasio Solvabilitas (%)"),
	R_0801070000 ("0801070000", "Kualitas Pendanaan"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2009PosRbDppks0801 eEnum : ER2009PosRbDppks0801.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2009PosRbDppks0801.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2009PosRbDppks0801.class.getSimpleName().substring(2, 6));
	}

	public static SegmentValidation genValidationKualitasPendanaan() {
		return UtilSegmentValidation.genFixedValue("2|3|4|5", R_0801070000.key, "1|2|3");
	}
	
	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumeric("2|3|4|5", UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 1, 2, 3, 6 }));
	}
	
	public static SegmentValidation genValidationNumericNegative() {
		return UtilSegmentValidation.genRegexNumericNegative("2|3|4|5", UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 1, 2, 3, 6 }));
	}
	
	public static SegmentValidation genValidationDecimal() {
		return UtilSegmentValidation.genRegexNumericDot("2|3|4|5", UtilMetadata.genPipeRow(getObjects(), 4, 5));
	}
	
	public static SegmentValidation genValidationMaxLengthKualitasPendanaan() {
		return UtilSegmentValidation.genMaxLength("2|3|4|5", R_0801070000.key, 1);
	}
}
