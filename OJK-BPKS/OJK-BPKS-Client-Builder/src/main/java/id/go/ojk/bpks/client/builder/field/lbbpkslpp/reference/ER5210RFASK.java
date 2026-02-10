package id.go.ojk.bpks.client.builder.field.lbbpkslpp.reference;

import java.util.ArrayList;
import java.util.List;

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
public enum ER5210RFASK implements IObject<KeyValueString> {
  RFASK0100000000("RFASK0100000000", "Detail"),
  RFASK0200000000("RFASK0200000000", "Total"),;

  @Getter
  private String key;
  private String value;

  public static String getName() {
    return ER5210RFASK.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5210RFASK.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5210RFASK eEnum : ER5210RFASK.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String genRequiredPos() {
    return ER5210RFASK.RFASK0200000000.getKey();
  }

  public static String genUniquePos() {
    return ER5210RFASK.RFASK0200000000.getKey();
  }

  public static String genFieldSave() {
    return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(4, 32), getObjects());
  }

  public static ConditionalRequired genConditionalExistA() {
    return UtilFieldConditional.genExistPosAndHasReference("M", "N", RFASK0100000000.key, getRefNumber(), "O");
  }

  public static SegmentValidation genValidationTotal() {
    return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(4, 32), RFASK0200000000.key,
        RFASK0100000000.key, "Total|Penjumlahan detail");
  }

  public static FieldValidation genFieldValidation33() {
    return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(4, 31), RFASK0100000000.key);
  }
}
