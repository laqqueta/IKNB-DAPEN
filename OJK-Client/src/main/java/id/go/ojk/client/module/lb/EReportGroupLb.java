package id.go.ojk.client.module.lb;

import id.go.ojk.client.constant.EValidExtension;
import id.go.ojk.client.model.ReportGroup;
import id.go.ojk.lib.client.IObject;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EReportGroupLb implements IObject<ReportGroup> {
	PELAPORAN (1, "R", "M", 0, EValidExtension.TXT_PDF),
	PERUBAHAN (2, "K", "M", 1, EValidExtension.TXT_PDF),
	PENYESUAIAN (3, "K", "M", 2, EValidExtension.TXT_PDF),
	PENYESUAIAN_KAP (4, "K", "M", 3, EValidExtension.TXT_PDF),
	PENYESUAIAN_2 (5, "K", "M", 1, EValidExtension.TXT_PDF),
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
		for (EReportGroupLb eEnum : EReportGroupLb.values()) {
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
