package id.go.ojk.bpks.client.builder.field.lbbpksdjs.reference;

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
public enum ER5102LAK implements IObject<KeyValueString> {
  LAK0101010000("LAK0101010000", "Iuran"),
  LAK0101020000("LAK0101020000", "Kontribusi dari BPJS"),
  LAK0101030000("LAK0101030000", "Pajak Rokok"),
  LAK0101040000("LAK0101040000", "Bantuan dari pemerintah"),
  LAK0101050000("LAK0101050000", "Hibah dari BPJS"),
  LAK0101060000("LAK0101060000", "Denda Peserta"),
  LAK0101070000("LAK0101070000", "Lain-lain"),
  LAK0102010000("LAK0102010000", "Jaminan kesehatan"),
  LAK0102020000("LAK0102020000", "Biaya operasional BPJS"),
  LAK0102030000("LAK0102030000", "Pengembalian Pajak Rokok"),
  LAK0102040000("LAK0102040000", "Denda Keterlambatan Pembayaran Klaim"),
  LAK0102050000("LAK0102050000", "Lain-lain"),
  LAK0200000000("LAK0200000000", "ARUS KAS NETO DARI AKTIVITAS OPERASI"),
  LAK0301010000("LAK0301010000", "Pelepasan investasi"),
  LAK0301020000("LAK0301020000", "Hasil Investasi"),
  LAK0302010000("LAK0302010000", "Perolehan investasi"),
  LAK0400000000("LAK0400000000", "ARUS KAS NETO DARI AKTIVITAS INVESTASI"),
  LAK0501010000("LAK0501010000", "Talangan dari BPJS"),
  LAK0501020000("LAK0501020000", "Bantuan Pemerintah"),
  LAK0501030000("LAK0501030000", "Lain-lain"),
  LAK0502010000("LAK0502010000", "Pelunasan talangan BPJS"),
  LAK0600000000("LAK0600000000", "ARUS KAS NETO DARI AKTIVITAS PENDANAAN"),
  LAK0700000000("LAK0700000000", "KENAIKAN (PENURUNAN) ARUS KAS"),
  LAK0800000000("LAK0800000000", "KAS DAN SETARA KAS AWAL PERIODE"),
  LAK0900000000("LAK0900000000", "KAS DAN SETARA KAS AKHIR PERIODE"),;

  @Getter
  private String key;
  private String value;

  public static final String POS_SALDO = "2";

  public static String getName() {
    return ER5102LAK.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5102LAK.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5102LAK eEnum : ER5102LAK.values()) {
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

  public static SegmentValidation genRowValidation14() {
    int[] rows1 = { 0, 1, 2, 3, 4, 5, 6 };
    int[] rows2 = { 7, 8, 9, 10, 11 };
    return genRowValidation2(LAK0200000000, rows1, rows2);
  }

  public static SegmentValidation genRowValidation18() {
    int[] rows1 = { 13, 14 };
    int[] rows2 = { 15 };
    return genRowValidation2(LAK0400000000, rows1, rows2);
  }

  public static SegmentValidation genRowValidation23() {
    int[] rows1 = { 17, 18, 19 };
    int[] rows2 = { 20 };
    return genRowValidation2(LAK0600000000, rows1, rows2);
  }

  public static SegmentValidation genRowValidation24() {
    int[] rows = { 12, 16, 21 };
    return genRowValidation1(LAK0700000000, rows);
  }

  public static SegmentValidation genRowValidation26() {
    int[] rows = { 22, 23 };
    return genRowValidation1(LAK0900000000, rows);
  }

  private static SegmentValidation genRowValidation1(IObject<KeyValueString> pos, int[] rows) {
    KeyValueString posCode = pos.getObject();
    String plusRows = UtilMetadata.genPlusRow(getObjects(), rows);
    String plusRowsDesc = UtilMetadata.genPlusDesc(getObjects(), rows);
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, posCode.getKey(), plusRows,
        UtilMetadata.genMessage(posCode.getValue(), plusRowsDesc));
  }

  private static SegmentValidation genRowValidation2(IObject<KeyValueString> pos, int[] rows1, int[] rows2) {
    KeyValueString posCode = pos.getObject();
    String plusRows = UtilMetadata.genPlusRow(getObjects(), rows1) + "-"
        + UtilMetadata.genMinusRow(getObjects(), rows2);
    String plusRowsDesc = "(" + UtilMetadata.genPlusDesc(getObjects(), rows1) + ") - ("
        + UtilMetadata.genPlusDesc(getObjects(), rows2) + ")";
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, posCode.getKey(), plusRows,
        UtilMetadata.genMessage(posCode.getValue(), plusRowsDesc));
  }
}
