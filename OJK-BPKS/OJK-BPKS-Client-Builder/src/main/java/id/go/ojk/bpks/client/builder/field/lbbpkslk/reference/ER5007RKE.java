package id.go.ojk.bpks.client.builder.field.lbbpkslk.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bpks.client.builder.field.EFormLbbpkslk;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER5007RKE implements IObject<KeyValueString> {
  RKE0101010000("RKE0101010000", "a. Beban Operasional Rasio Beban Terhadap Pendapatan Operasional"),
  RKE0101020000("RKE0101020000", "b. Pendapatan Operasional Rasio Beban Terhadap Pendapatan Operasional"),
  RKE0101030000("RKE0101030000", "c. Rasio ( a : b ) Rasio Beban Terhadap Pendapatan Operasional"),
  RKE0102010000("RKE0102010000", "a. Beban Operasional Rasio Beban Terhadap Pendapatan Operasional dan Pendapatan Investasi"),
  RKE0102020000("RKE0102020000", "b. Pendapatan Operasional Rasio Beban Terhadap Pendapatan Operasional dan Pendapatan Investasi"),
  RKE0102030000("RKE0102030000", "c. Pendapatan Investasi Rasio Beban Terhadap Pendapatan Operasional dan Pendapatan Investasi"),
  RKE0102040000("RKE0102040000", "d. Rasio ( a : ( b + c ) ) Rasio Beban Terhadap Pendapatan Operasional dan Pendapatan Investasi"),
  RKE0201010000("RKE0201010000", "a. Total Aset Neto Rasio Aset Neto Terhadap Liabilitas"),
  RKE0201020000("RKE0201020000", "b. Total Liabilitas Rasio Aset Neto Terhadap Liabilitas"),
  RKE0201030000("RKE0201030000", "c. Rasio ( a : b ) Rasio Aset Neto Terhadap Liabilitas"),
  RKE0301010000("RKE0301010000", "a. Aset Lancar Rasio Likuiditas"),
  RKE0301020000("RKE0301020000", "b. Kewajiban Lancar Rasio Likuiditas"),
  RKE0301030000("RKE0301030000", "c. Rasio ( a : b ) Rasio Likuiditas"),
  RKE0401010000("RKE0401010000", "a. Hasil Investasi Rasio Hasil Investasi"),
  RKE0401020000("RKE0401020000", "b. Rata-Rata Investasi Rasio Hasil Investasi"),
  RKE0401030000("RKE0401030000", "c. Rasio (disetahunkan) ( a : b ) / ( bulan * 12 ) Rasio Hasil Investasi"),
  RKE0402010000("RKE0402010000", "a. Pendapatan Neto Rasio Pendapatan terhadap Aset (RoA) dan terhadap Aset Neto (ROE)"),
  RKE0402020000("RKE0402020000", "b. Aset Rasio Pendapatan terhadap Aset (RoA) dan terhadap Aset Neto (ROE)"),
  RKE0402030000("RKE0402030000", "c. Aset Neto Rasio Pendapatan terhadap Aset (RoA) dan terhadap Aset Neto (ROE)"),
  RKE0402040000("RKE0402040000", "d. Rasio RoA (a : b) / bulan * 12 Rasio Pendapatan terhadap Aset (RoA) dan terhadap Aset Neto (ROE)"),
  RKE0402050000("RKE0402050000", "e. Rasio RoE (a : c) / bulan * 12 Rasio Pendapatan terhadap Aset (RoA) dan terhadap Aset Neto (ROE)"),
  RKE0501010000("RKE0501010000", "a. Aset Neto Periode Berjalan Rasio Pertumbuhan Aset Neto"),
  RKE0501020000("RKE0501020000", "b. Aset Neto Periode Sebelumnya Rasio Pertumbuhan Aset Neto"),
  RKE0501030000("RKE0501030000", "c. Rasio [( a : b ) - 1] Rasio Pertumbuhan Aset Neto"),
  RKE0601000000("RKE0601000000", "a. Beban Penyusutan Beban Penyusutan terhadap Beban Operasional"),
  RKE0602000000("RKE0602000000", "b. Beban Operasional Beban Penyusutan terhadap Beban Operasional"),
  RKE0603000000("RKE0603000000", "c. Rasio ( a : b ) Beban Penyusutan terhadap Beban Operasional"),;

  @Getter
  private String key;
  private String value;

  public static final int[] INT_ROWS = { 0, 1, 3, 4, 5, 7, 8, 10, 11, 13, 16, 17, 18, 21, 22, 24, 25 };
  public static final int[] PERCENT_ROWS = { 2, 6, 9, 12, 14, 15, 19, 20, 23, 26 };

  public static final String LKK = EFormLbbpkslk.LKK.getCode();
  public static final String LPK = EFormLbbpkslk.LPK.getCode();
  public static final String HIN = EFormLbbpkslk.HIN.getCode();
  public static final String ALM = EFormLbbpkslk.ALM.getCode();

  public static String getName() {
    return ER5007RKE.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5007RKE.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5007RKE eEnum : ER5007RKE.values()) {
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
    return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 6), getObjects());
  }

  public static SegmentValidation genValidationTypeNumericNegative() {
    return UtilSegmentValidation.genRegexNumericNegative("2", UtilMetadata.genPipeRow(getObjects(), INT_ROWS));
  }

  public static SegmentValidation genValidationTypeNumericDotNegative() {
    return UtilSegmentValidation.genRegexNumericDotNegative("2", UtilMetadata.genPipeRow(getObjects(), PERCENT_ROWS));
  }

  public static SegmentValidation genValidationLength20() {
    return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects()), 20);
  }

  public static SegmentValidation genRowValidation04() {
    String errMsg = RKE0101030000.value + " | Rasio (" + RKE0101010000.value + " : " + RKE0101020000.value + " )";
    return genEqualsRatio("2", RKE0101010000, RKE0101020000, RKE0101030000, errMsg);
  }

  public static SegmentValidation genRowValidation05() {
    int[] rows = { 0 };
    return UtilSegmentValidation.genEqualsFormula("2", RKE0102010000.key, UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(RKE0102010000.value, UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation06() {
    int[] rows = { 1 };
    return UtilSegmentValidation.genEqualsFormula("2", RKE0102020000.key, UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(RKE0102020000.value, UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation08() {
    String rightFormula = RKE0102010000.key + "|" + RKE0102020000.key + "+" + RKE0102030000.key;
    String errMsg = RKE0102040000.value + " | " + RKE0102010000.value + " : (" + RKE0102020000.value + " + " + RKE0102030000.value + ")";
    return UtilSegmentValidation.genEqualsRatio2("2", RKE0102040000.key, rightFormula, errMsg);
  }

  public static SegmentValidation genRowValidation11() {
    String errMsg = RKE0201030000.value + " | Rasio (" + RKE0201010000.value + " : " + RKE0201020000.value + " )";
    return genEqualsRatio("2", RKE0201010000, RKE0201020000, RKE0201030000, errMsg);
  }

  public static SegmentValidation genRowValidation14() {
    String errMsg = RKE0301030000.value + " | Rasio (" + RKE0301010000.value + " : " + RKE0301020000.value + " )";
    return genEqualsRatio("2", RKE0301010000, RKE0301020000, RKE0301030000, errMsg);
  }

  public static SegmentValidation genRowValidation15() {
    int[] rows = { 5 };
    return UtilSegmentValidation.genEqualsFormula("2", RKE0401010000.key,
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(RKE0401010000.value, UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation17() {
    String errMsg = RKE0401030000.value + " | (" + RKE0401010000.value + " : " + RKE0401020000.value + " ) / ( bulan periode laporan * 12)";
    return genEqualsRatioByPeriod("2", RKE0401010000, RKE0401020000, RKE0401030000, errMsg);
  }

  public static SegmentValidation genRowValidation20() {
    int[] rows = { 7 };
    return UtilSegmentValidation.genEqualsFormula("2", RKE0402030000.key,
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(RKE0402030000.value, UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation21() {
    String errMsg = RKE0402040000.value + " | (" + RKE0402010000.value + " : " + RKE0402020000.value + " ) / ( bulan periode laporan * 12)";
    return genEqualsRatioByPeriod("2", RKE0402010000, RKE0402020000, RKE0402040000, errMsg);
  }

  public static SegmentValidation genRowValidation22() {
    String errMsg = RKE0402050000.value + " | (" + RKE0402010000.value + " : " + RKE0402030000.value + " ) / ( bulan periode laporan * 12)";
    return genEqualsRatioByPeriod("2", RKE0402010000, RKE0402030000, RKE0402050000, errMsg);
  }

  public static SegmentValidation genRowValidation23() {
    int[] rows = { 7 };
    return UtilSegmentValidation.genEqualsFormula("2", RKE0501010000.key,
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(RKE0501010000.value, UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation25() {
    String rightFormula = RKE0501010000.key + "|" + RKE0501020000.key;
    String rightConstFormula = "- 1";
    String errMsg = RKE0501030000.value + " | ( " + RKE0501010000.value + " : " + RKE0501020000.value + " ) " + rightConstFormula;
    return UtilSegmentValidation.genEqualsRatio2("2", RKE0501030000.key, rightFormula, errMsg, null, rightConstFormula);
  }

  public static SegmentValidation genRowValidation27() {
    int[] rows = { 0 };
    return UtilSegmentValidation.genEqualsFormula("2", RKE0602000000.key,
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(RKE0602000000.value, UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation28() {
    String errMsg = RKE0603000000.value + " | Rasio (" + RKE0601000000.value + " : " + RKE0602000000.value + " )";
    return genEqualsRatio("2", RKE0601000000, RKE0602000000, RKE0603000000, errMsg);
  }

  private static SegmentValidation genEqualsRatio(String selectField, IObject<KeyValueString> posCode1,
      IObject<KeyValueString> posCode2, IObject<KeyValueString> expected, String errMsg) {
    return genEqualsRatio(selectField, posCode1, posCode2, expected, false, errMsg);
  }

  private static SegmentValidation genEqualsRatioByPeriod(String selectField, IObject<KeyValueString> posCode1,
      IObject<KeyValueString> posCode2, IObject<KeyValueString> expected, String errMsg) {
    return genEqualsRatio(selectField, posCode1, posCode2, expected, true, errMsg);
  }

  private static SegmentValidation genEqualsRatio(String selectField, IObject<KeyValueString> posCode1,
      IObject<KeyValueString> posCode2, IObject<KeyValueString> expected, boolean divByPeriod, String errMsg) {
    KeyValueString kv1 = posCode1.getObject();
    KeyValueString kv2 = posCode2.getObject();
    String rightFormula = kv1.getKey() + "|" + kv2.getKey();
    return UtilSegmentValidation.genEqualsRatio2(selectField, expected.getObject().getKey(), rightFormula, errMsg,
        divByPeriod);
  }

  /* -- ANTAR FORM -- */
  public static SegmentValidation genRowValidation02() {
    String selecPosCode = RKE0101010000.key;
    String comparatorPosCode = ER5001LKK.LKK0400000000.getKey();
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, LKK, "2", comparatorPosCode);
  }

  public static SegmentValidation genRowValidation03() {
    String selecPosCode = RKE0101020000.key;
    String comparatorPosCode = ER5001LKK.LKK0200000000.getKey();
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, LKK, "2", comparatorPosCode);
  }

  public static SegmentValidation genRowValidation07() {
    String selecPosCode = RKE0102030000.key;
    String comparatorPosCode = ER5001LKK.LKK0601000000.getKey();
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, LKK, "2", comparatorPosCode);
  }

  public static SegmentValidation genRowValidation09() {
    String selecPosCode = RKE0201010000.key;
    String comparatorPosCode = ER5000LPK.LPK0600000000.getKey();
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, LPK, "2", comparatorPosCode);
  }

  public static SegmentValidation genRowValidation10() {
    String selecPosCode = RKE0201020000.key;
    String comparatorPosCode = ER5000LPK.LPK0400000000.getKey();
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, LPK, "2", comparatorPosCode);
  }

  public static SegmentValidation genRowValidation12() {
    String selecPosCode = RKE0301010000.key;
    String comparatorPosCode = ER5006ALM.ALM0100000000.getKey();
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, ALM, "4", comparatorPosCode);
  }

  public static SegmentValidation genRowValidation13() {
    String selecPosCode = RKE0301020000.key;
    String comparatorPosCode = ER5006ALM.ALM0400000000.getKey();
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, ALM, "4", comparatorPosCode);
  }

  public static SegmentValidation genRowValidation16() {
    String selecPosCode = RKE0401020000.key;
    String comparatorPosCode = ER5005HIN.HIN0600000000.getKey();
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, HIN, "5", comparatorPosCode);
  }

  public static SegmentValidation genRowValidation18() {
    String selecPosCode = RKE0402010000.key;
    String comparatorPosCode = ER5001LKK.LKK1000000000.getKey();
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, LKK, "2", comparatorPosCode);
  }

  public static SegmentValidation genRowValidation19() {
    String selecPosCode = RKE0402020000.key;
    String comparatorPosCode = ER5000LPK.LPK0200000000.getKey();
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, LPK, "2", comparatorPosCode);
  }
}
