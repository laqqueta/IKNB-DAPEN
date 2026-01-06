package id.go.ojk.client.module.pls;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EReportTypeCode {
	ASRJK ("PLSASRJK"),
	ASRJU ("PLSASRJU"),
	ASRJS ("PLSASRJS"),
	ASRUK ("PLSASRUK"),
	ASRUU ("PLSASRUU"),
	ASRUS ("PLSASRUS"),
	;
	
	@Getter
	private String reportTypeCode;
	
}
