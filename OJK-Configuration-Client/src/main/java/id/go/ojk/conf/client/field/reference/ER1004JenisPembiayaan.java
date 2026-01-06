package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1004JenisPembiayaan implements IObject<KeyValueString> {
	R_JKE13 ("JK:e13", "Pembiayaan Investasi"),
	R_JKE14 ("JK:e14", "Pembiayaan Modal Kerja"),
	R_JKE52 ("JK:e52", "Pembiayaan Multi Guna"),
	R_JKE53 ("JK:e53", "Pembiayaan Berdasarkan Prinsip Syariah"),
	R_JKE25 ("JK:e25", "Pembiayaan Jual Beli Berdasarkan Prinsip Syariah"),
	R_JKE30 ("JK:e30", "Pembiayaan Investasi Berdasarkan Prinsip Syariah"),
	R_JKE36 ("JK:e36", "Pembiayaan Jasa Berdasarkan Prinsip Syariah"),
	R_JKE54 ("JK:e54", "Pembiayaan Lainnya Berdasarkan Persetujuan OJK"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1004JenisPembiayaan eEnum : ER1004JenisPembiayaan.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1004JenisPembiayaan.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1004JenisPembiayaan.class.getSimpleName().substring(2, 6));
	}
}
