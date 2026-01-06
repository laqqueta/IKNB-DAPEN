package id.go.ojk.client.model.config.validation.segmen;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("cancelFacilityValidation")
public class CancelFacilityValidation extends MapParamSegmentValidation {

	private int conditionCodeField;					//KODE KONDISI
	private String canceledConditionCode = "01";	//01

	public CancelFacilityValidation(){
		super();
	}

	public CancelFacilityValidation(String parameter){
		super(parameter);
	}

	@Override
	public CancelFacilityValidation initialized() {
		this.conditionCodeField 	= getIntParameter("conditionCodeField");
		this.canceledConditionCode 	= getStringParameter("canceledConditionCode", canceledConditionCode);

		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
		List<SubmissionField> fields = submissionFormat.getFields();
		String conditionCode = validationResult.getColumn(conditionCodeField);
		String operationCode = validationResult.getColumn(fields.size() - 1);

		//Jika kode kondisi dibatalkan maka tidak boleh create (C)
		if ( StringUtils.isNotEmpty(conditionCode) && conditionCode.equals(canceledConditionCode) && "C".equals(operationCode)) {
			validationResult.errors.add(
				new ValidationError(
					fields.get(conditionCodeField),
					ValidationErrorCode.E20_35_CANCELED_CONDITION, canceledConditionCode
				)
			);
		}
	}

}
