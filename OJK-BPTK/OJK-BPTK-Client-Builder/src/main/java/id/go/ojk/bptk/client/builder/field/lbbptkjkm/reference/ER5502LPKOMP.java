package id.go.ojk.bptk.client.builder.field.lbbptkjkm.reference;

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
public enum ER5502LPKOMP implements IObject<KeyValueString> {
  LPKOMP0201000000("LPKOMP0201000000", "Pendapatan Iuran"),
  LPKOMP0202000000("LPKOMP0202000000", "Pendapatan Investasi"),
  LPKOMP0202010000("LPKOMP0202010000", "Pendapatan Investasi, Pendapatan Bunga"),
  LPKOMP0202020000("LPKOMP0202020000", "Pendapatan Investasi, Pendapatan Bagi Hasil"),
  LPKOMP0202030000("LPKOMP0202030000", "Pendapatan Investasi, Pendapatan Dividen"),
  LPKOMP0202040000("LPKOMP0202040000", "Pendapatan Investasi, Keuntungan Pelepasan Investasi"),
  LPKOMP0202050000("LPKOMP0202050000", "Pendapatan Investasi, Selisih Penilaian Investasi"),
  LPKOMP0203000000("LPKOMP0203000000", "Kontribusi BPJS"),
  LPKOMP0204000000("LPKOMP0204000000", "Bantuan Pemerintah"),
  LPKOMP0205000000("LPKOMP0205000000", "Pendapatan Lain"),
  LPKOMP0300000000("LPKOMP0300000000", "Jumlah Pendapatan"),
  LPKOMP0401000000("LPKOMP0401000000", "Beban Jaminan Kematian"),
  LPKOMP0402000000("LPKOMP0402000000", "Beban Cadangan Teknis Program"),
  LPKOMP0402010000("LPKOMP0402010000", "Beban Cadangan Teknis Program, Kenaikan (Penurunan) Liabilitas Jaminan Kematian Dalam Proses"),
  LPKOMP0402020000("LPKOMP0402020000", "Beban Cadangan Teknis Program, Kenaikan (Penurunan) Liabilitas Jaminan Kematian Belum Dilaporkan"),
  LPKOMP0402030000("LPKOMP0402030000", "Beban Cadangan Teknis Program, Kenaikan (Penurunan) Iuran Yang Belum Merupakan Pendapatan"),
  LPKOMP0403000000("LPKOMP0403000000", "Beban Dana Operasional BPJS"),
  LPKOMP0404000000("LPKOMP0404000000", "Beban Investasi"),
  LPKOMP0405000000("LPKOMP0405000000", "Beban (Pemulihan) Penyisihan Piutang"),
  LPKOMP0406000000("LPKOMP0406000000", "Beban Lain"),
  LPKOMP0500000000("LPKOMP0500000000", "Jumlah Beban"),
  LPKOMP0600000000("LPKOMP0600000000", "Surplus (Defisit)"),
  LPKOMP0701000000("LPKOMP0701000000", "Penghasilan Komprehensif lain"),
  LPKOMP0800000000("LPKOMP0800000000", "Jumlah Penghasilan Komprehensif"),;

  @Getter
  private String key;
  private String value;

  public static String getName() {
    return ER5502LPKOMP.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5502LPKOMP.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5502LPKOMP eEnum : ER5502LPKOMP.values()) {
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

  public static SegmentValidation genRowValidation03() {
    int[] rows = { 2, 3, 4, 5, 6 };
    return genPlusValidation("2", LPKOMP0202000000, rows);
  };

  public static SegmentValidation genRowValidation12() {
    int[] rows = { 0, 1, 7, 8, 9 };
    return genPlusValidation("2", LPKOMP0300000000, rows);
  };

  public static SegmentValidation genRowValidation14() {
    int[] rows = { 13, 14, 15 };
    return genPlusValidation("2", LPKOMP0402000000, rows);
  };

  public static SegmentValidation genRowValidation23() {
    int[] rows = { 11, 12, 16, 17, 18, 19 };
    return genPlusValidation("2", LPKOMP0500000000, rows);
  };

  public static SegmentValidation genRowValidation24() {
    int[] rows = { 10, 20 };
    return genMinusValidation("2", LPKOMP0600000000, rows);
  };
  
  public static SegmentValidation genRowValidation25() {
    int[] rows = { 21, 22 };
    return genPlusValidation("2", LPKOMP0800000000, rows);
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
