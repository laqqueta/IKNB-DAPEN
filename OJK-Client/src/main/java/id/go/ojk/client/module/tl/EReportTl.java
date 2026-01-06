package id.go.ojk.client.module.tl;

import id.go.ojk.client.constant.EReport;
import id.go.ojk.client.model.ReportInfo;
import id.go.ojk.client.module.lb.EReportTypeCode;

public enum EReportTl {
	DPPKK_PELAPORAN (EReportTypeCode.TLRDPPKK.getReportTypeCode(), EReportGroupTl.PELAPORAN, EReport.TL_DPPKK),
	DPPKK_PELAPORAN_KOREKSI (EReportTypeCode.TLRDPPKK.getReportTypeCode(), EReportGroupTl.PELAPORAN_KOREKSI, EReport.TL_DPPKK),
	DPPKU_PELAPORAN (EReportTypeCode.TLRDPPKU.getReportTypeCode(), EReportGroupTl.PELAPORAN, EReport.TL_DPPKU),
	DPPKU_PELAPORAN_KOREKSI (EReportTypeCode.TLRDPPKU.getReportTypeCode(), EReportGroupTl.PELAPORAN_KOREKSI, EReport.TL_DPPKU),
	DPPKS_PELAPORAN (EReportTypeCode.TLRDPPKS.getReportTypeCode(), EReportGroupTl.PELAPORAN, EReport.TL_DPPKS),
	DPPKS_PELAPORAN_KOREKSI (EReportTypeCode.TLRDPPKS.getReportTypeCode(), EReportGroupTl.PELAPORAN_KOREKSI, EReport.TL_DPPKS),
	DPLKK_PELAPORAN (EReportTypeCode.TLRDPLKK.getReportTypeCode(), EReportGroupTl.PELAPORAN, EReport.TL_DPLKK),
	DPLKK_PELAPORAN_KOREKSI (EReportTypeCode.TLRDPLKK.getReportTypeCode(), EReportGroupTl.PELAPORAN_KOREKSI, EReport.TL_DPLKK),
	DPLKS_PELAPORAN (EReportTypeCode.TLRDPLKS.getReportTypeCode(), EReportGroupTl.PELAPORAN, EReport.TL_DPLKS),
	DPLKS_PELAPORAN_KOREKSI (EReportTypeCode.TLRDPLKS.getReportTypeCode(), EReportGroupTl.PELAPORAN_KOREKSI, EReport.TL_DPLKS),
	;

	private String reportTypeCode;
	private EReportGroupTl reportGroup;
	private EReport report;

	private EReportTl(String reportTypeCode, EReportGroupTl reportGroup, EReport report) {
		this.reportTypeCode = reportTypeCode;
		this.reportGroup = reportGroup;
		this.report = report;
	}

	public String getReportTypeCode() {
		return reportTypeCode;
	}

	public EReportGroupTl getReportGroup() {
		return reportGroup;
	}

	public EReport getReport() {
		return report;
	}

	public static ReportInfo getReportInfo(String reportCode, int reportMenuCode) {
		ReportInfo res = new ReportInfo();
		for (EReportTl eEnum : EReportTl.values()) {
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
