package id.go.ojk.client.model;

import java.io.Serializable;

import id.go.ojk.client.constant.EValidExtension;
import lombok.ToString;

@ToString
public class ReportGroup implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private int menuCode;
	private String deliveryCode;
	private String period;
	private int revisionCode;
	private EValidExtension validExtension;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(int menuCode) {
		this.menuCode = menuCode;
	}

	public String getDeliveryCode() {
		return deliveryCode;
	}

	public void setDeliveryCode(String deliveryCode) {
		this.deliveryCode = deliveryCode;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public int getRevisionCode() {
		return revisionCode;
	}

	public void setRevisionCode(int revisionCode) {
		this.revisionCode = revisionCode;
	}

	public EValidExtension getValidExtension() {
		return validExtension;
	}

	public void setValidExtension(EValidExtension validExtension) {
		this.validExtension = validExtension;
	}
}
