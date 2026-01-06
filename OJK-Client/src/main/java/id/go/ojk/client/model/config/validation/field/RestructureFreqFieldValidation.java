package id.go.ojk.client.model.config.validation.field;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.validation.ValidationUtil;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("restructureFreqFieldValidation")
public class RestructureFreqFieldValidation extends MapParamFieldValidation {

	private int creditNatureField;
	private String refCreditNatureCode = "1";

	public RestructureFreqFieldValidation(String parameter){
		setParameter(parameter);
	}

	@Override
	public RestructureFreqFieldValidation initialized() {
		creditNatureField = getIntParameter("creditNatureField");
		refCreditNatureCode = getStringParameter("refCreditNatureCode", refCreditNatureCode);
		return this;
	};

	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		String creditNatureCode = validationResult.getColumn(creditNatureField);
		if ( StringUtils.isEmpty(creditNatureCode) )
			return;

		//Integer value = ValidationUtil.validateInteger(validationResult.rowSplited[field.getNumber()], validationResult.errors) ;
		Integer value = ValidationUtil.validateInteger(validationResult.getColumn(field.getNumber()), null) ;
		
		if ( value == null )
			return;

		if ( refCreditNatureCode.equals(creditNatureCode) ){
			if( value <= 0 ){
				//validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E20_07_RESTRUCTURE_FREQ, field.getName() + " harus > 0"));
				validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E20_15_RESTRUCTURE_FREQ, field.getName()));
			}
		} else {
			if( value > 0 ){
				//validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E20_07_RESTRUCTURE_FREQ, field.getName() + " harus = 0"));
				validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E20_16_RESTRUCTURE_FREQ, field.getName()));
			}
		}
	}

	//~ getter setter

	public int getCreditNatureField() {
		return creditNatureField;
	};
	public void setCreditNatureField(int creditNatureField) {
		this.creditNatureField = creditNatureField;
	};

	public String getRefCreditNatureCode() {
		return refCreditNatureCode;
	};
	public void setRefCreditNatureCode(String refCreditNatureCode) {
		this.refCreditNatureCode = refCreditNatureCode;
	};


}
