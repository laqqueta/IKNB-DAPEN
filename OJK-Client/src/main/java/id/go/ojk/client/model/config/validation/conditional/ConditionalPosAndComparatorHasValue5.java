package id.go.ojk.client.model.config.validation.conditional;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.RequiredCondition;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

@XStreamAlias("ConditionalPosAndComparatorHasValue5")
public class ConditionalPosAndComparatorHasValue5 extends MapParamConditionalRequired {
    private RequiredCondition trueCondition;
    private RequiredCondition falseCondition;
    private String refPosCode;
    private String comparatorPosCode;
    private int comparatorField;
    private String comparatorValue;

    public ConditionalPosAndComparatorHasValue5() {
    }

    public ConditionalPosAndComparatorHasValue5(String parameter) {
        setParameter(parameter);
    }

    @Override
    public ConditionalPosAndComparatorHasValue5 initialized() {
        trueCondition = getRequiredConditionParameter("trueCondition");
        falseCondition = getRequiredConditionParameter("falseCondition");
        refPosCode = getStringParameter("refPosCode");
        comparatorPosCode = getStringParameter("comparatorPosCode");
        comparatorField = getIntParameter("comparatorField");
        comparatorValue = getStringParameter("comparatorValue");
        return this;
    }

    @Override
    public Tupple2<RequiredCondition, String> analizeRequiredCondition(SubmissionFormat submissionFormat,
                                                                       ValidationResult validationResult) {
        RequiredCondition result = falseCondition;
        String message = "";

        if (hasPosCode(validationResult) && comparatorHasValue(comparatorField)) {
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

    private boolean comparatorHasValue(int fieldComparator) {
        String valueComparator = SubmissionFormat.getMapPosValue(comparatorPosCode, String.valueOf(fieldComparator));
        return StringUtils.isNotEmpty(valueComparator) && valueComparator.equals(comparatorValue);
    }
}
