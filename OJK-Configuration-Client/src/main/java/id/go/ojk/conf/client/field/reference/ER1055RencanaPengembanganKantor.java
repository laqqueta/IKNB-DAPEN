package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1055RencanaPengembanganKantor implements IObject<KeyValueString> {
	R_PKE1 ("PK:e01", "Pembukaan"),
	R_PKE2 ("PK:e02", "Perubahan Alamat"),
	R_PKE3 ("PK:e03", "Penutupan"),
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
		for (ER1055RencanaPengembanganKantor eEnum : ER1055RencanaPengembanganKantor.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1055RencanaPengembanganKantor.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1055RencanaPengembanganKantor.class.getSimpleName().substring(2, 6));
	}
}
