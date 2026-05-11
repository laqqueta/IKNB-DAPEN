package id.go.ojk.client.model.config.validation.conditional;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.RequiredCondition;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@XStreamAlias("ConditionalPosAndComparatorHasValue3")
public class ConditionalPosAndComparatorHasValueSbn extends MapParamConditionalRequired {
	private RequiredCondition trueCondition;
	private RequiredCondition falseCondition;
	private RequiredCondition posFalseCondition;
	private String refPosCode;
	private int comparatorField;
	private String comparatorValue;

	public ConditionalPosAndComparatorHasValueSbn() {
	}

	public ConditionalPosAndComparatorHasValueSbn(String parameter) {
		setParameter(parameter);
	}

	@Override
	public ConditionalPosAndComparatorHasValueSbn initialized() {
		trueCondition = getRequiredConditionParameter("trueCondition");
		falseCondition = getRequiredConditionParameter("falseCondition");
		posFalseCondition = getRequiredConditionParameter("posFalseCondition");
		refPosCode = getStringParameter("refPosCode");
		comparatorField = getIntParameter("comparatorField");
		comparatorValue = getStringParameter("comparatorValue");
		return this;
	}

	@Override
	public Tupple2<RequiredCondition, String> analizeRequiredCondition(SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		RequiredCondition result = trueCondition;
		String[] comparatorValues = StringUtils.split(comparatorValue, "|");
		String message = "";

		if (hasPosCode(validationResult)) {
			if (comparatorHasValue(validationResult, comparatorValues)) {
				StringBuilder sb = new StringBuilder();
                for (String value : comparatorValues) {
                    sb.append(value).append(" atau ");
                }

				message = "kolom ke " + (comparatorField + 1) + " diisi " + "'" + sb.substring(0, sb.length()-6) + "'";
				result = falseCondition;
			}

			if (result.equals(RequiredCondition.N) && StringUtils.isNotEmpty(message)) {
				message = "jika " + message;
			}
		} else {
			result = posFalseCondition;
		}

		return Tupple2.<RequiredCondition, String>builder().a(result).b(message).build();
	}

	private boolean hasPosCode(ValidationResult validationResult) {
		String value = validationResult.getColumn(1);
		List<String> list = Arrays.asList(StringUtils.split(refPosCode, "|"));
		return StringUtils.isNotEmpty(value) && list.contains(value);
	}

	private boolean comparatorHasValue(ValidationResult validationResult, String[] comparatorValues) {
		String value = validationResult.getColumn(comparatorField);

		long equalCount = Arrays.stream(comparatorValues)
				.filter(value::equals)
				.count();

		return StringUtils.isNotEmpty(value) && equalCount > 0;
	}
}
