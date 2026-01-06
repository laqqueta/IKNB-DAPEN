package id.go.ojk.reask.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3065PosLbReask623 implements IObject<KeyValueString> {
	R_1201000100 ("1201000100", "Rincian baris"),
	R_1202000001 ("1202000001", "Total Investasi"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3065PosLbReask623 eEnum : ER3065PosLbReask623.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return R_1202000001.key;
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("6", getObjects());
	}
	
	public static ConditionalRequired genConditionField2() {
		return UtilFieldConditional.genExistPos("N", "M", R_1202000001.key);
	}
	
	public static ConditionalRequired genConditionField3() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "N", "M", R_1202000001.key, "2");
	}
	
	public static ConditionalRequired genConditionField4() {
		return genConditionField3();
	}
	
	public static ConditionalRequired genConditionField5() {
		return genConditionField3();
	}
	
	public static ConditionalRequired genConditionField6() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "M", "M", R_1202000001.key, "2");
	}
	
	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula("6", R_1202000001.key, R_1201000100.key, "Total|Penjumlahan detail");
	}
}
