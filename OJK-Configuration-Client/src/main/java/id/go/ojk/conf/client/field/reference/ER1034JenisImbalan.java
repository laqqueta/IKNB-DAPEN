package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1034JenisImbalan implements IObject<KeyValueString> {
	R_DPLK ("DPLK", "Dana Pensiun Lembaga Keuangan (DPLK)"),
	R_SVC ("SVC", "Jasa Manajemen"),
	R_FEE ("FEE", "Fee Penjualan Reksadana"),
	R_ASO ("ASO", "Jasa Administrasi (ASO)"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1034JenisImbalan eEnum : ER1034JenisImbalan.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1034JenisImbalan.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1034JenisImbalan.class.getSimpleName().substring(2, 6));
	}
}
