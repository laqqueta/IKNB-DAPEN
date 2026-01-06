package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1024SumberAsetReasuransi implements IObject<KeyValueString> {
	R_01 ("01", "Nilai Estimasi Pemulihan Klaim Pertanggungan Ulang"),
	R_02 ("02", "Perjanjian Kontrak Jangka Panjang Program Reas Dukungan Modal"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1024SumberAsetReasuransi eEnum : ER1024SumberAsetReasuransi.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1024SumberAsetReasuransi.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1024SumberAsetReasuransi.class.getSimpleName().substring(2, 6));
	}
}
