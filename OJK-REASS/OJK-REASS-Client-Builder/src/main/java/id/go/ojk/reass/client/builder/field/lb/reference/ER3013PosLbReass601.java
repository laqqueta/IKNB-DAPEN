package id.go.ojk.reass.client.builder.field.lb.reference;

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
public enum ER3013PosLbReass601 implements IObject<KeyValueString> {
	R_6011020100 ("6011020100", "Utang"),
	R_6011020101 ("6011020101", "Penyisihan Kontribusi"),
	R_6011020102 ("6011020102", "Penyisihan Kontribusi Yang Belum Merupakan Pendapatan (PKYBMP)"),
	R_6011020103 ("6011020103", "Penyisihan Klaim"),
	R_6011020104 ("6011020104", "Penyisihan atas Risiko Bencana (Catastrophic Risks)"),
	R_6011020105 ("6011020105", "Jumlah Liabilitas "),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3013PosLbReass601 eEnum : ER3013PosLbReass601.values()) {
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
	
	public static FieldValidation genValidation4() {
		return UtilFieldValidation.genEqualsPosFormula("2-3", UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 5 }));
	}
	
	public static SegmentValidation genValidationJumlahLiabilitas() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 4), R_6011020105.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 4), "Jumlah Liabilitas|Penjumlahan Liabilitas");
	}
}
