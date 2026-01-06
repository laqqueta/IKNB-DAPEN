package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1019PeringkatKlaster implements IObject<KeyValueString> {
	R_1 ("1", "Peringkat Klaster 1"),
	R_2 ("2", "Peringkat Klaster 2"),
	R_3 ("3", "Peringkat Klaster 3"),
	R_4 ("4", "Peringkat Klaster 4"),
	R_5 ("5", "Peringkat Klaster 5"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1019PeringkatKlaster eEnum : ER1019PeringkatKlaster.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1019PeringkatKlaster.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1019PeringkatKlaster.class.getSimpleName().substring(2, 6));
	}
}
