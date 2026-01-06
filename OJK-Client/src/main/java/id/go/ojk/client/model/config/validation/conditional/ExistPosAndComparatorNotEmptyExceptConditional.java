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
@XStreamAlias("ExistPosAndComparatorNotEmptyExceptConditional")
public class ExistPosAndComparatorNotEmptyExceptConditional extends MapParamConditionalRequired {
	private RequiredCondition trueCondition;
	private RequiredCondition falseCondition;
	private String refPosCode;
    private String exceptPos;
    private RequiredCondition exceptPosCondition;
	private int comparatorFieldNumber;

	public ExistPosAndComparatorNotEmptyExceptConditional() {
	}

	public ExistPosAndComparatorNotEmptyExceptConditional(String parameter) {
		setParameter(parameter);
	}

	@Override
	public ExistPosAndComparatorNotEmptyExceptConditional initialized() {
		trueCondition = getRequiredConditionParameter("trueCondition");
		falseCondition = getRequiredConditionParameter("falseCondition");
		refPosCode = getStringParameter("refPosCode");
		comparatorFieldNumber = getIntParameter("comparatorFieldNumber");
        exceptPos = getStringParameter("exceptPos");
        exceptPosCondition = getRequiredConditionParameter("exceptPosCondition");
		return this;
	}

	@Override
	public Tupple2<RequiredCondition, String> analizeRequiredCondition(SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		RequiredCondition result = falseCondition;
		String message = "";

        if (hasExceptPosCode(validationResult)) {
            return Tupple2.<RequiredCondition, String>builder().a(exceptPosCondition).b(message).build();
        }

		if (hasPosCode(validationResult) && comparatorNotEmpty(validationResult)) {
			message = "kolom ke " + (comparatorFieldNumber + 1) + " terisi";
			result = trueCondition;
			message = message + " terisi";
		}
		if (result.equals(RequiredCondition.N) && StringUtils.isNotEmpty(message)) {
			message = "jika " + message;
		}
		return Tupple2.<RequiredCondition, String>builder().a(result).b(message).build();
	}

	private boolean hasPosCode(ValidationResult validationResult) {
		String value = validationResult.getColumn(1);
		List<String> list = Arrays.asList(StringUtils.split(refPosCode, "|"));
		return StringUtils.isNotEmpty(value) && list.contains(value);
	}

    private boolean hasExceptPosCode(ValidationResult validationResult) {
        String value = validationResult.getColumn(1);
        List<String> list = Arrays.asList(StringUtils.split(exceptPos, "|"));
        return StringUtils.isNotEmpty(value) && list.contains(value);
    }

	private boolean comparatorNotEmpty(ValidationResult validationResult) {
		String value = validationResult.getColumn(comparatorFieldNumber);
		return StringUtils.isNotEmpty(value);
	}
}
