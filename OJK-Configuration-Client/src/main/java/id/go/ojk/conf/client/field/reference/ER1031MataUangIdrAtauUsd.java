package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1031MataUangIdrAtauUsd implements IObject<KeyValueString> {
	R_IDR ("IDR", "Indonesian Rupiah  (IDR)"),
	R_USD ("USD", "US Dollar (USD)"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1031MataUangIdrAtauUsd eEnum : ER1031MataUangIdrAtauUsd.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1031MataUangIdrAtauUsd.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1031MataUangIdrAtauUsd.class.getSimpleName().substring(2, 6));
	}
}
