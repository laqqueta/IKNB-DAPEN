package id.go.ojk.client.module.lktb;

import id.go.ojk.client.constant.EValidExtension;
import id.go.ojk.client.model.ReportGroup;
import id.go.ojk.lib.client.IObject;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static id.go.ojk.lib.client.model.config.DataType.numeric;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EReportGroupLktb implements IObject<ReportGroup> {
    LKD_BULANAN_RUTIN(1, "R", "M", 0, EValidExtension.TXT_PDF, 111),
    LKD_BULANAN_KOREKSI(2, "K", "M", 2, EValidExtension.TXT_PDF, 112),

    LKD_TAHUNAN_RUTIN(3, "R", "A", 0, EValidExtension.TXT_PDF, 113),
    LKD_TAHUNAN_KOREKSI(4, "K", "A", 2, EValidExtension.TXT_PDF, 114),

    ;

    @Getter
    private final int menuCode;
    @Getter
    private final String deliveryCode;
    @Getter
    private final String period;
    @Getter
    private final int revisionCode;
    @Getter
    private final EValidExtension validExtension;
    @Getter
    private final int code;

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
        EReportLktb eReportLktb = EReportLktb.getReportGroup(code);
        int tmpCode;

        if (eReportLktb == null)
            throw new IllegalStateException();

        String reportType = eReportLktb.getReportTypeCode();

        if (reportType.contains("DPPKS"))
            tmpCode = code - 10;
        else if (reportType.contains("DPLKK")) {
            tmpCode = code - 20;
        } else if (reportType.contains("DPLKS")) {
            tmpCode = code - 30;
        } else {
            tmpCode = code;
        }

        for (EReportGroupLktb eEnum : EReportGroupLktb.values()) {
            if (tmpCode == eEnum.getCode()) {
                res = eEnum.getObject();
                break;
            }
        }
        return res;
    }

    public static int getRevisionCodeByCode(int code) {
        ReportGroup res = getObjectByCode(code);
        return res != null ? res.getRevisionCode() : 0;
    }
}
