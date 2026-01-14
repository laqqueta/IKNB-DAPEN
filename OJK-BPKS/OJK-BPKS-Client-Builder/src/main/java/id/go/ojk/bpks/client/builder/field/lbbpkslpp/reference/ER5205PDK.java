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
public enum ER5205PDK implements IObject<KeyValueString> {
  PDK0100000000("PDK0100000000", "Detail"),
  PDK0200000000("PDK0200000000", "Total"),;

  @Getter
  private String key;
  private String value;

  public static String getName() {
    return ER5205PDK.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5205PDK.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5205PDK eEnum : ER5205PDK.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String genRequiredPos() {
    return ER5205PDK.PDK0200000000.getKey();
  }

  public static String genUniquePos() {
    return ER5205PDK.PDK0200000000.getKey();
  }

  public static String genFieldSave() {
    return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(new int[] { 3, 4, 5 }), getObjects());
  }

  public static String genFieldSaveForm() {
    return UtilMetadata.genFieldSave("5", getObjects());
  }

  public static ConditionalRequired genConditionalExistA() {
    return UtilFieldConditional.genExistPosAndHasReference("M", "N", PDK0100000000.key, getRefNumber(), "O");
  }

  public static FieldValidation genFieldValidation07() {
    int[] cols = { 3, 4 };
    return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(cols),
        UtilMetadata.genPipeRow(getObjects()));
  }

  public static SegmentValidation genValidationTotal() {
    return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(new int[] { 3, 4 }), PDK0200000000.key,
        PDK0100000000.key, "Total|Penjumlahan detail");
  }
}
