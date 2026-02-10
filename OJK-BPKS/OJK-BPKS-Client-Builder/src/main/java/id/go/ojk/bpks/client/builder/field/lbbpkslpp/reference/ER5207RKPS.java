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
public enum ER5207RKPS implements IObject<KeyValueString> {
  RKPS0100000000("RKPS0100000000", "Detail"),
  RKPS0200000000("RKPS0200000000", "Total"),;

  @Getter
  private String key;
  private String value;

  public static String getName() {
    return ER5207RKPS.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5207RKPS.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5207RKPS eEnum : ER5207RKPS.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String genRequiredPos() {
    return ER5207RKPS.RKPS0200000000.getKey();
  }

  public static String genUniquePos() {
    return ER5207RKPS.RKPS0200000000.getKey();
  }

  public static String genFieldSave() {
    return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(8, 12), getObjects());
  }

  public static ConditionalRequired genConditionalExistA() {
    return UtilFieldConditional.genExistPosAndHasReference("M", "N", RKPS0100000000.key, getRefNumber(), "O");
  }

  public static FieldValidation genFieldValidation13() {
    int[] cols = { 10, 11 };
    return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(cols),
        UtilMetadata.genPipeRow(getObjects()));
  }

  public static SegmentValidation genValidationTotal() {
    return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(new int[] { 8, 9, 10, 11 }),
        RKPS0200000000.key, RKPS0100000000.key, "Total|Penjumlahan detail");
  }
}
