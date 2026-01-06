package id.go.ojk.pmvs.client.builder.field;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormRealisasiBisnis {
	RE_010402 ("010402", "Form 1.4.b - Rincian Eksekutif (Indikator Keuangan Utama)"),
	RE_040102 ("040102", "Form 4.1.b - Realisasi Rencana Usaha Modal Ventura Berdasarkan Jenis Kegiatan Usaha bagi PMVS dan UUS dari PMV"),
	RE_040201 ("040201", "Form 4.2.a - Realisasi Rencana Usaha Modal Ventura Syariah Berdasarkan Sektor Ekonomi"),
	RE_040301 ("040301", "Form 4.3.a - Realisasi Rencana Usaha Modal Ventura Syariah Berdasarkan Lokasi"),
	RE_050101 ("050101", "Form 5.1.a - Realisasi Rencana Pengembangan atau Perluasan Kegiatan Usaha (Realisasi Rencana Pelaksanaan Kegiatan Usaha Lain dan Rencana Pengelolaan Dana Ventura yang Wajib Terlebih Dahulu Memperoleh Persetujuan Otoritas Jasa Keuangan)"),
	RE_050201 ("050201", "Form 5.2.a -  Realisasi Pelaksanaan Kegiatan Berbasis Fee dan Rencana Penggunaan Akad yang Belum Pernah Digunakan Sebelumnya yang Wajib Terlebih Dahulu Dilaporkan kepada Otoritas Jasa Keuangan"),
	RE_060100 ("060100", "Form 6.1 - Realisasi Rencana Permodalan (Proyeksi Permodalan)"),
	RE_070102 ("070102", "Form 7.1.b - Realisasi Rencana Pendanaan berdasarkan Sumber Pendanaan bagi PMVS dan UUS dari PMV   "),
	RE_070201 ("070201", "Form 7.2.a - Realisasi Rencana Pendanaan (Rencana Pendanaan Berdasarkan Mata Uang)"),
	RE_080000 ("080000", "Form 8 - Realisasi Rencana Pengembangan dan/atau Perubahan Jaringan Kantor atau Saluran Distribusi"),
	RE_090202 ("090202", "Form 9.2.b - Realisasi Rencana Pengembangan Organisasi, Sumber Daya Manusia, dan/atau Teknologi Informasi (Rencana Pendidikan dan Pelatihan Sumber Daya Manusia)"),
	RE_090203 ("090203", "Form 9.2.c - Realisasi Rencana Pengembangan Organisasi, Sumber Daya Manusia, dan/atau Teknologi Informasi (Rencana Penggunaan Tenaga Kerja Asing)"),
	RE_090204 ("090204", "Form 9.2.d - Realisasi Rencana Pengembangan Organisasi, Sumber Daya Manusia, dan/atau Teknologi Informasi (Rencana Pemanfaatan Tenaga Kerja Alih Daya)"),
	RE_100100 ("100100", "Form 10.1 - Realisasi Proyeksi Laporan Keuangan Beserta Asumsi yang Digunakan (Asumsi Makro dan Mikro yang Digunakan)"),
	RE_100202 ("100202", "Form 10.2.b - Realisasi Proyeksi Laporan Posisi Keuangan PMVS dan UUS dari PMV "),
	RE_100302 ("100302", "Form 10.3.b - Realisasi Proyeksi Laporan Keuangan Beserta Asumsi yang Digunakan (Proyeksi Laba/Rugi Komprehensif PMV dan UUS dari PMV)"),
	RE_100402 ("100402", "Form 10.4.b - Realisasi Proyeksi Laporan Keuangan Beserta Asumsi yang Digunakan (Proyeksi Laporan Arus Kas PMVS dan UUS dari PMV)"),
	RE_100502 ("100502", "Form 10.5.b - Realisasi Proyeksi Laporan Keuangan Beserta Asumsi yang Digunakan (Proyeksi Rekening Administratif PMVS dan UUS dari PMV)"),
	RE_110100 ("110100", "Form 11.1 - Realisasi Proyeksi Rasio dan Pos Tertentu"),
	RE_899999 ("899999", "Form 899999 - Surat Pengantar Realisasi Rencana Bisnis"),
	RE_999999 ("999999", "Form 999999 - Laporan Realisasi Rencana Bisnis"),
	RE_900001 ("900001", "Surat Pengantar"),
	RE_900002 ("900002", "Realisasi Rencana Bisnis"),
	;

	@Getter
	private String code;
	@Getter
	private String name;
}
