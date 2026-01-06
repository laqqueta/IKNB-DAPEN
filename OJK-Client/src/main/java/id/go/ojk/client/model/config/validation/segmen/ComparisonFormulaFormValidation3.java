package id.go.ojk.client.model.config.validation.segmen;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionFormat;

@XStreamAlias("ComparisonFormulaFormValidation3")
public class ComparisonFormulaFormValidation3 extends ComparisonFormulaFormValidation2 {

	public ComparisonFormulaFormValidation3() {
		super();
	}

	public ComparisonFormulaFormValidation3(String parameter) {
		super(parameter);
	}

	@Override
	public ComparisonFormulaFormValidation3 initialized() {
		super.initialized();
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
					res = calculate(valueOperator, comparatorPosCode, Integer.parseInt(field), res);
				}
			}
		}
		return res;
	}
	
	private BigDecimal calculate(String valueOperator, String posCode, int fieldNumber, BigDecimal oldValue) {
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
		return SubmissionFormat.getSumMapPosFormValueMultiFilter(posCode, String.valueOf(fieldNumber), comparatorFilterField, comparatorFilterValue);
	}
}