package id.go.ojk.bpks.client.builder.field.lbbpksdjs.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER5109RPI implements IObject<KeyValueString> {
  RPI0100000000("RPI0100000000", "Detail"),
  RPI0200000000("RPI0200000000", "Total"),;

  @Getter
  private String key;
  private String value;

  public static final int[] POS_TOTAL = { 5, 12, 13, 14 };

  public static String getName() {
    return ER5109RPI.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5109RPI.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5109RPI eEnum : ER5109RPI.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String genRequiredPos() {
    return ER5109RPI.RPI0200000000.getKey();
  }

  public static String genUniquePos() {
    return ER5109RPI.RPI0200000000.getKey();
  }

  public static String genFieldSave() {
    return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(POS_TOTAL), getObjects());
  }

  public static ConditionalRequired genConditionalExistA() {
    return UtilFieldConditional.genExistPosAndHasReference("M", "N", RPI0100000000.key, getRefNumber(), "O");
  }

  public static ConditionalRequired genConditionalExistB() {
    return UtilFieldConditional.genExistPosAndHasReference("O", "N", RPI0100000000.key, getRefNumber(), "O");
  }

  public static SegmentValidation genValidationTotal() {
    return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(POS_TOTAL), RPI0200000000.key,
        RPI0100000000.key, "Total|Penjumlahan detail");
  }
}
