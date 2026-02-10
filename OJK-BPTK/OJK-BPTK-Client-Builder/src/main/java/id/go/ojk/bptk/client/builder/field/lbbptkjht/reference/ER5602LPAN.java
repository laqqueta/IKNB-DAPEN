package id.go.ojk.bptk.client.builder.field.lbbptkjht.reference;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.bptk.client.builder.field.EFormLbbptkjht;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER5602LPAN implements IObject<KeyValueString> {
  LPAN0300000000("LPAN0300000000", "Pendapatan Iuran JHT"),
  LPAN0400000000("LPAN0400000000", "Bantuan Pemerintah"),
  LPAN0500000000("LPAN0500000000", "Pendapatan Investasi"),
  LPAN0501000000("LPAN0501000000", "Pendapatan Bunga"),
  LPAN0502000000("LPAN0502000000", "Pendapatan Bagi Hasil"),
  LPAN0503000000("LPAN0503000000", "Pendapatan Dividen"),
  LPAN0504000000("LPAN0504000000", "Pendapatan Sewa"),
  LPAN0505000000("LPAN0505000000", "Keuntungan Pelepasan Investasi"),
  LPAN0506000000("LPAN0506000000", "Selisih Penilaian Investasi"),
  LPAN0507000000("LPAN0507000000", "Penerimaan Lain Investasi"),
  LPAN0600000000("LPAN0600000000", "Kontribusi dari BPJS Ketenagakerjaan"),
  LPAN0700000000("LPAN0700000000", "Kenaikan (penurunan) penjualan aset investasi"),
  LPAN0800000000("LPAN0800000000", "Pendapatan Lain"),
  LPAN0900000000("LPAN0900000000", "Total Pendapatan"),
  LPAN1100000000("LPAN1100000000", "Beban Jaminan Hari Tua"),
  LPAN1200000000("LPAN1200000000", "Beban Dana Operasional BPJS Ketenagakerjaan"),
  LPAN1300000000("LPAN1300000000", "Beban Investasi"),
  LPAN1400000000("LPAN1400000000", "Kenaikan (penurunan) cadangan kerugian penurunan nilai piutang"),
  LPAN1500000000("LPAN1500000000", "Beban Lain"),
  LPAN1600000000("LPAN1600000000", "Total Beban"),
  LPAN1700000000("LPAN1700000000", "KENAIKAN (PENURUNAN) ASET NETO"),
  LPAN1800000000("LPAN1800000000", "ASET NETO AWAL PERIODE"),
  LPAN1900000000("LPAN1900000000", "ASET NETO AKHIR PERIODE"),;

  public static final String POS_SALDO = "2";

  @Getter
  private String key;
  private String value;

  public static String getName() {
    return ER5602LPAN.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5602LPAN.class.getSimpleName().substring(2, 6));
  }

  public String getKeyForm() {
    return EFormLbbptkjht.LPAN.getCode() + key;
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
    for (ER5602LPAN eEnum : ER5602LPAN.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static List<KeyValueString> getObjectsForm() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5602LPAN eEnum : ER5602LPAN.values()) {
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

  public static SegmentValidation genRowValidation04() {
    int[] rows = { 3, 4, 5, 6, 7, 8, 9 };
    return genPlusValidation(POS_SALDO, LPAN0500000000, rows);
  };

  public static SegmentValidation genRowValidation15() {
    int[] rows = { 0, 1, 2, 10, 11, 12 };
    return genPlusValidation(POS_SALDO, LPAN0900000000, rows);
  };

  public static SegmentValidation genRowValidation21() {
    int[] rows = { 14, 15, 16, 17, 18 };
    return genPlusValidation(POS_SALDO, LPAN1600000000, rows);
  };

  public static SegmentValidation genRowValidation22() {
    int[] rows = { 13, 19 };
    return genMinusValidation(POS_SALDO, LPAN1700000000, rows);
  };

  public static SegmentValidation genRowValidation24() {
    int[] rows = { 20, 21 };
    return genPlusValidation(POS_SALDO, LPAN1900000000, rows);
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
