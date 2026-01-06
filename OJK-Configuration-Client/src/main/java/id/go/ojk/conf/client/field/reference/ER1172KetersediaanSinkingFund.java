package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1172KetersediaanSinkingFund implements IObject<KeyValueString> {
	R_1("SK:e01", "Ada"),
	R_2("SK:e02", "Tidak Ada"),
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
		for (ER1172KetersediaanSinkingFund eEnum : ER1172KetersediaanSinkingFund.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER1172KetersediaanSinkingFund.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER1172KetersediaanSinkingFund.class.getSimpleName().substring(2, 6));
	}

	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1172KetersediaanSinkingFund[] eEnums = ER1172KetersediaanSinkingFund.values();
		int enumLength = eEnums.length;
		for (int i = 0; i < enumLength; i++) {
			ER1172KetersediaanSinkingFund eEnum = ER1172KetersediaanSinkingFund.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
