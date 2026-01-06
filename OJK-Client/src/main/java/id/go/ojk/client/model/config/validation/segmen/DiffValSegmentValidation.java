package id.go.ojk.client.model.config.validation.segmen;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.client.service.validation.ValidationUtil;
import id.go.ojk.lib.client.CollectionUtil;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import id.go.ojk.lib.client.service.context.ApplicationContext;

@XStreamAlias("diffValSegmentValidation")
public class DiffValSegmentValidation extends MapParamSegmentValidation {
	
	private String fieldGroup;	
	private String msgError;

	public DiffValSegmentValidation() {
		super();
	}

	public DiffValSegmentValidation(String parameter) {
		super(parameter);
	}

	@XStreamOmitField
	private ReferenceService referenceService = null;

	@Override
	public void setApplicationContext(ApplicationContext appCtx) {
		this.appCtx = appCtx;
		if (appCtx != null) {
			this.referenceService = appCtx.getService(ReferenceService.class);
		}
	}

	@Override
	public DiffValSegmentValidation initialized() {	
		this.fieldGroup = getStringParameter("fieldGroup");	
		this.msgError = getStringParameter("msgError");
		
		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
		List<SubmissionField> fields = submissionFormat.getFields();
		String[] fieldGroupSplit = fieldGroup.split("[|]");		
		
		for (int i = 0; i < fieldGroupSplit.length; i++) {
			String[] diffFields = fieldGroupSplit[i].split("[-]");
			validateDiff(validationResult, fields, Integer.parseInt(diffFields[2]), Integer.parseInt(diffFields[0]), Integer.parseInt(diffFields[1]));			
		}		
	}

	private void validateDiff(ValidationResult validationResult, List<SubmissionField> fields, int fieldC, int fieldA, int fieldB) {
		SubmissionField diffField = fields.get(fieldC);
		Double result = null;

		Double valC = ValidationUtil.validateDouble(diffField, validationResult, false);
		Double valA = ValidationUtil.validateDouble(fields.get(fieldA), validationResult, false);
		Double valB = ValidationUtil.validateDouble(fields.get(fieldB), validationResult, false);
	
		if (CollectionUtil.isAllNotNull(valC, valA, valB)){
			valC = BigDecimal.valueOf(valC).setScale(2, RoundingMode.HALF_UP).doubleValue();
			valA = BigDecimal.valueOf(valA).setScale(2, RoundingMode.HALF_UP).doubleValue();
			valB = BigDecimal.valueOf(valB).setScale(2, RoundingMode.HALF_UP).doubleValue();
			
			result = BigDecimal.valueOf(valA - valB).setScale(2, RoundingMode.HALF_UP).doubleValue();			
			if (!valC.equals(result)) {
				validationResult.errors.add(new ValidationError(diffField, ValidationErrorCode.E50_08_DIFF_VALUE, valC, msgError));
			}
		}
	}
}