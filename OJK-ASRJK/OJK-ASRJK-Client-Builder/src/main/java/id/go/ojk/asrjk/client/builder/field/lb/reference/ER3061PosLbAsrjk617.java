package id.go.ojk.asrjk.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3061PosLbAsrjk617 implements IObject<KeyValueString> {
	R_1400080200 ("1400080200", "Rincian baris"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3061PosLbAsrjk617 eEnum : ER3061PosLbAsrjk617.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3061PosLbAsrjk617.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3061PosLbAsrjk617.class.getSimpleName().substring(2, 6));
	}
	
	public static ConditionalRequired genConditionField() {
		return UtilFieldConditional.genAllExist("M", "N", "2");
	}
}
