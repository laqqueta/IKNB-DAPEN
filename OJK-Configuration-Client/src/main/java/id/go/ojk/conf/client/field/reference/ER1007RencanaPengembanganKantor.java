package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1007RencanaPengembanganKantor implements IObject<KeyValueString> {
	R_PKE1 ("PK:e1", "Peningkatan Status Kantor Selain Kantor Cabang Menjadi Kantor Cabang"),
	R_PKE2 ("PK:e2", "Peningkatan Status Kantor Selain Kantor Cabang UUS Menjadi Kantor Cabang UUS"),
	R_PKE3 ("PK:e3", "Perubahan Alamat"),
	R_PKE4 ("PK:e4", "Penutupan"),
	R_PKE10 ("PK:e10", "Pembukaan"),
	;

	private String key;
	private String value;
	
	public String getKey() {
		return key;
	}
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1007RencanaPengembanganKantor eEnum : ER1007RencanaPengembanganKantor.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1007RencanaPengembanganKantor.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1007RencanaPengembanganKantor.class.getSimpleName().substring(2, 6));
	}
}
