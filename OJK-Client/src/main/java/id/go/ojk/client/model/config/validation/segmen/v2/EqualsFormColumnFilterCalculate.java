package id.go.ojk.client.model.config.validation.segmen.v2;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.UtilValidation;
import id.go.ojk.client.model.config.validation.segmen.BaseDecimalValidation;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.constant.ESymbolMap;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

@XStreamAlias("EqualsFormColumnFilterCalculate")
@Slf4j
public class EqualsFormColumnFilterCalculate extends BaseDecimalValidation {
	private String comparatorColumn;
	private String comparatorRowCode;
	private String comparatorForm;
	private String filterColumn;
	private String filterValues;
	private String message;

	private final AtomicReference<String> filterVal = new AtomicReference<>();

	public EqualsFormColumnFilterCalculate() {
		super();
	}

	public EqualsFormColumnFilterCalculate(String parameter) {
		super(parameter);
	}

	@Override
	public EqualsFormColumnFilterCalculate initialized() {
		super.initialized();
		comparatorColumn = getStringParameter("comparatorColumn");
		comparatorRowCode = getStringParameter("comparatorRowCode");
		comparatorForm = getStringParameter("comparatorForm");
		message = ESymbolMap.decode(getStringParameter("message"));
		filterColumn = getStringParameter("filterColumn");
		filterValues = getStringParameter("filterValues");
		return this;
	}
	
	private BigDecimal getComparatorValue() {
		String formPrefix = comparatorForm + comparatorRowCode;
		Stream<Map.Entry<String, Map<String, String>>> savedValues = SubmissionFormat.getStreamOfFormSubMapFieldFilter(formPrefix, Character.MAX_VALUE, filterColumn, filterVal.get());

		return UtilValidation.calculateColumn(savedValues, comparatorRowCode, comparatorColumn, scale);
	}

	private BigDecimal getCurrentValue(ValidationResult validationResult) {
		return UtilValidation.toBigDecimal(validationResult.getColumn(Integer.parseInt(selectField)), "0");
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		String currentRowCode = validationResult.getColumn(1);
		if (currentRowCode.equals(selectPosCode)) {

			List<String> filters = Arrays.asList(StringUtils.split(filterValues, "|"));
			String filterFieldValue = validationResult.getColumn(Integer.parseInt(filterColumn));

			if (!filters.contains(filterFieldValue)) return;
			filterVal.set(filterFieldValue);

			BigDecimal comparatorValue = getComparatorValue();
			BigDecimal currentValue = getCurrentValue(validationResult);
			if (currentValue.compareTo(comparatorValue) != 0) {
				log.error("{}>{}?{}", parameter, currentValue, comparatorValue);
				List<SubmissionField> fields = submissionFormat.getFields();
				SubmissionField submissionField = fields.get(Integer.parseInt(selectField));
				SubmissionField sfJenisProgram = fields.get(Integer.parseInt(filterColumn));
				validationResult.errors.add(new ValidationError(submissionField,
						ValidationErrorCode.E50_02_FORMULA, String.valueOf(comparatorValue), 
						StringUtils.replace(message, "|", "=")
								+ " dengan '"
								+ sfJenisProgram.getName() + "' = '" + filterFieldValue + "'"));
			}
		}
	}
}