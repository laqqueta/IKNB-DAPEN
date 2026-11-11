package id.go.ojk.client.model.config.validation.conditional;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.RequiredCondition;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

@XStreamAlias("ConditionalPosAndComparatorHasValue6")
public class ConditionalPosAndComparatorHasValue6 extends MapParamConditionalRequired {
	private RequiredCondition trueCondition1;
	private RequiredCondition falseCondition1;
	private String refPosCode1;

	private RequiredCondition trueCondition2;
	private String refPosCode2;

	private RequiredCondition defaultCondition;

	private int comparatorField;

	public ConditionalPosAndComparatorHasValue6() {
	}

	public ConditionalPosAndComparatorHasValue6(String parameter) {
		setParameter(parameter);
	}

	@Override
	public ConditionalPosAndComparatorHasValue6 initialized() {
		trueCondition1 = getRequiredConditionParameter("trueCondition1");
		falseCondition1 = getRequiredConditionParameter("falseCondition1");
		refPosCode1 = getStringParameter("refPosCode1");

		trueCondition2 = getRequiredConditionParameter("trueCondition2");
		refPosCode2 = getStringParameter("refPosCode2");

		defaultCondition = getRequiredConditionParameter("defaultCondition");

		comparatorField = getIntParameter("comparatorField");
		return this;
	}

	@Override
	public Tupple2<RequiredCondition, String> analizeRequiredCondition(SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		RequiredCondition result = falseCondition1;
		String message = "";

		if (hasPosCode2(validationResult, refPosCode1)) {
			if (comparatorHasValue(validationResult)) {
				message = "kolom ke " + (comparatorField + 1) + " diisi ";
				result = trueCondition1;
			}

			if (result.equals(RequiredCondition.N) && StringUtils.isNotEmpty(message)) {
				message = "jika " + message;
			}
		} else if (hasPosCode2(validationResult, refPosCode2)) {
			result = trueCondition2;
		} else {
			result = defaultCondition;
		}

		return Tupple2.<RequiredCondition, String>builder().a(result).b(message).build();
	}

	private boolean hasPosCode2(ValidationResult validationResult, String posCode) {
		String value = validationResult.getColumn(1);
		List<String> list = Arrays.asList(StringUtils.split(posCode, "|"));
		return StringUtils.isNotEmpty(value) && list.contains(value);
	}


	private boolean comparatorHasValue(ValidationResult validationResult) {
		String value = validationResult.getColumn(comparatorField);
		return StringUtils.isNotEmpty(value);
	}
}
