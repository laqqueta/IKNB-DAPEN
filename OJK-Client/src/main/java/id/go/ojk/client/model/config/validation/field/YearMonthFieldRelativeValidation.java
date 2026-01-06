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
import id.go.ojk.lib.client.model.config.validation.field.YearMonthDifferent;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

/**
 * minDifferent=yyyy|MM&maxDifferent=1|1
 *
 */

@XStreamAlias("yearMonthFieldRelativeValidation")
public class YearMonthFieldRelativeValidation extends MapParamFieldValidation {

	private YearMonthDifferent minDifferent;
	private YearMonthDifferent maxDifferent;

	public YearMonthFieldRelativeValidation(String parameter){
		setParameter(parameter);
	}

	@Override
	public YearMonthFieldRelativeValidation initialized() {
		minDifferent = yearMonthDifferent("minDifferent");
		maxDifferent = yearMonthDifferent("maxDifferent");
		return this;
	};
	
	@XStreamOmitField
	private LocalDate minDate;
	
	@XStreamOmitField
	private LocalDate maxDate;
	
	@Override
	public FieldValidation beforeValidationStart(SubmissionData submissionData) {
		if ( minDifferent != null )
			minDate = minDifferent.applyDifference(submissionData.getDataYearMonth());

		if ( maxDifferent != null )
			maxDate = maxDifferent.applyDifference(submissionData.getDataYearMonth());

		return this;
	}
	
	public static DateTimeFormatter MM_yyyyDateFormat = DateTimeFormatter.ofPattern("MM/yyyy");

	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		LocalDate localDate = ValidationUtil.validateYearMonth(field, validationResult, false);
		
		if ( localDate == null )
			return;

		if ( minDate != null && minDate.isAfter(localDate) ){
			validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E12_11_YEARMONTH_MIN, MM_yyyyDateFormat.format(minDate)));
		}
		
		if ( maxDate != null && maxDate.isBefore(localDate) ){
			validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E12_12_YEARMONTH_MAX, MM_yyyyDateFormat.format(maxDate)));
		}		
	}
	
	protected YearMonthDifferent yearMonthDifferent(String name){
		String stringParam = getStringParameter(name);
		if ( StringUtils.isEmpty(stringParam) )
			return null;
		return YearMonthDifferent.fromString(stringParam);
	}

}
