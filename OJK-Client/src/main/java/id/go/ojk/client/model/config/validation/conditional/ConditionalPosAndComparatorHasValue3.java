package id.go.ojk.client.model.config.validation.conditional;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.RequiredCondition;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

@XStreamAlias("ConditionalPosAndComparatorHasValue3")
public class ConditionalPosAndComparatorHasValue3 extends MapParamConditionalRequired {
	private RequiredCondition trueCondition;
	private RequiredCondition falseCondition;
	private RequiredCondition posFalseCondition;
	private String refPosCode;
	private int comparatorField;
	private String comparatorValue;
	private String comparatorTrueValue;

	public ConditionalPosAndComparatorHasValue3() {
	}

	public ConditionalPosAndComparatorHasValue3(String parameter) {
		setParameter(parameter);
	}

	@Override
	public ConditionalPosAndComparatorHasValue3 initialized() {
		trueCondition = getRequiredConditionParameter("trueCondition");
		falseCondition = getRequiredConditionParameter("falseCondition");
		posFalseCondition = getRequiredConditionParameter("posFalseCondition");
		refPosCode = getStringParameter("refPosCode");
		comparatorField = getIntParameter("comparatorField");
		comparatorValue = getStringParameter("comparatorValue");
		comparatorTrueValue = getStringParameter("comparatorTrueValue");
		return this;
	}

	@Override
	public Tupple2<RequiredCondition, String> analizeRequiredCondition(SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		RequiredCondition result = falseCondition;
		String message = "";
		if (!hasPosCode(validationResult)) {
			result = posFalseCondition;
		} else {
			message = "kolom ke " + (comparatorField + 1);
			if (comparatorHasValue(validationResult)) {
				message = message + " terisi '" + comparatorTrueValue + "'";
				result = trueCondition;
			} else {
				message = message + " diisi selain '" + comparatorTrueValue + "'";
			}
			if (result.equals(RequiredCondition.N) && StringUtils.isNotEmpty(message)) {
				message = "jika " + message;
			}
		}
		return Tupple2.<RequiredCondition, String>builder().a(result).b(message).build();
	}

	private boolean hasPosCode(ValidationResult validationResult) {
		String value = validationResult.getColumn(1);
		List<String> list = Arrays.asList(StringUtils.split(refPosCode, "|"));
		return StringUtils.isNotEmpty(value) && list.contains(value);
	}

	private boolean comparatorHasValue(ValidationResult validationResult) {
		String value = validationResult.getColumn(comparatorField);
		return StringUtils.isNotEmpty(value) && value.equals(comparatorValue);
	}
}
