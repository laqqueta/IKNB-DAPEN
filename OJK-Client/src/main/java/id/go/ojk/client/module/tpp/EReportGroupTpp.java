package id.go.ojk.client.module.tpp;

import id.go.ojk.client.constant.EValidExtension;
import id.go.ojk.client.model.ReportGroup;
import id.go.ojk.lib.client.IObject;
import lombok.Getter;

@Getter
public enum EReportGroupTpp implements IObject<ReportGroup> {
	RENCANA_RUTIN (1, "R", "A", 0, EValidExtension.TXT_PDF),
	RENCANA_KOREKSI (2, "K", "A", 1, EValidExtension.TXT_PDF),
	REALISASI_RUTIN (3, "R", "A", 0, EValidExtension.TXT_PDF),
	REALISASI_KOREKSI (4, "K", "A", 1, EValidExtension.TXT_PDF),
	PENILAIAN_RESIKO_RUTIN (5, "R", "A", 0, EValidExtension.TXT_PDF),
	PENILAIAN_RESIKO_KOREKSI (6, "K", "A", 1, EValidExtension.TXT_PDF),
	;

	private final int menuCode;
	private final String deliveryCode;
	private final String period;
	private final int revisionCode;
	private final EValidExtension validExtension;

	EReportGroupTpp(int menuCode, String deliveryCode, String period, int revisionCode, EValidExtension validExtension) {
		this.menuCode = menuCode;
		this.deliveryCode = deliveryCode;
		this.period = period;
		this.revisionCode = revisionCode;
		this.validExtension = validExtension;
	}

    @Override
	public ReportGroup getObject() {
		ReportGroup res = new ReportGroup();
		res.setMenuCode(menuCode);
		res.setId(name());
		res.setPeriod(period);
		res.setDeliveryCode(deliveryCode);
		res.setValidExtension(validExtension);
		res.setRevisionCode(revisionCode);
		return res;
	}
	
	public static ReportGroup getObjectByCode(int code) {
		ReportGroup res = null;
		for (EReportGroupTpp eEnum : EReportGroupTpp.values()) {
			if (eEnum.getObject().getMenuCode() == code) {
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
