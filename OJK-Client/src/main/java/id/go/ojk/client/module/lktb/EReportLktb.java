package id.go.ojk.client.module.lktb;

import id.go.ojk.client.constant.EReport;
import id.go.ojk.client.model.ReportInfo;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EReportLktb {
    LBDPPKK_RUTIN("LBDPPKK", EReportGroupLktb.LKD_BULANAN_RUTIN, 111, EReport.LKBT_DPPKK),
    LBDPPKK_KOREKSI("LBDPPKK", EReportGroupLktb.LKD_BULANAN_KOREKSI, 112, EReport.LKBT_DPPKK),
    LTDPPKK_RUTIN("LTDPPKK", EReportGroupLktb.LKD_TAHUNAN_RUTIN, 113, EReport.LKBT_DPPKK),
    LTDPPKK_KOREKSI("LTDPPKK", EReportGroupLktb.LKD_TAHUNAN_KOREKSI, 114, EReport.LKBT_DPPKK),

    LBDPPKS_RUTIN("LBDPPKS", EReportGroupLktb.LKD_BULANAN_RUTIN, 121, EReport.LKBT_DPPKS),
    LBDPPKS_KOREKSI("LBDPPKS", EReportGroupLktb.LKD_BULANAN_KOREKSI, 122, EReport.LKBT_DPPKS),
    LTDPPKS_RUTIN("LTDPPKS", EReportGroupLktb.LKD_TAHUNAN_RUTIN, 123, EReport.LKBT_DPPKS),
    LTDPPKS_KOREKSI("LTDPPKS", EReportGroupLktb.LKD_TAHUNAN_KOREKSI, 124, EReport.LKBT_DPPKS),

    LBDPLKK_RUTIN("LBDPLKK", EReportGroupLktb.LKD_BULANAN_RUTIN, 131, EReport.LKBT_DPLKK),
    LBDPLKK_KOREKSI("LBDPLKK", EReportGroupLktb.LKD_BULANAN_KOREKSI, 132, EReport.LKBT_DPLKK),
    LTDPLKK_RUTIN("LTDPLKK", EReportGroupLktb.LKD_TAHUNAN_RUTIN, 133, EReport.LKBT_DPLKK),
    LTDPLKK_KOREKSI("LTDPLKK", EReportGroupLktb.LKD_TAHUNAN_KOREKSI, 134, EReport.LKBT_DPLKK),

    LBDPLKS_RUTIN("LBDPLKS", EReportGroupLktb.LKD_BULANAN_RUTIN, 141, EReport.LKBT_DPLKS),
    LBDPLKS_KOREKSI("LBDPLKS", EReportGroupLktb.LKD_BULANAN_KOREKSI, 142, EReport.LKBT_DPLKS),
    LTDPLKS_RUTIN("LTDPLKS", EReportGroupLktb.LKD_TAHUNAN_RUTIN, 143, EReport.LKBT_DPLKS),
    LTDPLKS_KOREKSI("LTDPLKS", EReportGroupLktb.LKD_TAHUNAN_KOREKSI, 144, EReport.LKBT_DPLKS),
    ;

    @Getter
    private final String reportTypeCode;
    @Getter
    private final EReportGroupLktb reportGroup;
    @Getter
    private final int reportGroupCode;
    @Getter
    private final EReport report;

    public static ReportInfo getReportInfo(String reportCode, int reportMenuCode) {
        ReportInfo res = new ReportInfo();
        for (EReportLktb eEnum : EReportLktb.values()) {
            EReport eReport = eEnum.getReport();
            if (eReport.getCode().equals(reportCode) && eEnum.reportGroupCode == reportMenuCode) {
                res.setId(eEnum.name());
                res.setReport(eReport);
                res.setReportTypeCode(eEnum.getReportTypeCode());
                res.setReportGroup(eEnum.reportGroup.getObject());
                break;
            }
        }
        return res;
    }

    public static ReportInfo getUploadReportInfo(String reportCode, int reportMenuCode) {
        ReportInfo res = new ReportInfo();
        for (EReportLktb eEnum : EReportLktb.values()) {
            EReport eReport = eEnum.getReport();
            if (eReport.getCode().equals(reportCode) && eEnum.reportGroupCode == reportMenuCode) {
                res.setId(eEnum.name());
                res.setReport(eReport);
                res.setReportTypeCode(eEnum.getReportTypeCode());
                res.setReportGroup(eEnum.reportGroup.getObjectForSending());
                break;
            }
        }
        return res;
    }

    public static EReportLktb getReportGroup(int reportGroupCode) {
        for (EReportLktb e : EReportLktb.values()) {
            if (e.getReportGroupCode() == reportGroupCode)
                return e;
        }

        return null;
    }

}
