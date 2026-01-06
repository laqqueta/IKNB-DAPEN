package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1054JenisKegiatanUsaha implements IObject<KeyValueString> {
	R_KUE01 ("KU:e01", "Rencana Pelaksanaan Kegiatan Berbasis Fee yang Wajib Terlebih Dahulu Dilaporkan kepada OJK"),
	R_KUE02 ("KU:e02", "Rencana Penggunaan Akad yang belum Digunakan Sebelumnya yang Wajib Terlebih Dahulu Dilaporkan kepada OJK"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1054JenisKegiatanUsaha eEnum : ER1054JenisKegiatanUsaha.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1054JenisKegiatanUsaha.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1054JenisKegiatanUsaha.class.getSimpleName().substring(2, 6));
	}
}
