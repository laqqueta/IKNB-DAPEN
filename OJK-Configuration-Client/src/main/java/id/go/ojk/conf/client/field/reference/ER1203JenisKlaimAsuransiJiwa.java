package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1203JenisKlaimAsuransiJiwa implements IObject<KeyValueString> {
	R_100 ("100", "Habis Kontrak"),
	R_200 ("200", "Meninggal"),
	R_300 ("300", "Nilai Tunai"),
	R_400 ("400", "Kesehatan"),
	R_500 ("500", "Personal Accident"),
	R_600 ("600", "Lainnya"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1203JenisKlaimAsuransiJiwa eEnum : ER1203JenisKlaimAsuransiJiwa.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1203JenisKlaimAsuransiJiwa.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1203JenisKlaimAsuransiJiwa.class.getSimpleName().substring(2, 6));
	}
}