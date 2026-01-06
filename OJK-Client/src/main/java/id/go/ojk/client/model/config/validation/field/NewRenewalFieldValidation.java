package id.go.ojk.client.model.config.validation.field;

import java.time.LocalDate;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.validation.ValidationUtil;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * startDateField=&creditBeginingDateField
 *
 */
@XStreamAlias("newRenewalFieldValidation")
public class NewRenewalFieldValidation extends MapParamFieldValidation {

	@Getter @Setter private int startDateField;
	@Getter @Setter private int creditBeginingDateField;
	
	public NewRenewalFieldValidation(String parameter){
		setParameter(parameter);
	}

	@Override
	public NewRenewalFieldValidation initialized() {
		startDateField = getIntParameter("startDateField");
		creditBeginingDateField = getIntParameter("creditBeginingDateField");
		return this;
	};

	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		
		SubmissionField startDateFieldObj = submissionFormat.getFields().get(startDateField);
		SubmissionField creditBeginingDateFieldObj = submissionFormat.getFields().get(creditBeginingDateField);
		
		LocalDate startDate = ValidationUtil.validateDate(startDateFieldObj, validationResult, false);
		LocalDate creditBeginingDate = ValidationUtil.validateDate(creditBeginingDateFieldObj, validationResult, false);
				
		if ( startDate != null && creditBeginingDate != null && startDate.isAfter(creditBeginingDate)){
			
			//Integer value = ValidationUtil.validateInteger(validationResult.rowSplited[field.getNumber()], validationResult.errors);
			Integer value = ValidationUtil.validateInteger(validationResult.getColumn(field.getNumber()), null);
			
			if ( value != null && value.intValue() == 0 ){
				String reason = 
					StringUtils.join(
							startDateFieldObj.getName(), " > ", creditBeginingDateFieldObj.getName()
					);
				validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E20_08_NEW_RENEWAL, reason));
			}
		}		
	}

}
