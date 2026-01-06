package id.go.ojk.client.model.config.validation.conditional;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.util.ToBigDecimal;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.Comparation;

@XStreamAlias("NumericComparisonConditional")
public class NumericComparisonConditional extends BaseComparisonConditional {

	public NumericComparisonConditional() {
	}

	public NumericComparisonConditional(String parameter) {
		setParameter(parameter);
	}

	@Override
	public NumericComparisonConditional initialized() {
		super.initialized();
		return this;
	}

	@Override
	protected Tupple2<Boolean, String> evaluate(SubmissionFormat submissionFormat, ValidationResult validationResult) {
		String[] arrComparatorField = StringUtils.split(comparatorField, "|");
		boolean evaluationResult = evaluate(validationResult, arrComparatorField);
		Tupple2<Boolean, String> res = Tupple2.<Boolean, String>builder().a(evaluationResult)
				.b(getMessage(arrComparatorField, comparation, evaluationResult, comparatorValue)).build();
		return res;
	}

	protected boolean evaluate(ValidationResult validationResult, String[] arrComparatorField) {
		boolean evaluationResult = true;
		if (arrComparatorField != null) {
			BigDecimal expectedComparatorValue = ToBigDecimal.convert(comparatorValue);
			for (int i = 0; i < arrComparatorField.length; i++) {
				BigDecimal realComparatorValue = ToBigDecimal
						.convert(validationResult.getColumn(Integer.parseInt(arrComparatorField[i])));
				evaluationResult = evaluate(realComparatorValue, expectedComparatorValue);
				if (!evaluationResult) {
					break;
				}
			}
		}
		return evaluationResult;
	}

	private boolean evaluate(BigDecimal realValue, BigDecimal expectedValue) {
		boolean res = true;
		switch (comparation) {
		case e:
			res = realValue.compareTo(expectedValue) == 0;
			break;
		case gt:
			res = realValue.compareTo(expectedValue) > 0;
			break;
		case gte:
			res = realValue.compareTo(expectedValue) >= 0;
			break;
		case lt:
			res = realValue.compareTo(expectedValue) < 0;
			break;
		case lte:
			res = realValue.compareTo(expectedValue) <= 0;
			break;
		case ne:
			res = realValue.compareTo(expectedValue) != 0;
			break;
		default:
			break;
		}
		return res;
	}

	private String getMessage(String[] arrComparatorField, Comparation comparation, boolean isTrue,
			String comparatorValue) {
		StringBuilder builder = new StringBuilder("kolom ");
		int length = arrComparatorField.length;
		for (int i = 0; i < length; i++) {
			builder.append(Integer.parseInt(arrComparatorField[i]) + 1);
			if (i + 1 < length) {
				builder.append(" dan ");
			}
		}
		return StringUtils.join(builder.toString(), isTrue ? " " : " tidak ", comparation.getDesc(), " ",
				comparatorValue);
	}
}
