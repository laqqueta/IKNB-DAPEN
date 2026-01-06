package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1078TujuanKepemilikan implements IObject<KeyValueString> {
	R_2801 ("2801", "Dimiliki Hingga Jatuh Tempo (Held to Maturity / HTM)"),
	R_2802 ("2802", "Diperdagangkan (Held for trading / Trading)"),
	R_2803 ("2803", "Tersedia Untuk Dijual (Available for Sale / AFS)"),
	R_2804 ("2804", "Untuk Investasi"),
	R_2805 ("2805", "Bukan Untuk Investasi"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1078TujuanKepemilikan eEnum : ER1078TujuanKepemilikan.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1078TujuanKepemilikan.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1078TujuanKepemilikan.class.getSimpleName().substring(2, 6));
	}
}
