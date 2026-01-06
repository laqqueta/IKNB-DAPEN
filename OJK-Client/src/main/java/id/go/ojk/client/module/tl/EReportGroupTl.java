package id.go.ojk.client.module.tl;

import id.go.ojk.client.constant.EValidExtension;
import id.go.ojk.client.model.ReportGroup;
import id.go.ojk.lib.client.IObject;

public enum EReportGroupTl implements IObject<ReportGroup> {
	PELAPORAN (0, "R", "I", 0, EValidExtension.TXT_PDF_ZIP),
	PELAPORAN_KOREKSI (1, "K", "I", 1, EValidExtension.TXT_PDF_ZIP),
	;

	private int menuCode;
	private String deliveryCode;
	private String period;
	private int revisionCode;
	private EValidExtension validExtension;

	private EReportGroupTl(int menuCode, String deliveryCode, String period, int revisionCode, EValidExtension validExtension) {
		this.menuCode = menuCode;
		this.deliveryCode = deliveryCode;
		this.period = period;
		this.revisionCode = revisionCode;
		this.validExtension = validExtension;
	}

	public int getMenuCode() {
		return menuCode;
	}

	public String getDeliveryCode() {
		return deliveryCode;
	}

	public String getPeriod() {
		return period;
	}

	public int getRevisionCode() {
		return revisionCode;
	}

	public EValidExtension getValidExtension() {
		return validExtension;
	}

	@Override
	public ReportGroup getObject() {
		ReportGroup res = new ReportGroup();
		res.setMenuCode(menuCode);
		res.setValidExtension(validExtension);
		res.setId(name());
		res.setPeriod(period);
		res.setDeliveryCode(deliveryCode);
		res.setRevisionCode(revisionCode);
		return res;
	}

	public static ReportGroup getObjectByCode(int code) {
		ReportGroup res = null;
		for (EReportGroupTl eEnum : EReportGroupTl.values()) {
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
