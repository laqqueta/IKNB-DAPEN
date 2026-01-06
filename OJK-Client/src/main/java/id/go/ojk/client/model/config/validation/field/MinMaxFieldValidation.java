package id.go.ojk.client.model.config.validation.field;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.validation.ValidationUtil;
import id.go.ojk.lib.client.model.constant.Comparation;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("minMaxFieldValidation")
public class MinMaxFieldValidation extends MapParamFieldValidation {

	private double minValue;
	private Boolean minEqual;

	private double maxValue;
	private Boolean maxEqual;

	public MinMaxFieldValidation(String parameter){
		setParameter(parameter);
	}

	@Override
	public MinMaxFieldValidation initialized() {
		minEqual = getBooleanParameter("minEqual");
		if ( minEqual != null )
			minValue = getDoubleParameter("minValue");

		maxEqual = getBooleanParameter("maxEqual");
		if ( maxEqual != null )
			maxValue = getDoubleParameter("maxValue");

		return this;
	};

	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		//Double value = ValidationUtil.validateDouble(field, validationResult.rowSplited[field.getNumber()], validationResult.errors);
		//error tidak disertakan karena sudah dicek oleh regex
		Double value = ValidationUtil.validateDouble(field, validationResult.getColumn(field.getNumber()), null);
		
		if ( value != null ){
			if ( minEqual != null ){
				Comparation comparation = minEqual ? Comparation.gte : Comparation.gt;
				if ( !comparation.testCompareDouble(value, minValue) ){
					validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E12_08_MIN_VALUE, comparation.getCode(), (long)minValue));
				}
			}

			if ( maxEqual != null ){
				Comparation comparation = maxEqual ? Comparation.lte : Comparation.lt;
				if ( !comparation.testCompareDouble(value, maxValue) ){
					validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E12_09_MAX_VALUE, comparation.getCode(), (long)maxValue));
				}
			}

		}
	}

	//~ getter setter

	public double getMinValue() {
		return minValue;
	}

	public void setMinValue(double minValue) {
		this.minValue = minValue;
	}

	public Boolean getMinEqual() {
		return minEqual;
	}

	public void setMinEqual(Boolean minEqual) {
		this.minEqual = minEqual;
	}

	public double getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(double maxValue) {
		this.maxValue = maxValue;
	}

	public Boolean getMaxEqual() {
		return maxEqual;
	};
	public void setMaxEqual(Boolean maxEqual) {
		this.maxEqual = maxEqual;
	}


}
