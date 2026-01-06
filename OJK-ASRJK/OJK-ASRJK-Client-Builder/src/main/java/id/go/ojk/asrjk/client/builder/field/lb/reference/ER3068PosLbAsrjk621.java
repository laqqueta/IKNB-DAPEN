package id.go.ojk.asrjk.client.builder.field.lb.reference;

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
public enum ER3068PosLbAsrjk621 implements IObject<KeyValueString> {
	R_1201000200 ("1201000200", "Rincian baris"),
	R_1202000002 ("1202000002", "Total Investasi"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3068PosLbAsrjk621 eEnum : ER3068PosLbAsrjk621.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3068PosLbAsrjk621.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3068PosLbAsrjk621.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return R_1202000002.key;
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("11|12|13", getObjects());
	}
	
	public static ConditionalRequired genConditionField2() {
		return UtilFieldConditional.genExistPos("N", "O", R_1202000002.key);
	}

	public static ConditionalRequired genConditionField3() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "N", "M", R_1202000002.key, "2");
	}
	
	public static ConditionalRequired genConditionField4() {
		return genConditionField3();
	}
	
	public static ConditionalRequired genConditionField5() {
		return genConditionField3();
	}
	
	public static ConditionalRequired genConditionField6() {
		return genConditionField3();
	}
	
	public static ConditionalRequired genConditionField7() {
		return genConditionField3();
	}
	
	public static ConditionalRequired genConditionField8() {
		return genConditionField3();
	}
	
	public static ConditionalRequired genConditionField9() {
		return genConditionField3();
	}
	
	public static ConditionalRequired genConditionField10() {
		return genConditionField3();
	}
	
	public static ConditionalRequired genConditionField11() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "M", "M", R_1202000002.key, "2");
	}
	
	public static ConditionalRequired genConditionField12() {
		return genConditionField11();
	}
	
	public static ConditionalRequired genConditionField13() {
		return genConditionField11();
	}
	
	public static SegmentValidation genValidationTotalA() {
		return UtilSegmentValidation.genEqualsFormula("11|12", R_1202000002.key, R_1201000200.key, "Total|Penjumlahan detail", 0);
	}
	
	public static SegmentValidation genValidationTotalB() {
		return UtilSegmentValidation.genEqualsFormula("13", R_1202000002.key, R_1201000200.key, "Total|Penjumlahan detail");
	}
}
