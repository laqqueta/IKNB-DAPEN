package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1097JenisInvestasiVsSektorEkonomi implements IObject<KeyValueString> {
	R_101 ("101", "08000"),
	R_102 ("102", "08000"),
	R_103 ("103", "01000|02000|03000|04000|05000|06000|07000|08000|09000"),
	R_104 ("104", "01000|02000|03000|04000|05000|06000|07000|08000|09000"),
	R_105 ("105", "01000|02000|03000|04000|05000|06000|07000|08000|09000"),
	R_111 ("111", "01000|02000|03000|04000|05000|06000|07000|08000|09000"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1097JenisInvestasiVsSektorEkonomi eEnum : ER1097JenisInvestasiVsSektorEkonomi.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1097JenisInvestasiVsSektorEkonomi.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1097JenisInvestasiVsSektorEkonomi.class.getSimpleName().substring(2, 6));
	}
}
