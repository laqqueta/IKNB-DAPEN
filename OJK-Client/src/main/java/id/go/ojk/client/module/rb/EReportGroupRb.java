package id.go.ojk.client.module.rb;

import id.go.ojk.client.constant.EValidExtension;
import id.go.ojk.client.model.ReportGroup;
import id.go.ojk.lib.client.IObject;

public enum EReportGroupRb implements IObject<ReportGroup> {
	PELAPORAN (1, "R", "A", 0, EValidExtension.TXT_PDF),
	PERUBAHAN (2, "K", "A", 1, EValidExtension.TXT_PDF),
	PENYESUAIAN (3, "K", "A", 2, EValidExtension.TXT_PDF),
	REALISASI (4, "R", "S", 0, EValidExtension.TXT_PDF),
	PENGAWASAN (5, "R", "S", 0, EValidExtension.PDF),
	;
	
	private int menuCode;
	private String deliveryCode;
	private String period;
	private int revisionCode;
	private EValidExtension validExtension;
	
	private EReportGroupRb(int menuCode, String deliveryCode, String period, int revisionCode, EValidExtension validExtension) {
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
		for (EReportGroupRb eEnum : EReportGroupRb.values()) {
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
