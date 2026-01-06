package id.go.ojk.ppis.client.builder.field;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormLaporanBulanan {
	LB_0000 ("0000", "Informasi Profil Perusahaan Pembiayaan Infrastruktur"),
	LB_0010 ("0010", "Rincian Izin Usaha"),
	LB_0020 ("0020", "Rincian Kantor Cabang"),
	LB_0030 ("0030", "Rincian Pemegang Saham dan Pemegang Saham Derajat Kedua"),
	LB_0035 ("0035", "Rincian Kepengurusan"),
	LB_0036 ("0036", "Rincian Pihak Terkait"),
	LB_0041 ("0041", "Rincian Tenaga Kerja Berdasarkan Tingkat Pendidikan"),
	LB_0043 ("0043", "Rincian Tenaga Kerja Berdasarkan Fungsi"),
	LB_0046 ("0046", "Rincian Tenaga Kerja Asing"),
	LB_1100 ("1100", "Laporan Posisi Keuangan"),
	LB_1110 ("1110", "Rekening Administratif"),
	LB_1200 ("1200", "Laporan Laba Rugi dan Penghasilan Komprehensif Lain"),
	LB_1300 ("1300", "Laporan Arus Kas"),
	LB_2100 ("2100", "Rincian Pembiayaan yang Diberikan"),
	LB_2150 ("2150", "Rincian Aset Ijarah"),
	LB_2200 ("2200", "Rincian Surat Berharga yang Dimiliki"),
	LB_2300 ("2300", "Rincian Penyertaan Modal"),
	LB_2350 ("2350", "Rincian Tagihan terkait Pemberian Jasa Konsultasi"),
	LB_2380 ("2380", "Rincian Tagihan terkait Proyek Pemulihan Ekonomi Nasional (PEN)"),
	LB_2490 ("2490", "Rincian Rupa-Rupa Aset"),
	LB_2550 ("2550", "Rincian Pinjaman/Pendanaan yang Diterima"),
	LB_2600 ("2600", "Rincian Surat Berharga yang Diterbitkan"),
	LB_2790 ("2790", "Rincian Rupa-Rupa Liabilitas"),
	LB_3010 ("3010", "Rincian Instrumen Derivatif untuk Lindung Nilai"),
	LB_5310 ("5310", "Laporan Analisis Kesesuaian Aset dan Liabilitas"),
	;
	
	@Getter
	private String code;
	@Getter
	private String name;
}
