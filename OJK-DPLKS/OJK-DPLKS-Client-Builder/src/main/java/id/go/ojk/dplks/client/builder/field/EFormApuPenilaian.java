package id.go.ojk.dplks.client.builder.field;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormApuPenilaian {
	APU_01 ("01", "BUSINESS FACTOR (BF)"),
	APU_02 ("02", "INTERNAL CONTROL ENVIRONMENT (ICE)"),
	APU_03 ("03", "STRUCTURAL FACTOR (SF)"),
	;

	@Getter
	private String code;
	@Getter
	private String name;
}
