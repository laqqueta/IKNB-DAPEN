package id.go.ojk.asrjs.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3049PosLbAsrjs610 implements IObject<KeyValueString> {
	R_6101010099 ("6101010099", "Rincian Baris"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3049PosLbAsrjs610 eEnum : ER3049PosLbAsrjs610.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
}
