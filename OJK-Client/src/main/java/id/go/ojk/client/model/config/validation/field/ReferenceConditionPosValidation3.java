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
public class ReferenceConditionPosValidation3 extends MapParamFieldValidation {
	private String refPosCode;
	private String fieldParent;
	private int referenceNumber;

	public ReferenceConditionPosValidation3(String parameter) {
		setParameter(parameter);
	}
	
	public ReferenceConditionPosValidation3() {
		super();
	}

	public ReferenceConditionPosValidation3 initialized() {
		refPosCode = getStringParameter("refPosCode");
		fieldParent = getStringParameter("fieldParent");
		referenceNumber = getIntParameter("referenceNumber");
		return this;
	}
	
	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		if (refPosCode.contains(validationResult.getColumn((1)))) {
			ReferenceService referenceService = appCtx.getService(ReferenceService.class);
			String parentValue = validationResult.getColumn(Integer.valueOf(fieldParent));
			String realValue = validationResult.getColumn(field.getNumber());
			Map<String, String> references = referenceService.getReference(referenceNumber);
			if (references.containsKey(realValue)) {
				String expectedValue = references.get(realValue);
				List<String> listExpectedValue = Arrays.asList(StringUtils.split(expectedValue, "|"));
				if (!listExpectedValue.contains(parentValue)) {
					validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E40_00_RELATION, parentValue));
				}
			}
		}
	}
}
