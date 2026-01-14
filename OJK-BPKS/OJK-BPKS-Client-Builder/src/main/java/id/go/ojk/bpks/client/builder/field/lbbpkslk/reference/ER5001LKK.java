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
public enum ER5001LKK implements IObject<KeyValueString> {
  LKK0101000000("LKK0101000000","Pendapatan operasional penyelenggaraan program jaminan kesehatan"),
  LKK0200000000("LKK0200000000","Jumlah Pendapatan Operasional"),
  LKK0301000000("LKK0301000000","Beban operasional penyelenggaraan program jaminan kesehatan"),
  LKK0400000000("LKK0400000000","Jumlah Beban Operasional"),
  LKK0500000000("LKK0500000000","PENGHASILAN (BEBAN) OPERASIONAL"),
  LKK0601000000("LKK0601000000","Pendapatan investasi"),
  LKK0602000000("LKK0602000000","Pendapatan lain"),
  LKK0603000000("LKK0603000000","Beban investasi"),
  LKK0604000000("LKK0604000000","Beban bunga"),
  LKK0605000000("LKK0605000000","Beban insentif"),
  LKK0606000000("LKK0606000000","Beban tanggung jawab sosial dan lingkungan"),
  LKK0607000000("LKK0607000000","Beban lain"),
  LKK0608000000("LKK0608000000","Bagian laba (rugi) entitas asosiasi dan entitas anak"),
  LKK0700000000("LKK0700000000","Jumlah Pendapatan dan Beban Non-Operasional"),
  LKK0800000000("LKK0800000000","PENGHASILAN (BEBAN) SEBELUM PAJAK"),
  LKK0900000000("LKK0900000000","Beban pajak penghasilan"),
  LKK1000000000("LKK1000000000","PENGHASILAN (BEBAN) NETO"),
  LKK1101000000("LKK1101000000","Penyesuaian nilai wajar aset keuangan tersedia untuk dijual"),
  LKK1102000000("LKK1102000000","Keuntungan (kerugian) aktuaria liabilitas pascakerja imbalan pasti"),
  LKK1103000000("LKK1103000000","Bagian penghasilan komprehensif lain entitas asosiasi dan entitas anak"),
  LKK1200000000("LKK1200000000","Jumlah Penghasilan Komprehensif Lain"),
  LKK1300000000("LKK1300000000","PENGHASILAN (BEBAN) KOMPREHENSIF"),
  ;

  @Getter
  private String key;
  private String value;

  public static final String POS_SALDO = "2";

  public static String getName() {
    return ER5001LKK.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5001LKK.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5001LKK eEnum : ER5001LKK.values()) {
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

  public static SegmentValidation genRowValidation3() {
    int[] rows = { 0 };
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, LKK0200000000.key,
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(LKK0200000000.value, UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation5() {
    int[] rows = { 2 };
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, LKK0400000000.key,
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(LKK0400000000.value, UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation6() {
    int[] rows = { 1, 3 };
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, LKK0500000000.key,
        UtilMetadata.genMinusRow(getObjects(), rows),
        UtilMetadata.genMessage(LKK0500000000.value, UtilMetadata.genMinusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation15() {
    int[] rowsPlus = { 5, 6 };
    int[] rowsMinus = { 7, 8, 9, 10, 11, 12 };

    String plusMinusRows = UtilMetadata.genPlusRow(getObjects(), rowsPlus) + "-"
        + UtilMetadata.genMinusRow(getObjects(), rowsMinus);
    String plusMinusRowsDesc = UtilMetadata.genPlusDesc(getObjects(), rowsPlus) + "-"
        + UtilMetadata.genMinusDesc(getObjects(), rowsMinus);

    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, LKK0700000000.key, plusMinusRows,
        UtilMetadata.genMessage(LKK0700000000.value, plusMinusRowsDesc));
  }

  public static SegmentValidation genRowValidation16() {
    int[] rows = { 4, 13 };
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, LKK0800000000.key,
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(LKK0800000000.value, UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation18() {
    int[] rows = { 14, 15 };
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, LKK1000000000.key,
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(LKK1000000000.value, UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation22() {
    int[] rows = { 17, 18, 19 };
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, LKK1200000000.key,
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(LKK1200000000.value, UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation23() {
    int[] rows = { 16, 20 };
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, LKK1300000000.key,
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(LKK1300000000.value, UtilMetadata.genPlusDesc(getObjects(), rows)));
  }
}
