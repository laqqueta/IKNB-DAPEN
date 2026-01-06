package id.go.ojk.dppkk.client.builder.field.setup;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3Branch implements IObject<KeyValueString> {
	R3_001 ("001", "Kantor Pusat"),
	R3_002 ("002", "Kantor Cabang Jakarta"),
	R3_003 ("003", "Kantor Cabang 003"),
	R3_004 ("004", "Kantor Cabang 004"),
	R3_005 ("005", "Kantor Cabang 005"),
	R3_006 ("006", "Kantor Cabang 006"),
	R3_007 ("007", "Kantor Cabang 007"),
	R3_008 ("008", "Kantor Cabang 008"),
	R3_009 ("009", "Kantor Cabang 009"),
	R3_010 ("010", "Kantor Cabang 010"),
	R3_011 ("011", "Kantor Cabang 011"),
	R3_012 ("012", "Kantor Cabang 012"),
	R3_013 ("013", "Kantor Cabang 013"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, null);
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3Branch eEnum : ER3Branch.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
}
