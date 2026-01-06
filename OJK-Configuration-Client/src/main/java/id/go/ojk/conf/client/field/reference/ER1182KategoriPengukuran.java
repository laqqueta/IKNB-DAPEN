package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1182KategoriPengukuran implements IObject<KeyValueString> {
	R_1 ("TJ:e11", "Fair value to profit and loss (FFVTPL)"),
	R_2 ("TJ:e12", "Fair value to other comprehensive income (FVOCI)"),
	R_3 ("TJ:e13", "Biaya Perolehan Diamortisasi"),
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
		for (ER1182KategoriPengukuran eEnum : ER1182KategoriPengukuran.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1182KategoriPengukuran.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1182KategoriPengukuran.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1182KategoriPengukuran[] eEnums = ER1182KategoriPengukuran.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1182KategoriPengukuran eEnum = ER1182KategoriPengukuran.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
