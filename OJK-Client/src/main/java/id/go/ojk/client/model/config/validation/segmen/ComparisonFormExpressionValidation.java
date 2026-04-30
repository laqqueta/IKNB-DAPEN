package id.go.ojk.client.model.config.validation.segmen;

import java.math.BigDecimal;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.util.ToBigDecimal;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.constant.Comparation;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import lombok.extern.slf4j.Slf4j;

@XStreamAlias("ComparisonFormExpressionValidation")
@Slf4j
/*
 * Use case:
 * If A in form 1 is <expr1>,then SUM(A:C) in form 2 must [eq atau neq> <expr2>
 */
public class ComparisonFormExpressionValidation extends ComparisonFormValidation {
  private String selectExpr;
  private String comparatorExpr;

  public ComparisonFormExpressionValidation() {
    super();
  }

  public ComparisonFormExpressionValidation(String parameter) {
    super(parameter);
  }
  
  @Override
    public ComparisonFormValidation initialized() {
      super.initialized();
      selectExpr = getStringParameter("selectExpr");
      comparatorExpr = getStringParameter("selectExpr");
      return this;
    }

  @Override
  public String genMessage() {
    if(StringUtils.isNotBlank(msgError)) {
      String operatorDesc = Comparation.valueOf(operator).getDesc();
      String[] components = StringUtils.split(msgError, "|");
      if (components.length == 2) {
        msgError = "Jika '" + components[0] + "' " + selectExpr + ", maka '" + components[1] + "' harus " + operatorDesc + " " + comparatorExpr + " pada form " + comparatorForm;
      }
      return msgError;
    }
    else {
      return super.genMessage();
    }
  }

  @Override
  protected void compare(ScriptEngine engine, SubmissionFormat submissionFormat, ValidationResult validationResult, String idxSelectField) {
    try {
      BigDecimal selectValue =  ToBigDecimal.convert(getSelectValue(validationResult, idxSelectField).toString());
      BigDecimal comparatorValue = getComparatorValue(comparatorField);
      boolean result1 = isValueEquals(engine, selectValue, selectExpr);
      boolean result2 = isValueEquals(engine, comparatorValue, comparatorExpr);
      if(!isExpressionEquals(result1, result2)) {
        log.error("{}. Expr: '{}' {} '{}'", parameter, selectExpr, operator, comparatorExpr);
        List<SubmissionField> fields = submissionFormat.getFields();
        SubmissionField submissionField = fields.get(Integer.parseInt(idxSelectField));
        validationResult.errors.add(new ValidationError(submissionField, ValidationErrorCode.E99_00_OTHER, genMessage()));
      }
    } catch(Exception e) {
      log.error(e.getMessage(), e);
    }
  }

  private boolean isValueEquals(ScriptEngine engine, BigDecimal value, String expression) {
    try {
      if(StringUtils.isNotBlank(expression)) {
        expression = value.toPlainString() + expression;
      } else {
        expression = value.toPlainString();
      }
      Object result = engine.eval(expression);
      if(log.isDebugEnabled())
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
