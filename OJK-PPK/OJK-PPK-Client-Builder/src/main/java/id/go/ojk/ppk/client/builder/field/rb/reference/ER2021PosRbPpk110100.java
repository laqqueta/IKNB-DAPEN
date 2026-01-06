package id.go.ojk.ppk.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2021PosRbPpk110100 implements IObject<KeyValueString> {
	R_11010100000000 ("11010100000000", "Gearing Ratio (kali)"),
	R_11010200000000 ("11010200000000", "Penyertaan Modal/Ekuitas (%)"),
	R_11010300000000 ("11010300000000",
			"Rasio Saldo Piutang Pembiayaan (Outstanding Principal) Neto terhadap Total Aset (Financing to Asset Ratio) (%)"),
	R_11010400000000 ("11010400000000",
			"Rasio Saldo Piutang Pembiayaan (Outstanding Principal) Neto terhadap Total Pendanaan yang Diterima (%)"),
	R_11010500000000 ("11010500000000",
			"Rasio Saldo Piutang Pembiayaan (Outstanding Principal) untuk Pembiayaan Investasi dan Pembiayaan Modal Kerja Dibandingkan dengan Total Saldo Piutang Pembiayaan (Outstanding Principal) Sebelum Dikurangi Cadangan Penyisihan Penghapusan Piutang Pembiayaan yang Telah Dibentuk (%)"),
	R_11010600000000 ("11010600000000", "Modal Sendiri/Modal Disetor (%)"),
	R_11010700000000 ("11010700000000", "Rasio Permodalan (%)"),
	R_11010800000000 ("11010800000000", "NPF Gross (%)"), 
	R_11010900000000 ("11010900000000", "NPF Netto (%)"),
	R_11011000000000 ("11011000000000", "ROE (%)"), 
	R_11011100000000 ("11011100000000", "ROA (%)"),
	R_11011200000000 ("11011200000000", "BOPO (%)"), 
	R_11011300000000 ("11011300000000", "NIM (%)"),
	R_11011400000000 ("11011400000000", "Current Ratio (%)"),
	R_11011500000000 ("11011500000000", "Cash Ratio (%)"),;

	@Getter
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2021PosRbPpk110100 eEnum : ER2021PosRbPpk110100.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2021PosRbPpk110100.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2021PosRbPpk110100.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}
}
