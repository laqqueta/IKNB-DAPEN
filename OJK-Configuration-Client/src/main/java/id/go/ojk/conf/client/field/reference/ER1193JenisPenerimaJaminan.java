package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1193JenisPenerimaJaminan implements IObject<KeyValueString> {
	R_1 ("EN:eJPJM1", "Bank"),
	R_2 ("EN:eJPJM2", "Perusahaan Pembiayaan"),
	R_3 ("EN:eJPJM3", "Perusahaan Modal Ventura"),
	R_4 ("EN:eJPJM4", "PT Permodalan Nasional Madani"),
	R_5 ("EN:eJPJM5", "Lembaga Pembiayaan Ekspor Indonesia"),
	R_6 ("EN:eJPJM6", "Perusahaan Pergadaian"),
	R_7 ("EN:eJPJM7", "Koperasi"),
	R_8 ("EN:eJPJM8", "Lembaga Keuangan Mikro"),
	R_9 ("EN:eJPJM9", "Lembaga Keuangan Lainnya"),
	R_10 ("EN:eJPJM10", "Non Lembaga Keuangan"),
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
		for (ER1193JenisPenerimaJaminan eEnum : ER1193JenisPenerimaJaminan.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1193JenisPenerimaJaminan.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1193JenisPenerimaJaminan.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1193JenisPenerimaJaminan[] eEnums = ER1193JenisPenerimaJaminan.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1193JenisPenerimaJaminan eEnum = ER1193JenisPenerimaJaminan.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
