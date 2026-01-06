package id.go.ojk.client.model.config.validation.segmen;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.config.Regex;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("PeriodValidation")
public class PeriodValidation extends BaseRegexValidation {
	
	public PeriodValidation() {
		super();
	}
	
	public PeriodValidation(String parameter) {
		super(parameter);
	}

	@Override
	protected Regex getRegex() {
		return SimpleValidation.PATTERN_PERIOD;
	}
	
	@Override
	protected boolean validate(Regex regex, String value, SubmissionField field, ValidationResult validationResult) {
		boolean res = super.validate(regex, value, field, validationResult);
		if (res) {
			String[] arr = value.split(":");
			if (getValue(arr, 1) > 23) {
				validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E11_12_LESS_EQUAL, "jam", "23"));
				res = false;
			}
			if (getValue(arr, 2) > 59) {
				validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E11_12_LESS_EQUAL, "menit", "59"));
				res = false;
			}
		}
		return res;
	}
	
	private int getValue(String[] arr, int idx) {
		String tmp = arr.length >= idx + 1 ? arr[idx] : "0";
		return Integer.parseInt(tmp);
	}
}