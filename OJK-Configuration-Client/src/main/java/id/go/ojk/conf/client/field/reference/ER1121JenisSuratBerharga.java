package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1121JenisSuratBerharga implements IObject<KeyValueString> {
	R_1 ("JI:e2", "Obligasi"),
	R_2 ("JI:e4", "Sertifikat Bank Indonesia SBI"),
	R_3 ("JI:e5", "Promes/aksep"),
	R_4 ("JI:e6", "Wesel"),
	R_5 ("JI:e7", "Saham"),
	R_6 ("JI:e8", "Surat berharga komersial CP"),
	R_7 ("JI:e9", "Medium Term Notes MTN"),
	R_8 ("JI:e10", "Floating Rate Notes FRN"),
	R_9 ("JI:e11", "Reksadana"),
	R_10 ("JI:e42", "Sertifikat Deposito"),
	R_11 ("JI:e84", "Surat Perbendaharaan Negara SPN"),
	R_12 ("JI:e85", "Wesel Ekspor"),
	R_13 ("JI:e86", "Obligasi Negara ON"),
	R_14 ("JI:e87", "Obligasi Ritel Indonesia ORI"),
	R_15 ("JI:e74", "Surat Berharga Lainnya"),
	R_16 ("JI:e25", "Obligasi Syariah/Sukuk"),
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
		for (ER1121JenisSuratBerharga eEnum : ER1121JenisSuratBerharga.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1121JenisSuratBerharga.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1121JenisSuratBerharga.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getPipedKey(int[] selected) {
		return UtilMetadata.genPipeRow(getObjects(), selected);
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1121JenisSuratBerharga[] eEnums = ER1121JenisSuratBerharga.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1121JenisSuratBerharga eEnum = ER1121JenisSuratBerharga.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
