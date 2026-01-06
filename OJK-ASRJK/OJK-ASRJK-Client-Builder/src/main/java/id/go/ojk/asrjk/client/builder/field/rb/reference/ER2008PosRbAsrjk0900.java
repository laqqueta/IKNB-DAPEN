package id.go.ojk.asrjk.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2008PosRbAsrjk0900 implements IObject<KeyValueString> {
//	R_0901000000 ("0901000000", "Pembukaan"),
	R_0901010000 ("0901010000", "Kantor yang memiliki kewenangan menerima atau menolak penutupan asuransi, menandatangani polis, menetapkan untuk membayar atau menolak klaim"),
	R_0901020000 ("0901020000", "Kantor yang tidak memiliki kewenangan menerima atau menolak penutupan asuransi, menandatangani polis, menetapkan untuk membayar atau menolak klaim"),
//	R_0902000000 ("0902000000", "Pemindahan Alamat"),
	R_0902010000 ("0902010000", "Pemindahan Alamat"),
//	R_0903000000 ("0903000000", "Penutupan Kantor"),
	R_0903010000 ("0903010000", "Penutupan Kantor"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2008PosRbAsrjk0900 eEnum : ER2008PosRbAsrjk0900.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2008PosRbAsrjk0900.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2008PosRbAsrjk0900.class.getSimpleName().substring(2, 6));
	}
	
	public static ConditionalRequired genConditionalField() {
		return UtilFieldConditional.genAllExist("M", "N", "2");
	}
}
