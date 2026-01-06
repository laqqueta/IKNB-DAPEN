package id.go.ojk.pps.client.builder.field;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormRealisasiBisnis {
	RE_010402 ("010402", "Form 1.4.b - Rincian Eksekutif (Indikator Keuangan"),
	RE_040102 ("040102", "Form 4.1.b - Realisasi Rencana Kegiatan Usaha (Rencana Penyaluran Pembiayaan Syariah Berdasarkan Jenis Pembiayaan bagi Perusahaan Pembiayaan Syariah dan UUS Perusahaan Pembiayaan)"),
	RE_040201 ("040201", "Form 4.2.a - Realisasi Rencana Kegiatan Usaha (Rencana Penyaluran Pembiayaan Syariah kepada Konsumen Inti)"),
	RE_040301 ("040301", "Form 4.3.a - Realisasi Rencana Kegiatan Usaha (Rencana Penyaluran Pembiayaan Syariah kepada Pihak Terkait)"),
	RE_040401 ("040401", "Form 4.4.a - Realisasi Rencana Kegiatan Usaha (Rencana Penyaluran Pembiayaan Syariah Berdasarkan Sektor Ekonomi)"),
	RE_040501 ("040501", "Form 4.5.a - Realisasi Rencana Kegiatan Usaha (Rencana Penyaluran Pembiayaan Syariah Berdasarkan Lokasi Pembiayaan Syariah)"),
	RE_050101 ("050101", "Form 5.1.a - Realisasi Rencana Pengembangan atau Perluasan Kegiatan Usaha (Rencana Penggunaan Akad Lain dan Rencana Perubahan Fitur dari Kegiatan Usaha Pembiayaan Syariah yang Dilakukan dengan Menggunakan Akad yang Sebelumnya Telah Disetujui oleh Otoritas"),
	RE_050201 ("050201", "Form 5.2.a - Realisasi Rencana Pengembangan atau Perluasan Kegiatan Usaha (Rencana Penggunaan Akad yang Belum Pernah Digunakan Sebelumnya, Rencana Perubahan Fitur dari Kegiatan Usaha Pembiayaan Syariah yang dilakukan dengan Menggunakan Akad yang Sebelumny"),
	RE_060101 ("060101", "Form 6.1.a - Realisasi Rencana Permodalan (Rencana Pemenuhan Rasio Permodalan)"),
	RE_060200 ("060200", "Form 6.2 - Realisasi Rencana Permodalan (Proyeksi Permodalan)"),
	RE_070102 ("070102", "Form 7.1.b - Realisasi Rencana Pendanaan (Rencana Pendanaan Berdasarkan Sumber Pendanaan bagi Perusahaan Pembiayaan)"),
	RE_070201 ("070201", "Form 7.2.a - Realisasi Rencana Pendanaan (Rencana Pendanaan Berdasarkan Mata Uang)"),
	RE_070301 ("070301", "Form 7.3.a - Realisasi Rencana Pendanaan (Rencana Pendanaan berdasarkan Akad Pendanaan bagi Perusahaan Pembiayaan Syariah dan UUS Perusahaan Pembiayaan)"),
	RE_080000 ("080000", "Form 8 - Realisasi Rencana Pengembangan dan/atau Perubahan Jaringan Kantor atau Saluran Distribusi"),
	RE_090202 ("090202", "Form 9.2.b - Realisasi Rencana Pengembangan Organisasi, Sumber Daya Manusia, dan/atau Teknologi Informasi (Rencana Pendidikan dan Pelatihan Sumber Daya Manusia)"),
	RE_090203 ("090203", "Form 9.2.c - Realisasi Rencana Pengembangan Organisasi, Sumber Daya Manusia, dan/atau Teknologi Informasi (Rencana Penggunaan Tenaga Kerja Asing)"),
	RE_090204 ("090204", "Form 9.2.d - Realisasi Rencana Pengembangan Organisasi, Sumber Daya Manusia, dan/atau Teknologi Informasi (Rencana Pemanfaatan Tenaga Kerja Alih Daya)"),
	RE_100100 ("100100", "Form 10.1 - Realisasi Proyeksi Laporan Keuangan Beserta Asumsi yang Digunakan (Asumsi Makro dan Mikro yang Digunakan)"),
	RE_100202 ("100202", "Form 10.2.b - Realisasi Proyeksi Laporan Keuangan Beserta Asumsi yang Digunakan (Proyeksi Laporan Posisi Keuangan Perusahaan Pembiayaan Syariah dan UUS Perusahaan Pembiayaan)"),
	RE_100302 ("100302", "Form 10.3.b - Realisasi Proyeksi Laporan Keuangan Beserta Asumsi yang Digunakan (Proyeksi Laba/Rugi Komprehensif Perusahaan Pembiayaan Syariah dan UUS Perusahaan Pembiayaan)"),
	RE_100402 ("100402", "Form 10.4.b - Realisasi Proyeksi Laporan Keuangan Beserta Asumsi yang Digunakan (Proyeksi Laporan Arus Kas Perusahaan Pembiayaan Syariah dan UUS Perusahaan Pembiayaan)"),
	RE_100502 ("100502", "Form 10.5.b - Realisasi Proyeksi Laporan Keuangan Beserta Asumsi yang Digunakan (Proyeksi Rekening Administratif Perusahaan Pembiayaan Syariah dan Unit Usaha Syariah Perusahaan Pembiayaan)"),
	RE_110200 ("110200", "Form 11.2 - Realisasi Proyeksi Rasio dan Pos Tertentu"),
	RE_120100 ("120100", "Form 12.1 - Realisasi Rencana Penyertaan Langsung (Rincian Rencana Penyertaan Langsung)"),
	RE_900001 ("900001", "Surat Pengantar"),
	RE_900002 ("900002", "Realisasi Rencana Bisnis"),
	;

	@Getter
	private String code;
	@Getter
	private String name;
}
