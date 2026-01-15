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
    LBDPPKK_RUTIN("LBDPPKK", EReportGroupLktb.LBDPPKK_RUTIN, EReport.LKTB_DPPKK),
    LBDPPKK_KOREKSI("LBDPPKK", EReportGroupLktb.LBDPPKK_KOREKSI, EReport.LKTB_DPPKK),
    LTDPPKK_RUTIN("LTDPPKK", EReportGroupLktb.LTDPPKK_RUTIN, EReport.LKTB_DPPKK),
    LTDPPKK_KOREKSI("LTDPPKK", EReportGroupLktb.LTDPPKK_KOREKSI, EReport.LKTB_DPPKK),

    LBDPPKS_RUTIN("LBDPPKS", EReportGroupLktb.LBDPPKS_RUTIN, EReport.LKTB_DPPKS),
    LBDPPKS_KOREKSI("LBDPPKS", EReportGroupLktb.LBDPPKS_KOREKSI, EReport.LKTB_DPPKS),
    LTDPPKS_RUTIN("LTDPPKS", EReportGroupLktb.LTDPPKS_RUTIN, EReport.LKTB_DPPKS),
    LTDPPKS_KOREKSI("LTDPPKS", EReportGroupLktb.LTDPPKS_KOREKSI, EReport.LKTB_DPPKS),

    LBDPLKK_RUTIN("LBDPLKK", EReportGroupLktb.LBDPLKK_DPLK_RUTIN, EReport.LKTB_DPLKK),
    LBDPLKK_KOREKSI("LBDPLKK", EReportGroupLktb.LBDPLKK_DPLK_KOREKSI, EReport.LKTB_DPLKK),
    LTDPLKK_RUTIN("LTDPLKK", EReportGroupLktb.LTDPLKK_DPLK_RUTIN, EReport.LKTB_DPLKK),
    LTDPLKK_KOREKSI("LTDPLKK", EReportGroupLktb.LTDPLKK_DPLK_KOREKSI, EReport.LKTB_DPLKK),

    LBDPLKS_RUTIN("LBDPLKK", EReportGroupLktb.LBDPLKS_DPLK_RUTIN, EReport.LKTB_DPLKS),
    LBDPLKS_KOREKSI("LBDPLKS", EReportGroupLktb.LBDPLKS_DPLK_KOREKSI, EReport.LKTB_DPLKS),
    LTDPLKS_RUTIN("LTDPLKK", EReportGroupLktb.LTDPLKS_DPLK_RUTIN, EReport.LKTB_DPLKS),
    LTDPLKS_KOREKSI("LTDPLKK", EReportGroupLktb.LTDPLKS_DPLK_KOREKSI, EReport.LKTB_DPLKS),

    ;

    @Getter
    private String reportTypeCode;
    @Getter
    private EReportGroupLktb reportGroup;
    @Getter
    private EReport report;



    public static ReportInfo getReportInfo(String reportCode, int reportMenuCode) {
        ReportInfo res = new ReportInfo();
        for (EReportLktb eEnum : EReportLktb.values()) {
            EReport eReport = eEnum.getReport();
            if (eReport.getCode().equals(reportCode) && eEnum.reportGroup.getMenuCode() == reportMenuCode) {
                res.setId(eEnum.name());
                res.setReport(eReport);
                res.setReportTypeCode(eEnum.getReportTypeCode());
                res.setReportGroup(eEnum.reportGroup.getObject());
                break;
            }
        }
        return res;
    }

    public static List<EReportLktb> getByReport(List<EReport> reports) {
        List<EReportLktb> result = new ArrayList<EReportLktb>();
        for (EReportLktb ereport : EReportLktb.values()) {
            if (reports.contains(ereport.report))
                result.add(ereport);
        }
        return result;
    }

    public static EReportLktb getByReportCode(String reportCode) {
        for (EReportLktb eEnum : EReportLktb.values()) {
            if (eEnum.getReportTypeCode().equals(reportCode)) {
                return eEnum;
            }
        }
        return null;
    }

}
