package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1255JenisManfaat implements IObject<KeyValueString> {

	R_JM1("MP1", "Manfaat Pensiun"),
	R_JM2("MP2", "Manfaat Pensiun - LCF"),
	R_JM3("MP3", "Manfaat Pensiun - Non LCF"),
	R_JM4("MPL1", "Manfaat Tambahan"),
	R_JM5("MPL2", "Kompensasi Pasca Kerja"),
	R_JM6("MPL3", "Lainnya"),
	R_JM7("ML1", "Kompensasi Pasca Kerja"),
	R_JM8("ML2", "Kesehatan"),
	R_JM9("ML3", "Santunan Kematian"),
	R_JM10("ML4", "Ibadah Keagamaan"),
	R_JM11("ML5", "Pendidikan"),
	R_JM12("ML6", "Lainnya"),
	R_JM13("UUS1", "Manfaat Pensiun UUS"),
	R_JM14("UUS2", "Manfaat Pensiun Lainnya UUS"),
	R_JM15("UUS3", "Manfaat Lain UUS"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1255JenisManfaat eEnum : ER1255JenisManfaat.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER1255JenisManfaat.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER1255JenisManfaat.class.getSimpleName().substring(2, 6));
	}
}
