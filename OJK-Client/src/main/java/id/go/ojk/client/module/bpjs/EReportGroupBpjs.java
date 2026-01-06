package id.go.ojk.client.module.bpjs;

import id.go.ojk.client.constant.EValidExtension;
import id.go.ojk.client.model.ReportGroup;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.constant.DisplayScene;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EReportGroupBpjs implements IObject<ReportGroup> {
  /* --- BPKS --- */
  LBBPKSLK_RUTIN(1, "R", "M", 0, EValidExtension.TXT_PDF),
  LBBPKSLK_KOREKSI(2, "K", "M", 1, EValidExtension.TXT_PDF),
  LBBPKSLK_KOREKSI_PENGAWAS(3, "K", "M", 2, EValidExtension.TXT_PDF),
  LBBPKSDJS_RUTIN(4, "R", "M", 0, EValidExtension.TXT_PDF),
  LBBPKSDJS_KOREKSI(5, "K", "M", 1, EValidExtension.TXT_PDF),
  LBBPKSDJS_KOREKSI_PENGAWAS(6, "K", "M", 2, EValidExtension.TXT_PDF),
  LBBPKSLPP_RUTIN(7, "R", "M", 0, EValidExtension.TXT_PDF),
  LBBPKSLPP_KOREKSI(8, "K", "M", 1, EValidExtension.TXT_PDF),
  LBBPKSLPP_KOREKSI_PENGAWAS(9, "K", "M", 2, EValidExtension.TXT_PDF),

  /* --- BPTK 1 --- */
  LBBPTKBDN_RUTIN(10, "R", "M", 0, EValidExtension.TXT_PDF),
  LBBPTKBDN_KOREKSI(11, "K", "M", 1, EValidExtension.TXT_PDF),
  LBBPTKBDN_KOREKSI_PENGAWAS(12, "K", "M", 2, EValidExtension.TXT_PDF),
  LBBPTKJKK_RUTIN(13, "R", "M", 0, EValidExtension.TXT_PDF),
  LBBPTKJKK_KOREKSI(14, "K", "M", 1, EValidExtension.TXT_PDF),
  LBBPTKJKK_KOREKSI_PENGAWAS(15, "K", "M", 2, EValidExtension.TXT_PDF),
  LBBPTKJK_RUTIN(16, "R", "M", 0, EValidExtension.TXT_PDF),
  LBBPTKJK_KOREKSI(17, "K", "M", 1, EValidExtension.TXT_PDF),
  LBBPTKJK_KOREKSI_PENGAWAS(18, "K", "M", 2, EValidExtension.TXT_PDF),
  LBBPTKJHT_RUTIN(19, "R", "M", 0, EValidExtension.TXT_PDF),
  LBBPTKJHT_KOREKSI(20, "K", "M", 1, EValidExtension.TXT_PDF),
  LBBPTKJHT_KOREKSI_PENGAWAS(21, "K", "M", 2, EValidExtension.TXT_PDF),
  LBBPTKJKP_RUTIN(22, "R", "M", 0, EValidExtension.TXT_PDF),
  LBBPTKJKP_KOREKSI(23, "K", "M", 1, EValidExtension.TXT_PDF),
  LBBPTKJKP_KOREKSI_PENGAWAS(24, "K", "M", 2, EValidExtension.TXT_PDF),
  LBBPTKJP_RUTIN(25, "R", "M", 0, EValidExtension.TXT_PDF),
  LBBPTKJP_KOREKSI(26, "K", "M", 1, EValidExtension.TXT_PDF),
  LBBPTKJP_KOREKSI_PENGAWAS(27, "K", "M", 2, EValidExtension.TXT_PDF),

  /* --- BPTK 2 --- */
  LPBPTKJKK_RUTIN(28, "R", "A", 0, EValidExtension.TXT_PDF),
  LPBPTKJKK_KOREKSI(29, "K", "A", 1, EValidExtension.TXT_PDF),
  LPBPTKJKK_KOREKSI_PENGAWAS(30, "K", "A", 2, EValidExtension.TXT_PDF),
  LPBPTKJK_RUTIN(31, "R", "A", 0, EValidExtension.TXT_PDF),
  LPBPTKJK_KOREKSI(32, "K", "A", 1, EValidExtension.TXT_PDF),
  LPBPTKJK_KOREKSI_PENGAWAS(33, "K", "A", 2, EValidExtension.TXT_PDF),
  LPBPTKJHT_RUTIN(34, "R", "A", 0, EValidExtension.TXT_PDF),
  LPBPTKJHT_KOREKSI(35, "K", "A", 1, EValidExtension.TXT_PDF),
  LPBPTKJHT_KOREKSI_PENGAWAS(36, "K", "A", 2, EValidExtension.TXT_PDF),
  LPBPTKJKP_RUTIN(37, "R", "A", 0, EValidExtension.TXT_PDF),
  LPBPTKJKP_KOREKSI(38, "K", "A", 1, EValidExtension.TXT_PDF),
  LPBPTKJKP_KOREKSI_PENGAWAS(39, "K", "A", 2, EValidExtension.TXT_PDF),
  LPBPTKJP_RUTIN(40, "R", "A", 0, EValidExtension.TXT_PDF),
  LPBPTKJP_KOREKSI(41, "K", "A", 1, EValidExtension.TXT_PDF),
  LPBPTKJP_KOREKSI_PENGAWAS(42, "K", "A", 2, EValidExtension.TXT_PDF),

  LABPTKJKK_RUTIN(43, "R", "A", 0, EValidExtension.TXT_PDF),
  LABPTKJKK_KOREKSI(44, "K", "A", 1, EValidExtension.TXT_PDF),
  LABPTKJKK_KOREKSI_PENGAWAS(45, "K", "A", 2, EValidExtension.TXT_PDF),
  LABPTKJK_RUTIN(46, "R", "A", 0, EValidExtension.TXT_PDF),
  LABPTKJK_KOREKSI(47, "K", "A", 1, EValidExtension.TXT_PDF),
  LABPTKJK_KOREKSI_PENGAWAS(48, "K", "A", 2, EValidExtension.TXT_PDF),
  LABPTKJHT_RUTIN(49, "R", "A", 0, EValidExtension.TXT_PDF),
  LABPTKJHT_KOREKSI(50, "K", "A", 1, EValidExtension.TXT_PDF),
  LABPTKJHT_KOREKSI_PENGAWAS(51, "K", "A", 2, EValidExtension.TXT_PDF),
  LABPTKJKP_RUTIN(52, "R", "A", 0, EValidExtension.TXT_PDF),
  LABPTKJKP_KOREKSI(53, "K", "A", 1, EValidExtension.TXT_PDF),
  LABPTKJKP_KOREKSI_PENGAWAS(54, "K", "A", 2, EValidExtension.TXT_PDF),
  LABPTKJP_RUTIN(55, "R", "A", 0, EValidExtension.TXT_PDF),
  LABPTKJP_KOREKSI(56, "K", "A", 1, EValidExtension.TXT_PDF),
  LABPTKJP_KOREKSI_PENGAWAS(57, "K", "A", 2, EValidExtension.TXT_PDF),

  LTBPTKBDN_RUTIN(58, "R", "A", 0, EValidExtension.TXT_PDF),
  LTBPTKBDN_KOREKSI(59, "K", "A", 1, EValidExtension.TXT_PDF),
  LTBPTKBDN_KOREKSI_PENGAWAS(60, "K", "A", 2, EValidExtension.TXT_PDF),
  LTBPTKJKK_RUTIN(61, "R", "A", 0, EValidExtension.TXT_PDF),
  LTBPTKJKK_KOREKSI(62, "K", "A", 1, EValidExtension.TXT_PDF),
  LTBPTKJKK_KOREKSI_PENGAWAS(63, "K", "A", 2, EValidExtension.TXT_PDF),
  LTBPTKJK_RUTIN(64, "R", "A", 0, EValidExtension.TXT_PDF),
  LTBPTKJK_KOREKSI(65, "K", "A", 1, EValidExtension.TXT_PDF),
  LTBPTKJK_KOREKSI_PENGAWAS(66, "K", "A", 2, EValidExtension.TXT_PDF),
  LTBPTKJHT_RUTIN(67, "R", "A", 0, EValidExtension.TXT_PDF),
  LTBPTKJHT_KOREKSI(68, "K", "A", 1, EValidExtension.TXT_PDF),
  LTBPTKJHT_KOREKSI_PENGAWAS(69, "K", "A", 2, EValidExtension.TXT_PDF),
  LTBPTKJKP_RUTIN(70, "R", "A", 0, EValidExtension.TXT_PDF),
  LTBPTKJKP_KOREKSI(71, "K", "A", 1, EValidExtension.TXT_PDF),
  LTBPTKJKP_KOREKSI_PENGAWAS(72, "K", "A", 2, EValidExtension.TXT_PDF),
  LTBPTKJP_RUTIN(73, "R", "A", 0, EValidExtension.TXT_PDF),
  LTBPTKJP_KOREKSI(74, "K", "A", 1, EValidExtension.TXT_PDF),
  LTBPTKJP_KOREKSI_PENGAWAS(75, "K", "A", 2, EValidExtension.TXT_PDF),
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
    for (EReportGroupBpjs eEnum : EReportGroupBpjs.values()) {
      if (eEnum.getObject().getMenuCode() == code) {
        res = eEnum.getObject();
        break;
      }
    }
    return res;
  }

  public static EReportGroupBpjs getReportGroupByScene(DisplayScene scene) {
    for (EReportGroupBpjs reportGroup : EReportGroupBpjs.values()) {
      String reportGroupName = reportGroup.toString().split("_")[0];
      if(reportGroupName.equalsIgnoreCase(scene.toString())) {
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
