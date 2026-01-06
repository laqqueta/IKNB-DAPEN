package id.go.ojk.lpei.client.builder.field;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormLaporanBulanan {
	LB_0000 ("0000", "Informasi Profil LPEI"),
	LB_0020 ("0020", "Rincian Kantor di Luar Kantor Pusat"),
	LB_0035 ("0035", "Rincian Kepengurusan"),
	LB_0041 ("0041", "Rincian Tenaga Kerja Berdasarkan Tingkat Pendidikan"),
	LB_0043 ("0043", "Rincian Tenaga Kerja Berdasarkan Fungsi"),
	LB_0046 ("0046", "Rincian Tenaga Kerja Asing"),
	LB_1000 ("1000", "Laporan Kualitas Aset"),
	LB_1100 ("1100", "Laporan Posisi Keuangan"),
	LB_1110 ("1110", "Rekening Administratif"),
	LB_1200 ("1200", "Laporan Laba Rugi dan Penghasilan Komprehensif Lain"),
	LB_1300 ("1300", "Laporan Arus Kas"),
	LB_2000 ("2000", "Rincian Penempatan pada Bank Indonesia"),
	LB_2050 ("2050", "Rincian Penempatan pada Bank"),
	LB_2100 ("2100", "Rincian Pembiayaan yang Diberikan"),
	LB_2150 ("2150", "Rincian Aset Ijarah"),
	LB_2200 ("2200", "Rincian Surat Berharga yang Dimiliki"),
	LB_2300 ("2300", "Rincian Penyertaan Modal"),
	LB_2350 ("2350", "Rincian Aset Reasuransi"),
	LB_2400 ("2400", "Rincian Tagihan Derivatif"),
	LB_2450 ("2450", "Rincian Akseptasi"),
	LB_2490 ("2490", "Rincian Rupa – Rupa Aset"),
	LB_2550 ("2550", "Rincian Pendanaan yang Diterima"),
	LB_2600 ("2600", "Rincian Surat Berharga yang Diterbitkan"),
	LB_2700 ("2700", "Rincian Liabilitas Derivatif"),
	LB_2730 ("2730", "Rincian Liabilitas Akseptasi"),
	LB_2760 ("2760", "Rincian Klaim Liabilitas Asuransi dan Penjaminan"),
	LB_2790 ("2790", "Rincian Rupa – Rupa Liabilitas"),
	LB_5200 ("5200", "Laporan Retensi Sendiri Penutupan Asuransi dan Penjaminan"),
	LB_5250 ("5250", "Laporan Posisi Devisa Neto"),
	LB_5310 ("5310", "Laporan Analisis Kesesuaian Aset dan Liablitas"),
	LB_DHE01 ("DHE01", "Laporan Penerimaan Devisa Hasil Ekspor"),
	LB_9001 ("9001", "Surat Pengantar"),
	;
	
	@Getter
	private String code;
	@Getter
	private String name;
}
