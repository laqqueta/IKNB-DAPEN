package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1157LokasiDati1 implements IObject<KeyValueString> {
    R_1 ("LO:e11", "Aceh"),
    R_2 ("LO:e12", "Sumatera Utara"),
    R_3 ("LO:e13", "Sumatera Barat"),
    R_4 ("LO:e14", "Riau"),
    R_5 ("LO:e15", "Jambi"),
    R_6 ("LO:e16", "Sumatera Selatan"),
    R_7 ("LO:e17", "Bengkulu"),
    R_8 ("LO:e18", "Lampung"),
    R_9 ("LO:e19", "Kepulauan Bangka Belitung"),
    R_10 ("LO:e21", "Kepulauan Riau"),
    R_11 ("LO:e31", "DKI Jakarta"),
    R_12 ("LO:e32", "Jawa Barat"),
    R_13 ("LO:e33", "Jawa Tengah"),
    R_14 ("LO:e34", "Daerah Istimewa Yogyakarta"),
    R_15 ("LO:e35", "Jawa Timur"),
    R_16 ("LO:e36", "Banten"),
    R_17 ("LO:e51", "Bali "),
    R_18 ("LO:e52", "Nusa Tenggara Barat"),
    R_19 ("LO:e53", "Nusa Tenggara Timur"),
    R_20 ("LO:e61", "Kalimantan Barat"),
    R_21 ("LO:e62", "Kalimantan Tengah"),
    R_22 ("LO:e63", "Kalimantan Selatan"),
    R_23 ("LO:e64", "Kalimantan Timur"),
    R_24 ("LO:e65", "Kalimantan Utara"),
    R_25 ("LO:e71", "Sulawesi Utara"),
    R_26 ("LO:e72", "Sulawesi Tengah"),
    R_27 ("LO:e73", "Sulawesi Selatan"),
    R_28 ("LO:e74", "Sulawesi Tenggara"),
    R_29 ("LO:e75", "Gorontalo"),
    R_30 ("LO:e76", "Sulawesi Barat"),
    R_31 ("LO:e81", "Maluku"),
    R_32 ("LO:e82", "Maluku Utara"),
    R_33 ("LO:e91", "Papua"),
    R_34 ("LO:e92", "Papua Barat"),
    R_35 ("LO:e93", "Papua Selatan "),
    R_36 ("LO:e94", "Papua Tengah "),
    R_37 ("LO:e95", "Papua Pegunungan"),
    R_38 ("LO:e96", "Papua Barat Daya"),
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
		for (ER1157LokasiDati1 eEnum : ER1157LokasiDati1.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1157LokasiDati1.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1157LokasiDati1.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1157LokasiDati1[] eEnums = ER1157LokasiDati1.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1157LokasiDati1 eEnum = ER1157LokasiDati1.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
