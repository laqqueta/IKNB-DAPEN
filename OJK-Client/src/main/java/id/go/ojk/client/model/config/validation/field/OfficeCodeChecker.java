package id.go.ojk.client.model.config.validation.field;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("officeCodeChecker")
public class OfficeCodeChecker extends MapParamFieldValidation {

	public OfficeCodeChecker() {

	}

	public OfficeCodeChecker(String parameter) {
		setParameter(parameter);
	}

	@Override
	public OfficeCodeChecker initialized() {

		return this;
	};

	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		String officeCode = validationResult.getColumn(1);
		List<String> listRincianKantor = SubmissionFormat.listRincianKantor;

		if (officeCode.equals("000")) {
			validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E50_14_OFFICE_CODE_00, officeCode));
		} else if (!listRincianKantor.contains(officeCode)) {
			validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E50_11_OFFICE_CODE, officeCode));
		}
	}
}
