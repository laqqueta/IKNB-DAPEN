package id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.dppkk.client.builder.constant.JenisProgram;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7017PosLtlbDppkRas1 implements IObject<KeyValueString> {

//    R_RAS10100000000("RAS10100000000", "Rasio Pendapatan investasi (ROI)", EnumSet.of(JenisProgram.ALL)),
    R_RAS10101000000("RAS10101000000", "A. Total Pendapatan Investasi – Beban Investasi", EnumSet.of(JenisProgram.ALL)),
    R_RAS10102000000("RAS10102000000", "B. Rata-rata investasi", EnumSet.of(JenisProgram.ALL)),
    R_RAS10103000000("RAS10103000000", "C. Rasio (A:B)", EnumSet.of(JenisProgram.ALL)),
//    R_RAS10200000000("RAS10200000000", "Rasio Pendapatan investasi terhadap Aset (ROA)", EnumSet.of(JenisProgram.ALL)),
    R_RAS10201000000("RAS10201000000", "A. Total Pendapatan Investasi+Pendapatan di luar investasi)-(Beban investasi+Beban Operasional+Beban di luar Investasi dan operasional)", EnumSet.of(JenisProgram.ALL)),
    R_RAS10202000000("RAS10202000000", "B. Rata-rata aset tersedia", EnumSet.of(JenisProgram.ALL)),
    R_RAS10203000000("RAS10203000000", "C. Rasio (A:B)", EnumSet.of(JenisProgram.ALL)),
//    R_RAS10300000000("RAS10300000000", "Rasio Beban Operasional (BOPO)", EnumSet.of(JenisProgram.ALL)),
    R_RAS10301000000("RAS10301000000", "A. Beban Operasional", EnumSet.of(JenisProgram.ALL)),
    R_RAS10302000000("RAS10302000000", "B. Pendapatan Investasi + Pendapatan di luar Investasi", EnumSet.of(JenisProgram.ALL)),
    R_RAS10303000000("RAS10303000000", "C. Rasio (A:B)", EnumSet.of(JenisProgram.ALL)),
//    R_RAS10400000000("RAS10400000000", "Rasio Kecukupan Dana (RKD)", EnumSet.of(JenisProgram.PPMPM)),
    R_RAS10401000000("RAS10401000000", "A. Kekayaan Untuk Pendanaan (KUP)", EnumSet.of(JenisProgram.PPMPM)),
    R_RAS10402000000("RAS10402000000", "B. Nilai Kini Aktuarial (NKA)", EnumSet.of(JenisProgram.PPMPM)),
    R_RAS10403000000("RAS10403000000", "C. Rasio (A:B)", EnumSet.of(JenisProgram.PPMPM)),
//    R_RAS10500000000("RAS10500000000", "Rasio beban operasional terhadap aset tersedia", EnumSet.of(JenisProgram.PPIPM, JenisProgram.PPIPK, JenisProgram.PPMPK, JenisProgram.PPMPPPIPK)),
    R_RAS10501000000("RAS10501000000", "A. Beban Operasional", EnumSet.of(JenisProgram.PPIPM, JenisProgram.PPIPK, JenisProgram.PPMPK, JenisProgram.PPMPPPIPK)),
    R_RAS10502000000("RAS10502000000", "B. Total Aset Tersedia", EnumSet.of(JenisProgram.PPIPM, JenisProgram.PPIPK, JenisProgram.PPMPK, JenisProgram.PPMPPPIPK)),
    R_RAS10503000000("RAS10503000000", "C. Rasio (A:B)", EnumSet.of(JenisProgram.PPIPM, JenisProgram.PPIPK, JenisProgram.PPMPK, JenisProgram.PPMPPPIPK)),
//    R_RAS10600000000("RAS10600000000", "Rasio Kekayaan Untuk Pendanaan terhadap Liabilitas Solvabilitas (Rasio Solvabilitas)", EnumSet.of(JenisProgram.PPMPM)),
    R_RAS10601000000("RAS10601000000", "A. Kekayaan Untuk Pendanaan (KUP)", EnumSet.of(JenisProgram.PPMPM)),
    R_RAS10602000000("RAS10602000000", "B. Liabilitas Solvabilitas", EnumSet.of(JenisProgram.PPMPM)),
    R_RAS10603000000("RAS10603000000", "C. Rasio (A:B)", EnumSet.of(JenisProgram.PPMPM)),
//    R_RAS10700000000("RAS10700000000", "Rasio Umur Piutang Iuran (RUPI)", EnumSet.of(JenisProgram.ALL)),
    R_RAS10701000000("RAS10701000000", "A. Piutang Iuran (LAN) x Jumlah Bulan Berjalan", EnumSet.of(JenisProgram.ALL)),
    R_RAS10702000000("RAS10702000000", "B. Iuran Jatuh Tempo (LPAN)", EnumSet.of(JenisProgram.ALL)),
    R_RAS10703000000("RAS10703000000", "C. Rasio (A:B)", EnumSet.of(JenisProgram.ALL)),
//    R_RAS10800000000("RAS10800000000", "Rasio Investasi terhadap Aset Neto (RITA)", EnumSet.of(JenisProgram.ALL)),
    R_RAS10801000000("RAS10801000000", "A. Total Investasi x 100%", EnumSet.of(JenisProgram.ALL)),
    R_RAS10802000000("RAS10802000000", "B. Total Aset Neto", EnumSet.of(JenisProgram.ALL)),
    R_RAS10803000000("RAS10803000000", "C. Rasio (A:B)", EnumSet.of(JenisProgram.ALL)),
//    R_RAS10900000000("RAS10900000000", "Piutang Investasi dan Piutang Hasil Investasi terhadap Total Investasi", EnumSet.of(JenisProgram.ALL)),
    R_RAS10901000000("RAS10901000000", "A. Piutang Investasi + Piutang Hasil Investasi", EnumSet.of(JenisProgram.ALL)),
    R_RAS10902000000("RAS10902000000", "B. Total Investasi", EnumSet.of(JenisProgram.ALL)),
    R_RAS10903000000("RAS10903000000", "C. Rasio (A:B)", EnumSet.of(JenisProgram.ALL)),
//    R_RAS11000000000("RAS11000000000", "Rasio Pertumbuhan Investasi", EnumSet.of(JenisProgram.ALL)),
    R_RAS11001000000("RAS11001000000", "A. (Total Investasi t1 - Total Investasi t0) x 100%", EnumSet.of(JenisProgram.ALL)),
    R_RAS11002000000("RAS11002000000", "B. Total Investasi t0", EnumSet.of(JenisProgram.ALL)),
    R_RAS11003000000("RAS11003000000", "C. Rasio (A:B)", EnumSet.of(JenisProgram.ALL)),
//    R_RAS11100000000("RAS11100000000", "Perubahan harga pasar atas total pendapatan", EnumSet.of(JenisProgram.ALL)),
    R_RAS11101000000("RAS11101000000", "A. (SPIn-SPIn-1) x 100%", EnumSet.of(JenisProgram.ALL)),
    R_RAS11102000000("RAS11102000000", "B. Pendapatan Investasi", EnumSet.of(JenisProgram.ALL)),
    R_RAS11103000000("RAS11103000000", "C. Rasio (A:B)", EnumSet.of(JenisProgram.ALL)),
//    R_RAS11200000000("RAS11200000000", "SPI dibandingkan dengan aset neto", EnumSet.of(JenisProgram.ALL)),
    R_RAS11201000000("RAS11201000000", "A. SPI", EnumSet.of(JenisProgram.ALL)),
    R_RAS11202000000("RAS11202000000", "B. Aset Neto", EnumSet.of(JenisProgram.ALL)),
    R_RAS11203000000("RAS11203000000", "C. Rasio (A:B)", EnumSet.of(JenisProgram.ALL)),
//    R_RAS11300000000("RAS11300000000", "Rasio Likuiditas minimum/cash ratio", EnumSet.of(JenisProgram.ALL)),
    R_RAS11301000000("RAS11301000000", "A. Aset lancar atau investasi untuk pemenuhan likuiditas minimum", EnumSet.of(JenisProgram.ALL)),
    R_RAS11302000000("RAS11302000000", "B. Biaya Operasional + Biaya Investasi + Manfaat Pensiun dan Manfaat Lain Jatuh Tempo setahun", EnumSet.of(JenisProgram.ALL)),
    R_RAS11303000000("RAS11303000000", "C. Rasio (A:B)", EnumSet.of(JenisProgram.ALL)),
//    R_RAS11400000000("RAS11400000000", "Arus Kas Masuk dibandingkan dengan Arus Kas Keluar", EnumSet.of(JenisProgram.ALL)),
    R_RAS11401000000("RAS11401000000", "A. Arus Kas Masuk dari Aktivitas Investasi, Operasional, dan Pendanaan", EnumSet.of(JenisProgram.ALL)),
    R_RAS11402000000("RAS11402000000", "B. Arus Kas Keluar dari Aktivitas Investasi, Operasional, dan Pendanaan", EnumSet.of(JenisProgram.ALL)),
    R_RAS11403000000("RAS11403000000", "C. Rasio (A:B)", EnumSet.of(JenisProgram.ALL)),
//    R_RAS11500000000("RAS11500000000", "Rasio Piutang Iuran terhadap Aset Neto", EnumSet.of(JenisProgram.ALL)),
    R_RAS11501000000("RAS11501000000", "A. Piutang Iuran", EnumSet.of(JenisProgram.ALL)),
    R_RAS11502000000("RAS11502000000", "B. Aset Neto", EnumSet.of(JenisProgram.ALL)),
    R_RAS11503000000("RAS11503000000", "C. Rasio (A:B)", EnumSet.of(JenisProgram.ALL)),
//    R_RAS11600000000("RAS11600000000", "Rasio Pertumbuhan Piutang Iuran Pendiri (Piutang Iuran Pemberi Kerja + Iuran Tambahan)", EnumSet.of(JenisProgram.ALL)),
    R_RAS11601000000("RAS11601000000", "A. (Total Piutang Iuran Pendiri t1 - total Piutang Iuran Pendiri t0) X 100%", EnumSet.of(JenisProgram.ALL)),
    R_RAS11602000000("RAS11602000000", "B. Total Piutang Iuran Pendiri t0", EnumSet.of(JenisProgram.ALL)),
    R_RAS11603000000("RAS11603000000", "C. Rasio (A:B)", EnumSet.of(JenisProgram.ALL)),
//    R_RAS11700000000("RAS11700000000", "Rasio Total Aset Jangka Panjang terhadap Total Liabilitas Jangka Panjang", EnumSet.of(JenisProgram.ALL)),
    R_RAS11701000000("RAS11701000000", "A. Total Aset jangka Panjang x 100%", EnumSet.of(JenisProgram.ALL)),
    R_RAS11702000000("RAS11702000000", "B. Total Liabilitas Jangka Panjang", EnumSet.of(JenisProgram.ALL)),
    R_RAS11703000000("RAS11703000000", "C. Rasio (A:B)", EnumSet.of(JenisProgram.ALL)),
//    R_RAS11800000000("RAS11800000000", "Rasio Pendapatan terhadap Pengeluaran", EnumSet.of(JenisProgram.ALL)),
    R_RAS11801000000("RAS11801000000", "A. Beban Operasional + Beban Investasi + Pembayaran Manfaat Pensiun", EnumSet.of(JenisProgram.ALL)),
    R_RAS11802000000("RAS11802000000", "B. Total Pendapatan", EnumSet.of(JenisProgram.ALL)),
    R_RAS11803000000("RAS11803000000", "C. Rasio (A:B)", EnumSet.of(JenisProgram.ALL)),
//    R_RAS11900000000("RAS11900000000", "Interest rate spread", EnumSet.of(JenisProgram.ALL)),
    R_RAS11901000000("RAS11901000000", "A. Rasio Pendapatan Investasi (ROI)", EnumSet.of(JenisProgram.ALL)),
    R_RAS11902000000("RAS11902000000", "B. Tingkat Bunga Aktuaria", EnumSet.of(JenisProgram.ALL)),
    R_RAS11903000000("RAS11903000000", "C. Rasio (A-B)", EnumSet.of(JenisProgram.ALL)),
//    R_RAS12000000000("RAS12000000000", "Rasio Aset Lancar terhadap Total Aset", EnumSet.of(JenisProgram.ALL)),
    R_RAS12010000000("RAS12010000000", "A. Aset Lancar", EnumSet.of(JenisProgram.ALL)),
    R_RAS12020000000("RAS12020000000", "B. Total Aset", EnumSet.of(JenisProgram.ALL)),
    R_RAS12030000000("RAS12030000000", "C. Rasio (A:B)", EnumSet.of(JenisProgram.ALL)),
//    R_RAS13000000000("RAS13000000000", "Rasio Kewajiban Lancar terhadap Total Liabilitas", EnumSet.of(JenisProgram.ALL)),
    R_RAS13010000000("RAS13010000000", "A. Kewajiban Lancar", EnumSet.of(JenisProgram.ALL)),
    R_RAS13020000000("RAS13020000000", "B. Total Liabilitas", EnumSet.of(JenisProgram.ALL)),
    R_RAS13030000000("RAS13030000000", "C. Rasio (A:B)", EnumSet.of(JenisProgram.ALL)),
//    R_RAS14000000000("RAS14000000000", "Rasio Beban Usaha", EnumSet.of(JenisProgram.ALL)),
    R_RAS14010000000("RAS14010000000", "A. Beban Operasional + Beban Investasi", EnumSet.of(JenisProgram.ALL)),
    R_RAS14020000000("RAS14020000000", "B. Pendapatan Investasi", EnumSet.of(JenisProgram.ALL)),
    R_RAS14030000000("RAS14030000000", "C. Rasio (A:B)", EnumSet.of(JenisProgram.ALL)),
    ;

    private String key;
    private String value;
    private final EnumSet<JenisProgram> jenisPrograms;

    public static final int[] INT_ROWS = { 0, 1, 3, 4, 6, 7, 9, 10, 12, 13, 15, 16, 18, 19, 21, 22, 24, 25, 27, 28, 30,
        31, 33, 34, 36, 37, 39, 40, 42, 43, 45, 46, 48, 49, 51, 52, 54, 55, 57, 58 };
    public static final int[] PERCENT_ROWS = { 2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35, 38, 41, 44, 47, 50, 53, 56,
        59 };
    public static final int[] TOTAL_ROWS = { 0, 3 };

    private static final String ROI = "ROI";
    private static final String ROIML = "ROIML";
    private static final String REKINV = "REKINV";
    private static final String LPAN = "LPAN";

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[] {});
    }

    public static List<KeyValueString> getObjects(JenisProgram jenisProgram) {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7017PosLtlbDppkRas1 eEnum : ER7017PosLtlbDppkRas1.values()) {
            if (eEnum.jenisPrograms.contains(jenisProgram) || eEnum.jenisPrograms.contains(JenisProgram.ALL) ) {
                res.add(eEnum.getObject());
            }
        }
        return res;
    }

    public static String getName() {
        return ER7017PosLtlbDppkRas1.class.getSimpleName().substring(6);
    }

    public static int getRefNumber() {
        return Integer.parseInt(ER7017PosLtlbDppkRas1.class.getSimpleName().substring(2, 6));
    }

    public static String genFieldSave() {
      return UtilMetadata.genFieldSave("2|3|4|5", getObjects(JenisProgram.PPMPK));
    }

    public static String genRequiredPos() {
      return UtilMetadata.genPipeRow(getObjects(JenisProgram.PPMPK));
    }

    public static String genUniquePos() {
      return UtilMetadata.genPipeRow(getObjects(JenisProgram.PPMPK));
    }

    public static ConditionalRequired genConditionalTotalMustEmpty() {
      String refPosCode = R_RAS11901000000.key + "|" + R_RAS11902000000.key;
      return UtilFieldConditional.genExistPosAndHasReference("N", "M", refPosCode, getRefNumber(), "O");
    }

    public static SegmentValidation genValidationTypeInteger() {
      return UtilSegmentValidation.genRegexNumericNegative("2|3|4|5", UtilMetadata.genPipeRow(getObjects(JenisProgram.PPMPK), INT_ROWS));
    }

    public static SegmentValidation genValidationTypeDecimal() {
      return UtilSegmentValidation.genRegexNumericDotNegative("2|3|4|5", UtilMetadata.genPipeRow(getObjects(JenisProgram.PPMPK), PERCENT_ROWS));
    }

    public static FieldValidation genFieldValidation06A() {
      String formula = UtilMetadata.genPlusColumn(2, 4);
      int[] rows = { 0, 3, 6, 7, 9, 10, 12, 13, 15, 16, 18, 19, 21, 22, 24, 25, 27, 28, 30, 31, 33, 34, 36, 37, 39, 40,
          45, 46, 51, 52 };
      return UtilFieldValidation.genEqualsPosFormula(formula, UtilMetadata.genPipeRow(getObjects(JenisProgram.PPMPK), rows));
    }

    public static FieldValidation genFieldValidation06B() {
      String formula = UtilMetadata.genPlusColumn(3, 4);
      int[] rows = { 42, 43, 54, 55 };
      return UtilFieldValidation.genEqualsPosFormula(formula, UtilMetadata.genPipeRow(getObjects(JenisProgram.PPMPK), rows));
    }

    public static List<SegmentValidation> genAllValidationRatioAB() {
      List<SegmentValidation> validations = new ArrayList<>();
      List<IObject<KeyValueString>> ratios = Arrays.asList(R_RAS10103000000, R_RAS10203000000, R_RAS10303000000,
          R_RAS10503000000, R_RAS10703000000, R_RAS10803000000, R_RAS10903000000, R_RAS11003000000, R_RAS11103000000,
          R_RAS11203000000, R_RAS11303000000, R_RAS11403000000, R_RAS11503000000, R_RAS11603000000, R_RAS11703000000,
          R_RAS11803000000, R_RAS11903000000, R_RAS12030000000, R_RAS13030000000, R_RAS14030000000);

      for (int i = 0; i < ratios.size(); i++) {
        int rowA = i * 3;
        int rowB = rowA + 1;
        validations.add(genValidationRatioAB(ratios.get(i), rowA, rowB));
      }
      return validations;
    }

    private static SegmentValidation genValidationRatioAB(IObject<KeyValueString> posCode, int rowA, int rowB) {
      String errMsg = "Rasio (A:B)|'" + getObjects(JenisProgram.PPMPK).get(rowA).getValue() + "' : '"
          + getObjects(JenisProgram.PPMPK).get(rowB).getValue() + "'";
      return UtilSegmentValidation.genEqualsRatio(UtilMetadata.genPipeColumn(2, 5), posCode.getObject().getKey(),
          UtilMetadata.genPipeRow(getObjects(JenisProgram.PPMPK), new int[] { rowA, rowB }), errMsg);
    }

    public static FieldValidation genFieldValidation03A() {
      String formula = UtilMetadata.genMinusColumn(new int[] {5, 3, 4});
      int[] rows = { 1, 4 };
      return UtilFieldValidation.genEqualsPosFormula(formula, UtilMetadata.genPipeRow(getObjects(JenisProgram.PPMPK), rows));
    }

    /* -- ANTAR FORM -- */
    public static SegmentValidation genRowValidation02A() {
      int[] rows = { 5, 6 };
      int row3 = 14;

      String comparatorField = UtilMetadata.genPlusRow(ER7002PosLtlbDppkLpan.getObjectsForm(), rows);
      comparatorField = comparatorField + "-" + ER7002PosLtlbDppkLpan.getObjectsForm().get(row3).getKey();
      String comparatorDesc = UtilMetadata.genPlusDesc(ER7002PosLtlbDppkLpan.getObjectsForm(), rows);
      comparatorDesc = comparatorDesc + "-'" + ER7002PosLtlbDppkLpan.getObjectsForm().get(row3).getValue()+"'";

      String errMsg =  UtilMetadata.genMessage(R_RAS10101000000.value, comparatorDesc + " pada form " + LPAN);
      return UtilSegmentValidation.genEqualsFormulaForm("2", R_RAS10101000000.key, "2", comparatorField, errMsg, 2);
    }

    public static SegmentValidation genRowValidation02B() {
      //=SUM(LPAN!G16:I17)-SUM(LPAN!G27:I27)
      return null;
    }

    public static SegmentValidation genRowValidation02C() {
      //=SUM(LPAN!G16:I17)-SUM(LPAN!G27:I27)
      return null;
    }

    public static SegmentValidation genRowValidation03A() {
      String selectPosCode = R_RAS10102000000.key;
      String comparatorPosCode = ER7010PosLtlbDppkRoiml.R_ROIML2100000000.getKey();
      return UtilSegmentValidation.genEqualsForm("4", selectPosCode, ROIML, "10", comparatorPosCode);
    }

    public static SegmentValidation genRowValidation03B() {
      String selectPosCode = R_RAS10102000000.key;
      String comparatorPosCode = ER7009PosLtlbDppkRoi.R_ROI2100000000.getKey();
      return UtilSegmentValidation.genEqualsForm("5", selectPosCode, ROI, "10", comparatorPosCode);
    }

    public static SegmentValidation genRowValidation05A() {
      // =(LPAN!F16+LPAN!F17+LPAN!F23)-(LPAN!F27+LPAN!F28+LPAN!F29)
      int[] rows1 = { 5, 6, 11 };
      int[] rows2 = { 14, 15, 16 };
      String plus = UtilMetadata.genPlusRow(ER7002PosLtlbDppkLpan.getObjectsForm(), rows1);
      String minus = UtilMetadata.genMinusRow(ER7002PosLtlbDppkLpan.getObjectsForm(), rows2);
      String plusDesc1 = UtilMetadata.genPlusDesc(ER7002PosLtlbDppkLpan.getObjectsForm(), rows1);
      String plusDesc2 = UtilMetadata.genPlusDesc(ER7002PosLtlbDppkLpan.getObjectsForm(), rows2);

      String comparatorField = plus + "-" + minus;
      String comparatorDesc = "(" + plusDesc1 + ") - (" + plusDesc2 + ")";
      String errMsg =  UtilMetadata.genMessage(R_RAS10201000000.value, comparatorDesc + " pada form " + LPAN);
      return UtilSegmentValidation.genEqualsFormulaForm("2", R_RAS10201000000.key, "2", comparatorField, errMsg, 2);
    }

    public static SegmentValidation genRowValidation05B() {
      //=SUM(LPAN!G16:I17)+SUM(LPAN!G23:I23)-SUM(LPAN!G27:I29)
      return null;
    }

    public static SegmentValidation genRowValidation05C() {
      //=SUM(LPAN!J16:O17)+SUM(LPAN!J23:O23)-SUM(LPAN!J27:O29)
      return null;
    }

    public static SegmentValidation genRowValidation06A() {
      KeyValueString comparator = ER7008PosLtlbDppkRekinv.R_REKINV2400000000.getObject();
      String comparatorField = UtilMetadata.genPipeColumn(2, 13);
      String comparatorExpr = "/12";
      String errMsg = "'" + R_RAS10202000000.value + "' harus sama dengan rata-rata '" + comparator.getValue() + "' pada form " + REKINV;
      return UtilSegmentValidation.genEqualsFormExpression("3", R_RAS10202000000.key, null, REKINV, comparatorField,
          comparator.getKey(), comparatorExpr, "e", 2, errMsg);
    }

    public static SegmentValidation genRowValidation06B() {
      KeyValueString comparator = ER7008PosLtlbDppkRekinv.R_REKINV2300000000.getObject();
      String comparatorField = UtilMetadata.genPipeColumn(2, 13);
      String comparatorExpr = "/12";
      String errMsg = "'" + R_RAS10202000000.value + "' harus sama dengan rata-rata '" + comparator.getValue() + "' pada form " + REKINV;
      return UtilSegmentValidation.genEqualsFormExpression("4", R_RAS10202000000.key, null, REKINV, comparatorField,
          comparator.getKey(), comparatorExpr, "e", 2, errMsg);
    }

    public static SegmentValidation genRowValidation06C() {
      KeyValueString comparator = ER7008PosLtlbDppkRekinv.R_REKINV2200000000.getObject();
      String comparatorField = UtilMetadata.genPipeColumn(2, 13);
      String comparatorExpr = "/12";
      String errMsg = "'" + R_RAS10202000000.value + "' harus sama dengan rata-rata '" + comparator.getValue() + "' pada form " + REKINV;
      return UtilSegmentValidation.genEqualsFormExpression("5", R_RAS10202000000.key, null, REKINV, comparatorField,
          comparator.getKey(), comparatorExpr, "e", 2, errMsg);
    }
}
