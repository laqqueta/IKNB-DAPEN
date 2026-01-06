package id.go.ojk.client.model.config.validation.conditional;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.RequiredCondition;

@XStreamAlias("ConditionalPosAndComparatorHasValue")
public class ConditionalPosAndComparatorHasValue extends MapParamConditionalRequired {
	private RequiredCondition trueCondition;
	private RequiredCondition falseCondition;
	private RequiredCondition posFalseCondition;
	private String refPosCode;
	private int comparatorField;
	private String comparatorValue;

	public ConditionalPosAndComparatorHasValue() {
	}

	public ConditionalPosAndComparatorHasValue(String parameter) {
		setParameter(parameter);
	}

	@Override
	public ConditionalPosAndComparatorHasValue initialized() {
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
		RequiredCondition result = falseCondition;
		String message = "";
		if (!hasPosCode(validationResult)) {
			result = posFalseCondition;
		} else {
			if (comparatorHasValue(validationResult)) {
				message = "kolom ke " + (comparatorField + 1) + " terisi";
				result = trueCondition;
				message = message + " terisi";
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
