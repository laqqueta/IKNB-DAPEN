package id.go.ojk.pnjk.client.builder.field.lb.uus.reference;

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
public enum ER3124PosLbPnju3000 implements IObject<KeyValueString> {
	R_3000010000 ("3000010000", "Detail"),
	;

	@Getter
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3124PosLbPnju3000 eEnum : ER3124PosLbPnju3000.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER3124PosLbPnju3000.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3124PosLbPnju3000.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static FieldValidation genFieldValidation5() {
		return UtilFieldValidation.genGreaterValue("0");
	}
	
	public static FieldValidation genFieldValidation7() {
		return UtilFieldValidation.genDateGreaterEquals("6");
	}
	
	public static FieldValidation genFieldValidationGreater(String value) {
		return UtilFieldValidation.genGreaterValue(value);
	}
}
