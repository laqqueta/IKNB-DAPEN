package id.go.ojk.client.model.config.validation.segmen;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import javax.script.ScriptEngine;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.util.ToBigDecimal;

import com.google.common.util.concurrent.AtomicDouble;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.context.ApplicationContextClient;
import id.go.ojk.client.service.validation.ValidationService;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import lombok.extern.slf4j.Slf4j;
/*
 * Compare antar form yang tidak mempunyai row total
 */

@XStreamAlias("ComparisonFormulaFormValidation4")
@Slf4j
public class ComparisonFormulaFormValidation4 extends ComparisonFormulaFormValidation {
  private AtomicDouble sumValue;
  private AtomicInteger counterValue;
  private static List<ValidationResult> validationResults;

  @Override
  public void load(SubmissionFormat submissionFormat) {
    //reset/renew variables untuk tiap form.
    sumValue = new AtomicDouble();
    counterValue = new AtomicInteger();
    validationResults = new ArrayList<ValidationResult>();
  }

  public ComparisonFormulaFormValidation4() {
    super();
  }

  public ComparisonFormulaFormValidation4(String parameter) {
    super(parameter);
  }


  @Override
  public synchronized void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
    validationResults.add(validationResult);
    int totalDetailRow = submissionFormat.getTotalRow() - 1;
    int currentDetailRow = counterValue.incrementAndGet();

    List<String> listSelectPosCode = Arrays.asList(StringUtils.split(selectPosCode, "|"));
    String posCode = validationResult.getColumn(1);
    String[] arrSelectField = StringUtils.split(selectField, "|");

    if (StringUtils.isNotEmpty(posCode) && listSelectPosCode.contains(posCode)) {
      for (int i = 0; i < arrSelectField.length; i++) {
        String idxSelectField = arrSelectField[i];
        Object selectValue = getSelectValue(validationResult, idxSelectField);
        if (!Objects.isNull(selectValue)) {
          sumValue.addAndGet(toBigDecimal(selectValue).doubleValue());
        }

        log.trace("totalDetailRow={}, currentDetailRow={}, selectValue={}, sumValue={}", totalDetailRow, currentDetailRow, selectValue, sumValue.get());
        if (currentDetailRow >= totalDetailRow) {
          BigDecimal totalValue = BigDecimal.valueOf(sumValue.get());
          Object comparatorValue = getComparatorValue(idxSelectField);
          ScriptEngine engine = ApplicationContextClient.getInstance().getService(ValidationService.class).getScriptEngine();
          if (!compareValue(engine, totalValue, comparatorValue)) {
            log.error("{}>{}?{}", parameter, totalValue.toPlainString(), comparatorValue);

            ValidationError validationError = new ValidationError(submissionFormat.getFields().get(Integer.valueOf(idxSelectField)), ValidationErrorCode.E50_02_FORMULA, String.valueOf(comparatorValue), 
                StringUtils.replace(msgError, "|", " " + operatorFormula.replace("==", "=") + " "));

            // Simpen error di baris terakhir
            validationResults.stream().max(Comparator.comparingInt(v -> v.lineNumber)).ifPresent(v -> {
              v.errors.add(validationError);
            });
          } else {
            log.trace("{}>{}?{}", parameter, totalValue.toPlainString(), comparatorValue);
          }
        }
      }
    }
  }

  private BigDecimal toBigDecimal(Object selectValue) {
    String stringValue = (selectValue != null) ? String.valueOf(selectValue) : null;
    BigDecimal bdValue = ToBigDecimal.convert(stringValue);
    bdValue.setScale(scale, RoundingMode.HALF_UP);
    return bdValue;
  }
}
