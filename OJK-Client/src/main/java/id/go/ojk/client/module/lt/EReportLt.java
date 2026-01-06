package id.go.ojk.client.module.lt;

import id.go.ojk.client.constant.EReport;
import id.go.ojk.client.model.ReportInfo;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EReportLt {
	FINK_PELAPORAN (EReportTypeCode.FINK.getReportTypeCode(), EReportGroupLt.PELAPORAN, EReport.LFINK),
	FINK_PENYESUAIAN (EReportTypeCode.FINK.getReportTypeCode(), EReportGroupLt.PENYESUAIAN, EReport.LFINK),
	FINS_PELAPORAN (EReportTypeCode.FINS.getReportTypeCode(), EReportGroupLt.PELAPORAN, EReport.LFINS),
	FINS_PENYESUAIAN (EReportTypeCode.FINS.getReportTypeCode(), EReportGroupLt.PENYESUAIAN, EReport.LFINS),
	;

	@Getter
	private String reportTypeCode;
	@Getter
	private EReportGroupLt reportGroup;
	@Getter
	private EReport report;
	
	public static ReportInfo getReportInfo(String reportCode, int reportMenuCode) {
		ReportInfo res = new ReportInfo();
		for (EReportLt eEnum : EReportLt.values()) {
			EReport eReport = eEnum.getReport();
			if (eReport.getCode().equals(reportCode) && eEnum.reportGroup.getMenuCode() == reportMenuCode) {
				res.setId(eEnum.name());
				res.setReport(eReport);
				res.setReportGroup(eEnum.reportGroup.getObject());
				res.setReportTypeCode(eEnum.getReportTypeCode());
				break;
			}
		}
		return res;
	}
}
