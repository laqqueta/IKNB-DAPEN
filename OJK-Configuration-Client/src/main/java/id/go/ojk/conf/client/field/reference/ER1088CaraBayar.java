package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1088CaraBayar implements IObject<KeyValueString> {
	R_3701 ("3701", "Kontribusi Tunggal"),
	R_3702 ("3702", "Kontribusi Reguler"),
	R_3703 ("3703", "Kontribusi Polis-Polis Paid - up"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1088CaraBayar eEnum : ER1088CaraBayar.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1088CaraBayar.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1088CaraBayar.class.getSimpleName().substring(2, 6));
	}
}
