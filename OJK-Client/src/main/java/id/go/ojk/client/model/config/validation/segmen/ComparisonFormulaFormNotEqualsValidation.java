package id.go.ojk.client.model.config.validation.segmen;

import java.math.BigDecimal;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionFormat;

@XStreamAlias("ComparisonFormulaFormNotEqualsValidation")
public class ComparisonFormulaFormNotEqualsValidation extends ComparisonFormulaFormValidation2 {

	public ComparisonFormulaFormNotEqualsValidation() {
		super();
	}

	public ComparisonFormulaFormNotEqualsValidation(String parameter) {
		super(parameter);
	}

	@Override
	public ComparisonFormulaFormNotEqualsValidation initialized() {
		super.initialized();
		return this;
	}
	
	@Override
	protected BigDecimal getValue(String posCode, int fieldNumber) {
		return SubmissionFormat.getSumMapPosFormValueFilterNotEquals(posCode, String.valueOf(fieldNumber), comparatorFilterField, comparatorFilterValue);
	}
}