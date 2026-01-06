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

@XStreamAlias("ComparisonFormulaValidation")
public class ComparisonFormulaValidation extends BaseRowFormulaValidation {

	public ComparisonFormulaValidation() {
		super();
	}

	public ComparisonFormulaValidation(String parameter) {
		super(parameter);
	}

	@Override
	public ComparisonFormulaValidation initialized() {
		super.initialized();
		return this;
	}
	
	@Override
	protected Object getComparatorValue(String idxSelectField) {
		return arithmeticOperation(comparatorPosCode, Integer.parseInt(idxSelectField)).setScale(scale, RoundingMode.HALF_UP);
	}
	
	@Override
	protected void compare(ScriptEngine engine, SubmissionFormat submissionFormat, ValidationResult validationResult,
			String idxSelectField) {
		final Logger logger = LoggerFactory.getLogger(ComparisonFormulaValidation.class);
		Object selectValue = getSelectValue(validationResult, idxSelectField);
		Object comparatorValue = getComparatorValue(idxSelectField);
		if (!compareValue(engine, selectValue, comparatorValue)) {
			logger.error("{}>{}?{}", parameter, selectValue, comparatorValue);
			List<SubmissionField> fields = submissionFormat.getFields();
			SubmissionField submissionField = fields.get(Integer.parseInt(idxSelectField));
			validationResult.errors.add(new ValidationError(submissionField,
					ValidationErrorCode.E50_02_FORMULA, String.valueOf(comparatorValue), 
					StringUtils.replace(msgError, "|", " " + operatorFormula.replace("==", "=") + " ")));
		}
	}
}