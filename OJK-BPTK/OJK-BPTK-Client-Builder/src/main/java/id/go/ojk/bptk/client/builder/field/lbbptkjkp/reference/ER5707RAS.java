package id.go.ojk.bptk.client.builder.field.lbbptkjkp.reference;

import java.util.ArrayList;
import java.util.List;

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
public enum ER5707RAS implements IObject<KeyValueString> {
  RAS0101010000("RAS0101010000", "a. Piutang Iuran subsidi Pemerintah"),
  RAS0101020000("RAS0101020000", "b. Pendapatan Iuran s.d Laporan"),
  RAS0101030000("RAS0101030000", "Rasio [1 - ( a : b )], Rasio Kolektibilitas Iuran"),
  RAS0102010000("RAS0102010000", "a. Beban jaminan kehilangan pekerjaan"),
  RAS0102020000("RAS0102020000", "b. Beban cadangan teknis"),
  RAS0102030000("RAS0102030000", "c. Pendapatan Iuran"),
  RAS0102040000("RAS0102040000", "Rasio [( a + b ) : c], Rasio Manfaat Terhadap Iuran"),
  RAS0201010000("RAS0201010000", "a. Total Aset Neto"),
  RAS0201020000("RAS0201020000", "b. Total Liabilitas"),
  RAS0201030000("RAS0201030000", "Rasio ( a : b ), Rasio Aset Neto Terhadap Liabilitas"),
  RAS0301010000("RAS0301010000", "a. Aset Lancar"),
  RAS0301020000("RAS0301020000", "b. Kewajiban Lancar"),
  RAS0301030000("RAS0301030000", "Rasio ( a : b ), Rasio Likuiditas"),
  RAS0302010000("RAS0302010000", "a. Aset Neto Akhir Periode"),
  RAS0302020000("RAS0302020000", "b. Pembayaran Klaim 12 Bulan Terakhir"),
  RAS0302030000("RAS0302030000", "Rasio [ a : ( b / 12 ) ], Rasio Kesehatan Keuangan"),
  RAS0303010000("RAS0303010000", "a.Total Investasi"),
  RAS0303020000("RAS0303020000", "b.Total cadangan Teknis"),
  RAS0303030000("RAS0303030000", "Rasio ( a : b ), Rasio Rasio Investasi Terhadap Cadangan Teknis"),
  RAS0401010000("RAS0401010000", "a. Hasil Investasi"),
  RAS0401020000("RAS0401020000", "b. Rata-Rata Investasi"),
  RAS0401030000("RAS0401030000", "Rasio (disetahunkan) ( a : b )"),
  RAS0501010000("RAS0501010000", "a. Aset Neto Periode Berjalan"),
  RAS0501020000("RAS0501020000", "b. Aset Neto Periode Sebelumnya"),
  RAS0501030000("RAS0501030000", "Rasio [( a : b ) - 1], Rasio Pertumbuhan Aset Neto"),;

  @Getter
  private String key;
  private String value;

  private static final String LPK = EFormLbbptkjkp.LPK.getCode();
  private static final String LPKOMP = EFormLbbptkjkp.LPKOMP.getCode();
  private static final String AI = EFormLbbptkjkp.AI.getCode();
  private static final String HAI = EFormLbbptkjkp.HAI.getCode();
  private static final String LPAN = EFormLbbptkjkp.LPAN.getCode();

  public static final int[] INT_ROWS = { 0, 1, 3, 4, 5, 7, 8, 10, 11, 13, 14, 16, 17, 19, 20, 22, 23 };
  public static final int[] PERCENT_ROWS = { 2, 6, 9, 12, 15, 18, 21, 24 };

  public static String getName() {
    return ER5707RAS.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5707RAS.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5707RAS eEnum : ER5707RAS.values()) {
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

  public static SegmentValidation genRowValidation08() {
    String rightFormula = RAS0102010000.key + "+" + RAS0102020000.key + "|" + RAS0102030000.key;
    String errMsg = "Rasio (" + RAS0102010000.value + " + " + RAS0102020000.value + ") / " + RAS0102030000.value;
    return UtilSegmentValidation.genEqualsRatio2("2", RAS0102040000.key, rightFormula, errMsg);
  }

  public static SegmentValidation genRowValidation11() {
    return genEqualsRatio("2", RAS0201010000, RAS0201020000, RAS0201030000);
  }

  public static SegmentValidation genRowValidation14() {
    return genEqualsRatio("2", RAS0301010000, RAS0301020000, RAS0301030000);
  }

  public static SegmentValidation genRowValidation17() {
    String rightFormula = RAS0302010000.key + "|" + RAS0302020000.key;
    String leftConstFormula = "12*";
    String errMsg = "Rasio " + RAS0302010000.value + " : (" + RAS0302020000.value + " / 12 )";
    return UtilSegmentValidation.genEqualsRatio2("2", RAS0302030000.key, rightFormula, errMsg, leftConstFormula, null);
  }

  public static SegmentValidation genRowValidation20() {
    return genEqualsRatio("2", RAS0303010000, RAS0303020000, RAS0303030000);
  }

  public static SegmentValidation genRowValidation23() {
    return genEqualsRatioByPeriod("2", RAS0401010000, RAS0401020000, RAS0401030000);
  }

  public static SegmentValidation genRowValidation26() {
    String rightFormula = RAS0501010000.key + "|" + RAS0501020000.key;
    String rightConstFormula = "-1";
    String errMsg = "Rasio ( " + RAS0501010000.value + " : " + RAS0501020000.value + " ) " + rightConstFormula;
    return UtilSegmentValidation.genEqualsRatio2("2", RAS0501030000.key, rightFormula, errMsg, null, rightConstFormula);
  }

  /* -- ANTAR FORM -- */
  public static SegmentValidation genRowValidation02() {
    String selecPosCode = RAS0101010000.key;
    String comparatorPosCode = ER5701LPK.LPK0103000000.getKey();
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, LPK, "2", comparatorPosCode);
  }

