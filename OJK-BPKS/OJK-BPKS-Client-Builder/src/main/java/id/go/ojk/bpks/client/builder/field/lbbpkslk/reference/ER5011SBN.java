package id.go.ojk.bpks.client.builder.field.lbbpkslk.reference;

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
public enum ER5011SBN implements IObject<KeyValueString> {
  SBN0100000000("SBN0100000000", "Detail"),
  SBN0200000000("SBN0200000000", "Total"),;

  @Getter
  private String key;
  private String value;

  public static final int[] POS_TOTAL = { 3, 8, 11, 15, 20, 22 };

  public static String getName() {
    return ER5011SBN.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5011SBN.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5011SBN eEnum : ER5011SBN.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String genRequiredPos() {
    return ER5011SBN.SBN0200000000.getKey();
  }

  public static String genUniquePos() {
    return ER5011SBN.SBN0200000000.getKey();
  }

  public static String genFieldSave() {
    return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(POS_TOTAL), getObjects());
  }

  public static ConditionalRequired genConditionalExistA() {
    return UtilFieldConditional.genExistPosAndHasReference("M", "N", SBN0100000000.key, getRefNumber(), "O");
  }

  public static ConditionalRequired genConditionalExistB() {
    return UtilFieldConditional.genExistPosAndHasReference("O", "N", SBN0100000000.key, getRefNumber(), "O");
  }

  public static SegmentValidation genValidationTotal() {
    return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(POS_TOTAL), SBN0200000000.key,
        SBN0100000000.key, "Total|Penjumlahan detail");
  }
}
