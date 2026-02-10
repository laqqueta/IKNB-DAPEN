package id.go.ojk.bptk.client.builder.field.lbbptkjkp.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER5712SBN implements IObject<KeyValueString> {
  SBN0100000000("SBN0100000000", "Detail"),;

  @Getter
  private String key;
  private String value;

  public static String getName() {
    return ER5712SBN.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5712SBN.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5712SBN eEnum : ER5712SBN.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String genFieldSave() {
    return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(3, 3), getObjects());
  }

  public static SegmentValidation genRowValidation04() {
    String comparatorField = UtilMetadata.genPlusRow(ER5701LPK.getObjectsForm(), 9, 9);
    String fieldName = "Total Saldo SAK";
    String errMsg = UtilMetadata.genMessage(fieldName, UtilMetadata.genPlusDesc(ER5701LPK.getObjects(), 9, 9) + " pada form LPK");
    return UtilSegmentValidation.genEqualsFormulaForm4("3", SBN0100000000.key, "2", comparatorField, errMsg, 2);
  }
}
