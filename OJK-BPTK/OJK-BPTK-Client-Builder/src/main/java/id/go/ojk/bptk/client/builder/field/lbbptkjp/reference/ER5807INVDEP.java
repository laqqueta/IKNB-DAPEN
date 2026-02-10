package id.go.ojk.bptk.client.builder.field.lbbptkjp.reference;

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
public enum ER5807INVDEP implements IObject<KeyValueString> {
  INVDEP0100000000("INVDEP0100000000", "Detail"),
  INVDEP0200000000("INVDEP0200000000", "Total"),;;

  @Getter
  private String key;
  private String value;

  public static final int[] ROW_TOTAL = { 10, 16, 17, 18 };

  public static String getName() {
    return ER5807INVDEP.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5807INVDEP.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5807INVDEP eEnum : ER5807INVDEP.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String genRequiredPos() {
    return INVDEP0200000000.key;
  }

  public static String genUniquePos() {
    return INVDEP0200000000.key;
  }

  public static String genFieldSave() {
    return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(new int[] { 10, 11, 12, 13, 14, 16, 17, 18 }),
        getObjects());
  }
  
  public static FieldValidation genFieldValidation11() {
    return UtilFieldValidation.genGreaterValue("0");
  }

  public static FieldValidation genFieldValidation13() {
    return UtilFieldValidation.genDateLess("13");
  }

  public static FieldValidation genFieldValidation14() {
    return UtilFieldValidation.genDateGreater("12");
  }

  public static FieldValidation genFieldValidation15() {
    return UtilFieldValidation.genGreaterValue("1");
  }

  public static FieldValidation genFieldValidation18() {
    int[] cols = { 10, 16, 17 };
    String msgError = "Kolom 19 | Kolom 11 - (Kolom 17 + Kolom 18)";
    return UtilFieldValidation.genEqualsPosFormula2(UtilMetadata.genMinusColumn(cols), INVDEP0100000000.key, msgError);
  }

  public static ConditionalRequired genConditionalExist17() {
    return UtilFieldConditional.genAllExistPosAndInReference("N", "M", "17", INVDEP0100000000.key, getRefNumber());
  }

  public static ConditionalRequired genConditionalExist18() {
    return UtilFieldConditional.genAllExistPosAndInReference("N", "M", "16", INVDEP0100000000.key, getRefNumber());
  }

  public static ConditionalRequired genConditionalExistA() {
    return UtilFieldConditional.genExistPosAndHasReference("M", "N", INVDEP0100000000.key, getRefNumber(), "O");
  }

  public static SegmentValidation genValidationTotal() {
    return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(ROW_TOTAL), INVDEP0200000000.key,
        INVDEP0100000000.key, "Total|Penjumlahan detail");
  }

  public static FieldValidation genFieldValidation05() {
    return UtilFieldValidation.genReferenceConditionPos("5", "1192", UtilMetadata.genPipeRow(getObjects(), new int[] {0}));
  }
}
