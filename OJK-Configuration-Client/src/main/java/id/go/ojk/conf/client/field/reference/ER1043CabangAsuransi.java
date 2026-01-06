package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1043CabangAsuransi implements IObject<KeyValueString> {
	R_KTO ("KTO", "Kematian berjangka selain ekawarsa"),
	R_DWG ("DWG", "Dwiguna"),
	R_DWC ("DWC", "Dwiguna Kombinasi"),
	R_LFT ("LFT", "Seumur Hidup"),
	R_LFC ("LFC", "Seumur Hidup Kombinasi"),
	R_GAN ("GAN", "Anuitas Umum"),
	R_PAN ("PAN", "Anuitas Dana Pensiun"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1043CabangAsuransi eEnum : ER1043CabangAsuransi.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1043CabangAsuransi.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1043CabangAsuransi.class.getSimpleName().substring(2, 6));
	}
}
