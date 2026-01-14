package id.go.ojk.bpks.client.builder.field.lbbpkslk.reference;

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
public enum ER5003LAK implements IObject<KeyValueString> {
  LAK0101010000("LAK0101010000","Operasional program jaminan kesehatan"),
  LAK0101020000("LAK0101020000","Lain-lain"),
  LAK0102000000("LAK0102000000","Jumlah Penerimaan Aktivitas Operasi"),
  LAK0103010000("LAK0103010000","Operasional program jaminan kesehatan"),
  LAK0103020000("LAK0103020000","Lain-lain"),
  LAK0104000000("LAK0104000000","Jumlah Pengeluaran Aktivitas Operasi"),
  LAK0200000000("LAK0200000000","ARUS KAS NETO DARI AKTIVITAS OPERASI"),
  LAK0301010000("LAK0301010000","Pelepasan investasi"),
  LAK0301020000("LAK0301020000","Hasil Investasi"),
  LAK0301030000("LAK0301030000","Pelepasan aset tetap"),
  LAK0301040000("LAK0301040000","Lain-lain"),
  LAK0302000000("LAK0302000000","Jumlah Penerimaan Aktivitas Investasi"),
  LAK0303010000("LAK0303010000","Perolehan investasi"),
  LAK0303020000("LAK0303020000","Beban Investasi"),
  LAK0303030000("LAK0303030000","Perolehan aset tetap"),
  LAK0303040000("LAK0303040000","Lain-lain"),
  LAK0304000000("LAK0304000000","Jumlah Pengeluaran Aktivitas Investasi"),
  LAK0400000000("LAK0400000000","ARUS KAS NETO DARI AKTIVITAS INVESTASI"),
  LAK0501010000("LAK0501010000","Pelunasan talangan dari program jaminan kesehatan"),
  LAK0501020000("LAK0501020000","Setoran modal pemerintah"),
  LAK0501030000("LAK0501030000","Lain-lain"),
  LAK0502000000("LAK0502000000","Jumlah Penerimaan Aktivitas Pendanaan"),
  LAK0503010000("LAK0503010000","Kontribusi kepada program jaminan kesehatan"),
  LAK0503020000("LAK0503020000","Pemberian Talangan kepada Program Jaminan Kesehatan"),
  LAK0503030000("LAK0503030000","Lain-lain"),
  LAK0504000000("LAK0504000000","Jumlah Pengeluaran Aktivitas Pendanaan"),
  LAK0600000000("LAK0600000000","ARUS KAS NETO DARI AKTIVITAS PENDANAAN"),
  LAK0700000000("LAK0700000000","KENAIKAN (PENURUNAN) ARUS KAS"),
  LAK0800000000("LAK0800000000","KAS DAN SETARA KAS AWAL PERIODE"),
  LAK0900000000("LAK0900000000","KAS DAN SETARA KAS AKHIR PERIODE"),
  ;

  @Getter
  private String key;
  private String value;

  public static final String POS_SALDO = "2";

  public static String getName() {
    return ER5003LAK.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5003LAK.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5003LAK eEnum : ER5003LAK.values()) {
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

  public static SegmentValidation genRowValidation4() {
    int[] rows = { 0, 1 };
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, LAK0102000000.key,
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(LAK0102000000.value, UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation7() {
    int[] rows = { 3, 4 };
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, LAK0104000000.key,
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(LAK0104000000.value, UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation8() {
    int[] rows = { 2, 5 };
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, LAK0200000000.key,
        UtilMetadata.genMinusRow(getObjects(), rows),
        UtilMetadata.genMessage(LAK0200000000.value, UtilMetadata.genMinusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation13() {
    int[] rows = {7, 8, 9, 10};
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, LAK0302000000.key,
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(LAK0302000000.value, UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation18() {
    int[] rows = {12, 13, 14, 15};
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, LAK0304000000.key,
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(LAK0304000000.value, UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation19() {
    int[] rows = {11, 16};
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, LAK0400000000.key,
        UtilMetadata.genMinusRow(getObjects(), rows),
        UtilMetadata.genMessage(LAK0400000000.value, UtilMetadata.genMinusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation23() {
    int[] rows = {18, 19, 20};
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, LAK0502000000.key,
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(LAK0502000000.value, UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation27() {
    int[] rows = {22, 23, 24};
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, LAK0504000000.key,
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(LAK0504000000.value, UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation28() {
    int[] rows = {21, 25};
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, LAK0600000000.key,
        UtilMetadata.genMinusRow(getObjects(), rows),
        UtilMetadata.genMessage(LAK0600000000.value, UtilMetadata.genMinusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation29() {
    int[] rows = {6, 17, 26};
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, LAK0700000000.key,
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(LAK0700000000.value, UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation31() {
    int[] rows = {27, 28};
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, LAK0900000000.key,
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(LAK0900000000.value, UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

}
