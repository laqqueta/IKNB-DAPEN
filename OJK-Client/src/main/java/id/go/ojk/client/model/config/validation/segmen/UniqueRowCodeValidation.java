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

@XStreamAlias("UniqueRowCodeValidation")
public class UniqueRowCodeValidation extends MapParamSegmentValidation {
	private String selectPosCode;

	public UniqueRowCodeValidation() {
		super();
	}

	public UniqueRowCodeValidation(String parameter) {
		super(parameter);
	}

	@Override
	public UniqueRowCodeValidation initialized() {
		selectPosCode = getStringParameter("selectPosCode");
		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		List<SubmissionField> listSubmissionField = submissionFormat.getFields();
		String rowCode = validationResult.getColumn(1);
		if (checkSelectPosCode(rowCode)) {
			ValueByRowCode instance = ValueByRowCode.getInstance();
			if (!instance.checkPut(rowCode, validationResult.lineNumber, 1, rowCode)) {
				validationResult.errors.add(new ValidationError(listSubmissionField.get(1),
						ValidationErrorCode.E14_02_UNIQUE_POS_NOT_COMBINE, rowCode));
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