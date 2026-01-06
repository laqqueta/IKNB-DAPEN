package id.go.ojk.client.model.config.validation.segmen;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("UniqueValidation")
public class UniqueValidation extends BaseRowValidation {
	private String uniqueValue;
	private String conditionField;
	private String conditionFieldValue;

	public UniqueValidation() {
		super();
	}

	public UniqueValidation(String parameter) {
		super(parameter);
	}

	@Override
	public UniqueValidation initialized() {
		super.initialized();
		uniqueValue = getStringParameter("uniqueValue");
		conditionField = getStringParameter("conditionField");
		conditionFieldValue = getStringParameter("conditionFieldValue");
		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		List<SubmissionField> listSubmissionField = submissionFormat.getFields();
		String rowCode = validationResult.getColumn(1);
		if (checkSelectPosCode(rowCode)) {
			if (checkConditionField(validationResult)) {
				String[] arrSelectField = StringUtils.split(selectField, "|");
				String[] arrUniqueValue = StringUtils.split(uniqueValue, "|");
				for (int i = 0; i < arrSelectField.length; i++) {
					String fieldNumber = arrSelectField[i];
					int idxField = Integer.parseInt(fieldNumber);
					String uniqueFieldValue = getString(i, arrUniqueValue, "");
					String realFieldValue = validationResult.getColumn(idxField);
					if (realFieldValue.equals(uniqueFieldValue) && !isUnique(validationResult.lineNumber, fieldNumber, uniqueFieldValue)) {
						validationResult.errors.add(new ValidationError(listSubmissionField.get(idxField),
								ValidationErrorCode.E14_03_UNIQUE, genCauseMessage()));
					}
				}
			}
		}
	}
	
	private String genCauseMessage() {
		String colNumber = String.valueOf(Integer.parseInt(conditionField) + 1);
		return "kolom " + colNumber  + " = " + conditionFieldValue;
	}

	private boolean checkConditionField(ValidationResult validationResult) {
		boolean res = false;
		if (StringUtils.isEmpty(conditionField)) {
			res = true;
		} else {
			String realConditionFieldValue = validationResult.getColumn(Integer.parseInt(conditionField));
			res = realConditionFieldValue.equals(conditionFieldValue);
		}
		return res;
	}

	private boolean isUnique(int idxRow, String fieldNumber, String uniqueFieldValue) {
		Map<String, Map<String, String>> mapPosValue = SubmissionFormat.mapPosValue;
		Iterator<Entry<String, Map<String, String>>> iterator = mapPosValue.entrySet().iterator();
		int count = 0;
		while (iterator.hasNext()) {
			Entry<String, Map<String, String>> entry = iterator.next();
			String key = entry.getKey();
			int idxOf = key.indexOf("-");
			String idx = idxOf > -1 ? key.substring(idxOf + 1) : "0";
			int idxLine = Integer.parseInt(idx);
			Map<String, String> value = entry.getValue();
			String savedValue = value.get(fieldNumber);
			String savedConditionValue = value.get(conditionField);
			if (StringUtils.equals(savedValue, uniqueFieldValue) && StringUtils.equals(savedConditionValue, conditionFieldValue) 
					&& idxLine < idxRow) {
				count++;
			}
		}
		return count < 1;
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