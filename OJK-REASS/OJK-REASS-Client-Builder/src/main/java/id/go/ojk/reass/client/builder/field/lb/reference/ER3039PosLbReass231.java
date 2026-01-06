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
public enum ER3039PosLbReass231 implements IObject<KeyValueString> {
	R_2310080100 ("2310080100", "<= 1 tahun "),
	R_2310080101 ("2310080101", "1 tahun < umur < 5 tahun"),
	R_2310080102 ("2310080102", "5 tahun = umur < 10 tahun"),
	R_2310080103 ("2310080103", ">= 10 tahun"),
	R_2310080104 ("2310080104", "Total"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3039PosLbReass231 eEnum : ER3039PosLbReass231.values()) {
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

	public static FieldValidation genValidation4() {
		return UtilFieldValidation.genEqualsPosFormula("2+3", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 4 }));
	}

	public static FieldValidation genValidation7() {
		return UtilFieldValidation.genEqualsPosFormula("5+6", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 4 }));
	}

	public static FieldValidation genValidation8() {
		return UtilFieldValidation.genEqualsRatio("2|5");
	}

	public static FieldValidation genValidation9() {
		return UtilFieldValidation.genEqualsRatio("3|6");
	}

	public static FieldValidation genValidation10() {
		return UtilFieldValidation.genEqualsRatio("4|7");
	}
	
	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 7), R_2310080104.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 3), "Total|Penjumlahan Detail");
	}
}
