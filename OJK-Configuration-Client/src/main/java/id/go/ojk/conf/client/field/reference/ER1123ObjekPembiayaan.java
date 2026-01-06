package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1123ObjekPembiayaan implements IObject<KeyValueString> {
	R_1 ("BJ:e1301", "infrastruktur transportasi;"),
	R_2 ("BJ:e1311", "Infrastruktur jalan;"),
	R_3 ("BJ:e1321", "infrastruktur sumber daya air dan irigasi;"),
	R_4 ("BJ:e1331", "infrastruktur air minum;"),
	R_5 ("BJ:e1341", "infrastruktur sistem pengelolaan air limbah terpusat;"),
	R_6 ("BJ:e1351", "infrastruktur sistem pengelolaan air limbah setempat;"),
	R_7 ("BJ:e1361", "infrastruktur sistem pengelolaan persampahan;"),
	R_8 ("BJ:e1371", "infrastruktur telekomunikasi dan informatika;"),
	R_9 ("BJ:e1381", "infrastruktur ketenagalistrikan;"),
	R_10 ("BJ:e1391", "infrastruktur minyak dan gas bumi dan energi terbarukan;"),
	R_11 ("BJ:e1401", "infrastruktur konservasi energi;"),
	R_12 ("BJ:e1411", "infrastruktur fasilitas perkotaan;"),
	R_13 ("BJ:e1421", "infrastruktur fasilitas pendidikan;"),
	R_14 ("BJ:e1431", "infrastruktur fasilitas sarana dan prasarana olahraga, serta kesenian"),
	R_15 ("BJ:e1441", "infrastruktur kawasan;"),
	R_16 ("BJ:e1451", "infrastruktur pariwisata;"),
	R_17 ("BJ:e1461", "infrastruktur kesehatan;"),
	R_18 ("BJ:e1471", "infrastruktur lembaga pemasyarakatan;"),
	R_19 ("BJ:e1481", "infrastruktur perumahan rakyat;"),
	R_20 ("BJ:e1491", "infrastruktur bangunan negara; dan"),
	R_21 ("BJ:e1501", "infrastruktur lain"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1123ObjekPembiayaan eEnum : ER1123ObjekPembiayaan.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1123ObjekPembiayaan.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1123ObjekPembiayaan.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1123ObjekPembiayaan[] eEnums = ER1123ObjekPembiayaan.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1123ObjekPembiayaan eEnum = ER1123ObjekPembiayaan.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
