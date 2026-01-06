package id.go.ojk.reask.client.builder.field.lb.reference;

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
public enum ER3015PosLbReask506 implements IObject<KeyValueString> {
	R_1601000000 ("1601000000", "CPrf"),
	R_1602000000 ("1602000000", "CPo"),
	R_1603000000 ("1603000000", "Maks((CPrf-CPo),0)"),
	R_1604000000 ("1604000000", "Faktor Perubahan Tingkat Bunga"),
	R_1605000000 ("1605000000", "Perubahan Tingkat Bunga"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3015PosLbReask506 eEnum : ER3015PosLbReask506.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2", getObjects());
	}
	
	public static SegmentValidation genValidationNumericNegatif() {
		return UtilSegmentValidation.genRegexNumericNegative("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 1, 2, 4 }));
	}
	
	public static SegmentValidation genValidationNumericDot() {
		return UtilSegmentValidation.genRegexNumericDot("2", R_1604000000.key);
	}
	
	public static SegmentValidation genValidationMax() {
		return UtilSegmentValidation.genMaxValue("2", R_1603000000.key, R_1601000000.key + "-" + R_1602000000.key, 
				"0", "perhitungan nilai maksimum");
	}
	
	public static SegmentValidation genValidationFaktorPerubahanTingkatBunga() {
		return UtilSegmentValidation.genFixedValue("2", R_1604000000.key, "15.00");
	}
	
	public static SegmentValidation genValidationPerubahanTingkatBunga() {
		return UtilSegmentValidation.genPercentage("2", R_1605000000.key, 
				UtilMetadata.genPipeRow(getObjects(), 2, 3), "Perubahan tingkat bunga|Perhitungan Perubahan tingkat bunga");
	}
}
