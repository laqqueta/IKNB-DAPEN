package id.go.ojk.client.model.config.validation.segmen;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionFormat;

@XStreamAlias("EqualsFormTotalDetailRowFilterNotInValidation")
public class EqualsFormTotalDetailRowFilterNotInValidation extends EqualsFormTotalDetailRowValidation {
	protected String comparatorFilterField;
	protected String comparatorFilterValue;

	public EqualsFormTotalDetailRowFilterNotInValidation() {
		super();
	}

	public EqualsFormTotalDetailRowFilterNotInValidation(String parameter) {
		super(parameter);
	}

	@Override
	public EqualsFormTotalDetailRowFilterNotInValidation initialized() {
		super.initialized();
		comparatorFilterField = getStringParameter("comparatorFilterField");
		comparatorFilterValue = getStringParameter("comparatorFilterValue");
		return this;
	}

	@Override
	protected int getComparatorValue() {
		return SubmissionFormat.getFormTotalRowNotIn(comparatorForm, comparatorFilterField, comparatorFilterValue);
	}
}