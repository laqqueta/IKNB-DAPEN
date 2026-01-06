package id.go.ojk.client.model.config.validation.segmen;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("NotZeroFieldValidation")
public class NotZeroFieldValidation extends BaseRowValidation {

	public NotZeroFieldValidation() {
		super();
	}

	public NotZeroFieldValidation(String parameter) {
		super(parameter);
	}

	@Override
	public NotZeroFieldValidation initialized() {
		super.initialized();
		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		List<SubmissionField> fields = submissionFormat.getFields();
		String[] arrSelectField = StringUtils.split(selectField, "|");
		String delimitedField = delimitedField(arrSelectField);
		String[] arrSelectPosCode = StringUtils.split(selectPosCode, "|");
		String posCode = validationResult.getColumn(1);
		for (int i = 0; i < arrSelectPosCode.length; i++) {
			if (posCode.contains(arrSelectPosCode[i])) {
				int notZeroCount = 0;
				for (String field : arrSelectField) {
					int idxField = Integer.parseInt(field);
					String fieldValueString = validationResult.getColumn(idxField);
					BigDecimal value = toBigDecimal(fieldValueString, 0);
					if (value.compareTo(BigDecimal.ZERO) != 0) {
						notZeroCount++;
						if (notZeroCount > 1) {
							SubmissionField submissionField = fields.get(idxField);
							validationResult.errors.add(new ValidationError(submissionField,
									ValidationErrorCode.E11_10_NOT_ZERO, delimitedField));
							return;
						}
					}
				}
			}
		}
	}

	private String delimitedField(String[] arrSelectField) {
		StringBuilder res = new StringBuilder();
		if (arrSelectField != null) {
			int size = arrSelectField.length;
			for (int i = 0; i < size; i++) {
				res = res.append(Integer.parseInt(arrSelectField[i]) + 1) ;
				if ((i + 1) < size) {
					res = res.append(",");
				}
			}
		}
		return res.toString();
	}
}