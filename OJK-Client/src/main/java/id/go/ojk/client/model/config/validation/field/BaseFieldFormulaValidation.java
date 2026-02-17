package id.go.ojk.client.model.config.validation.field;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.util.ToBigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import id.go.ojk.client.model.config.validation.UtilValidation;

public abstract class BaseFieldFormulaValidation extends MapParamFieldValidation {
	protected String comparatorFormula;
	protected String operator;
	protected String operatorFormula;

	public BaseFieldFormulaValidation(String parameter){
		setParameter(parameter);
	}
	
	public BaseFieldFormulaValidation() { }

	@Override
	public BaseFieldFormulaValidation initialized() {
		comparatorFormula = getStringParameter("comparatorFormula");
		operator = getStringParameter("operator");
		initOperator();
		return this;
	};

	protected BigDecimal arithmeticOperation(String formula, String[] fieldValues) {
		Logger logger = LoggerFactory.getLogger(BaseFieldFormulaValidation.class);
		BigDecimal res = BigDecimal.ZERO;
		try {
			String[] formulaSplit = formula.split("(?<=[-+/*])|(?=[-+/*])");
			if (formulaSplit != null) {
				int length = formulaSplit.length;
				String valueOperator = "+";
				for (int i = 0; i < length; i++) {
					String value = formulaSplit[i];
					if (StringUtils.isNumeric(value)) {
						String fieldValue = UtilValidation.getArray(fieldValues, Integer.valueOf(value), "0");
						BigDecimal tmp = UtilValidation.toBigDecimal(fieldValue, "0");
						if (valueOperator.equals("+")) {
							res = res.add(tmp);
						} else if (valueOperator.equals("-")) {
							res = res.subtract(tmp);
						} else if (valueOperator.equals("*")) {
							res = res.multiply(tmp);
						} else if (valueOperator.equals("/")) {
							if (tmp == BigDecimal.ZERO) {
								res = BigDecimal.ZERO;
							} else {
								res = res.divide(tmp, 4, RoundingMode.HALF_EVEN);
							}
						}
					} else {
						valueOperator = value;
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			res = null;
		}
		return res;
	}

	protected boolean compareValue(Object fieldValue, Object comparatorValue) {
		boolean res = false;
		switch (operator) {
		case "e":
			res = compareEquals(fieldValue, comparatorValue);
			break;
		case "ne":
			res = compareNotEquals(fieldValue, comparatorValue);
			break;
		default:
			res = compareEngine(fieldValue, comparatorValue);
			break;
		}
		return res;
	}

	protected boolean compareEquals(Object selectValue, Object comparatorValue) {
		boolean res = false;
		String realValue = String.valueOf(selectValue);
		if (StringUtils.isNotEmpty(realValue) && comparatorValue != null) {
			BigDecimal value1 = ToBigDecimal.convert(realValue);
			BigDecimal value2 = comparatorValue instanceof BigDecimal ? (BigDecimal) comparatorValue : ToBigDecimal.convert(String.valueOf(comparatorValue));
			res = (value1.compareTo(value2) == 0);
		}
		return res;
	}

	protected boolean compareNotEquals(Object selectValue, Object comparatorValue) {
		return !compareEquals(selectValue, comparatorValue);
	}

	protected boolean compareEngine(Object selectValue, Object comparatorValue) {
		boolean res = false;
		final Logger logger = LoggerFactory.getLogger(BaseFieldFormulaValidation.class);
		final ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
		final String formula = selectValue + operatorFormula + comparatorValue;
		try {
			res = (boolean) engine.eval(formula);
		} catch (Exception e) {
			logger.error(formula, e);
		}
		return res;
	}
	
	private void initOperator() {
		switch (operator) {
		case "e":
			operatorFormula = "==";
			break;
		case "ne":
			operatorFormula = "!=";
			break;
		case "lt":
			operatorFormula = "<";
			break;
		case "lte":
			operatorFormula = "<=";
			break;
		case "gt":
			operatorFormula = ">";
			break;
		case "gte":
			operatorFormula = ">=";
			break;
		default:
			operatorFormula = "==";
			break;
		}
	}
}
