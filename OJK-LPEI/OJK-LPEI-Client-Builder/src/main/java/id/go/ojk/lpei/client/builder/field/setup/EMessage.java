package id.go.ojk.lpei.client.builder.field.setup;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EMessage implements IObject<KeyValueString> {
	EMAIL ("CLI-email", "helpdesk@ojk.go.id"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, null);
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (EMessage eEnum : EMessage.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
}
