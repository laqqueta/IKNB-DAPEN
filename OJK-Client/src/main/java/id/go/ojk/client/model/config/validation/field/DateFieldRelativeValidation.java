package id.go.ojk.client.model.config.validation.field;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.validation.ValidationUtil;
import id.go.ojk.lib.client.model.config.validation.field.DateDifferent;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

/**
 * minDateDifferent=yyyy|MM|dd&maxDateDifferent=1|1|1
 *
 */

@XStreamAlias("dateFieldRelativeValidation")
public class DateFieldRelativeValidation extends MapParamFieldValidation {

	private DateDifferent minDateDifferent;
	private DateDifferent maxDateDifferent;

	public DateFieldRelativeValidation(String parameter){
		setParameter(parameter);
	}

	@Override
	public DateFieldRelativeValidation initialized() {
		minDateDifferent = minDateDifferent("minDateDifferent");
		maxDateDifferent = minDateDifferent("maxDateDifferent");
		return this;
	};
	
	@XStreamOmitField
	private LocalDate minDate;
	
	@XStreamOmitField
	private LocalDate maxDate;
	
	@Override
	public FieldValidation beforeValidationStart(SubmissionData submissionData) {
		if ( minDateDifferent != null )
			minDate = minDateDifferent.applyDifference(submissionData.getDataYearMonth());

		if ( maxDateDifferent != null )
			maxDate = maxDateDifferent.applyDifference(submissionData.getDataYearMonth());

		return this;
	}
	
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
	
	protected DateDifferent minDateDifferent(String name){
		if ( StringUtils.isEmpty(getStringParameter(name)) )
			return null;
		return DateDifferent.fromString(getStringParameter(name));
	}

}
