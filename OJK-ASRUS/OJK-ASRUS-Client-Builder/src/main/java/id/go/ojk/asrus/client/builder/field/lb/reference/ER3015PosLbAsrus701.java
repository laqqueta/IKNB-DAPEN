package id.go.ojk.asrus.client.builder.field.lb.reference;

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
public enum ER3015PosLbAsrus701 implements IObject<KeyValueString> {
	R_7301020100 ("7301020100", "Utang"),
	R_7301020101 ("7301020101", "Akumulasi Dana Investasi Peserta"),
	R_7301020102 ("7301020102", "Penyisihan PAYDI yang memberikan garansi pokok investasi"),
	R_7301020103 ("7301020103", "JUMLAH LIABILITAS"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3015PosLbAsrus701 eEnum : ER3015PosLbAsrus701.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 4), getObjects());
	}
	
	public static FieldValidation genFieldValidation4() {
		return UtilFieldValidation.genEqualsPosFormula("2-3", UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 3 }));
	}
	
	public static SegmentValidation genValidationJumlahLiabilitas() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 4), R_7301020103.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 2), "Jumlah Liabilitas|Penjumlahan Liabilitas");
	}
}
