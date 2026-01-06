package id.go.ojk.lib.client.model.config.validation.segmen;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.lib.client.model.constant.Comparation;

/**
 * TODO
 * @author PC
 *
 */
@XStreamAlias("dateFieldCompare")
public class DateFieldCompare {
	private int leftField;
	private RightDateField[] rightDateFields;
	private Comparation comparationYearMonthData;

	public DateFieldCompare(){
	}

	public DateFieldCompare(int leftField, Comparation comparationYearMonthData, RightDateField ... rightDateFields){
		this.leftField = leftField;
		this.rightDateFields = rightDateFields;
		this.comparationYearMonthData = comparationYearMonthData;
	}


	public int getLeftField() {
		return leftField;
	}
	public void setLeftField(int leftField) {
		this.leftField = leftField;
	}

	public RightDateField[] getRightDateFields() {
		return rightDateFields;
	}
	public void setRightDateFields(RightDateField[] rightDateFields) {
		this.rightDateFields = rightDateFields;
	}

	public Comparation getComparationYearMonthData() {
		return comparationYearMonthData;
	};
	public void setComparationYearMonthData(Comparation comparationYearMonthData) {
		this.comparationYearMonthData = comparationYearMonthData;
	};

	@XStreamAlias("rightDateField")
	public static class RightDateField {

		private Comparation comparation;
		private int rightField;

		public RightDateField(){
		}

		public RightDateField(Comparation comparation, int rightField){
			this.comparation = comparation;
			this.rightField = rightField;
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
}
