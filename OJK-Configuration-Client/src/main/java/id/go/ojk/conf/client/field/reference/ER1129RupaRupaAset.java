package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1129RupaRupaAset implements IObject<KeyValueString> {
	R_1 ("RK:e60", "Biaya Dibayar dimuka"),
	R_2 ("RK:e66", "Aset Istishna dalam Penyelesaian"),
	R_3 ("RK:e61", "Biaya yg ditangguhkan"),
	R_4 ("RK:e20", "Uang muka pajak"),
	R_5 ("RK:e62", "Pinjaman Pegawai"),
	R_6 ("RK:e26", "Jenis Rupa-Rupa Aset Lainnya"),
	R_7 ("RK:e69", "Rekening Antar Kantor"),
	R_8 ("RK:e70", "Agunan Yang Diambil Alih (AYDA)"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1129RupaRupaAset eEnum : ER1129RupaRupaAset.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return "Rupa-RupaAset";
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1129RupaRupaAset.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1129RupaRupaAset[] eEnums = ER1129RupaRupaAset.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1129RupaRupaAset eEnum = ER1129RupaRupaAset.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
