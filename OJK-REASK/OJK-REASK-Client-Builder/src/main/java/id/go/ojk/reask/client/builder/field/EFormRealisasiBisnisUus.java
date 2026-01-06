package id.go.ojk.reask.client.builder.field;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormRealisasiBisnisUus {
	RE_0101 ("0101", "Realisasi Keuangan Untuk Laporan Posisi Keuangan a) Untuk Dana Perusahaan"),
	RE_0102 ("0102", "Realisasi Keuangan Untuk Laporan Posisi Keuangan b) Untuk Dana Tabarru"),
	RE_0201 ("0201", "Realisasi Keuangan untuk Laba/Rugi Komprehensif a) Untuk Dana Perusahaan"),
	RE_0202 ("0202", "Realisasi Keuangan untuk Laba/Rugi Komprehensif b) Untuk Dana Tabarru"),
	RE_0301 ("0301", "LAPORAN ARUS KAS a) Untuk Dana Perusahaan"),
	RE_0302 ("0302", "LAPORAN ARUS KAS b) Untuk Dana Tabarru"),
	RE_0401 ("0401", "Realisasi Rasio-Rasio dan Pos-Pos Tertentu Lainnya a) Untuk Dana Perusahaan"),
	RE_0402 ("0402", "Realisasi Rasio-Rasio dan Pos-Pos Tertentu Lainnya b) Untuk Dana Tabarru"),
	RE_9001 ("9001", "Surat Pengantar"),
	RE_9002 ("9002", "Realisasi Rencana Bisnis"),
	;

	@Getter
	private String code;
	@Getter
	private String name;
}
