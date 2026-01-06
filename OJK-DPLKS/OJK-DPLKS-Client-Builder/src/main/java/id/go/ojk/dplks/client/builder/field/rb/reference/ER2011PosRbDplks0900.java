package id.go.ojk.dplks.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2011PosRbDplks0900 implements IObject<KeyValueString> {
//	R_0901000000 ("0901000000", "A. Pembukaan"),
	R_0901010000 ("0901010000", "Pembukaan"),
//	R_0902000000 ("0902000000", "B. Perubahan Status"),
	R_0902010000 ("0902010000", "Perubahan Status"),
//	R_0903000000 ("0903000000", "C. Penggabungan"),
	R_0903010000 ("0903010000", "Penggabungan"),
//	R_0904000000 ("0904000000", "D. Pemindahan Alamat"),
	R_0904010000 ("0904010000", "Pemindahan Alamat"),
//	R_0905000000 ("0905000000", "E. Penutupan Kantor"),
	R_0905010000 ("0905010000", "Penutupan Kantor"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2011PosRbDplks0900 eEnum : ER2011PosRbDplks0900.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2011PosRbDplks0900.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2011PosRbDplks0900.class.getSimpleName().substring(2, 6));
	}

	public static ConditionalRequired genConditionalAllExist() {
		return UtilFieldConditional.genAllExist("M", "N", "2");
	}
}
