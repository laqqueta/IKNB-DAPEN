package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1011Program implements IObject<KeyValueString> {
	R_PPIP ("PPIP", "Dana Pensiun Pemberi Kerja - Program Pensiun Iuran Pasti, program pensiun yang iurannya ditetapkan dalam PDP dan seluruh iuran serta hasil pengembangannya dibukukan pada rekening masing- masing peserta sebagai Manfaat Pensiun"),
	R_PPMP ("PPMP", "Dana Pensiun Pemberi Kerja - Program Pensiun Manfaat Pasti, program pensiun yang manfaatnya ditetapkan dalam PDP atau program pensiun lain yang bukan merupakan program pensiun iuran pasti."),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1011Program eEnum : ER1011Program.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1011Program.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1011Program.class.getSimpleName().substring(2, 6));
	}
}
