package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1110BidangSpesialisasi implements IObject<KeyValueString> {
	R_1 ("KR:e25", "Pemasaran"),
	R_2 ("KR:e26", "Analisis Kelayakan Pembiayaan"),
	R_3 ("KR:e39", "Penagihan"),
	R_4 ("KR:e27", "Human Resource (HR) dan General Affair (GA)"),
	R_5 ("KR:e43", "Administrasi dan Pembukuan"),
	R_6 ("KR:e29", "Manajemen Risiko"),
	R_7 ("KR:e30", "Audit Internal"),
	R_8 ("KR:e31", "Legal"),
	R_9 ("KR:e32", "Teknologi Informasi (IT)"),
	R_10 ("KR:e45", "Anti Pencucian Uang dan Pencegahan Pendanaan Terorisme"),
	R_11 ("KR:e46", "Pengelolaan portofolio investasi"),
	R_12 ("KR:e47", "Spesialisasi lainnya"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1110BidangSpesialisasi eEnum : ER1110BidangSpesialisasi.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1110BidangSpesialisasi.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1110BidangSpesialisasi.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1110BidangSpesialisasi[] eEnums = ER1110BidangSpesialisasi.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1110BidangSpesialisasi eEnum = ER1110BidangSpesialisasi.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
