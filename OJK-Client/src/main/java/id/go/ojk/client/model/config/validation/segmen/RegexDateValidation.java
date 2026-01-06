package id.go.ojk.client.model.config.validation.segmen;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.config.Regex;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("regexDateValidation")
public class RegexDateValidation extends BaseRegexValidation {
	private String dateFormat;
	
	public RegexDateValidation() {
		super();
	}
	
	public RegexDateValidation(String parameter) {
		super(parameter);
	}
	
	@Override
	public RegexDateValidation initialized() {
		super.initialized();
		dateFormat = getStringParameter("dateFormat", "yyyyMMdd");
		return this;
	}

	@Override
	protected Regex getRegex() {
		return SimpleValidation.patternDate;
	}
	
	@Override
	protected boolean validate(Regex regex, String value, SubmissionField field, ValidationResult validationResult) {
		boolean res = super.validate(regex, value, field, validationResult);
		if (res) {
			if (!isValidDate(value)) {
				validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E11_00_FORMAT, dateFormat));
				res = false;
			}
		}
		return res;
	}
	
	private boolean isValidDate(String dateStr) {
		DateFormat sdf = new SimpleDateFormat(this.dateFormat);
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
	}
}