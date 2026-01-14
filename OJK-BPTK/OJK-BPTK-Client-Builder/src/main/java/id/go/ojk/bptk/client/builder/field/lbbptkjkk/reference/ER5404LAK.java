package id.go.ojk.bptk.client.builder.field.lbbptkjkk.reference;

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
public enum ER5404LAK implements IObject<KeyValueString> {
  LAK0201000000("LAK0201000000", "Iuran"),
  LAK0202000000("LAK0202000000", "Kontribusi BPJS"),
  LAK0203000000("LAK0203000000", "Bantuan Pemerintah"),
  LAK0204000000("LAK0204000000", "Penerimaan, Lain-Lain"),
  LAK0300000000("LAK0300000000", "Total Penerimaan"),
  LAK0401000000("LAK0401000000", "Beban Jaminan Kecelakaan Kerja"),
  LAK0402000000("LAK0402000000", "Dana Operasional BPJS"),
  LAK0403000000("LAK0403000000", "Pengeluaran, Lain-Lain"),
  LAK0500000000("LAK0500000000", "Total Pengeluaran"),
  LAK0600000000("LAK0600000000", "Arus Kas Neto Dari Aktivitas Operasi"),
  LAK0801000000("LAK0801000000", "Pelepasan Investasi"),
  LAK0802000000("LAK0802000000", "Pendapatan Investasi"),
  LAK0900000000("LAK0900000000", "Total Penerimaan"),
  LAK1001000000("LAK1001000000", "Perolehan Investasi"),
  LAK1002000000("LAK1002000000", "Beban Investasi"),
  LAK1100000000("LAK1100000000", "Total Pengeluaran"),
  LAK1200000000("LAK1200000000", "Arus Kas Neto Dari Aktivitas Investasi"),
  LAK1400000000("LAK1400000000", "Penerimaan"),
  LAK1401000000("LAK1401000000", "Talangan BPJS"),
  LAK1500000000("LAK1500000000", "Pengeluaran"),
  LAK1501000000("LAK1501000000", "Pelunasan Talangan BPJS"),
  LAK1600000000("LAK1600000000", "Arus Kas Neto Dari Aktivitas Pendanaan"),
  LAK1700000000("LAK1700000000", "Kenaikan (Penurunan) Arus Kas"),
  LAK1800000000("LAK1800000000", "Kas Dan Bank Awal Periode"),
  LAK1900000000("LAK1900000000", "Kas Dan Bank Akhir Periode"),;

  @Getter
  private String key;
  private String value;

  public static String getName() {
    return ER5404LAK.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5404LAK.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5404LAK eEnum : ER5404LAK.values()) {
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

  public static SegmentValidation genRowValidation06() {
    int[] rows = { 0, 1, 2, 3 };
    return genPlusValidation("2", LAK0300000000, rows);
  };

  public static SegmentValidation genRowValidation10() {
    int[] rows = { 5, 6, 7 };
    return genPlusValidation("2", LAK0500000000, rows);
  };

  public static SegmentValidation genRowValidation11() {
    int[] rows = { 4, 8 };
    return genMinusValidation("2", LAK0600000000, rows);
  };

  public static SegmentValidation genRowValidation14() {
    int[] rows = { 10, 11 };
    return genPlusValidation("2", LAK0900000000, rows);
  };

  public static SegmentValidation genRowValidation17() {
    int[] rows = { 13, 14 };
    return genPlusValidation("2", LAK1100000000, rows);
  };

  public static SegmentValidation genRowValidation18() {
    int[] rows = { 12, 15 };
    return genMinusValidation("2", LAK1200000000, rows);
  };

  public static SegmentValidation genRowValidation19() {
    int[] rows = { 18 };
    return genPlusValidation("2", LAK1400000000, rows);
  };

  public static SegmentValidation genRowValidation21() {
    int[] rows = { 20 };
    return genPlusValidation("2", LAK1500000000, rows);
  };

  public static SegmentValidation genRowValidation23() {
    int[] rows = { 17, 19 };
    return genMinusValidation("2", LAK1600000000, rows);
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
