package id.go.ojk.client.model.config.validation.field;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.validation.ValidationUtil;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("oriCurrencyFieldValidation")
public class OriCurrencyFieldValidation extends MapParamFieldValidation {

	private int refValueField;	//Baki Debet

	public OriCurrencyFieldValidation(String parameter){
		setParameter(parameter);
	}

	@Override
	public OriCurrencyFieldValidation initialized() {
		refValueField = getIntParameter("refValueField");
		return this;
	};

	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		SubmissionField refValueFieldObj = submissionFormat.getFields().get(refValueField);
		
//		Long refValue = ValidationUtil.validateLong(null, validationResult.rowSplited[refValueField], validationResult.errors);
//		Long value = ValidationUtil.validateLong(field, validationResult.rowSplited[field.getNumber()], validationResult.errors);

		Long refValue = ValidationUtil.validateLong(null, validationResult.getColumn(refValueField), null);
		Long value = ValidationUtil.validateLong(field, validationResult.getColumn(field.getNumber()), null);

		if ( refValue == null || value == null)
			return;
		if ( refValue > 0 ){
			if( value <= 0 ){
				//validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E20_06_ORI_CURRENCY, field.getName() + " Harus > 0"));
				String reason = StringUtils.join(refValueFieldObj.getName(), " > 0");
				validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E20_21_ORI_CURRENCY, reason));
			}
		} else {
			if( value > 0 ){
				//validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E20_06_ORI_CURRENCY, field.getName() + " Harus = 0"));
				String reason = StringUtils.join(refValueFieldObj.getName(), " = 0");
				validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E20_22_ORI_CURRENCY, reason));
			}
		}
	}

	//~ getter setter

	public int getRefValueField() {
		return refValueField;
	}

	public void setRefValueField(int refValueField) {
		this.refValueField = refValueField;
	}

}
