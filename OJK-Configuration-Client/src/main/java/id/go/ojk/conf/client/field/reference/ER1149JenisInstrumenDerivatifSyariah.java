package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1149JenisInstrumenDerivatifSyariah implements IObject<KeyValueString> {
	R_1 ("JI:e70", "Forward"),
	R_2 ("JI:e72", "Instrumen Derivatif Lainnya"),
	R_3 ("JI:e82", "Spot"),
	R_4 ("JI:e95", "Forward Agreement"),
	;

	private String key;
	private String value;
	
	public String getKey() {
		return key;
	}
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1149JenisInstrumenDerivatifSyariah eEnum : ER1149JenisInstrumenDerivatifSyariah.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1149JenisInstrumenDerivatifSyariah.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1149JenisInstrumenDerivatifSyariah.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1149JenisInstrumenDerivatifSyariah[] eEnums = ER1149JenisInstrumenDerivatifSyariah.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1149JenisInstrumenDerivatifSyariah eEnum = ER1149JenisInstrumenDerivatifSyariah.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
