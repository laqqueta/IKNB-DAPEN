package id.go.ojk.reass.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2016PosRbReass1003 implements IObject<KeyValueString> {
	R_1003010000 ("1003010000", "Tenaga Kerja Asing"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2016PosRbReass1003 eEnum : ER2016PosRbReass1003.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2016PosRbReass1003.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2016PosRbReass1003.class.getSimpleName().substring(2, 6));
	}

	public static ConditionalRequired genConditionalField() {
		return UtilFieldConditional.genAllExist("M", "N", "2");
	}
}
