package id.go.ojk.client.module.apu;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.client.constant.ESector;
import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.module.ValidationPreHeader;
import id.go.ojk.client.service.SetupService;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

public class ValidationPreHeaderApu extends ValidationPreHeader {

	public ValidationPreHeaderApu(File file, int sumRow, int reportFormGroupCode, SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		super(file, sumRow, reportFormGroupCode, submissionFormat, validationResult);
	}
	
	@Override
	protected boolean validatePart() {
		int colCount = ((reportFormGroupCode == 1 || reportFormGroupCode == 2) ? 7 : 8);
		boolean res = result.getColumnLength() == colCount;
		if (!res) {
			result.errors.add(new ValidationError(null, ValidationErrorCode.E03_01_COL_NUMBER, colCount));
			result.stopValidation = true;
		}
		return res;
	}

	@Override
	protected boolean validatePart6() {
		String part = getPart(6);
		boolean res = false;
		List<String> codes = new ArrayList<>();
		switch (reportFormGroupCode) {
		case 2:
		case 4:
		case 6:
		case 8:
			codes.add("1");
			break;
		case 9:
			codes.add("2");
			break;
		default:
			codes.add("0");
			break;
		}
		res = codes.contains(part);
		if (!res) {
			result.errors.add(new ValidationError(null, ValidationErrorCode.E03_20_REPORT_FORM_GROUP, StringUtils.join(codes, " atau ")));
		}
		return res;
	}

	@Override
	protected boolean validatePart7() {
		int maxLen = 25;
		String memberCode = ctx.getService(SetupService.class).getSectorCode();
		if (ESector.isFintech(memberCode)) {
			maxLen = 50;
		}
		String part = getPart(7);
		boolean res = true;
		if (reportFormGroupCode == 4 || reportFormGroupCode == 6 || reportFormGroupCode == 9) {
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
