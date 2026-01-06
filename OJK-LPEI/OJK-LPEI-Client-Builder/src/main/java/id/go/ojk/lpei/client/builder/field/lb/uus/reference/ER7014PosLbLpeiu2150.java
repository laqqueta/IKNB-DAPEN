 package id.go.ojk.lpei.client.builder.field.lb.uus.reference;

 import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7014PosLbLpeiu2150 implements IObject<KeyValueString> {
	R_2150010000 ("2150010000", "Detail"),
	;

	@Getter
	private String key;
	private String value;
	
	@Override
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER7014PosLbLpeiu2150 eEnum : ER7014PosLbLpeiu2150.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER7014PosLbLpeiu2150.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER7014PosLbLpeiu2150.class.getSimpleName().substring(2, 6));
	}
}