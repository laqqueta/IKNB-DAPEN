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
public enum ER5305AI implements IObject<KeyValueString> {
  AI0100000000("AI0100000000", "Investasi Setara Kas"),
  AI0101000000("AI0101000000", "Investasi Setara Kas, Deposito"),
  AI0102000000("AI0102000000", "Investasi Setara Kas, Sertifikat Deposito"),
  AI0103000000("AI0103000000", "Investasi Setara Kas, Deposito on call"),
  AI0200000000("AI0200000000", "Investasi Jangka Pendek"),
  AI0201000000("AI0201000000", "Investasi Jangka Pendek, Deposito"),
  AI0202000000("AI0202000000", "Investasi Jangka Pendek, Sertifikat Deposito"),
  AI0203000000("AI0203000000", "Investasi Jangka Pendek, Saham yang tercatat di bursa"),
  AI0204000000("AI0204000000", "Investasi Jangka Pendek, Surat utang korporasi & sukuk korporasi"),
  AI0205000000("AI0205000000", "Investasi Jangka Pendek, Surat berharga yang diterbitkan oleh Negara RI"),
  AI0206000000("AI0206000000", "Investasi Jangka Pendek, Surat berharga yang diterbitkan oleh Bank Indonesia"),
  AI0207000000("AI0207000000", "Investasi Jangka Pendek, Reksa dana"),
  AI0208000000("AI0208000000", "Investasi Jangka Pendek, Kontrak investasi kolektif efek beragun aset"),
  AI0209000000("AI0209000000", "Investasi Jangka Pendek, Dana investasi real estat"),
  AI0210000000("AI0210000000", "Investasi Jangka Pendek, Repurchase agreement (repo)"),
  AI0211000000("AI0211000000", "Investasi Jangka Pendek, Lainnya"),
  AI0300000000("AI0300000000", "Investasi Jangka Panjang"),
  AI0301000000("AI0301000000", "Investasi Jangka Panjang, Deposito"),
  AI0302000000("AI0302000000", "Investasi Jangka Panjang, Sertifikat Deposito"),
  AI0303000000("AI0303000000", "Investasi Jangka Panjang, Surat utang korporasi & sukuk korporasi"),
  AI0304000000("AI0304000000", "Investasi Jangka Panjang, Surat berharga yang diterbitkan oleh Negara RI"),
  AI0305000000("AI0305000000", "Investasi Jangka Panjang, Surat berharga yang diterbitkan oleh Bank Indonesia"),
  AI0306000000("AI0306000000", "Investasi Jangka Panjang, Reksa dana"),
  AI0307000000("AI0307000000", "Investasi Jangka Panjang, Penyertaan langsung"),
  AI0308000000("AI0308000000", "Investasi Jangka Panjang, Kontrak investasi kolektif efek beragun aset"),
  AI0309000000("AI0309000000", "Investasi Jangka Panjang, Dana investasi real estat"),
  AI0310000000("AI0310000000", "Investasi Jangka Panjang, Lainnya"),
  AI0400000000("AI0400000000", "Investasi pada Entitas Asosiasi dan Entitas Anak"),
  AI0401000000("AI0401000000", "Investasi pada Entitas Asosiasi dan Entitas Anak, Penyertaan langsung"),
  AI0402000000("AI0402000000", "Investasi pada Entitas Asosiasi dan Entitas Anak, Saham yang tercatat di bursa"),
  AI0500000000("AI0500000000", "Investasi pada Properti"),
  AI0501000000("AI0501000000", "Investasi pada Properti, Tanah"),
  AI0502000000("AI0502000000", "Investasi pada Properti, Bangunan"),
  AI0503000000("AI0503000000", "Investasi pada Properti, Tanah dengan bangunan"),
  AI0600000000("AI0600000000", "Lainnya"),
  AI0700000000("AI0700000000", "TOTAL INVESTASI"),;

  @Getter
  private String key;
  private String value;

  public static final String POS_SALDO = "2";

  public static String getName() {
    return ER5305AI.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5305AI.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5305AI eEnum : ER5305AI.values()) {
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

  public static SegmentValidation genRowValidation02() {
    int[] rows = { 1, 2, 3 };
    return genPlusValidation(POS_SALDO, AI0100000000, rows);
  };

  public static SegmentValidation genRowValidation06() {
    int[] rows = { 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
    return genPlusValidation(POS_SALDO, AI0200000000, rows);
  };

  public static SegmentValidation genRowValidation18() {
    int[] rows = { 17, 18, 19, 20, 21, 22, 23, 24, 25, 26 };
    return genPlusValidation(POS_SALDO, AI0300000000, rows);
  };

  public static SegmentValidation genRowValidation29() {
    int[] rows = { 28, 29 };
    return genPlusValidation(POS_SALDO, AI0400000000, rows);
  };

  public static SegmentValidation genRowValidation32() {
    int[] rows = { 31, 32, 33 };
    return genPlusValidation(POS_SALDO, AI0500000000, rows);
  };

  public static SegmentValidation genRowValidation37() {
    int[] rows = { 0, 4, 16, 27, 30, 34 };
    return genPlusValidation(POS_SALDO, AI0700000000, rows);
  };

  private static SegmentValidation genPlusValidation(String selectField, IObject<KeyValueString> pos, int[] rows) {
    return UtilSegmentValidation.genEqualsFormula(selectField, pos.getObject().getKey(),
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(pos.getObject().getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
  }
}
