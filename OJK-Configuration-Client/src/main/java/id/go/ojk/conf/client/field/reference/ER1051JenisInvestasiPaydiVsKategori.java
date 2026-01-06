package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1051JenisInvestasiPaydiVsKategori implements IObject<KeyValueString> {
	R_101 ("101", "BUK|BUS"),
	R_103 ("103", "IDX30|JII|NON"),
	R_105 ("105", "MTN|MTNS"),
	R_106 ("106", "HTM|AFT|AFS"),
	R_110 ("110", "SUN|OBG|EQT|MXD|RDPT"),
	R_113 ("113", "KSEI|BIS4"),
	;

	private String key;
	private String value;
	
	public String getKey() {
		return key;
	}
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1051JenisInvestasiPaydiVsKategori eEnum : ER1051JenisInvestasiPaydiVsKategori.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1051JenisInvestasiPaydiVsKategori.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1051JenisInvestasiPaydiVsKategori.class.getSimpleName().substring(2, 6));
	}
}
