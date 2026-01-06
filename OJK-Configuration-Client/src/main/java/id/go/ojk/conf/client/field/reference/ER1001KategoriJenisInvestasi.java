package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1001KategoriJenisInvestasi implements IObject<KeyValueString> {
	R_BUK ("BUK", "Bank Umum Konvensional (BUK)"),
	R_BUS ("BUS", "Bank Umum Syariah (BUS)"),
	R_BPRK ("BPRK", "BPR Konvensional (BPRK)"),
	R_BPRS ("BPRS", "BPR Syariah (BPRS)"),
	R_IDX30 ("IDX30", "IDX30"),
	R_JII ("JII", "JII"),
	R_NON ("NON", "Investasi Saham Selain IDX30 dan JII"),
	R_MTN ("MTN", "MTN"),
	R_MTNS ("MTNS", "MTN Syariah"),
	R_HTM ("HTM", "Surat Berharga yang Dimiliki Hingga Jatuh Tempo"),
	R_AFT ("AFT", "Surat Berharga yang Diperdagangkan"),
	R_AFS ("AFS", "Surat Berharga yang Tersedia untuk Dijual"),
	R_SUN ("SUN", "Sepenuhnya surat utang pemerintah"),
	R_OBG ("OBG", "Sepenuhnya surat utang swasta atau surat berharga pasar"),
	R_EQT ("EQT", "Sepenuhnya surat berharga ekuitas"),
	R_MXD ("MXD", "Campuran"),
	R_RDPT ("RDPT", "Reksa Dana Penyertaan Terbatas"),
	R_USPV ("USPV", "Dalam Pengawasan OJK"),
	R_NSPV ("NSPV", "Tidak Dalam Pengawasan OJK"),
	R_LND ("LND", "Tanah"),
	R_BLD ("BLD", "Bangunan"),
	R_LNB ("LNB", "Tanah dan Bangunan"),
	R_PRES ("PRES", "Properti Residensial"),
	R_PCOM ("PCOM", "Properti Komersial Lainnya"),
	R_PNUS ("PNUS", "Properti Yang Tidak Digunakan"),
	R_APL ("APL", "APL"),
	R_NAPL ("NAPL", "Non APL"),
	R_KSEI ("KSEI", "KSEI"),
	R_BIS4 ("BIS4", "BIS4"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1001KategoriJenisInvestasi eEnum : ER1001KategoriJenisInvestasi.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1001KategoriJenisInvestasi.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1001KategoriJenisInvestasi.class.getSimpleName().substring(2, 6));
	}
}
