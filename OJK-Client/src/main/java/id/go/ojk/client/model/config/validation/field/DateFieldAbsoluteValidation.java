package id.go.ojk.client.model.config.validation.field;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.validation.ValidationUtil;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("dateFieldAbsoluteValidation")
public class DateFieldAbsoluteValidation extends MapParamFieldValidation {

	private LocalDate minDate;
	private LocalDate maxDate;

	public DateFieldAbsoluteValidation(String parameter){
		setParameter(parameter);
	}

	@Override
	public DateFieldAbsoluteValidation initialized() {
		minDate = getLocalDateParameter("minDate");
		maxDate = getLocalDateParameter("maxDate");
		return this;
	};
	
	public static DateTimeFormatter yyyyMMddDateFormat = DateTimeFormatter.ofPattern("yyyyMMdd");
	public static DateTimeFormatter dd_MM_yyyyDateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		LocalDate localDate = ValidationUtil.validateDate(field, validationResult, false);
		
		if ( localDate == null )
			return;

		if ( minDate != null && minDate.isAfter(localDate) ){
			validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E12_06_DATE_MIN, dd_MM_yyyyDateFormat.format(minDate)));
		}
		
		if ( maxDate != null && maxDate.isBefore(localDate) ){
			validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E12_07_DATE_MAX, dd_MM_yyyyDateFormat.format(maxDate)));
		}		
	}
}
