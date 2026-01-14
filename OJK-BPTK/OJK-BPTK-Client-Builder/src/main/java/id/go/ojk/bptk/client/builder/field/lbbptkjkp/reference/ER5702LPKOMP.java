package id.go.ojk.bptk.client.builder.field.lbbptkjkp.reference;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.bptk.client.builder.field.EFormLbbptkjkp;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER5702LPKOMP implements IObject<KeyValueString> {
  LPKOMP0300000000("LPKOMP0300000000", "Pendapatan dana rekomposisi"),
  LPKOMP0400000000("LPKOMP0400000000", "Pendapatan iuran pemerintah pusat"),
  LPKOMP0501000000("LPKOMP0501000000", "Pendapatan bunga"),
  LPKOMP0502000000("LPKOMP0502000000", "Pendapatan bagi hasil"),
  LPKOMP0503000000("LPKOMP0503000000", "Pendapatan dividen"),
  LPKOMP0504000000("LPKOMP0504000000", "Keuntungan pelepasan investasi"),
  LPKOMP0505000000("LPKOMP0505000000", "Selisih penilaian investasi"),
  LPKOMP0600000000("LPKOMP0600000000", "Subjumlah pendapatan investasi"),
  LPKOMP0700000000("LPKOMP0700000000", "Kontribusi dari BPJS"),
  LPKOMP0800000000("LPKOMP0800000000", "Pendapatan lain"),
  LPKOMP0900000000("LPKOMP0900000000", "Jumlah Pendapatan"),
  LPKOMP1100000000("LPKOMP1100000000", "Beban jaminan kehilangan pekerjaan"),
  LPKOMP1200000000("LPKOMP1200000000", "Beban cadangan teknis program"),
  LPKOMP1201000000("LPKOMP1201000000", "Kenaikan (penurunan) liabilitas jaminan kehilangan pekerjaan dalam proses"),
  LPKOMP1202000000("LPKOMP1202000000", "Kenaikan (penurunan) liabilitas jaminan kehilangan pekerjaan belum dilaporkan"),
  LPKOMP1203000000("LPKOMP1203000000", "Kenaikan (penurunan) iuran yang belum merupakan pendapatan"),
  LPKOMP1300000000("LPKOMP1300000000", "Beban dana operasional BPJS"),
  LPKOMP1400000000("LPKOMP1400000000", "Beban investasi"),
  LPKOMP1500000000("LPKOMP1500000000", "Beban (pemulihan) penyisihan piutang"),
  LPKOMP1600000000("LPKOMP1600000000", "Beban lain"),
  LPKOMP1700000000("LPKOMP1700000000", "Jumlah Beban"),
  LPKOMP1800000000("LPKOMP1800000000", "SURPLUS (DEFISIT)"),
  LPKOMP1900000000("LPKOMP1900000000", "DENGAN PEMBATASAN DARI PEMBERI SUMBER DAYA"),
  LPKOMP2000000000("LPKOMP2000000000", "Penghasilan Komprehensif lain"),
  LPKOMP2100000000("LPKOMP2100000000", "JUMLAH PENGHASILAN KOMPREHENSIF"),;

  @Getter
  private String key;
  private String value;

  public static String getName() {
    return ER5702LPKOMP.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5702LPKOMP.class.getSimpleName().substring(2, 6));
  }

  public String getKeyForm() {
    return EFormLbbptkjkp.LPKOMP.getCode() + key;
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
    for (ER5702LPKOMP eEnum : ER5702LPKOMP.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static List<KeyValueString> getObjectsForm() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5702LPKOMP eEnum : ER5702LPKOMP.values()) {
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
    return UtilMetadata.genFieldSave("2", getObjects());
  }

  public static SegmentValidation genRowValidation09() {
    int[] rows = { 2, 3, 4, 5, 6 };
    return genPlusValidation("2", LPKOMP0600000000, rows);
  };

  public static SegmentValidation genRowValidation12() {
    int[] rows = { 0, 1, 7, 8, 9 };
    return genPlusValidation("2", LPKOMP0900000000, rows);
  };

  public static SegmentValidation genRowValidation14() {
    int[] rows = { 13, 14, 15 };
    return genPlusValidation("2", LPKOMP1200000000, rows);
  };

  public static SegmentValidation genRowValidation22() {
    int[] rows = { 11, 12, 16, 17, 18, 19 };
    return genPlusValidation("2", LPKOMP1700000000, rows);
  };

  public static SegmentValidation genRowValidation23() {
    int[] rows = { 10, 20 };
    return genMinusValidation("2", LPKOMP1800000000, rows);
  };

  public static SegmentValidation genRowValidation26() {
    int[] rows = { 21, 23 };
    return genPlusValidation("2", LPKOMP2100000000, rows);
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
