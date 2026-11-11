package id.go.ojk.client.model.config.validation.segmen.v2;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.context.ApplicationContextClient;
import id.go.ojk.client.service.validation.ValidationService;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.util.ToBigDecimal;

import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@XStreamAlias("ComparisonFormConditionalExpressionValidationDppk2")
@Slf4j
/*
 * Use case:
 * If A in form 1 is <expr1>,then SUM(A:C) in form 2 must [eq atau neq> <expr2>
 */
public class ComparisonFormConditionalExpressionValidationDppk2 extends ComparisonFormValidationV2 {
    private String selectExpr;
    private String comparatorExpr;
    private String filterColumn;
    private String filterValues;
    private final AtomicReference<String> filterVal = new AtomicReference<>();

    public ComparisonFormConditionalExpressionValidationDppk2(String parameter) {
        super(parameter);
    }

    @Override
    public ComparisonFormValidationV2 initialized() {
        super.initialized();
        filterColumn = getStringParameter("filterColumn");
        filterValues = getStringParameter("filterValues");
        selectExpr = getStringParameter("selectExpr");
        comparatorExpr = getStringParameter("comparatorExpr");
        return this;
    }

    @Override
    public void validate(ProgressPreparationAndSending.SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
        List<String> listSelectPosCode = Arrays.asList(StringUtils.split(selectPosCode, "|"));
        String posCode = validationResult.getColumn(1);
        if (StringUtils.isNotEmpty(posCode) && listSelectPosCode.contains(posCode)) {

            List<String> filters = Arrays.asList(StringUtils.split(filterValues, "|"));
            String filterFieldValue = validationResult.getColumn(Integer.parseInt(filterColumn));

            if (!filters.contains(filterFieldValue)) return;
            filterVal.set(filterFieldValue);

            String[] arrSelectField = StringUtils.split(selectField, "|");
            for (int i = 0; i < arrSelectField.length; i++) {
                engine = ApplicationContextClient.getInstance().getService(ValidationService.class).getScriptEngine();
                compare(engine, submissionFormat, validationResult, arrSelectField[i]);
            }
        }
    }

    @Override
    public String genMessage() {
        if (StringUtils.isNotBlank(msgError)) {
            String[] components = StringUtils.split(msgError, "|");
            if (components.length == 2) {
                msgError = "Jika '" + components[0] + "' " + comparatorExpr + ", maka '" + components[1] + comparatorForm + "' harus " + selectExpr;
            }
            return msgError;
        } else {
            return super.genMessage();
        }
    }

    @Override
    protected void compare(ScriptEngine engine, SubmissionFormat submissionFormat, ValidationResult validationResult, String idxSelectField) {
        try {
            BigDecimal selectValue = ToBigDecimal.convert(getSelectValue(validationResult, idxSelectField).toString());
            BigDecimal comparatorValue = getComparatorValue(comparatorField);
            boolean result1 = isValueEquals(engine, selectValue, selectExpr);
            boolean result2 = isValueEquals(engine, comparatorValue, comparatorExpr);
            if (!isExpressionEquals(result1, result2)) {
                log.error("{}. Expr: '{}' {} '{}'", parameter, selectExpr, operator, comparatorExpr);
                List<SubmissionField> fields = submissionFormat.getFields();
                SubmissionField submissionField = fields.get(Integer.parseInt(idxSelectField));
                SubmissionField sfJenisProgram = fields.get(Integer.parseInt(filterColumn));
                validationResult.errors.add(new ValidationError(submissionField, ValidationErrorCode.E99_00_OTHER,
                        genMessage() + " pada '" + sfJenisProgram.getName() + "' = " + filterVal.get()));
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    protected BigDecimal getComparatorValue(String idxSelectField) {
        String[] arrComparatorField = StringUtils.split(comparatorField, '|');
        BigDecimal res = BigDecimal.ZERO;
        for (String field : arrComparatorField) {
            res = res.add(SubmissionFormat.getSumTreeMapPosFormValue(
                    comparatorForm, comparatorPosCode, field,
                    filterColumn, filterVal.get()
            ).setScale(scale, RoundingMode.HALF_UP));
        }
        return res;
    }

    private boolean isValueEquals(ScriptEngine engine, BigDecimal value, String expression) {
        try {
            if (StringUtils.isNotBlank(expression)) {
                expression = value.toPlainString() + expression;
            } else {
                expression = value.toPlainString();
            }
            Object result = engine.eval(expression);
            if (log.isDebugEnabled())
                log.debug("expression: {}, result: {}", expression, result);
            return Boolean.valueOf(result.toString());
        } catch (ScriptException e) {
            log.error("expression: {}", expression);
            log.error(e.getMessage(), e);
            return false;
        }
    }

    private boolean isExpressionEquals(boolean a, boolean b) {
        boolean res = false;
        switch (operator) {
            case "e":
                res = a == b;
                break;
            case "ne":
                res = a != b;
                break;
            default:
                break;
        }
        return res;
    }
}
