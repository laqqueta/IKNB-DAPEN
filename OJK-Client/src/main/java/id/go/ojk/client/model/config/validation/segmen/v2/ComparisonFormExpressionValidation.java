package id.go.ojk.client.model.config.validation.segmen.v2;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
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
import java.util.List;


@XStreamAlias("ComparisonFormExpressionValidation")
@Slf4j
public class ComparisonFormExpressionValidation extends ComparisonFormValidationV2 {
    private String selectExpr;
    private String comparatorExpr;

    public ComparisonFormExpressionValidation() {
        super();
    }

    public ComparisonFormExpressionValidation(String parameter) {
        super(parameter);
    }

    @Override
    public ComparisonFormValidationV2 initialized() {
        super.initialized();
        selectExpr = getStringParameter("selectExpr");
        comparatorExpr = getStringParameter("comparatorExpr");
        return this;
    }

    @Override
    public String genMessage() {
        return msgError;
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
                validationResult.errors.add(new ValidationError(submissionField, ValidationErrorCode.E99_00_OTHER, genMessage()));
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
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
