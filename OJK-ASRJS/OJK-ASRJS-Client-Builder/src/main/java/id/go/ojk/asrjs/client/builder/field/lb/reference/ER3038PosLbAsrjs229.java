package id.go.ojk.asrjs.client.builder.field.lb.reference;

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
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3038PosLbAsrjs229 implements IObject<KeyValueString> {
	R_2290060100 ("2290060100", " Kematian Ekawarsa (Masukkan semua produk asuransi jiwa)"),
	R_2290060101 ("2290060101", " Kematian Jangka Warsa"),
	R_2290060102 ("2290060102", " Kecelakaan Diri"),
	R_2290060103 ("2290060103", " Kesehatan"),
	R_2290060104 ("2290060104", "Anuitas"),
	R_2290060105 ("2290060105", "Total"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3038PosLbAsrjs229 eEnum : ER3038PosLbAsrjs229.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 10), getObjects());
	}

	public static FieldValidation genFieldValidation8() {
		return UtilFieldValidation.genEqualsPosFormula("2+4+6", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 5 }));
	}
	
	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 10), R_2290060105.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 4), 
				"Total|Penjumlahan Detail");
	}
}
