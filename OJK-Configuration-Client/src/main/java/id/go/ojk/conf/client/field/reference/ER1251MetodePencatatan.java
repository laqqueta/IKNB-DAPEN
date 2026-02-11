package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1251MetodePencatatan implements IObject<KeyValueString> {

	R_MP1("AFS", "Tersedia Untuk Dijual (Available for Sale / AFS)"),
	R_MP2("HTM", "Dimiliki Hingga Jatuh Tempo (Held to Maturity / HTM)"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1251MetodePencatatan eEnum : ER1251MetodePencatatan.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER1251MetodePencatatan.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER1251MetodePencatatan.class.getSimpleName().substring(2, 6));
	}
}
