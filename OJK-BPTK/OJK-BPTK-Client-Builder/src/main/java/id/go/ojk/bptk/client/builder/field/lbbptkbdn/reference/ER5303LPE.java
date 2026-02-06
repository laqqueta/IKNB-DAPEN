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
public enum ER5303LPE implements IObject<KeyValueString> {
  LPE0100000000("LPE0100000000", "SALDO AWAL PERIODE SEBELUMNYA"),
  LPE0200000000("LPE0200000000", "Perubahan Kebijakan Akuntansi"),
  LPE0300000000("LPE0300000000", "Laba tahun berjalan"),
  LPE0301000000("LPE0301000000", "Distribusi Surplus Laba ditahan"),
  LPE0401000000("LPE0401000000", "Penghasilan Komprensif Lain, Pengukuran kembali liabilitas imbalan kerja"),
  LPE0402000000("LPE0402000000", "Penghasilan Komprensif Lain, Penyesuaian pajak tangguhan"),
  LPE0403000000("LPE0403000000", "Penghasilan Komprensif Lain, Selisih Transaksi Dengan Pihak Nonpengendali"),
  LPE0404000000("LPE0404000000", "Penghasilan Komprensif Lain, Kenaikan (penurunan) yang belum direalisasikan atas nilai investasi FVOCI"),
  LPE0405000000("LPE0405000000", "Penghasilan Komprensif Lain, Keuntungan direalisasi atas kenaikan"),
  LPE0405010000("LPE0405010000", "Penghasilan Komprensif Lain, Keuntungan direalisasi atas kenaikan nilai wajar investasi FVOCI"),
  LPE0405020000("LPE0405020000", "Penghasilan Komprensif Lain, Keuntungan direalisasi atas kenaikan direklasifikasi ke laba rugi"),
  LPE0406000000("LPE0406000000", "Penghasilan Komprensif Lain, Reklasifikasi keuntungan yang direalisasi atas aset keuangan"),
  LPE0406010000("LPE0406010000", "Penghasilan Komprensif Lain, Reklasifikasi keuntungan yang direalisasi atas aset keuangan yang diukur pada nilai wajar melalui penghasilan"),
  LPE0406020000("LPE0406020000", "Penghasilan Komprensif Lain, Reklasifikasi keuntungan yang direalisasi atas aset keuangan komprehensif lain ke surplus operasional"),
  LPE0500000000("LPE0500000000", "Pembayaran Dividen"),
  LPE0601000000("LPE0601000000", "Transaksi dengan pemilik, Penambahan modal dari distribusi surplus Tahun Sebelumnya"),
  LPE0602000000("LPE0602000000", "Transaksi dengan pemilik, Kontribusi kepada program JHT"),
  LPE0603000000("LPE0603000000", "Transaksi dengan pemilik, Kontribusi kepada program JKK"),
  LPE0604000000("LPE0604000000", "Transaksi dengan pemilik, Kontribusi kepada program JKM"),
  LPE0605000000("LPE0605000000", "Transaksi dengan pemilik, Kontribusi kepada program JPN"),
  LPE0700000000("LPE0700000000", "SALDO AKHIR PERIODE SEBELUMNYA"),
  LPE0800000000("LPE0800000000", "Perubahan Kebijakan Akuntansi"),
  LPE0900000000("LPE0900000000", "Laba tahun berjalan"),
  LPE1001000000("LPE1001000000", "Penghasilan Komprensif Lain, Pengukuran kembali liabilitas imbalan kerja"),
  LPE1002000000("LPE1002000000", "Penghasilan Komprensif Lain, Penyesuaian pajak tangguhan"),
  LPE1003000000("LPE1003000000", "Penghasilan Komprensif Lain, Selisih Transaksi Dengan Pihak Nonpengendali"),
  LPE1004000000("LPE1004000000", "Penghasilan Komprensif Lain, Penyesuaian Laba Tahun Lalu terkait PSAK 73"),
  LPE1005000000("LPE1005000000", "Penghasilan Komprensif Lain, Kenaikan (penurunan) yang belum direalisasikan atas nilai investasi FVOCI"),
  LPE1006000000("LPE1006000000", "Penghasilan Komprensif Lain, Keuntungan direalisasi atas kenaikan"),
  LPE1006010000("LPE1006010000", "Penghasilan Komprensif Lain, Keuntungan direalisasi atas kenaikan nilai wajar investasi FVOCI - direklasifikasi ke laba rugi"),
  LPE1007000000("LPE1007000000", "Penghasilan Komprensif Lain, Reklasifikasi keuntungan yang direalisasi atas aset keuangan"),
  LPE1007010000("LPE1007010000", "Penghasilan Komprensif Lain, Reklasifikasi keuntungan yang direalisasi atas aset keuangan yang diukur pada nilai wajar melalui penghasilan"),
  LPE1007020000("LPE1007020000", "Penghasilan Komprensif Lain, Reklasifikasi keuntungan yang direalisasi atas aset keuangan komprehensif lain ke surplus operasional"),
  LPE1101000000("LPE1101000000", "Transaksi dengan pemilik, Penambahan modal dari distribusi surplus Tahun Sebelumnya"),
  LPE1102000000("LPE1102000000", "Transaksi dengan pemilik, Kontribusi kepada program JHT"),
  LPE1103000000("LPE1103000000", "Transaksi dengan pemilik, Kontribusi kepada program JKK"),
  LPE1104000000("LPE1104000000", "Transaksi dengan pemilik, Kontribusi kepada program JKM"),
  LPE1200000000("LPE1200000000", "Pembayaran Dividen"),
  LPE1300000000("LPE1300000000", "SALDO AKHIR BERJALAN"),;

  @Getter
  private String key;
  private String value;

  public static final int[] ALL_COLS = { 2, 3, 4, 5, 6, 7, 8, 9 };

  public static String getName() {
    return ER5303LPE.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5303LPE.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5303LPE eEnum : ER5303LPE.values()) {
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
    return UtilMetadata.genFieldSave(UtilMetadata.genDelimitedColumn(2, 9, "|"), getObjects());
  }

  public static SegmentValidation genRowValidation22() {
    int[] rows = { 0, 1, 2, 3, 4, 5, 6, 7, 8, /*9,*/ 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 };
    KeyValueString posCode = LPE0700000000.getObject();
    String selectFields = UtilMetadata.genDelimitedColumn(ALL_COLS, "|");
    String plusRows = UtilMetadata.genPlusRow(getObjects(), rows);
    String plusRowsDesc = UtilMetadata.genPlusDesc(getObjects(), rows);
    return UtilSegmentValidation.genEqualsFormula(selectFields, posCode.getKey(), plusRows,
        UtilMetadata.genMessage(posCode.getValue(), plusRowsDesc));
  }

  public static SegmentValidation genRowValidation40() {
    int[] rows = { 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37 };
    KeyValueString posCode = LPE1300000000.getObject();
    String selectFields = UtilMetadata.genDelimitedColumn(ALL_COLS, "|");
    String plusRows = UtilMetadata.genPlusRow(getObjects(), rows);
    String plusRowsDesc = UtilMetadata.genPlusDesc(getObjects(), rows);
    return UtilSegmentValidation.genEqualsFormula(selectFields, posCode.getKey(), plusRows,
        UtilMetadata.genMessage(posCode.getValue(), plusRowsDesc));
  }
}
