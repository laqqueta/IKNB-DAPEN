package id.go.ojk.client.model.config.validation.field;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;

@XStreamAlias("NotEqualsPosFixedValueValidation")
public class NotEqualsPosFixedValueValidation extends NotEqualsFixedValueValidation {
	protected String posCode;

	public NotEqualsPosFixedValueValidation() { }

	public NotEqualsPosFixedValueValidation(String parameter) {
		setParameter(parameter);
	}

	@Override
	public NotEqualsPosFixedValueValidation initialized() {
		super.initialized();
		posCode = getStringParameter("posCode");
		return this;
	};

	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		String[] arrPosCode = StringUtils.split(posCode, "|");
		if (arrPosCode != null) {
			for (int i = 0; i < arrPosCode.length; i++) {
				String currentPosCode = validationResult.getColumn(1);
				if (currentPosCode.equals(arrPosCode[i])) {
					super.validate(submissionFormat, field, validationResult);
				}
			}
		}
	}
}
