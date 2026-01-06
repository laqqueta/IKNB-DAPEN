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
public enum ER3108PosLbPnju2100A2 implements IObject<KeyValueString> {
	R_2100A20100 ("2100A20100", "Detail"),
	R_2100A20000 ("2100A20000", "Total"),
	;

	@Getter
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3108PosLbPnju2100A2 eEnum : ER3108PosLbPnju2100A2.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER3108PosLbPnju2100A2.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3108PosLbPnju2100A2.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects(), new int[] { 1 });
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("6|12|13|14", getObjects());
	}

    public static String genFieldSaveForm() {
        return UtilMetadata.genFieldSave("14", getObjects());
    }

	public static ConditionalRequired genConditionA() {
		return UtilFieldConditional.genExistPos("N", "M", UtilMetadata.genPipeRow(getObjects(), new int[] { 1 }));
	}
	
	public static ConditionalRequired genConditionB(String comparatorField) {
		return UtilFieldConditional.genExistPosAndComparatorNotEmpty("N", "M",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 0 }), comparatorField);
	}
	
	public static FieldValidation genFieldValidationGreater(String value) {
		return UtilFieldValidation.genPosGreaterValue(UtilMetadata.genPipeRow(getObjects(), new int[] {0}), value);
	}
	
	public static FieldValidation genFieldValidation02() {
		return UtilFieldValidation.genReferenceConditionPos("3", "1192", UtilMetadata.genPipeRow(getObjects(), new int[] {0}));
	}
	
	public static FieldValidation genFieldValidation08() {
		return UtilFieldValidation.genDateLessPos("9", UtilMetadata.genPipeRow(getObjects(), new int[] {0}));
	}
	
	public static FieldValidation genFieldValidation09() {
		return UtilFieldValidation.genDateGreaterPos("8", UtilMetadata.genPipeRow(getObjects(), new int[] {0}));
	}
	
	public static FieldValidation genFieldValidation14() {
		return UtilFieldValidation.genEqualsFormula("6-12-13");
	}
	
	public static SegmentValidation genValidation1() {
		int[] field = new int[] { 0 };
		return UtilSegmentValidation.genEqualsFormula("6|12|13|14", R_2100A20000.key,
				UtilMetadata.genPlusRow(getObjects(), field),
				UtilMetadata.genMessageTotal(R_2100A20000.value, R_2100A20100.value));
	}
}
