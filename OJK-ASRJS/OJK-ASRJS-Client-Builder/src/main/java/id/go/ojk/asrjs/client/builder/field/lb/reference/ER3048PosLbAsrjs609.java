package id.go.ojk.asrjs.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3048PosLbAsrjs609 implements IObject<KeyValueString> {
	R_6091010099 ("6091010099", "Rincian Baris ke-1"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3048PosLbAsrjs609 eEnum : ER3048PosLbAsrjs609.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static FieldValidation genValidation12() {
		return UtilFieldValidation.genEqualsFormula("10+11");
	}
	
	public static FieldValidation genValidation15() {
		return UtilFieldValidation.genEqualsFormula("13+14");
	}
	
	public static FieldValidation genValidation18() {
		return UtilFieldValidation.genEqualsFormula("16+17");
	}
}
