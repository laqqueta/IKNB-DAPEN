package id.go.ojk.client.model.config.validation.conditional;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.RequiredCondition;

@XStreamAlias("ExistPosConditional")
public class ExistPosConditional extends MapParamConditionalRequired {
	private RequiredCondition trueCondition;
	private RequiredCondition falseCondition;
	private String refPosCode;

	public ExistPosConditional() {
	}

	public ExistPosConditional(String parameter) {
		setParameter(parameter);
	}

	@Override
	public ExistPosConditional initialized() {
		this.trueCondition = getRequiredConditionParameter("trueCondition");
		this.falseCondition = getRequiredConditionParameter("falseCondition");
		this.refPosCode = getStringParameter("refPosCode");
		return this;
	}

	@Override
	public Tupple2<RequiredCondition, String> analizeRequiredCondition(SubmissionFormat submissionFormat, ValidationResult validationResult) {
		String[] arrRefPosCode = refPosCode.split("[|]");
		RequiredCondition result = falseCondition;
		String rowValue = validationResult.getColumn(1);
		for(String posCode : arrRefPosCode) {
			if (rowValue.equals(posCode)) {
				result = trueCondition;
				break;
			}
		}
		return Tupple2.<RequiredCondition, String>builder().a(result).b("").build();
	}
}
