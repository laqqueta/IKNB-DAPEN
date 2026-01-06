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

@XStreamAlias("ReferenceConditionValidation2")
public class ReferenceConditionValidation2 extends MapParamFieldValidation {
	private String fieldComparator;
	private String valueComparator;
	private int referenceNumber;

	public ReferenceConditionValidation2(String parameter) {
		setParameter(parameter);
	}
	
	public ReferenceConditionValidation2() {
		super();
	}

	public ReferenceConditionValidation2 initialized() {
		fieldComparator = getStringParameter("fieldComparator");
		valueComparator = getStringParameter("valueComparator");
		referenceNumber = getIntParameter("referenceNumber");
		return this;
	}
	
	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		ReferenceService referenceService = appCtx.getService(ReferenceService.class);
		String realComparatorValue = validationResult.getColumn(Integer.valueOf(fieldComparator));
		List<String> arrExpectedComparatorValue = Arrays.asList(StringUtils.split(valueComparator, "|"));
		if (arrExpectedComparatorValue.contains(realComparatorValue)) {
			Map<String, String> references = referenceService.getReference(referenceNumber);
			String realValue = validationResult.getColumn(field.getNumber());
			if (!references.containsKey(realValue)) {
				validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E12_01_REFERENCE, 
						referenceService.getReferenceDescription(referenceNumber)));
			}
		}
	}
}
