package id.go.ojk.reask.client.builder.field.lb.reference;

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
public enum ER3041PosLbReask116 implements IObject<KeyValueString> {
//	R_2501010099 ("2501010099", "Asuransi Umum"),
	R_2501010100 ("2501010100", "Kematian Akibat Kecelakaan Diri"),
	R_2501019900 ("2501019900", "Lainnya"),
	R_2501010000 ("2501010000", "Total Cadangan Premi"),
//	R_2501010001 ("2501010001", "*Jumlah kolom total dibukukan di LPK PAYDI"),
//	R_2501010002 ("2501010002", "**Jumlah cadangan risiko dibukukan di LPK tradisional"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3041PosLbReask116 eEnum : ER3041PosLbReask116.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 13), getObjects());
	}
	
	public static FieldValidation genFieldValidation11() {
		return UtilFieldValidation.genEqualsPosFormula("3+4+6+7+9+10", UtilMetadata.genPipeRow(getObjects(), 0, 1));
	}
	
	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 13), R_2501010000.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 1), "Total|Penjumlahan detail");
	}
}
