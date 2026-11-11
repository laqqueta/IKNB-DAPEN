package id.go.ojk.client.model.config.validation.segmen.v2;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.UtilValidation;
import id.go.ojk.client.model.config.validation.segmen.v2.base.BaseRowValidation;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterGeoMeanInvestasiFormValidation extends BaseRowValidation {

    private String comparatorForm;
    private String comparatorRow;
    private String comparatorField;
    private String filterColumn;
    private String filterValues;
    private String msgError;
    private String msgErrorRow;

    private static final Logger logger = LoggerFactory.getLogger(FilterGeoMeanInvestasiFormValidation.class);

    public FilterGeoMeanInvestasiFormValidation(String parameter) {
        super(parameter);
    }

    @Override
    public BaseRowValidation initialized() {
        super.initialized();

        comparatorForm = getStringParameter("comparatorForm");
        comparatorRow = getStringParameter("comparatorRow");
        comparatorField = getStringParameter("comparatorField");
        filterColumn = getStringParameter("filterColumn");
        filterValues = getStringParameter("filterValues");
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

            List<String> filters = Arrays.asList(StringUtils.split(filterValues, "|"));
            String filterFieldValue = validationResult.getColumn(Integer.parseInt(filterColumn));

            if (!filters.contains(filterFieldValue)) return;

            String[] fields = StringUtils.split(selectField, "|");
            String[] comparatorRows = StringUtils.split(comparatorRow, "|");
            String[] errorRows = StringUtils.split(msgErrorRow, "|");
            int formRowIndex = selectRowCodes.indexOf(currentRowCode);

            for (String idxField : fields) {
                BigDecimal selectValue = getCurrentValue(validationResult, idxField);
                BigDecimal formComparatorValue = calculateGeoMean(comparatorRows[formRowIndex], filterFieldValue, filterColumn);

                if (selectValue.compareTo(formComparatorValue) != 0) {
                    String[] msgErrors = StringUtils.split(msgError, "|");
                    List<SubmissionField> subsFields = submissionFormat.getFields();
                    SubmissionField submissionField = subsFields.get(Integer.parseInt(idxField));
                    SubmissionField sfFilter = subsFields.get(Integer.parseInt(filterColumn));
                    logger.error("{}>{}?{}", parameter, selectValue, formComparatorValue);
                    validationResult.errors.add(new ValidationError(submissionField,
                            ValidationErrorCode.E50_22_FORMULA_GEOMEAN_2,
                            getComparatorMsg(msgErrors[0]), msgErrors[1], msgErrors[2], msgErrors[3] + errorRows[formRowIndex],
                            sfFilter.getName(), filterFieldValue));
                }
            }
        }
    }

    private BigDecimal calculateGeoMean(String comparatorFormRow, String filterValue, String filterCol) {
        String[] comparatorFields = StringUtils.split(comparatorField, "|");
        AtomicLong positiveCount = new AtomicLong();
        BigDecimal[] p = new BigDecimal[1];
        p[0] = BigDecimal.ONE;
        AtomicBoolean isContains = new AtomicBoolean(true);
        AtomicBoolean isInvalidNum = new AtomicBoolean(false);

        String prefix = comparatorForm + comparatorFormRow.split("-")[0];
        Stream<Map.Entry<String, Map<String, String>>> tmp = SubmissionFormat.getStreamOfFormSubMap(prefix, Character.MAX_VALUE);
        SubmissionFormat.getStreamOfFormSubMap(prefix, Character.MAX_VALUE)
                .filter(v -> v.getValue().get(filterCol) != null && v.getValue().get(filterCol).equals(filterValue))
                .forEach(v -> {
                    for (String field : comparatorFields) {
                        if (!isContains.get()) {
                            p[0] = BigDecimal.ZERO;
                            return;
                        }

                        if (isInvalidNum.get()) {
                            p[0] = BigDecimal.ZERO;
                            return;
                        }

                        if (!v.getValue().containsKey(field)) {
                            isContains.set(false);
                            return;
                        }

                        if (isInvalidNumeric(v.getValue().get(field))) {
                            isInvalidNum.set(true);
                            return;
                        }

                        boolean isNegative = false;
                        BigDecimal value = BigDecimal.valueOf(Long.parseLong(v.getValue().get(field)));

                        if (value.compareTo(BigDecimal.ZERO) < 0 | value.compareTo(BigDecimal.ZERO) == 0)
                            isNegative = true;

                        if (!isNegative) positiveCount.getAndIncrement();
                        else value = BigDecimal.ONE;

                        p[0] = p[0].multiply(value, MathContext.DECIMAL64);
                    }

                });


        if (p[0].compareTo(BigDecimal.ZERO) == 0) return BigDecimal.ZERO;

        BigDecimal exponent = BigDecimal.ONE.divide(
                BigDecimal.valueOf(positiveCount.get()), MathContext.DECIMAL64);

        return BigDecimal.valueOf(
                        Math.pow(p[0].doubleValue(), exponent.doubleValue()))
                .setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal getCurrentValue(ValidationResult validationResult, String idxField) {
        return UtilValidation.toBigDecimal(validationResult.getColumn(Integer.parseInt(idxField)))
                .setScale(2, RoundingMode.HALF_UP);
    }

    private String getComparatorMsg(String comparatorFormula) {
        StringBuilder res = new StringBuilder("( Kolom");
        String[] formulaSplit = comparatorFormula.split("(?<=[-+/*])|(?=[-+/*])");
        int len = formulaSplit.length;
        for (int i = 0; i < len; i++) {
            String str = String.valueOf(formulaSplit[i]);
            String tmp = "";
            if (StringUtils.isNumeric(str)) {
                tmp = " kolom " + (Integer.parseInt(str) + 1);
            } else {
                tmp = " " + str;
            }
            res.append(tmp);
        }
        return res.append(")").toString();
    }
}
