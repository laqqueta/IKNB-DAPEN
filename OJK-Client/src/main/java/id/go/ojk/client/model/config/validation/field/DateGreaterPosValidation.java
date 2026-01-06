package id.go.ojk.client.model.config.validation.field;

import java.util.List;

import org.apache.commons.net.util.ToStringList;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;

@XStreamAlias("DateGreaterPosValidation")
public class DateGreaterPosValidation extends DateGreaterValidation {
	protected String refPosCode;

	public DateGreaterPosValidation() { }

	public DateGreaterPosValidation(String parameter) {
		setParameter(parameter);
	}

	@Override
	public DateGreaterPosValidation initialized() {
		super.initialized();
		refPosCode = getStringParameter("refPosCode");
		return this;
	};

	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		List<String> list = ToStringList.convert(refPosCode, "|");
		String posCode = validationResult.getColumn(1);
		if (list.contains(posCode)) {
			super.validate(submissionFormat, field, validationResult);
		}
	}
}
