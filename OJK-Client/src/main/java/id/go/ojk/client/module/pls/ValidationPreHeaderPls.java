package id.go.ojk.client.module.pls;

import java.io.File;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.client.model.ValidFile;
import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.SetupService;
import id.go.ojk.client.service.context.ApplicationContextClient;
import id.go.ojk.client.validation.BaseValidationPreHeader;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import id.go.ojk.lib.client.util.CrLfType;

public class ValidationPreHeaderPls extends BaseValidationPreHeader {
	private ApplicationContextClient ctx = ApplicationContextClient.getInstance();
	protected ValidFile validFile;
	protected int reportFormGroupCode;

	public ValidationPreHeaderPls(File file, int sumRow, int reportFormGroupCode, SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		super(sumRow, submissionFormat, validationResult);
		this.validFile = new ValidFile(file);
		this.reportFormGroupCode = reportFormGroupCode;
	}

	@Override
	public boolean validate() {
		boolean res = false;
		validatePart0();
		res = validatePart();
		if (res) {
			validatePart1();
			validatePart2();
			validatePart3();
			validatePart4();
			validatePart5();
			validatePart6();
			validatePart7();
			validatePart8();
		}
		sumRow(result);
		return res;
	}

	protected boolean validatePart() {
		boolean res = result.getColumnLength() == 8;
		if (!res) {
			result.errors.add(new ValidationError(null, ValidationErrorCode.E03_01_COL_NUMBER, 8));
			result.stopValidation = true;
		}
		return res;
	}

	protected boolean validatePart0() {
		String part = getPart(0);
		boolean res = "H01".equals(part);
		if (!res) {
			result.errors.add(new ValidationError(null, ValidationErrorCode.E03_02_FLAG_H));
		}
		return res;
	}

	protected boolean validatePart1() {
		String part = getPart(1);
		String sectorCode = ctx.getService(SetupService.class).getSectorCode();
		boolean res = sectorCode.equals(part);
		if (!res) {
			result.errors.add(new ValidationError(null, ValidationErrorCode.E02_02_SECTOR_CODE, part, sectorCode));
		}
		return res;
	}

	protected boolean validatePart2() {
		String part = getPart(2);
		String memberCode = ctx.getService(SetupService.class).getMemberCode();
		boolean res = memberCode.equals(part);
		if (!res) {
			result.errors.add(new ValidationError(null, ValidationErrorCode.E02_01_ENTITY_CODE));
		}
		return res;
	}

	protected boolean validatePart3() {
		String part = getPart(3);
		String filePeriod = validFile.getPart(4);
		String periodeCode = filePeriod.subSequence(0, 4) + "-" + filePeriod.subSequence(4, 6) + "-"
				+ filePeriod.subSequence(6, 8);
		boolean res = periodeCode.equals(part);
		if (!res) {
			result.errors.add(new ValidationError(null, ValidationErrorCode.E03_09_PERIOD_CODE, part, periodeCode));
		}
		return res;
	}

	protected boolean validatePart4() {
		String part = getPart(4);
		String kodeJenisReport = validFile.getPart(0);
		boolean res = kodeJenisReport.equals(part);
		if (!res) {
			result.errors.add(new ValidationError(null, ValidationErrorCode.E03_10_REPORT_CODE, part, kodeJenisReport));
		}
		return res;
	}

	protected boolean validatePart5() {
		String part = getPart(5);
		String kodeFormReport = validFile.getPart(1);
		boolean res = kodeFormReport.equals(part);
		if (!res) {
			result.errors.add(new ValidationError(null, ValidationErrorCode.E03_05_FORMCODE, part, kodeFormReport));
		}
		return res;
	}

	protected boolean validatePart6() {
		String part = getPart(6);
		boolean res = false;
		String code = String.valueOf(EReportGroupPls.getRevisionCodeByCode(reportFormGroupCode));
		res = part.equals(code);
		if (!res) {
			result.errors.add(new ValidationError(null, ValidationErrorCode.E03_20_REPORT_FORM_GROUP, code));
		}
		return res;
	}

	protected boolean validatePart7() {
		final int maxLen = 50;
		String part = getPart(7);
		boolean res = true;
		if( StringUtils.isEmpty(part)) {
      List<String> noSurat = SubmissionFormat.noSurat;
      noSurat.add(part);
      if (!part.equals(noSurat.get(0))) {
        result.errors.add(new ValidationError(null, ValidationErrorCode.E03_16_NO_SURAT_EQUAL, part, noSurat.get(0)));
        return false;
      }
		}
		if (reportFormGroupCode == 0 && StringUtils.isNotEmpty(part)) {
			if (!part.matches(SimpleValidation.patternNomorSurat.getPattern())) {
				result.errors.add(new ValidationError(null, ValidationErrorCode.E03_18_NO_SURAT_PATTERN));
				return false;
			} else if (part.length() > maxLen) {
				result.errors.add(new ValidationError(null, ValidationErrorCode.E03_26_MAX_LENGTH_NO_SURAT,
						String.valueOf(maxLen)));
				return false;
			} else {
				List<String> noSurat = SubmissionFormat.noSurat;
				noSurat.add(part);
				if (!part.equals(noSurat.get(0))) {
					result.errors.add(new ValidationError(null, ValidationErrorCode.E03_16_NO_SURAT_EQUAL, part,
							noSurat.get(0)));
					return false;
				}
			}
			return res;
		}
		if (reportFormGroupCode == 1) {
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

	protected boolean validatePart8() {
	  if (CrLfType.crLf != result.crLfType) {
      result.errors.add(new ValidationError(null, ValidationErrorCode.E04_01_CRLF));
      result.stopValidation = true;
      return false;
    }
	  return true;
	}

	protected String getPart(int idx) {
		return result.getColumnLength() - 1 >= idx ? result.getColumn(idx) : ""; 
	}
}
