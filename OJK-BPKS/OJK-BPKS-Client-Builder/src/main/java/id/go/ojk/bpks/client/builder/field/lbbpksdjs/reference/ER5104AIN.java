package id.go.ojk.bpks.client.builder.field.lbbpksdjs.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bpks.client.builder.field.EFormLbbpksdjs;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER5104AIN implements IObject<KeyValueString> {
  AIN0100000000("AIN0100000000", "a. Deposito"),
  AIN0200000000("AIN0200000000", "b. Surat berharga yang diterbitkan oleh bank indonesia"),
  AIN0300000000("AIN0300000000", "c. Surat berharga yang diterbitkan oleh Negara RI"),
  AIN0400000000("AIN0400000000", "d. Sukuk dan Obligasi"),
  AIN0500000000("AIN0500000000", "Total Investasi"),;

  @Getter
  private String key;
  private String value;

  private static final String LPK = EFormLbbpksdjs.LPK.getCode();

  public static String getName() {
    return ER5104AIN.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5104AIN.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5104AIN eEnum : ER5104AIN.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String genRequiredPos() {
    return UtilMetadata.genPipeRow(getObjects());
  }

  public static String genUniquePos() {
    return UtilMetadata.genPipeRow(getObjects());
  }

  public static String genFieldSave() {
    return UtilMetadata.genFieldSave("2", getObjects());
  }

  public static SegmentValidation genRowValidation06() {
    int[] rows = { 0, 1, 2, 3 };
    String plusRows = UtilMetadata.genPlusRow(getObjects(), rows);
    String plusRowsDesc = UtilMetadata.genPlusDesc(getObjects(), rows);
    return UtilSegmentValidation.genEqualsFormula("2", AIN0500000000.key, plusRows,
        UtilMetadata.genMessage(AIN0500000000.value, plusRowsDesc));
  }

  /* -- ANTAR FORM -- */
  public static SegmentValidation genRowValidation03() {
    String selecPosCode = AIN0200000000.key;
    String comparatorPosCode = ER5100LPK.LPK0111000000.getKey();
    String errMsg = AIN0200000000.value + "|" + ER5100LPK.LPK0111000000.getValue() + " pada form " + LPK;
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, LPK, "2", comparatorPosCode, errMsg);
  }

  public static SegmentValidation genRowValidation04() {
    String selecPosCode = AIN0300000000.key;
    String comparatorPosCode = ER5100LPK.LPK0112000000.getKey();
    String errMsg = AIN0300000000.value + "|" + ER5100LPK.LPK0112000000.getValue() + " pada form " + LPK;
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, LPK, "2", comparatorPosCode, errMsg);
  }
}
