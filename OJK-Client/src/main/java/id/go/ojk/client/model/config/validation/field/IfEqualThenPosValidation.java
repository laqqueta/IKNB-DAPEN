package id.go.ojk.client.model.config.validation.field;

import org.apache.commons.net.util.ToStringList;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;

@XStreamAlias("IfEqualThenPosValidation")
public class IfEqualThenPosValidation extends IfEqualThenValidation {
	private String rowCode;

	public IfEqualThenPosValidation() {
		super();
	}

	public IfEqualThenPosValidation(String parameter) {
		super(parameter);
	}

	@Override
	public IfEqualThenPosValidation initialized() {
		super.initialized();
		rowCode = getStringParameter("rowCode");
		return this;
	};

	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		if (ToStringList.convert(rowCode, "|").contains(validationResult.getColumn((1)))) {
			super.validate(submissionFormat, field, validationResult);
		}
	}
}
