package id.go.ojk.bptk.client.builder.field.lbbptkbdn.reference;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.bptk.client.builder.field.EFormLbbptkbdn;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER5301LPK implements IObject<KeyValueString> {
  LPK0101010000("LPK0101010000", "Kas dan setara Kas"),
  LPK0101020000("LPK0101020000", "Piutang Dana Operasional"),
  LPK0101020100("LPK0101020100", "Piutang Dana Operasional, Program Jaminan Hari Tua"),
  LPK0101020300("LPK0101020300", "Piutang Dana Operasional, Program Jaminan Kematian"),
  LPK0101020200("LPK0101020200", "Piutang Dana Operasional, Program Jaminan Kecelakaan Kerja"),
  LPK0101020400("LPK0101020400", "Piutang Dana Operasional, Program Jaminan Pensiun"),
  LPK0101030000("LPK0101030000", "Piutang Talangan"),
  LPK0101040000("LPK0101040000", "Piutang Investasi"),
  LPK0101050000("LPK0101050000", "Piutang Hasil Investasi"),
  LPK0101060000("LPK0101060000", "Piutang Usaha"),
  LPK0101070000("LPK0101070000", "Piutang SKP"),
  LPK0101080000("LPK0101080000", "Piutang Lain"),
  LPK0101090000("LPK0101090000", "Investasi Jangka Pendek"),
  LPK0101090100("LPK0101090100", "Investasi Jangka Pendek, Deposito"),
  LPK0101090200("LPK0101090200", "Investasi Jangka Pendek, Saham"),
  LPK0101090300("LPK0101090300", "Investasi Jangka Pendek, Reksadana"),
  LPK0101090400("LPK0101090400", "Investasi Jangka Pendek, Sukuk Korporasi"),
  LPK0101090500("LPK0101090500", "Investasi Jangka Pendek, Obligasi Korporasi"),
  LPK0101090600("LPK0101090600", "Investasi Jangka Pendek, Surat Berharga Negara"),
  LPK0101090700("LPK0101090700", "Investasi Jangka Pendek, Surat Berharga yang Diterbitkan Bank Indonesia"),
  LPK0101100000("LPK0101100000", "Pajak Dibayar Dimuka"),
  LPK0101110000("LPK0101110000", "Uang Muka"),
  LPK0101120000("LPK0101120000", "Biaya Dibayar Dimuka"),
  LPK0101130000("LPK0101130000", "Perlengkapan Kantor"),
  LPK0101140000("LPK0101140000", "Aset dimiliki Untuk Dijual"),
  LPK0101150000("LPK0101150000", "Aset Lancar Lain"),
  LPK0102000000("LPK0102000000", "Total Aset Lancar"),
  LPK0103010000("LPK0103010000", "Investasi Jangka Panjang"),
  LPK0103010100("LPK0103010100", "Investasi Jangka Panjang, KIK EBA"),
  LPK0103010200("LPK0103010200", "Investasi Jangka Panjang, Sukuk Korporasi"),
  LPK0103010300("LPK0103010300", "Investasi Jangka Panjang, Obligasi Korporasi"),
  LPK0103010400("LPK0103010400", "Investasi Jangka Panjang, Surat Berharga Negara"),
  LPK0103010500("LPK0103010500", "Investasi Jangka Panjang, Surat Berharga yang Diterbitkan Bank Indonesia"),
  LPK0103020000("LPK0103020000", "Investasi Pada Entitas Asosiasi/Penyertaan Langsung"),
  LPK0103030000("LPK0103030000", "Properti Investasi"),
  LPK0103040000("LPK0103040000", "Aset Tetap"),
  LPK0103050000("LPK0103050000", "Aset Hak Sewa"),
  LPK0103060000("LPK0103060000", "Aset Tidak Berwujud"),
  LPK0103070000("LPK0103070000", "Klaim Pengembalian Pajak"),
  LPK0103080000("LPK0103080000", "Aset Pajak Tangguhan"),
  LPK0103090000("LPK0103090000", "Aset Tidak Lancar Lain"),
  LPK0103100000("LPK0103100000", "Sarana Kesejahteraan Peserta"),
  LPK0104000000("LPK0104000000", "Total Aset Tidak Lancar"),
  LPK0200000000("LPK0200000000", "Total Aset"),
  LPK0301010000("LPK0301010000", "Utang Kepada Pihak Ketiga"),
  LPK0301020000("LPK0301020000", "Utang Pajak"),
  LPK0301030000("LPK0301030000", "Utang insentif"),
  LPK0301040000("LPK0301040000", "Utang Kontribusi Kepada Program"),
  LPK0301040100("LPK0301040100", "Utang Kontribusi Kepada Program, Program Jaminan Hari Tua"),
  LPK0301040200("LPK0301040200", "Utang Kontribusi Kepada Program, Program Jaminan Kecelakaan Kerja"),
  LPK0301040300("LPK0301040300", "Utang Kontribusi Kepada Program, Program Jaminan Kematian"),
  LPK0301040400("LPK0301040400", "Utang Kontribusi Kepada Program, Program Jaminan Pensiun"),
  LPK0301050000("LPK0301050000", "Biaya Yang Masih Harus Dibayar (Beban Akrual)"),
  LPK0301060000("LPK0301060000", "Pendapatan Diterima Dimuka"),
  LPK0301070000("LPK0301070000", "Utang Bank"),
  LPK0301080000("LPK0301080000", "Liabilitas Hak Sewa Guna < Satu Tahun"),
  LPK0301090000("LPK0301090000", "Liabilitas Jangka Pendek Lain"),
  LPK0301100000("LPK0301100000", "MLT Untuk Operasional"),
  LPK0301110000("LPK0301110000", "MLT Telah Disalurkan"),
  LPK0302000000("LPK0302000000", "Total Liabilitas Jangka Pendek"),
  LPK0303010000("LPK0303010000", "MLT Untuk Operasional"),
  LPK0303020000("LPK0303020000", "MLT Telah Disalurkan"),
  LPK0303030000("LPK0303030000", "Liabilitas Imbalan Pasca Kerja"),
  LPK0303040000("LPK0303040000", "Liabilitas Sewa Jangka Panjang dan Lainnya"),
  LPK0304000000("LPK0304000000", "Total Liabilitas Jangka Panjang"),
  LPK0400000000("LPK0400000000", "Total Liabilitas"),
  LPK0500000000("LPK0500000000", "Total Aset Neto"),
  LPK0601000000("LPK0601000000", "Modal"),
  LPK0602000000("LPK0602000000", "Kombinasi Bisnis Entitas Sepengendali (Tambahan Modal disetor)"),
  LPK0603000000("LPK0603000000", "Saldo Laba"),
  LPK0604000000("LPK0604000000", "Saldo Penghasilan (Beban) Neto"),
  LPK0605000000("LPK0605000000", "Komponen Ekuitas Lainnya"),
  LPK0606000000("LPK0606000000", "Keuntungan ( Kerugian ) Aktuaria"),
  LPK0607000000("LPK0607000000", "Saldo Penyesuaian Nilai Wajar Aset Keuangan FVOCI"),
  LPK0608000000("LPK0608000000", "Saldo Selisih Transaksi Dengan Pihak Nonpengendali"),
  LPK0609000000("LPK0609000000", "Saldo Bagian Penghasilan Komprehensif Lain Entitas Asosiasi"),
  LPK0610000000("LPK0610000000", "Cadangan Umum PT Bijak"),
  LPK0611000000("LPK0611000000", "Cadangan Tujuan PT Bijak"),
  LPK0700000000("LPK0700000000", "Jumlah Ekuitas yang dapat diatribusi kepada pemilik induk"),
  LPK0800000000("LPK0800000000", "Kepentingan Nonpengendali"),
  LPK0900000000("LPK0900000000", "Total Ekuitas"),
  LPK1000000000("LPK1000000000", "Total Liabilitas dan Ekuitas"),;

  public static final String POS_SALDO = "2";

  @Getter
  private String key;
  private String value;

  public static String getName() {
    return ER5301LPK.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5301LPK.class.getSimpleName().substring(2, 6));
  }

  public String getKeyForm() {
    return EFormLbbptkbdn.LPK.getCode() + key;
  }

  public String getValue() {
    String marker = ". ";
    value = StringUtils.strip(value, "-").trim();
    int idx = value.indexOf(marker);
    return idx > -1 ? value.substring(idx + 1).trim() : value;
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public KeyValueString getObjectForm() {
    return new KeyValueString(getKeyForm(), getValue(), new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5301LPK eEnum : ER5301LPK.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static List<KeyValueString> getObjectsForm() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5301LPK eEnum : ER5301LPK.values()) {
      res.add(eEnum.getObjectForm());
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

  public static SegmentValidation genRowValidation03() {
    int[] rows = { 2, 3, 4, 5 };
    return genPlusValidation(POS_SALDO, LPK0101020000, rows);
  }

  public static SegmentValidation genRowValidation14a() {
    int[] rows = { 13, 14, 15, 16, 17, 18, 19 };
    return genPlusValidation(POS_SALDO, LPK0101090000, rows);
  }

  public static SegmentValidation genRowValidation28() {
    int[] rows = { 0, 1, 6, 7, 8, 9, 10, 11, 12, 20, 21, 22, 23, 24, 25 };
    return genPlusValidation(POS_SALDO, LPK0102000000, rows);
  }

  public static SegmentValidation genRowValidation29() {
    int[] rows = { 28, 29, 30, 31, 32 };
    return genPlusValidation(POS_SALDO, LPK0103010000, rows);
  }

  public static SegmentValidation genRowValidation44() {
    int[] rows = { 27, 33, 34, 35, 36, 37, 38, 39, 40, 41 };
    return genPlusValidation(POS_SALDO, LPK0104000000, rows);
  }

  public static SegmentValidation genRowValidation45() {
    int[] rows = { 26, 42 };
    return genPlusValidation(POS_SALDO, LPK0200000000, rows);
  }

  public static SegmentValidation genRowValidation49() {
    int[] rows = { 48, 49, 50, 51 };
    return genPlusValidation(POS_SALDO, LPK0301040000, rows);
  }

  public static SegmentValidation genRowValidation61() {
    int[] rows = { 44, 45, 46, 47, 52, 53, 54, 55, 56, 57, 58 };
    return genPlusValidation(POS_SALDO, LPK0302000000, rows);
  }

  public static SegmentValidation genRowValidation66() {
    int[] rows = { 60, 61, 62, 63 };
    return genPlusValidation(POS_SALDO, LPK0304000000, rows);
  }

  public static SegmentValidation genRowValidation67() {
    int[] rows = { 59, 64 };
    return genPlusValidation(POS_SALDO, LPK0400000000, rows);
  }

  public static SegmentValidation genRowValidation68() {
    int[] rows = { 43, 65 };
    return genMinusValidation(POS_SALDO, LPK0500000000, rows);
  }

  public static SegmentValidation genRowValidation73() {
    int[] rows = { 72, 73 };
    return genPlusValidation(POS_SALDO, LPK0605000000, rows);
  }

  public static SegmentValidation genRowValidation80() {
    int[] rows = { 67, 68, 69, 71 };
    return genPlusValidation(POS_SALDO, LPK0700000000, rows);
  }

  public static SegmentValidation genRowValidation82() {
    int[] rows = { 78, 79 };
    return genPlusValidation(POS_SALDO, LPK0900000000, rows);
  }

  public static SegmentValidation genRowValidation83() {
    int[] rows = { 65, 79, 80 };
    return genPlusValidation(POS_SALDO, LPK1000000000, rows);
  }

  private static SegmentValidation genPlusValidation(String selectField, IObject<KeyValueString> pos, int[] rows) {
    return UtilSegmentValidation.genEqualsFormula(selectField, pos.getObject().getKey(),
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(pos.getObject().getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  private static SegmentValidation genMinusValidation(String selectField, IObject<KeyValueString> pos, int[] rows) {
    return UtilSegmentValidation.genEqualsFormula(selectField, pos.getObject().getKey(),
        UtilMetadata.genMinusRow(getObjects(), rows),
        UtilMetadata.genMessage(pos.getObject().getValue(), UtilMetadata.genMinusDesc(getObjects(), rows)));
  }

  /* -- ANTAR FORM -- */
  public static SegmentValidation genRowValidation14b() {
    String selecPosCode = LPK0101090000.key;
    String comparatorPosCode = ER5305AI.AI0200000000.getKey();
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, EFormLbbptkbdn.AI.getCode(), "2", comparatorPosCode);
  }
}
