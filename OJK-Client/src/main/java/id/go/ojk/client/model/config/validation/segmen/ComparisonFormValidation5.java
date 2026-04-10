 package id.go.ojk.client.model.config.validation.segmen;

import java.math.BigDecimal;
import java.util.List;

import javax.script.ScriptEngine;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import lombok.extern.slf4j.Slf4j;

@XStreamAlias("ComparisonFormValidation5")
@Slf4j
@Deprecated
public class ComparisonFormValidation5 extends ComparisonFormValidation {
  private String leftExpr;
  private String rightExpr;

	public ComparisonFormValidation5() {
		super();
	}

	public ComparisonFormValidation5(String parameter) {
		super(parameter);
	}

	@Override
	public ComparisonFormValidation5 initialized() {
		super.initialized();
		leftExpr = getStringParameter("leftExpr");
		rightExpr = getStringParameter("rightExpr");
		return this;
	}

	@Override
  protected void compare(ScriptEngine engine, SubmissionFormat submissionFormat, ValidationResult validationResult, String idxSelectField) {
    try {
      Object selectValue = getSelectValue(validationResult, idxSelectField);
      BigDecimal comparatorValue = getComparatorValue(idxSelectField);

      if (StringUtils.isNotBlank(leftExpr)) {
        comparatorValue = toBigDecimal(engine.eval(leftExpr + comparatorValue.toPlainString()));
      }

      if (StringUtils.isNotBlank(rightExpr)) {
        comparatorValue = toBigDecimal(engine.eval(comparatorValue.toPlainString() + rightExpr));
      }

      if (!compareValue(engine, selectValue, comparatorValue)) {
        log.error("{}>{}?{}", parameter, selectValue, comparatorValue.toPlainString());
        List<SubmissionField> fields = submissionFormat.getFields();
        SubmissionField submissionField = fields.get(Integer.parseInt(idxSelectField));
        validationResult.errors.add(new ValidationError(submissionField, ValidationErrorCode.E50_02_FORMULA, comparatorValue.toPlainString(), genMessage()));
      } else {
        log.trace("{}>{}?{}", parameter, selectValue, comparatorValue.toPlainString());
      }
    } catch(Exception e) {
      log.error(e.getMessage(), e);
    }
  }
	
  @Override
  public String genMessage() {
    String msg = super.genMessage();

    if (StringUtils.isNotBlank(rightExpr)) {
      msg = msg + " " + rightExpr.trim();
    }

    if (StringUtils.isNotBlank(leftExpr)) {
      String prefix = "sama dengan ";
      msg = prefix + leftExpr.trim() + " " + msg.substring(prefix.length());
    }

    return msg;
  }

  private static BigDecimal toBigDecimal(Object value) {
    BigDecimal defaultValue = BigDecimal.ZERO;
    if (value == null) {
      return defaultValue;
    }
    try {
      if (value instanceof BigDecimal) {
        return (BigDecimal) value;
      }
      if (value instanceof Number) {
        return BigDecimal.valueOf(((Number) value).doubleValue());
      }
      if (value instanceof String) {
        String s = ((String) value).trim();
        if (s.isEmpty()) {
          return null;
        }
        return new BigDecimal(s);
      }
    } catch (NumberFormatException e) {
      return defaultValue;
    }
    return defaultValue;
  }
}