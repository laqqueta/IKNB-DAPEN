package id.go.ojk.client.model.config.validation.conditional;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.RequiredCondition;

@XStreamAlias("totalLengthConditional")
public class TotalLengthConditional extends MapParamConditionalRequired {

	private Integer fieldNumber;
	private Integer lengthValue;
	private RequiredCondition trueCondition;
	private RequiredCondition falseCondition;

	public TotalLengthConditional() {
	}

	public TotalLengthConditional(String parameter) {
		setParameter(parameter);
	}

	@Override
	public TotalLengthConditional initialized() {
		this.fieldNumber = getIntParameter("fieldNumber");
		this.lengthValue = getIntParameter("lengthValue");
		this.trueCondition = getRequiredConditionParameter("trueCondition");
		this.falseCondition = getRequiredConditionParameter("falseCondition");

		return this;
	}

	@Override
	public Tupple2<RequiredCondition, String> analizeRequiredCondition(SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		Boolean evaluateResult = false;
		Integer compareLength = validationResult.getColumn(fieldNumber).length();
		String conditionMessage = "karena kolom '" + submissionFormat.getFields().get(fieldNumber).getName() + "' diisi " + validationResult.getColumn(fieldNumber);
		
		if (compareLength.equals(lengthValue)) {
			evaluateResult = true;
		}
		
		RequiredCondition requiredCondition = evaluateResult ? trueCondition : falseCondition;
		return Tupple2.<RequiredCondition, String>builder().a(requiredCondition).b(conditionMessage).build();

	}
}
