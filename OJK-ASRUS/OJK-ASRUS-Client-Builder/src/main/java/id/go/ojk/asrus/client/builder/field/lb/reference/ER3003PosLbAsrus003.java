package id.go.ojk.asrus.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3003PosLbAsrus003 implements IObject<KeyValueString> {
	R_1401000000 ("1401000000", "Rasio Pendidikan dan Pelatihan - I"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3003PosLbAsrus003 eEnum : ER3003PosLbAsrus003.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
}
