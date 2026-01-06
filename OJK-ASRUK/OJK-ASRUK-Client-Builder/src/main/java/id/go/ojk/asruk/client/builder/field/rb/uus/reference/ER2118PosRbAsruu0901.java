package id.go.ojk.asruk.client.builder.field.rb.uus.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2118PosRbAsruu0901 implements IObject<KeyValueString> {
//	R_0901010000 ("0901010000", "A. Pembukaan"),
	R_0901010100 ("0901010100", "1. Kantor yang memiliki kewenangan menerima atau menolak penutupan asuransi syariah, menandatangani polis, menetapkan untuk membayar atau menolak klaim"),
	R_0901010200 ("0901010200", "2. Kantor yang tidak memiliki kewenangan menerima atau menolak penutupan asuransi syariah, menandatangani polis, menetapkan untuk membayar atau menolak klaim"),
//	R_0901020000 ("0901020000", "B. Perubahan Alamat"),
	R_0901020100 ("0901020100", "1"),
//	R_0901030000 ("0901030000", "C. Penutupan "),
	R_0901030100 ("0901030100", "1"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2118PosRbAsruu0901 eEnum : ER2118PosRbAsruu0901.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2118PosRbAsruu0901.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2118PosRbAsruu0901.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static ConditionalRequired genConditionalField() {
		return UtilFieldConditional.genAllExist("M", "N", "2");
	}
}
