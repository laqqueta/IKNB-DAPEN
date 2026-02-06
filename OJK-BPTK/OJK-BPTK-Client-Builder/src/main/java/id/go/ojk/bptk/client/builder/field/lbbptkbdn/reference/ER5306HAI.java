package id.go.ojk.bptk.client.builder.field.lbbptkbdn.reference;

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
public enum ER5306HAI implements IObject<KeyValueString> {
  HAI0100000000("HAI0100000000", "Investasi Setara Kas"),
  HAI0101000000("HAI0101000000", "Investasi Setara Kas, Deposito"),
  HAI0102000000("HAI0102000000", "Investasi Setara Kas, Sertifikat Deposito"),
  HAI0103000000("HAI0103000000", "Investasi Setara Kas, Deposito on call"),
  HAI0200000000("HAI0200000000", "Investasi Jangka Pendek"),
  HAI0201000000("HAI0201000000", "Investasi Jangka Pendek, Deposito"),
  HAI0202000000("HAI0202000000", "Investasi Jangka Pendek, Sertifikat Deposito"),
  HAI0203000000("HAI0203000000", "Investasi Jangka Pendek, Saham yang tercatat di bursa"),
  HAI0204000000("HAI0204000000", "Investasi Jangka Pendek, Surat utang korporasi & sukuk korporasi"),
  HAI0205000000("HAI0205000000", "Investasi Jangka Pendek, Surat berharga yang diterbitkan oleh Negara RI"),
  HAI0206000000("HAI0206000000", "Investasi Jangka Pendek, Surat berharga yang diterbitkan oleh Bank Indonesia"),
  HAI0207000000("HAI0207000000", "Investasi Jangka Pendek, Reksa dana"),
  HAI0208000000("HAI0208000000", "Investasi Jangka Pendek, Kontrak investasi kolektif efek beragun aset"),
  HAI0209000000("HAI0209000000", "Investasi Jangka Pendek, Dana investasi real estat"),
  HAI0210000000("HAI0210000000", "Investasi Jangka Pendek, Repurchase agreement (repo)"),
  HAI0211000000("HAI0211000000", "Investasi Jangka Pendek, Lainnya"),
  HAI0300000000("HAI0300000000", "Investasi Jangka Panjang"),
  HAI0301000000("HAI0301000000", "Investasi Jangka Panjang, Deposito"),
  HAI0302000000("HAI0302000000", "Investasi Jangka Panjang, Sertifikat Deposito"),
  HAI0303000000("HAI0303000000", "Investasi Jangka Panjang, Surat utang korporasi & sukuk korporasi"),
  HAI0304000000("HAI0304000000", "Investasi Jangka Panjang, Surat berharga yang diterbitkan oleh Negara RI"),
  HAI0305000000("HAI0305000000", "Investasi Jangka Panjang, Surat berharga yang diterbitkan oleh Bank Indonesia"),
  HAI0306000000("HAI0306000000", "Investasi Jangka Panjang, Reksa dana"),
  HAI0307000000("HAI0307000000", "Investasi Jangka Panjang, Penyertaan langsung"),
  HAI0308000000("HAI0308000000", "Investasi Jangka Panjang, Kontrak investasi kolektif efek beragun aset"),
  HAI0309000000("HAI0309000000", "Investasi Jangka Panjang, Dana investasi real estat"),
  HAI0310000000("HAI0310000000", "Investasi Jangka Panjang, Lainnya"),
  HAI0400000000("HAI0400000000", "Investasi pada Entitas Asosiasi dan Entitas Anak"),
  HAI0401000000("HAI0401000000", "Investasi pada Entitas Asosiasi dan Entitas Anak, Penyertaan langsung"),
  HAI0402000000("HAI0402000000", "Investasi pada Entitas Asosiasi dan Entitas Anak, Saham yang tercatat di bursa"),
  HAI0500000000("HAI0500000000", "Investasi pada Properti"),
  HAI0501000000("HAI0501000000", "Investasi pada Properti, Tanah"),
  HAI0502000000("HAI0502000000", "Investasi pada Properti, Bangunan"),
  HAI0503000000("HAI0503000000", "Investasi pada Properti, Tanah dengan bangunan"),
  HAI0600000000("HAI0600000000", "Lainnya"),
  HAI0700000000("HAI0700000000", "Total Invenstasi"),;

  @Getter
  private String key;
  private String value;

  public static final String POS_SALDO = "2|3|4";

  public static String getName() {
    return ER5306HAI.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5306HAI.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5306HAI eEnum : ER5306HAI.values()) {
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

  public static SegmentValidation genRowValidation02() {
    int[] rows = { 1, 2, 3 };
    return genPlusValidation(POS_SALDO, HAI0100000000, rows);
  };

  public static SegmentValidation genRowValidation06() {
    int[] rows = { 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
    return genPlusValidation(POS_SALDO, HAI0200000000, rows);
  };

  public static SegmentValidation genRowValidation18() {
    int[] rows = { 17, 18, 19, 20, 21, 22, 23, 24, 25, 26 };
    return genPlusValidation(POS_SALDO, HAI0300000000, rows);
  };

  public static SegmentValidation genRowValidation29() {
    int[] rows = { 28, 29 };
    return genPlusValidation(POS_SALDO, HAI0400000000, rows);
  };

  public static SegmentValidation genRowValidation32() {
    int[] rows = { 31, 32, 33 };
    return genPlusValidation(POS_SALDO, HAI0500000000, rows);
  };

  public static SegmentValidation genRowValidation37() {
    int[] rows = { 0, 4, 16, 27, 30, 34 };
    return genPlusValidation("2|3|4|5", HAI0700000000, rows);
  };

  public static FieldValidation genFieldValidation6() {
    int[] cols = { 3, 4 };
    int[] rows = { 0, 4, 16, 27, 30 };
    return UtilFieldValidation.genEqualsPosByConst(UtilMetadata.genPlusColumn(cols), 2,
        UtilMetadata.genPipeRow(getObjects(), rows), "2", "/");
  }

  public static FieldValidation genFieldValidation07() {
    String refPosCode = UtilMetadata.genPipeRow(getObjects());
    return UtilFieldValidation.genEqualsPosRatio("2|5", refPosCode, 2);
  };

  private static SegmentValidation genPlusValidation(String selectField, IObject<KeyValueString> pos, int[] rows) {
    return UtilSegmentValidation.genEqualsFormula(selectField, pos.getObject().getKey(),
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(pos.getObject().getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
  }
}
