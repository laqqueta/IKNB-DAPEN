package id.go.ojk.bptk.client.builder.field.lbbptkbdn.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.lbbptkjkk.reference.ER5401LPK;
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
public enum ER5312SBN implements IObject<KeyValueString> {
  SBN0100000000("SBN0100000000", "Detail"),;

  @Getter
  private String key;
  private String value;

  public static String getName() {
    return ER5312SBN.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5312SBN.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5312SBN eEnum : ER5312SBN.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String genFieldSave() {
    return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(3, 3), getObjects());
  }

  /* -- ANTAR FORM -- */
  public static SegmentValidation genRowValidation03Bdn() {
    int[] rows = { 18, 31 };
    String comparatorField = UtilMetadata.genPlusRow(ER5301LPK.getObjectsForm(), rows);
    String fieldName = "SBN, Saldo SAK";
    String errMsg = UtilMetadata.genMessage(fieldName, UtilMetadata.genPlusDesc(ER5301LPK.getObjects(), rows) + " pada form LPK");
    return UtilSegmentValidation.genEqualsFormulaForm4("3", SBN0100000000.key, "2", comparatorField, errMsg, 2);
  }

  public static SegmentValidation genRowValidation03Jkk() {
    int[] rows = { 8 };
    String comparatorField = UtilMetadata.genPlusRow(ER5401LPK.getObjectsForm(), rows);
    String fieldName = "SBN, Saldo SAK";
    String errMsg = UtilMetadata.genMessage(fieldName,
        UtilMetadata.genPlusDesc(ER5401LPK.getObjects(), rows) + " pada form LPK");
    return UtilSegmentValidation.genEqualsFormulaForm4("3", SBN0100000000.key, "2", comparatorField, errMsg, 2);
  }
}
