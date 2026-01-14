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
public enum ER5302LKK implements IObject<KeyValueString> {
  LKK0101000000("LKK0101000000", "Pendapatan Pengelolaan Program JHT"),
  LKK0102000000("LKK0102000000", "Pendapatan Pengelolaan Program JKK"),
  LKK0103000000("LKK0103000000", "Pendapatan Pengelolaan Program JKM"),
  LKK0104000000("LKK0104000000", "Pendapatan Pengelolaan Program JPN"),
  LKK0105000000("LKK0105000000", "Jumlah Pendapatan Operasional Pengelolaan Program"),
  LKK0201000000("LKK0201000000", "Beban Operasional dan pendukung"),
  LKK0202000000("LKK0202000000", "Beban Personil dan manajemen"),
  LKK0203000000("LKK0203000000", "Beban Umum dan lainnya"),
  LKK0204000000("LKK0204000000", "Jumlah Beban Operasional Pengelolaan Progam"),
  LKK0300000000("LKK0300000000", "Surplus Operasional Pengelolaan Program"),
  LKK0401000000("LKK0401000000", "Pendapatan investasi"),
  LKK0402000000("LKK0402000000", "Beban Investasi"),
  LKK0403000000("LKK0403000000", "Beban Bunga"),
  LKK0404000000("LKK0404000000", "Beban Insentif"),
  LKK0405000000("LKK0405000000", "Pendapatan Peningkatan Kapasitas Pelayanan SKP"),
  LKK0406000000("LKK0406000000", "Beban Peningkatan Kapasitas Pelayanan SKP"),
  LKK0407000000("LKK0407000000", "Beban Tanggung Jawab Sosial dan Lingkungan (CSR)"),
  LKK0408000000("LKK0408000000", "Jumlah Penghasilan (Beban) Operasional Non Pengelolaan Program"),
  LKK0500000000("LKK0500000000", "Surplus Operasional"),
  LKK0601000000("LKK0601000000", "Pendapatan Entitas Anak"),
  LKK0602000000("LKK0602000000", "Beban Usaha Entitas Anak"),
  LKK0603000000("LKK0603000000", "Pendapatan (Beban) Lain - bersih"),
  LKK0604000000("LKK0604000000", "Beban Lain-Lain"),
  LKK0700000000("LKK0700000000", "Surplus Non Operasional"),
  LKK0800000000("LKK0800000000", "Surplus Sebelum Distribusi dan Pajak"),
  LKK0901000000("LKK0901000000", "Penyelenggaraan Program Jaminan Hari Tua"),
  LKK0902000000("LKK0902000000", "Penyelenggaraan Program Jaminan Kecelakaan Kerja"),
  LKK0903000000("LKK0903000000", "Penyelenggaraan Program Jaminan Kematian"),
  LKK0904000000("LKK0904000000", "Penyelenggaraan Program Jaminan Pensiun"),
  LKK0905000000("LKK0905000000", "Jumlah Beban Distribusi Surplus Badan"),
  LKK1001000000("LKK1001000000", "Beban Pajak Penghasilan"),
  LKK1002000000("LKK1002000000", "Pajak Tangguhan"),
  LKK1003000000("LKK1003000000", "Jumlah Beban (Penghasilan) Pajak"),
  LKK1100000000("LKK1100000000", "Surplus Tahun Berjalan"),
  LKK1201000000("LKK1201000000", "Penyesuaian Nilai Wajar Aset Keuangan Tersedia Untuk Dijual"),
  LKK1202000000("LKK1202000000", "Pengukuran kembali atas program Imbalan Pasti"),
  LKK1203000000("LKK1203000000", "Dampak Pajak Tangguhan"),
  LKK1204000000("LKK1204000000", "Pajak Penghasilan Terkait Pos-Pos yang tidak akan direklasifikasi ke Rugi Laba"),
  LKK1301000000("LKK1301000000", "Penyesuaian Nilai Wajar Aset Keuangan FVOCI"),
  LKK1400000000("LKK1400000000", "Penghasilan Komprehensive Lain"),
  LKK1500000000("LKK1500000000", "Penghasilan (beban) Komprehensif Tahun Berjalan"),
  LKK1501000000("LKK1501000000", "Pemilik Entitas Induk"),
  LKK1502000000("LKK1502000000", "Kepentingan Non Pengendali"),
  LKK1600000000("LKK1600000000", "Laba Tahun Berjalan Yang Dapat Diatribusikan"),
  LKK1701000000("LKK1701000000", "Pemilik Entitas Induk"),
  LKK1702000000("LKK1702000000", "Kepentingan Non Pengendali"),
  LKK1800000000("LKK1800000000", "Total Penghasilan Komprehensif Lain"),;

