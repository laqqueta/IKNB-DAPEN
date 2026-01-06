package id.go.ojk.client.model.config.validation.field;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("DateValidation")
public class DateValidation extends MapParamFieldValidation {
	protected String dateFormat;

	public DateValidation() { }

	public DateValidation(String parameter) {
		setParameter(parameter);
	}

	@Override
	public DateValidation initialized() {
		dateFormat = getStringParameter("dateFormat", "yyyyMMdd");
		return this;
	};

	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		String realValue = validationResult.getColumn(field.getNumber());
		if (!isValidDate(realValue)) {
			validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E11_00_FORMAT, dateFormat));
		}
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
