package id.go.ojk.client.model.config.validation.conditional;

import id.go.ojk.lib.client.model.constant.RequiredCondition;

public abstract class BaseFieldCondition extends MapParamConditionalRequired {
	protected RequiredCondition trueCondition;
	protected RequiredCondition falseCondition;

	public BaseFieldCondition() {
	}

	public BaseFieldCondition(String parameter) {
		setParameter(parameter);
	}

	@Override
	public BaseFieldCondition initialized() {
		this.trueCondition = getRequiredConditionParameter("trueCondition");
		this.falseCondition = getRequiredConditionParameter("falseCondition");
		return this;
	}
}
