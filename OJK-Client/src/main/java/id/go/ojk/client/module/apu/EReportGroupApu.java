package id.go.ojk.client.module.apu;

import id.go.ojk.client.constant.EValidExtension;
import id.go.ojk.client.model.ReportGroup;
import id.go.ojk.lib.client.IObject;

public enum EReportGroupApu implements IObject<ReportGroup> {
	PENILAIAN_RUTIN (1, "R", "A", 0, EValidExtension.TXT),
	PENILAIAN_KOREKSI (2, "K", "A", 1, EValidExtension.TXT),
	RENCANA_RUTIN (3, "R", "A", 0, EValidExtension.TXT_PDF),
	RENCANA_KOREKSI (4, "K", "A", 1, EValidExtension.TXT_PDF),
	REALISASI_RUTIN (5, "R", "A", 0, EValidExtension.TXT_PDF),
	REALISASI_KOREKSI (6, "K", "A", 1, EValidExtension.TXT_PDF),
	PENILAIAN_RUTIN_2 (7, "R", "A", 0, EValidExtension.TXT),
	PENILAIAN_KOREKSI_2 (8, "K", "A", 1, EValidExtension.TXT),
	PENILAIAN_PERBAIKAN (9, "K", "A", 2, EValidExtension.TXT),
	;
	
	private int menuCode;
	private String deliveryCode;
	private String period;
	private int revisionCode;
	private EValidExtension validExtension;
	
	private EReportGroupApu(int menuCode, String deliveryCode, String period, int revisionCode, EValidExtension validExtension) {
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
		res.setId(name());
		res.setPeriod(period);
		res.setDeliveryCode(deliveryCode);
		res.setValidExtension(validExtension);
		res.setRevisionCode(revisionCode);
		return res;
	}
	
	public static ReportGroup getObjectByCode(int code) {
		ReportGroup res = null;
		for (EReportGroupApu eEnum : EReportGroupApu.values()) {
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
