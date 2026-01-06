package id.go.ojk.client.model.config.validation.field;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.util.ToBigDecimal;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("GreaterValuePosValidation")
public class GreaterValuePosValidation extends MapParamFieldValidation {
	private String refPosCode;
	private String valueComparator;

	public GreaterValuePosValidation() {
	}

	public GreaterValuePosValidation(String parameter) {
		setParameter(parameter);
	}

	@Override
	public GreaterValuePosValidation initialized() {
		refPosCode = getStringParameter("refPosCode");
		valueComparator = getStringParameter("valueComparator");
		return this;
	};

	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		if (hasPosCode(validationResult)) {
			BigDecimal comparator = ToBigDecimal.convert(valueComparator, 0);
			BigDecimal realValue = ToBigDecimal.convert(validationResult.getColumn(field.getNumber()));
			if (realValue.compareTo(comparator) < 1) {
				validationResult.errors
						.add(new ValidationError(field, ValidationErrorCode.E11_13_GREATER, valueComparator));
			}
		}
	}
	
	private boolean hasPosCode(ValidationResult validationResult) {
		List<String> list = Arrays.asList(StringUtils.split(refPosCode, "|"));
		String currentPosCode = validationResult.getColumn(1);
		return StringUtils.isNotEmpty(currentPosCode) && list.contains(currentPosCode);
	}
}
