package id.go.ojk.client.model.config.validation.segmen;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.UtilValidation;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("EqualsFormulaValidation")
public class EqualsFormulaValidation extends BaseDecimalValidation {
	private String comparatorField;
	private String comparatorRow;
	private String msgError;

	public EqualsFormulaValidation() {
		super();
	}

	public EqualsFormulaValidation(String parameter) {
		super(parameter);
	}

	@Override
	public EqualsFormulaValidation initialized() {
		super.initialized();
		comparatorField = getStringParameter("comparatorField");
		comparatorRow = getStringParameter("comparatorRow");
		msgError = getStringParameter("msgError");
		return this;
	}
	
	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		final Logger logger = LoggerFactory.getLogger(EqualsFormulaValidation.class);
		if (!validateSelectPosCode(validationResult.getColumn(1))) {
			return;
		}
		String[] arrField = selectField.split("|");
		String[] arrComparatorField = comparatorField.split("|");
		for (int i = 0; i < arrField.length; i++) {
			String idxField = arrField[i];
			BigDecimal currentValue = getCurrentValue(validationResult, idxField);
			BigDecimal comparatorValue = getComparatorValue(arrComparatorField[i]);
			if (currentValue.compareTo(comparatorValue) != 0) {
				List<SubmissionField> fields = submissionFormat.getFields();
				SubmissionField submissionField = fields.get(Integer.parseInt(idxField));
				logger.error("{}>{}?{}", parameter, currentValue, comparatorValue);
				validationResult.errors.add(new ValidationError(submissionField,
						ValidationErrorCode.E50_02_FORMULA, String.valueOf(comparatorValue), 
						StringUtils.replace(msgError, "|", " = ")));
			}
		}
	}
	
	private BigDecimal getCurrentValue(ValidationResult validationResult, String idxField) {
		return UtilValidation.toBigDecimal(validationResult.getColumn(Integer.parseInt(idxField)));
	}
	
	private BigDecimal getComparatorValue(String idxField) {
		return arithmeticOperation(comparatorRow, Integer.parseInt(idxField)).setScale(scale, RoundingMode.HALF_UP);
	}
}