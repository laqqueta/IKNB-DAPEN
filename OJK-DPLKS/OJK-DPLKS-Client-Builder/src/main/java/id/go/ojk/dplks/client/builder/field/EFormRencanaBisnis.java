package id.go.ojk.dplks.client.builder.field;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormRencanaBisnis {
	RB_0100 ("0100",   "Form 1. Informasi Umum Dana Pensiun"),
	RB_0204 ("0204",   "Form 2.d. Indikator Keuangan"),
	RB_0205 ("0205",   "Form 2.e. Rasio Keuangan "),
	RB_0301 ("0301",   "Form 3.a. Evaluasi atas Pelaksanaan Rencana Bisnis Periode Sebelumnya"),
	RB_0403 ("0403",   "Form 4.c. Strategi Bisnis Dana Pensiun"),
	RB_0600 ("0600",   "Form 6. Rencana Pengembangan Atau Perluasan Kegiatan Usaha"),
	RB_0701 ("0701",   "Form 7.a Rencana Investasi Komposisi Investasi Berdasarkan Nilai Perolehan"),
	RB_0702 ("0702",   "Form 7.a.2 Rencana Investasi Komposisi Investasi Berdasarkan Nilai Wajar"),
	RB_0703 ("0703",   "Form 7.b. Hasil Investasi"),
	RB_0801 ("0801",   "Form 8.a. Proyeksi Pendanaan"),
	RB_0802 ("0802",   "Form 8.b. Proyeksi Jumlah Peserta"),
	RB_0900 ("0900",   "Form 9. Rencana Pengembangan dan/atau perubahan jaringan kantor atau saluran distribusi "),
	RB_1001 ("1001",   "Form 10.a Rencana Pemanfaatan Tenaga Kerja Alih Daya"),
	RB_1002 ("1002",   "Form 10.b Rencana Pemenuhan Sumber Daya Manusia"),
	RB_1003 ("1003",   "Form 10.c.1. Rencana Pelaksanaan Pendidikan dan Pelatihan SDM untuk Pengurus, Dewan Pengawas, dan pegawai"),
	RB_1004 ("1004",   "Form 10.d Rencana Pengembangan Sistem Teknologi Informasi"),
	RB_1201 ("1201",   "Form 12.a. Proyeksi Laporan Keuangan, Proyeksi Rasio-Rasio dan Pos tertentu lainnya, serta Asumsi Yang Digunakan Proyeksi Laporan Aset Netto"),
	RB_1202 ("1202",   "Form 12.b. Proyeksi Laporan Perubahan Aset Netto"),
	RB_1203 ("1203",   "Form 12.c. Asumsi Yang Digunakan"),
	RB_9001 ("9001",   "Surat Pengantar"),
	RB_9002 ("9002",   "Rencana Bisnis"),
	;
	
	@Getter
	private String code;
	@Getter
	private String name;
}
