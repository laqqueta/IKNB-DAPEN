package id.go.ojk.client.module.lktb;

import id.go.ojk.client.model.ValidFile;
import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.SetupService;
import id.go.ojk.client.service.context.ApplicationContextClient;
import id.go.ojk.client.util.states.JenisProgramState;
import id.go.ojk.client.validation.BaseValidationPreHeader;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.List;

public class ValidationPreHeaderLktb extends BaseValidationPreHeader {
    private ApplicationContextClient ctx = ApplicationContextClient.getInstance();
    protected ValidFile validFile;
    protected int reportFormGroupCode;

    public ValidationPreHeaderLktb(File file, int sumRow, int reportFormGroupCode, SubmissionFormat submissionFormat,
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
        }
        sumRow(result);
        return res;
    }

    protected boolean validatePart() {
        boolean res = result.getColumnLength() == 9;
        if (!res) {
            result.errors.add(new ValidationError(null, ValidationErrorCode.E03_01_COL_NUMBER, 9));
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
        String code = String.valueOf(EReportGroupLktb.getRevisionCodeByCode(reportFormGroupCode));
        res = part.equals(code);
        if (!res) {
            result.errors.add(new ValidationError(null, ValidationErrorCode.E03_20_REPORT_FORM_GROUP, code));
        }
        return res;
    }


    protected boolean validatePart7() {
        String part = getPart(8);

        String code = JenisProgramState.selectedKey.replaceAll("[^A-Za-z]", "");
        boolean res = part.equals(code);
        if (!res) {
            JenisProgramState.validationState.setValue(false);
            result.errors.add(new ValidationError(null, ValidationErrorCode.E03_30_JENIS_PROGRAM, part, JenisProgramState.selectedValue));
        }

        return res;

    }

    protected String getPart(int idx) {
        return result.getColumnLength() - 1 >= idx ? result.getColumn(idx) : "";
    }
}
