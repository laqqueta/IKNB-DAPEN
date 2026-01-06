package id.go.ojk.client.model.config.validation.segmen;

import java.util.List;
import java.util.Map;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("referenceValidation")
public class ReferenceValidation extends BaseRowValidation {
	private int referenceNumber;

	public ReferenceValidation() {
		super();
	}

	public ReferenceValidation(String parameter) {
		super(parameter);
	}

	@Override
	public ReferenceValidation initialized() {
		super.initialized();
		referenceNumber = getIntParameter("referenceNumber");
		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		ReferenceService referenceService = appCtx.getService(ReferenceService.class);
		List<SubmissionField> fields = submissionFormat.getFields();
		String[] arrSelectField = selectField.split("[|]");
		String[] arrSelectPosCode = selectPosCode.split("[|]");
		String posCode = validationResult.getColumn(1);
		Map<String, String> referenceMap = referenceService.getReference(referenceNumber);
		for (String field : arrSelectField) {
			SubmissionField submissionField = fields.get(Integer.parseInt(field));
			for (int i = 0; i < arrSelectPosCode.length; i++) {
				if (posCode.contains(arrSelectPosCode[i])) {
					if (referenceMap != null) {
						String fieldValueString = validationResult.getColumn(Integer.parseInt(field)).replaceAll("\\s+", "");
						if (!fieldValueString.equals("") && (!referenceMap.containsKey(fieldValueString))) {
							validationResult.errors.add(new ValidationError(submissionField, ValidationErrorCode.E12_01_REFERENCE, 
									referenceService.getReferenceDescription(referenceNumber)));
						}
					} else {
						validationResult.errors.add(new ValidationError(submissionField, ValidationErrorCode.E12_00_REFERENCE, 
								referenceService.getReferenceDescription(referenceNumber)));
					}
				}
			}
		}
	}
}