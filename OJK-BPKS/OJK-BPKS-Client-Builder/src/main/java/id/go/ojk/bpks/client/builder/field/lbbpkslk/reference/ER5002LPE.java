package id.go.ojk.bpks.client.builder.field.lbbpkslk.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER5002LPE implements IObject<KeyValueString> {
  LPE0100000000("LPE0100000000", "SALDO AWAL PERIODE SEBELUMNYA"),
  LPE0200000000("LPE0200000000", "Tambahan modal"),
  LPE0300000000("LPE0300000000", "Penghasilan (beban) neto"),
  LPE0400000000("LPE0400000000", "Kontribusi kepada program kesehatan"),
  LPE0500000000("LPE0500000000", "Penyesuaian nilai wajar aset keuangan tersedia untuk dijual"),
  LPE0600000000("LPE0600000000", "Keuntungan (kerugian) aktuaria liabilitas pascakerja imbalan pasti"),
  LPE0700000000("LPE0700000000", "Bagian penghasilan komprehensif lain entitas asosiasi dan entitas anak"),
  LPE0800000000("LPE0800000000", "Selisih transaksi dengan pihak nonpengendali"),
  LPE0900000000("LPE0900000000", "Selisih kombinasi dan pelepasan bisnis antar entitas sepengendali"),
  LPE1000000000("LPE1000000000", "SALDO AKHIR PERIODE SEBELUMNYA"),
  LPE1100000000("LPE1100000000", "Tambahan modal"),
  LPE1200000000("LPE1200000000", "Penghasilan (beban) neto"),
  LPE1300000000("LPE1300000000", "Kontribusi kepada program kesehatan"),
  LPE1400000000("LPE1400000000", "Penyesuaian nilai wajar aset keuangan tersedia untuk dijual"),
  LPE1500000000("LPE1500000000", "Keuntungan (kerugian) aktuaria liabilitas pascakerja imbalan pasti"),
  LPE1600000000("LPE1600000000", "Bagian penghasilan komprehensif lain entitas asosiasi dan entitas anak"),
  LPE1700000000("LPE1700000000", "Selisih transaksi dengan pihak nonpengendali"),
  LPE1800000000("LPE1800000000", "Selisih kombinasi dan pelepasan bisnis antar entitas sepengendali"),
  LPE1900000000("LPE1900000000", "SALDO AKHIR PERIODE BERJALAN"),;

  @Getter
  private String key;
  private String value;

  public static String getName() {
    return ER5002LPE.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5002LPE.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5002LPE eEnum : ER5002LPE.values()) {
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
    return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 9), getObjects());
  }

  public static ConditionalRequired genConditionalExist03() {
    int[] rows = { 0, 1, 9, 10, 18 };
    return genConditionalMustExist(rows);
  }

  public static ConditionalRequired genConditionalExist04() {
    int[] rows = { 0, 4, 9, 13, 18 };
    return genConditionalMustExist(rows);
  }

  public static ConditionalRequired genConditionalExist05() {
    int[] rows = { 0, 5, 9, 14, 18 };
    return genConditionalMustExist(rows);
  }

  public static ConditionalRequired genConditionalExist06() {
    int[] rows = { 0, 6, 9, 15, 18 };
    return genConditionalMustExist(rows);
  }

  public static ConditionalRequired genConditionalExist07() {
    int[] rows = { 0, 7, 9, 16, 18 };
    return genConditionalMustExist(rows);
  }

  public static ConditionalRequired genConditionalExist08() {
    int[] rows = { 0, 8, 9, 17, 18 };
    return genConditionalMustExist(rows);
  }

  public static ConditionalRequired genConditionalExist09() {
    int[] rows = { 0, 2, 3, 5, 9, 11, 12, 18 };
    return genConditionalMustExist(rows);
  }

  public static SegmentValidation genColValidation03a() {
    return genSubtotalValidation("2", LPE1000000000.key, new int[] { 0, 1 }, LPE1000000000.value);
  }

  public static SegmentValidation genColValidation03b() {
    return genSubtotalValidation("2", LPE1900000000.key, new int[] { 9, 10 }, LPE1900000000.value);
  }

  public static SegmentValidation genColValidation04a() {
    return genSubtotalValidation("3", LPE1000000000.key, new int[] { 0, 4 }, LPE1000000000.value);
  }

  public static SegmentValidation genColValidation04b() {
    return genSubtotalValidation("3", LPE1900000000.key, new int[] { 9, 13 }, LPE1900000000.value);
  }

  public static SegmentValidation genColValidation05a() {
    return genSubtotalValidation("4", LPE1000000000.key, new int[] { 0, 5 }, LPE1000000000.value);
  }

  public static SegmentValidation genColValidation05b() {
    return genSubtotalValidation("4", LPE1900000000.key, new int[] { 9, 14 }, LPE1900000000.value);
  }

  public static SegmentValidation genColValidation06a() {
    return genSubtotalValidation("5", LPE1000000000.key, new int[] { 0, 6 }, LPE1000000000.value);
  }

  public static SegmentValidation genColValidation06b() {
    return genSubtotalValidation("5", LPE1900000000.key, new int[] { 9, 15 }, LPE1900000000.value);
  }

  public static SegmentValidation genColValidation07a() {
    return genSubtotalValidation("6", LPE1000000000.key, new int[] { 0, 7 }, LPE1000000000.value);
  }

  public static SegmentValidation genColValidation07b() {
    return genSubtotalValidation("6", LPE1900000000.key, new int[] { 9, 16 }, LPE1900000000.value);
  }

  public static SegmentValidation genColValidation08a() {
    return genSubtotalValidation("7", LPE1000000000.key, new int[] { 0, 8 }, LPE1000000000.value);
  }

  public static SegmentValidation genColValidation08b() {
    return genSubtotalValidation("7", LPE1900000000.key, new int[] { 9, 17 }, LPE1900000000.value);
  }

  public static SegmentValidation genColValidation09a() {
    return genSubtotalValidation("8", LPE1000000000.key, new int[] { 0, 2, 3, 5 }, LPE1000000000.value);
  }

  public static SegmentValidation genColValidation09b() {
    return genSubtotalValidation("8", LPE1900000000.key, new int[] { 9, 11, 12 }, LPE1900000000.value);
  }

  public static SegmentValidation genColValidation10a() {
    return genSubtotalValidation("9", LPE1000000000.key, new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 }, LPE1000000000.value);
  }

  public static SegmentValidation genColValidation10b() {
    return genSubtotalValidation("9", LPE1900000000.key, new int[] { 9, 10, 11, 12, 13, 14, 15, 16, 17 },
        LPE1900000000.value);
  }

  public static FieldValidation genFieldValidation10() {
    return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(2, 8),
        UtilMetadata.genPipeRow(getObjects()));
  }

  private static ConditionalRequired genConditionalMustExist(int rows[]) {
    return UtilFieldConditional.genExistPos("M", "N", UtilMetadata.genPipeRow(ER5002LPE.getObjects(), rows));
  }

  private static SegmentValidation genSubtotalValidation(String selectField, String selectPosCode, int[] rows,
      String errMsgField) {
    return UtilSegmentValidation.genEqualsFormula(selectField, selectPosCode,
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(errMsgField, UtilMetadata.genPlusDesc(getObjects(), rows)));
  }
}
