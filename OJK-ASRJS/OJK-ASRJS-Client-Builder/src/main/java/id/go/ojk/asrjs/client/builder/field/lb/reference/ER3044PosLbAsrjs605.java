package id.go.ojk.asrjs.client.builder.field.lb.reference;

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
public enum ER3044PosLbAsrjs605 implements IObject<KeyValueString> {
	R_6051010099 ("6051010099", "Baris rincian"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3044PosLbAsrjs605 eEnum : ER3044PosLbAsrjs605.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static FieldValidation genValidation18() {
		return UtilFieldValidation.genEqualsFormula(UtilMetadata.genPlusColumn(6, 10), 0);
	}
}
