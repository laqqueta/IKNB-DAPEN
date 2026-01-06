package id.go.ojk.client.model.config.validation.segmen;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.client.service.validation.ValidationUtil;
import id.go.ojk.lib.client.model.constant.Comparation;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("minMaxSegmentValidation")
public class MinMaxSegmentValidation extends BaseRowValidation {
	private double minValue;
	private Boolean minEqual;
	private double maxValue;
	private Boolean maxEqual;

	public MinMaxSegmentValidation() {
		super();
	}

	public MinMaxSegmentValidation(String parameter) {
		super(parameter);
	}

	@XStreamOmitField
	private ReferenceService referenceService = null;

	@Override
	public MinMaxSegmentValidation initialized() {	
		super.initialized();
		minEqual = getBooleanParameter("minEqual");
		if ( minEqual != null )
			minValue = getDoubleParameter("minValue");

		maxEqual = getBooleanParameter("maxEqual");
		if ( maxEqual != null )
			maxValue = getDoubleParameter("maxValue");
		
		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
		List<SubmissionField> fields = submissionFormat.getFields();
		
		String[] SelectField = selectField.split("[|]");
		String[] SelectPosCode = selectPosCode.split("[|]");
		String posCode = validationResult.getColumn(1);
		
		for (String values : SelectField) {
			Double fieldValue = ValidationUtil.validateDouble(fields.get(Integer.parseInt(values)), validationResult, false);			
			if (fieldValue != null) {
				for (String code : SelectPosCode) {
					if(posCode.contains(code)) {						
						if ( minEqual != null ){
							Comparation comparation = minEqual ? Comparation.gte : Comparation.gt;
							if ( !comparation.testCompareDouble(fieldValue, minValue) ){
								validationResult.errors.add(new ValidationError(fields.get(Integer.parseInt(values)), ValidationErrorCode.E12_08_MIN_VALUE, comparation.getCode(), (long)minValue));
							}
						}

						if ( maxEqual != null ){
							Comparation comparation = maxEqual ? Comparation.lte : Comparation.lt;
							if ( !comparation.testCompareDouble(fieldValue, maxValue) ){
								validationResult.errors.add(new ValidationError(fields.get(Integer.parseInt(values)), ValidationErrorCode.E12_09_MAX_VALUE, comparation.getCode(), (long)maxValue));
							}
						}
					}
				}
			}
		}
	}
}