  public static SegmentValidation genRowValidation03() {
    String selecPosCode = RAS0101020000.key;
    int rows[] = { 0, 1 };
    String comparatorPosCode = UtilMetadata.genPlusRow(ER5702LPKOMP.getObjectsForm(), rows);
    String msgError = UtilMetadata.genPlusDesc(ER5702LPKOMP.getObjects(), rows) + " pada form " + LPKOMP;
    return UtilSegmentValidation.genEqualsFormulaForm("2", selecPosCode, "2", comparatorPosCode, msgError);
  }

  public static SegmentValidation genRowValidation05() {
    String selecPosCode = RAS0102010000.key;
    String comparatorPosCode = ER5702LPKOMP.LPKOMP1100000000.getKey();
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, LPKOMP, "2", comparatorPosCode);
  }

  public static SegmentValidation genRowValidation06() {
    String selecPosCode = RAS0102020000.key;
    String comparatorPosCode = ER5702LPKOMP.LPKOMP1200000000.getKey();
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, LPKOMP, "2", comparatorPosCode);
  }

  public static SegmentValidation genRowValidation07() {
    String selecPosCode = RAS0102030000.key;
    int rows[] = { 0, 1 };
    String comparatorPosCode = UtilMetadata.genPlusRow(ER5702LPKOMP.getObjectsForm(), rows);
    String msgError = UtilMetadata.genPlusDesc(ER5702LPKOMP.getObjects(), rows) + " pada form " + LPKOMP;
    return UtilSegmentValidation.genEqualsFormulaForm("2", selecPosCode, "2", comparatorPosCode, msgError);
  }

  public static SegmentValidation genRowValidation09() {
    String selecPosCode = RAS0201010000.key;
    String comparatorPosCode = ER5701LPK.LPK0600000000.getKey();
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, LPK, "2", comparatorPosCode);
  }

  public static SegmentValidation genRowValidation10() {
    String selecPosCode = RAS0201020000.key;
    String comparatorPosCode = ER5701LPK.LPK0400000000.getKey();
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, LPK, "2", comparatorPosCode);
  }

  public static SegmentValidation genRowValidation18() {
    String selecPosCode = RAS0303010000.key;
    String comparatorPosCode = ER5705AI.AI1100000000.getKey();
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, AI, "2", comparatorPosCode);
  }
  
  public static SegmentValidation genRowValidation19() {
    String selecPosCode = RAS0303020000.key;
    String comparatorPosCode = ER5701LPK.LPK0304000000.getKey();
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, LPK, "2", comparatorPosCode);
  }

  public static SegmentValidation genRowValidation21() {
    String selecPosCode = RAS0401010000.key;
    String comparatorPosCode = ER5706HAI.HAI1100000000.getKey();
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, HAI, "2", comparatorPosCode);
  }

  public static SegmentValidation genRowValidation24() {
    String selecPosCode = RAS0501010000.key;
    String comparatorPosCode = ER5703LPAN.LPAN0500000000.getKey();
    return UtilSegmentValidation.genEqualsForm("2", selecPosCode, LPAN, "2", comparatorPosCode);
  }

  public static SegmentValidation genRowValidation25() {
    int rows[] = { 0, 4, 8, 12 };
    String selecPosCode = RAS0501020000.key;
    String comparatorPosCode = UtilMetadata.genPlusRow(ER5703LPAN.getObjectsForm(), rows);
    String msgError = UtilMetadata.genPlusDesc(ER5703LPAN.getObjects(), rows) + " pada form " + LPAN;
    return UtilSegmentValidation.genEqualsFormulaForm("2", selecPosCode, "2", comparatorPosCode, msgError);
  }

  private static SegmentValidation genEqualsRatio(String selectField, IObject<KeyValueString> posCode1,
      IObject<KeyValueString> posCode2, IObject<KeyValueString> expected) {
    KeyValueString kv1 = posCode1.getObject();
    KeyValueString kv2 = posCode2.getObject();
    String errMsg = "Rasio " + kv1.getValue() + " : " + kv2.getValue();
    return genEqualsRatio(selectField, posCode1, posCode2, expected, false, errMsg);
  }

  private static SegmentValidation genEqualsRatioByPeriod(String selectField, IObject<KeyValueString> posCode1,
      IObject<KeyValueString> posCode2, IObject<KeyValueString> expected) {
    KeyValueString kv1 = posCode1.getObject();
    KeyValueString kv2 = posCode2.getObject();
    String errMsg = expected.getObject().getValue();//"Rasio (disetahunkan) (" + kv1.getValue() + " : " + kv2.getValue() + ")";
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
}
