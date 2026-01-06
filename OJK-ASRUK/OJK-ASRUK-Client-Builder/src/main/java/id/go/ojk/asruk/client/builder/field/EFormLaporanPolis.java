package id.go.ojk.asruk.client.builder.field;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormLaporanPolis {
	PLS_0100 ("0100", "LAPORAN POSISI POLIS"),
	PLS_0200 ("0200", "LAPORAN MUTASI POLIS"),
	PLS_9001 ("9001", "SURAT PENGANTAR"),
	;
	
	@Getter
	private String code;
	@Getter
	private String name;
}
