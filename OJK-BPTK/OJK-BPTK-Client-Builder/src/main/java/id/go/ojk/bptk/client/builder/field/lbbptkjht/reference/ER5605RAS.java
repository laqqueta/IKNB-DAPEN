package id.go.ojk.bptk.client.builder.field.lbbptkjht.reference;

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
public enum ER5605RAS implements IObject<KeyValueString> {
  RAS0101010000("RAS0101010000", "a. Piutang Iuran"),
  RAS0101020000("RAS0101020000", "b. Pendapatan Iuran setahun"),
  RAS0101030000("RAS0101030000", "Rasio [1 - ( a : b )], Rasio Kolektibilitas Iuran"),
  RAS0102010000("RAS0102010000", "a. Aset Neto Akhir Periode"),
  RAS0102020000("RAS0102020000", "b. Utang jaminan hari tua siap bayar"),
  RAS0102030000("RAS0102030000", "c. Liabilitas jaminan hari tua jatuh tempo"),
  RAS0102040000("RAS0102040000", "d. Liabilitas jaminan hari tua jatuh tempo parsial"),
  RAS0102050000("RAS0102050000", "Rasio [ a : (b + c + d )], Rasio Aset Neto Terhadap Liabilitas JHT"),
  RAS0201010000("RAS0201010000", "a. Total Aset Neto"),
  RAS0201020000("RAS0201020000", "b. Total Liabilitas"),
  RAS0201030000("RAS0201030000", "Rasio ( a : b ), Rasio Aset Neto Terhadap Liabilitas"),
  RAS0202010000("RAS0202010000", "a. Total Aset"),
  RAS0202020000("RAS0202020000", "b. Total Kewajiban Kepada Peserta"),
  RAS0202020100("RAS0202020100", "Dana Peserta"),
  RAS0202020200("RAS0202020200", "Hasil Pengembangan - Realized"),
  RAS0202020300("RAS0202020300", "Utang Jaminan"),
  RAS0202030000("RAS0202030000", "Rasio ( a : b ), Rasio Aset terhadap Kewajiban Kepada Peserta"),
  RAS0301010000("RAS0301010000", "a. Aset Lancar"),
  RAS0301020000("RAS0301020000", "b. Kewajiban Lancar"),
  RAS0301030000("RAS0301030000", "Rasio ( a : b ), Rasio Likuiditas"),
  RAS0302010000("RAS0302010000", "a. Aset Neto Akhir Periode"),
  RAS0302020000("RAS0302020000", "b. Pembayaran Klaim 12 Bulan Terakhir"),
  RAS0302030000("RAS0302030000", "Rasio [ a : ( b / 12 ) ], Rasio Kesehatan Keuangan"),
  RAS0303010000("RAS0303010000", "a. Total Investasi"),
  RAS0303020000("RAS0303020000", "b. Utang jaminan hari tua siap bayar"),
  RAS0303030000("RAS0303030000", "c. Liabilitas jaminan hari tua jatuh tempo"),
  RAS0303040000("RAS0303040000", "d. Liabilitas jaminan hari tua jatuh tempo parsial"),
  RAS0303050000("RAS0303050000", "e. Aset Neto"),
  RAS0303060000("RAS0303060000", "Rasio [ a : (b + c + d + e )], Rasio Investasi Terhadap Liabilitas JHT dan Aset Neto"),
  RAS0304010000("RAS0304010000", "a. Total Aset"),
  RAS0304020000("RAS0304020000", "b. Total Investasi"),
  RAS0304030000("RAS0304030000", "Rasio ( a : b ), Rasio Investasi Terhadap Total Aset"),
  RAS0401010000("RAS0401010000", "a. Hasil Investasi"),
  RAS0401020000("RAS0401020000", "b. Rata-Rata Investasi"),
  RAS0401030000("RAS0401030000", "Rasio (disetahunkan) ( a : b ), Rasio Hasil Investasi"),
  RAS0501010000("RAS0501010000", "a. Aset Neto Periode Berjalan"),
  RAS0501020000("RAS0501020000", "b. Aset Neto Periode Sebelumnya"),
  RAS0501030000("RAS0501030000", "Rasio [( a : b ) - 1], Rasio Pertumbuhan Aset Neto"),;

  @Getter
  private String key;
  private String value;

  public static final int[] INT_ROWS = { 0, 1, 3, 4, 5, 6, 8, 9, 11, 12, 13, 14, 15, 17, 18, 20, 21, 23, 24, 25, 26, 27,
      29, 30, 32, 33, 35, 36 };
  public static final int[] PERCENT_ROWS = { 2, 7, 10, 16, 19, 22, 28, 31, 34, 37 };

