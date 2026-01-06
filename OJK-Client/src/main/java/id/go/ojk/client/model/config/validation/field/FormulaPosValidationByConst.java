package id.go.ojk.client.model.config.validation.field;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.util.ToStringList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

// Untuk formula seperti (A + B) / 2 atau (A + B) * 2 dsj
@XStreamAlias("FormulaPosValidationByConst")
public class FormulaPosValidationByConst extends FormulaValidation {
  private final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;
  private String refPosCode;
  private String constValue;
  private String constOper;

  public FormulaPosValidationByConst(String parameter) {
    super(parameter);
  }

  public FormulaPosValidationByConst() {
    super();
  }

  @Override
  public FormulaPosValidationByConst initialized() {
    super.initialized();
    refPosCode = getStringParameter("refPosCode");
    constValue = getStringParameter("constValue");
    constOper = getStringParameter("constOper");
    return this;
  }

  @Override
  public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
    if (ToStringList.convert(refPosCode, "|").contains(validationResult.getColumn((1)))) {
      boolean result = false;
      Logger logger = LoggerFactory.getLogger(FormulaValidation.class);
      String fieldNumber = String.valueOf(field.getNumber());
      String fieldValue = validationResult.getColumn(field.getNumber());
      BigDecimal comparatorValue = arithmeticOperation(comparatorFormula, validationResult.rowSplited);
      comparatorValue = operateOnComparatorValue(comparatorValue);
      result = compareValue(fieldValue, comparatorValue);
      if (!result) {
        StringBuilder msg = new StringBuilder(field.getName())
//            .append(Integer.valueOf(fieldNumber) + 1)
            .append(" ").append(operatorFormula.replace("==", "="))
            .append(" (").append(getComparatorMsg(submissionFormat)).append(") ")
            .append(constOper).append(" ").append(constValue);

        logger.error("{" + parameter + "}>" + fieldValue + "?" + comparatorValue);
        validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E50_02_FORMULA, "", msg.toString()));
      } else {
        logger.trace("{" + parameter + "}>" + fieldValue + "?" + comparatorValue);
      }
    }
  }

  private BigDecimal operateOnComparatorValue(BigDecimal comparatorValue) {
    BigDecimal res = BigDecimal.ZERO;
    switch (constOper) {
      case "*":
        res = comparatorValue.multiply(new BigDecimal(constValue));
        break;
      case "/":
        res = comparatorValue.divide(new BigDecimal(constValue));
        break;
      case "+":
        res = comparatorValue.add(new BigDecimal(constValue));
        break;
      case "-":
        res = comparatorValue.subtract(new BigDecimal(constValue));
        break;
      default:
        res = comparatorValue;
        break;
    }
    res.setScale(scale, ROUNDING_MODE);
    return res;
  }

  private String getComparatorMsg(SubmissionFormat submissionFormat) {
    String res = "";
    String[] formulaSplit = comparatorFormula.split("(?<=[-+/*])|(?=[-+/*])");
    int len = formulaSplit.length;
    for (int i = 0; i < len; i++) {
      String str = String.valueOf(formulaSplit[i]);
      String tmp = "";
      if (StringUtils.isNumeric(str)) {
//        tmp = " kolom " + String.valueOf(Integer.parseInt(str) + 1);
        tmp = submissionFormat.getFieldName(Integer.parseInt(str));
      } else if (i + 1 < len) {
        tmp = " " + str + " ";
      }
      res += tmp;
    }
    return res;
  }
}
