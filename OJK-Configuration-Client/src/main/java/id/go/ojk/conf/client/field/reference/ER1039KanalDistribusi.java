package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1039KanalDistribusi implements IObject<KeyValueString> {
	R_100 ("100", "Direct Marketing "),
	R_200 ("200", "Agen Asuransi"),
	R_300 ("300", "Bancassurance"),
	R_400 ("400", "BUSB (Perusahaan Pembiayaan)"),
	R_500 ("500", "BUSB (Lainnya)"),
	R_600 ("600", "Tenaga Pemasar"),
	R_700 ("700", "Pialang Asuransi"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1039KanalDistribusi eEnum : ER1039KanalDistribusi.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1039KanalDistribusi.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1039KanalDistribusi.class.getSimpleName().substring(2, 6));
	}
}
