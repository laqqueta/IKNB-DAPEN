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
import java.util.Arrays;
import java.util.List;

@XStreamAlias("EqualsFilterRatio2Validation")
@Slf4j
public class EqualsFilterRatio2Validation extends BaseDecimalValidation {
	private String comparator1RowCode;
	private String comparator2RowCode;
	private String fieldRow1;
	private String fieldRow2;
	private String fieldFilter;
	private String filterValue;
	private String message;

	public EqualsFilterRatio2Validation() {
		super();
	}

	public EqualsFilterRatio2Validation(String parameter) {
		super(parameter);
	}

	@Override
	public EqualsFilterRatio2Validation initialized() {
		super.initialized();
		comparator1RowCode = getStringParameter("comparator1RowCode");
		comparator2RowCode = getStringParameter("comparator2RowCode");
		fieldRow1 = getStringParameter("fieldRow1");
		fieldRow2 = getStringParameter("fieldRow2");
		fieldFilter = getStringParameter("fieldFilter");
		filterValue = getStringParameter("filterValue");
		message = getStringParameter("message");
		return this;
	}
	
	private BigDecimal getComparator1Value(String column, String filterField, String filterValue) {
		return UtilValidation.calculateColumn(SubmissionFormat.mapPosValue, comparator1RowCode, column, scale, filterField, filterValue);
	}
	
	private BigDecimal getComparator2Value(String column, String filterField, String filterValue) {
		return UtilValidation.calculateColumn(SubmissionFormat.mapPosValue, comparator2RowCode, column, scale, filterField, filterValue);
	}
	
	private BigDecimal getComparatorValue(String column, String filterValue) {
		BigDecimal value1 = getComparator1Value(column, fieldFilter, filterValue);
		BigDecimal value2 = getComparator2Value(fieldRow2, fieldFilter, filterValue);
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

			List<String> filters = Arrays.asList(StringUtils.split(filterValue, "|"));
			String filterFieldValue = validationResult.getColumn(Integer.parseInt(fieldFilter));

			if (!filters.contains(filterFieldValue)) return;

			String[] arrColumn = StringUtils.split(selectField, "|");
			String[] dividends = StringUtils.split(fieldRow1, "|");

			for (int i = 0; i < arrColumn.length; i++) {
				String column = arrColumn[i];
				String divCol = dividends[i];
				BigDecimal comparatorValue = getComparatorValue(divCol, filterFieldValue);
				BigDecimal currentValue = getCurrentValue(validationResult, column);

				if (currentValue.compareTo(comparatorValue) != 0) {
					log.error("{}->{}?{}", parameter, currentValue, comparatorValue);
					List<SubmissionField> fields = submissionFormat.getFields();
					SubmissionField submissionField = fields.get(Integer.parseInt(column));
					SubmissionField errJenisProgram = fields.get(Integer.parseInt(column));
					validationResult.errors.add(new ValidationError(submissionField,
							ValidationErrorCode.E50_02_FORMULA, "", 
							StringUtils.replace(message, "|", "=")
									+ " pada '" + errJenisProgram.getName() + "' = " + filterFieldValue));
				}
			}
		}
	}
}