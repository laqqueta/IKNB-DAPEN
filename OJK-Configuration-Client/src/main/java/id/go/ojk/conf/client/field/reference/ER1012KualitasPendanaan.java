package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1012KualitasPendanaan implements IObject<KeyValueString> {
	R_1 ("1", "Tingkat pertama, yaitu apabila DPPK yang menyelenggarakan PPMP berada dalam keadaan Dana Terpenuh"),
	R_2 ("2", "Tingkat kedua, yaitu apabila Kekayaan untuk Pendanaan kurang dari Nilai Kini Aktuarial dan tidak kurang dari Liabilitas Solvabilitas"),
	R_3 ("3", "ingkat ketiga, yaitu apabila Kekayaan untuk Pendanaan kurang dari Liabilitas Solvabilitas"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1012KualitasPendanaan eEnum : ER1012KualitasPendanaan.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1012KualitasPendanaan.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1012KualitasPendanaan.class.getSimpleName().substring(2, 6));
	}
}
