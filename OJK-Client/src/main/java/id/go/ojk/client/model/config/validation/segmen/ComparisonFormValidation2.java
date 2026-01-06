package id.go.ojk.client.model.config.validation.segmen;

import java.math.RoundingMode;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionFormat;

@XStreamAlias("ComparisonFormValidation2")
public class ComparisonFormValidation2 extends BaseRowFormulaValidation {
	protected String comparatorForm;

	public ComparisonFormValidation2() {
		super();
	}

	public ComparisonFormValidation2(String parameter) {
		super(parameter);
	}

	@Override
	public ComparisonFormValidation2 initialized() {
		super.initialized();
		comparatorForm = getStringParameter("comparatorForm");
		return this;
	}

	@Override
	protected Object getComparatorValue(String idxSelectField) {
		return SubmissionFormat.getSumMapPosFormValue(comparatorForm, comparatorPosCode, idxSelectField).setScale(scale, RoundingMode.HALF_UP);
	}
}