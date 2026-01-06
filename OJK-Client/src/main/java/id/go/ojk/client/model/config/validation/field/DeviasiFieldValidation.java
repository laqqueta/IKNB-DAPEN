package id.go.ojk.client.model.config.validation.field;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.validation.ValidationUtil;
import id.go.ojk.lib.client.model.constant.Comparation;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DeviasiFieldValidation extends MapParamFieldValidation {
    private String conditionField;

    public DeviasiFieldValidation(String param) {
        setParameter(param);
    }

    @Override
    public DeviasiFieldValidation initialized() {
        this.conditionField = getStringParameter("conditionField");

        return this;
    }

    @Override
    public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
        String[] condtionFields = conditionField.split("[|]");

        int t = Integer.parseInt(condtionFields[0]);
        int r = Integer.parseInt(condtionFields[1]);

        Double targetVal = ValidationUtil.validateDouble(field, validationResult.rowSplited[t], null);
        Double realisasiVal = ValidationUtil.validateDouble(field, validationResult.rowSplited[r], null);
        Double deviasiVal = ValidationUtil.validateDouble(field, validationResult.rowSplited[field.getNumber()], null);

        String targetCol = submissionFormat.getFields().get(t).getName();
        String realisasiCol = submissionFormat.getFields().get(r).getName();

        Comparation comp = Comparation.e;

        if (targetVal == 0) {
            double realisasi = realisasiVal * 100;
            if (!comp.testCompareDouble(realisasi, deviasiVal)) {
                validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E03_28_TARGET_ZERO, realisasiCol, targetCol));
            }
        } else {
            double calc = new BigDecimal(((realisasiVal - targetVal) / targetVal) * 100)
                    .setScale(2, RoundingMode.HALF_UP)
                    .doubleValue();

            if (!comp.testCompareDouble(calc, deviasiVal)) {
                validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E03_29_DEVIATION_CALCULATION,
                        realisasiCol, targetCol, targetCol));
            }
        }
    }
}
