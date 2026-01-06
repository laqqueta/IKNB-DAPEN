package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1154JenisSuratBerharga implements IObject<KeyValueString> {
	R_1 ("JI:e42", "Sertifikat Deposito"),
	R_2 ("JI:e4", "Sertifikat Bank Indonesia (SBI)"),
	R_3 ("JI:e8", "Surat Berharga Komersial (CP)"),
	R_4 ("JI:e9", "Medium Term Notes (MTN)"),
	R_5 ("JI:e11", "Reksadana"),
	R_6 ("JI:e84", "Surat Perbendaharaan Negara (SPN)"),
	R_7 ("JI:e85", "Wesel Ekspor"),
	R_8 ("JI:e86", "Obligasi Negara (ON)"),
	R_9 ("JI:e87", "Obligasi Ritel Indonesia (ORI)"),
	R_10 ("JI:e74", "Surat Berharga Lainnya"),
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
		for (ER1154JenisSuratBerharga eEnum : ER1154JenisSuratBerharga.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1154JenisSuratBerharga.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1154JenisSuratBerharga.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1154JenisSuratBerharga[] eEnums = ER1154JenisSuratBerharga.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1154JenisSuratBerharga eEnum = ER1154JenisSuratBerharga.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
