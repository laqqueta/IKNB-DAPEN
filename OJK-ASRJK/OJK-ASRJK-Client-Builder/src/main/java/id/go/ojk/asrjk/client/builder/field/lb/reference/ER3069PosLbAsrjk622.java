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
public enum ER3069PosLbAsrjk622 implements IObject<KeyValueString> {
	R_1301000100 ("1301000100", "Rincian baris"),
	R_1301000200 ("1301000200", "Total Investasi"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3069PosLbAsrjk622 eEnum : ER3069PosLbAsrjk622.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3069PosLbAsrjk622.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3069PosLbAsrjk622.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return R_1301000200.key;
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(3, 12), getObjects());
	}
	
	public static ConditionalRequired genConditionField2() {
		return UtilFieldConditional.genExistPos("N", "O", R_1301000200.key);
	}
	
	public static ConditionalRequired genConditionField3() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "M", "M", R_1301000200.key, "2");
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
		return genConditionField3();
	}

	public static ConditionalRequired genConditionField12() {
		return genConditionField3();
	}
	
	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 12), R_1301000200.key, R_1301000100.key, "Total|Penjumlahan detail", 0);
	}
}
