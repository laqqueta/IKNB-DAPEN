package id.go.ojk.pmvk.client.builder.field;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormRealisasiBisnis {
	RE_010401 ("010401", "Form 1.4.a - Rincian Eksekutif (Indikator Keuangan Utama)"),
	RE_040101 ("040101", "Form 4.1.a - Rencana Kegiatan Usaha (Rencana Penyaluran Pembiayaan Berdasarkan Jenis Pembiayaan bagi Perusahaan Pembiayaan)"),
	RE_040201 ("040201", "Form 4.2.a - Rencana Kegiatan Usaha (Rencana Penyaluran Pembiayaan kepada Debitur Inti)"),
	RE_040301 ("040301", "Form 4.3.a - Rencana Kegiatan Usaha (Rencana Penyaluran Pembiayaan kepada Pihak Terkait)"),
	RE_050101 ("050101", "Form 5.1.a - Rencana Pengembangan atau Perluasan Kegiatan Usaha (Rencana Pelaksanaan Kegiatan Usaha Pembiayaan Lain dan Rencana Pelaksanaan Cara Pembiayaan Lain yang Wajib Terlebih Dahulu Memperoleh Persetujuan Otoritas Jasa Keuangan)"),
	RE_050201 ("050201", "Form 5.2.a - Rencana Pengembangan atau Perluasan Kegiatan Usaha (Rencana Pelaksanaan Kegiatan Berbasis Imbal Jasa yang Wajib Dilaporkan kepada Otoritas Jasa Keuangan)"),
	RE_060100 ("060100", "Form 6.1 - Rencana Permodalan (Rencana Pemenuhan Rasio Permodalan)"),
	RE_070101 ("070101", "Form 7.1.a - Rencana Pendanaan (Rencana Pendanaan Berdasarkan Sumber Pendanaan bagi Perusahaan Pembiayaan)"),
	RE_070201 ("070201", "Form 7.2.a - Rencana Pendanaan (Rencana Pendanaan Berdasarkan Mata Uang)"),
	RE_080000 ("080000", "Form 8 - Rencana Pengembangan dan/atau Perubahan Jaringan Kantor atau Saluran Distribusi"),
	RE_090202 ("090202", "Form 9.2.b - Rencana Pengembangan Organisasi, Sumber Daya Manusia, dan/atau Teknologi Informasi (Rencana Pendidikan dan Pelatihan Sumber Daya Manusia)"),
	RE_090203 ("090203", "Form 9.2.c - Rencana Pengembangan Organisasi, Sumber Daya Manusia, dan/atau Teknologi Informasi (Rencana Penggunaan Tenaga Kerja Asing)"),
	RE_090204 ("090204", "Form 9.2.d - Rencana Pengembangan Organisasi, Sumber Daya Manusia, dan/atau Teknologi Informasi (Rencana Pemanfaatan Tenaga Kerja Alih Daya)"),
	RE_100100 ("100100", "Form 10.1 - Proyeksi Laporan Keuangan Beserta Asumsi yang Digunakan (Asumsi Makro dan Mikro yang Digunakan)"),
	RE_100201 ("100201", "Form 10.2.a - Proyeksi Laporan Keuangan Beserta Asumsi yang Digunakan (Proyeksi Laporan Posisi Keuangan Perusahaan Pembiayaan)"),
	RE_100301 ("100301", "Form 10.3.a - Proyeksi Laporan Keuangan Beserta Asumsi yang Digunakan (Proyeksi Laba/Rugi Komprehensif Perusahaan Pembiayaan)"),
	RE_100401 ("100401", "Form 10.4.a - Proyeksi Laporan Keuangan Beserta Asumsi yang Digunakan (Proyeksi Laporan Arus Kas Perusahaan Pembiayaan)"),
	RE_100501 ("100501", "Form 10.5.a - Proyeksi Laporan Keuangan Beserta Asumsi yang Digunakan (Proyeksi Rekening Administratif Perusahaan Pembiayaan)"),
	RE_110100 ("110100", "Form 11.1 - Proyeksi Rasio dan Pos Tertentu"),
	RE_900001 ("900001", "Surat Pengantar"),
	RE_900002 ("900002", "Realisasi Rencana Bisnis"),
	;
	
	@Getter
	private String code;
	@Getter
	private String name;
}
