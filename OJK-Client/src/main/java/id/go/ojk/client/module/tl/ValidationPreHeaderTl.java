package id.go.ojk.client.module.tl;

import java.io.File;

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

public class ValidationPreHeaderTl extends BaseValidationPreHeader {
	private ApplicationContextClient ctx = ApplicationContextClient.getInstance();
	protected ValidFile validFile;
	protected int reportFormGroupCode;

	public ValidationPreHeaderTl(File file, int sumRow, int reportFormGroupCode, SubmissionFormat submissionFormat,
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

	//	0: H01
	//	1: Kode Sektor
	//	2: Sandi LJK
	//	3: YYYY-MM-DD
	//	4: Kode Jenis Laporan
	//	5: Kode Form
	//	6: Kode Status Koreksi
	//	7: No Surat Pengantar
	//	8: No LHPL

	// Validasi jumlah kolom header
	protected boolean validatePart() {
		final int columnLength = 9;
		boolean res = result.getColumnLength() == columnLength;
		if (!res) {
			result.errors.add(new ValidationError(null, ValidationErrorCode.E03_01_COL_NUMBER, columnLength));
			result.stopValidation = true;
		}
		return res;
	}

	// Validasi H1
	protected boolean validatePart0() {
		String part = getPart(0);
		boolean res = "H01".equals(part);
		if (!res) {
			result.errors.add(new ValidationError(null, ValidationErrorCode.E03_02_FLAG_H));
		}
		return res;
	}

	//	Validasi kode sektor
	protected boolean validatePart1() {
		String part = getPart(1);
		String sectorCode = ctx.getService(SetupService.class).getSectorCode();
		boolean res = sectorCode.equals(part);
		if (!res) {
			result.errors.add(new ValidationError(null, ValidationErrorCode.E02_02_SECTOR_CODE, part, sectorCode));
		}
		return res;
	}

	// Validasi kode LJK
	protected boolean validatePart2() {
		String part = getPart(2);
		String memberCode = ctx.getService(SetupService.class).getMemberCode();
		boolean res = memberCode.equals(part);
		if (!res) {
			result.errors.add(new ValidationError(null, ValidationErrorCode.E02_01_ENTITY_CODE));
		}
		return res;
	}

	// Validasi kode YYYY-MM-DDDD
	protected boolean validatePart3() {
		String part = getPart(3);
		String filePeriod = validFile.getPart(4);
		String periodeCode = filePeriod.subSequence(0, 4) + "-" + filePeriod.subSequence(4, 6) + "-" + filePeriod.subSequence(6, 8);
		boolean res = periodeCode.equals(part);
		if (!res) {
			result.errors.add(new ValidationError(null, ValidationErrorCode.E03_09_PERIOD_CODE, part, periodeCode));
		}
		return res;
	}

	// Validasi kode laporan
	protected boolean validatePart4() {
		String part = getPart(4);
		String kodeJenisReport = validFile.getPart(0);
		boolean res = kodeJenisReport.equals(part);
		if (!res) {
			result.errors.add(new ValidationError(null, ValidationErrorCode.E03_10_REPORT_CODE, part, kodeJenisReport));
		}
		return res;
	}

	// Validasi kode form
	protected boolean validatePart5() {
		String part = getPart(5);
		String kodeFormReport = validFile.getPart(1);
		boolean res = kodeFormReport.equals(part);
		if (!res) {
			result.errors.add(new ValidationError(null, ValidationErrorCode.E03_05_FORMCODE, part, kodeFormReport));
		}
		return res;
	}

	// Validasi kode status koreksi
	protected boolean validatePart6() {
		boolean res = true;
		String part = getPart(6);
		String code = "0";

		if (reportFormGroupCode == EReportGroupTl.PELAPORAN_KOREKSI.getMenuCode()) {
			code = "1";
		}

		if (!part.equals(code))
			res = false;

		if (!res)
			result.errors.add(new ValidationError(null, ValidationErrorCode.E03_20_REPORT_FORM_GROUP, code));

		return res;
	}

	// Validasi surat pengantar
	protected boolean validatePart7() {
		boolean isValid = true;
		int maxLen = 50;
		String part = getPart(7);

		if (StringUtils.isBlank(part)) {
			result.errors.add(new ValidationError(null, ValidationErrorCode.E07_01_NO_SURAT_PENGANTAR));
			isValid = false;
		} else if (!part.matches(SimpleValidation.patternNomorSurat.getPattern())) {
			result.errors.add(new ValidationError(null, ValidationErrorCode.E07_05_NO_SURAT_PENGANTAR_PATTERN));
			isValid = false;
		} else if (part.length() > maxLen) {
			result.errors.add(new ValidationError(null, ValidationErrorCode.E07_03_MAX_LENGTH_NO_SURAT_PENGANTAR, String.valueOf(maxLen)));
			isValid = false;
		}

		return isValid;
	}

	// Validasi surat LHPL
	protected boolean validatePart8() {
		boolean isValid = true;
		int maxLen = 50;
		String part = getPart(8);

		if (StringUtils.isBlank(part)) {
			result.errors.add(new ValidationError(null, ValidationErrorCode.E07_02_NO_SURAT_LHPL));
			isValid = false;
		} else if (!part.matches(SimpleValidation.patternNomorSurat.getPattern())) {
			result.errors.add(new ValidationError(null, ValidationErrorCode.E07_06_NO_SURAT_LHPL_PATTERN));
			isValid = false;
		} else if (part.length() > maxLen) {
			result.errors.add(new ValidationError(null, ValidationErrorCode.E07_04_MAX_LENGTH_NO_SURAT_LHPL, String.valueOf(maxLen)));
			isValid = false;
		}

		return isValid;
	}

	protected String getPart(int idx) {
		return result.getColumn(idx);
	}
}
