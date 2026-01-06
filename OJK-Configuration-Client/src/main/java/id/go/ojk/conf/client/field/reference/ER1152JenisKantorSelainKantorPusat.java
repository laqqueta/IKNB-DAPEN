package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1152JenisKantorSelainKantorPusat implements IObject<KeyValueString> {
	R_1 ("ST:e24", "Kantor Cabang ULaMM"),
	R_2 ("ST:e25", "Kantor Unit ULaMM"),
	R_3 ("ST:e26", "Kantor Cabang Mekaar"),
	;

	private String key;
	private String value;
	
	public String getKey() {
		return key;
	}
	
	public String getValue() {
		return value;
	}
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1152JenisKantorSelainKantorPusat eEnum : ER1152JenisKantorSelainKantorPusat.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1152JenisKantorSelainKantorPusat.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1152JenisKantorSelainKantorPusat.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1152JenisKantorSelainKantorPusat[] eEnums = ER1152JenisKantorSelainKantorPusat.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1152JenisKantorSelainKantorPusat eEnum = ER1152JenisKantorSelainKantorPusat.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
