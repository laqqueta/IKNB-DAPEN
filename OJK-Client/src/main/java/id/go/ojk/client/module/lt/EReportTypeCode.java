package id.go.ojk.client.module.lt;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EReportTypeCode {
	FINK ("LTFINK"),
	FINS ("LTFINS"),
	;
	
	@Getter
	private String reportTypeCode;
}
