package id.go.ojk.asrjk.client.builder.field;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormRealisasiBisnis {
	RE_0100 ("0100", "Realisasi Posisi Keuangan Untuk Perusahaan Asuransi Jiwa"),
	RE_0200 ("0200", "Realisasi Laba/Rugi Komprehensif Untuk Perusahaan Asuransi Jiwa"),
	RE_0300 ("0300", "Realisasi Arus Kas Untuk Perusahaan Asuransi Jiwa"),
	RE_0400 ("0400", "Realisasi Rasio-Rasio dan Pos-Pos Tertentu Lainnya Untuk Perusahaan Asuransi Jiwa"),
	RE_9001 ("9001", "Surat Pengantar"),
	RE_9002 ("9002", "Realisasi Rencana Bisnis"),
	;
	
	@Getter
	private String code;
	@Getter
	private String name;
}
