package id.go.ojk.client.module.tpp;

import id.go.ojk.client.constant.ESector;
import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.module.ValidationPreHeader;
import id.go.ojk.client.service.SetupService;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ValidationPreHeaderTpp extends ValidationPreHeader {

    private final int MAX_HEADER_LENGTH = 8;

    public ValidationPreHeaderTpp(File file, int sumRow, int reportFormGroupCode, SubmissionFormat submissionFormat,
                                  ValidationResult validationResult) {
        super(file, sumRow, reportFormGroupCode, submissionFormat, validationResult);
    }

    @Override
    protected boolean validatePart() {
        boolean res = result.getColumnLength() == MAX_HEADER_LENGTH;
        if (!res) {
            result.errors.add(new ValidationError(null, ValidationErrorCode.E03_01_COL_NUMBER, MAX_HEADER_LENGTH));
            result.stopValidation = true;
        }
        return res;
    }

    @Override
    protected boolean validatePart6() {
        boolean res;
        String part = getPart(6);
        List<String> codes = new ArrayList<>();
        switch (reportFormGroupCode) {
            case 2:
            case 4:
            case 6:
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
        boolean res = true;
        String part = getPart(7);
        String memberCode = ctx.getService(SetupService.class).getSectorCode();

        if (ESector.isFintech(memberCode)) {
            maxLen = 50;
        }

        if (reportFormGroupCode == 2 || reportFormGroupCode == 4 || reportFormGroupCode == 6) {
            if (StringUtils.isBlank(part)) {
                result.errors.add(new ValidationError(null, ValidationErrorCode.E03_15_NO_SURAT));
                res = false;
            } else if (!part.matches(SimpleValidation.PATTERN_NO_SURAT_PM.getPattern())) {
                result.errors.add(new ValidationError(null, ValidationErrorCode.E03_27_NO_SURAT_PATTERN_PM));
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
