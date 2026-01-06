package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1042JenisLiabilitas implements IObject<KeyValueString> {
	R_01 ("01", "Utang Klaim"),
	R_02 ("02", "Utang koasuransi"),
	R_03 ("03", "Utang reasuransi"),
	R_04 ("04", "Utang komisi"),
	R_05 ("05", "Biaya yang harus dibayar"),
	R_99 ("99", "Utang lain"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1042JenisLiabilitas eEnum : ER1042JenisLiabilitas.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1042JenisLiabilitas.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1042JenisLiabilitas.class.getSimpleName().substring(2, 6));
	}
}
