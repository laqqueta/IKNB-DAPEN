package id.go.ojk.client.model.config.validation.conditional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.RequiredCondition;

/*
 * Copy dari ConditionalPosAndComparatorHasValue
 * 1. Cek kode komponen (khusus multi) dalam validationResult ada di referensi
 * 2. Tampilkan conditional valuenya ketika error validasi
 * 3. Support multiple comparator values
 */

@XStreamAlias("ConditionalPosAndComparatorHasValue2")
public class ConditionalPosAndComparatorHasValue2 extends MapParamConditionalRequired {
  private RequiredCondition trueCondition;
  private RequiredCondition falseCondition;
  private RequiredCondition posFalseCondition;
  private String refPosCode;
  private int referenceNumber;
  private int comparatorField;
  private String comparatorValue;

  public ConditionalPosAndComparatorHasValue2() {
  }

  public ConditionalPosAndComparatorHasValue2(String parameter) {
    setParameter(parameter);
  }

  @Override
  public ConditionalPosAndComparatorHasValue2 initialized() {
    trueCondition = getRequiredConditionParameter("trueCondition");
    falseCondition = getRequiredConditionParameter("falseCondition");
    posFalseCondition = getRequiredConditionParameter("posFalseCondition");
    refPosCode = getStringParameter("refPosCode");
    referenceNumber = getIntParameter("referenceNumber");
    comparatorField = getIntParameter("comparatorField");
    comparatorValue = getStringParameter("comparatorValue");
    return this;
  }

  @Override
  public Tupple2<RequiredCondition, String> analizeRequiredCondition(SubmissionFormat submissionFormat,
      ValidationResult validationResult) {
    ReferenceService referenceService = appCtx.getService(ReferenceService.class);
    Map<String, String> referenceMap = referenceService.getReference(referenceNumber);

    RequiredCondition result = falseCondition;
    String posCode = validationResult.getColumn(1);
    String message = "";
    String message2 = " tidak terisi ";

    if (referenceMap != null) {
      if (!referenceMap.containsKey(posCode)) {
        result = RequiredCondition.O;
      } else {
        if (!hasPosCode(posCode)) {
          result = posFalseCondition;
        } else {
          if (comparatorHasValue(validationResult)) {
            result = trueCondition;
            message2 = " terisi ";
          }
          // message = "kolom ke " + (comparatorField + 1) + message2;
          message = "'" + submissionFormat.getFieldName(comparatorField) + "'" + message2;
          message = message + formatString(comparatorValue, " atau ");

          if (result.equals(RequiredCondition.N) && StringUtils.isNotEmpty(message)) {
            message = "jika " + message;
          }
        }
      }
    }

    Tupple2<RequiredCondition, String> tupple = Tupple2.<RequiredCondition, String>builder().a(result).b(message).build();
    return tupple;
  }

  private boolean hasPosCode(String posCode) {
    List<String> list = Arrays.asList(StringUtils.split(refPosCode, "|"));
    return StringUtils.isNotEmpty(posCode) && list.contains(posCode);
  }

  private boolean comparatorHasValue(ValidationResult validationResult) {
    String value = validationResult.getColumn(comparatorField);
    List<String> comparatorValues = Arrays.asList(StringUtils.split(comparatorValue, "|"));
    return StringUtils.isNotEmpty(value) && comparatorValues.contains(value);
  }

  private static String formatString(String inputString, String separator) {
    if (inputString == null || inputString.isEmpty()) {
      return "";
    }
    List<String> elements = Arrays.asList(inputString.split("\\|"));
    int size = elements.size();

    if (size == 1) {
      return elements.get(0);
    } else if (size == 2) {
      return elements.get(0) + separator + elements.get(1);
    } else if (size > 2) {
      List<String> initialElements = elements.subList(0, size - 1);
      String lastElement = elements.get(size - 1);
      String initialPart = initialElements.stream().collect(Collectors.joining(", "));
      return initialPart + separator + lastElement;
    }

    return inputString;
  }
}
