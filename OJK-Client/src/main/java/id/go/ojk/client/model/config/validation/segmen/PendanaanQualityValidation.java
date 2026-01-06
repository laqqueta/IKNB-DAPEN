package id.go.ojk.client.model.config.validation.segmen;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("PendanaanQualityValidation")
public class PendanaanQualityValidation extends MapParamSegmentValidation {
	private String selectField;
	private String selectPosCode;
	private String comparatorPosCode;
	private String value;
	private String deviation;
	private String conditionPosCode;
	private String conditionValue;
	private String msgError;

	public PendanaanQualityValidation() {
		super();
	}

	public PendanaanQualityValidation(String parameter) {
		super(parameter);
	}

	@Override
	public PendanaanQualityValidation initialized() {
		selectField = getStringParameter("selectField");
		selectPosCode = getStringParameter("selectPosCode");
		comparatorPosCode = getStringParameter("comparatorPosCode");
		value = getStringParameter("value");
		deviation = getStringParameter("deviation");
		conditionPosCode = getStringParameter("conditionPosCode");
		conditionValue = getStringParameter("conditionValue");
		msgError = getStringParameter("msgError");
		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		List<SubmissionField> fields = submissionFormat.getFields();
		String[] arrSelectField = StringUtils.split(selectField, "|");
		String[] arrSelectPosCode = StringUtils.split(selectPosCode, "|");
		BigDecimal expectedValue = toBigDecimal(value, 0);
		BigDecimal deviationValue = toBigDecimal(deviation);
		String currentPosCode = validationResult.getColumn(1);
		BigDecimal min = expectedValue.subtract(deviationValue);
		BigDecimal max = expectedValue.add(deviationValue);

		for (String field : arrSelectField) {
			String fieldValueString = validationResult.getColumn(Integer.parseInt(field));
			SubmissionField submissionField = fields.get(Integer.parseInt(field));
			for (int i = 0; i < arrSelectPosCode.length; i++) {
				if (currentPosCode.contains(arrSelectPosCode[i])) {
					boolean isNotZero = conditionIsNotZero(field);
					BigDecimal comparatorValue = getComparatorValue(field);
					if (isNotZero) {
						if (!validateValue(min, max, comparatorValue)) {
							validationResult.errors.add(new ValidationError(submissionField,
									ValidationErrorCode.E50_02_FORMULA, "", msgError + "=" + value));
						}
						if (!fieldValueString.equals(value)) {
							validationResult.errors.add(
									new ValidationError(submissionField, ValidationErrorCode.E11_07_EQUAL, value));
						}
					} else if (!isNotZero) {
						if (!validateValue(comparatorValue)) {
							validationResult.errors.add(
									new ValidationError(submissionField, ValidationErrorCode.E50_02_FORMULA, "", msgError + "=" + conditionValue));
						}
						if (!fieldValueString.equals(conditionValue)) {
							validationResult.errors.add(
									new ValidationError(submissionField, ValidationErrorCode.E11_07_EQUAL, conditionValue));
						}
					}
				}
			}
		}
	}
	private BigDecimal getComparatorValue(String idxSelectField) {
		return arithmeticOperation(comparatorPosCode, Integer.parseInt(idxSelectField)).setScale(2, RoundingMode.HALF_UP);
	}

	private boolean validateValue(BigDecimal realValue) {
		return realValue.compareTo(toBigDecimal(conditionValue)) == 0;
	}

	private boolean validateValue(BigDecimal min, BigDecimal max, BigDecimal realValue) {
		return realValue.compareTo(min) > -1 && realValue.compareTo(max) < 1;
	}

	private boolean conditionIsNotZero(String field) {
		String[] arrPosCode = StringUtils.split(conditionPosCode, "|");
		for (String posCode : arrPosCode) {
			BigDecimal tmp = SubmissionFormat.getSumMapPosValue(posCode, field).setScale(2, RoundingMode.HALF_UP);
			if (tmp.compareTo(BigDecimal.ZERO) != 0) {
				return true;
			}
		}
		return false;
	}
}