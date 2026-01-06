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

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3064PosLbAsrjk122 implements IObject<KeyValueString> {
	R_1100000010 ("1100000010", "<= 1 tahun"),
	R_1100000020 ("1100000020", "1 tahun < umur <= 5 tahun"),
	R_1100000030 ("1100000030", "5 tahun < umur <= 10 tahun"),
	R_1100000040 ("1100000040", "> 10 tahun"),
	R_1100000050 ("1100000050", "Total"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3064PosLbAsrjk122 eEnum : ER3064PosLbAsrjk122.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3064PosLbAsrjk122.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3064PosLbAsrjk122.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 7), getObjects());
	}

	public static FieldValidation genFieldValidation4() {
		return UtilFieldValidation.genEqualsPosFormula("2+3", 0, UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 4 }));
	}

	public static FieldValidation genFieldValidation7() {
		return UtilFieldValidation.genEqualsPosFormula("5+6", 0, UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 4 }));
	}
	
	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 7), R_1100000050.key, UtilMetadata.genPlusRow(getObjects(), 0, 3), "Total|Penjumalah detail", 0);
	}
}
