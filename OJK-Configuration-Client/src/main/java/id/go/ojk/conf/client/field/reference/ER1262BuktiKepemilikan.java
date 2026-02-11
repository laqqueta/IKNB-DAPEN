package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1262BuktiKepemilikan implements IObject<KeyValueString> {

	R_BK1("SHM", "Sertifikat Hak Milik ( SHM )"),
	R_BK2("SHSRS", "Sertifikat Hak Satuan Rumah Susun (SHSRS)/strata title"),
	R_BK3("SHGB", "Sertifikat Hak Guna Bangunan (SHGB)"),
	R_BK4("GRK", "Girik"),
	R_BK5("AJB", "Akta Jual Beli (AJB)"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1262BuktiKepemilikan eEnum : ER1262BuktiKepemilikan.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER1262BuktiKepemilikan.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER1262BuktiKepemilikan.class.getSimpleName().substring(2, 6));
	}
}
