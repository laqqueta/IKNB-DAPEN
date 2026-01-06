package id.go.ojk.client.model.config.validation.conditional;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.util.ToBigDecimal;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.RequiredCondition;

@XStreamAlias("BetweenCondition")
public class NotBetweenCondition extends BaseFieldCondition {
	private int comparatorField;
	private BigDecimal comparatorLowValue;
	private BigDecimal comparatorHighValue;

	public NotBetweenCondition() {
	}

	public NotBetweenCondition(String parameter) {
		setParameter(parameter);
	}

	@Override
	public NotBetweenCondition initialized() {
		super.initialized();
		this.comparatorField = getIntParameter("comparatorField");
		this.comparatorLowValue = getAsBigDecimal("comparatorLowValue");
		this.comparatorHighValue = getAsBigDecimal("comparatorHighValue");
		return this;
	}

	@Override
	public Tupple2<RequiredCondition, String> analizeRequiredCondition(SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		RequiredCondition result = validateCondition(validationResult);
		String rowValue = validationResult.getColumn(comparatorField);
		String message = StringUtils.isNotEmpty(rowValue)
				? ("nilai kolom " + (comparatorField + 1) + " < " + comparatorLowValue + " atau > "
						+ comparatorHighValue)
				: "";
		if (result.equals(RequiredCondition.N) && StringUtils.isNotBlank(message)) {
			message = "jika " + message;
		}
		return Tupple2.<RequiredCondition, String>builder().a(result).b(message).build();
	}

	protected RequiredCondition validateCondition(ValidationResult validationResult) {
		String rowValue = validationResult.getColumn(comparatorField);
		BigDecimal realValue = ToBigDecimal.convert(rowValue);
		boolean isBetween = realValue.compareTo(comparatorLowValue) < 0 || realValue.compareTo(comparatorHighValue) > 0;
		return isBetween ? trueCondition : falseCondition;
	}
}
