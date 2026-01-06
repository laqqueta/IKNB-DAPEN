package id.go.ojk.client.model.config.validation.segmen;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.UtilValidation;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

public abstract class BaseFormulaValidation extends BaseRowValidation {
	protected String leftFormula;
	protected String rightFormula;
	protected String operator;
	protected String operatorFormula;
	protected String msgError;
	protected int totalRow;
	protected boolean posExist;

	protected BaseFormulaValidation() {
		super();
	}

	protected BaseFormulaValidation(String parameter) {
		super(parameter);
	}

	@Override
	public BaseFormulaValidation initialized() {
		super.initialized();
		leftFormula = getStringParameter("leftFormula");
		rightFormula = getStringParameter("rightFormula");
		operator = getStringParameter("operator");
		msgError = getStringParameter("msgError");
		posExist = false;
		operatorFormula = initOperator(operator);
		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		String[] SelectField = StringUtils.split(selectField, "|");
		String posCode = UtilValidation.getArray(validationResult.rowSplited, 1, "");
		totalRow = submissionFormat.getTotalRow();
		if (StringUtils.isNotEmpty(posCode)) {
			if (selectPosCode.contains(posCode)) {
				for (int i = 0; i < SelectField.length; i++) {
					compareFormula(validationResult, submissionFormat.getFields(), SelectField[i],
							Integer.valueOf(SelectField[i]), leftFormula, operatorFormula, rightFormula);
				}
				posExist = true;
			} else {
				if (posExist == true && validationResult.lineNumber == 1) {
					posExist = false;
				}
				if (posExist == false) {
					if (validationResult.lineNumber == totalRow) {
						validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E50_03_POS_MUST_EXIST,
								posExist, leftFormula));
					}
				}
			}
		}
	}

	protected abstract void compareFormula(ValidationResult validationResult, List<SubmissionField> submissionField,
			String field, int seq, String leftFormula, String operator, String rightFormula);

	protected BigDecimal calculateSavedValue(int fieldNumber, String pos) {
		return SubmissionFormat.getSumMapPosValue(pos, String.valueOf(fieldNumber));
	}
}