package id.go.ojk.client.constant;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public enum EPelaporanIdReport {

    LKBT(Arrays.asList(EReport.LKBT_DPPKK, EReport.LKBT_DPPKS, EReport.LKBT_DPLKK, EReport.LKBT_DPLKS))

    ;

    private final List<EReport> eReport;

    public static boolean isPelaporanIdLoginOnly(String report) {
        String reportCode = StringUtils.split(report, "|")[1];
        for (EPelaporanIdReport vals : EPelaporanIdReport.values()) {
            for (EReport reportAvail : vals.eReport ) {
                if (reportCode.equals(reportAvail.getCode())) return true;
            }
        }

        return false;
    }
}
