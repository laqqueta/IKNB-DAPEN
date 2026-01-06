package id.go.ojk.client.model.config.validation.segmen;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.UtilValidation;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import lombok.extern.slf4j.Slf4j;

@XStreamAlias("EqualsPercentageFormValidation")
@Slf4j
public class EqualsPercentageFormValidation extends BaseDecimalValidation {
	private String comparator1Form;
	private String comparator1Field;
	private String comparator1RowCode;
	private String comparator2Form;
	private String comparator2Field;
	private String comparator2RowCode;
	private String message;

	public EqualsPercentageFormValidation() {
		super();
	}

	public EqualsPercentageFormValidation(String parameter) {
		super(parameter);
	}

	@Override
	public EqualsPercentageFormValidation initialized() {
		super.initialized();
		comparator1Form = getStringParameter("comparator1Form");
		comparator1Field = getStringParameter("comparator1Field");
		comparator1RowCode = getStringParameter("comparator1RowCode");
		comparator2Form = getStringParameter("comparator2Form");
		comparator2Field = getStringParameter("comparator2Field");
		comparator2RowCode = getStringParameter("comparator2RowCode");
		message = getStringParameter("message");
		return this;
	}
	
	private BigDecimal getComparator1Value() {
		return UtilValidation.calculateColumn(SubmissionFormat.mapPosValueForm, comparator1Form + comparator1RowCode, comparator1Field, scale);
	}
	
	private BigDecimal getComparator2Value() {
		return UtilValidation.calculateColumn(SubmissionFormat.mapPosValueForm, comparator2Form + comparator2RowCode, comparator2Field, scale);
	}
	
	private BigDecimal getComparatorValue() {
		BigDecimal value1 = getComparator1Value();
		BigDecimal value2 = getComparator2Value();
		if (value1.compareTo(BigDecimal.ZERO) == 0) {
			return BigDecimal.ZERO;
		}
		BigDecimal res = value1.multiply(new BigDecimal(100));
		res = value2.compareTo(BigDecimal.ZERO) != 0 ? res.divide(value2, scale, RoundingMode.HALF_UP) : BigDecimal.ZERO;
		return res;
	}

	private BigDecimal getCurrentValue(ValidationResult validationResult) {
		return UtilValidation.toBigDecimal(validationResult.getColumn(Integer.parseInt(selectField)), "0");
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		String currentRowCode = validationResult.getColumn(1);
		if (currentRowCode.equals(selectPosCode)) {
			BigDecimal comparatorValue = getComparatorValue();
			BigDecimal currentValue = getCurrentValue(validationResult);
			if (currentValue.compareTo(comparatorValue) != 0) {
				log.error("{}->{}?{}", parameter, currentValue, comparatorValue);
				List<SubmissionField> fields = submissionFormat.getFields();
				SubmissionField submissionField = fields.get(Integer.parseInt(selectField));
				validationResult.errors.add(new ValidationError(submissionField,
						ValidationErrorCode.E50_02_FORMULA, "", 
						StringUtils.replace(message, "|", "=")));
			}
		}
	}
}