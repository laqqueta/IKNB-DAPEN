package id.go.ojk.client.model.config.validation.segmen;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.client.service.validation.ValidationUtil;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import id.go.ojk.lib.client.service.context.ApplicationContext;

@XStreamAlias("overdueValidation")
public class OverdueValidation extends MapParamSegmentValidation {

	private int conditionCodeField;
	private int pricipalAmountField;
	private int interestAmountField;
	private int daysField;

	public OverdueValidation(){
		super();
	}

	public OverdueValidation(String parameter){
		super(parameter);
	}

	private ReferenceService referenceService;
	@Override
	public void setApplicationContext(ApplicationContext appCtx) {
		this.appCtx = appCtx;
		if( appCtx != null ){
			referenceService = appCtx.getService(ReferenceService.class);			
		}
	}

	@Override
	public OverdueValidation initialized() {
		this.conditionCodeField 	= getIntParameter("conditionCodeField");
		this.pricipalAmountField 	= getIntParameter("pricipalAmountField");
		this.interestAmountField 	= getIntParameter("interestAmountField");
		this.daysField 				= getIntParameter("daysField");
		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
		
		List<SubmissionField> fields =submissionFormat.getFields();
		if ( StringUtils.isEmpty(validationResult.getColumn(conditionCodeField)) )
			return;

		String conditionCategory = referenceService.getLabel(ReferenceMetadata.R24Condition.getNumber(), 0, validationResult.getColumn(conditionCodeField));

		if ( StringUtils.isEmpty(conditionCategory) )
			return;

		Long pricipalAmount 	= ValidationUtil.validateLong(fields.get(pricipalAmountField), validationResult.getColumn(pricipalAmountField), null);
		Integer days 			= ValidationUtil.validateInteger(validationResult.getColumn(daysField), null);
		Long interestAmount 	= null;
		
		if ( interestAmountField != 0 ) {
			interestAmount 	= ValidationUtil.validateLong(fields.get(interestAmountField), validationResult.getColumn(interestAmountField), null);
		}


		if ( ReferenceMetadata.R24_Category_T.equals(conditionCategory) ){

			if ( interestAmountField != 0 ) {
				if ( pricipalAmount != null && pricipalAmount != 0 ){
					SubmissionField field = fields.get(pricipalAmountField);
					validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E20_11_OVERDUE, field.getName()));
				}

				if ( interestAmount != null && interestAmount != 0 ){
					SubmissionField field = fields.get(interestAmountField);
					validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E20_11_OVERDUE, field.getName()));
				}

			} else {
				if ( pricipalAmount != null && pricipalAmount != 0 ){
					SubmissionField field = fields.get(pricipalAmountField);
					validationResult.errors.add(new ValidationError(fields.get(pricipalAmountField), ValidationErrorCode.E20_11_OVERDUE, field.getName()));
				}

			}
		}
		
		if ( interestAmountField != 0 ) {
			if ( pricipalAmount != null && pricipalAmount == 0 && interestAmount != null && interestAmount == 0 ){
				if ( days != null && days != 0 ){
					SubmissionField field = fields.get(daysField);
					validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E20_12_OVERDUE, field.getName()));					
				}
			} else if ( (pricipalAmount != null && pricipalAmount > 0)  ||  (interestAmount != null && interestAmount > 0) ){
				if ( days != null && days == 0 ){
					SubmissionField field = fields.get(daysField);
					validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E20_14_OVERDUE, field.getName()));					
				}				
			}
			
//			if ( days != null && days != 0 && pricipalAmount != null && pricipalAmount == 0 && interestAmount != null && interestAmount == 0){
//				SubmissionField field = fields.get(daysField);
//				validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E20_12_OVERDUE, field.getName()));
//			} 
			
		} else {
			if ( days != null && days != 0 && pricipalAmount != null && pricipalAmount == 0 ){
				SubmissionField field = fields.get(daysField);
				validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E20_13_OVERDUE, field.getName()));
			} else if ( days != null && days == 0 && pricipalAmount != null && pricipalAmount > 0  ){
				SubmissionField field = fields.get(daysField);
				validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E20_17_OVERDUE, field.getName()));				
			}

//			if ( days != null && days != 0 && pricipalAmount != null && pricipalAmount == 0 ){
//				SubmissionField field = fields.get(daysField);
//				validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E20_13_OVERDUE, field.getName()));
//			}
		}

	}
}
