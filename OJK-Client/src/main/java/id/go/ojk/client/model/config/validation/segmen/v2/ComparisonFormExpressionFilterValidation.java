package id.go.ojk.client.model.config.validation.segmen.v2;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.context.ApplicationContextClient;
import id.go.ojk.client.service.validation.ValidationService;
import id.go.ojk.lib.client.exception.SlikException;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.util.ToBigDecimal;

import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;


@XStreamAlias("ComparisonFormExpressionFilterValidation")
@Slf4j
public class ComparisonFormExpressionFilterValidation extends ComparisonFormValidationV2 {
    private String selectExpr;
    private String comparatorExpr;
    private String filterColumn;
    private String filterValues;
    private final AtomicReference<String> filterVal = new AtomicReference<>();

    public ComparisonFormExpressionFilterValidation() {
        super();
    }

    public ComparisonFormExpressionFilterValidation(String parameter) {
        super(parameter);
    }

    @Override
    public ComparisonFormValidationV2 initialized() {
        super.initialized();
        selectExpr = getStringParameter("selectExpr");
        comparatorExpr = getStringParameter("comparatorExpr");
        filterColumn = getStringParameter("filterColumn");
        filterValues = getStringParameter("filterValues");
        return this;
    }

    @Override
    public String genMessage() {
        return msgError;
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
    protected void compare(ScriptEngine engine, SubmissionFormat submissionFormat, ValidationResult validationResult, String idxSelectField) {
        try {
            BigDecimal selectValue = ToBigDecimal.convert(getSelectValue(validationResult, idxSelectField).toString());
            BigDecimal comparatorValue = getComparatorValue(comparatorField);
            Object result1 = evaluateExpression(engine, selectValue, selectExpr);
            BigDecimal result2 = new BigDecimal(evaluateExpression(engine, comparatorValue, comparatorExpr).toString(), new MathContext(scale, RoundingMode.HALF_UP));
            if (!compareValue(engine, result1, result2)) {
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
            res = res.add(SubmissionFormat.getSumTreeMapPosFormValue(comparatorForm, comparatorPosCode, field, filterColumn, filterVal.get()).setScale(scale, RoundingMode.HALF_UP));
        }
        return res;
    }

    private Object evaluateExpression(ScriptEngine engine, BigDecimal value, String expression) {
        try {
            if (StringUtils.isBlank(expression)) {
                return value;
            }
            expression = value.toPlainString() + expression;
            Object result = engine.eval(expression);
            if (log.isDebugEnabled())
                log.debug("expression: {}, result: {}", expression, result);
            return result;
        } catch (ScriptException e) {
            log.error("expression: {}", expression);
            log.error(e.getMessage(), e);
            throw new SlikException(e.getMessage(), e);
        }
    }
}
