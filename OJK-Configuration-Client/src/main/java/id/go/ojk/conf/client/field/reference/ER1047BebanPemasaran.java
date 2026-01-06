package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1047BebanPemasaran implements IObject<KeyValueString> {
	R_51 ("51", "Beban Pemasaran"),
	R_52 ("52", "Beban Umum dan Administrasi (Pegawai)"),
	R_53 ("53", "Beban Umum dan Administrasi (Pengurus)"),
	R_54 ("54", "Beban Umum dan Administrasi (Diklat Pegawai)"),
	R_55 ("55", "Beban Umum dan Administrasi (Diklat Pengurus)"),
	R_99 ("99", "Beban Umum dan Administrasi (Lainnya)"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1047BebanPemasaran eEnum : ER1047BebanPemasaran.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1047BebanPemasaran.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1047BebanPemasaran.class.getSimpleName().substring(2, 6));
	}
}
