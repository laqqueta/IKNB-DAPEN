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
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@XStreamAlias("EqualsFormColumnCalculateV2")
@Slf4j
public class EqualsFormColumnCalculate extends BaseDecimalValidation {
	private String comparatorColumn;
	private String comparatorRowCode;
	private String comparatorForm;
	private String message;

	public EqualsFormColumnCalculate() {
		super();
	}

	public EqualsFormColumnCalculate(String parameter) {
		super(parameter);
	}

	@Override
	public EqualsFormColumnCalculate initialized() {
		super.initialized();
		comparatorColumn = getStringParameter("comparatorColumn");
		comparatorRowCode = getStringParameter("comparatorRowCode");
		comparatorForm = getStringParameter("comparatorForm");
		message = ESymbolMap.decode(getStringParameter("message"));
		return this;
	}
	
	private BigDecimal getComparatorValue() {
		String formPrefix = comparatorForm + comparatorRowCode;
		Stream<Map.Entry<String, Map<String, String>>> savedValues = SubmissionFormat.getStreamOfFormSubMap(formPrefix, Character.MAX_VALUE);

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
			BigDecimal comparatorValue = getComparatorValue();
			BigDecimal currentValue = getCurrentValue(validationResult);
			if (currentValue.compareTo(comparatorValue) != 0) {
				log.error("{}>{}?{}", parameter, currentValue, comparatorValue);
				List<SubmissionField> fields = submissionFormat.getFields();
				SubmissionField submissionField = fields.get(Integer.parseInt(selectField));
				validationResult.errors.add(new ValidationError(submissionField,
						ValidationErrorCode.E50_02_FORMULA, String.valueOf(comparatorValue), 
						StringUtils.replace(message, "|", "=")));
			}
		}
	}
}