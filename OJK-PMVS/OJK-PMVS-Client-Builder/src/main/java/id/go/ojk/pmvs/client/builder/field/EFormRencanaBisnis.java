package id.go.ojk.pmvs.client.builder.field;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormRencanaBisnis {
	RB_010402 ("010402", "Form 4.1.b - Rencana Usaha Modal Ventura  Syariah Berdasarkan Jenis Kegiatan Usaha bagi PMVS dan UUS dari PMV"),
	RB_040102 ("040102", "Form 4.1.b - Rencana Usaha Modal Ventura  Syariah Berdasarkan Jenis Kegiatan Usaha bagi PMVS dan UUS dari PMV"),
	RB_040201 ("040201", "Form 4.2.a -  Rencana Usaha Modal Ventura dan/atau Usaha Modal Ventura Syariah Berdasarkan Sektor Ekonomi"),
	RB_040301 ("040301", "Form 4.3.a -  Rencana Usaha Modal Ventura dan/atau Usaha Modal Ventura Syariah Berdasarkan Lokasi"),
	RB_050101 ("050101", "Form 5.1.a - Rencana Pengembangan atau Perluasan Kegiatan Usaha (Rencana Pelaksanaan Kegiatan Usaha Lain dan Rencana Pengelolaan Dana Ventura yang Wajib Terlebih Dahulu Memperoleh Persetujuan Otoritas Jasa Keuangan)"),
	RB_050201 ("050201", "Form 5.2.a -  Pelaksanaan Kegiatan Berbasis Fee dan Rencana Penggunaan Akad yang Belum Pernah Digunakan Sebelumnya yang Wajib Terlebih Dahulu Dilaporkan kepada Otoritas Jasa Keuangan"),
	RB_060100 ("060100", "Form 6.1 - Rencana Permodalan (Proyeksi Permodalan)"),
	RB_070102 ("070102", "Form 7.1.b - Rencana Pendanaan Berdasarkan Sumber Pendanaan bagi PMVS dan UUS dari PMV   "),
	RB_070201 ("070201", "Form 7.2.a - Rencana Pendanaan (Rencana Pendanaan Berdasarkan Mata Uang)"),
	RB_080000 ("080000", "Form 8 - Rencana Pengembangan dan/atau Perubahan Jaringan Kantor atau Saluran Distribusi"),
	RB_090202 ("090202", "Form 9.2.b - Rencana Pengembangan Organisasi, Sumber Daya Manusia, dan/atau Teknologi Informasi (Rencana Pendidikan dan Pelatihan Sumber Daya Manusia)"),
	RB_090203 ("090203", "Form 9.2.c - Rencana Pengembangan Organisasi, Sumber Daya Manusia, dan/atau Teknologi Informasi (Rencana Penggunaan Tenaga Kerja Asing)"),
	RB_090204 ("090204", "Form 9.2.d - Rencana Pengembangan Organisasi, Sumber Daya Manusia, dan/atau Teknologi Informasi (Rencana Pemanfaatan Tenaga Kerja Alih Daya)"),
	RB_100100 ("100100", "Form 10.1 - Proyeksi Laporan Keuangan Beserta Asumsi yang Digunakan (Asumsi Makro dan Mikro yang Digunakan)"),
	RB_100202 ("100202", "Form 10.2.b - Proyeksi Laporan Posisi Keuangan PMVS dan UUS dari PMV "),
	RB_100302 ("100302", "Form 10.3.b - Proyeksi Laporan Keuangan Beserta Asumsi yang Digunakan (Proyeksi Laba/Rugi Komprehensif PMV dan UUS dari PMV)"),
	RB_100402 ("100402", "Form 10.4.b - Proyeksi Laporan Keuangan Beserta Asumsi yang Digunakan (Proyeksi Laporan Arus Kas PMVS dan UUS dari PMV    )"),
	RB_100502 ("100502", "Form 10.5.b - Proyeksi Laporan Keuangan Beserta Asumsi yang Digunakan (Proyeksi Rekening Administratif PMVS dan UUS dari PMV)"),
	RB_110100 ("110100", "Form 11.1 - Proyeksi Rasio dan Pos Tertentu"),
	RB_900001 ("900001", "Surat Pengantar"),
	RB_900002 ("900002", "Rencana Bisnis"),
	RB_900003 ("900003", "Rencana Aksi Keuangan Berkelanjutan (RAKB)"),
	;

	@Getter
	private String code;
	@Getter
	private String name;
}
