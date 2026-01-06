package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1194SandiCounterparty implements IObject<KeyValueString> {
	R_1 ("S121", "Bank Indonesia (Bank Sentral)"),
	R_2 ("EN:e53", "Bank Umum"),
	R_3 ("EN:e54", "Bank Umum Syariah"),
	R_4 ("EN:e56", "BPR"),
	R_5 ("EN:e57", "BPRS"),
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
		for (ER1194SandiCounterparty eEnum : ER1194SandiCounterparty.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1194SandiCounterparty.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1194SandiCounterparty.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1194SandiCounterparty[] eEnums = ER1194SandiCounterparty.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1194SandiCounterparty eEnum = ER1194SandiCounterparty.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
