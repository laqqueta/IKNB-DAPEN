package id.go.ojk.client.model.config.validation.segmen;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.UtilValidation;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GeoMeanInvestasiFormValidation extends BaseRowValidation {

    private String comparatorForm;
    private String comparatorRow;
    private String comparatorField;
    private String msgError;
    private String msgErrorRow;

    private static final Logger logger = LoggerFactory.getLogger(GeoMeanInvestasiFormValidation.class);

    public GeoMeanInvestasiFormValidation() {
    }

    public GeoMeanInvestasiFormValidation(String parameter) {
        super(parameter);
    }

    @Override
    public BaseRowValidation initialized() {
        super.initialized();

        comparatorForm = getStringParameter("comparatorForm");
        comparatorRow = getStringParameter("comparatorRow");
        comparatorField = getStringParameter("comparatorField");
        msgError = getStringParameter("msgError");
        msgErrorRow = getStringParameter("msgErrorRow");

        return this;
    }

    @Override
    public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
        String currentRowCode = validationResult.getColumn(1);
        LinkedList<String> selectRowCodes = Arrays.stream(StringUtils.split(selectPosCode, "|"))
                .collect(Collectors.toCollection(LinkedList::new));

        if (selectRowCodes.contains(currentRowCode)) {
            String[] fields = StringUtils.split(selectField, "|");
            String[] comparatorRows = StringUtils.split(comparatorRow, "|");
            String[] errorRows = StringUtils.split(msgErrorRow, "|");

            int formRowIndex = selectRowCodes.indexOf(currentRowCode);
            for (String idxField : fields) {
                BigDecimal selectValue = getCurrentValue(validationResult, idxField);
                BigDecimal formComparatorValue = calculateGeoMean(comparatorRows[formRowIndex]);

                if (selectValue.compareTo(formComparatorValue) != 0) {
                    String[] msgErrors = StringUtils.split(msgError, "|");
                    List<SubmissionField> subsFields = submissionFormat.getFields();
                    SubmissionField submissionField = subsFields.get(Integer.parseInt(idxField));
                    logger.error("{}>{}?{}", parameter, selectValue, formComparatorValue);
                    validationResult.errors.add(new ValidationError(submissionField,
                            ValidationErrorCode.E50_21_FORMULA_GEOMEAN,
                            getComparatorMsg(msgErrors[0]), msgErrors[1], msgErrors[2], msgErrors[3] + errorRows[formRowIndex]));
                }
            }
        }
    }

    private BigDecimal calculateGeoMean(String comparatorFormRow) {
        String[] comparatorFields = StringUtils.split(comparatorField, "|");
        BigDecimal p = BigDecimal.ONE;
        long positiveCount = 0;

        for (Map.Entry<String, Map<String, String>> entry : SubmissionFormat.mapPosValueForm.entrySet()) {
            if (!entry.getKey().startsWith(comparatorForm + comparatorFormRow)) continue; // check if its the required form

            Map<String, String> formVals = entry.getValue();

            for(String field : comparatorFields) {
                if (!formVals.containsKey(field)) return BigDecimal.ZERO;
                if (!isValidInteger(formVals.get(field))) return BigDecimal.ZERO;

                boolean isNegative = false;
                BigDecimal value = BigDecimal.valueOf(Long.parseLong(formVals.get(field)));

                if (value.compareTo(BigDecimal.ZERO) < 0 | value.compareTo(BigDecimal.ZERO) == 0) isNegative = true;

                if (!isNegative) positiveCount++;
                else value = BigDecimal.ONE;

                p = p.multiply(value);
            }

            break;
        }

        BigDecimal exponent = BigDecimal.ONE.divide(
                BigDecimal.valueOf(positiveCount),
                3,
                RoundingMode.HALF_UP
        );

        return BigDecimal.valueOf(
                        Math.pow(p.doubleValue(), exponent.doubleValue()))
                .setScale(2, RoundingMode.CEILING);
    }

    private boolean isValidInteger(String s) {
        if (s == null) return false;

        int len = s.length();
        if (len == 0) return false;

        int i = 0;

        for (; i < len; i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }

        return true;
    }

    private BigDecimal getCurrentValue(ValidationResult validationResult, String idxField) {
        return UtilValidation.toBigDecimal(validationResult.getColumn(Integer.parseInt(idxField)))
                .setScale(2, RoundingMode.HALF_UP);
    }

    private String getComparatorMsg(String comparatorFormula) {
        String res = "";
        String[] formulaSplit = comparatorFormula.split("(?<=[-+/*])|(?=[-+/*])");
        int len = formulaSplit.length;
        for (int i = 0; i < len; i++) {
            String str = String.valueOf(formulaSplit[i]);
            String tmp = "";
            if (StringUtils.isNumeric(str)) {
                tmp = " kolom " + String.valueOf(Integer.parseInt(str) + 1);
            } else if (i + 1 < len) {
                tmp = " " + str;
            }
            res += tmp;
        }
        return res;
    }
}
