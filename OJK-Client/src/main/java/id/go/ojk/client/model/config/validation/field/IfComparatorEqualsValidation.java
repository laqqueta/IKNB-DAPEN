package id.go.ojk.client.model.config.validation.field;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@XStreamAlias("IfComparatorEqualsValidation")
public class IfComparatorEqualsValidation extends MapParamFieldValidation {
	private int fieldComparator;
	private String comparatorValue;
	private String trueValue;

	public IfComparatorEqualsValidation(String parameter) {
		setParameter(parameter);
	}

	@Override
	public IfComparatorEqualsValidation initialized() {
		fieldComparator = getIntParameter("fieldComparator");
		comparatorValue = getStringParameter("comparatorValue");
		trueValue = getStringParameter("trueValue");
		return this;
	};

	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		List<String> listTrueConditionValue = Arrays.asList(StringUtils.split(comparatorValue, "|"));
		String fieldConditionValue = validationResult.getColumn(fieldComparator);
		if (listTrueConditionValue.contains(fieldConditionValue)) {
			List<String> arrFalseValue = Arrays.asList(StringUtils.split(trueValue, "|"));
			String fieldValue = validationResult.getColumn(field.getNumber());
			if (!arrFalseValue.contains(fieldValue)) {
				validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E50_15_COLUMNCONDITION,
						trueValue.replace("|", " atau "), fieldComparator + 1, 
						fieldConditionValue.replace("|", " atau ")));
			}
		}
	}
}
