package id.go.ojk.client.model.config.validation.field;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("UniqueToOtherFieldValidation")
public class UniqueToOtherFieldValidation extends MapParamFieldValidation {
	private String checkField;

	public UniqueToOtherFieldValidation(String parameter) {
		setParameter(parameter);
	}
	
	public UniqueToOtherFieldValidation() {
		super();
	}

	public UniqueToOtherFieldValidation initialized() {
		checkField = getStringParameter("checkField");
		return this;
	}
	
	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		String realValue = validationResult.getColumn(field.getNumber());
		if (isExist(realValue, validationResult)) {
			validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E15_00_FIELD_UNIQUE, realValue));
		}
	}
	
	private List<String> getExisting(ValidationResult validationResult) {
		List<String> res = new ArrayList<>();
		String[] arrCheckField = StringUtils.split(checkField, "|");
		if (arrCheckField != null) {
			for (int i = 0; i < arrCheckField.length; i++) {
				res.add(validationResult.getColumn(Integer.valueOf(arrCheckField[i])));
			}
		}
		return res;
	}
	
	private boolean isExist(String realValue, ValidationResult validationResult) {
		List<String> list = getExisting(validationResult);
		return list.contains(realValue);
	}
}
