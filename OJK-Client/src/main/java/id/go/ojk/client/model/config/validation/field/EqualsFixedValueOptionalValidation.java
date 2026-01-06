package id.go.ojk.client.model.config.validation.field;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.util.ToStringList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("EqualsFixedValueOptionalValidation")
public class EqualsFixedValueOptionalValidation extends EqualsFixedValueValidation {

	public EqualsFixedValueOptionalValidation() { }

	public EqualsFixedValueOptionalValidation(String parameter) {
		setParameter(parameter);
	}

	@Override
	public EqualsFixedValueOptionalValidation initialized() {
		super.initialized();
		return this;
	};

	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		Logger logger = LoggerFactory.getLogger(EqualsFixedValueOptionalValidation.class);
		List<String> listValue = ToStringList.convert(value, "|");
		if (listValue != null) {
			String realValue = validationResult.getColumn(field.getNumber());
			if (StringUtils.isNotEmpty(realValue) && !listValue.contains(realValue)) {
				logger.error(validationResult.getColumn(1) + "|" + realValue + "?" + listValue);
				validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E11_07_EQUAL,
						StringUtils.replace(value, "|", " atau ")));
			}
		}
	}
}
