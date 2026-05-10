package id.go.ojk.client.model.config.validation.segmen;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("PosMinSizeValidation")
public class PosMinDataCountValidation extends BaseRowValidation {
	private int min;

	public PosMinDataCountValidation() {
		super();
	}

	@Override
	public BaseRowValidation initialized() {
		min = getIntParameter("min");
		return super.initialized();
	}

	public PosMinDataCountValidation(String parameter) {
		super(parameter);
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat,
			ValidationResult validationResult) {

		String currentRowCode = validationResult.getColumn(1);
		if (!selectPosCode.contains(currentRowCode)) return;

		long rowCount = SubmissionFormat.mapPosValue
				.entrySet()
				.stream()
				.filter(e -> e.getKey().contains(currentRowCode))
				.count();

		if (rowCount < min) {
			validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E03_33_ROW_COUNT,
					currentRowCode, min));
		}
	}
}