package id.go.ojk.asrjk.client.builder.field.lb.reference;

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
public enum ER3048PosLbAsrjk212 implements IObject<KeyValueString> {
	R_5502010000 ("5502010000", "Beban Pegawai, Direksi, dan Komisaris"),
//	R_5502020099 ("5502020099", "Beban Pendidikan dan Latihan (Diklat)"),
	R_5502020100 ("5502020100", "a. Diklat Pegawai"),
	R_5502020200 ("5502020200", "b. Diklat Direksi"),
	R_5502020300 ("5502020300", "c. Diklat Komisaris"),
	R_5502020000 ("5502020000", "Total Beban Diklat"),
	R_7012000000 ("7012000000", "Rasio Beban Diklat dan Beban Pegawai, Direksi, dan Komisaris"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3048PosLbAsrjk212 eEnum : ER3048PosLbAsrjk212.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3048PosLbAsrjk212.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3048PosLbAsrjk212.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 3), getObjects());
	}
	
	public static SegmentValidation genValidationNumericNegatif() {
		return UtilSegmentValidation.genRegexNumericNegative(UtilMetadata.genPipeColumn(2, 3), 
				UtilMetadata.genPipeRow(getObjects(), 0, 4));
	}
	
	public static SegmentValidation genValidationNumericDotNegatif() {
		return UtilSegmentValidation.genRegexNumericDotNegative(UtilMetadata.genPipeColumn(2, 3), R_7012000000.key);
	}
	
	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_5502020000.key, 
				UtilMetadata.genPlusRow(getObjects(), 1, 3), "Total beban diklat|Penjumlahan beban diklat");
	}
	
	public static SegmentValidation genValidationRatio() {
		return UtilSegmentValidation.genEqualsRatio(UtilMetadata.genPipeColumn(2, 3), R_7012000000.key, 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 4, 0 }), 
				"Rasio beban diklat dan beban pegawai, direksi, dan komisaris|Perhitungan beban diklat dan beban pegawai, direksi, dan komisaris");
	}
}
