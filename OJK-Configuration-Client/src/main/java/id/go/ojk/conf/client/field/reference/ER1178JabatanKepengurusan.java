package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1178JabatanKepengurusan implements IObject<KeyValueString> {
	R_1 ("KR:e8", "Komisaris Utama"),
	R_2 ("KR:e9", "Komisaris"),
	R_3 ("KR:e34", "Komisaris Independen"),
	R_4 ("KR:e35", "Dewan Pengawas Syariah"),
	R_5 ("KR:e10", "Direktur Utama"),
	R_6 ("KR:e11", "Direktur"),
	R_7 ("KR:e42", "Pimpinan Unit Usaha Syariah"),
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
		for (ER1178JabatanKepengurusan eEnum : ER1178JabatanKepengurusan.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1178JabatanKepengurusan.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1178JabatanKepengurusan.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getPiped(List<Integer> except) {
		StringBuilder res = new StringBuilder();
		ER1178JabatanKepengurusan[] eEnums = ER1178JabatanKepengurusan.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			if (except.contains(i)) {
				res.append(ER1178JabatanKepengurusan.values()[i].key).append("|");
			}
		}
		String tmp = res.toString();
		return tmp.endsWith("|") ? tmp.substring(0, tmp.length() - 1) : tmp;
	}
	
	public static String getPipedExcept(List<Integer> except) {
		StringBuilder res = new StringBuilder();
		ER1178JabatanKepengurusan[] eEnums = ER1178JabatanKepengurusan.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			if (!except.contains(i)) {
				res.append(ER1178JabatanKepengurusan.values()[i].key).append("|");
			}
		}
		String tmp = res.toString();
		return tmp.endsWith("|") ? tmp.substring(0, tmp.length() - 1) : tmp;
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1178JabatanKepengurusan[] eEnums = ER1178JabatanKepengurusan.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1178JabatanKepengurusan eEnum = ER1178JabatanKepengurusan.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
