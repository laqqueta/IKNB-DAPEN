package id.go.ojk.client.model.config.validation.segmen;

import java.util.List;
import java.util.Map;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import id.go.ojk.lib.client.service.context.ApplicationContext;

@XStreamAlias("referenceConditionValidation")
public class ReferenceConditionValidation extends BaseRowValidation {
	private int referenceNumber;
	private String parentPosCode;
	@XStreamOmitField
	private ReferenceService referenceService;

	public ReferenceConditionValidation() {
		super();
	}

	public ReferenceConditionValidation(String parameter) {
		super(parameter);
	}

	@Override
	public ReferenceConditionValidation initialized() {
		super.initialized();
		referenceNumber = getIntParameter("referenceNumber");
		parentPosCode = getStringParameter("parentPosCode");
		return this;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext appCtx) {
		super.setApplicationContext(appCtx);
		if (appCtx != null) {
			referenceService = appCtx.getService(ReferenceService.class);
		}
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		List<SubmissionField> fields = submissionFormat.getFields();
		String[] arrSelectField = selectField.split("[|]");
		String posCode = validationResult.getColumn(1);
		Map<String, String> referenceMap = referenceService.getReference(referenceNumber);
		for (String field : arrSelectField) {
			SubmissionField submissionField = fields.get(Integer.parseInt(field));
			if (referenceMap != null) {
				String fieldValueString = validationResult.getColumn(Integer.parseInt(field)).replaceAll("\\s+", "");
				if (posCode.contains(selectPosCode)) {
					if (!fieldValueString.equals("")) {
						String parentValue = SubmissionFormat.getMapPosValue(parentPosCode, field);
						if (!referenceMap.containsKey(fieldValueString) || !referenceMap.get(fieldValueString).equals(parentValue)) {
							validationResult.errors.add(new ValidationError(submissionField, ValidationErrorCode.E40_00_RELATION, parentValue));
						}
					}
				}
			} else {
				validationResult.errors.add(new ValidationError(submissionField, ValidationErrorCode.E12_00_REFERENCE, referenceNumber));
			}
		}
	}
}