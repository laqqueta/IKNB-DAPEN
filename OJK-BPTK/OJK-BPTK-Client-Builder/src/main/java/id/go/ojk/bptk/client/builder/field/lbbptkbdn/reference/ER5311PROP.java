package id.go.ojk.bptk.client.builder.field.lbbptkbdn.reference;

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
public enum ER5311PROP implements IObject<KeyValueString> {
  PROP0100000000("PROP0100000000", "Detail");

  @Getter
  private String key;
  private String value;

  public static final int[] ROW_TOTAL = { 17 };

  public static String getName() {
    return ER5311PROP.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5311PROP.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5311PROP eEnum : ER5311PROP.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static String genFieldSave() {
    return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(new int[] { 11, 12, 13, 15, 17 }), getObjects());
  }

  /* -- ANTAR FORM -- */
  public static SegmentValidation genRowValidation18() {
    int[] rows = { 34 };
    String comparatorField = UtilMetadata.genPlusRow(ER5301LPK.getObjectsForm(), rows);
    String errMsg = UtilMetadata.genMessage("Total Saldo", UtilMetadata.genPlusDesc(ER5301LPK.getObjects(), rows) + " pada form LPK");
    return UtilSegmentValidation.genEqualsFormulaForm4("17", PROP0100000000.key, "2", comparatorField, errMsg, 2);
  }
}
