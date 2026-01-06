package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1164PenempatanDana implements IObject<KeyValueString> {
	R_1 ("BJ:e63", "Deposito"),
	R_2 ("BJ:e92", "Piutang"),
	R_3 ("BJ:e94", "Kas"),
	R_4 ("BJ:e97", "Tabungan"),
	R_5 ("BJ:e95", "Giro"),
	R_6 ("BJ:e128", "Deposito On Call"),
	R_7 ("BJ:e129", "Call Money"),
	;

	private String key;
	private String value;

	public String getKey() {
		return key;
	}

	@Override
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1164PenempatanDana eEnum : ER1164PenempatanDana.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER1164PenempatanDana.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER1164PenempatanDana.class.getSimpleName().substring(2, 6));
	}

	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1164PenempatanDana[] eEnums = ER1164PenempatanDana.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1164PenempatanDana eEnum = ER1164PenempatanDana.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
