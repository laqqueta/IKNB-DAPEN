package id.go.ojk.bptk.client.builder.field.lbbptkjkk.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.lbbptkjkm.reference.ER5501LPK;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER5405AI implements IObject<KeyValueString> {
  AI0100000000("AI0100000000", "Deposito"),
  AI0200000000("AI0200000000", "Surat berharga yang diterbitkan oleh Bank Indonesia"),
  AI0300000000("AI0300000000", "Surat berharga yang diterbitkan oleh Negara RI"),
  AI0400000000("AI0400000000", "Saham yang tercatat di bursa"),
  AI0500000000("AI0500000000", "Sukuk korporasi"),
  AI0600000000("AI0600000000", "Obligasi korporasi"),
  AI0700000000("AI0700000000", "Reksadana"),
  AI0800000000("AI0800000000", "Kontrak investasi kolektif efek beragun aset"),
  AI0900000000("AI0900000000", "Repurchase agreement (Repo)"),
  AI1000000000("AI1000000000", "Lainnya"),
  AI1100000000("AI1100000000", "TOTAL INVESTASI"),;

  @Getter
  private String key;
  private String value;

  public static String getName() {
    return ER5405AI.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5405AI.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5405AI eEnum : ER5405AI.values()) {
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

  public static SegmentValidation genRowValidation12a() {
    IObject<KeyValueString> pos = AI1100000000;
    return UtilSegmentValidation.genEqualsFormula("2", pos.getObject().getKey(),
        UtilMetadata.genPlusRow(getObjects(), 0, 9),
        UtilMetadata.genMessage(pos.getObject().getValue(), UtilMetadata.genPlusDesc(getObjects(), 0, 9)));
  };

  /* -- ANTAR FORM -- */
  public static SegmentValidation genRowValidation12Jkk() {
    int[] rows = { 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
    String comparatorField = UtilMetadata.genPlusRow(ER5401LPK.getObjectsForm(), rows);
    String errMsg = UtilMetadata.genMessage(AI1100000000.value,
        UtilMetadata.genPlusDesc(ER5401LPK.getObjects(), rows) + " pada form LPK");
    return UtilSegmentValidation.genEqualsFormulaForm("2", AI1100000000.key, "2", comparatorField, errMsg, 2);
  }

  public static SegmentValidation genRowValidation12Jkm() {
    int[] rows = { 6, 7, 8, 9, 10, 11, 12, 13, 14 };
    String comparatorField = UtilMetadata.genPlusRow(ER5501LPK.getObjectsForm(), rows);
    String errMsg = UtilMetadata.genMessage(AI1100000000.value,
        UtilMetadata.genPlusDesc(ER5501LPK.getObjects(), rows) + " pada form LPK");
    return UtilSegmentValidation.genEqualsFormulaForm("2", AI1100000000.key, "2", comparatorField, errMsg, 2);
  }
}
