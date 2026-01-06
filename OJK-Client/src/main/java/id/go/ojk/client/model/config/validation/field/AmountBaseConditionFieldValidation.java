package id.go.ojk.client.model.config.validation.field;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.client.service.validation.ValidationUtil;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import id.go.ojk.lib.client.service.context.ApplicationContext;

@XStreamAlias("amountBaseConditionFieldValidation")
public class AmountBaseConditionFieldValidation extends MapParamFieldValidation {

	private int conditionCodeField;
	private final long cekAmount = 0;

	public AmountBaseConditionFieldValidation(String parameter){
		setParameter(parameter);
	}
	
	private ReferenceService referenceService;
	@Override
	public void setApplicationContext(ApplicationContext appCtx) {
		super.setApplicationContext(appCtx);
		referenceService = appCtx.getService(ReferenceService.class);
	}

	@Override
	public AmountBaseConditionFieldValidation initialized() {
		conditionCodeField = getIntParameter("conditionCodeField");
		return this;
	};

	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		String conditionCode = validationResult.getColumn(conditionCodeField);
		if ( StringUtils.isEmpty(conditionCode) )
			return;

		String conditionLabel1 = referenceService.getLabel(ReferenceMetadata.R24Condition.getNumber(), 0, conditionCode);
		if ( ReferenceMetadata.R24_Category_T.equals(conditionLabel1) ){
			
//			Long value = ValidationUtil.validateLong(field, validationResult.rowSplited[field.getNumber()], validationResult.errors) ;
			Long value = ValidationUtil.validateLong(field, validationResult.getColumn(field.getNumber()), null) ;
			
			if( value != null && value.longValue() != cekAmount ){
				validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E20_05_AMOUNT_BASE_CONDITION, field.getName(), cekAmount, conditionCode));
			}
		}
	}

	//~ getter setter

	public int getConditionCodeField() {
		return conditionCodeField;
	};
	public void setConditionCodeField(int conditionCodeField) {
		this.conditionCodeField = conditionCodeField;
	};

}
