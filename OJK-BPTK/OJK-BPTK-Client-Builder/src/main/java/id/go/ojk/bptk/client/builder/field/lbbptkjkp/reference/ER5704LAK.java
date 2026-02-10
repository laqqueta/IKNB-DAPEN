package id.go.ojk.bptk.client.builder.field.lbbptkjkp.reference;

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
public enum ER5704LAK implements IObject<KeyValueString> {
  LAK0201000000("LAK0201000000", "Modal awal pemerintah"),
  LAK0202000000("LAK0202000000", "Dana rekomposisi"),
  LAK0203000000("LAK0203000000", "Iuran pemerintah pusat"),
  LAK0204000000("LAK0204000000", "Kontribusi dari BPJS"),
  LAK0205000000("LAK0205000000", "Bantuan dari pemerintah"),
  LAK0206000000("LAK0206000000", "Penerimaan Lain-lain"),
  LAK0300000000("LAK0300000000", "Total Penerimaan Aktivitas Operasi"),
  LAK0401000000("LAK0401000000", "Beban Jaminan Kehilangan Pekerjaan"),
  LAK0402000000("LAK0402000000", "Dana Operasional BPJS"),
  LAK0403000000("LAK0403000000", "Pengeluaran Lain-Lain"),
  LAK0500000000("LAK0500000000", "Total Pengeluaran Aktivitas Operasi"),
  LAK0600000000("LAK0600000000", "Arus Kas Neto Dari Aktivitas Operasi"),
  LAK0801000000("LAK0801000000", "Pelepasan Investasi"),
  LAK0802000000("LAK0802000000", "Pendapatan Investasi"),
  LAK0900000000("LAK0900000000", "Total Penerimaan Aktivitas Investasi"),
  LAK1001000000("LAK1001000000", "Perolehan Investasi"),
  LAK1002000000("LAK1002000000", "Beban Investasi"),
  LAK1100000000("LAK1100000000", "Total Pengeluaran Aktivitas Investasi"),
  LAK1200000000("LAK1200000000", "Arus Kas Neto Dari Aktivitas Investasi"),
  LAK1400000000("LAK1400000000", "Penerimaan, Aktivitas Pendanaan"),
  LAK1401000000("LAK1401000000", "Talangan BPJS"),
  LAK1500000000("LAK1500000000", "Pengeluaran, Aktivitas Pendanaan"),
  LAK1501000000("LAK1501000000", "Pelunasan Talangan BPJS"),
  LAK1600000000("LAK1600000000", "Arus Kas Neto Dari Aktivitas Pendanaan"),
  LAK1700000000("LAK1700000000", "Kenaikan (Penurunan) Arus Kas"),
  LAK1800000000("LAK1800000000", "Kas Dan Bank Awal Periode"),
  LAK1900000000("LAK1900000000", "Kas Dan Bank Akhir Periode"),;

  @Getter
  private String key;
  private String value;

  public static String getName() {
    return ER5704LAK.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5704LAK.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5704LAK eEnum : ER5704LAK.values()) {
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
    return genPlusValidation("2", LAK0300000000, rows);
  };

  public static SegmentValidation genRowValidation12() {
    int[] rows = { 7, 8, 9 };
    return genPlusValidation("2", LAK0500000000, rows);
  };

  public static SegmentValidation genRowValidation13() {
    int[] rows = { 6, 10 };
    return genMinusValidation("2", LAK0600000000, rows);
  };

  public static SegmentValidation genRowValidation16() {
    int[] rows = { 12, 13 };
    return genPlusValidation("2", LAK0900000000, rows);
  };

  public static SegmentValidation genRowValidation19() {
    int[] rows = { 15, 16 };
    return genPlusValidation("2", LAK1100000000, rows);
  };

  public static SegmentValidation genRowValidation20() {
    int[] rows = { 14, 17 };
    return genMinusValidation("2", LAK1200000000, rows);
  };

  public static SegmentValidation genRowValidation21() {
    int[] rows = { 20 };
    return genPlusValidation("2", LAK1400000000, rows);
  };

  public static SegmentValidation genRowValidation23() {
    int[] rows = { 22 };
    return genPlusValidation("2", LAK1500000000, rows);
  };

  public static SegmentValidation genRowValidation25() {
    int[] rows = { 19, 21 };
    return genMinusValidation("2", LAK1600000000, rows);
  };

  public static SegmentValidation genRowValidation26() {
    int[] rows = { 11, 18, 23 };
    return genPlusValidation("2", LAK1700000000, rows);
  };

  public static SegmentValidation genRowValidation28() {
    int[] rows = { 24, 25 };
    return genPlusValidation("2", LAK1900000000, rows);
  };

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
}
