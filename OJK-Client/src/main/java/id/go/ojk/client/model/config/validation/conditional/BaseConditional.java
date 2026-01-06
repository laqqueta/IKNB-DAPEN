package id.go.ojk.client.model.config.validation.conditional;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import id.go.ojk.lib.client.model.constant.RequiredCondition;

public abstract class BaseConditional extends MapParamConditionalRequired {
	@XStreamAsAttribute
	protected RequiredCondition trueCondition;
	@XStreamAsAttribute
	protected RequiredCondition falseCondition;

	protected BaseConditional() {
	}

	protected BaseConditional(String parameter) {
		setParameter(parameter);
	}

	@Override
	public BaseConditional initialized() {
		this.trueCondition = getRequiredConditionParameter("trueCondition");
		this.falseCondition = getRequiredConditionParameter("falseCondition");
		return this;
	}
}
