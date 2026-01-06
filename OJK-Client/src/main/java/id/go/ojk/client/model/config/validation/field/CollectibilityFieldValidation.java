package id.go.ojk.client.model.config.validation.field;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import id.go.ojk.lib.client.service.context.ApplicationContext;

@XStreamAlias("collectibilityFieldValidation")
public class CollectibilityFieldValidation extends MapParamFieldValidation {

	private int conditionCodeField;
	private String refCollectibilityCode = "1";

	public CollectibilityFieldValidation(String parameter){
		setParameter(parameter);
	}
	
	private ReferenceService referenceService;
	
	@Override
	public void setApplicationContext(ApplicationContext appCtx) {
		super.setApplicationContext(appCtx);
		referenceService = appCtx.getService(ReferenceService.class);
	}

	@Override
	public CollectibilityFieldValidation initialized() {
		conditionCodeField = getIntParameter("conditionCodeField");
		refCollectibilityCode = getStringParameter("refCollectibilityCode", refCollectibilityCode);
		return this;
	};

	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		String conditionCode = validationResult.getColumn(conditionCodeField);
		if ( StringUtils.isEmpty(conditionCode) )
			return;

		String conditionLabel1 = referenceService.getLabel(ReferenceMetadata.R24Condition.getNumber(), 0, conditionCode);
		if ( ReferenceMetadata.R24_Category_T.equals(conditionLabel1) ){
			String value = validationResult.getColumn(field.getNumber());
			if( !refCollectibilityCode.equals(value) ){
				//validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E11_06_EQUAL, field.getName(), refCollectibilityCode));
				validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E20_06_COLLECTIBILITY, field.getName(), refCollectibilityCode, conditionCode));
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

	public String getRefCollectibilityCode() {
		return refCollectibilityCode;
	}
	public void setRefCollectibilityCode(String refCollectibilityCode) {
		this.refCollectibilityCode = refCollectibilityCode;
	}

}
