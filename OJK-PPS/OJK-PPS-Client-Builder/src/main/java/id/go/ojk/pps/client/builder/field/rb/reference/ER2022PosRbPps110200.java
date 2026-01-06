package id.go.ojk.pps.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2022PosRbPps110200 implements IObject<KeyValueString> {
	R_11020100000000 ("11020100000000", "Gearing Ratio (kali)"),
	R_11020200000000 ("11020200000000", "Penyertaan Modal/Ekuitas (%)"),
	R_11020300000000 ("11020300000000", "Rasio Saldo Aset Produktif (Outstanding Principal) Neto terhadap Total Aset (Financing to Asset Ratio) (%)"),
	R_11020400000000 ("11020400000000", "Rasio Saldo Aset Produktif (Outstanding Principal) Neto terhadap Total Pendanaan yang Diterima (%)"),
	R_11020500000000 ("11020500000000", "Rasio Saldo Aset Produktif (Outstanding Principal) untuk Tujuan Usaha Produktif Dibandingkan dengan Total Saldo Aset Produktif (Outstanding Principal) Sebelum Dikurangi Cadangan Penyisihan Penghapusan Aset Produktif yang Telah Dibentuk (%)"),
	R_11020600000000 ("11020600000000", "Modal Sendiri/Modal Disetor (%)"),
	R_11020700000000 ("11020700000000", "Rasio Permodalan (%)"),
	R_11020800000000 ("11020800000000", "Rasio Aset Produktif Bermasalah Gross (%)"),
	R_11020900000000 ("11020900000000", "Rasio Aset Produktif Bermasalah Netto (%)"),
	R_11021000000000 ("11021000000000", "ROE (%)"),
	R_11021100000000 ("11021100000000", "ROA (%)"),
	R_11021200000000 ("11021200000000", "BOPO (%)"),
	R_11021300000000 ("11021300000000", "NIM (%)"),
	R_11021400000000 ("11021400000000", "Current Ratio (%)"),
	R_11021500000000 ("11021500000000", "Cash Ratio (%)"),
	;

	@Getter
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2022PosRbPps110200 eEnum : ER2022PosRbPps110200.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2022PosRbPps110200.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2022PosRbPps110200.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}
}
