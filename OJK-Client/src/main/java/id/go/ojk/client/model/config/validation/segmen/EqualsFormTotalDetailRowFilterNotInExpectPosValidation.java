package id.go.ojk.client.model.config.validation.segmen;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import id.go.ojk.client.model.config.SubmissionFormat;

@XStreamAlias("EqualsFormTotalDetailRowFilterNotInExpectPosValidation")
public class EqualsFormTotalDetailRowFilterNotInExpectPosValidation extends EqualsFormTotalDetailRowValidation {
	protected String comparatorFilterField;
	protected String comparatorFilterValue;
    protected String expectPos;

	public EqualsFormTotalDetailRowFilterNotInExpectPosValidation() {
		super();
	}

	public EqualsFormTotalDetailRowFilterNotInExpectPosValidation(String parameter) {
		super(parameter);
	}

	@Override
	public EqualsFormTotalDetailRowFilterNotInExpectPosValidation initialized() {
		super.initialized();
		comparatorFilterField = getStringParameter("comparatorFilterField");
		comparatorFilterValue = getStringParameter("comparatorFilterValue");
        expectPos = getStringParameter("expectPos");
		return this;
	}

	@Override
	protected int getComparatorValue() {
		return SubmissionFormat.getFormTotalRowNotInExpectPos(comparatorForm, comparatorFilterField, comparatorFilterValue, expectPos);
	}
}