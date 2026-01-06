package id.go.ojk.pnjk.client.builder.field.lb.uus.reference;

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
public enum ER3112PosLbPnju2100C1 implements IObject<KeyValueString> {
	R_2100C10100 ("2100C10100", "Detail"),
	R_2100C10000 ("2100C10000", "Total"),
	;

	@Getter
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3112PosLbPnju2100C1 eEnum : ER3112PosLbPnju2100C1.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER3112PosLbPnju2100C1.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3112PosLbPnju2100C1.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects(), new int[] { 1 });
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(5, 9), getObjects());
	}

    public static String genFieldSaveForm() {
        return UtilMetadata.genFieldSave("9", getObjects());
    }
	
	public static ConditionalRequired genConditionA() {
		return UtilFieldConditional.genExistPos("N", "M", UtilMetadata.genPipeRow(getObjects(), new int[] { 1 }));
	}
	
	public static ConditionalRequired genConditionB(String comparatorField) {
		return UtilFieldConditional.genExistPosAndComparatorNotEmpty("N", "M",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 0 }), comparatorField);
	}
	
	public static FieldValidation genFieldValidation9() {
		return UtilFieldValidation.genEqualsFormula("6-7-8");
	}
	
	public static SegmentValidation genValidation1() {
		int[] field = new int[] { 0 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(5, 9), R_2100C10000.key,
				UtilMetadata.genPlusRow(getObjects(), field),
				UtilMetadata.genMessageTotal(R_2100C10000.value, R_2100C10100.value));
	}
}
