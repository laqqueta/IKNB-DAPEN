package id.go.ojk.pnjk.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3014PosLbPnjk2100D1 implements IObject<KeyValueString> {
	R_2100D10100 ("2100D10100", "Detail"),
	R_2100D10000 ("2100D10000", "Total"),
	;

	@Getter
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3014PosLbPnjk2100D1 eEnum : ER3014PosLbPnjk2100D1.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER3014PosLbPnjk2100D1.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3014PosLbPnjk2100D1.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects(), new int[] { 1 });
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("6|8|9|10", getObjects());
	}

    public static String genFieldSaveForm() {
        return UtilMetadata.genFieldSave("10", getObjects());
    }
	
	public static ConditionalRequired genConditionA() {
		return UtilFieldConditional.genExistPos("N", "M", R_2100D10000.key);
	}
	
	public static ConditionalRequired genConditionB(String comparatorField) {
		return UtilFieldConditional.genExistPosAndComparatorNotEmpty("N", "M",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 0 }), comparatorField);
	}
	
	public static FieldValidation genFieldValidation05() {
		return UtilFieldValidation.genPosGreaterValue(R_2100D10100.key, "0.00");
	}
	
	public static FieldValidation genFieldValidation10() {
		return UtilFieldValidation.genEqualsPosFormula("7-8-9", R_2100D10100.key);
	}
	
	public static SegmentValidation genValidation1() {
		return UtilSegmentValidation.genEqualsFormula("6|8|9|10", R_2100D10000.key, R_2100D10100.key,
				UtilMetadata.genMessageTotal(R_2100D10000.value, R_2100D10100.value));
	}
}
