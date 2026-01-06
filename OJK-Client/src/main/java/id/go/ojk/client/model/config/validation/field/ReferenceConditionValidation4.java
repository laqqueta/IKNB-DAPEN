package id.go.ojk.client.model.config.validation.field;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("ReferenceConditionValidation")
public class ReferenceConditionValidation4 extends MapParamFieldValidation {
	private String fieldComparator;
	private int referenceNumber;
	private String defaultValue;

	public ReferenceConditionValidation4(String parameter) {
		setParameter(parameter);
	}
	
	public ReferenceConditionValidation4() {
		super();
	}

	public ReferenceConditionValidation4 initialized() {
		fieldComparator = getStringParameter("fieldComparator");
		referenceNumber = getIntParameter("referenceNumber");
		defaultValue = getStringParameter("defaultValue");
		return this;
	}
	
	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		ReferenceService referenceService = appCtx.getService(ReferenceService.class);
		String comparatorValue = validationResult.getColumn(Integer.valueOf(fieldComparator));
		Map<String, String> references = referenceService.getReference(referenceNumber);
		String expectedValue = references.get(comparatorValue);
		if (StringUtils.isEmpty(expectedValue)) {
			expectedValue = defaultValue;
			validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E50_16_COLUMNCONDITION2, defaultValue));
		} else {
			List<String> listExpectedValue = Arrays.asList(StringUtils.split(expectedValue, "|"));
			String realValue = validationResult.getColumn(field.getNumber());
			if (StringUtils.isEmpty(realValue) || !listExpectedValue.contains(realValue)) {
				validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E50_15_COLUMNCONDITION,
						StringUtils.replace(expectedValue, "|", " atau "), Integer.valueOf(fieldComparator) + 1, comparatorValue));
			}
		}
	}
}
