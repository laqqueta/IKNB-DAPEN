package id.go.ojk.client.model.config.validation.segmen.v2;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.UtilValidation;
import id.go.ojk.client.model.config.validation.segmen.v2.base.BaseDecimalValidation;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

@XStreamAlias("EqualsRatioFormDapenValidation")
@Slf4j
public class EqualsInvestasiRatioValidation extends BaseDecimalValidation {
	private String comparator1RowCode;
	private String comparator2Form;
	private String comparator2RowCode;
	private String fieldRow1;
	private String fieldRow2;
	private String message;

	public EqualsInvestasiRatioValidation() {
		super();
	}

	public EqualsInvestasiRatioValidation(String parameter) {
		super(parameter);
	}

	@Override
	public EqualsInvestasiRatioValidation initialized() {
		super.initialized();
		comparator1RowCode = getStringParameter("comparator1RowCode");
		comparator2Form = getStringParameter("comparator2Form");
		comparator2RowCode = getStringParameter("comparator2RowCode");
		message = getStringParameter("message");
		fieldRow1 = getStringParameter("comparator1FieldRow");
		fieldRow2 = getStringParameter("comparator2FieldRow");
		return this;
	}

	private BigDecimal getComparator2Value(String column) {
		Map<String, Map<String, String>> formValues = SubmissionFormat.getFormValues(comparator2Form + comparator2RowCode, Character.MAX_VALUE);
		return UtilValidation.calculateColumn(formValues, comparator2Form + comparator2RowCode, column, scale);
	}

	private BigDecimal getComparatorValue(BigDecimal value1) {
		BigDecimal value2 = getComparator2Value(fieldRow2);

		if (value1.compareTo(BigDecimal.ZERO) == 0 || value2.compareTo(BigDecimal.ZERO) == 0) {
			return BigDecimal.ZERO;
		}

		BigDecimal tmp = value1.divide(value2, MathContext.DECIMAL128);
		BigDecimal tmp2 = tmp.multiply(BigDecimal.valueOf(100));

		return value1.divide(value2, scale, RoundingMode.HALF_UP);
	}

	private BigDecimal getCurrentValue(ValidationResult validationResult, String column) {
		return UtilValidation.toBigDecimal(validationResult.getColumn(Integer.parseInt(column)), "0");
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		String currentRowCode = validationResult.getColumn(1);
		if (currentRowCode.equals(selectPosCode)) {

			String[] arrColumn = StringUtils.split(selectField, "|");
			for (int i = 0; i < arrColumn.length; i++) {
				String column = arrColumn[i];
				BigDecimal divVal = getCurrentValue(validationResult, fieldRow1);
				BigDecimal comparatorValue = getComparatorValue(divVal);
				BigDecimal currentValue = getCurrentValue(validationResult, column);
				if (currentValue.compareTo(comparatorValue) != 0) {
					log.error("{}->{}?{}", parameter, currentValue, comparatorValue);
					List<SubmissionField> fields = submissionFormat.getFields();
					SubmissionField submissionField = fields.get(Integer.parseInt(column));
					validationResult.errors.add(new ValidationError(submissionField,
							ValidationErrorCode.E50_02_FORMULA, "",
							StringUtils.replace(message, "|", "=")));
				}
			}
		}
	}
}