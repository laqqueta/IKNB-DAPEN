 package id.go.ojk.client.model.config.validation.segmen;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ComparisonFormValidation3")
public class ComparisonFormValidation3 extends ComparisonFormValidation {
	private BigDecimal comparatorBaseValue;

	public ComparisonFormValidation3() {
		super();
	}

	public ComparisonFormValidation3(String parameter) {
		super(parameter);
	}

	@Override
	public ComparisonFormValidation3 initialized() {
		super.initialized();
		comparatorBaseValue = toBigDecimal(getStringParameter("comparatorBaseValue"));
		return this;
	}

	@Override
	protected BigDecimal getComparatorValue(String idxSelectField) {
		BigDecimal value = super.getComparatorValue(idxSelectField);
		return comparatorBaseValue.subtract(value).setScale(scale, RoundingMode.HALF_UP);
	}
}