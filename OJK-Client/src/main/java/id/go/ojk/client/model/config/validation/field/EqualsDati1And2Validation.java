package id.go.ojk.client.model.config.validation.field;

import java.util.Map;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("EqualsDati1And2Validation")
public class EqualsDati1And2Validation extends MapParamFieldValidation {
  private String selectPosCode;
  private String fieldDati1;
  private int referenceNumberDati1;
  private int referenceNumberDati2;

  public EqualsDati1And2Validation() {
    super();
  }

  public EqualsDati1And2Validation(String parameter) {
    setParameter(parameter);
  }

  @Override
  public FieldValidation initialized() {
    selectPosCode = getStringParameter("selectPosCode");
    fieldDati1 = getStringParameter("fieldDati1");
    referenceNumberDati1 = getIntParameter("referenceNumberDati1");
    referenceNumberDati2 = getIntParameter("referenceNumberDati2");
    return this;
  }

  @Override
  public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
    if (selectPosCode.contains(validationResult.getColumn((1)))) {
      ReferenceService referenceService = appCtx.getService(ReferenceService.class);
      Map<String, String> referenceDati1 = referenceService.getReference(referenceNumberDati1);
      Map<String, String> referenceDati2 = referenceService.getReference(referenceNumberDati2);

      String fieldDati1Value = validationResult.getColumn(Integer.valueOf(fieldDati1));
      String fieldDati2Value = validationResult.getColumn(field.getNumber());

      boolean referenceDati1Valid = referenceDati1.containsKey(fieldDati1Value);
      boolean referenceDati2Valid = referenceDati2.containsKey(fieldDati2Value);

      // Execute validate hanya jika referensi DATI 1 & 2 valid
      if (referenceDati1Valid && referenceDati2Valid) {
        String fieldDati2ValueParsed = fieldDati2Value.substring(3, 6);
        String fieldDati1ValueParsed = fieldDati1Value.substring(3, 6);

        if (!fieldDati1ValueParsed.equalsIgnoreCase(fieldDati2ValueParsed)) {
          validationResult.errors.add(
              new ValidationError(field, ValidationErrorCode.E04_20_DATI2_DATI1, fieldDati2Value, fieldDati1Value));
        }
        // TODO: handle Lokasi DATI II = Luar Negeri (LO:e0001) kalau ada
      }
    }
  }

}
