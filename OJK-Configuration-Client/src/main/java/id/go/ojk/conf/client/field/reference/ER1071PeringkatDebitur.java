package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1071PeringkatDebitur implements IObject<KeyValueString> {
	R_1701 ("1701", "AAA atau yang setara"),
	R_1702 ("1702", "AA atau yang setara"),
	R_1703 ("1703", "A atau yang setara"),
	R_1704 ("1704", "BBB atau yang setara"),
	R_1705 ("1705", "dibawah BBB atau yang setara, atau tidak diperingkat"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1071PeringkatDebitur eEnum : ER1071PeringkatDebitur.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1071PeringkatDebitur.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1071PeringkatDebitur.class.getSimpleName().substring(2, 6));
	}
}
