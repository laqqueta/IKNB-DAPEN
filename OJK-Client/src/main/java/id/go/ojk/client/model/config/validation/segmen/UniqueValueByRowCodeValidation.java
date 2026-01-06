package id.go.ojk.client.model.config.validation.segmen;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.instance.ValueByRowCode;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("UniqueValueByRowCodeValidation")
public class UniqueValueByRowCodeValidation extends BaseRowValidation {

	public UniqueValueByRowCodeValidation() {
		super();
	}

	public UniqueValueByRowCodeValidation(String parameter) {
		super(parameter);
	}

	@Override
	public UniqueValueByRowCodeValidation initialized() {
		super.initialized();
		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		List<SubmissionField> listSubmissionField = submissionFormat.getFields();
		String rowCode = validationResult.getColumn(1);
		if (checkSelectPosCode(rowCode)) {
			String[] arrSelectField = StringUtils.split(selectField, "|");
			for (int i = 0; i < arrSelectField.length; i++) {
				String fieldNumber = arrSelectField[i];
				int idxField = Integer.parseInt(fieldNumber);
				String realFieldValue = validationResult.getColumn(idxField);
				ValueByRowCode instance = ValueByRowCode.getInstance();
				if (instance.checkPut(rowCode, validationResult.lineNumber, Integer.valueOf(fieldNumber), realFieldValue)) {
					validationResult.errors.add(new ValidationError(listSubmissionField.get(idxField),
							ValidationErrorCode.E14_04_SEGMENT_VALUE_UNIQUE, realFieldValue, rowCode));
				}
			}
		}
	}

	private boolean checkSelectPosCode(String value) {
		boolean res = false;
		if (StringUtils.isEmpty(selectPosCode)) {
			res = true;
		} else {
			List<String> list = Arrays.asList(StringUtils.split(selectPosCode, "|"));
			res = list.contains(value);
		}
		return res;
	}
}