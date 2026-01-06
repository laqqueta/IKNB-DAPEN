package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1080JenisTingkatPengembalian implements IObject<KeyValueString> {
	R_2901 ("2901", "Suku Bunga Mengambang/Floating"),
	R_2902 ("2902", "Suku Bunga Tetap/Fix"),
	R_2903 ("2903", "Margin"),
	R_2904 ("2904", "Bagi Hasil"),
	R_2905 ("2905", "Imbal Jasa"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1080JenisTingkatPengembalian eEnum : ER1080JenisTingkatPengembalian.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1080JenisTingkatPengembalian.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1080JenisTingkatPengembalian.class.getSimpleName().substring(2, 6));
	}
}
