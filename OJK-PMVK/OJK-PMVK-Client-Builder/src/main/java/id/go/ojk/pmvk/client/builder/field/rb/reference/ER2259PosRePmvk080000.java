package id.go.ojk.pmvk.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.pmvk.client.builder.field.reference.EHeaderMetadataShared;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2259PosRePmvk080000 implements IObject<KeyValueString> {
	R_08010100000000 ("08010100000000", "Detail"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2259PosRePmvk080000 eEnum : ER2259PosRePmvk080000.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2259PosRePmvk080000.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2259PosRePmvk080000.class.getSimpleName().substring(2, 6));
	}

	public static ConditionalRequired genConditionalField3() {
		return UtilFieldConditional.genAllExist("M", "N", "2");
	}

	public static ConditionalRequired genConditionalField4() {
		return genConditionalField3();
	}

	public static ConditionalRequired genConditionalField5() {
		return genConditionalField3();
	}

	public static ConditionalRequired genConditionalField6() {
		return genConditionalField3();
	}

	public static ConditionalRequired genConditionalField7() {
		return genConditionalField3();
	}

	public static ConditionalRequired genConditionalField8() {
		return genConditionalField3();
	}

	public static ConditionalRequired genConditionalField9() {
		return genConditionalField3();
	}
	
	public static FieldValidation genValidationField3() {
		return UtilFieldValidation.genReferenceCondition("2", String.valueOf(EHeaderMetadataShared.R009.getNumber()));
	}
	
	public static FieldValidation genValidationField7() {
		return UtilFieldValidation.genEqualsFormula("6-5");
	}
}
