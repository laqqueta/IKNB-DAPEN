package id.go.ojk.client.model.config.validation.segmen;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionFormat;

@XStreamAlias("ComparisonFormulaFormNotEqualsValidation2")
public class ComparisonFormulaFormNotEqualsValidation2 extends ComparisonFormulaFormValidation2 {
	private String comparatorFilterFieldNotEquals;
	private String comparatorFilterValueNotEquals;

	public ComparisonFormulaFormNotEqualsValidation2() {
		super();
	}

	public ComparisonFormulaFormNotEqualsValidation2(String parameter) {
		super(parameter);
	}

	@Override
	public ComparisonFormulaFormNotEqualsValidation2 initialized() {
		super.initialized();
		comparatorFilterFieldNotEquals = getStringParameter("comparatorFilterFieldNotEquals");
		comparatorFilterValueNotEquals = getStringParameter("comparatorFilterValueNotEquals");
		return this;
	}
	
	@Override
	protected BigDecimal getComparatorValue(String idxSelectField) {
		BigDecimal res = BigDecimal.ZERO;
		String[] fieldSplit = comparatorField.split("(?<=[-+/*])|(?=[-+/*])");
		if (fieldSplit != null) {
			String valueOperator = "+";
			for (int i = 0; i < fieldSplit.length; i++) {
				String field = fieldSplit[i];
				if (field.length() == 1) {
					valueOperator = field;
				} else {
					res = calculate(valueOperator, Integer.parseInt(field), res);
				}
			}
		}
		return res;
	}
	
	private BigDecimal calculate(String valueOperator, int fieldNumber, BigDecimal oldValue) {
		BigDecimal res = oldValue;
		BigDecimal tmp = arithmeticOperation(comparatorPosCode, fieldNumber).setScale(scale, RoundingMode.HALF_UP);
		if (valueOperator.equals("-")) {
			res = res.subtract(tmp);
		} else if (valueOperator.equals("*")) {
			res = res.multiply(tmp);
		} else if (valueOperator.equals("/")) {
			if (tmp == BigDecimal.ZERO) {
				res = BigDecimal.ZERO;
			} else {
				res = res.divide(tmp);
			}
		} else {
			res = res.add(tmp);
		}
		return res;
	}
	
	@Override
	protected BigDecimal getValue(String posCode, int fieldNumber) {
		return SubmissionFormat.getSumMapPosFormValueMultiFilterNotEquals(posCode, String.valueOf(fieldNumber), comparatorFilterField, comparatorFilterValue, comparatorFilterFieldNotEquals, comparatorFilterValueNotEquals);
	}
}