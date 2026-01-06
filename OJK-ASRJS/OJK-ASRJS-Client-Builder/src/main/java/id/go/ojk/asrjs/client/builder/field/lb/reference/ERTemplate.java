package id.go.ojk.asrjs.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;

public enum ERTemplate implements IObject<KeyValueString> {
	;

	private String key;
	private String value;

	private ERTemplate(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ERTemplate eEnum : ERTemplate.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
}
