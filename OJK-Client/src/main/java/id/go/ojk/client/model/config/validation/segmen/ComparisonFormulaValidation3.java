package id.go.ojk.client.model.config.validation.segmen;

import java.math.BigDecimal;
import java.util.List;

import javax.script.ScriptEngine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("ComparisonFormulaValidation3")
public class ComparisonFormulaValidation3 extends ComparisonFormulaValidation2 {
	private String total;
	private String deviation;
	

	public ComparisonFormulaValidation3() {
		super();
	}

	public ComparisonFormulaValidation3(String parameter) {
		super(parameter);
	}

	@Override
	public ComparisonFormulaValidation3 initialized() {
		total = getStringParameter("total");
		deviation = getStringParameter("deviation");
		super.initialized();
		return this;
	}
	
	@Override
	protected void compare(ScriptEngine engine, SubmissionFormat submissionFormat, ValidationResult validationResult,
			String idxSelectField) {
		final Logger logger = LoggerFactory.getLogger(ComparisonFormulaValidation.class);
		List<SubmissionField> fields = submissionFormat.getFields();
		Object selectValue = getSelectValue(validationResult, idxSelectField);
		Object comparator = getComparatorValue(idxSelectField);
		BigDecimal comparatorValue = toBigDecimal(String.valueOf(comparator));
		BigDecimal deviationValue = toBigDecimal(deviation);
		BigDecimal totalValue = toBigDecimal(total);
		BigDecimal min = totalValue.subtract(deviationValue);
		BigDecimal max = totalValue.add(deviationValue);
		if (comparatorValue.compareTo(min) < 0 || comparatorValue.compareTo(max) > 0) {
			logger.trace("{}>{}?{}", parameter, selectValue, comparator);
			SubmissionField submissionField = fields.get(Integer.parseInt(idxSelectField));
			validationResult.errors.add(new ValidationError(submissionField,
					ValidationErrorCode.E50_02_FORMULA, String.valueOf(comparator), 
					msgError + "=" + total));
		}
	}
}