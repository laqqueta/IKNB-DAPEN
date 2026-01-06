package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1026KategoriUtang implements IObject<KeyValueString> {
	R_EKW ("EKW", "Ekawarsa"),
	R_KTB ("KTB", "Kematian Berjangka"),
	R_DWG ("DWG", "Dwiguna"),
	R_DWK ("DWK", "Dwiguna Kombinasi"),
	R_LFT ("LFT", "Seumur Hidup"),
	R_LFC ("LFC", "Seumur Hidup Kombinasi"),
	R_GAN ("GAN", "Anuitas Umum"),
	R_PAN ("PAN", "Anuitas Dana Pensiun"),
	R_ACD ("ACD", "Kecelakaan Diri"),
	R_HLT ("HLT", "Kesehatan"),
	R_LO_IDN ("LO_IDN", "Dalam Negeri (Indonesia)"),
	R_LO_E1 ("LO_e1", "Luar Negeri"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1026KategoriUtang eEnum : ER1026KategoriUtang.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1026KategoriUtang.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1026KategoriUtang.class.getSimpleName().substring(2, 6));
	}
}
