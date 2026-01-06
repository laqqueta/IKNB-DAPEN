package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1023KategoriJenisNonInvestasi implements IObject<KeyValueString> {
	R_101 ("101", "Deposito"),
	R_102 ("102", "Sertifikat Deposito"),
	R_103 ("103", "Saham"),
	R_104 ("104", "Obligasi Korporasi"),
	R_105 ("105", "MTN"),
	R_106 ("106", "Surat Berharga yang Diterbitkan oleh Negara RI "),
	R_107 ("107", "Surat Berharga yang Diterbitkan oleh Negara Selain Negara RI "),
	R_108 ("108", "Surat Berharga yang Diterbitkan oleh Bank Indonesia"),
	R_109 ("109", "Surat Berharga yang Diterbitkan oleh Lembaga Multinasional"),
	R_110 ("110", "Reksa Dana"),
	R_111 ("111", "Efek Beragun Aset (EBA)"),
	R_112 ("112", "Dana Investasi Real Estat"),
	R_113 ("113", "REPO"),
	R_114 ("114", "Penyertaan Langsung"),
	R_115 ("115", "Tanah, Bangunan dengan Hak Strata, atau Tanah dengan Bangunan, untuk Investasi"),
	R_116 ("116", "Pembiayaan Melalui Kerjasama dengan Pihak Lain (Executing)"),
	R_117 ("117", "Emas Murni"),
	R_118 ("118", "Pinjaman yang Dijamin dengan Hak Tanggungan"),
	R_119 ("119", "Pinjaman Polis"),
	R_999 ("999", "Investasi Lain"),
	R_LO_IDN ("LO_IDN", "Dalam Negeri (Indonesia)"),
	R_LO_e1 ("LO_e1", "Luar Negeri"),
	R_CSH ("CSH", "Kas"),
	R_SIDN ("SIDN", "Tabungan Dalam Negeri"),
	R_SE1 ("Se1", "Tabungan Luar Negeri"),
	R_EKW ("EKW", "Ekawarsa"),
	R_KTB ("KTB", "Kematian Berjangka"),
	R_DWG ("DWG", "Dwiguna"),
	R_DWK ("DWK", "Dwiguna Kombinasi"),
	R_LFT ("LFT", "Seumur Hidup"),
	R_LFC ("LFC", "Seumur Hidup Kombinasi"),
	R_GAN ("GAN", "Anuitas Umum"),
	R_PAN ("PAN", "Anuitas Dana Pensiun"),
	R_ACD ("ACD", "Kecelakaan Diri"),
	R_HLT ("HLT", "Kesehatan"),
	R_DLL ("DLL", "Lainnya"),
	R_CUS ("CUS", "Tertanggung"),
	R_PGA ("PGA", "Pialang Asuransi"),
	R_TPK ("TPK", "Tagihan Premi Koasuransi"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1023KategoriJenisNonInvestasi eEnum : ER1023KategoriJenisNonInvestasi.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1023KategoriJenisNonInvestasi.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1023KategoriJenisNonInvestasi.class.getSimpleName().substring(2, 6));
	}
}
