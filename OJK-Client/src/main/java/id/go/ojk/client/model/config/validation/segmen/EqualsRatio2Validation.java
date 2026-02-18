package id.go.ojk.client.model.config.validation.segmen;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.UtilValidation;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@XStreamAlias("EqualsRatioValidation")
@Slf4j
public class EqualsRatio2Validation extends BaseDecimalValidation {
	private String comparator1RowCode;
	private String comparator2RowCode;
	private String fieldRow1;
	private String fieldRow2;
	private String message;

	public EqualsRatio2Validation() {
		super();
	}

	public EqualsRatio2Validation(String parameter) {
		super(parameter);
	}

	@Override
	public EqualsRatio2Validation initialized() {
		super.initialized();
		comparator1RowCode = getStringParameter("comparator1RowCode");
		comparator2RowCode = getStringParameter("comparator2RowCode");
		fieldRow1 = getStringParameter("fieldRow1");
		fieldRow2 = getStringParameter("fieldRow2");
		message = getStringParameter("message");
		return this;
	}
	
	private BigDecimal getComparator1Value(String column) {
		return UtilValidation.calculateColumn(SubmissionFormat.mapPosValue, comparator1RowCode, column, scale);
	}
	
	private BigDecimal getComparator2Value(String column) {
		return UtilValidation.calculateColumn(SubmissionFormat.mapPosValue, comparator2RowCode, column, scale);
	}
	
	private BigDecimal getComparatorValue(String column) {
		BigDecimal value1 = getComparator1Value(column);
		BigDecimal value2 = getComparator2Value(fieldRow2);
		if (value1.compareTo(BigDecimal.ZERO) == 0) {
			return BigDecimal.ZERO;
		}
		return value2.compareTo(BigDecimal.ZERO) != 0 ? value1.divide(value2, scale, RoundingMode.HALF_UP) : BigDecimal.ZERO;
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
			String[] dividends = StringUtils.split(fieldRow1, "|");

			for (int i = 0; i < arrColumn.length; i++) {
				String column = arrColumn[i];
				String divCol = dividends[i];
				BigDecimal comparatorValue = getComparatorValue(divCol);
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