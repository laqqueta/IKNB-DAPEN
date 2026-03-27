package id.go.ojk.bptk.client.builder.field.lpbptkjp.reference;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.bptk.client.builder.field.EFormLpbptkjp;
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
public enum ER6304RPMF implements IObject<KeyValueString> {
  RPMF0100000000("RPMF0100000000", "Detail"),
  RPMF0200000000("RPMF0200000000", "Total"),;

  @Getter
  private String key;
  private String value;

  public static String getName() {
    return ER6304RPMF.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER6304RPMF.class.getSimpleName().substring(2, 6));
  }

  public String getKeyForm() {
    return EFormLpbptkjp.RPMF.getCode() + key;
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
    for (ER6304RPMF eEnum : ER6304RPMF.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static List<KeyValueString> getObjectsForm() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER6304RPMF eEnum : ER6304RPMF.values()) {
      res.add(eEnum.getObjectForm());
    }
    return res;
  }

  public static String genRequiredPos() {
    return RPMF0200000000.key;
  }

  public static String genUniquePos() {
    return RPMF0200000000.key;
  }

  public static String genFieldSave() {
    return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(9, 23), getObjects());
  }

  public static String genFieldSaveForm() {
    return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(15, 23), getObjects());
  }

  public static ConditionalRequired genConditionalExistA() {
    return UtilFieldConditional.genExistPosAndHasReference("M", "N", RPMF0100000000.key, getRefNumber(), "O");
  }

  public static SegmentValidation genValidationTotal() {
    String errMsg = "Total|Penjumlahan detail";
    return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(9, 23), RPMF0200000000.key,
        RPMF0100000000.key, errMsg);
  }

  public static FieldValidation genValidationTotalJenisManfaat() {
    return UtilFieldValidation.genEqualsExceptPosFormula(UtilMetadata.genPlusColumn(9, 14), RPMF0200000000.key);
  }

  public static FieldValidation genDati2Validation() {
    return UtilFieldValidation.getEqualsDati2And1(RPMF0100000000.key, 7, ER1157LokasiDati1.getRefNumber(),
        ER1135LokasiDati2.getRefNumber());
  }
}
