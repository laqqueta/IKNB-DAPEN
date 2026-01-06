package id.go.ojk.client.model.config.validation.field;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;

@XStreamAlias("ReferenceConditionPosValidation")
public class ReferenceConditionPosValidation extends ReferenceConditionValidation {
	private String refPosCode;

	public ReferenceConditionPosValidation(String parameter) {
		super(parameter);
	}
	
	public ReferenceConditionPosValidation() {
		super();
	}

	@Override
	public ReferenceConditionPosValidation initialized() {
		super.initialized();
		refPosCode = getStringParameter("refPosCode");
		return this;
	}
	
	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		List<String> list = Arrays.asList(StringUtils.split(refPosCode, "|"));
		if (list.contains(validationResult.getColumn(1))) {
			super.validate(submissionFormat, field, validationResult);
		}
	}
}
