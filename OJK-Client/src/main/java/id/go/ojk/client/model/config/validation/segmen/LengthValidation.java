package id.go.ojk.client.model.config.validation.segmen;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.RequiredCondition;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("LengthValidation")
public class LengthValidation extends BaseRowValidation {
	private int minLength;
	private int maxLength;

	public LengthValidation() {
		super();
	}

	public LengthValidation(String parameter) {
		super(parameter);
	}

	@XStreamOmitField
	private ReferenceService referenceService = null;

	@Override
	public LengthValidation initialized() {
		super.initialized();
		minLength = getIntParameter("minLength");
		maxLength = getIntParameter("maxLength");
		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		List<SubmissionField> fields = submissionFormat.getFields();
		String[] arrSelectField = StringUtils.split(selectField, "|");
		String posCode = validationResult.getColumn(1);
		if (selectPosCode.contains(posCode)) {
			for (String field : arrSelectField) {
				String fieldValueString = validationResult.getColumn(Integer.parseInt(field));
				SubmissionField submissionField = fields.get(Integer.parseInt(field));
				if (!isMustEmpty(submissionFormat, validationResult, submissionField)) {
					if (fieldValueString.length() < minLength) {
						validationResult.errors.add(new ValidationError(submissionField, ValidationErrorCode.E11_01_MIN_LENGTH, minLength));
					}
					if (fieldValueString.length() > maxLength) {
						validationResult.errors.add(new ValidationError(submissionField, ValidationErrorCode.E11_02_MAX_LENGTH, maxLength));
					}
				}
			}
		}
	}

	private boolean isMustEmpty(SubmissionFormat submissionFormat, ValidationResult validationResult, SubmissionField submissionField) {
		boolean res = false;
		SimpleValidation simpleValidation = submissionField.getSimpleValidation();
		RequiredCondition requiredCondition = simpleValidation.getRequiredCondition();
		if (requiredCondition != null) {
			if (requiredCondition.equals(RequiredCondition.C)) {
				ConditionalRequired conditionalRequired = simpleValidation.getConditionalRequired();
				if (conditionalRequired != null) {
					Tupple2<RequiredCondition, String> tupple = conditionalRequired.analizeRequiredCondition(submissionFormat, validationResult);
					if (tupple != null) {
						res = tupple.getA().equals(RequiredCondition.N);
					}
				}
			} else {
				res = requiredCondition.equals(RequiredCondition.N);
			}
		}
		return res;
	}
}