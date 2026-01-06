package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1201CaraBayar implements IObject<KeyValueString> {
	R_101 ("101", "Reguler - Bulanan"),
	R_102 ("102", "Reguler - Triwulanan"),
	R_103 ("103", "Reguler - Semesteran"),
	R_104 ("104", "Reguler - Tahunan"),
	R_105 ("105", "Reguler - Lainnya"),
	R_200 ("200", "Single Premium"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1201CaraBayar eEnum : ER1201CaraBayar.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1201CaraBayar.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1201CaraBayar.class.getSimpleName().substring(2, 6));
	}
}