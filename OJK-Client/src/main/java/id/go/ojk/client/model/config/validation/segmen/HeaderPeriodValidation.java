package id.go.ojk.client.model.config.validation.segmen;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("PeriodeYearValidation")
public class HeaderPeriodValidation extends BaseRowValidation {
	
	public HeaderPeriodValidation() {
		super();
	}
	
	public HeaderPeriodValidation(String parameter) {
		super(parameter);
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		List<SubmissionField> fields = submissionFormat.getFields();
		String[] arrSelectField = selectField.split("[|]");
		String[] arrSelectPosCode = selectPosCode.split("[|]");
		String posCode = validationResult.getColumn(1);
		String period = getPeriod();

		for (String field : arrSelectField) {
			String fieldValueString = validationResult.getColumn(Integer.parseInt(field));
			for (int i = 0; i < arrSelectPosCode.length; i++) {
				if (posCode.contains(arrSelectPosCode[i])) {
					if (!fieldValueString.equals("")) {
						validate(period, fieldValueString, fields.get(Integer.parseInt(field)), validationResult);
					}
				}
			}
		}
	}
	
	protected boolean validate(String period, String value, SubmissionField field, ValidationResult validationResult) {
		boolean res = true;
		if (!value.matches(period)) {
			validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E50_10_FORMULA2, period));
			res = false;
		}
		return res;
	}

	protected String getPeriod() {
		String period = SubmissionFormat.getHeader(3);
		return StringUtils.replace(period, "-", "");
	}
}