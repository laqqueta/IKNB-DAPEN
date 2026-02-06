package id.go.ojk.bptk.client.builder.field.lbbptkbdn.reference;

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
public enum ER5307RAS implements IObject<KeyValueString> {
  RAS0101010000("RAS0101010000", "a. Beban Operasional"),
  RAS0101020000("RAS0101020000", "b. Pendapatan Operasional"),
  RAS0101030000("RAS0101030000", "Rasio ( a : b ), Rasio Beban Terhadap Pendapatan Operasional"),
  RAS0102010000("RAS0102010000", "a. Beban Operasional"),
  RAS0102020000("RAS0102020000", "b. Pendapatan Operasional"),
  RAS0102030000("RAS0102030000", "c. Pendapatan Investasi"),
  RAS0102040000("RAS0102040000", "Rasio ( a : (b + c) ), Rasio Beban Terhadap Pendapatan Operasional dan Pendapatan Investasi"),
  RAS0201010000("RAS0201010000", "a. Total Aset Neto"),
  RAS0201020000("RAS0201020000", "b. Total Liabilitas"),
  RAS0201030000("RAS0201030000", "Rasio ( a : b ), Rasio Aset Neto Terhadap Liabilitas"),
  RAS0301010000("RAS0301010000", "a. Aset Lancar"),
  RAS0301020000("RAS0301020000", "b. Kewajiban Lancar"),
  RAS0301030000("RAS0301030000", "Rasio Likuiditas, Rasio ( a : b )"),
  RAS0401010000("RAS0401010000", "a. Hasil Investasi"),
  RAS0401020000("RAS0401020000", "b. Rata-Rata Investasi"),
  RAS0401030000("RAS0401030000", "Rasio (disetahunkan) ( a : b )"),
  RAS0402010000("RAS0402010000", "a. Pendapatan Neto"),
  RAS0402020000("RAS0402020000", "b. Aset"),
  RAS0402030000("RAS0402030000", "c. Aset Neto"),
  RAS0402040000("RAS0402040000", "Rasio RoA (a : b) - disetahunkan"),
  RAS0402050000("RAS0402050000", "Rasio RoE (a : c) - disetahunkan"),
  RAS0501010000("RAS0501010000", "a. Aset Neto Periode Berjalan"),
  RAS0501020000("RAS0501020000", "b. Aset Neto Periode Sebelumnya"),
  RAS0501030000("RAS0501030000", "Rasio [( a : b ) - 1], Rasio Pertumbuhan Aset Neto"),
  RAS0601000000("RAS0601000000", "a. Beban penyusutan"),
  RAS0602000000("RAS0602000000", "b. Beban Operasional"),
  RAS0603000000("RAS0603000000", "Rasio ( a : b ), Rasio penyusutan terhadap beban operasional"),;

  @Getter
  private String key;
  private String value;

  public static final int[] INT_ROWS = { 0, 1, 3, 4, 5, 7, 8, 10, 11, 13, 14, 16, 17, 18, 21, 22, 24, 25 };
  public static final int[] PERCENT_ROWS = { 2, 6, 9, 12, 15, 19, 20, 23, 26 };

  public static String getName() {
    return ER5307RAS.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5307RAS.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5307RAS eEnum : ER5307RAS.values()) {
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
    return genEqualsRatio("2", RAS0101010000, RAS0101020000, RAS0101030000);
  }

  public static SegmentValidation genRowValidation08() {
    String rightFormula = RAS0102010000.key + "|" + RAS0102020000.key + "+" + RAS0102030000.key;
    String errMsg = "Rasio " + RAS0102010000.value + " : (" + RAS0102020000.value + " + " + RAS0102030000.value + ")";
    return UtilSegmentValidation.genEqualsRatio2("2", RAS0102040000.key, rightFormula, errMsg);
  }

  public static SegmentValidation genRowValidation11() {
    return genEqualsRatio("2", RAS0201010000, RAS0201020000, RAS0201030000);
  }

  public static SegmentValidation genRowValidation14() {
    return genEqualsRatio("2", RAS0301010000, RAS0301020000, RAS0301030000);
  }

  public static SegmentValidation genRowValidation17() {
    return genEqualsRatioByPeriod("2", RAS0401010000, RAS0401020000, RAS0401030000);
  }

  public static SegmentValidation genRowValidation21() {
    return genEqualsRatioByPeriod("2", RAS0402010000, RAS0402020000, RAS0402040000);
  }

  public static SegmentValidation genRowValidation22() {
    return genEqualsRatioByPeriod("2", RAS0402010000, RAS0402030000, RAS0402050000);
  }

  public static SegmentValidation genRowValidation25() {
    String rightFormula = RAS0501010000.key + "|" + RAS0501020000.key;
    String rightConstFormula = "-1";
    String errMsg = "Rasio ( " + RAS0501010000.value + " : " + RAS0501020000.value + " ) " + rightConstFormula;
    return UtilSegmentValidation.genEqualsRatio2("2", RAS0501030000.key, rightFormula, errMsg, null, rightConstFormula);
  }

  public static SegmentValidation genRowValidation28() {
    return genEqualsRatio("2", RAS0601000000, RAS0602000000, RAS0603000000);
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
    String errMsg = "Rasio (disetahunkan) (" + kv1.getValue() + " : " + kv2.getValue() + ")";
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
