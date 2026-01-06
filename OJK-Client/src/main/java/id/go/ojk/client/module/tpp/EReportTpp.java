package id.go.ojk.client.module.tpp;

import id.go.ojk.client.constant.EReport;
import id.go.ojk.client.model.ReportInfo;
import id.go.ojk.client.module.apu.EReportGroupApu;

public enum EReportTpp {


	FNK_PENILAIAN_RESIKO_RUTIN ("TPPFNKPNA", EReportGroupTpp.PENILAIAN_RESIKO_RUTIN, EReport.TPP_FINK),
	FNK_PENILAIAN_RESIKO_KOREKSI ("TPPFNKPNA", EReportGroupTpp.PENILAIAN_RESIKO_KOREKSI, EReport.TPP_FINK),
	FNK_RENCANA_RUTIN ("TPPFNKRNA", EReportGroupTpp.RENCANA_RUTIN, EReport.TPP_FINK),
	FNK_RENCANA_KOREKSI ("TPPFNKRNA", EReportGroupTpp.RENCANA_KOREKSI, EReport.TPP_FINK),
	FNK_REALISASI_RUTIN ("TPPFNKRLA", EReportGroupTpp.REALISASI_RUTIN, EReport.TPP_FINK),
	FNK_REALISASI_KOREKSI ("TPPFNKRLA", EReportGroupTpp.REALISASI_KOREKSI, EReport.TPP_FINK),

	FNS_PENILAIAN_RESIKO_RUTIN ("TPPFNSPNA", EReportGroupTpp.PENILAIAN_RESIKO_RUTIN, EReport.TPP_FINS),
	FNS_PENILAIAN_RESIKO_KOREKSI ("TPPFNSPNA", EReportGroupTpp.PENILAIAN_RESIKO_KOREKSI, EReport.TPP_FINS),
	FNS_RENCANA_RUTIN ("TPPFNSRNA", EReportGroupTpp.RENCANA_RUTIN, EReport.TPP_FINS),
	FNS_RENCANA_KOREKSI ("TPPFNSRNA", EReportGroupTpp.RENCANA_KOREKSI, EReport.TPP_FINS),
	FNS_REALISASI_RUTIN ("TPPFNSRLA", EReportGroupTpp.REALISASI_RUTIN, EReport.TPP_FINS),
	FNS_REALISASI_KOREKSI ("TPPFNSRLA", EReportGroupTpp.REALISASI_KOREKSI, EReport.TPP_FINS),

	PA_PENILAIAN_RESIKO_RUTIN ("TPPPAPNA", EReportGroupTpp.PENILAIAN_RESIKO_RUTIN, EReport.TPP_PA),
	PA_PENILAIAN_RESIKO_KOREKSI ("TPPPAPNA", EReportGroupTpp.PENILAIAN_RESIKO_KOREKSI, EReport.TPP_PA),
	PA_RENCANA_RUTIN ("TPPPARNA", EReportGroupTpp.RENCANA_RUTIN, EReport.TPP_PA),
	PA_RENCANA_KOREKSI ("TPPPARNA", EReportGroupTpp.RENCANA_KOREKSI, EReport.TPP_PA),
	PA_REALISASI_RUTIN ("TPPPARLA", EReportGroupTpp.REALISASI_RUTIN, EReport.TPP_PA),
	PA_REALISASI_KOREKSI ("TPPPARLA", EReportGroupTpp.REALISASI_KOREKSI, EReport.TPP_PA),

	;

	private String reportTypeCode;
	private EReportGroupTpp reportGroup;
	private EReport report;

	private EReportTpp(String reportTypeCode, EReportGroupTpp reportGroup, EReport report) {
		this.reportTypeCode = reportTypeCode;
		this.reportGroup = reportGroup;
		this.report = report;
	}
	
	public String getReportTypeCode() {
		return reportTypeCode;
	}
	
	public EReportGroupTpp getReportGroup() {
		return reportGroup;
	}
	
	public EReport getReport() {
		return report;
	}
	
	public static ReportInfo getReportInfo(String reportCode, int reportMenuCode) {
		ReportInfo res = new ReportInfo();
		for (EReportTpp eEnum : EReportTpp.values()) {
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
