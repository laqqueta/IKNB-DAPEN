package id.go.ojk.client.model.config.validation.field;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;

/*
 * Copy from FormulaValidation with custom error message from caller
 */
@XStreamAlias("FormulaValidation3")
public class FormulaValidation3 extends BaseFieldFormulaValidation {
  protected String msgError;
  protected int scale;
  protected String fixedValue;

  public FormulaValidation3(String parameter) {
    super(parameter);
  }

  public FormulaValidation3() {
    super();
  }

  @Override
  public FormulaValidation3 initialized() {
    super.initialized();
    scale = getIntParameter("scale", 0);
    msgError = getStringParameter("msgError");
    fixedValue = getStringParameter("fixedValue");
    return this;
  }

  @Override
  public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
    boolean result = false;
    Logger logger = LoggerFactory.getLogger(FormulaValidation3.class);
    BigDecimal fieldValue = new BigDecimal(fixedValue);
    BigDecimal comparatorValue = arithmeticOperation(comparatorFormula, validationResult.rowSplited);
    result = compareValue(fieldValue, comparatorValue);
    if (!result) {
      String msg = getComparatorMsg();
      if (StringUtils.isNotBlank(msgError)) {
        msg = msgError.replace("|", "=");
      }
      logger.error("{" + parameter + "}>" + fieldValue + "?" + comparatorValue);
      validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E50_20_FORMULA_TOTAL, msg, fixedValue.concat("%")));
    } else {
      logger.trace("{" + parameter + "}>" + fieldValue + "?" + comparatorValue);
    }
  }

  @Override
  protected BigDecimal arithmeticOperation(String formula, String[] fields) {
    BigDecimal res = super.arithmeticOperation(formula, fields);
    if (res != null) {
      res = res.setScale(scale, RoundingMode.HALF_UP);
    }
    return res;
  }

  private String getComparatorMsg() {
    String res = "";
    String[] formulaSplit = comparatorFormula.split("(?<=[-+/*])|(?=[-+/*])");
    int len = formulaSplit.length;
    for (int i = 0; i < len; i++) {
      String str = String.valueOf(formulaSplit[i]);
      String tmp = "";
      if (StringUtils.isNumeric(str)) {
        tmp = " kolom " + String.valueOf(Integer.parseInt(str) + 1);
      } else if (i + 1 < len) {
        tmp = " " + str;
      }
      res += tmp;
    }
    return res;
  }
}
