package id.go.ojk.client.model.config.validation.segmen.v2;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.UtilValidation;
import id.go.ojk.client.model.config.validation.segmen.v2.base.BaseDecimalValidation;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

@XStreamAlias("EqualsRatioFormSbnValidation")
@Slf4j
public class EqualsRatioFormSbnValidation extends BaseDecimalValidation {
    private String comparator1RowCode;
    private String comparator1Field;
    private String comparator2Form;
    private String comparator2RowCode;
    private String comparator2Field;
    private String message;

    public EqualsRatioFormSbnValidation() {
        super();
    }

    public EqualsRatioFormSbnValidation(String parameter) {
        super(parameter);
    }

    @Override
    public EqualsRatioFormSbnValidation initialized() {
        super.initialized();
        comparator1RowCode = getStringParameter("comparator1RowCode");
        comparator1Field = getStringParameter("comparator1Field");
        comparator2Form = getStringParameter("comparator2Form");
        comparator2RowCode = getStringParameter("comparator2RowCode");
        comparator2Field = getStringParameter("comparator2Field");
        message = getStringParameter("message");
        return this;
    }

    private BigDecimal getComparator1Value(String column) {
        return UtilValidation.calculateColumn(SubmissionFormat.mapPosValue, comparator1RowCode, column, scale);
    }

    private BigDecimal getComparator2Value(String column) {
        Map<String, Map<String, String>> formValues = SubmissionFormat.getFormValues(comparator2Form + comparator2RowCode, Character.MAX_VALUE);
        return UtilValidation.calculateColumn(formValues, comparator2Form + comparator2RowCode, column, scale);
    }

    private BigDecimal getComparatorValue() {
        BigDecimal value1 = getComparator1Value(comparator1Field);
        BigDecimal value2 = getComparator2Value(comparator2Field);

        if (value1.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }

        return value2.compareTo(BigDecimal.ZERO) != 0 ?
                value1.divide(value2, 10, RoundingMode.HALF_UP) :
                BigDecimal.ZERO;
    }

    private BigDecimal getCurrentValue(ValidationResult validationResult, String column) {
        return UtilValidation.toBigDecimal(validationResult.getColumn(Integer.parseInt(column)), "0");
    }

    @Override
    public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat,
                         ValidationResult validationResult) {
        String currentRowCode = validationResult.getColumn(1);
        if (currentRowCode.equals(selectPosCode)) {

            BigDecimal comparatorValue = getComparatorValue()
                    .multiply(BigDecimal.valueOf(100))
                    .setScale(scale, RoundingMode.HALF_UP);

            BigDecimal currentValue = getCurrentValue(validationResult, selectField);

            if (currentValue.compareTo(comparatorValue) != 0) {
                log.error("{}->{}?{}", parameter, currentValue, comparatorValue);
                List<SubmissionField> fields = submissionFormat.getFields();
                SubmissionField submissionField = fields.get(Integer.parseInt(selectField));
                validationResult.errors.add(new ValidationError(submissionField,
                        ValidationErrorCode.E50_02_FORMULA, "",
                        StringUtils.replace(message, "|", "=")));
            }
        }
    }
}