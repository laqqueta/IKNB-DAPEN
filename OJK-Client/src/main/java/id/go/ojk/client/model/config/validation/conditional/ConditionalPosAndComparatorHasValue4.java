package id.go.ojk.client.model.config.validation.conditional;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.RequiredCondition;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

@XStreamAlias("ConditionalPosAndComparatorHasValue4")
public class ConditionalPosAndComparatorHasValue4 extends MapParamConditionalRequired {
    private RequiredCondition trueCondition;
    private RequiredCondition falseCondition;
    private String refPosCode;
    private int comparatorField;
    private String comparatorValue;

    public ConditionalPosAndComparatorHasValue4() {
    }

    public ConditionalPosAndComparatorHasValue4(String parameter) {
        setParameter(parameter);
    }

    @Override
    public ConditionalPosAndComparatorHasValue4 initialized() {
        trueCondition = getRequiredConditionParameter("trueCondition");
        falseCondition = getRequiredConditionParameter("falseCondition");
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
        if (hasPosCode(validationResult) && comparatorHasValue(validationResult)) {
            message = "kolom ke " + (comparatorField + 1) + " terisi";
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

    private boolean comparatorHasValue(ValidationResult validationResult) {
        String value = validationResult.getColumn(comparatorField);
        return StringUtils.isNotEmpty(value) && value.equals(comparatorValue);
    }
}
