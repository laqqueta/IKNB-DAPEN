package id.go.ojk.client.model.config.validation.segmen;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.UtilValidation;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.context.ApplicationContextClient;
import id.go.ojk.client.service.validation.ValidationService;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import lombok.extern.slf4j.Slf4j;

/*
 * Copy dari RatioValidation dengan modif:
 * - Free text error message
 * - Const value eval
 * - Reuse script engine
 * - Divide by period
 * - fallback/default scale
 */
@XStreamAlias("ratioValidation2")
@Slf4j
public class RatioValidation2 extends BaseFormulaValidation {
  public static final int DEFAULT_SCALE = 2;
  protected boolean roundFull;
  protected String leftConstFormula;
  protected String rightConstFormula;
  protected boolean divByPeriod;

  public RatioValidation2() {
    super();
  }

  @Override
  public BaseFormulaValidation initialized() {
    roundFull = getBooleanParameter("roundFull", false);
    leftConstFormula = getStringParameter("leftConstFormula", null);
    rightConstFormula = getStringParameter("rightConstFormula", null);
    divByPeriod = getBooleanParameter("divByPeriod", false);
    return super.initialized();
  }

  public RatioValidation2(String parameter) {
    super(parameter);
  }

  @Override
  protected void compareFormula(ValidationResult validationResult, List<SubmissionField> submissionField, String field,
      int seq, String leftFormula, String operator, String rightFormula) {
    ScriptEngine engine = ApplicationContextClient.getInstance().getService(ValidationService.class).getScriptEngine();
    boolean result;
    BigDecimal leftValue = arithmeticOperation(leftFormula, seq);
    BigDecimal rightValue = calculateRatio(engine, rightFormula, seq);

    if (divByPeriod) {
      LocalDate period = SubmissionFormat.reportPeriod;
      if (period != null)
        rightValue = rightValue.divide(BigDecimal.valueOf(period.getMonthValue()), MathContext.DECIMAL128)
            .multiply(BigDecimal.valueOf(12));
    }

    rightValue = rightValue.multiply(new BigDecimal(100));
    rightValue = rightValue.setScale(roundFull ? 0 : DEFAULT_SCALE, RoundingMode.HALF_UP);

    String compareValue = leftValue + operator + rightValue;
    if (leftValue != null && rightValue != null) {
      try {
        result = (boolean) engine.eval(compareValue);
        if (!result) {
          int idxField = Integer.parseInt(field);
          log.error("leftFormula=" + leftFormula + ";rightFormula=" + rightFormula + ";compare=" + compareValue);
          msgError = StringUtils.replaceChars(msgError, "|", "=");
          validationResult.errors.add(new ValidationError(submissionField.get(idxField),
              ValidationErrorCode.E50_02_FORMULA, compareValue, msgError));
        }
      } catch (ScriptException e) {
        log.error(compareValue, e);
      }
    }
  }

  @Override
  protected BigDecimal arithmeticOperation(String formula, int seq) {
    BigDecimal res = super.arithmeticOperation(formula, seq);
    if (res != null) {
      res = res.setScale(roundFull ? 0 : DEFAULT_SCALE, RoundingMode.HALF_UP);
    }
    return res;
  }

  protected BigDecimal calculateRatio(ScriptEngine engine, String formula, int seq) {
    Logger logger = LoggerFactory.getLogger(RatioValidation2.class);
    BigDecimal res = BigDecimal.ZERO;
    try {
      String[] ratioFormulas = StringUtils.split(formula, "|");
      String formula1 = UtilValidation.getArray(ratioFormulas, 0, "");
      String formula2 = UtilValidation.getArray(ratioFormulas, 1, "");
      BigDecimal value1 = arithmeticOperation(formula1, seq);
      BigDecimal value2 = arithmeticOperation(formula2, seq);
      if (value2 != null && value2.compareTo(BigDecimal.ZERO) != 0) {
        res = value1.divide(value2, MathContext.DECIMAL128);
      }
      if (res != null) {
        if (StringUtils.isNotBlank(leftConstFormula)) {
          String expr = leftConstFormula + res;
          res = new BigDecimal(engine.eval(expr).toString());
        }
        if (StringUtils.isNotBlank(rightConstFormula)) {
          String expr = res + rightConstFormula;
          res = new BigDecimal(engine.eval(expr).toString());
        }
//        res = res.multiply(new BigDecimal(100));
//        res = res.setScale(roundFull ? 0 : DEFAULT_SCALE, RoundingMode.HALF_UP);
      }
    } catch (Exception e) {
      logger.error("formula=" + formula, e);
    }
    return res;
  }
}
