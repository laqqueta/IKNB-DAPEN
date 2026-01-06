package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1166JenisKegiatanUsahaYangDilakukan implements IObject<KeyValueString> {
	R_1 ("AK:e51","Pemberian pinjaman langsung (direct lending)"),
	R_2 ("AK:e52","Refinancing atas Infrastruktur yang telah dibiayai pihak lain"),
	R_3 ("AK:e53","Pemberian pembiayaan subordinasi"),
	R_4 ("AK:e54","Kegiatan atau pemberian fasilitas lain yang berkaitan dengan pembiayaan dengan memperoleh persetujuan Otoritas Jasa Keuangan"),
	R_5 ("AK:e55","Kegiatan atau pemberian fasilitas lain yang tidak berkaitan dengan pembiayaan berdasarkan penugasan pemerintah"),
	R_6 ("AK:e56","Pemberian pinjaman langsung (direct lending) prinsip syariah neto"),
	R_7 ("AK:e57","Refinancing berdasarkan prinsip syariah neto"),
	R_8 ("AK:e58","Pemberian pembiayaan subordinasi yang berdasarkan prinsip syariah neto"),
	R_9 ("AK:e59","Kegiatan atau pemberian fasilitas lain yang berkaitan dengan pembiayaan setelah memperoleh persetujuan Otoritas Jasa Keuangan berdasarkan prinsip syariah neto"),
	R_10 ("AK:e60","Kegiatan atau pemberian fasilitas lain yang tidak berkaitan dengan pembiayaan berdasarkan penugasan pemerintah berdasarkan prinsip syariah neto"),
	R_11 ("AK:e61","Kegiatan dalam rangka pembiayaan bersama (sindikasi)"),
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
		for (ER1166JenisKegiatanUsahaYangDilakukan eEnum : ER1166JenisKegiatanUsahaYangDilakukan.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1166JenisKegiatanUsahaYangDilakukan.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1166JenisKegiatanUsahaYangDilakukan.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1166JenisKegiatanUsahaYangDilakukan[] eEnums = ER1166JenisKegiatanUsahaYangDilakukan.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1166JenisKegiatanUsahaYangDilakukan eEnum = ER1166JenisKegiatanUsahaYangDilakukan.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
