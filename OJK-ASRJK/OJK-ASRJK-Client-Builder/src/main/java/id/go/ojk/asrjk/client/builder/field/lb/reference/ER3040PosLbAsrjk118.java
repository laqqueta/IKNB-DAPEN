package id.go.ojk.asrjk.client.builder.field.lb.reference;

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
public enum ER3040PosLbAsrjk118 implements IObject<KeyValueString> {
//	R_5401020099 ("5401020099", "Klaim Penebusan Unit"),
	R_5401020001 ("5401020001", "Kematian"),
	R_5401020002 ("5401020002", "Habis Kontrak"),
	R_5401020003 ("5401020003", "Nilai Tunai"),
	R_5401020004 ("5401020004", "Lainnya"),
	R_5401020000 ("5401020000", "Jumlah Klaim Penebusan Unit"),
//	R_5401029901 ("5401029901", "Catatan:"),
//	R_5401029902 ("5401029902", "*) Jumlah kolom Klaim Risiko dibukukan di LRK tradisional"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3040PosLbAsrjk118 eEnum : ER3040PosLbAsrjk118.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3040PosLbAsrjk118.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3040PosLbAsrjk118.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 5), getObjects());
	}
	
	public static FieldValidation genFieldValidation5() {
		return UtilFieldValidation.genEqualsPosFormula("3+4", UtilMetadata.genPipeRow(getObjects(), 0, 3));
	}
	
	public static SegmentValidation genValidationKlaimPenebusanUnit() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 5), R_5401020000.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 3), "Total klaim penebusan unit|Penjumlahan klaim penebusan unit");
	}
}
