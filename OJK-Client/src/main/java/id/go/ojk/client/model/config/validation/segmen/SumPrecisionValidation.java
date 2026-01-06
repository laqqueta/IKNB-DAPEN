package id.go.ojk.client.model.config.validation.segmen;

import java.math.BigDecimal;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("sumPrecisionValidation")
public class SumPrecisionValidation extends SumValidation {
	private String precision;

	public SumPrecisionValidation() {
		super();
	}

	@Override
	public BaseFormulaValidation initialized() {
		precision = getStringParameter("precision");
		return super.initialized();
	}
	
	public SumPrecisionValidation(String parameter) {
		super(parameter);
	}
	
	@Override
	protected String genCompareScript(BigDecimal leftValue, BigDecimal rightValue, String operator) {
		if (leftValue.compareTo(rightValue) != 0) {
			BigDecimal lowValue = rightValue.subtract(new BigDecimal(precision));
			BigDecimal highValue = rightValue.add(new BigDecimal(precision));
			if ((leftValue.compareTo(lowValue) == 1) && (leftValue.compareTo(highValue) == -1)) {
				rightValue = leftValue;
			}
		}
		return leftValue + operator + rightValue;
	}
}