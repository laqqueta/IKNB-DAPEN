package id.go.ojk.bpks.client.builder.field.lbbpksdjs.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bpks.client.builder.field.EFormLbbpksdjs;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER5106RKU implements IObject<KeyValueString> {
  RKU0101010000("RKU0101010000", "a. Piutang Iuran"),
  RKU0101020000("RKU0101020000", "b. Pendapatan Iuran setahun"),
  RKU0101030000("RKU0101030000", "c. Rasio [1 - ( a : b )]"),
  RKU0102010000("RKU0102010000", "a. Beban jaminan kesehatan"),
  RKU0102020000("RKU0102020000", "b. Beban cadangan teknis"),
  RKU0102030000("RKU0102030000", "c. Pendapatan Iuran"),
  RKU0102040000("RKU0102040000", "d. Rasio [( a + b ) : c]"),
  RKU0201010000("RKU0201010000", "a. Total Aset Neto"),
  RKU0201020000("RKU0201020000", "b. Total Liabilitas"),
  RKU0201030000("RKU0201030000", "c. Rasio ( a : b )"),
  RKU0301010000("RKU0301010000", "a. Aset Lancar"),
  RKU0301020000("RKU0301020000", "b. Kewajiban Lancar"),
  RKU0301030000("RKU0301030000", "c. Rasio ( a : b )"),
  RKU0302010000("RKU0302010000", "a. Aset Neto Akhir Periode"),
  RKU0302020000("RKU0302020000", "b. Pembayaran klaim 12 bulan terakhir"),
  RKU0302030000("RKU0302030000", "c. Rasio [ a : ( b / 12 )]"),
  RKU0303010000("RKU0303010000", "a. Total Investasi"),
  RKU0303020000("RKU0303020000", "b. Total cadangan Teknis"),
  RKU0303030000("RKU0303030000", "c. Rasio ( a : b )"),
  RKU0401010000("RKU0401010000", "a. Hasil Investasi"),
  RKU0401020000("RKU0401020000", "b. Rata-Rata Investasi"),
  RKU0401030000("RKU0401030000", "c. Rasio (disetahunkan) ( a : b )"),
  RKU0501010000("RKU0501010000", "a. Aset Neto Periode Berjalan"),
  RKU0501020000("RKU0501020000", "b. Aset Neto Periode Sebelumnya"),
  RKU0501030000("RKU0501030000", "c. Rasio [( a : b ) - 1]"),
  RKU0601000000("RKU0601000000", "a. Aset Neto"),
  RKU0602000000("RKU0602000000", "b. Rata-rata beban pelayanan kesehatan bulanan selama 12 bulan terakhir"),
  RKU0603000000("RKU0603000000", "c. Jumlah bulan tercukupi (a : b)"),;

  @Getter
  private String key;
  private String value;

  public static final int[] INT_ROWS = { 0, 1, 3, 4, 5, 7, 8, 10, 11, 13, 14, 16, 17, 19, 20, 22, 23, 25, 26 };
  public static final int[] PERCENT_ROWS = { 2, 6, 9, 12, 15, 18, 21, 24, 27 };

  public static final String AIN = EFormLbbpksdjs.AIN.getCode();
  public static final String ALM = EFormLbbpksdjs.ALM.getCode();
  public static final String HIN = EFormLbbpksdjs.HIN.getCode();
  public static final String LAV = EFormLbbpksdjs.LAV.getCode();
  public static final String LPK = EFormLbbpksdjs.LPK.getCode();
  public static final String LPAN = EFormLbbpksdjs.LPAN.getCode();

  public static String getName() {
    return ER5106RKU.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5106RKU.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5106RKU eEnum : ER5106RKU.values()) {
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

  public static SegmentValidation genValidationTypeNumericNegative() {
    return UtilSegmentValidation.genRegexNumericNegative("2", UtilMetadata.genPipeRow(getObjects(), INT_ROWS));
  }

  public static SegmentValidation genValidationTypeNumericDotNegative() {
    return UtilSegmentValidation.genRegexNumericDotNegative("2", UtilMetadata.genPipeRow(getObjects(), PERCENT_ROWS));
  }

  public static SegmentValidation genValidationLength06() {
    return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), PERCENT_ROWS), 6);
  }

  public static SegmentValidation genValidationLength20() {
    return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), INT_ROWS), 20);
  }

  public static SegmentValidation genRowValidation04() {
    String rightFormula = RKU0101010000.key + "|" + RKU0101020000.key;
    String leftConstFormula = "1-";
    String errMsg = "Rasio 1 - ( " + RKU0101010000.value + " : " + RKU0101020000.value + " ) ";
    return UtilSegmentValidation.genEqualsRatio2("2", RKU0101030000.key, rightFormula, errMsg, leftConstFormula, null);
  }

  public static SegmentValidation genRowValidation08() {
    String rightFormula = RKU0102010000.key + "+" + RKU0102020000.key + "|" + RKU0102030000.key;
    String errMsg = "Rasio (" + RKU0102010000.value + " + " + RKU0102020000.value + ") / " + RKU0102030000.value;
    return UtilSegmentValidation.genEqualsRatio2("2", RKU0102040000.key, rightFormula, errMsg);
  }

  public static SegmentValidation genRowValidation11() {
    return genEqualsRatio("2", RKU0201010000, RKU0201020000, RKU0201030000);
  }

  public static SegmentValidation genRowValidation14() {
    return genEqualsRatio("2", RKU0301010000, RKU0301020000, RKU0301030000);
  }

  public static SegmentValidation genRowValidation17() {
    String rightFormula = RKU0302010000.key + "|" + RKU0302020000.key;
    String leftConstFormula = "12*";
    String errMsg = "Rasio " + RKU0302010000.value + " : (" + RKU0302020000.value + " / 12 )";
    return UtilSegmentValidation.genEqualsRatio2("2", RKU0302030000.key, rightFormula, errMsg, leftConstFormula, null);
  }

  public static SegmentValidation genRowValidation20() {
    return genEqualsRatio("2", RKU0303010000, RKU0303020000, RKU0303030000);
  }

  public static SegmentValidation genRowValidation23() {
    return genEqualsRatio("2", RKU0401010000, RKU0401020000, RKU0401030000);
  }

  public static SegmentValidation genRowValidation26() {
    String rightFormula = RKU0501010000.key + "|" + RKU0501020000.key;
    String rightConstFormula = "-1";
    String errMsg = "Rasio ( " + RKU0501010000.value + " : " + RKU0501020000.value + " ) " + rightConstFormula;
    return UtilSegmentValidation.genEqualsRatio2("2", RKU0501030000.key, rightFormula, errMsg, null, rightConstFormula);
  }

  public static SegmentValidation genRowValidation27() {
    int[] rows = { 7 };
    return UtilSegmentValidation.genEqualsFormula("2", RKU0601000000.key, RKU0201010000.key,
        UtilMetadata.genMessage(RKU0601000000.value, UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation29() {
    return genEqualsRatio("2", RKU0601000000, RKU0602000000, RKU0603000000);
  }

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

  /* -- ANTAR FORM -- */
  public static SegmentValidation genRowValidation02() {
    String selecPosCode = RKU0101010000.key;
    String comparatorPosCode = ER5100LPK.LPK0103000000.getKey();
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, LPK, "2", comparatorPosCode);
  }

  public static SegmentValidation genRowValidation03() {
    String selecPosCode = RKU0101020000.key;
    String comparatorPosCode = ER5101LAV.LAV0101000000.getKey();
    String rightExpr = "* 12";
    return UtilSegmentValidation.genEqualsForm5("2", selecPosCode, "2", LAV, comparatorPosCode, null, rightExpr);
  }

  public static SegmentValidation genRowValidation05() {
    String selecPosCode = RKU0102010000.key;
    String comparatorPosCode = ER5101LAV.LAV0301000000.getKey();
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, LAV, "2", comparatorPosCode);
  }

  public static SegmentValidation genRowValidation06() {
    String selecPosCode = RKU0102020000.key;
    String comparatorPosCode = ER5101LAV.LAV0302000000.getKey();
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, LAV, "2", comparatorPosCode);
  }

  public static SegmentValidation genRowValidation07() {
    String selecPosCode = RKU0102030000.key;
    String comparatorPosCode = ER5101LAV.LAV0101000000.getKey();
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, LAV, "2", comparatorPosCode);
  }

  public static SegmentValidation genRowValidation09() {
    String selecPosCode = RKU0201010000.key;
    String comparatorPosCode = ER5100LPK.LPK0600000000.getKey();
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, LPK, "2", comparatorPosCode);
  }

  public static SegmentValidation genRowValidation10() {
    String selecPosCode = RKU0201020000.key;
    String comparatorPosCode = ER5100LPK.LPK0400000000.getKey();
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, LPK, "2", comparatorPosCode);
  }

  public static SegmentValidation genRowValidation12() {
    String selecPosCode = RKU0301010000.key;
    String comparatorPosCode = ER5107ALM.ALM0200000000.getKey();
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, ALM, "4", comparatorPosCode);
  }

  public static SegmentValidation genRowValidation13() {
    String selecPosCode = RKU0301020000.key;
    String comparatorPosCode = ER5107ALM.ALM0400000000.getKey();
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, ALM, "4", comparatorPosCode);
  }

  public static SegmentValidation genRowValidation18() {
    String selecPosCode = RKU0303010000.key;
    String comparatorPosCode = ER5104AIN.AIN0500000000.getKey();
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, AIN, "2", comparatorPosCode);
  }

  public static SegmentValidation genRowValidation19() {
    String selecPosCode = RKU0303020000.key;
    String comparatorPosCode = ER5100LPK.LPK0308000000.getKey();
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, LPK, "2", comparatorPosCode);
  }

  public static SegmentValidation genRowValidation22() {
    String selecPosCode = RKU0401020000.key;
    String comparatorPosCode = ER5105HIN.HIN0500000000.getKey();
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, HIN, "5", comparatorPosCode);
  }

  public static SegmentValidation genRowValidation24() {
    String selecPosCode = RKU0501010000.key;
    String comparatorPosCode = ER5100LPK.LPK0600000000.getKey();
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, LPK, "2", comparatorPosCode);
  }

  public static SegmentValidation genRowValidation25() {
    String selecPosCode = RKU0501020000.key;
    String comparatorPosCode = ER5103LPAN.LPAN0103000000.getKey();
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, LPAN, "3", comparatorPosCode);
  }

  public static SegmentValidation genRowValidation02b() {
    String selecPosCode = RKU0101010000.key;
    String comparatorPosCode = ER5100LPK.LPK0103000000.getKey();
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, LPK, "2", comparatorPosCode);
  }

  public static SegmentValidation genRowValidation05b() {
    String selecPosCode = RKU0102010000.key;
    String comparatorPosCode = ER5101LAV.LAV0301000000.getKey();
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, LAV, "2", comparatorPosCode);
  }

  public static SegmentValidation genRowValidation09b() {
    String selecPosCode = RKU0201010000.key;
    String comparatorPosCode = ER5100LPK.LPK0600000000.getKey();
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, LPK, "2", comparatorPosCode);
  }

  public static SegmentValidation genRowValidation10b() {
    String selecPosCode = RKU0201020000.key;
    String comparatorPosCode = ER5100LPK.LPK0400000000.getKey();
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, LPK, "2", comparatorPosCode);
  }
}
