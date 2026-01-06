package id.go.ojk.asrjs.client.builder.field;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormRencanaBisnis {
	RB_0101 ("0101", "Format 1: Ringkasan Eksekutif Indikator Keuangan Utama Dana Perusahaan "),
	RB_0102 ("0102", "Format 1: Ringkasan Eksekutif Indikator Keuangan Utama Dana Tabarru' "),
	RB_0103 ("0103", "Format 1: Ringkasan Eksekutif Indikator Keuangan Utama Dana Investasi Peserta "),
	RB_0104 ("0104", "Format 1: Ringkasan Eksekutif Rasio Keuangan Dana Perusahaan "),
	RB_0105 ("0105", "Format 1: Ringkasan Eksekutif Rasio Keuangan Dana Tabarru "),
	RB_0106 ("0106", "Format 1: Ringkasan Eksekutif Rasio Keuangan Dana Investasi Peserta "),
	RB_0201 ("0201", "Format 2: Evaluasi atas Pelaksanaan Rencana Bisnis Periode Sebelumnya Dana Perusahaan "),
	RB_0202 ("0202", "Format 2: Evaluasi atas Pelaksanaan Rencana Bisnis Periode Sebelumnya Dana Tabarru "),
	RB_0203 ("0203", "Format 2: Evaluasi atas Pelaksanaan Rencana Bisnis Periode Sebelumnya Dana Investasi Peserta "),
	RB_0401 ("0401", "Format 4: Rencana Kegiatan Usaha   "),
	RB_0501 ("0501", "Format 5: Rencana Pengembangan Atau Perluasan Kegiatan Usaha  "),
	RB_0601 ("0601", "Format 6: Rencana Investasi a.    Komposisi Investasi 1)    Untuk Dana Perusahaan"),
	RB_0602 ("0602", "Format 6: Rencana Investasi a.    Komposisi Investasi 1)    Untuk Tabarru"),
	RB_0603 ("0603", "Format 6: Rencana Investasi a.    Komposisi Investasi 1)    Untuk Dana Investasi Peserta"),
	RB_0604 ("0604", "Format 6: Rencana Investasi a.    Komposisi Investasi 1)    Untuk Dana Perusahaan"),
	RB_0605 ("0605", "Format 6: Rencana Investasi a.    Komposisi Investasi 1)    Untuk Dana Tabarru"),
	RB_0606 ("0606", "Format 6: Rencana Investasi a.    Komposisi Investasi 1)    Untuk Dana Investasi Peserta"),
	RB_0701 ("0701", "Format 7: Rencana Permodalan a.   Proyeksi Permodalan "),
	RB_0901 ("0901", "Form 9. Rencana Pengembangan dan/atau Perubahan Jaringan Kantor  "),
	RB_1001 ("1001", "Format 10: Rencana Pengembangan Organisasi, Sumber Daya Manusia, dan/atau Teknologi Informasi  "),
	RB_1002 ("1002", "Form 10.c Rencana Pelaksanaan Pendidikan dan Pelatihan SDM untuk Direksi, Dewan Komisaris, dan Pegawai  "),
	RB_1003 ("1003", "Form 10 Rencana Penggunaan Tenaga Kerja Asing  "),
	RB_1004 ("1004", "Form 10 Rencana Pemanfaatan Tenaga Kerja Alih Daya  "),
	RB_1005 ("1005", "Form 10 Rencana Pengembangan Teknologi Informasi  "),
	RB_1201 ("1201", "Format 12: Proyeksi Laporan Keuangan dan Asumsi Yang Digunakan a.  Proyeksi Posisi Keuangan 1)   Untuk Dana Perusahaan"),
	RB_1202 ("1202", "Format 12: Proyeksi Laporan Keuangan dan Asumsi Yang Digunakan a.  Proyeksi Posisi Keuangan 2)   Untuk Dana Tabarru"),
	RB_1203 ("1203", "Format 12: Proyeksi Laporan Keuangan dan Asumsi Yang Digunakan a.  Proyeksi Posisi Keuangan 3)   Untuk Dana Investasi Peserta"),
	RB_1204 ("1204", "Format 12: Proyeksi Laporan Keuangan dan Asumsi Yang Digunakan a.  Proyeksi Laba/Rugi Komprehensif  1)   Untuk Dana Perusahaan"),
	RB_1205 ("1205", "Format 12: Proyeksi Laporan Keuangan dan Asumsi Yang Digunakan a.  Proyeksi Laba/Rugi Komprehensif  2)   Untuk Dana Tabarru"),
	RB_1206 ("1206", "Format 12: Proyeksi Laporan Keuangan dan Asumsi Yang Digunakan a.  Proyeksi Laba/Rugi Komprehensif  3)   Untuk Dana Investasi Peserta"),
	RB_1207 ("1207", "Format 12: Proyeksi Laporan Keuangan dan Asumsi Yang Digunakan c.  Proyeksi Arus Kas 1)   Untuk Dana Perusahaan"),
	RB_1208 ("1208", "Format 12: Proyeksi Laporan Keuangan dan Asumsi Yang Digunakan c.  Proyeksi Arus Kas 2)   Untuk Dana Tabarru"),
	RB_1209 ("1209", "Format 12: Proyeksi Laporan Keuangan dan Asumsi Yang Digunakan c.  Proyeksi Arus Kas 3)   Untuk Dana Investasi Peserta"),
	RB_1210 ("1210", "Format 12: Proyeksi Laporan Keuangan dan Asumsi Yang Digunakan d.  Asumsi Yang Digunakan 3)   Untuk Dana Investasi Peserta"),
	RB_1301 ("1301", "Format 13: Proyeksi Rasio-Rasio dan Pos tertentu lainnya 1)   Untuk Dana Perusahaan "),
	RB_1302 ("1302", "Format 13: Proyeksi Rasio-Rasio dan Pos tertentu lainnya 2)   Untuk Dana Tabarru "),
	RB_1303 ("1303", "Format 13: Proyeksi Rasio-Rasio dan Pos tertentu lainnya 3)   Untuk Dana Investasi Peserta "),
	RB_9001 ("9001", "Surat Pengantar"),
	RB_9002 ("9002", "Rencana Bisnis"),
	RB_9003 ("9003", "Rencana Aksi Keuangan Berkelanjutan (RAKB)"),
	;
	
	@Getter
	private String code;
	@Getter
	private String name;
}
