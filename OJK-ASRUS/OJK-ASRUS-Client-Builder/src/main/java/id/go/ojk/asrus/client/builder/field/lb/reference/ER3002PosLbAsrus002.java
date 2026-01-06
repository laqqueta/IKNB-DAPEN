package id.go.ojk.asrus.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3002PosLbAsrus002 implements IObject<KeyValueString> {
	R_1301000000 ("1301000000", "Daftar rincian pihak utama"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3002PosLbAsrus002 eEnum : ER3002PosLbAsrus002.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
}
