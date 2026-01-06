package id.go.ojk.fins.client.builder.field;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormLaporanBulanan {
	LB_0000 ("0000", "Profil Perusahaan"),
	LB_0001 ("0001", "Rincian Escrow Account"),
	LB_0002 ("0002", "Rincian Payment Gateway"),
	LB_0003 ("0003", "Rincian E-Wallet"),
	LB_1100 ("1100", "Laporan Posisi Keuangan"),
	LB_1200 ("1200", "Laporan Laba/Rugi"),
	LB_1201 ("1201", "Laporan Perubahan Ekuitas"),
	LB_1300 ("1300", "Laporan Arus Kas"),
	LB_8800 ("8800", "Catatan Atas Laporan Keuangan"),
	LB_6901 ("6901", "Inclusivity"),
	LB_6902 ("6902", "Transaction Value"),
	LB_6903 ("6903", "Kualitas Pendanaan, Biaya Modal, Manfaat Efektif Ekonomi, Velocity/Tempo, Sektor Produktif, Informasi terkait dengan Kerjasama Penyaluran Pendanaan, lainnya"),
	LB_2907 ("2907", "Detail Outstanding Penyelenggara"),
	LB_6908 ("6908", "Data Kualitas Pendanaan Outstanding"),
	LB_6910 ("6910", "Data Hapus Buku & Hapus Tagih dan Klaim Asuransi/Penjaminan"),
	LB_6909 ("6909", "Laporan Kegiatan Yang Telah Dilakukan"),
	LB_2111 ("2111", "Rincian Kas dan Setara Kas"),
	LB_2112 ("2112", "Rincian Piutang Lancar Lainnya"),
	LB_2116 ("2116", "Rincian Aset Tak Berwujud"),
	LB_2113 ("2113", "Rincian Piutang Tidak Lancar Lainnya"),
	LB_2114 ("2114", "Rincian Utang Jangka Pendek Lainnya"),
	LB_2115 ("2115", "Rincian Utang Jangka Panjang Lainnya"),
	LB_2117 ("2117", "Rincian Biaya yang masih harus dibayar"),
	LB_2120 ("2120", "Rincian Pendapatan Komisi Platform"),
	LB_2121 ("2121", "Rincian Pendapatan Denda"),
	LB_2119 ("2119", "Rincian Pendapatan Non Operasional"),
	LB_2118 ("2118", "Rincian Beban Pemasaran dan Periklanan"),
	LB_2913 ("2913", "Rincian Beban Pengembangan dan Pemeliharaan IT"),
	LB_2310 ("2310", "Rincian Laporan Arus Kas"),
	LB_2910 ("2910", "Rincian Pendanaan yang Dihapus Buku dan Dihapus Tagih"),
	LB_2122 ("2122", "Rincian Penggunaan Asuransi/Penjaminan"),
	LB_2911 ("2911", "Rincian Pengalihan Kuasa Penagihan Kepada Penyelenggara Jasa Penagihan Pihak Ketiga"),
	LB_2912 ("2912", "Rincian Pendanaan Outstanding"),
	;
	
	@Getter
	private String code;
	@Getter
	private String name;
}
