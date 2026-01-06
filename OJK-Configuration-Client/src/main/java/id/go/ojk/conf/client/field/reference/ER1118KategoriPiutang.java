package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1118KategoriPiutang implements IObject<KeyValueString> {
	R_1 ("JK:e68", "Restrukturisasi"),
	R_2 ("JK:e69", "Non Restrukturisasi"),
	R_3 ("JK:e72", "Restrukturisasi khusus"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1118KategoriPiutang eEnum : ER1118KategoriPiutang.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1118KategoriPiutang.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1118KategoriPiutang.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1118KategoriPiutang[] eEnums = ER1118KategoriPiutang.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1118KategoriPiutang eEnum = ER1118KategoriPiutang.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
