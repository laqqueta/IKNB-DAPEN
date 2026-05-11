package id.go.ojk.client.model.config.validation.segmen;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import org.apache.commons.lang3.StringUtils;

@XStreamAlias("PosMinSizeValidation")
public class PosEmptyValidation extends BaseRowValidation {

	public PosEmptyValidation() {
		super();
	}

	@Override
	public BaseRowValidation initialized() {
		return super.initialized();
	}

	public PosEmptyValidation(String parameter) {
		super(parameter);
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult){
		String currentRowCode = validationResult.getColumn(1);
		if (!selectPosCode.contains(currentRowCode)) return;

		String[] arrSelectField = StringUtils.split(selectField, "|");

		for (String field : arrSelectField) {
			String fieldValue = validationResult.getColumn(Integer.parseInt(field));

			if (!fieldValue.isEmpty()) {

			}
		}
	}
}