package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1130RupaRupaliabilitas implements IObject<KeyValueString> {
	R_1 ("RK:e27", "Beban Bunga yang masih harus dibayar"),
	R_2 ("RK:e67", "Beban Margin/Bagi Hasil/Imbal Jasa yang Masih Harus Dibayar"),
	R_3 ("RK:e68", "Utang Gaji"),
	R_4 ("RK:e57", "Dividen yang Belum Dibayar"),
	R_5 ("RK:e58", "Liabilitas Pajak Penghasilan"),
	R_6 ("RK:e29", "Pendapatan yang ditangguhkan"),
	R_7 ("RK:e59", "Liabilitas Imbal Kerja"),
	R_8 ("RK:e64", "Utang Asuransi"),
	R_9 ("RK:e65", "Utang Dealer"),
	R_10 ("RK:e33", "Jenis Rupa-Rupa Liabilitas Lainnya"),
	R_11 ("RK:e71", "Rekening Antar Kantor"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1130RupaRupaliabilitas eEnum : ER1130RupaRupaliabilitas.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1130RupaRupaliabilitas.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1130RupaRupaliabilitas.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1130RupaRupaliabilitas[] eEnums = ER1130RupaRupaliabilitas.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1130RupaRupaliabilitas eEnum = ER1130RupaRupaliabilitas.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
