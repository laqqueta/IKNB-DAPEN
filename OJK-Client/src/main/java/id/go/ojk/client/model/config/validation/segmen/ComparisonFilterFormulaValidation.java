package id.go.ojk.client.model.config.validation.segmen;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.context.ApplicationContextClient;
import id.go.ojk.client.service.validation.ValidationService;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.ScriptEngine;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@XStreamAlias("ComparisonFilterFormulaValidation")
public class ComparisonFilterFormulaValidation extends BaseRowFormulaValidation {

	private String filterField;
	private String filterValue;

	private final AtomicReference<String> filterVal = new AtomicReference<>();

	public ComparisonFilterFormulaValidation() {
		super();
	}

	public ComparisonFilterFormulaValidation(String parameter) {
		super(parameter);
	}

	@Override
	public ComparisonFilterFormulaValidation initialized() {
		super.initialized();

		filterField = getStringParameter("filterField");
		filterValue = getStringParameter("filterValue");

		return this;
	}

	@Override
	protected Object getComparatorValue(String idxSelectField) {
		return arithmeticOperation(comparatorPosCode, Integer.parseInt(idxSelectField),
				filterField, filterVal.get()
		).setScale(scale, RoundingMode.HALF_UP);
	}

	@Override
	public void validate(ProgressPreparationAndSending.SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
		List<String> listSelectPosCode = Arrays.asList(StringUtils.split(selectPosCode, "|"));
		String posCode = validationResult.getColumn(1);
		if (StringUtils.isNotEmpty(posCode) && listSelectPosCode.contains(posCode)) {

			List<String> filters = Arrays.asList(StringUtils.split(filterValue, "|"));
			String filterFieldValue = validationResult.getColumn(Integer.parseInt(filterField));

			if (!filters.contains(filterFieldValue)) return;

			filterVal.set(filterFieldValue);

			String[] arrSelectField = StringUtils.split(selectField, "|");
			engine = ApplicationContextClient.getInstance().getService(ValidationService.class).getScriptEngine();
			for (int i = 0; i < arrSelectField.length; i++) {
				compare(engine, submissionFormat, validationResult, arrSelectField[i]);
			}
		}
	}

	@Override
	protected void compare(ScriptEngine engine, SubmissionFormat submissionFormat, ValidationResult validationResult,
			String idxSelectField) {
		final Logger logger = LoggerFactory.getLogger(ComparisonFilterFormulaValidation.class);
		Object selectValue = getSelectValue(validationResult, idxSelectField);
		Object comparatorValue = getComparatorValue(idxSelectField);
		if (!compareValue(engine, selectValue, comparatorValue)) {
			logger.error("{}>{}?{}", parameter, selectValue, comparatorValue);
			List<SubmissionField> fields = submissionFormat.getFields();
			SubmissionField submissionField = fields.get(Integer.parseInt(idxSelectField));
			SubmissionField sfFilter = fields.get(Integer.parseInt(filterField));
			String err = StringUtils.replace(msgError, "|", " " + operatorFormula.replace("==", "=") + " ")
					+ " pada '" + sfFilter.getName() + "' = " + filterVal.get();
			validationResult.errors.add(new ValidationError(submissionField,
					ValidationErrorCode.E50_02_FORMULA, String.valueOf(comparatorValue),
					err));
		}
	}
}