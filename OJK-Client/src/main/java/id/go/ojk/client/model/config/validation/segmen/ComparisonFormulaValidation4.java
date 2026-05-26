package id.go.ojk.client.model.config.validation.segmen;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.ScriptEngine;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

@XStreamAlias("ComparisonFormulaValidation4")
public class ComparisonFormulaValidation4 extends BaseRowFormulaValidation {

	public ComparisonFormulaValidation4() {
		super();
	}

	public ComparisonFormulaValidation4(String parameter) {
		super(parameter);
	}

	@Override
	public ComparisonFormulaValidation4 initialized() {
		super.initialized();
		return this;
	}

	protected BigDecimal getComparatorValue(String idxSelectField) {
		return arithmeticOperation(comparatorPosCode, Integer.parseInt(idxSelectField))
				.setScale(scale, RoundingMode.HALF_UP);
	}

	protected BigDecimal getSelectValue(ValidationResult validationResult, String idxSelectField) { 
		return new BigDecimal(validationResult.getColumn(Integer.parseInt(idxSelectField)));
	}

	@Override
	protected void compare(ScriptEngine engine, SubmissionFormat submissionFormat, ValidationResult validationResult,
			String idxSelectField) {
		final Logger logger = LoggerFactory.getLogger(ComparisonFormulaValidation4.class);
		BigDecimal selectValue = getSelectValue(validationResult, idxSelectField);
		BigDecimal comparatorValue = BigDecimal.valueOf(100.00);

		if (selectValue.compareTo(comparatorValue) != 0) {
			logger.error("{}>{}?{}", parameter, selectValue, comparatorValue);
			List<SubmissionField> fields = submissionFormat.getFields();
			SubmissionField submissionField = fields.get(Integer.parseInt(idxSelectField));
			validationResult.errors.add(new ValidationError(submissionField,
					ValidationErrorCode.E50_02_FORMULA, String.valueOf(comparatorValue),
					StringUtils.replace(msgError, "|", " " + operatorFormula.replace("==", "=") + " ")));
		}
	}
}