package id.go.ojk.client.model.config.validation.conditional;

import java.util.Map;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.RequiredCondition;

/*
 * Jika value tidak terdapat di referensi 'referenceNumber', maka return 'referenceFalseCondition'
 * sebagai trueCondition.
 * Jika value terdapat di referensi 'referenceNumber', atau 'referenceNumber' tidak ditemukan,
 * maka teruskan seperti validasi ExistPosConditional
 */
@XStreamAlias("ExistPosAndInReferenceConditional")
public class ExistPosAndInReferenceConditional extends MapParamConditionalRequired {
  private RequiredCondition trueCondition;
  private RequiredCondition falseCondition;
  private String refPosCode;
  private int referenceNumber;
  private RequiredCondition referenceFalseCondition;

  public ExistPosAndInReferenceConditional() {
  }

  public ExistPosAndInReferenceConditional(String parameter) {
    setParameter(parameter);
  }

  @Override
  public ExistPosAndInReferenceConditional initialized() {
    this.trueCondition = getRequiredConditionParameter("trueCondition");
    this.falseCondition = getRequiredConditionParameter("falseCondition");
    this.refPosCode = getStringParameter("refPosCode");
    this.referenceNumber = getIntParameter("referenceNumber");
    this.referenceFalseCondition = getRequiredConditionParameter("referenceFalseCondition");
    return this;
  }

  @Override
  public Tupple2<RequiredCondition, String> analizeRequiredCondition(SubmissionFormat submissionFormat, ValidationResult validationResult) {
    ReferenceService referenceService = appCtx.getService(ReferenceService.class);
    Map<String, String> referenceMap = referenceService.getReference(referenceNumber);
    String[] arrRefPosCode = refPosCode.split("[|]");
    RequiredCondition result = falseCondition;
    String rowValue = validationResult.getColumn(1);
    for (String posCode : arrRefPosCode) {
      if (referenceMap != null) {
        if (!referenceMap.containsKey(rowValue)) {
          result = referenceFalseCondition;
          break;
        }
      }
      if (rowValue.equals(posCode)) {
        result = trueCondition;
        break;
      }
    }
    return Tupple2.<RequiredCondition, String>builder().a(result).b("").build();
  }
}
