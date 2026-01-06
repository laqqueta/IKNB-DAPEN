package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1177JenisSuratBerhargaLPEI implements IObject<KeyValueString> {
	R_1 ("BJ:e128","Surat berharga yang diterbitkan Pemerintah (SBN)"),
	R_2 ("BJ:e129","Sertifikat Bank Indonesia (SBI)"),
	R_3 ("BJ:e130","Surat berharga yang diterbitkan oleh pemerintah negara donor"),
	R_4 ("BJ:e131","Surat berharga yang diterbitkan oleh lembaga keuangan multilateral"),
	R_5 ("BJ:e132","Lainnya"),
	R_6 ("BJ:e133","Surat berharga syariah yang diterbitkan Pemerintah (SBSN)"),
	R_7 ("BJ:e134","Sertifikat Bank Indonesia Syariah (SBI Syariah)"),
	R_8 ("BJ:e135","Surat berharga syariah yang diterbitkan oleh pemerintah negara donor"),
	R_9 ("BJ:e136","Surat berharga syariah yang diterbitkan oleh lembaga keuangan multilateral"),
	;

	private String key;
	private String value;

	public String getKey() {
		return key;
	}

	@Override
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1177JenisSuratBerhargaLPEI eEnum : ER1177JenisSuratBerhargaLPEI.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return "JenisSuratBerharga";
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER1177JenisSuratBerhargaLPEI.class.getSimpleName().substring(2, 6));
	}

	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String getPipedKey(int[] selected) {
		return UtilMetadata.genPipeRow(getObjects(), selected);
	}

	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1177JenisSuratBerhargaLPEI[] eEnums = ER1177JenisSuratBerhargaLPEI.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1177JenisSuratBerhargaLPEI eEnum = ER1177JenisSuratBerhargaLPEI.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
