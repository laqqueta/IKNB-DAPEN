package id.go.ojk.dppkk.client.builder.field;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormRealisasiBisnisUus {
	RE_0100 ("0100", "Form 1. Profil Dana Pensiun"),
	RE_0200 ("0200", "Form 2. Realisasi Posisi Keuangan Untuk Dana Pensiun"),
	RE_0300 ("0300", "Form 3. Realisasi LPAN"),
	RE_0400 ("0400", "Form 4. Asumsi Yang Digunakan"),
	RE_0500 ("0500", "Form 5. Proyeksi Rasio"),
	RE_9001 ("9001", "Surat Pengantar"),
	RE_9002 ("9002", "Realisasi Rencana Bisnis"),
	;

	@Getter
	private String code;
	@Getter
	private String name;
}
