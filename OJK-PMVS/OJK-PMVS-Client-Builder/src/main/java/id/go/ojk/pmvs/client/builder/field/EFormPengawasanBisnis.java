package id.go.ojk.pmvs.client.builder.field;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormPengawasanBisnis {
	RP_010000 ("010000", "Pengawasan"),
	RP_900001 ("900001", "Surat Pengantar"),
	;

	@Getter
	private String code;
	@Getter
	private String name;
}
