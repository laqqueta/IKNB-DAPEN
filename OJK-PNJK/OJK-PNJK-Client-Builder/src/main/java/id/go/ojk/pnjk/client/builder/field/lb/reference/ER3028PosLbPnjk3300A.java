package id.go.ojk.pnjk.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3028PosLbPnjk3300A implements IObject<KeyValueString> {
	R_3300A10100 ("3300A10100", "Detail"),
	;

	@Getter
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3028PosLbPnjk3300A eEnum : ER3028PosLbPnjk3300A.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER3028PosLbPnjk3300A.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3028PosLbPnjk3300A.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static FieldValidation genFieldValidation18() {
		return UtilFieldValidation.genEqualsFormula("3+6+9+12+15");
	}
	
	public static FieldValidation genFieldValidation19() {
		return UtilFieldValidation.genEqualsFormula("4+7+10+13+16");
	}
	
	public static FieldValidation genFieldValidation20() {
		return UtilFieldValidation.genEqualsFormula("5+8+11+14+17");
	}
}
