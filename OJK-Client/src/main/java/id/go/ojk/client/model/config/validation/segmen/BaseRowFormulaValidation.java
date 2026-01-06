package id.go.ojk.client.model.config.validation.segmen;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.script.ScriptEngine;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.util.ToBigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.context.ApplicationContextClient;
import id.go.ojk.client.service.validation.ValidationService;
import id.go.ojk.lib.client.constant.ESymbolMap;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

public abstract class BaseRowFormulaValidation extends BaseDecimalValidation {
	protected String comparatorPosCode;
	protected String operator;
	protected String operatorFormula;
	protected String msgError;
	private ScriptEngine engine;

	protected BaseRowFormulaValidation() {
		super();
	}

	protected BaseRowFormulaValidation(String parameter) {
		super(parameter);
	}

	@Override
	public BaseRowFormulaValidation initialized() {
		super.initialized();
		comparatorPosCode = getStringParameter("comparatorPosCode");
		operator = getStringParameter("operator");
		msgError = ESymbolMap.decode(getStringParameter("msgError"));
		operatorFormula = initOperator(operator);
		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		List<String> listSelectPosCode = Arrays.asList(StringUtils.split(selectPosCode, "|"));
		String posCode = validationResult.getColumn(1);
		if (StringUtils.isNotEmpty(posCode) && listSelectPosCode.contains(posCode)) {
			String[] arrSelectField = StringUtils.split(selectField, "|");
			for (int i = 0; i < arrSelectField.length; i++) {
			  engine = ApplicationContextClient.getInstance().getService(ValidationService.class).getScriptEngine();
				compare(engine, submissionFormat, validationResult, arrSelectField[i]);
			}
		}
	}

	protected Object getSelectValue(ValidationResult validationResult, String idxSelectField) {
		return validationResult.getColumn(Integer.parseInt(idxSelectField));
	}

	protected abstract Object getComparatorValue(String idxSelectField);

	protected void compare(ScriptEngine engine, SubmissionFormat submissionFormat, ValidationResult validationResult,
			String idxSelectField) {
		final Logger logger = LoggerFactory.getLogger(BaseRowFormulaValidation.class);
		Object selectValue = getSelectValue(validationResult, idxSelectField);
		Object comparatorValue = getComparatorValue(idxSelectField);
		if (!compareValue(engine, selectValue, comparatorValue)) {
			logger.error("{}>{}?{}", parameter, selectValue, comparatorValue);
			List<SubmissionField> fields = submissionFormat.getFields();
			SubmissionField submissionField = fields.get(Integer.parseInt(idxSelectField));
			validationResult.errors.add(new ValidationError(submissionField, ValidationErrorCode.E50_02_FORMULA,
					comparatorValue, genErrorMessage(idxSelectField)));
		} else {
			logger.trace("{}>{}?{}", parameter, selectValue, comparatorValue);
		}
	}

	protected boolean compareValue(ScriptEngine engine, Object selectValue, Object comparatorValue) {
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

	protected boolean compareEquals(Object selectValue, Object comparatorValue) {
		boolean res = false;
		String realValue = (selectValue != null) ? String.valueOf(selectValue) : null;
		if (StringUtils.isNotEmpty(realValue) && comparatorValue != null) {
			BigDecimal value1 = ToBigDecimal.convert(realValue);
			BigDecimal value2 = (comparatorValue instanceof BigDecimal) ? (BigDecimal) comparatorValue : ToBigDecimal.convert(String.valueOf(comparatorValue));
			res = (value1.compareTo(value2) == 0);
		}
		return res;
	}

	protected boolean compareNotEquals(Object selectValue, Object comparatorValue) {
		return !compareEquals(selectValue, comparatorValue);
	}

	protected boolean compareEngine(ScriptEngine engine, Object selectValue, Object comparatorValue) {
		boolean res = false;
		final Logger logger = LoggerFactory.getLogger(BaseRowFormulaValidation.class);
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