  public static String getName() {
    return ER5605RAS.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5605RAS.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5605RAS eEnum : ER5605RAS.values()) {
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

  public static SegmentValidation genRegexValidation01() {
    return UtilSegmentValidation.genRegexNumericNegative("2", UtilMetadata.genPipeRow(getObjects(), INT_ROWS));
  }

  public static SegmentValidation genRegexValidation02() {
    return UtilSegmentValidation.genRegexNumericDotNegative("2", UtilMetadata.genPipeRow(getObjects(), PERCENT_ROWS));
  }

  public static SegmentValidation genMaxLengthValidation() {
    return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), PERCENT_ROWS), 15);
  }

  public static SegmentValidation genMaxLengthValidation2() {
    return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), INT_ROWS), 20);
  }

  public static SegmentValidation genRowValidation04() {
    String rightFormula = RAS0101010000.key + "|" + RAS0101020000.key;
    String leftConstFormula = "1 - ";
    String errMsg = "Rasio " + leftConstFormula + "( " + RAS0101010000.value + " : " + RAS0101020000.value + " )";
    return UtilSegmentValidation.genEqualsRatio2("2", RAS0101030000.key, rightFormula, errMsg, leftConstFormula, null);
  }

  public static SegmentValidation genRowValidation09() {
    String rightFormula = RAS0102010000.key + "|" + RAS0102020000.key + "+" + RAS0102030000.key + "+"
        + RAS0102040000.key;
    String errMsg = "Rasio " + RAS0102010000.value + " / (" + RAS0102020000.value + " + " + RAS0102030000.value + " + "
        + RAS0102040000.value + ")";
    return UtilSegmentValidation.genEqualsRatio2("2", RAS0102050000.key, rightFormula, errMsg);
  }

  public static SegmentValidation genRowValidation12() {
    return genEqualsRatio("2", RAS0201010000, RAS0201020000, RAS0201030000);
  }

  public static SegmentValidation genRowValidation14() {
    int[] rows = { 13, 14, 15 };
    return UtilSegmentValidation.genEqualsFormula("2", RAS0202020000.getObject().getKey(),
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(RAS0202020000.getObject().getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation18() {
    return genEqualsRatio("2", RAS0202010000, RAS0202020000, RAS0202030000);
  }

  public static SegmentValidation genRowValidation21() {
    return genEqualsRatio("2", RAS0301010000, RAS0301020000, RAS0301030000);
  }

  public static SegmentValidation genRowValidation24() {
    String rightFormula = RAS0302010000.key + "|" + RAS0302020000.key;
    String leftConstFormula = "12*";
    String errMsg = "Rasio " + RAS0302010000.value + " : (" + RAS0302020000.value + " / 12 )";
    return UtilSegmentValidation.genEqualsRatio2("2", RAS0302030000.key, rightFormula, errMsg, leftConstFormula, null);
  }

  public static SegmentValidation genRowValidation30() {
    String rightFormula = RAS0303010000.key + "|" + RAS0303020000.key + "+" + RAS0303030000.key + "+"
        + RAS0303040000.key + "+" + RAS0303050000.key;
    String errMsg = "Rasio " + RAS0303010000.value + " / (" + RAS0303020000.value + "+" + RAS0303030000.value + "+"
        + RAS0303040000.value + "+" + RAS0303050000.value + ")";
    return UtilSegmentValidation.genEqualsRatio2("2", RAS0303060000.key, rightFormula, errMsg);
  }

  public static SegmentValidation genRowValidation33() {
    return genEqualsRatio("2", RAS0304010000, RAS0304020000, RAS0304030000);
  }
  
  public static SegmentValidation genRowValidation36() {
    return genEqualsRatioByPeriod("2", RAS0401010000, RAS0401020000, RAS0401030000);
  }

  public static SegmentValidation genRowValidation39() {
    String rightFormula = RAS0501010000.key + "|" + RAS0501020000.key;
    String rightConstFormula = "-1";
    String errMsg = "Rasio ( " + RAS0501010000.value + " : " + RAS0501020000.value + " ) " + rightConstFormula;
    return UtilSegmentValidation.genEqualsRatio2("2", RAS0501030000.key, rightFormula, errMsg, null, rightConstFormula);
  }

  /* -- PRIVATE METHODS -- */

  private static SegmentValidation genEqualsRatio(String selectField, IObject<KeyValueString> posCode1,
      IObject<KeyValueString> posCode2, IObject<KeyValueString> expected) {
    KeyValueString kv1 = posCode1.getObject();
    KeyValueString kv2 = posCode2.getObject();
    String errMsg = "Rasio " + kv1.getValue() + " : " + kv2.getValue();
    return genEqualsRatio(selectField, posCode1, posCode2, expected, false, errMsg);
  }

  private static SegmentValidation genEqualsRatio(String selectField, IObject<KeyValueString> posCode1,
      IObject<KeyValueString> posCode2, IObject<KeyValueString> expected, boolean divByPeriod, String errMsg) {
    KeyValueString kv1 = posCode1.getObject();
    KeyValueString kv2 = posCode2.getObject();
    String rightFormula = kv1.getKey() + "|" + kv2.getKey();
    return UtilSegmentValidation.genEqualsRatio2(selectField, expected.getObject().getKey(), rightFormula, errMsg,
        divByPeriod);
  }

  private static SegmentValidation genEqualsRatioByPeriod(String selectField, IObject<KeyValueString> posCode1,
      IObject<KeyValueString> posCode2, IObject<KeyValueString> expected) {
    KeyValueString kv1 = posCode1.getObject();
    KeyValueString kv2 = posCode2.getObject();
    String errMsg = "Rasio (" + kv1.getValue() + " : " + kv2.getValue() + " ) / ( bulan periode laporan * 12) ";
    return genEqualsRatio(selectField, posCode1, posCode2, expected, true, errMsg);
  }
}
