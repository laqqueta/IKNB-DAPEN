package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1038StatusProduk implements IObject<KeyValueString> {
	R_100 ("100", "PRODUK BARU"),
	R_200 ("200", "PRODUK MASIH DIJUAL"),
	R_300 ("300", "PRODUK SUDAH TIDAK DIJUAL"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1038StatusProduk eEnum : ER1038StatusProduk.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1038StatusProduk.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1038StatusProduk.class.getSimpleName().substring(2, 6));
	}
}
