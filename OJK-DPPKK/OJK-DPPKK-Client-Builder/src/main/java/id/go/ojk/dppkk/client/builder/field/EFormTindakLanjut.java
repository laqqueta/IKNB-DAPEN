package id.go.ojk.dppkk.client.builder.field;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormTindakLanjut {
	TL_0100 ("0100", "Form Tindak Lanjut Hasil Rekomendasi Pemeriksaan Langsung"),
	TL_8888 ("8888", "Surat Pengantar Laporan Tindak Lanjut Hasil Rekomendasi Pemeriksaan Langsung"),
	TL_9999 ("9999", "Laporan Utama Tindak Lanjut Hasil Rekomendasi Pemeriksaan Langsung"),
	TL_1111 ("1111", "Berkas Dokumen Pendukung Lainnya"),
	;

	@Getter
	private String code;
	@Getter
	private String name;
}
