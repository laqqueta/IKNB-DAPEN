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
public enum ER5304LAK implements IObject<KeyValueString> {
  LAK0101000000("LAK0101000000", "Penerimaan Dana Operasional Program JHT"),
  LAK0102000000("LAK0102000000", "Penerimaan Dana Operasional Program JKK"),
  LAK0103000000("LAK0103000000", "Penerimaan Dana Operasional Program JKM"),
  LAK0104000000("LAK0104000000", "Penerimaan Dana Operasional Program JPN"),
  LAK0105000000("LAK0105000000", "Penerimaan restitusi pajak"),
  LAK0106000000("LAK0106000000", "Penerimaan Lainnya"),
  LAK0106010000("LAK0106010000", "Jumlah Penerimaan Aktivitas Operasi"),
  LAK0107000000("LAK0107000000", "Pembayaran kepada karyawan, pemasok dan lainnya"),
  LAK0108000000("LAK0108000000", "Pembayaran Pajak Penghasilan Badan"),
  LAK0108010000("LAK0108010000", "Jumlah Pembayaran Aktivitas Operasi"),
  LAK0200000000("LAK0200000000", "ARUS KAS BERSIH DIPEROLEH DARI (DIGUNAKAN UNTUK) AKTIVITAS OPERASI"),
  LAK0301000000("LAK0301000000", "Penempatan Investasi"),
  LAK0302000000("LAK0302000000", "Pelepasan investasi"),
  LAK0303000000("LAK0303000000", "Penerimaan bunga deposito"),
  LAK0304000000("LAK0304000000", "Pencairan Obligasi"),
  LAK0305000000("LAK0305000000", "Penerimaan bunga obligasi"),
  LAK0306000000("LAK0306000000", "Penerimaan dividen"),
  LAK0307000000("LAK0307000000", "Pendapatan sukuk"),
  LAK0308000000("LAK0308000000", "Properti investasi"),
  LAK0309000000("LAK0309000000", "Pendapatan reksadana"),
  LAK0310000000("LAK0310000000", "Hasil penjualan aset tetap"),
  LAK0311000000("LAK0311000000", "Perolehan Aset Tetap"),
  LAK0400000000("LAK0400000000", "ARUS KAS BERSIH DIPEROLEH DARI (DIGUNAKAN UNTUK) AKTIVITAS INVESTASI"),
  LAK0501000000("LAK0501000000", "Penerimaan pinjaman bank"),
  LAK0502000000("LAK0502000000", "Pembayaran pinjaman bank"),
  LAK0503000000("LAK0503000000", "Pembayaran bank garansi"),
  LAK0504000000("LAK0504000000", "Pembayaran dividen"),
  LAK0505000000("LAK0505000000", "Pembayaran bunga"),
  LAK0506000000("LAK0506000000", "Kontribusi Kepada Program JHT"),
  LAK0507000000("LAK0507000000", "Kontribusi Kepada Program JKK"),
  LAK0508000000("LAK0508000000", "Kontribusi Kepada Program JKM"),
  LAK0509000000("LAK0509000000", "Kontribusi Kepada Program JP"),
  LAK0510000000("LAK0510000000", "Pembayaran Liabilitas Sewa"),
  LAK0511000000("LAK0511000000", "Lain - Lain"),
  LAK0600000000("LAK0600000000", "ARUS KAS BERSIH DIPEROLEH DARI (DIGUNAKAN UNTUK) AKTIVITAS PENDANAAN"),
  LAK0700000000("LAK0700000000", "KENAIKAN (PENURUNAN) ARUS KAS"),
  LAK0800000000("LAK0800000000", "KAS DAN SETARA KAS AWAL PERIODE"),
  LAK0900000000("LAK0900000000", "KAS DAN SETARA KAS AKHIR PERIODE"),
  LAK0901000000("LAK0901000000", "Cadangan Kerugian Kredit Ekspetasian"),
  LAK1000000000("LAK1000000000", "KAS DAN SETARA KAS AKHIR PERIODE SETELAH CADANGAN KERUGIAN KREDIT EKSPETASIAN"),;

  @Getter
  private String key;
  private String value;

  public static final String POS_SALDO = "2";

  public static String getName() {
    return ER5304LAK.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5304LAK.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5304LAK eEnum : ER5304LAK.values()) {
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

  public static SegmentValidation genRowValidation08() {
    int[] rows = { 0, 1, 2, 3, 4, 5 };
    return genPlusValidation(POS_SALDO, LAK0106010000, rows);
  };

  public static SegmentValidation genRowValidation11() {
    int[] rows = { 7, 8 };
    return genPlusValidation(POS_SALDO, LAK0108010000, rows);
  };

  public static SegmentValidation genRowValidation12() {
    int[] rows = { 6, 9 };
    return genPlusValidation(POS_SALDO, LAK0200000000, rows);
  };

  public static SegmentValidation genRowValidation24() {
    int[] rows = { 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21 };
    return genPlusValidation(POS_SALDO, LAK0400000000, rows);
  };

  public static SegmentValidation genRowValidation36() {
    int[] rows = { 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33 };
    return genPlusValidation(POS_SALDO, LAK0600000000, rows);
  };

  public static SegmentValidation genRowValidation37() {
    int[] rows = { 10, 22, 34 };
    return genPlusValidation(POS_SALDO, LAK0700000000, rows);
  };

  public static SegmentValidation genRowValidation39() {
    int[] rows = { 35, 36 };
    return genPlusValidation(POS_SALDO, LAK0900000000, rows);
  };

  public static SegmentValidation genRowValidation41() {
    int[] rows = { 37, 38 };
    return genPlusValidation(POS_SALDO, LAK1000000000, rows);
  };

  private static SegmentValidation genPlusValidation(String selectField, IObject<KeyValueString> pos, int[] rows) {
    return UtilSegmentValidation.genEqualsFormula(selectField, pos.getObject().getKey(),
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(pos.getObject().getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
  }
}
