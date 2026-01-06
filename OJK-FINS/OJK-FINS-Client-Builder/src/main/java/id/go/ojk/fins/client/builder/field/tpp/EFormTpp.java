package id.go.ojk.fins.client.builder.field.tpp;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormTpp {
	TPP_101 ("82A101", "Laporan Rencana Pengkinian Data"),
	TPP_199 ("82A199", "Lampiran surat Direksi Laporan Rencana Pengkinian Data"),
	TPP_201 ("82A201", "Laporan Realisasi Pengkinian Data"),
	TPP_299 ("82A299", "Lampiran surat Direksi Laporan Realisasi Pengkinian Data"),
	TPP_301 ("82A301", "Nomor Surat Hasil Penilaian Tingkat Risiko PJK"),
	TPP_399 ("82A399", "Laporan Hasil Penilaian Tingkat Risiko PJK"),

	;
	
	@Getter
	private final String code;
	@Getter
	private final String name;
}
