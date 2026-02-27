package id.go.ojk.client.model.config.validation.segmen;

import com.thoughtworks.xstream.annotations.XStreamAlias;
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
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@XStreamAlias("TotalSumIfsFormValidation")
public class TotalSumIfsFormValidation extends BaseRowValidation {

    private String comparatorForm;
    private String comparatorRow;
    private String rangeField;
    private String criteriaField;
    private String criteriaCondition;
    private String msgError;
    private String conditionError;

    public TotalSumIfsFormValidation() { }

    public TotalSumIfsFormValidation(String parameter) {
        super(parameter);
    }

    @Override
    public BaseRowValidation initialized() {
        super.initialized();

        comparatorForm = getStringParameter("comparatorForm");
        comparatorRow = getStringParameter("comparatorRow");
        rangeField = getStringParameter("rangeField");
        criteriaField = getStringParameter("criteriaField");
        criteriaCondition = getStringParameter("criteriaCondition");
        msgError = getStringParameter("msgError");
        conditionError = getStringParameter("conditionError");

        return this;
    }

    @Override
    public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
        String currentRowCode = validationResult.getColumn(1);
        if (currentRowCode.equals(selectPosCode)) {
            final Logger logger = LoggerFactory.getLogger(EqualsFormulaValidation.class);
            String[] arrColumn = StringUtils.split(selectField, "|");
            BigDecimal sumCondsValue = calculateConditions();
            for (int i = 0; i < arrColumn.length; i++) {
                String idxField = arrColumn[i];
                BigDecimal selectValue = getCurrentValue(validationResult, idxField);
                if (selectValue.compareTo(sumCondsValue) != 0) {
                    String[] msgErrors = StringUtils.split(msgError, "|");
                    List<SubmissionField> fields = submissionFormat.getFields();
                    SubmissionField submissionField = fields.get(Integer.parseInt(idxField));
                    logger.error("{}>{}?{}", parameter, selectValue, sumCondsValue);
                    validationResult.errors.add(new ValidationError(submissionField,
                            ValidationErrorCode.E50_21_FORMULA_SUMIFS,
                            msgErrors[0], msgErrors[1], slashFormatError(conditionError), msgErrors[2] ));
                }

            }
        }
    }

    private BigDecimal calculateConditions() {
        String[] conds = StringUtils.split(criteriaCondition, "|");
        Map<String, BigDecimal> mapConds = Arrays.stream(conds)
                .collect(Collectors.toMap(
                        s -> s,
                        s -> this.scaledDecimal(0.0)));

        // this used for marking the key that has invalid decimal value
        Map<String, Boolean> mapCondsStatus = Arrays.stream(conds)
                .collect(Collectors.toMap(
                        s -> s,
                        s -> true));

        for (Map.Entry<String, Map<String, String>> entry : SubmissionFormat.mapPosValueForm.entrySet()) {
            if (!entry.getKey().startsWith(comparatorForm + comparatorRow)) continue; // check if its the required form
            if (entry.getValue().get(criteriaField).isEmpty()) continue; // check ref if empty or not *this prob useless

            String key = entry.getValue().get(criteriaField);
            if (!mapConds.containsKey(key)) continue; // check if the refs are in the map

            // skip the key entirely if the status's key are having invalid decimal
            // so that'll skip the next logic entirely to avoid any kind exception/error (stopper)
            if (!mapCondsStatus.get(key)) continue;

            String value = entry.getValue().get(rangeField);
            if (!this.isValidDecimal(value)) { // minimal check if its valid decimal or not
                // mark the invalid decimal value
                mapCondsStatus.put(key, false);
                continue;
            }

            if (!mapCondsStatus.get(key)) continue; // same

            mapConds.compute(key, (k, v) -> v.add(new BigDecimal(value)));
        }

        return mapConds.values()
                .stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal scaledDecimal(double d) {
        return BigDecimal.valueOf(d)
                .setScale(2, RoundingMode.HALF_UP);
    }

    private boolean isValidDecimal(String s) {
        int len = s.length();
        if (len == 0) return false;

        boolean dotFound = false;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '.') {
                if (dotFound) return false;
                dotFound = true;
            } else if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }

    private BigDecimal getCurrentValue(ValidationResult validationResult, String idxField) {
        return UtilValidation.toBigDecimal(validationResult.getColumn(Integer.parseInt(idxField)));
    }

    private String slashFormatError(String errorData) {
        String[] errs = StringUtils.split(errorData, "|");

        return String.join(" / ", errs);
    }

    /*
    * nilai harus sama dengan total penjumlahan pada form '' di kolom '' dengan kondisi '' pada kolom ''
    *
    * */
}
