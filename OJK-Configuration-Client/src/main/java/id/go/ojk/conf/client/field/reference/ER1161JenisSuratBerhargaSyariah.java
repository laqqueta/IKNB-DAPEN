package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1161JenisSuratBerhargaSyariah implements IObject<KeyValueString> {
	R_1 ("JI:e7", "Saham"),
	R_2 ("JI:e75", "Sertifikat Deposito pada Bank Syariah"),
	R_3 ("JI:e76", "Sertifikat Bank Indonesia SBI Syariah"),
	R_4 ("JI:e77", "Surat Berharga Komersial CP syariah"),
	R_5 ("JI:e78", "Medium Term Notes MTN Syariah"),
	R_6 ("JI:e79", "Reksadana Syariah"),
	R_7 ("JI:e80", "Obligasi syariah/Sukuk"),
	R_8 ("JI:e84", "Surat Perbendaharaan Negara SPN"),
	R_9 ("JI:e85", "Wesel Ekspor"),
	R_10 ("JI:e86", "Obligasi Negara ON"),
	R_11 ("JI:e87", "Obligasi Ritel Indonesia ORI"),
	R_12 ("JI:e81", "Surat Berharga Lainnya Berdasarkan Prinsip Syariah"),
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
		for (ER1161JenisSuratBerhargaSyariah eEnum : ER1161JenisSuratBerhargaSyariah.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1161JenisSuratBerhargaSyariah.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1161JenisSuratBerhargaSyariah.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1161JenisSuratBerhargaSyariah[] eEnums = ER1161JenisSuratBerhargaSyariah.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1161JenisSuratBerhargaSyariah eEnum = ER1161JenisSuratBerhargaSyariah.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
