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
public class DuplicateWithConditionValidation extends MapParamFieldValidation {
	private Integer fieldCondition;
	private String trueConditionValue;
	private String selectPosCode;

	public DuplicateWithConditionValidation() {

	}

	public DuplicateWithConditionValidation(String parameter) {
		setParameter(parameter);
	}

	@Override
	public DuplicateWithConditionValidation initialized() {
		fieldCondition = getIntParameter("fieldCondition");
		trueConditionValue = getStringParameter("trueConditionValue");
		selectPosCode = getStringParameter("selectPosCode");
		return this;
	};

	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		String[] trueConditionValueSplit = StringUtils.split(trueConditionValue, "|");
		String fieldConditionValue = validationResult.getColumn(fieldCondition);
		String value = validationResult.getColumn(field.getNumber());
		if (StringUtils.isNotEmpty(value) &&  isContainSelectedPosCode(value) && 
				compareConditionValue(trueConditionValueSplit, fieldConditionValue)) {
			validateUnique(field, validationResult, value);
		}
	}

	private boolean compareConditionValue(String[] trueConditionValueSplit, String conditionValue) {
		boolean res = false;
		if (trueConditionValueSplit != null) {
			for (int i = 0; i < trueConditionValueSplit.length; i++) {
				if (trueConditionValueSplit[i].equals(conditionValue)) {
					res = true;
					break;
				}
			}
		}
		return res;
	}
	
	private void validateUnique(SubmissionField field, ValidationResult validationResult, String value) {
		List<String> checkUnique = SubmissionFormat.checkUniqueCustom;
		if (checkUnique.contains(value)) {
			validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E14_00_UNIQUE));
		} else {
			SubmissionFormat.checkUniqueCustom.add(value);
		}
	}
	
	private boolean isContainSelectedPosCode(String value) {
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
