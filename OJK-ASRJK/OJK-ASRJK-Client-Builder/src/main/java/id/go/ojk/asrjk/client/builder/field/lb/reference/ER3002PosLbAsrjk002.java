package id.go.ojk.asrjk.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3002PosLbAsrjk002 implements IObject<KeyValueString> {
	R_1301000000 ("1301000000", "Daftar rincian direksi dan/atau komisaris"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3002PosLbAsrjk002 eEnum : ER3002PosLbAsrjk002.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3002PosLbAsrjk002.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3002PosLbAsrjk002.class.getSimpleName().substring(2, 6));
	}
}
