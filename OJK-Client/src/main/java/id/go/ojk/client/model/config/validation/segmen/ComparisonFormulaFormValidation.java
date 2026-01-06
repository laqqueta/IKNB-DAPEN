package id.go.ojk.client.model.config.validation.segmen;

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

@XStreamAlias("ComparisonFormulaFormValidation")
public class ComparisonFormulaFormValidation extends BaseRowFormulaValidation {
	private String comparatorField;

	public ComparisonFormulaFormValidation() {
		super();
	}

	public ComparisonFormulaFormValidation(String parameter) {
		super(parameter);
	}

	@Override
	public ComparisonFormulaFormValidation initialized() {
		super.initialized();
		comparatorField = getStringParameter("comparatorField");
		return this;
	}

	@Override
	protected Object getComparatorValue(String idxSelectField) {
		return arithmeticOperation(SubmissionFormat.mapPosValueForm, comparatorPosCode, Integer.parseInt(comparatorField)).setScale(scale, RoundingMode.HALF_UP);
	}
	
	@Override
	protected void compare(ScriptEngine engine, SubmissionFormat submissionFormat, ValidationResult validationResult,
			String idxSelectField) {
		final Logger logger = LoggerFactory.getLogger(ComparisonFormulaFormValidation.class);
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
}