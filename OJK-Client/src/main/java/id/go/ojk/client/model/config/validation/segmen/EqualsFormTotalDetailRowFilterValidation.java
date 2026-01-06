package id.go.ojk.client.model.config.validation.segmen;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionFormat;

@XStreamAlias("EqualsFormTotalDetailRowFilterValidation")
public class EqualsFormTotalDetailRowFilterValidation extends EqualsFormTotalDetailRowValidation {
	protected String comparatorFilterField;
	protected String comparatorFilterValue;

	public EqualsFormTotalDetailRowFilterValidation() {
		super();
	}

	public EqualsFormTotalDetailRowFilterValidation(String parameter) {
		super(parameter);
	}

	@Override
	public EqualsFormTotalDetailRowFilterValidation initialized() {
		super.initialized();
		comparatorFilterField = getStringParameter("comparatorFilterField");
		comparatorFilterValue = getStringParameter("comparatorFilterValue");
		return this;
	}

	@Override
	protected int getComparatorValue() {
		return SubmissionFormat.getFormTotalRow(comparatorForm, comparatorFilterField, comparatorFilterValue);
	}
}