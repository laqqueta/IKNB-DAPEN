package id.go.ojk.lib.client.model.config.validation;

import id.go.ojk.lib.client.model.constant.Comparation;

public class FieldCompare {
	private int leftField;
	private Comparation comparation;
	private int rightField;

	public FieldCompare(){
	}

	public FieldCompare(int leftField, Comparation comparation, int rightField){
		this.leftField = leftField;
		this.comparation = comparation;
		this.rightField = rightField;

	}


	public int getLeftField() {
		return leftField;
	}
	public void setLeftField(int leftField) {
		this.leftField = leftField;
	}

	public Comparation getComparation() {
		return comparation;
	}
	public void setComparation(Comparation comparation) {
		this.comparation = comparation;
	}

	public int getRightField() {
		return rightField;
	}
	public void setRightField(int rightField) {
		this.rightField = rightField;
	}
}
