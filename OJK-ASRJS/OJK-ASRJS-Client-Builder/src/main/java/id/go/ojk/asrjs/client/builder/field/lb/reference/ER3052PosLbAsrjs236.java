package id.go.ojk.asrjs.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3052PosLbAsrjs236 implements IObject<KeyValueString> {
	R_2361010099 ("2361010099", "Baris rincian"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3052PosLbAsrjs236 eEnum : ER3052PosLbAsrjs236.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
}
