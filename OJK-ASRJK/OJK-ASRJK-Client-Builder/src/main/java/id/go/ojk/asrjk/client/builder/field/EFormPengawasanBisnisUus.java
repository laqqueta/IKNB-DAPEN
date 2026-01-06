package id.go.ojk.asrjk.client.builder.field;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormPengawasanBisnisUus {
	RP_0100 ("0100", "Pengawasan"), 
	RP_9001 ("9001", "Surat Pengantar"),
	;
	
	@Getter
	private String code;
	@Getter
	private String name;
}
