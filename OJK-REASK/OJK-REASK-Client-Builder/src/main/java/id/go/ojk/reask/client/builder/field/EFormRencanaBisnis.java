package id.go.ojk.reask.client.builder.field;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormRencanaBisnis {
	RB_0104 ("0104", "Rincian Eksekutif (Indikator Keuangan Utama)"),
	RB_0105 ("0105", "Rasio Keuangan"),
	RB_0201 ("0201", "Perbandingan Antara Rencana Bisnis Periode Sebelumnya"),
	RB_0400 ("0400", "Rencana Pengembangan Produk dan Pemasaran Produk Asuransi bagi Perusahaan Asuransi atau Rencana Pengembangan Program Pertanggungan Ulang bagi Perusahaan Reasuransi untuk 1 (Satu) Tahun Ke Depan"),
	RB_0500 ("0500", "Rencana Pengembangan Atau Perluasan Kegiatan Usaha"),
	RB_0601 ("0601", "Komposisi Investasi"),
	RB_0602 ("0602", "Hasil Investasi"),
	RB_0702 ("0702", "Proyeksi Permodalan"),
	RB_0900 ("0900", "Rencana Pengembangan dan/atau Perubahan Jaringan Kantor"),
	RB_1002 ("1002", "Uraian Mengenai Rencana Pemenuhan Sumber Daya Manusia"),
	RB_1003 ("1003", "Rencana Pelaksanaan Pendidikan dan Pelatihan SDM untuk Direksi, Dewan Komisaris, dan Pegawai"),
	RB_1004 ("1004", "Rencana Penggunaan Tenaga Kerja Asing"),
	RB_1005 ("1005", "Rencana Pemanfaatan Tenaga Kerja Alih Daya"),
	RB_1006 ("1006", "Rencana Pengembangan Sistem Teknologi Informasi"),
	RB_1301 ("1301", "Proyeksi Posisi Keuangan Untuk Perusahaan Asuransi Umum"),
	RB_1304 ("1304", "Proyeksi Laba/Rugi Komprehensif Untuk Perusahaan Asuransi Umum"),
	RB_1307 ("1307", "Proyeksi Arus Kas Untuk Perusahaan Asuransi Umum"),
	RB_1310 ("1310", "Proyeksi Rasio-Rasio dan Pos-Pos Tertentu Lainnya Untuk Perusahaan Asuransi Umum"),
	RB_1313 ("1313", "Asumsi Yang Digunakan"),
	RB_9001 ("9001", "Surat Pengantar"),
	RB_9002 ("9002", "Rencana Bisnis"),
	RB_9003 ("9003", "Rencana Aksi Keuangan Berkelanjutan (RAKB)"),
	;

	@Getter
	private String code;
	@Getter
	private String name;
}
