package id.go.ojk.asruk.client.builder.field.lb.reference;

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
public enum ER3063PosLbAsruk621 implements IObject<KeyValueString> {
	R_1400080300 ("1400080300", "Rincian baris"),
	R_1400000000 ("1400000000", "Total Investasi"),
	;
	
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}
	
	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3063PosLbAsruk621 eEnum : ER3063PosLbAsruk621.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return R_1400000000.key;
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(5, 22), getObjects());
	}

	public static ConditionalRequired genConditionField10() {
		return genConditionField5();
	}
	public static ConditionalRequired genConditionField11() {
		return genConditionField5();
	}

	public static ConditionalRequired genConditionField12() {
		return genConditionField5();
	}
	
	public static ConditionalRequired genConditionField13() {
		return genConditionField5();
	}

	public static ConditionalRequired genConditionField14() {
		return genConditionField5();
	}
	
	public static ConditionalRequired genConditionField15() {
		return genConditionField5();
	}
	
	public static ConditionalRequired genConditionField16() {
		return genConditionField5();
	}
	
	public static ConditionalRequired genConditionField17() {
		return genConditionField5();
	}
	
	public static ConditionalRequired genConditionField18() {
		return genConditionField5();
	}
	
	public static ConditionalRequired genConditionField19() {
		return genConditionField5();
	}
	
	public static ConditionalRequired genConditionField2() {
		return UtilFieldConditional.genExistPos("N", "O", R_1400000000.key);
	}
	
	public static ConditionalRequired genConditionField20() {
		return genConditionField5();
	}
	
	public static ConditionalRequired genConditionField21() {
		return genConditionField5();
	}
	
	public static ConditionalRequired genConditionField22() {
		return genConditionField5();
	}
	
	public static ConditionalRequired genConditionField3() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "N", "M", R_1400000000.key, "2");
	}
	
	public static ConditionalRequired genConditionField4() {
		return genConditionField3();
	}
	
	public static ConditionalRequired genConditionField5() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "M", "M", R_1400000000.key, "2");
	}
	
	public static ConditionalRequired genConditionField6() {
		return genConditionField5();
	}
	
	public static ConditionalRequired genConditionField7() {
		return genConditionField5();
	}
	
	public static ConditionalRequired genConditionField8() {
		return genConditionField5();
	}
	
	public static ConditionalRequired genConditionField9() {
		return genConditionField5();
	}
	
	public static SegmentValidation genValidationTotalInvestasi() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(5, 22), R_1400000000.key, R_1400080300.key, "Total Investasi|Penjumlahan Investasi", 0);
	}
}
