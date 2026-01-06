package id.go.ojk.client.model.config.validation.segmen;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.script.ScriptEngine;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("ComparisonFormulaFormValidation2")
public class ComparisonFormulaFormValidation2 extends BaseRowFormulaValidation {
	protected String comparatorField;
	protected String comparatorFilterField;
	protected String comparatorFilterValue;

	public ComparisonFormulaFormValidation2() {
		super();
	}

	public ComparisonFormulaFormValidation2(String parameter) {
		super(parameter);
	}

	@Override
	public ComparisonFormulaFormValidation2 initialized() {
		super.initialized();
		comparatorField = getStringParameter("comparatorField");
		comparatorFilterField = getStringParameter("comparatorFilterField");
		comparatorFilterValue = getStringParameter("comparatorFilterValue");
		return this;
	}

	@Override
	protected BigDecimal getComparatorValue(String idxSelectField) {
		return arithmeticOperation(comparatorPosCode, Integer.parseInt(comparatorField)).setScale(scale, RoundingMode.HALF_UP);
	}
	
	@Override
	protected void compare(ScriptEngine engine, SubmissionFormat submissionFormat, ValidationResult validationResult,
			String idxSelectField) {
		final Logger logger = LoggerFactory.getLogger(ComparisonFormulaFormValidation2.class);
		Object selectValue = getSelectValue(validationResult, idxSelectField);
		Object comparatorValue = getComparatorValue(idxSelectField);
		if (!compareValue(engine, selectValue, comparatorValue)) {
			logger.error("{}>{}?{}", parameter, selectValue, comparatorValue);
			List<SubmissionField> fields = submissionFormat.getFields();
			SubmissionField submissionField = fields.get(Integer.parseInt(idxSelectField));
			validationResult.errors.add(new ValidationError(submissionField,
					ValidationErrorCode.E50_02_FORMULA, String.valueOf(comparatorValue), 
					StringUtils.replace(msgError, "|", " " + operatorFormula.replace("==", "=") + " ")));
		} else {
			logger.trace("{}>{}?{}", parameter, selectValue, comparatorValue);
		}
	}
	
	@Override
	protected BigDecimal arithmeticOperation(String formula, int fieldNumber) {
		Logger logger = LoggerFactory.getLogger(MapParamSegmentValidation.class);
		BigDecimal res = BigDecimal.ZERO;
		try {
			String[] formulaSplit = formula.split("(?<=[-+/*])|(?=[-+/*])");
			if (formulaSplit != null) {
				res = calculateValue(formulaSplit, fieldNumber);
			}
		} catch (Exception e) {
			logger.error(parameter, e);
			res = null;
		}
		return res;
	}
	
	protected BigDecimal calculateValue(String[] formulaSplit, int fieldNumber) {
		BigDecimal res = BigDecimal.ZERO;
		String valueOperator = "+";
		for (int i = 0; i < formulaSplit.length; i++) {
			String posCode = formulaSplit[i];
			if (posCode.length() == 1) {
				valueOperator = posCode;
			} else {
				res = calculateValue(valueOperator, posCode, fieldNumber, res);
			}
		}
		return res;
	}
	
	protected BigDecimal calculateValue(String valueOperator, String posCode, int fieldNumber, BigDecimal oldValue) {
		BigDecimal res = oldValue;
		BigDecimal tmp = getValue(posCode, fieldNumber);
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
	
	protected BigDecimal getValue(String posCode, int fieldNumber) {
		return SubmissionFormat.getSumMapPosFormValue(posCode, String.valueOf(fieldNumber), comparatorFilterField, comparatorFilterValue);
	}
}