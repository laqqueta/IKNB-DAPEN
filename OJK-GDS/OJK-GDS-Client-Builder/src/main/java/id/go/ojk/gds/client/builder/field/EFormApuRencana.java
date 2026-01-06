package id.go.ojk.gds.client.builder.field;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormApuRencana {
	APU_00 ("00", "NOMOR SURAT"),
	APU_88 ("88", "SURAT PENGANTAR"),
	APU_99 ("99", "LAMPIRAN LAPORAN RENCANA KEGIATAN PENGKINIAN DATA"),
	;

	@Getter
	private String code;
	@Getter
	private String name;
}
