package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1098JenisPemegangSaham implements IObject<KeyValueString> {
	R_WNI ("WNI", "Warga Negara Indonesia"),
	R_BHI ("BHI", "Badan Hukum Indonesia"),
	R_WNA ("WNA", "Warga Negara Asing"),
	R_BHA ("BHA", "Badan Hukum Asing"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1098JenisPemegangSaham eEnum : ER1098JenisPemegangSaham.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1098JenisPemegangSaham.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1098JenisPemegangSaham.class.getSimpleName().substring(2, 6));
	}
}
