package id.go.ojk.client.model.config.validation.field;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.UtilValidation;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
@XStreamAlias("IfComparatorEqualsValidation2")
public class IfComparatorEqualsValidation2 extends MapParamFieldValidation {
	private int fieldComparator;
	private String comparatorValue;
	private String trueValue;

	public IfComparatorEqualsValidation2(String parameter) {
		setParameter(parameter);
	}

	@Override
	public IfComparatorEqualsValidation2 initialized() {
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
			String fieldValue = validationResult.getColumn(field.getNumber());
			if (UtilValidation.toBigDecimal(trueValue).compareTo(UtilValidation.toBigDecimal(fieldValue)) >= 0) {
				log.error("{}>{}?{}", parameter, fieldConditionValue, fieldValue);
				validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E50_19_COLUMNCONDITION,
						trueValue.replace("|", " atau "), fieldComparator + 1, 
						fieldConditionValue.replace("|", " atau ")));
			}
		}
	}
}
