package id.go.ojk.client.model.config.validation.conditional;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.segmen.MapParamSegmentValidation;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.RequiredCondition;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

import static id.go.ojk.lib.client.model.constant.RequiredCondition.N;

@XStreamAlias("emptyPosFieldValidation")
public class EmptyPosFieldValidation extends MapParamConditionalRequired {
	protected int selectField;
	protected String selectPosCode;
    protected RequiredCondition trueCondition;
    protected RequiredCondition falseCondition;

	public EmptyPosFieldValidation(String parameter) {
		setParameter(parameter);
	}

	@Override
	public EmptyPosFieldValidation initialized() {
		selectField = getIntParameter("selectField");
		selectPosCode = getStringParameter("selectPosCode");
        trueCondition = getRequiredConditionParameter("trueCondition");
        falseCondition = getRequiredConditionParameter("falseCondition");

		return this;
	}

    @Override
    public Tupple2<RequiredCondition, String> analizeRequiredCondition(SubmissionFormat submissionFormat, ValidationResult validationResult) {
        List<String> arrPos = Arrays.asList(StringUtils.split(selectPosCode, "|"));
        String posCode = validationResult.getColumn(1);

        RequiredCondition result = trueCondition;

        if (!arrPos.contains(posCode))
            return Tupple2.<RequiredCondition, String>builder().a(result).b("").build();

        return Tupple2.<RequiredCondition, String>builder().a(falseCondition).b("").build();
    }

}