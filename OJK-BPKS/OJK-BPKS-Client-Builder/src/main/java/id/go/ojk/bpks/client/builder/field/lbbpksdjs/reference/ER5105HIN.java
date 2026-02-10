package id.go.ojk.bpks.client.builder.field.lbbpksdjs.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bpks.client.builder.field.EFormLbbpksdjs;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER5105HIN implements IObject<KeyValueString> {
  HIN0100000000("HIN0100000000", "a. Deposito"),
  HIN0200000000("HIN0200000000", "b. Surat berharga yang diterbitkan oleh bank indonesia"),
  HIN0300000000("HIN0300000000", "c. Surat berharga yang diterbitkan oleh Negara RI"),
  HIN0400000000("HIN0400000000", "d. Sukuk dan Obligasi"),
  HIN0500000000("HIN0500000000", "Total Hasil Investasi"),;

  @Getter
  private String key;
  @Getter
  private String value;

  private static final String LPK = EFormLbbpksdjs.LPK.getCode();
  private static final String LAV = EFormLbbpksdjs.LAV.getCode();

  public static String getName() {
    return ER5105HIN.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5105HIN.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5105HIN eEnum : ER5105HIN.values()) {
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
    return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 6), getObjects());
  }

  public static String genFieldSaveForm() {
    return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 6), getObjects());
  }

  public static SegmentValidation genRowValidation06() {
    int[] rows = { 0, 1, 2, 3 };
    KeyValueString posCode = HIN0500000000.getObject();
    String selectFields = UtilMetadata.genDelimitedColumn(new int[] { 2, 3, 4 }, "|");
    String plusRows = UtilMetadata.genPlusRow(getObjects(), rows);
    String plusRowsDesc = UtilMetadata.genPlusDesc(getObjects(), rows);
    return UtilSegmentValidation.genEqualsFormula(selectFields, posCode.getKey(), plusRows,
        UtilMetadata.genMessage(posCode.getValue(), plusRowsDesc));
  }

  public static FieldValidation genFieldValidation6() {
    int[] cols = { 3, 4 };
    return UtilFieldValidation.genEqualsPosByConst(UtilMetadata.genPlusColumn(cols), 2,
        UtilMetadata.genPipeRow(getObjects()), "2", "/");
  }

  public static FieldValidation genFieldValidation7() {
    return UtilFieldValidation.genEqualsRatio("2|5", 2);
  }

  /* -- ANTAR FORM -- */
  public static SegmentValidation genRowValidation03() {
    String selecPosCode = HIN0200000000.key;
    String comparatorPosCode = ER5100LPK.LPK0111000000.getKey();
    String errMsg = HIN0200000000.value + "|" + ER5100LPK.LPK0111000000.getValue() + " pada form " + LPK;
    return UtilSegmentValidation.genEqualsForm("4", selecPosCode, LPK, "2", comparatorPosCode, errMsg);
  }

  public static SegmentValidation genRowValidation04() {
    String selecPosCode = HIN0300000000.key;
    String comparatorPosCode = ER5100LPK.LPK0112000000.getKey();
    String errMsg = HIN0300000000.value + "|" + ER5100LPK.LPK0112000000.getValue() + " pada form " + LPK;
    return UtilSegmentValidation.genEqualsForm("4", selecPosCode, LPK, "2", comparatorPosCode, errMsg);
  }

  public static SegmentValidation genRowValidation06b() {
    String selecPosCode = HIN0500000000.key;
    String comparatorPosCode = ER5101LAV .LAV0106000000.getKey();
    String errMsg = HIN0500000000.value + "|" + ER5101LAV.LAV0106000000.getValue() + " pada form " + LAV;
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, LAV, "2", comparatorPosCode, errMsg);
  }
}
