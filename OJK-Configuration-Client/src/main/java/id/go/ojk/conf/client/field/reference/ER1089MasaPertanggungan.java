package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1089MasaPertanggungan implements IObject<KeyValueString> {
	R_3201 ("3201", "Produk dengan Masa Pertanggungan tidak lebih dari 1 bulan"),
	R_3202 ("3202", "Produk dengan Masa Pertanggungan lebih dari 1 bulan"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1089MasaPertanggungan eEnum : ER1089MasaPertanggungan.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1089MasaPertanggungan.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1089MasaPertanggungan.class.getSimpleName().substring(2, 6));
	}
}
