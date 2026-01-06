package id.go.ojk.dplkk.client.builder.field.sa.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER4004PosSaDplkk0400 implements IObject<KeyValueString> {
	R_0401000000 ("0401000000", "Peringkat Rentabilitas"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER4004PosSaDplkk0400 eEnum : ER4004PosSaDplkk0400.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static FieldValidation genValidationPeringkat() {
		return UtilFieldValidation.genEqualsFixedValue("1|2|3|4|5");
	}
}
