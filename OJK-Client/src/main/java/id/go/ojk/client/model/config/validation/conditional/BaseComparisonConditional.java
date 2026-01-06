package id.go.ojk.client.model.config.validation.conditional;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.Comparation;
import id.go.ojk.lib.client.model.constant.RequiredCondition;

/**
 * comparation untuk string harus equal atau not equal <br/>
 * Membandingkan refField dengan comparationValue
 * Jika selain e, ne dan na maka akan membandingkan Long <br/>
 *
 */
public abstract class BaseComparisonConditional extends BaseConditional {
	protected String comparatorField;
	protected String comparatorValue;
	@XStreamAsAttribute
	protected Comparation comparation;

	public BaseComparisonConditional() { }

	public BaseComparisonConditional(String parameter){
		setParameter(parameter);
	}

	@Override
	public BaseComparisonConditional initialized() {
		super.initialized();
		this.comparatorField = getStringParameter("comparatorField");
		this.comparatorValue = getStringParameter("comparatorValue");
		this.comparation = getComparationParameter("comparation");
		return this;
	}

	@Override
	public Tupple2<RequiredCondition, String> analizeRequiredCondition(SubmissionFormat submissionFormat, ValidationResult validationResult) {
		Tupple2<Boolean, String> evaluationResult = evaluate(submissionFormat, validationResult);
		RequiredCondition requiredCondition = getRequiredCondition(evaluationResult);
		return Tupple2.<RequiredCondition, String>builder()
			.a(requiredCondition)
			.b(evaluationResult.getB())
			.build();
	}

	protected abstract Tupple2<Boolean, String> evaluate(SubmissionFormat submissionFormat, ValidationResult validationResult);
	
	protected RequiredCondition getRequiredCondition(Tupple2<Boolean, String> evaluationResult) {
		return evaluationResult.getA() ? trueCondition : falseCondition;
	}
}
