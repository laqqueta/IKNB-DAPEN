package id.go.ojk.client.model.config.validation.segmen;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.script.ScriptEngine;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("EqualsValidation")
public class FormulaFormValidation extends BaseRowFormulaValidation {
	private String comparatorField;

	public FormulaFormValidation() {
		super();
	}

	public FormulaFormValidation(String parameter) {
		super(parameter);
	}
	
	@Override
	public FormulaFormValidation initialized() {
		super.initialized();
		comparatorField = getStringParameter("comparatorField");
		return this;
	}
	
	@Override
	protected BigDecimal getComparatorValue(String idxSelectField) {
		return arithmeticOperation(SubmissionFormat.mapPosValueForm, comparatorPosCode, Integer.parseInt(idxSelectField)).setScale(scale, RoundingMode.HALF_UP);
	}

	@Override
	protected void compare(ScriptEngine engine, SubmissionFormat submissionFormat, ValidationResult validationResult,
			String idxField) {
		Logger logger = LoggerFactory.getLogger(FormulaFormValidation.class);
		BigDecimal selectValue = toBigDecimal(validationResult.getColumn(Integer.parseInt(idxField)), 0);
		BigDecimal comparatorValue = getComparatorValue(comparatorField);
		String formula = selectValue + operatorFormula + comparatorValue;
		try {
			if (!(boolean) engine.eval(formula)) {
				logger.error("{" + parameter + "}>" + selectValue + "?" + comparatorValue);
				validationResult.errors.add(new ValidationError(submissionFormat.getFields().get(Integer.parseInt(idxField)),
						ValidationErrorCode.E50_02_FORMULA, formula, 
						StringUtils.replace(msgError, "|", " " + operatorFormula + " ")));
			} else {
				logger.trace("{" + parameter + "}>" + selectValue + "?" + comparatorValue);
			}
		} catch (Exception e) {
			logger.error(formula, e);
		}
	}
}