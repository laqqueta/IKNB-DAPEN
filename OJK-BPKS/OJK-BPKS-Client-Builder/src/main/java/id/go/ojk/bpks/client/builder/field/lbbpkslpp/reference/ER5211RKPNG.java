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
public enum ER5211RKPNG implements IObject<KeyValueString> {
  RKPNG0100000000("RKPNG0100000000", "Detail"),
  RKPNG0200000000("RKPNG0200000000", "Total"),;

  @Getter
  private String key;
  private String value;

  public static String getName() {
    return ER5211RKPNG.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5211RKPNG.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5211RKPNG eEnum : ER5211RKPNG.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String genRequiredPos() {
    return ER5211RKPNG.RKPNG0200000000.getKey();
  }

  public static String genUniquePos() {
    return ER5211RKPNG.RKPNG0200000000.getKey();
  }

  public static String genFieldSave() {
    return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(3, 30), getObjects());
  }

  public static ConditionalRequired genConditionalExistA() {
    return UtilFieldConditional.genExistPosAndHasReference("M", "N", RKPNG0100000000.key, getRefNumber(), "O");
  }

  public static FieldValidation genFieldValidation17() {
    return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(3, 15), RKPNG0100000000.key);
  }

  public static FieldValidation genFieldValidation23() {
    return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(17, 21), RKPNG0100000000.key);
  }

  public static FieldValidation genFieldValidation27() {
    return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(23, 25), RKPNG0100000000.key);
  }

  public static FieldValidation genFieldValidation31() {
    return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(27, 29), RKPNG0100000000.key);
  }

  public static SegmentValidation genValidationTotal() {
    return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 30), RKPNG0200000000.key,
        RKPNG0100000000.key, "Total|Penjumlahan detail");
  }
}
