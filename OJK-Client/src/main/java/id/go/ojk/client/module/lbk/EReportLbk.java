package id.go.ojk.client.module.lbk;

import id.go.ojk.client.constant.EReport;
import id.go.ojk.client.model.ReportInfo;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EReportLbk {
	FINK_PELAPORAN_BULANAN (EReportTypeCode.LB_FINK.getReportTypeCode(), EReportGroupLbk.PELAPORAN_BULANAN, EReport.LFINK),
	FINK_PENYESUAIAN_BULANAN (EReportTypeCode.LB_FINK.getReportTypeCode(), EReportGroupLbk.PENYESUAIAN_BULANAN, EReport.LFINK),
	FINK_PELAPORAN_TAHUNAN(EReportTypeCode.LT_FINK.getReportTypeCode(), EReportGroupLbk.PELAPORAN_TAHUNAN, EReport.LFINK),
	FINK_PENYESUAIAN_TAHUNAN (EReportTypeCode.LT_FINK.getReportTypeCode(), EReportGroupLbk.PENYESUAIAN_TAHUNAN, EReport.LFINK),
	FINS_PELAPORAN_BULANAN (EReportTypeCode.LB_FINS.getReportTypeCode(), EReportGroupLbk.PELAPORAN_BULANAN, EReport.LFINS),
	FINS_PENYESUAIAN_BULANAN (EReportTypeCode.LB_FINS.getReportTypeCode(), EReportGroupLbk.PENYESUAIAN_BULANAN, EReport.LFINS),
	FINS_PELAPORAN_TAHUNAN (EReportTypeCode.LT_FINS.getReportTypeCode(), EReportGroupLbk.PELAPORAN_TAHUNAN, EReport.LFINS),
	FINS_PENYESUAIAN_TAHUNAN (EReportTypeCode.LT_FINS.getReportTypeCode(), EReportGroupLbk.PENYESUAIAN_TAHUNAN, EReport.LFINS),
	;

	@Getter
	private String reportTypeCode;
	@Getter
	private EReportGroupLbk reportGroup;
	@Getter
	private EReport report;
	
	public static ReportInfo getReportInfo(String reportCode, int reportMenuCode) {
		ReportInfo res = new ReportInfo();
		for (EReportLbk eEnum : EReportLbk.values()) {
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
