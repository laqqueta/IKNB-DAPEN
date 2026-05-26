package id.go.ojk.conf.client.field.reference;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1250Properti implements IObject<KeyValueString> {

	R_PR1("2001", "Tanah"),
	R_PR2("2005", "Bangunan"),
	R_PR3("2010", "Tanah & Bangunan"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1250Properti eEnum : ER1250Properti.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER1250Properti.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER1250Properti.class.getSimpleName().substring(2, 6));
	}

	public static String getKey(String key) {
		Optional<ER1250Properti> keys = Arrays.stream(ER1250Properti.values())
				.filter(v -> v.key.equalsIgnoreCase(key))
				.findFirst();

        return keys.map(er1250Properti -> er1250Properti.key).orElse(null);
    }

	public static String getKeyValue(String key) {
		Optional<ER1250Properti> keys = Arrays.stream(ER1250Properti.values())
				.filter(v -> v.key.equalsIgnoreCase(key))
				.findFirst();

		return keys.map(er1250Properti -> er1250Properti.key + " - " + er1250Properti.value)
				.orElse(null);
	}

	public static String getPipedReferenceKeys() {
		List<String> keys = Arrays.stream(ER1250Properti.values())
				.map(k -> k.key + "|")
				.collect(Collectors.toList());

		// remove last pipe
		String lastElem = keys.get(keys.size() - 1);
		keys.set(keys.size() - 1, lastElem.substring(0, lastElem.length() - 1));

		return String.join("", keys);
	}

	public static String getPipedReferenceKeys(ER1250Properti addProp) {
		List<String> keys = Arrays.stream(ER1250Properti.values())
				.map(k -> k.key + "|")
				.collect(Collectors.toList());

		keys.add(addProp.key + "|");

		// remove last pipe
		String lastElem = keys.get(keys.size() - 1);
		keys.set(keys.size() - 1, lastElem.substring(0, lastElem.length() - 1));

		return String.join("", keys);
	}

	public static String getPipedReferenceKeyValues() {
		List<String> keys = Arrays.stream(ER1250Properti.values())
				.map(k -> k.key + " - " + k.value + "|")
				.collect(Collectors.toList());

		// remove last pipe
		String lastElem = keys.get(keys.size() - 1);
		keys.set(keys.size() - 1, lastElem.substring(0, lastElem.length() - 1));

		return String.join("", keys);
	}

	public static String getPipedReferenceKeyValues(ER1250Properti addProp) {
		List<String> keys = Arrays.stream(ER1250Properti.values())
				.map(k -> k.key + " - " + k.value + "|")
				.collect(Collectors.toList());

		keys.add(addProp.key + " - " + addProp.value + "|");

		// remove last pipe
		String lastElem = keys.get(keys.size() - 1);
		keys.set(keys.size() - 1, lastElem.substring(0, lastElem.length() - 1));


		return String.join("", keys);
	}

	public static void main(String[] args) {
		System.out.println(getKeyValue("2010"));
	}
}
