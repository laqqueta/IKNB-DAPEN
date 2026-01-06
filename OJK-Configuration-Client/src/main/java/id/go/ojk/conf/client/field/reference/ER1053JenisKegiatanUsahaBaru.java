package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1053JenisKegiatanUsahaBaru implements IObject<KeyValueString> {
	R_KBE01 ("KB:e01", "Rencana Pelaksanaan Kegiatan Usaha Lain yang Wajib Terlebih Dahulu Memperoleh Persetujuan OJK"),
	R_KBE02 ("KB:e02", "Rencana Pengelolaan Dana Ventura yang Wajib Terlebih Dahulu Memperoleh Persetujuan OJK"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1053JenisKegiatanUsahaBaru eEnum : ER1053JenisKegiatanUsahaBaru.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1053JenisKegiatanUsahaBaru.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1053JenisKegiatanUsahaBaru.class.getSimpleName().substring(2, 6));
	}
}
