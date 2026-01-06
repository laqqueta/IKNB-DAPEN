package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1050JenisInvestasiVsKategori implements IObject<KeyValueString> {
	R_101 ("101", "BUK|BUS"),
	R_103 ("103", "IDX30|JII|NON"),
	R_105 ("105", "MTN|MTNS"),
	R_106 ("106", "HTM|AFT|AFS"),
	R_110 ("110", "SUN|OBG|EQT|MXD|RDPT"),
	R_113 ("113", "KSEI|BIS4"),
	R_114 ("114", "USPV|NSPV"),
	R_115 ("115", "LND|BLD|LNB"),
	R_118 ("118", "PRES|PCOM|PNUS"),
	R_119 ("119", "APL|NAPL"),
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
		for (ER1050JenisInvestasiVsKategori eEnum : ER1050JenisInvestasiVsKategori.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1050JenisInvestasiVsKategori.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1050JenisInvestasiVsKategori.class.getSimpleName().substring(2, 6));
	}
}
