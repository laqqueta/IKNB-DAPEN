package id.go.ojk.bpks.client.builder.field.lbbpkslpp.reference;

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
public enum ER5209RKLM implements IObject<KeyValueString> {
  RKLM0100000000("RKLM0100000000", "Detail"),
  RKLM0200000000("RKLM0200000000", "Total"),;

  @Getter
  private String key;
  private String value;

  public static String getName() {
    return ER5209RKLM.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5209RKLM.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5209RKLM eEnum : ER5209RKLM.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String genRequiredPos() {
    return ER5209RKLM.RKLM0200000000.getKey();
  }

  public static String genUniquePos() {
    return ER5209RKLM.RKLM0200000000.getKey();
  }

  public static String genFieldSave() {
    return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(8, 9), getObjects());
  }

  public static ConditionalRequired genConditionalExistA() {
    return UtilFieldConditional.genExistPosAndHasReference("M", "N", RKLM0100000000.key, getRefNumber(), "O");
  }

  public static SegmentValidation genValidationTotal() {
    return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(8, 9), RKLM0200000000.key,
        RKLM0100000000.key, "Total|Penjumlahan detail");
  }
}
