package id.go.ojk.client.module.sa;

import java.io.File;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

public class ValidationPreHeaderSaPpi extends ValidationPreHeaderSa {

	public ValidationPreHeaderSaPpi(File file, int sumRow, int reportFormGroupCode, SubmissionFormat submissionFormat, 
			ValidationResult validationResult) {
		super(file, sumRow, reportFormGroupCode, submissionFormat, validationResult);
	}
	
	protected boolean validatePart6() {
		boolean res = true;
		String part = getPart(6);
		String code = "0";
		
		if (reportFormGroupCode == EReportGroupSa.PELAPORAN_KOREKSI.getMenuCode() || 
				reportFormGroupCode == EReportGroupSa.PENGKINIAN_KOREKSI.getMenuCode()) {
			code = "1";
		}
		
		if (!part.equals(code))
			res = false;
		
		if (!res)
			result.errors.add(new ValidationError(null, ValidationErrorCode.E03_20_REPORT_FORM_GROUP, code));

		return res;
	}
}
