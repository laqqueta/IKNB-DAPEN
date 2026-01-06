package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1095JenisSaluranPemasaran implements IObject<KeyValueString> {
	R_1201 ("1201", "Secara Langsung (Direct Marketing)"),
	R_1202 ("1202", "Agen asuransi (Agency)"),
	R_1203 ("1203", "Bancassurance"),
	R_1204 ("1204", "Badan Usaha Selain Bank - Agen Laku Pandai"),
	R_1205 ("1205", "Badan Usaha Selain Bank - Selain Agen Laku Pandai"),
	R_1206 ("1206", "Tenaga Pemasar (Mikro) - Agen Laku Pandai"),
	R_1207 ("1207", "Tenaga Pemasar (Mikro) - Selain Agen Laku Pandai"),
	R_1208 ("1208", "Pialang Asuransi"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1095JenisSaluranPemasaran eEnum : ER1095JenisSaluranPemasaran.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1095JenisSaluranPemasaran.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1095JenisSaluranPemasaran.class.getSimpleName().substring(2, 6));
	}
}
