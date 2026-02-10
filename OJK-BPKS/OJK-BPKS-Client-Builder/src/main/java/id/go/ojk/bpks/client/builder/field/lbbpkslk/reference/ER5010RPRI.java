package id.go.ojk.bpks.client.builder.field.lbbpkslk.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bpks.client.builder.field.EFormLbbpkslk;
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
public enum ER5010RPRI implements IObject<KeyValueString> {
  RPRI0100000000("RPRI0100000000", "Detail"),
  RPRI0200000000("RPRI0200000000", "Total"),;

  @Getter
  private String key;
  private String value;

  public static final int[] POS_TOTAL = { 9, 10, 12, 14 };

  public static String getName() {
    return ER5010RPRI.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5010RPRI.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5010RPRI eEnum : ER5010RPRI.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String genRequiredPos() {
    return RPRI0200000000.key;
  }

  public static String genUniquePos() {
    return RPRI0200000000.key;
  }

  public static String genFieldSave() {
    return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(POS_TOTAL), getObjects());
  }

  public static ConditionalRequired genConditionalExistA() {
    return UtilFieldConditional.genExistPosAndHasReference("M", "N", RPRI0100000000.key, getRefNumber(), "O");
  }

  public static SegmentValidation genValidationTotal() {
    return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(POS_TOTAL), RPRI0200000000.key,
        RPRI0100000000.key, "Total|Penjumlahan detail");
  }

  /* -- ANTAR FORM -- */
  public static SegmentValidation genRowValidation15() {
    String selecPosCode = RPRI0200000000.key;
    String comparatorPosCode = ER5000LPK.LPK0103030000.getKey();
    String errMsg = "Total Saldo|" + ER5000LPK.LPK0103030000.getValue() + " pada form " + EFormLbbpkslk.LPK.getCode();
    return UtilSegmentValidation.genEqualsForm("14", selecPosCode, EFormLbbpkslk.LPK.getCode(), "2", comparatorPosCode, errMsg);
  }
}
