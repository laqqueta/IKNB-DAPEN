package id.go.ojk.client.model.config.validation.segmen.v2;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.segmen.v2.base.BaseRowValidation;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class OperatorComparationValidation extends BaseRowValidation {

    private String operatorComparation;
    private String comparationValue;
    private String defaultValue;

    private String formCode = "";

    private static final Logger logger = LoggerFactory.getLogger(OperatorComparationValidation.class);

    public OperatorComparationValidation(String parameter) {
        super(parameter);
    }

    @Override
    public BaseRowValidation initialized() {
        super.initialized();

        operatorComparation = getStringParameter("operatorComparation");
        comparationValue = getStringParameter("comparationValue");
        defaultValue = getStringParameter("defaultValue");

        return this;
    }

    @Override
    public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
        String currentRowCode = validationResult.getColumn(1);
        LinkedList<String> selectRowCodes = Arrays.stream(StringUtils.split(selectPosCode, "|"))
                .collect(Collectors.toCollection(LinkedList::new));

        if (selectRowCodes.contains(currentRowCode)) {
            String[] fields = StringUtils.split(selectField, "|");
            String[] arrOperatorComparations = StringUtils.split(operatorComparation, "|");
            List<String> comparations = Arrays.stream(StringUtils.split(comparationValue, "|"))
                    .collect(Collectors.toCollection(LinkedList::new));

            comparations.add(defaultValue);
            formCode = submissionFormat.getCode();

            for (String idxField : fields) {
                String selectValue = getCurrentValue(validationResult, idxField);
                String comparatorValue = comparatorValue(idxField, arrOperatorComparations);

                if (!comparations.contains(selectValue)) {
                    List<SubmissionField> subsFields = submissionFormat.getFields();
                    SubmissionField submissionField = subsFields.get(Integer.parseInt(idxField));
                    validationResult.errors.add(new ValidationError(submissionField,
                            ValidationErrorCode.E50_26_FORMULA_CONDITIONVALUE,
                            String.join(" atau ", comparations)));
                } else if (!selectValue.equals(comparatorValue)) {
                    int errIdx = comparations.indexOf(comparatorValue);
                    List<SubmissionField> subsFields = submissionFormat.getFields();
                    SubmissionField submissionField = subsFields.get(Integer.parseInt(idxField));
                    logger.error("{}>{}?{}", parameter, selectValue, comparatorValue);
                    validationResult.errors.add(new ValidationError(submissionField,
                            ValidationErrorCode.E50_25_FORMULA_CONDITION,
                            comparatorValue, operationComparatorMsg(arrOperatorComparations[errIdx], idxField)));
                }
            }
        }
    }

    private String comparatorValue(String fields, String[] operatorComparation) {
        String[] arrComparationsValue = StringUtils.split(comparationValue, "|");

        for (int i = 0; i < operatorComparation.length; i++) {
            if (evalOperations(fields, operatorComparation[i])) return arrComparationsValue[i];
        }

        return defaultValue;
    }

    private String getCurrentValue(ValidationResult validationResult, String idxField) {
        return validationResult.getColumn(Integer.parseInt(idxField));
    }

    private boolean evalOperations(String fields, String operation) {
        Pattern pattern = Pattern.compile("(.*?)(>=|<=|==|!=|>|<)(.*)");
        Matcher matcher = pattern.matcher(operation);

        if (matcher.matches()) {
            String left = matcher.group(1).trim();
            String op = matcher.group(2);
            String right = matcher.group(3).trim();

            String leftVal = SubmissionFormat.getFormValue(formCode + left, fields);
            String rightVal = SubmissionFormat.getFormValue(formCode + right, fields);

            if (leftVal == null | rightVal == null) return false;

            return evalValue(leftVal, rightVal, op);
        }

        return false;
    }

    private boolean evalValue(String leftVal, String rightVal, String operator) {
        if (isInvalidNumeric(leftVal) || isInvalidNumeric(rightVal)) return false;

        BigDecimal leftValue = new BigDecimal(leftVal);
        BigDecimal rightValue = new BigDecimal(rightVal);

        int cmp = leftValue.compareTo(rightValue);

        switch (operator) {
            case ">=":
                return cmp >= 0;
            case "<=":
                return cmp <= 0;
            case "!=":
                return cmp != 0;
            case "==":
                return cmp == 0;
            case ">":
                return cmp > 0;
            default:
                return cmp < 0;
        }
    }

    private String operationComparatorMsg(String operation, String field) {
        Pattern pattern = Pattern.compile("(.*?)(>=|<=|==|!=|>|<)(.*)");
        Matcher matcher = pattern.matcher(operation);

        if (matcher.matches()) {
            String left = matcher.group(1).trim();
            String op = matcher.group(2);
            String right = matcher.group(3).trim();

            return String.format("kolom %4$s baris %1$s %2$s kolom %4$s baris %3$s", left, op, right, field);
        }

        return null;
    }

    private String getComparatorMsg(String comparatorFormula) {
        StringBuilder res = new StringBuilder();
        String[] formulaSplit = comparatorFormula.split("(?<=[-+/*])|(?=[-+/*])");
        int len = formulaSplit.length;
        for (int i = 0; i < len; i++) {
            String str = String.valueOf(formulaSplit[i]);
            String tmp = "";
            if (StringUtils.isNumeric(str)) {
                tmp = " kolom " + (Integer.parseInt(str) + 1);
            } else if (i + 1 < len) {
                tmp = " " + str;
            }
            res.append(tmp);
        }
        return res.toString();
    }
}
