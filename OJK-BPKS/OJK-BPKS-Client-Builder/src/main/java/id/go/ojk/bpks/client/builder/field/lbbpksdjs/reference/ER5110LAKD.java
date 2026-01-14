package id.go.ojk.bpks.client.builder.field.lbbpksdjs.reference;

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
public enum ER5110LAKD implements IObject<KeyValueString> {
  LAKD0100000000("LAKD0100000000", "Detail"),
  LAKD0200000000("LAKD0200000000", "Total"),;

  @Getter
  private String key;
  private String value;

  public static final int[] POS_TOTAL = { 3, 5, 7, 8 };

  public static String getName() {
    return ER5110LAKD.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5110LAKD.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5110LAKD eEnum : ER5110LAKD.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String genRequiredPos() {
    return ER5110LAKD.LAKD0200000000.getKey();
  }

  public static String genUniquePos() {
    return ER5110LAKD.LAKD0200000000.getKey();
  }

  public static String genFieldSave() {
    return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(POS_TOTAL), getObjects());
  }

  public static ConditionalRequired genConditionalExistA() {
    return UtilFieldConditional.genExistPosAndHasReference("M", "N", LAKD0100000000.key, getRefNumber(), "O");
  }

  public static SegmentValidation genValidationTotal() {
    return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(POS_TOTAL), LAKD0200000000.key,
        LAKD0100000000.key, "Total|Penjumlahan detail");
  }

  public static FieldValidation genFieldValidation03() {
    return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genMinusColumn(new int[] { 3, 5, 7 }),
        LAKD0100000000.key);
  }
}
