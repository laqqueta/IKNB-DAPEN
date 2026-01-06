package id.go.ojk.client.model.config.validation.field;

import java.math.BigDecimal;

import org.apache.commons.net.util.ToBigDecimal;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("GreaterValueValidation")
public class GreaterValueValidation extends MapParamFieldValidation {
	private String valueComparator;

	public GreaterValueValidation() {
	}

	public GreaterValueValidation(String parameter) {
		setParameter(parameter);
	}

	@Override
	public GreaterValueValidation initialized() {
		valueComparator = getStringParameter("valueComparator");
		return this;
	};

	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		BigDecimal comparator = ToBigDecimal.convert(valueComparator, 0);
		BigDecimal realValue = ToBigDecimal.convert(validationResult.getColumn(field.getNumber()));
		if (realValue.compareTo(comparator) < 1) {
			validationResult.errors
					.add(new ValidationError(field, ValidationErrorCode.E11_13_GREATER, valueComparator));
		}
	}
}
