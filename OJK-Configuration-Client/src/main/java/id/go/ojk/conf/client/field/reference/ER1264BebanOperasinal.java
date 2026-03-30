package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1264BebanOperasinal implements IObject<KeyValueString> {

    R_BBOP1("BP01", "Beban Gaji/Honor Karyawan, Pengurus, dan Dewan Pengawas"),
    R_BBOP2("BP02", "Beban Kantor"),
    R_BBOP3("BP03", "Beban Pemeliharaan"),
    R_BBOP4("BP04", "Beban Penyusutan"),
    R_BBOP5("BP05", "Beban Jasa Pihak Ketiga"),
    R_BBOP6("BP06", "Beban Pendidikan dan Pelatihan"),
    R_BBOP7("BP07", "Beban Operasional Lain"),
    ;

    private String key;
    private String value;

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[]{});
    }

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER1264BebanOperasinal eEnum : ER1264BebanOperasinal.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static String getName() {
        return ER1264BebanOperasinal.class.getSimpleName().substring(6);
    }

    public static int getRefNumber() {
        return Integer.parseInt(ER1264BebanOperasinal.class.getSimpleName().substring(2, 6));
    }

	public static String getReferenceIndex(int index) {
		StringBuilder res = new StringBuilder();
		ER1264BebanOperasinal[] eEnums = ER1264BebanOperasinal.values();
		for (int i= 0; i < eEnums.length; i++) {
			if (i == index) {
				res.append(ER1264BebanOperasinal.values()[i].key);
				break;
			}
		}
		return res.toString();
	}

    public static String getPipedReferenceKeys() {
        List<String> keys = Arrays.stream(ER1264BebanOperasinal.values())
                .map(k -> k.key + "|")
                .collect(Collectors.toList());

        // remove last pipe
        String lastElem = keys.get(keys.size() - 1);
        keys.set(keys.size() - 1, lastElem.substring(0, lastElem.length() - 1));

        return String.join("", keys);
    }

    public static String getPipedReferenceKeyValues() {
        List<String> keys = Arrays.stream(ER1264BebanOperasinal.values())
                .map(k -> k.key + " - " + k.value + "|")
                .collect(Collectors.toList());

        // remove last pipe
        String lastElem = keys.get(keys.size() - 1);
        keys.set(keys.size() - 1, lastElem.substring(0, lastElem.length() - 1));

        return String.join("", keys);
    }

	public static String getPipedReferenceKeys(String filter) {
		List<String> keys = Arrays.stream(ER1264BebanOperasinal.values())
				.filter(k -> {
					String[] filters = filter.split("\\|");
					for (String s : filters) {
						if (k.key.equals(s)) {
							return true;
						}
					}

					return false;
				})
				.map(k -> k.key + "|")
				.collect(Collectors.toList());

		// remove last pipe
		String lastElem = keys.get(keys.size() - 1);
		keys.set(keys.size() - 1, lastElem.substring(0, lastElem.length() - 1));

		return String.join("", keys);
	}

	public static String getPipedReferenceKeyValues(String filter) {
		List<String> keys = Arrays.stream(ER1264BebanOperasinal.values())
				.filter(k -> {
					String[] filters = filter.split("\\|");
					for (String s : filters) {
						if (k.key.equals(s)) {
							return true;
						}
					}

					return false;
				})
				.map(k -> k.key + " - " + k.value + "|")
				.collect(Collectors.toList());

		// remove last pipe
		String lastElem = keys.get(keys.size() - 1);
		keys.set(keys.size() - 1, lastElem.substring(0, lastElem.length() - 1));

		return String.join("", keys);
	}
}
