package id.go.ojk.client.module.lbk;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EReportTypeCode {
	LB_FINK ("LBFINK"),
	LT_FINK ("LTFINK"),
	LB_FINS ("LBFINS"),
	LT_FINS ("LTFINS"),
	;
	
	@Getter
	private String reportTypeCode;
}
