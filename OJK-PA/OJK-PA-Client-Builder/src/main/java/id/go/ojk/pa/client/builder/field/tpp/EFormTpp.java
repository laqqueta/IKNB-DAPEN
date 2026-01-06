package id.go.ojk.pa.client.builder.field.tpp;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormTpp {
	TPP_101 ("81A101", "Laporan Rencana Pengkinian Data"),
	TPP_199 ("81A199", "Lampiran surat Direksi Laporan Rencana Pengkinian Data"),
	TPP_201 ("81A201", "Laporan Realisasi Pengkinian Data"),
	TPP_299 ("81A299", "Lampiran surat Direksi Laporan Realisasi Pengkinian Data"),
	TPP_301 ("81A301", "Nomor Surat Hasil Penilaian Tingkat Risiko PJK"),
	TPP_399 ("81A399", "Laporan Hasil Penilaian Tingkat Risiko PJK"),

	;
	
	@Getter
	private String code;
	@Getter
	private String name;
}
