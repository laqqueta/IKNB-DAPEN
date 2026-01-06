package id.go.ojk.client.module.pls;

import id.go.ojk.client.constant.EReport;
import id.go.ojk.client.model.ReportInfo;
//import id.go.ojk.client.module.pls.EReportTypeCode;
//import id.go.ojk.client.module.pls.EReportGroupPls;
import id.go.ojk.client.module.pls.EReportPls;

public enum EReportPls {
	ASRJK_PELAPORAN (EReportTypeCode.ASRJK.getReportTypeCode(), EReportGroupPls.PELAPORAN, EReport.PLS_ASRJK),
	ASRJK_PELAPORAN_KOREKSI (EReportTypeCode.ASRJK.getReportTypeCode(), EReportGroupPls.PELAPORAN_KOREKSI, EReport.PLS_ASRJK),
	ASRJU_PELAPORAN (EReportTypeCode.ASRJU.getReportTypeCode(), EReportGroupPls.PELAPORAN, EReport.PLS_ASRJU),
	ASRJU_PELAPORAN_KOREKSI (EReportTypeCode.ASRJU.getReportTypeCode(), EReportGroupPls.PELAPORAN_KOREKSI, EReport.PLS_ASRJU),
	ASRJS_PELAPORAN (EReportTypeCode.ASRJS.getReportTypeCode(), EReportGroupPls.PELAPORAN, EReport.PLS_ASRJS),
	ASRJS_PELAPORAN_KOREKSI (EReportTypeCode.ASRJS.getReportTypeCode(), EReportGroupPls.PELAPORAN_KOREKSI, EReport.PLS_ASRJS),
	ASRUK_PELAPORAN (EReportTypeCode.ASRUK.getReportTypeCode(), EReportGroupPls.PELAPORAN, EReport.PLS_ASRUK),
	ASRUK_PELAPORAN_KOREKSI (EReportTypeCode.ASRUK.getReportTypeCode(), EReportGroupPls.PELAPORAN_KOREKSI, EReport.PLS_ASRUK),
	ASRUU_PELAPORAN (EReportTypeCode.ASRUU.getReportTypeCode(), EReportGroupPls.PELAPORAN, EReport.PLS_ASRUU),
	ASRUU_PELAPORAN_KOREKSI (EReportTypeCode.ASRUU.getReportTypeCode(), EReportGroupPls.PELAPORAN_KOREKSI, EReport.PLS_ASRUU),
	ASRUS_PELAPORAN (EReportTypeCode.ASRUS.getReportTypeCode(), EReportGroupPls.PELAPORAN, EReport.PLS_ASRUS),
	ASRUS_PELAPORAN_KOREKSI (EReportTypeCode.ASRUS.getReportTypeCode(), EReportGroupPls.PELAPORAN_KOREKSI, EReport.PLS_ASRUS),
	;

	private String reportTypeCode;
	private EReportGroupPls reportGroup;
	private EReport report;

	private EReportPls(String reportTypeCode, EReportGroupPls reportGroup, EReport report) {
		this.reportTypeCode = reportTypeCode;
		this.reportGroup = reportGroup;
		this.report = report;
	}

	public String getReportTypeCode() {
		return reportTypeCode;
	}

	public EReportGroupPls getReportGroup() {
		return reportGroup;
	}

	public EReport getReport() {
		return report;
	}

	public static ReportInfo getReportInfo(String reportCode, int reportMenuCode) {
		ReportInfo res = new ReportInfo();
		for (EReportPls eEnum : EReportPls.values()) {
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