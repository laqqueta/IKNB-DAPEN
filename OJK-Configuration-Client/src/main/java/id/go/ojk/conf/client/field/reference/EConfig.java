package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EConfig implements IObject<KeyValueString> {
	SUMMARY_START_YEAR_MONTH ("AC.summaryStartYearMonth", "201604"),
	MIN_ALL_DATE ("AC.minAllDate", "19000101"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		KeyValueString res = new KeyValueString(key, value, null);
		return res;
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (EConfig eEnum : EConfig.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
}
