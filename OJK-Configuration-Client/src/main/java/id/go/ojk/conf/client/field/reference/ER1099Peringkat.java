package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1099Peringkat implements IObject<KeyValueString> {
	R_1 ("1", "Peringkat 1"),
	R_2 ("2", "Peringkat 2"),
	R_3 ("3", "Peringkat 3"),
	R_4 ("4", "Peringkat 4"),
	R_5 ("5", "Peringkat 5"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1099Peringkat eEnum : ER1099Peringkat.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1099Peringkat.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1099Peringkat.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1099Peringkat[] eEnums = ER1099Peringkat.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1099Peringkat eEnum = ER1099Peringkat.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
