package id.go.ojk.client.module.lktb;

import id.go.ojk.client.constant.EValidExtension;
import id.go.ojk.client.model.ReportGroup;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.constant.DisplayScene;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EReportGroupLktb implements IObject<ReportGroup> {
    /* --- BPKS --- */
//    LBDPPKK_PPMPM_RUTIN(1, "R", "M", 0, EValidExtension.TXT_PDF),
//    LBDPPKK_PPMPM_KOREKSI(2, "K", "M", 1, EValidExtension.TXT_PDF),
//    LBDPPKK_PPMPK_RUTIN(3, "R", "M", 0, EValidExtension.TXT_PDF),
//    LBDPPKK_PPMPK_KOREKSI(4, "K", "M", 1, EValidExtension.TXT_PDF),
//    LBDPPKK_PPIPM_RUTIN(5, "R", "M", 0, EValidExtension.TXT_PDF),
//    LBDPPKK_PPIPM_KOREKSI(6, "K", "M", 1, EValidExtension.TXT_PDF),
//    LBDPPKK_PPIPK_RUTIN(7, "R", "M", 0, EValidExtension.TXT_PDF),
//    LBDPPKK_PPIPK_KOREKSI(8, "K", "M", 1, EValidExtension.TXT_PDF),
//    LBDPPKK_PPMPPPIPK_RUTIN(9, "R", "M", 0, EValidExtension.TXT_PDF),
//    LBDPPKK_PPMPPPIPK_KOREKSI(10, "K", "M", 1, EValidExtension.TXT_PDF),
//    LTDPPKK_PPMPM_RUTIN(11, "R", "A", 0, EValidExtension.TXT_PDF),
//    LTDPPKK_PPMPM_KOREKSI(12, "K", "A", 1, EValidExtension.TXT_PDF),
//    LTDPPKK_PPMPK_RUTIN(13, "R", "A", 0, EValidExtension.TXT_PDF),
//    LTDPPKK_PPMPK_KOREKSI(14, "K", "A", 1, EValidExtension.TXT_PDF),
//    LTDPPKK_PPIPM_RUTIN(15, "R", "A", 0, EValidExtension.TXT_PDF),
//    LTDPPKK_PPIPM_KOREKSI(16, "K", "A", 1, EValidExtension.TXT_PDF),
//    LTDPPKK_PPIPK_RUTIN(17, "R", "A", 0, EValidExtension.TXT_PDF),
//    LTDPPKK_PPIPK_KOREKSI(18, "K", "A", 1, EValidExtension.TXT_PDF),
//    LTDPPKK_PPMPPPIPK_RUTIN(19, "R", "A", 0, EValidExtension.TXT_PDF),
//    LTDPPKK_PPMPPPIPK_KOREKSI(20, "K", "A", 1, EValidExtension.TXT_PDF),
//    LBDPPKS_PPMPM_RUTIN(21, "R", "M", 0, EValidExtension.TXT_PDF),
//    LBDPPKS_PPMPM_KOREKSI(22, "K", "M", 1, EValidExtension.TXT_PDF),
//    LBDPPKS_PPMPK_RUTIN(23, "R", "M", 0, EValidExtension.TXT_PDF),
//    LBDPPKS_PPMPK_KOREKSI(24, "K", "M", 1, EValidExtension.TXT_PDF),
//    LBDPPKS_PPIPM_RUTIN(25, "R", "M", 0, EValidExtension.TXT_PDF),
//    LBDPPKS_PPIPM_KOREKSI(26, "K", "M", 1, EValidExtension.TXT_PDF),
//    LBDPPKS_PPIPK_RUTIN(27, "R", "M", 0, EValidExtension.TXT_PDF),
//    LBDPPKS_PPIPK_KOREKSI(28, "K", "M", 1, EValidExtension.TXT_PDF),
//    LBDPPKS_PPMPPPIPK_RUTIN(29, "R", "M", 0, EValidExtension.TXT_PDF),
//    LBDPPKS_PPMPPPIPK_KOREKSI(30, "K", "M", 1, EValidExtension.TXT_PDF),
//    LTDPPKS_PPMPM_RUTIN(31, "R", "M", 0, EValidExtension.TXT_PDF),
//    LTDPPKS_PPMPM_KOREKSI(32, "K", "M", 1, EValidExtension.TXT_PDF),
//    LTDPPKS_PPMPK_RUTIN(33, "R", "M", 0, EValidExtension.TXT_PDF),
//    LTDPPKS_PPMPK_KOREKSI(34, "K", "M", 1, EValidExtension.TXT_PDF),
//    LTDPPKS_PPIPM_RUTIN(35, "R", "M", 0, EValidExtension.TXT_PDF),
//    LTDPPKS_PPIPM_KOREKSI(36, "K", "M", 1, EValidExtension.TXT_PDF),
//    LTDPPKS_PPIPK_RUTIN(37, "R", "M", 0, EValidExtension.TXT_PDF),
//    LTDPPKS_PPIPK_KOREKSI(38, "K", "M", 1, EValidExtension.TXT_PDF),
//    LTDPPKS_PPMPPPIPK_RUTIN(39, "R", "M", 0, EValidExtension.TXT_PDF),
//    LTDPPKS_PPMPPPIPK_KOREKSI(40, "K", "M", 1, EValidExtension.TXT_PDF),
    LBDPPKK_RUTIN(1, "R", "M", 0, EValidExtension.TXT_PDF),
    LBDPPKK_KOREKSI(2, "K", "M", 1, EValidExtension.TXT_PDF),
    LTDPPKK_RUTIN(3, "R", "M", 0, EValidExtension.TXT_PDF),
    LTDPPKK_KOREKSI(4, "K", "M", 1, EValidExtension.TXT_PDF),
    LBDPPKS_RUTIN(5, "R", "M", 0, EValidExtension.TXT_PDF),
    LBDPPKS_KOREKSI(6, "K", "M", 1, EValidExtension.TXT_PDF),
    LTDPPKS_RUTIN(7, "R", "M", 0, EValidExtension.TXT_PDF),
    LTDPPKS_KOREKSI(8, "R", "M", 1, EValidExtension.TXT_PDF),
    LBDPLKK_DPLK_RUTIN(9, "R", "M", 0, EValidExtension.TXT_PDF),
    LBDPLKK_DPLK_KOREKSI(10, "K", "M", 1, EValidExtension.TXT_PDF),
    LTDPLKK_DPLK_RUTIN(11, "R", "M", 0, EValidExtension.TXT_PDF),
    LTDPLKK_DPLK_KOREKSI(12, "K", "M", 1, EValidExtension.TXT_PDF),
    LBDPLKS_DPLK_RUTIN(13, "R", "M", 0, EValidExtension.TXT_PDF),
    LBDPLKS_DPLK_KOREKSI(14, "K", "M", 1, EValidExtension.TXT_PDF),
    LTDPLKS_DPLK_RUTIN(15, "R", "M", 0, EValidExtension.TXT_PDF),
    LTDPLKS_DPLK_KOREKSI(16, "K", "M", 1, EValidExtension.TXT_PDF),

    ;

    @Getter
    private int menuCode;
    @Getter
    private String deliveryCode;
    @Getter
    private String period;
    @Getter
    private int revisionCode;
    @Getter
    private EValidExtension validExtension;

    @Override
    public ReportGroup getObject() {
        ReportGroup res = new ReportGroup();
        res.setMenuCode(menuCode);
        res.setId(name());
        res.setPeriod(period);
        res.setDeliveryCode(deliveryCode);
        res.setRevisionCode(revisionCode);
        res.setValidExtension(validExtension);
        return res;
    }

    public static ReportGroup getObjectByCode(int code) {
        ReportGroup res = null;
        for (EReportGroupLktb eEnum : EReportGroupLktb.values()) {
            if (eEnum.getObject().getMenuCode() == code) {
                res = eEnum.getObject();
                break;
            }
        }
        return res;
    }

    public static EReportGroupLktb getReportGroupByScene(DisplayScene scene) {
        for (EReportGroupLktb reportGroup : EReportGroupLktb.values()) {
            String reportGroupName = reportGroup.toString().split("_")[0];
            if (reportGroupName.equalsIgnoreCase(scene.toString())) {
                return reportGroup;
            }
        }
        throw new IllegalArgumentException("Report group not found for scene " + scene);
    }

    public static boolean isKoreksiPengawas(int code) {
        return getRevisionCodeByCode(code) == 2;
    }

    public static int getRevisionCodeByCode(int code) {
        ReportGroup res = getObjectByCode(code);
        return res != null ? res.getRevisionCode() : 0;
    }
}
