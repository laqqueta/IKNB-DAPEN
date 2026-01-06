package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1072NamaPemeringkat implements IObject<KeyValueString> {
	R_2101 ("2101", "Fitch Ratings"),
	R_2102 ("2102", "Moody’s Investor Service"),
	R_2103 ("2103", "Standard and Poor’s"),
	R_2104 ("2104", "PT. Fitch Ratings Indonesia"),
	R_2105 ("2105", "PT. ICRA Indonesia"),
	R_2106 ("2106", "PT. Pemeringkat Efek Indonesia"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1072NamaPemeringkat eEnum : ER1072NamaPemeringkat.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1072NamaPemeringkat.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1072NamaPemeringkat.class.getSimpleName().substring(2, 6));
	}
}
