package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1027JenisPendapatan implements IObject<KeyValueString> {
	R_01 ("01", "Imbalan Jasa"),
	R_02 ("02", "Pendapatan Lain"),
	R_03 ("03", "Pendapatan Komprehensif Lain"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1027JenisPendapatan eEnum : ER1027JenisPendapatan.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1027JenisPendapatan.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1027JenisPendapatan.class.getSimpleName().substring(2, 6));
	}
}
