package id.go.ojk.pps.client.builder.field;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormRencanaBisnis {
	RB_010402 ("010402", "Form 1.4.b - Rincian Eksekutif (Indikator Keuangan)"),
	RB_040102 ("040102", "Form 4.1.b - Rencana Kegiatan Usaha (Rencana Penyaluran Pembiayaan Syariah Berdasarkan Jenis Pembiayaan bagi Perusahaan Pembiayaan Syariah dan UUS Perusahaan Pembiayaan)"),
	RB_040201 ("040201", "Form 4.2.a - Rencana Kegiatan Usaha (Rencana Penyaluran Pembiayaan Syariah kepada Konsumen Inti)"),
	RB_040301 ("040301", "Form 4.3.a - Rencana Kegiatan Usaha (Rencana Penyaluran Pembiayaan Syariah kepada Pihak Terkait)"),
	RB_040401 ("040401", "Form 4.4.a - Rencana Kegiatan Usaha (Rencana Penyaluran Pembiayaan Syariah Berdasarkan Sektor Ekonomi)"),
	RB_040501 ("040501", "Form 4.5.a - Rencana Kegiatan Usaha (Rencana Penyaluran Pembiayaan Syariah Berdasarkan Lokasi Pembiayaan Syariah)"),
	RB_050101 ("050101", "Form 5.1.a - Rencana Pengembangan atau Perluasan Kegiatan Usaha (Rencana Penggunaan Akad Lain dan Rencana Perubahan Fitur dari Kegiatan Usaha Pembiayaan Syariah yang Dilakukan dengan Menggunakan Akad yang Sebelumnya Telah Disetujui oleh Otoritas Jasa Keua"),
	RB_050201 ("050201", "Form 5.2.a -  Rencana Pengembangan atau Perluasan Kegiatan Usaha (Rencana Penggunaan Akad yang Belum Pernah Digunakan Sebelumnya, Rencana Perubahan Fitur dari Kegiatan Usaha Pembiayaan Syariah yang dilakukan dengan Menggunakan Akad yang Sebelumnya Telah D"),
	RB_060101 ("060101", "Form 6.1.a - Rencana Permodalan (Rencana Pemenuhan Rasio Permodalan)"),
	RB_060200 ("060200", "Form 6.2 - Rencana Permodalan (Proyeksi Permodalan)"),
	RB_070102 ("070102", "Form 7.1.b - Rencana Pendanaan (Rencana Pendanaan Berdasarkan Sumber Pendanaan bagi Perusahaan Pembiayaan)"),
	RB_070201 ("070201", "Form 7.2.a - Rencana Pendanaan (Rencana Pendanaan Berdasarkan Mata Uang)"),
	RB_070301 ("070301", "Form 7.3.a - Rencana Pendanaan (Rencana Pendanaan berdasarkan Akad Pendanaan bagi Perusahaan Pembiayaan Syariah dan UUS Perusahaan Pembiayaan)"),
	RB_080000 ("080000", "Form 8 - Rencana Pengembangan dan/atau Perubahan Jaringan Kantor atau Saluran Distribusi"),
	RB_090202 ("090202", "Form 9.2.b - Rencana Pengembangan Organisasi, Sumber Daya Manusia, dan/atau Teknologi Informasi (Rencana Pendidikan dan Pelatihan Sumber Daya Manusia)"),
	RB_090203 ("090203", "Form 9.2.c - Rencana Pengembangan Organisasi, Sumber Daya Manusia, dan/atau Teknologi Informasi (Rencana Penggunaan Tenaga Kerja Asing)"),
	RB_090204 ("090204", "Form 9.2.d - Rencana Pengembangan Organisasi, Sumber Daya Manusia, dan/atau Teknologi Informasi (Rencana Pemanfaatan Tenaga Kerja Alih Daya)"),
	RB_100100 ("100100", "Form 10.1 - Proyeksi Laporan Keuangan Beserta Asumsi yang Digunakan (Asumsi Makro dan Mikro yang Digunakan)"),
	RB_100202 ("100202", "Form 10.2.b - Proyeksi Laporan Keuangan Beserta Asumsi yang Digunakan (Proyeksi Laporan Posisi Keuangan Perusahaan Pembiayaan Syariah dan UUS Perusahaan Pembiayaan)"),
	RB_100302 ("100302", "Form 10.3.b - Proyeksi Laporan Keuangan Beserta Asumsi yang Digunakan (Proyeksi Laba/Rugi Komprehensif Perusahaan Pembiayaan Syariah dan UUS Perusahaan Pembiayaan)"),
	RB_100402 ("100402", "Form 10.4.b - Proyeksi Laporan Keuangan Beserta Asumsi yang Digunakan (Proyeksi Laporan Arus Kas Perusahaan Pembiayaan Syariah dan UUS Perusahaan Pembiayaan)"),
	RB_100502 ("100502", "Form 10.5.b - Proyeksi Laporan Keuangan Beserta Asumsi yang Digunakan (Proyeksi Rekening Administratif Perusahaan Pembiayaan Syariah dan Unit Usaha Syariah Perusahaan Pembiayaan)"),
	RB_110200 ("110200", "Form 11.2 - Proyeksi Rasio dan Pos Tertentu"),
	RB_120100 ("120100", "Form 12.1 - Rencana Penyertaan Langsung (Rincian Rencana Penyertaan Langsung)"),
	RB_900001 ("900001", "Surat Pengantar"),
	RB_900002 ("900002", "Rencana Bisnis"),
	RB_900003 ("900003", "Rencana Aksi Keuangan Berkelanjutan (RAKB)"),
	;

	@Getter
	private String code;
	@Getter
	private String name;
}
