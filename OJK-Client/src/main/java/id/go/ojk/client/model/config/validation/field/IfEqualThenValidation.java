package id.go.ojk.client.model.config.validation.field;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("IfEqualThenValidation")
public class IfEqualThenValidation extends MapParamFieldValidation {
	private Integer fieldCondition;
	private String trueConditionValue;
	private String trueValue;

	public IfEqualThenValidation() {

	}

	public IfEqualThenValidation(String parameter) {
		setParameter(parameter);
	}

	@Override
	public IfEqualThenValidation initialized() {
		fieldCondition = getIntParameter("fieldCondition");
		trueConditionValue = getStringParameter("trueConditionValue");
		trueValue = getStringParameter("trueValue");
		return this;
	};

	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		List<String> listTrueConditionValue = Arrays.asList(StringUtils.split(trueConditionValue, "|"));
		String fieldConditionValue = validationResult.getColumn(fieldCondition);
		if (listTrueConditionValue.contains(fieldConditionValue)) {
			List<String> listTrueValue = Arrays.asList(StringUtils.split(trueValue, "|"));
			String fieldValue = validationResult.getColumn(field.getNumber());
			if (!listTrueValue.contains(fieldValue)) {
				validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E50_15_COLUMNCONDITION,
						trueValue.replace("|", " atau "), fieldCondition + 1, 
						fieldConditionValue.replace("|", " atau ")));
			}
		}
	}
}
