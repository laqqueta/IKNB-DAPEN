package id.go.ojk.bptk.client.builder.field.lpbptkjht.reference;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.bptk.client.builder.field.EFormLpbptkjht;
import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1157LokasiDati1;
import id.go.ojk.conf.client.field.reference.ER1135LokasiDati2;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER6103RDJHT implements IObject<KeyValueString> {
  RDJHT0100000000("RDJHT0100000000", "Detail"),
  RDJHT0200000000("RDJHT0200000000", "Total"),;

  @Getter
  private String key;
  private String value;

  public static String getName() {
    return ER6103RDJHT.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER6103RDJHT.class.getSimpleName().substring(2, 6));
  }

  public String getKeyForm() {
    return EFormLpbptkjht.RDJHT.getCode() + key;
  }

  public String getValue() {
    String marker = ". ";
    value = StringUtils.strip(value, "-").trim();
    int idx = value.indexOf(marker);
    return idx > -1 ? value.substring(idx + 1).trim() : value;
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public KeyValueString getObjectForm() {
    return new KeyValueString(getKeyForm(), getValue(), new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER6103RDJHT eEnum : ER6103RDJHT.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static List<KeyValueString> getObjectsForm() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER6103RDJHT eEnum : ER6103RDJHT.values()) {
      res.add(eEnum.getObjectForm());
    }
    return res;
  }

  public static String genRequiredPos() {
    return RDJHT0200000000.key;
  }

  public static String genUniquePos() {
    return RDJHT0200000000.key;
  }

  public static String genFieldSave() {
    return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(9, 14), getObjects());
  }
  
  public static String genFieldSaveForm() {
    return UtilMetadata.genFieldSave("14", getObjects());
  }

  public static ConditionalRequired genConditionalExistA() {
    return UtilFieldConditional.genExistPosAndHasReference("M", "N", RDJHT0100000000.key, getRefNumber(), "O");
  }

  public static SegmentValidation genValidationTotal() {
    String errMsg = "Total|Penjumlahan detail";
    return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(9, 14), RDJHT0200000000.key,
        RDJHT0100000000.key, errMsg);
  }

  public static FieldValidation genValidationSaldoAkhir() {
    return UtilFieldValidation.genEqualsExceptPosFormula(UtilMetadata.genPlusColumn(9, 13), RDJHT0200000000.key);
  }

  public static FieldValidation genDati2Validation() {
    return UtilFieldValidation.getEqualsDati2And1(RDJHT0100000000.key, 7, ER1157LokasiDati1.getRefNumber(),
        ER1135LokasiDati2.getRefNumber());
  }
}
