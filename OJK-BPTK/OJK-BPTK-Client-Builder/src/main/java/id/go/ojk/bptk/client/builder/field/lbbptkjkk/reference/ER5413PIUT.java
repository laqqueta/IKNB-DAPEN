package id.go.ojk.bptk.client.builder.field.lbbptkjkk.reference;

import java.util.ArrayList;
import java.util.List;

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
public enum ER5413PIUT implements IObject<KeyValueString> {
  PIUT0100000000("PIUT0100000000", "Detail"),;

  @Getter
  private String key;
  private String value;

  public static String getName() {
    return ER5413PIUT.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5413PIUT.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5413PIUT eEnum : ER5413PIUT.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String genFieldSave() {
    return UtilMetadata.genFieldSave("13", getObjects());
  }

  /* -- ANTAR FORM -- */
  public static SegmentValidation genRowValidation14() {
    int[] rows = { 1, 2, 3, 4, 5 };
    String comparatorField = UtilMetadata.genPlusRow(ER5401LPK.getObjectsForm(), rows);
    String errMsg = UtilMetadata.genMessage("Total Saldo", UtilMetadata.genPlusDesc(ER5401LPK.getObjects(), rows) + " pada form LPK");
    return UtilSegmentValidation.genEqualsFormulaForm4("13", PIUT0100000000.key, "2", comparatorField, errMsg, 2);
  }
}
