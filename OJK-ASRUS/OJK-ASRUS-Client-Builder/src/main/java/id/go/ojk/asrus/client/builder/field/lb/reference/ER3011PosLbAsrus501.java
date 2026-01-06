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
public enum ER3011PosLbAsrus501 implements IObject<KeyValueString> {
	R_1400000000 ("1400000000", "I. Utang"),
	R_1401000000 ("1401000000", "II. Penyisihan Ujrah"),
	R_1401010000 ("1401010000", "III. Penyisihan untuk Penjaminan Atas Pokok Investasi PAYDI"),
	R_1401020000 ("1401020000", "JUMLAH KEWAJIBAN (I+II+III)"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3011PosLbAsrus501 eEnum : ER3011PosLbAsrus501.values()) {
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
	
	public static SegmentValidation genValidationJumlahKewajiban() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 4), R_1401020000.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 2), "Jumlah Kewajiban|Penjumlahan Kewajiban");
	}
}
