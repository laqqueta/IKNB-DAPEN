package id.go.ojk.bptk.client.builder.field.lpbptkjkk.reference;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.bptk.client.builder.field.EFormLpbptkjkk;
import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER5902RPIU implements IObject<KeyValueString> {
  RPIU0100000000("RPIU0100000000", "Detail"),
  RPIU0200000000("RPIU0200000000", "Total"),;

  @Getter
  private String key;
  private String value;

  public static String getName() {
    return ER5902RPIU.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5902RPIU.class.getSimpleName().substring(2, 6));
  }

  public String getKeyForm() {
    return EFormLpbptkjkk.RPIU.getCode() + key;
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
    for (ER5902RPIU eEnum : ER5902RPIU.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static List<KeyValueString> getObjectsForm() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5902RPIU eEnum : ER5902RPIU.values()) {
      res.add(eEnum.getObjectForm());
    }
    return res;
  }

  public static String genRequiredPos() {
    return RPIU0200000000.key;
  }

  public static String genUniquePos() {
    return RPIU0200000000.key;
  }

  public static String genFieldSave() {
    return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(9, 23), getObjects());
  }

  public static String genFieldSaveForm() {
    return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(new int[] {14, 22}), getObjects());
  }

  public static ConditionalRequired genConditionalExistA() {
    return UtilFieldConditional.genExistPosAndHasReference("M", "N", RPIU0100000000.key, getRefNumber(), "O");
  }

  public static SegmentValidation genValidationTotal() {
    String errMsg = "Total|Penjumlahan detail";
    return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(9, 23), RPIU0200000000.key,
        RPIU0100000000.key, errMsg);
  }

  public static FieldValidation genValidationTotalKelompokUpah() {
    return UtilFieldValidation.genEqualsExceptPosFormula(UtilMetadata.genPlusColumn(9, 13), RPIU0200000000.key);
  }

  public static FieldValidation genValidationTotalPembebananIuran() {
    return UtilFieldValidation.genEqualsExceptPosFormula(UtilMetadata.genPlusColumn(15, 16), RPIU0200000000.key);
  }

  public static FieldValidation genValidationTotalIuranYangDiterima() {
    return UtilFieldValidation.genEqualsExceptPosFormula(UtilMetadata.genPlusColumn(18, 21), RPIU0200000000.key);
  }
}
