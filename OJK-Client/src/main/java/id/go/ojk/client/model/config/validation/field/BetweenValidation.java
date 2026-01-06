package id.go.ojk.client.model.config.validation.field;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.util.ToBigDecimal;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("BetweenValidation")
public class BetweenValidation extends MapParamFieldValidation {
	private String minValue;
	private String maxValue;

	public BetweenValidation(String parameter){
		setParameter(parameter);
	}

	@Override
	public BetweenValidation initialized() {
		minValue = getStringParameter("minValue");
		maxValue = getStringParameter("maxValue");
		return this;
	};

	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		String currentValue = validationResult.getColumn(field.getNumber());
		if (StringUtils.isNotEmpty(currentValue)) {
			BigDecimal current = ToBigDecimal.convert(currentValue, 0);
			BigDecimal min = ToBigDecimal.convert(minValue, 0);
			BigDecimal max = ToBigDecimal.convert(maxValue, 0);
			if (current.compareTo(min) < 0 || current.compareTo(max) > 0) {
				validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E12_19_VALUE_BETWEEN, minValue, maxValue));
			}
		}
	}
}
