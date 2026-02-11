package id.go.ojk.conf.client.field.reference;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1259SandiCounterparty implements IObject<KeyValueString> {
	R_1 ("S121", "Bank Indonesia"),
	R_2 ("EN:e53", "Bank Umum Konvensional"),
	R_3 ("EN:e54", "Bank Umum Syariah"),
	R_4 ("EN:e56", "BPR Konvensional"),
	R_5 ("EN:e57", "BPR Syariah"),
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
		for (ER1259SandiCounterparty eEnum : ER1259SandiCounterparty.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1259SandiCounterparty.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1259SandiCounterparty.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1259SandiCounterparty[] eEnums = ER1259SandiCounterparty.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1259SandiCounterparty eEnum = ER1259SandiCounterparty.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
