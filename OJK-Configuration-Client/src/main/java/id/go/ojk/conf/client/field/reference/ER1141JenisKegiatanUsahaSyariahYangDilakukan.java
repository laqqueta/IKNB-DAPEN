package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1141JenisKegiatanUsahaSyariahYangDilakukan implements IObject<KeyValueString> {
	R_1 ("AK:e56", "pemberian pinjaman langsung (direct lending) untuk pembiayaan infrastruktur berdasarkan prinsip syariah neto"),
	R_2 ("AK:e57", "refinancing atas Infrastruktur yang telah dibiayai pihak lain  berdasarkan prinsip syariah neto"),
	R_3 ("AK:e58", "pemberian pembiayaan subordinasi yang berkaitan dengan pembiayaan infrastruktur  berdasarkan prinsip syariah neto"),
	R_4 ("AK:e59", "kegiatan atau pemberian fasilitas lain yang berkaitan dengan pembiayaan infrastruktur setelah memperoleh persetujuan Otoritas Jasa Keuangan  berdasarkan prinsip syariah neto"),
	R_5 ("AK:e60", "kegiatan atau pemberian fasilitas lain yang tidak berkaitan dengan pembiayaan infrastruktur berdasarkan penugasan pemerintah  berdasarkan prinsip syariah neto"),
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
		for (ER1141JenisKegiatanUsahaSyariahYangDilakukan eEnum : ER1141JenisKegiatanUsahaSyariahYangDilakukan.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1141JenisKegiatanUsahaSyariahYangDilakukan.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1141JenisKegiatanUsahaSyariahYangDilakukan.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1141JenisKegiatanUsahaSyariahYangDilakukan[] eEnums = ER1141JenisKegiatanUsahaSyariahYangDilakukan.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1141JenisKegiatanUsahaSyariahYangDilakukan eEnum = ER1141JenisKegiatanUsahaSyariahYangDilakukan.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
