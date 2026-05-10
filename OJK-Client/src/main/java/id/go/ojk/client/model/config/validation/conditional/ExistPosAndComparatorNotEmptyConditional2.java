package id.go.ojk.client.model.config.validation.conditional;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.RequiredCondition;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * If All "fieldNumbers" not empty will produce "trueCondition" otherwise
 * "falseCondition"
 *
 */
@XStreamAlias("ExistPosAndComparatorNotEmptyConditional2")
public class ExistPosAndComparatorNotEmptyConditional2 extends MapParamConditionalRequired {
	private RequiredCondition trueCondition;
	private RequiredCondition falseCondition;
	private RequiredCondition posFalseCondition;
	private String refPosCode;
	private int comparatorFieldNumber;

	public ExistPosAndComparatorNotEmptyConditional2() {
	}

	public ExistPosAndComparatorNotEmptyConditional2(String parameter) {
		setParameter(parameter);
	}

	@Override
	public ExistPosAndComparatorNotEmptyConditional2 initialized() {
		trueCondition = getRequiredConditionParameter("trueCondition");
		falseCondition = getRequiredConditionParameter("falseCondition");
		posFalseCondition = getRequiredConditionParameter("posFalseCondition");
		refPosCode = getStringParameter("refPosCode");
		comparatorFieldNumber = getIntParameter("comparatorFieldNumber");
		return this;
	}

	@Override
	public Tupple2<RequiredCondition, String> analizeRequiredCondition(SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		RequiredCondition result = trueCondition;
		String message = "";

		if (hasPosCode(validationResult)) {
			if (!comparatorNotEmpty(validationResult)) {
				message = "kolom ke " + (comparatorFieldNumber + 1) + " tidak diisi";
				result = falseCondition;
			} else {
				message = "kolom ke " + (comparatorFieldNumber + 1) + " diisi";
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

	private boolean comparatorNotEmpty(ValidationResult validationResult) {
		String value = validationResult.getColumn(comparatorFieldNumber);
		if (value.isEmpty()) {
			System.out.println("as");
		}
		return StringUtils.isNotEmpty(value);
	}
}
