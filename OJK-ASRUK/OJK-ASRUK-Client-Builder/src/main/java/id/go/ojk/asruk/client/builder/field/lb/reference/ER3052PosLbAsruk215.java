package id.go.ojk.asruk.client.builder.field.lb.reference;

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
public enum ER3052PosLbAsruk215 implements IObject<KeyValueString> {
	R_5502010000 ("5502010000", "Biaya Pegawai, Direksi, dan Komisaris"),
//	R_5502020000 ("5502020000", "Biaya Pendidikan dan Latihan (Diklat)"),
	R_5502020100 ("5502020100", "a. Diklat Pegawai"),
	R_5502020200 ("5502020200", "b. Diklat Direksi"),
	R_5502020300 ("5502020300", "c. Diklat Komisaris"),
	R_5502020099 ("5502020099", "Total Biaya Diklat"),
	R_7012000000 ("7012000000", "Rasio Biaya Diklat dan Biaya Pegawai, Direksi, dan Komisaris"),
	;
	
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}
	
	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3052PosLbAsruk215 eEnum : ER3052PosLbAsruk215.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3", getObjects());
	}
	public static SegmentValidation genValidationNumericDotNegatif() {
		return UtilSegmentValidation.genRegexNumericDotNegative("2|3", R_7012000000.key);
	}

	public static SegmentValidation genValidationNumericNegatif() {
		return UtilSegmentValidation.genRegexNumericNegative("2|3", UtilMetadata.genPipeRow(getObjects(), 0, 4));
	}
	
	public static SegmentValidation genValidationRasioBiayaDiklat() {
		return UtilSegmentValidation.genEqualsRatio("2|3", R_7012000000.key, 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 4, 0 }), "Rasio biaya diklat dan biaya pegawai, direksi, dan komisaris|Penjumlahan rasio biaya diklat dan biaya pegawai, direksi, dan komisaris");
	}

	public static SegmentValidation genValidationTotalBiayaDiklat() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_5502020099.key, 
				UtilMetadata.genPlusRow(getObjects(), 1, 3), "Total biaya diklat|Penjumlahan biaya diklat");
	}
}
