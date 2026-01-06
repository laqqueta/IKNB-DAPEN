package id.go.ojk.reass.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2013PosRbReass0901 implements IObject<KeyValueString> {
//	R_0901010000 ("0901010000", "A. Pembukaan"),
	R_0901010100 ("0901010100", "1. Kantor yang memiliki kewenangan menerima atau menolak penutupan asuransi syariah, menandatangani polis, menetapkan untuk membayar atau menolak klaim"),
	R_0901010200 ("0901010200", "2. Kantor yang tidak memiliki kewenangan menerima atau menolak penutupan asuransi syariah, menandatangani polis, menetapkan untuk membayar atau menolak klaim"),
//	R_0901020000 ("0901020000", "B. Perubahan Alamat"),
	R_0901020100 ("0901020100", "Perubahan Alamat"),
//	R_0901030000 ("0901030000", "C. Penutupan "),
	R_0901030100 ("0901030100", "Penutupan"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2013PosRbReass0901 eEnum : ER2013PosRbReass0901.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2013PosRbReass0901.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2013PosRbReass0901.class.getSimpleName().substring(2, 6));
	}

	public static ConditionalRequired genConditionalField() {
		return UtilFieldConditional.genAllExist("M", "N", "2");
	}
}
