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
public enum ER5208RKPI implements IObject<KeyValueString> {
  RKPI0100000000("RKPI0100000000", "Detail"),
  RKPI0200000000("RKPI0200000000", "Total"),;

  @Getter
  private String key;
  private String value;

  public static String getName() {
    return ER5208RKPI.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5208RKPI.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5208RKPI eEnum : ER5208RKPI.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String getRequiredPos() {
    return ER5208RKPI.RKPI0200000000.getKey();
  }

  public static String getUniquePos() {
    return ER5208RKPI.RKPI0200000000.getKey();
  }

  public static String genFieldSave() {
    return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(6, 11), getObjects());
  }

  public static ConditionalRequired genConditionalExistA() {
    return UtilFieldConditional.genExistPosAndHasReference("M", "N", RKPI0100000000.key, getRefNumber(), "O");
  }

  public static SegmentValidation genValidationTotal() {
    return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(6, 11), RKPI0200000000.key,
        RKPI0100000000.key, "Total|Penjumlahan detail");
  }
}
