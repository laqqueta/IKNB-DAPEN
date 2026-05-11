package id.go.ojk.client.module.lktb;

import id.go.ojk.client.constant.EReport;
import id.go.ojk.client.model.ReportInfo;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.lib.client.model.constant.Comparation;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EReportLktb {
    LBDPPKK_RUTIN("LBDPPKK", EReportGroupLktb.LKD_BULANAN_RUTIN, 111, EReport.LKTB_DPPKK),
    LBDPPKK_KOREKSI("LBDPPKK", EReportGroupLktb.LKD_BULANAN_KOREKSI, 112, EReport.LKTB_DPPKK),
    LTDPPKK_RUTIN("LTDPPKK", EReportGroupLktb.LKD_TAHUNAN_RUTIN, 113, EReport.LKTB_DPPKK),
    LTDPPKK_KOREKSI("LTDPPKK", EReportGroupLktb.LKD_TAHUNAN_KOREKSI, 114, EReport.LKTB_DPPKK),

    LBDPPKS_RUTIN("LBDPPKS", EReportGroupLktb.LKD_BULANAN_RUTIN, 121, EReport.LKTB_DPPKS),
    LBDPPKS_KOREKSI("LBDPPKS", EReportGroupLktb.LKD_BULANAN_KOREKSI, 122, EReport.LKTB_DPPKS),
    LTDPPKS_RUTIN("LTDPPKS", EReportGroupLktb.LKD_TAHUNAN_RUTIN, 123, EReport.LKTB_DPPKS),
    LTDPPKS_KOREKSI("LTDPPKS", EReportGroupLktb.LKD_TAHUNAN_KOREKSI, 124, EReport.LKTB_DPPKS),

    LBDPLKK_RUTIN("LBDPLKK", EReportGroupLktb.LKD_BULANAN_RUTIN, 131, EReport.LKTB_DPLKK),
    LBDPLKK_KOREKSI("LBDPLKK", EReportGroupLktb.LKD_BULANAN_KOREKSI, 132, EReport.LKTB_DPLKK),
    LTDPLKK_RUTIN("LTDPLKK", EReportGroupLktb.LKD_TAHUNAN_RUTIN, 133, EReport.LKTB_DPLKK),
    LTDPLKK_KOREKSI("LTDPLKK", EReportGroupLktb.LKD_TAHUNAN_KOREKSI, 134, EReport.LKTB_DPLKK),

    LBDPLKS_RUTIN("LBDPLKS", EReportGroupLktb.LKD_BULANAN_RUTIN, 141, EReport.LKTB_DPLKS),
    LBDPLKS_KOREKSI("LBDPLKS", EReportGroupLktb.LKD_BULANAN_KOREKSI, 142, EReport.LKTB_DPLKS),
    LTDPLKS_RUTIN("LTDPLKS", EReportGroupLktb.LKD_TAHUNAN_RUTIN, 143, EReport.LKTB_DPLKS), 
    LTDPLKS_KOREKSI("LTDPLKS", EReportGroupLktb.LKD_TAHUNAN_KOREKSI, 144, EReport.LKTB_DPLKS),
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
