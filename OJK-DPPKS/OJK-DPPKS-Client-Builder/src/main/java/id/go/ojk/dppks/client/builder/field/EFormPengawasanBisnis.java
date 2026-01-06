package id.go.ojk.dppks.client.builder.field;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormPengawasanBisnis {
	RP_0100 ("0100", "Pengawasan"),
	RP_9001 ("9001", "Surat Pengantar"),
	;

	@Getter
	private String code;
	@Getter
	private String name;
}
