package id.go.ojk.client.module.lb;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EReportTypeCode {
	ASRJK ("LBASRJK"),
	ASRUK ("LBASRUK"),
	REASK ("LBREASK"),
	ASRJS ("LBASRJS"),
	ASRUS ("LBASRUS"),
	REASS ("LBREASS"),
	PPIK ("LBPPIK"),
	PPIU ("LBPPIU"),
	PPIS ("LBPPIS"),
	PNMK ("LBPNMK"),
	PNMU ("LBPNMU"),
	FINK ("LBFINK"),
	FINS ("LBFINS"),
	LBLPIG("LBLPEIG"),
	LBLPIU("LBLPEIU"),
	TLRDPPKK("TLRDPPKK"),
	TLRDPPKU("TLRDPPKU"),
	TLRDPPKS("TLRDPPKS"),
//	TLRDPLKK("TLRDLPKK"), //mengikuti typo di dokumen
	TLRDPLKK("TLRDPLKK"),
	TLRDPLKS("TLRDPLKS"),
	PNJK ("LBPPNJK"),
	PNJU ("LBPPNJU"),
	PNJS ("LBPPNJS"),
	LBLKBPKS ("LBLKBPKS"),
	LBDJSBPKS ("LBDJSBPKS"),
	LBLPPBPKS ("LBLPPBPKS"),
	;
	
	@Getter
	private String reportTypeCode;
	
	public static boolean isPpiOrPnm(String reportTypeCode) {
		return reportTypeCode != null && (reportTypeCode.equals(EReportTypeCode.PPIK.getReportTypeCode()) || 
				reportTypeCode.equals(EReportTypeCode.PPIU.getReportTypeCode()) ||
				reportTypeCode.equals(EReportTypeCode.PPIS.getReportTypeCode()) ||
				reportTypeCode.equals(EReportTypeCode.PNMK.getReportTypeCode()) ||
				reportTypeCode.equals(EReportTypeCode.PNMU.getReportTypeCode()));
	}
}
