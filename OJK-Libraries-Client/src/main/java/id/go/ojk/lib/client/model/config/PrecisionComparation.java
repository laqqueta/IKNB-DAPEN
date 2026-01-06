package id.go.ojk.lib.client.model.config;

public class PrecisionComparation {
	private Double leftValue;
	private Double rightValue;
	private Double precisionValue;

	public PrecisionComparation(Double leftValue, Double rightValue, Double precisionValue) {
		this.leftValue = leftValue;
		this.rightValue = rightValue;
		this.precisionValue = precisionValue;
	}

	public Boolean compare() {
		Double result = Math.abs(leftValue - rightValue);

		return result <= precisionValue ? true : false;
	}
}
