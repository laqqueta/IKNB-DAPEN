package id.go.ojk.client.model.config.validation.segmen;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.UtilValidation;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("WithColumnValidation")
public class WithRowColumnValidation extends BaseRowValidation {
	private String comparatorField;
	private String comparatorPosCode;
	private String operator;
	protected String operatorFormula;
	private String msgError;

	public WithRowColumnValidation() {
		super();
	}

	public WithRowColumnValidation(String parameter) {
		super(parameter);
	}

	@Override
	public WithRowColumnValidation initialized() {
		super.initialized();
		comparatorField = getStringParameter("comparatorField");
		comparatorPosCode = getStringParameter("comparatorPosCode");
		operator = getStringParameter("operator");
		msgError = getStringParameter("msgError");
		operatorFormula = initOperator(operator);
		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		List<SubmissionField> fields = submissionFormat.getFields();
		String posCode = UtilValidation.getArray(validationResult.rowSplited, 1, "");
		if (posCode.equals(selectPosCode)) {
			String value = UtilValidation.getArray(validationResult.rowSplited, Integer.valueOf(selectField), "");
			String comparatorValue = SubmissionFormat.getMapPosValue(comparatorPosCode, comparatorField);
			if (!value.equals(comparatorValue)) {
				String msg = msgError.replace("|", " " + operatorFormula.replace("==", "=") + " ");
				validationResult.errors.add(new ValidationError(fields.get(Integer.parseInt(selectField)),
						ValidationErrorCode.E50_02_FORMULA, msg, msg));
			}
		}
	}
}