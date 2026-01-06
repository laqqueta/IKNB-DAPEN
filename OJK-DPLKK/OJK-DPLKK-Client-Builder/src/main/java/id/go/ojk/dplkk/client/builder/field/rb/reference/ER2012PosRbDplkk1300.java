package id.go.ojk.dplkk.client.builder.field.rb.reference;

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
public enum ER2012PosRbDplkk1300 implements IObject<KeyValueString> {
//	R_1301000000 ("1301000000", "A. Pembukaan"),
	R_1301010000 ("1301010000", "Pembukaan"),
//	R_1302000000 ("1302000000", "B. Perubahan Status"),
	R_1302010000 ("1302010000", "Perubahan Status"),
//	R_1303000000 ("1303000000", "C. Penggabungan"),
	R_1303010000 ("1303010000", "Penggabungan"),
//	R_1304000000 ("1304000000", "D. Pemindahan Alamat"),
	R_1304010000 ("1304010000", "Pemindahan Alamat"),
//	R_1305000000 ("1305000000", "E. Penutupan Kantor"),
	R_1305010000 ("1305010000", "Penutupan Kantor"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2012PosRbDplkk1300 eEnum : ER2012PosRbDplkk1300.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2012PosRbDplkk1300.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2012PosRbDplkk1300.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects(), 0, 0);
	}
	
	public static ConditionalRequired genConditionalAllExist() {
		return UtilFieldConditional.genAllExist("M", "N", "2");
	}
}
