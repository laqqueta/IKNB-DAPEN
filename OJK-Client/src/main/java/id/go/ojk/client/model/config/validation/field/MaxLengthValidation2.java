package id.go.ojk.client.model.config.validation.field;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("MaxLengthValidation2")
public class MaxLengthValidation2 extends MapParamFieldValidation {
	protected String fieldComparator1;
	protected String valueComparator1;
	protected String fieldComparator2;
	protected String valueComparator2;
	protected int maxLength;

	public MaxLengthValidation2() { }

	public MaxLengthValidation2(String parameter) {
		setParameter(parameter);
	}

	@Override
	public MaxLengthValidation2 initialized() {
		fieldComparator1 = getStringParameter("fieldComparator1");
		valueComparator1 = getStringParameter("valueComparator1");
		fieldComparator2 = getStringParameter("fieldComparator2");
		valueComparator2 = getStringParameter("valueComparator2");
		maxLength = getIntParameter("maxLength", 0);
		return this;
	};

	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		String realValueComparator1 = validationResult.getColumn(Integer.parseInt(fieldComparator1));
		String realValueComparator2 = validationResult.getColumn(Integer.parseInt(fieldComparator2));
		if (realValueComparator1.equals(valueComparator1) && realValueComparator2.equals(valueComparator2)) {
			String realValue = validationResult.getColumn(field.getNumber());
			if (StringUtils.isEmpty(realValue) || (realValue.length() > maxLength)) {
				validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E11_02_MAX_LENGTH, maxLength));
			}
		}
	}
}
