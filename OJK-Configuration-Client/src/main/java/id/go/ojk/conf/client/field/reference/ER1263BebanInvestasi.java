package id.go.ojk.conf.client.field.reference;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1263BebanInvestasi implements IObject<KeyValueString> {

	R_BBIV1("BI01", "Beban Transaksi"),
	R_BBIV2("BI02", "Beban Pemeliharaan Tanah dan Bangunan"),
	R_BBIV3("BI03", "Beban Penyusutan Bangunan"),
	R_BBIV4("BI04", "Beban Manajer Investasi"),
	R_BBIV5("BI05", "Beban Kustodi"),
	R_BBIV6("BI06", "Beban Investasi Lain"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1263BebanInvestasi eEnum : ER1263BebanInvestasi.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER1263BebanInvestasi.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER1263BebanInvestasi.class.getSimpleName().substring(2, 6));
	}

	public static String getReferenceIndex(int index) {
		StringBuilder res = new StringBuilder();
		ER1263BebanInvestasi[] eEnums = ER1263BebanInvestasi.values();
		for (int i= 0; i < eEnums.length; i++) {
			if (i == index) {
				res.append(ER1263BebanInvestasi.values()[i].key);
				break;
			}
		}
		return res.toString();
	}

	public static String getPipedReferenceKeys() {
		List<String> keys = Arrays.stream(ER1263BebanInvestasi.values())
				.map(k -> k.key + "|")
				.collect(Collectors.toList());

		// remove last pipe
		String lastElem = keys.get(keys.size() - 1);
		keys.set(keys.size() - 1, lastElem.substring(0, lastElem.length() - 1));

		return String.join("", keys);
	}

	public static String getPipedReferenceKeyValues() {
		List<String> keys = Arrays.stream(ER1263BebanInvestasi.values())
				.map(k -> k.key + " - " + k.value + "|")
				.collect(Collectors.toList());

		// remove last pipe
		String lastElem = keys.get(keys.size() - 1);
		keys.set(keys.size() - 1, lastElem.substring(0, lastElem.length() - 1));

		return String.join("", keys);
	}
}
