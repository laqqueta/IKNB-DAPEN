package id.go.ojk.client.model.config.validation.segmen;

import java.util.Arrays;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

public abstract class BaseRowStringValidation extends BaseRowValidation {
	protected String comparatorPosCode;
	protected String operator;
	protected String operatorFormula;
	protected String msgError;

	public BaseRowStringValidation() {
		super();
	}

	public BaseRowStringValidation(String parameter) {
		super(parameter);
	}

	@Override
	public BaseRowStringValidation initialized() {
		super.initialized();
		comparatorPosCode = getStringParameter("comparatorPosCode");
		operator = getStringParameter("operator");
		msgError = getStringParameter("msgError");
		operatorFormula = initOperator(operator);
		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		List<String> listSelectPosCode = Arrays.asList(StringUtils.split(selectPosCode, "|"));
		String posCode = validationResult.getColumn(1);
		if (StringUtils.isNotEmpty(posCode) && listSelectPosCode.contains(posCode)) {
			String[] arrSelectField = StringUtils.split(selectField, "|");
			for (int i = 0; i < arrSelectField.length; i++) {
				compare(engine, submissionFormat, validationResult, arrSelectField[i]);
			}
		}
	}

	protected String getSelectValue(ValidationResult validationResult, String idxSelectField) {
		return validationResult.getColumn(Integer.parseInt(idxSelectField));
	}

	protected abstract String getComparatorValue(String idxSelectField);

	protected void compare(ScriptEngine engine, SubmissionFormat submissionFormat, ValidationResult validationResult,
			String idxSelectField) {
		final Logger logger = LoggerFactory.getLogger(BaseRowStringValidation.class);
		String selectValue = getSelectValue(validationResult, idxSelectField);
		String comparatorValue = getComparatorValue(idxSelectField);
		if (!compareValue(engine, selectValue, comparatorValue)) {
			logger.error("{" + parameter + "}>" + selectValue + "?" + comparatorValue);
			List<SubmissionField> fields = submissionFormat.getFields();
			SubmissionField submissionField = fields.get(Integer.parseInt(idxSelectField));
			validationResult.errors.add(new ValidationError(submissionField, ValidationErrorCode.E50_02_FORMULA,
					comparatorValue, genErrorMessage(idxSelectField)));
		} else {
			logger.trace("{" + parameter + "}>" + selectValue + "?" + comparatorValue);
		}
	}

	protected boolean compareValue(ScriptEngine engine, String selectValue, String comparatorValue) {
		boolean res = false;
		switch (operator) {
		case "e":
			res = compareEquals(selectValue, comparatorValue);
			break;
		case "ne":
			res = compareNotEquals(selectValue, comparatorValue);
			break;
		default:
			res = compareEngine(engine, selectValue, comparatorValue);
			break;
		}
		return res;
	}

	protected boolean compareEquals(String selectValue, String comparatorValue) {
		boolean res = true;
		if (StringUtils.isNoneEmpty(selectValue, comparatorValue)) {
			res = selectValue.equals(comparatorValue);
		}
		return res;
	}

	protected boolean compareNotEquals(String selectValue, String comparatorValue) {
		return !compareEquals(selectValue, comparatorValue);
	}

	protected boolean compareEngine(ScriptEngine engine, String selectValue, String comparatorValue) {
		boolean res = false;
		final Logger logger = LoggerFactory.getLogger(BaseRowStringValidation.class);
		final String formula = selectValue + operatorFormula + comparatorValue;
		try {
			res = (boolean) engine.eval(formula);
		} catch (Exception e) {
			logger.error(formula, e);
		}
		return res;
	}
	
	protected String genErrorMessage(String idxSelectField) {
		String res = msgError.replace("|", " " + operatorFormula.replace("==", "=") + " ");
		res = res.replace("#kolom#", "kolom " + (Integer.parseInt(idxSelectField) + 1));
		return res;
	}
}