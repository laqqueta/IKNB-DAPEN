package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1252Pengelolaan implements IObject<KeyValueString> {

	R_PL1("SW", "Swakelola"),
	R_PL2("KPD", "KPD"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1252Pengelolaan eEnum : ER1252Pengelolaan.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER1252Pengelolaan.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER1252Pengelolaan.class.getSimpleName().substring(2, 6));
	}

	public static String getReferenceIndex(int index) {
		StringBuilder res = new StringBuilder();
		ER1252Pengelolaan[] eEnums = ER1252Pengelolaan.values();
		for (int i= 0; i < eEnums.length; i++) {
			if (i == index) {
				res.append(ER1252Pengelolaan.values()[i].key);
				break;
			}
		}

		return res.toString();
	}
}
