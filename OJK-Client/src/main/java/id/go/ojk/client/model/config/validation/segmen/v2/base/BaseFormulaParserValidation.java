package id.go.ojk.client.model.config.validation.segmen.v2.base;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.UtilValidation;
import id.go.ojk.client.model.config.validation.segmen.v2.util.FormulaParser;
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
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import static id.go.ojk.client.model.config.validation.segmen.v2.util.FormulaParser.ParsedFormula;
import static id.go.ojk.client.model.config.validation.segmen.v2.util.FormulaParser.parse;

@XStreamAlias("BaseFormulaParserFormValidation")
public class BaseFormulaParserValidation extends BaseRowValidation {
    protected String formulaOperation;
    protected String formulaOperationErr;
    protected int scale;

    public BaseFormulaParserValidation() {
        super();
    }

    public BaseFormulaParserValidation(String parameter) {
        super(parameter);
    }

    @Override
    public BaseFormulaParserValidation initialized() {
        super.initialized();

        formulaOperation = getStringParameter("formulaOperation");
        formulaOperationErr = getStringParameter("formulaOperationErr");
        scale = getIntParameter("scale");

        return this;
    }

    @Override
    public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
        String currentRowCode = validationResult.getColumn(1);
        List<String> selectRowCodes = Arrays.stream(StringUtils.split(selectPosCode, "|"))
                .collect(Collectors.toList());

        if (!selectRowCodes.contains(currentRowCode)) return;

        String[] fields = StringUtils.split(selectField, "|");
        String[] operations = StringUtils.split(formulaOperation, "|");
        String[] operationErrMsgs = StringUtils.split(formulaOperationErr, "|");

        if (fields.length != operations.length || operationErrMsgs.length != operations.length)
            throw new IllegalStateException();

        final Logger logger = LoggerFactory.getLogger(BaseFormulaParserValidation.class);

        for (int i = 0; i < fields.length; i++) {
            ParsedFormula parsed = parse(operations[i]);
            BigDecimal selectValue = getCurrentValue(validationResult, fields[i]);
            BigDecimal calculatedValue = calculateFormula(parsed);

            if (selectValue.compareTo(calculatedValue) != 0) {
                List<SubmissionField> field = submissionFormat.getFields();
                SubmissionField submissionField = field.get(Integer.parseInt(fields[i]));
//				String err = "= " + operationErrMsg + " pada Form " + comparatorForm;
                logger.error("{}>{}?{} :: Operation Idx > {}", parameter, selectValue, calculatedValue, i);
                validationResult.errors.add(new ValidationError(submissionField,
                        ValidationErrorCode.E03_35_EQUAL_FORM,
                        operationErrMsgs[i].replaceFirst("(sama dengan)", "=")
                                .replace("kurang lebih atau sama dengan", "<=")
                                .replace("lebih dari atau sama dengan ", ">=")));

            }
        }
    }

    protected BigDecimal getCurrentValue(ValidationResult validationResult, String idxField) {
        return UtilValidation.toBigDecimal(validationResult.getColumn(Integer.parseInt(idxField)));
    }

    protected BigDecimal calculateFormula(ParsedFormula parsed) {
        BigDecimal formulaResult = BigDecimal.ZERO;
        for (FormulaParser.Group g : parsed.getGroups()) {
            BigDecimal groupTotal = BigDecimal.ZERO;
            for (FormulaParser.RowToken t : g.getTokens()) {
                groupTotal = calculateOperand(groupTotal, calculateFieldStream(t), t.getOperator());
            }
            formulaResult = calculateOperand(formulaResult, groupTotal, g.getOperator());
        }

        return formulaResult;
    }

    protected BigDecimal calculateFieldStream(FormulaParser.RowToken rowToken) {
        BigDecimal[] fieldTotal = { BigDecimal.ZERO };
        int[] ctrA = { 0 };
        boolean[] isInvalidValue = { false };
        SubmissionFormat.getStreamOfFormSubMap(rowToken.getRowPrefix() + rowToken.getRowCode(), Character.MAX_VALUE)
                .map(Map.Entry::getValue)
                .forEach(v -> {
                    for (String field : rowToken.getMapOperands().keySet()) {
                        if (isInvalidValue[0]) continue;
                        if (isInvalidNumeric(v.get(field))) isInvalidValue[0] = true;
                        else {
                            fieldTotal[0] = calculateFieldOperand(fieldTotal[0],
                                    new BigDecimal(v.get(field)),
                                    rowToken.getMapOperands().get(field), ctrA[0]++);
                        }
                    }

                    if (isInvalidValue[0]) fieldTotal[0] = BigDecimal.ZERO;
                });

        return fieldTotal[0];
    }

    protected BigDecimal calculateOperand(BigDecimal value, BigDecimal tmpVal, String operator) {
        if (operator == null || operator.isEmpty()) {
            value = tmpVal;
        } else {
            switch (operator) {
                case "+":
                    value = value.add(tmpVal);
                    break;
                case "-":
                    value = value.subtract(tmpVal);
                    break;
                case "*":
                    value = value.multiply(tmpVal);
                    break;
                case "/":
                    if (tmpVal.compareTo(BigDecimal.ZERO) != 0) value = value.divide(tmpVal, 4, RoundingMode.HALF_EVEN);
                    else value = BigDecimal.ZERO;
                    break;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        return value
                .setScale(scale, RoundingMode.HALF_UP);
    }

    protected BigDecimal calculateFieldOperand(BigDecimal value, BigDecimal tmpVal, String operator, int ctr) {
        if (ctr == 0 && (operator == null || operator.isEmpty())) {
            value = tmpVal;
        } else if (ctr > 0 && (operator == null || operator.isEmpty())) {
            value = value.add(tmpVal);
        } else {
            switch (operator) {
                case "+":
                    value = value.add(tmpVal);
                    break;
                case "-":
                    value = value.subtract(tmpVal);
                    break;
                case "*":
                    value = value.multiply(tmpVal);
                    break;
                case "/":
                    if (tmpVal.compareTo(BigDecimal.ZERO) != 0) value = value.divide(tmpVal, 4, RoundingMode.HALF_EVEN);
                    else value = BigDecimal.ZERO;
                    break;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        return value
                .setScale(scale, RoundingMode.HALF_UP);
    }
}