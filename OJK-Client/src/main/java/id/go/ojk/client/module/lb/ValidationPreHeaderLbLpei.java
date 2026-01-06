package id.go.ojk.client.module.lb;

import java.io.File;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

public class ValidationPreHeaderLbLpei extends ValidationPreHeaderLb {

	public ValidationPreHeaderLbLpei(File file, int sumRow, int reportFormGroupCode, SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		super(file, sumRow, reportFormGroupCode, submissionFormat, validationResult);
	}

	@Override
	protected boolean validatePart7() {
		final int maxLen = 50;
		String part = getPart(7);
		boolean res = true;
		if (reportFormGroupCode == 3 || reportFormGroupCode == 5) {
			if (StringUtils.isBlank(part)) {
				result.errors.add(new ValidationError(null, ValidationErrorCode.E03_15_NO_SURAT));
				res = false;
			} else if (!part.matches(SimpleValidation.patternNomorSurat.getPattern())) {
				result.errors.add(new ValidationError(null, ValidationErrorCode.E03_18_NO_SURAT_PATTERN));
				res = false;
			} else if (part.length() > maxLen) {
				result.errors.add(new ValidationError(null, ValidationErrorCode.E03_26_MAX_LENGTH_NO_SURAT,
						String.valueOf(maxLen)));
				res = false;
			} else {
				List<String> noSurat = SubmissionFormat.noSurat;
				noSurat.add(part);
				if (!part.equals(noSurat.get(0))) {
					result.errors.add(
							new ValidationError(null, ValidationErrorCode.E03_16_NO_SURAT_EQUAL, part, noSurat.get(0)));
					res = false;
				}
			}
		} else {
			if (StringUtils.isNotEmpty(part)) {
				result.errors.add(new ValidationError(null, ValidationErrorCode.E03_17_NO_SURAT_EMPTY));
				res = false;
			}
		}
		return res;
	}

}
