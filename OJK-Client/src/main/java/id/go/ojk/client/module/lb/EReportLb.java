package id.go.ojk.client.module.lb;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.constant.EReport;
import id.go.ojk.client.model.ReportInfo;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EReportLb {
	ASRJK_PELAPORAN (EReportTypeCode.ASRJK.getReportTypeCode(), EReportGroupLb.PELAPORAN, EReport.LB_ASRJK),
	ASRJK_PERUBAHAN (EReportTypeCode.ASRJK.getReportTypeCode(), EReportGroupLb.PERUBAHAN, EReport.LB_ASRJK),
	ASRJK_PENYESUAIAN (EReportTypeCode.ASRJK.getReportTypeCode(), EReportGroupLb.PENYESUAIAN, EReport.LB_ASRJK),
	ASRJK_PENYESUAIAN_KAP (EReportTypeCode.ASRJK.getReportTypeCode(), EReportGroupLb.PENYESUAIAN_KAP, EReport.LB_ASRJK),
	ASRUK_PELAPORAN (EReportTypeCode.ASRUK.getReportTypeCode(), EReportGroupLb.PELAPORAN, EReport.LB_ASRUK),
	ASRUK_PERUBAHAN (EReportTypeCode.ASRUK.getReportTypeCode(), EReportGroupLb.PERUBAHAN, EReport.LB_ASRUK),
	ASRUK_PENYESUAIAN (EReportTypeCode.ASRUK.getReportTypeCode(), EReportGroupLb.PENYESUAIAN, EReport.LB_ASRUK),
	ASRUK_PENYESUAIAN_KAP (EReportTypeCode.ASRUK.getReportTypeCode(), EReportGroupLb.PENYESUAIAN_KAP, EReport.LB_ASRUK),
	REASK_PELAPORAN (EReportTypeCode.REASK.getReportTypeCode(), EReportGroupLb.PELAPORAN, EReport.LB_REASK),
	REASK_PERUBAHAN (EReportTypeCode.REASK.getReportTypeCode(), EReportGroupLb.PERUBAHAN, EReport.LB_REASK),
	REASK_PENYESUAIAN (EReportTypeCode.REASK.getReportTypeCode(), EReportGroupLb.PENYESUAIAN, EReport.LB_REASK),
	REASK_PENYESUAIAN_KAP (EReportTypeCode.REASK.getReportTypeCode(), EReportGroupLb.PENYESUAIAN_KAP, EReport.LB_REASK),
	ASRJS_PELAPORAN (EReportTypeCode.ASRJS.getReportTypeCode(), EReportGroupLb.PELAPORAN, EReport.LB_ASRJS),
	ASRJS_PERUBAHAN (EReportTypeCode.ASRJS.getReportTypeCode(), EReportGroupLb.PERUBAHAN, EReport.LB_ASRJS),
	ASRJS_PENYESUAIAN (EReportTypeCode.ASRJS.getReportTypeCode(), EReportGroupLb.PENYESUAIAN, EReport.LB_ASRJS),
	ASRJS_PENYESUAIAN_KAP (EReportTypeCode.ASRJS.getReportTypeCode(), EReportGroupLb.PENYESUAIAN_KAP, EReport.LB_ASRJS),
	ASRUS_PELAPORAN (EReportTypeCode.ASRUS.getReportTypeCode(), EReportGroupLb.PELAPORAN, EReport.LB_ASRUS),
	ASRUS_PERUBAHAN (EReportTypeCode.ASRUS.getReportTypeCode(), EReportGroupLb.PERUBAHAN, EReport.LB_ASRUS),
	ASRUS_PENYESUAIAN (EReportTypeCode.ASRUS.getReportTypeCode(), EReportGroupLb.PENYESUAIAN, EReport.LB_ASRUS),
	ASRUS_PENYESUAIAN_KAP (EReportTypeCode.ASRUS.getReportTypeCode(), EReportGroupLb.PENYESUAIAN_KAP, EReport.LB_ASRUS),
	REASS_PELAPORAN (EReportTypeCode.REASS.getReportTypeCode(), EReportGroupLb.PELAPORAN, EReport.LB_REASS),
	REASS_PERUBAHAN (EReportTypeCode.REASS.getReportTypeCode(), EReportGroupLb.PERUBAHAN, EReport.LB_REASS),
	REASS_PENYESUAIAN (EReportTypeCode.REASS.getReportTypeCode(), EReportGroupLb.PENYESUAIAN, EReport.LB_REASS),
	REASS_PENYESUAIAN_KAP (EReportTypeCode.REASS.getReportTypeCode(), EReportGroupLb.PENYESUAIAN_KAP, EReport.LB_REASS),
	PPIK_PELAPORAN (EReportTypeCode.PPIK.getReportTypeCode(), EReportGroupLb.PELAPORAN, EReport.LB_PPIK),
	PPIK_PERUBAHAN (EReportTypeCode.PPIK.getReportTypeCode(), EReportGroupLb.PERUBAHAN, EReport.LB_PPIK),
	PPIK_PENYESUAIAN (EReportTypeCode.PPIK.getReportTypeCode(), EReportGroupLb.PENYESUAIAN, EReport.LB_PPIK),
	PPIU_PELAPORAN (EReportTypeCode.PPIU.getReportTypeCode(), EReportGroupLb.PELAPORAN, EReport.LB_PPIU),
	PPIU_PERUBAHAN (EReportTypeCode.PPIU.getReportTypeCode(), EReportGroupLb.PERUBAHAN, EReport.LB_PPIU),
	PPIU_PENYESUAIAN (EReportTypeCode.PPIU.getReportTypeCode(), EReportGroupLb.PENYESUAIAN, EReport.LB_PPIU),
	PPIS_PELAPORAN (EReportTypeCode.PPIS.getReportTypeCode(), EReportGroupLb.PELAPORAN, EReport.LB_PPIS),
	PPIS_PERUBAHAN (EReportTypeCode.PPIS.getReportTypeCode(), EReportGroupLb.PERUBAHAN, EReport.LB_PPIS),
	PPIS_PENYESUAIAN (EReportTypeCode.PPIS.getReportTypeCode(), EReportGroupLb.PENYESUAIAN, EReport.LB_PPIS),
	PNMK_PELAPORAN (EReportTypeCode.PNMK.getReportTypeCode(), EReportGroupLb.PELAPORAN, EReport.LB_PNMK),
	PNMK_PENYESUAIAN (EReportTypeCode.PNMK.getReportTypeCode(), EReportGroupLb.PENYESUAIAN, EReport.LB_PNMK),
	PNMU_PELAPORAN (EReportTypeCode.PNMU.getReportTypeCode(), EReportGroupLb.PELAPORAN, EReport.LB_PNMU),
	PNMU_PENYESUAIAN (EReportTypeCode.PNMU.getReportTypeCode(), EReportGroupLb.PENYESUAIAN, EReport.LB_PNMU),
	FINK_PELAPORAN (EReportTypeCode.FINK.getReportTypeCode(), EReportGroupLb.PELAPORAN, EReport.LFINK),
	FINK_PENYESUAIAN (EReportTypeCode.FINK.getReportTypeCode(), EReportGroupLb.PENYESUAIAN, EReport.LFINK),
	FINS_PELAPORAN (EReportTypeCode.FINS.getReportTypeCode(), EReportGroupLb.PELAPORAN, EReport.LFINS),
	FINS_PENYESUAIAN (EReportTypeCode.FINS.getReportTypeCode(), EReportGroupLb.PENYESUAIAN, EReport.LFINS),
	LPEIG_PELAPORAN (EReportTypeCode.LBLPIG.getReportTypeCode(), EReportGroupLb.PELAPORAN, EReport.LB_LPEIG),
	LPEIG_PERUBAHAN (EReportTypeCode.LBLPIG.getReportTypeCode(), EReportGroupLb.PERUBAHAN, EReport.LB_LPEIG),
	LPEIG_PENYESUAIAN (EReportTypeCode.LBLPIG.getReportTypeCode(), EReportGroupLb.PENYESUAIAN, EReport.LB_LPEIG),
	LPEIU_PELAPORAN (EReportTypeCode.LBLPIU.getReportTypeCode(), EReportGroupLb.PELAPORAN, EReport.LB_LPEIU),
	LPEIU_PERUBAHAN (EReportTypeCode.LBLPIU.getReportTypeCode(), EReportGroupLb.PERUBAHAN, EReport.LB_LPEIU),
	LPEIU_PENYESUAIAN (EReportTypeCode.LBLPIU.getReportTypeCode(), EReportGroupLb.PENYESUAIAN, EReport.LB_LPEIU),
	PNJK_PELAPORAN (EReportTypeCode.PNJK.getReportTypeCode(), EReportGroupLb.PELAPORAN, EReport.LB_PNJK),
	PNJK_PERUBAHAN (EReportTypeCode.PNJK.getReportTypeCode(), EReportGroupLb.PERUBAHAN, EReport.LB_PNJK),
	PNJK_PENYESUAIAN (EReportTypeCode.PNJK.getReportTypeCode(), EReportGroupLb.PENYESUAIAN, EReport.LB_PNJK),
	PNJU_PELAPORAN (EReportTypeCode.PNJU.getReportTypeCode(), EReportGroupLb.PELAPORAN, EReport.LB_PNJU),
	PNJU_PERUBAHAN (EReportTypeCode.PNJU.getReportTypeCode(), EReportGroupLb.PERUBAHAN, EReport.LB_PNJU),
	PNJU_PENYESUAIAN (EReportTypeCode.PNJU.getReportTypeCode(), EReportGroupLb.PENYESUAIAN, EReport.LB_PNJU),
	PNJS_PELAPORAN (EReportTypeCode.PNJS.getReportTypeCode(), EReportGroupLb.PELAPORAN, EReport.LB_PNJS),
	PNJS_PERUBAHAN (EReportTypeCode.PNJS.getReportTypeCode(), EReportGroupLb.PERUBAHAN, EReport.LB_PNJS),
	PNJS_PENYESUAIAN (EReportTypeCode.PNJS.getReportTypeCode(), EReportGroupLb.PENYESUAIAN, EReport.LB_PNJS),
	;

	@Getter
	private String reportTypeCode;
	@Getter
	private EReportGroupLb reportGroup;
	@Getter
	private EReport report;
	
	public static ReportInfo getReportInfo(String reportCode, int reportMenuCode) {
		ReportInfo res = new ReportInfo();
		for (EReportLb eEnum : EReportLb.values()) {
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

	public static List<EReportLb> getByReport(List<EReport> reports) {
		List<EReportLb> result = new ArrayList<EReportLb>();
		for (EReportLb eReportLb : EReportLb.values()) {
			if (reports.contains(eReportLb.report))
				result.add(eReportLb);
		}
		return result;
	}
}
