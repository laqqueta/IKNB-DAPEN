package id.go.ojk.bptk.client.builder.field.lbbptkjkp.reference;

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
public enum ER5706HAI implements IObject<KeyValueString> {
  HAI0100000000("HAI0100000000","Deposito"),
  HAI0200000000("HAI0200000000","Surat berharga yang diterbitkan oleh Bank Indonesia"),
  HAI0300000000("HAI0300000000","Surat berharga yang diterbitkan oleh Negara RI"),
  HAI0400000000("HAI0400000000","Saham yang tercatat di bursa"),
  HAI0500000000("HAI0500000000","Sukuk korporasi"),
  HAI0600000000("HAI0600000000","Obligasi korporasi"),
  HAI0700000000("HAI0700000000","Reksadana"),
  HAI0800000000("HAI0800000000","Kontrak investasi kolektif efek beragun aset"),
  HAI0900000000("HAI0900000000","Repurchase agreement (Repo)"),
  HAI1000000000("HAI1000000000","Lainnya"),
  HAI1100000000("HAI1100000000","TOTAL INVESTASI"),;

  @Getter
  private String key;
  private String value;

  public static final String POS_SALDO = "2|3|4|5";

  public static String getName() {
    return ER5706HAI.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5706HAI.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5706HAI eEnum : ER5706HAI.values()) {
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

  public static FieldValidation genFieldValidation6() {
    int[] cols = { 3, 4 };
    return UtilFieldValidation.genEqualsPosByConst(UtilMetadata.genPlusColumn(cols), 2,
        UtilMetadata.genPipeRow(getObjects(), 0, 9), "2", "/");
  }

  public static FieldValidation genFieldValidation07() {
    String refPosCode = UtilMetadata.genPipeRow(getObjects());
    return UtilFieldValidation.genEqualsPosRatio("2|5", refPosCode, 2);
  };

  public static SegmentValidation genRowValidation12() {
    return UtilSegmentValidation.genEqualsFormula("2|3|4|5", HAI1100000000.getObject().getKey(),
        UtilMetadata.genPlusRow(getObjects(), 0, 9),
        UtilMetadata.genMessage(HAI1100000000.getObject().getValue(), UtilMetadata.genPlusDesc(getObjects(), 0, 9)));
  }
}
