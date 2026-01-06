package id.go.ojk.client.model.config.validation.field;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("uniqueChecker")
public class UniqueChecker extends MapParamFieldValidation {
	private String selectPosCode;

	public UniqueChecker() {

	}

	public UniqueChecker(String parameter) {
		setParameter(parameter);
	}

	@Override
	public UniqueChecker initialized() {
		selectPosCode = getStringParameter("selectPosCode");
		return this;
	};

	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		String value = validationResult.getColumn(field.getNumber());
		if (StringUtils.isNotEmpty(value) && isContainsSelectedPosCode(value)) {
			validateUnique(field, validationResult, value);
		}
	}
	
	private void validateUnique(SubmissionField field, ValidationResult validationResult, String value) {
		List<String> checkUnique = SubmissionFormat.checkUniqueCustom;
		if (checkUnique.contains(value)) {
			validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E14_00_UNIQUE));
		} else {
			SubmissionFormat.checkUniqueCustom.add(value);
		}
	}
	
	private boolean isContainsSelectedPosCode(String value) {
		boolean res = false;
		if (StringUtils.isEmpty(selectPosCode)) {
			res = true;
		} else {
			String[] arr = StringUtils.split(selectPosCode, "|");
			if (arr != null) {
				for (int i = 0; i < arr.length; i++) {
					if (value.equals(arr[i])) {
						res = true;
						break;
					}
				}
			}
		}
		return res;
	}
}
