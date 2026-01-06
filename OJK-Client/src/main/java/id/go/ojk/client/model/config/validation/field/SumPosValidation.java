package id.go.ojk.client.model.config.validation.field;

import org.apache.commons.net.util.ToStringList;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;

@XStreamAlias("SumPosValidation")
public class SumPosValidation extends SumValidation {
	private String refPosCode;

	public SumPosValidation(String parameter) {
		super(parameter);
	}
	
	public SumPosValidation() {
		super();
	}

	@Override
	public SumPosValidation initialized() {
		super.initialized();
		refPosCode = getStringParameter("refPosCode");
		return this;
	}
	
	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		if (ToStringList.convert(refPosCode, "|").contains(validationResult.getColumn((1)))) {
			super.validate(submissionFormat, field, validationResult);
		}
	}
}
