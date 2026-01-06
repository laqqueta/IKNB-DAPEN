package id.go.ojk.lpei.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER5030PosLbLpeigDHE01 implements IObject<KeyValueString> {
	R_DHE0101000("DHE0101000", "Detail"),
	;

	@Getter
	private String key;
	private String value;

	@Override
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER5030PosLbLpeigDHE01 eEnum : ER5030PosLbLpeigDHE01.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER5030PosLbLpeigDHE01.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER5030PosLbLpeigDHE01.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return ER5030PosLbLpeigDHE01.R_DHE0101000.getKey();
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 19), getObjects());
	}

	public static FieldValidation genFieldValidation12() {
		return UtilFieldValidation.genEqualsPosFormula("10*11", UtilMetadata.genPipeRow(getObjects()));
	}

	public static FieldValidation genFieldValidation13and14() {
		return UtilFieldValidation.genEqualsPosMultiplyConst("12", 2, UtilMetadata.genPipeRow(getObjects()), "0.3");
	}

	public static ConditionalRequired genConditionalValidation13() {
		return UtilFieldConditional.genAllExist("N", "M", "14");
	}

	public static ConditionalRequired genConditionalValidation14() {
		return UtilFieldConditional.genAllExist("N", "M", "13");
	}

	public static FieldValidation genFieldValidation19() {
		return UtilFieldValidation.genEqualsPosFormula("12-13-18", UtilMetadata.genPipeRow(getObjects()));
	}
}