  public static final String POS_SALDO = "2";

  @Getter
  private String key;
  private String value;

  public static String getName() {
    return ER5302LKK.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5302LKK.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5302LKK eEnum : ER5302LKK.values()) {
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
    return UtilMetadata.genFieldSave(POS_SALDO, getObjects());
  }

  public static SegmentValidation genRowValidation06() {
    int[] rows = { 0, 1, 2, 3 };
    return genPlusValidation(POS_SALDO, LKK0105000000, rows);
  }

  public static SegmentValidation genRowValidation10() {
    int[] rows = { 5, 6, 7 };
    return genPlusValidation(POS_SALDO, LKK0204000000, rows);
  };

  public static SegmentValidation genRowValidation11() {
    int[] rows = { 4, 8 };
    return genPlusValidation(POS_SALDO, LKK0300000000, rows);
  };

  public static SegmentValidation genRowValidation19() {
    int[] rows = { 10, 11, 12, 13, 14, 15, 16 };
    return genPlusValidation(POS_SALDO, LKK0408000000, rows);
  };

  public static SegmentValidation genRowValidation20() {
    int[] rows = { 9, 17 };
    return genPlusValidation(POS_SALDO, LKK0500000000, rows);
  };

  public static SegmentValidation genRowValidation25() {
    int[] rows = { 19, 20, 21, 22 };
    return genPlusValidation(POS_SALDO, LKK0700000000, rows);
  };

  public static SegmentValidation genRowValidation26() {
    int[] rows = { 18, 23 };
    return genPlusValidation(POS_SALDO, LKK0800000000, rows);
  };

  public static SegmentValidation genRowValidation31() {
    int[] rows = { 25, 26, 27, 28 };
    return genPlusValidation(POS_SALDO, LKK0905000000, rows);
  };

  public static SegmentValidation genRowValidation34() {
    int[] rows = { 30, 31 };
    return genPlusValidation(POS_SALDO, LKK1003000000, rows);
  };

  public static SegmentValidation genRowValidation35() {
    int[] rows = { 24, 29, 32 };
    return genPlusValidation(POS_SALDO, LKK1100000000, rows);
  };

  public static SegmentValidation genRowValidation41() {
    int[] rows = { 34, 35, 36, 37, 38 };
    return genPlusValidation(POS_SALDO, LKK1400000000, rows);
  };

  public static SegmentValidation genRowValidation42() {
    int[] rows = { 33, 39 };
    return genPlusValidation(POS_SALDO, LKK1500000000, rows);
  };

  public static SegmentValidation genRowValidation45() {
    int[] rows = { 41, 42 };
    return genPlusValidation(POS_SALDO, LKK1600000000, rows);
  };

  public static SegmentValidation genRowValidation48() {
    int[] rows = { 44, 45 };
    return genPlusValidation(POS_SALDO, LKK1800000000, rows);
  };

  private static SegmentValidation genPlusValidation(String selectField, IObject<KeyValueString> pos, int[] rows) {
    return UtilSegmentValidation.genEqualsFormula(selectField, pos.getObject().getKey(),
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(pos.getObject().getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
  }
}
