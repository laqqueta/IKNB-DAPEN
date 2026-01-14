package id.go.ojk.bpks.client.builder.field.lbbpkslk.reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import id.go.ojk.bpks.client.builder.field.EFormLbbpkslk;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER5006ALM implements IObject<KeyValueString> {
  ALM0100000000("ALM0100000000", "A. ASET LANCAR"),
  ALM0101000000("ALM0101000000", "Kas dan setara kas"),
  ALM0102000000("ALM0102000000", "Deposito berjangka"),
  ALM0103000000("ALM0103000000", "Piutang biaya operasional"),
  ALM0104000000("ALM0104000000", "Piutang talangan"),
  ALM0105000000("ALM0105000000", "Piutang investasi"),
  ALM0106000000("ALM0106000000", "Piutang hasil investasi"),
  ALM0107000000("ALM0107000000", "Piutang lain"),
  ALM0108000000("ALM0108000000", "Uang muka"),
  ALM0109000000("ALM0109000000", "Pajak dibayar di muka"),
  ALM0110000000("ALM0110000000", "Biaya dibayar di muka"),
  ALM0111000000("ALM0111000000", "Investasi jangka pendek"),
  ALM0112000000("ALM0112000000", "Perlengkapan kantor"),
  ALM0113000000("ALM0113000000", "Aset dimiliki untuk dijual"),
  ALM0114000000("ALM0114000000", "Aset lancar lain"),
  ALM0200000000("ALM0200000000", "B. Aset Tidak Lancar"),
  ALM0201000000("ALM0201000000", "Investasi jangka panjang"),
  ALM0202000000("ALM0202000000", "Investasi pada entitas asosiasi dan entitas anak"),
  ALM0203000000("ALM0203000000", "Properti investasi"),
  ALM0204000000("ALM0204000000", "Aset tetap"),
  ALM0205000000("ALM0205000000", "Aset Hak Guna"),
  ALM0206000000("ALM0206000000", "Aset tidak berwujud"),
  ALM0207000000("ALM0207000000", "Aset pajak tangguhan"),
  ALM0208000000("ALM0208000000", "Aset tidak lancar lain"),
  ALM0300000000("ALM0300000000", "C. Total Aset"),
  ALM0400000000("ALM0400000000", "D. Liabilitas Jangka Pendek"),
  ALM0401000000("ALM0401000000", "Utang kepada pihak ketiga"),
  ALM0402000000("ALM0402000000", "Utang pajak"),
  ALM0403000000("ALM0403000000", "Utang kontribusi kepada program"),
  ALM0404000000("ALM0404000000", "Utang insentif"),
  ALM0405000000("ALM0405000000", "Biaya yang masih harus dibayar"),
  ALM0406000000("ALM0406000000", "Pendapatan diterima dimuka"),
  ALM0407000000("ALM0407000000", "Liabilitas jangka pendek lain"),
  ALM0500000000("ALM0500000000", "E. Liabilitas Jangka Panjang"),
  ALM0501000000("ALM0501000000", "Pendapatan diterima dimuka"),
  ALM0502000000("ALM0502000000", "Liabilitas imbalan pascakerja"),
  ALM0503000000("ALM0503000000", "Liabilitas pajak tangguhan"),
  ALM0504000000("ALM0504000000", "Liabilitas jangka panjang lain"),
  ALM0600000000("ALM0600000000", "F. Total Liabilitas"),
  ALM0700000000("ALM0700000000", "G. SELISIH TOTAL ASET DAN TOTAL LIABILITAS (C-F)"),;

  @Getter
  private String key;
  private String value;

  public static final String LPK = EFormLbbpkslk.LPK.getCode();
  public static final int[] ROWS_A = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
  public static final int[] ROWS_B = { 16, 17, 18, 19, 20, 21, 22, 23 };
  public static final int[] ROWS_C = { 0, 15 };
  public static final int[] ROWS_D = { 26, 27, 28, 29, 30, 31, 32 };
  public static final int[] ROWS_E = { 34, 35, 36, 37 };
  public static final int[] ROWS_F = { 25, 33 };
  public static final int[] ROWS_G = { 24, 38 };

  public static String getName() {
    return ER5006ALM.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5006ALM.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5006ALM eEnum : ER5006ALM.values()) {
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
    return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 19), getObjects());
  }

  public static FieldValidation genFieldValidation05() {
    return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(new int[] { 2, 3 }),
        UtilMetadata.genPipeRow(getObjects()));
  }

  public static FieldValidation genFieldValidation08() {
    return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(new int[] { 5, 6 }),
        UtilMetadata.genPipeRow(getObjects()));
  }

  public static FieldValidation genFieldValidation11() {
    return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(new int[] { 8, 9 }),
        UtilMetadata.genPipeRow(getObjects()));
  }

  public static FieldValidation genFieldValidation14() {
    return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(new int[] { 11, 12 }),
        UtilMetadata.genPipeRow(getObjects()));
  }

  public static FieldValidation genFieldValidation17() {
    return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(new int[] { 14, 15 }),
        UtilMetadata.genPipeRow(getObjects()));
  }

  public static FieldValidation genFieldValidation18() {
    return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(new int[] { 2, 5, 8, 11, 14 }),
        UtilMetadata.genPipeRow(getObjects()));
  }

  public static FieldValidation genFieldValidation19() {
    return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(new int[] { 3, 6, 9, 12, 15 }),
        UtilMetadata.genPipeRow(getObjects()));
  }

  public static FieldValidation genFieldValidation20() {
    return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(new int[] { 17, 18 }),
        UtilMetadata.genPipeRow(getObjects()));
  }
  
  public static List<SegmentValidation> genColValidationsA() {
    String selectField = UtilMetadata.genDelimitedColumn(new int[] { 2, 3, 5, 6, 8, 9, 11, 12, 14, 15 }, "|");
    return Arrays.asList(
        genColPlusValidation(selectField, ALM0100000000, ROWS_A),
        genColPlusValidation(selectField, ALM0200000000, ROWS_B),
        genColPlusValidation(selectField, ALM0300000000, ROWS_C),
        genColPlusValidation(selectField, ALM0400000000, ROWS_D),
        genColPlusValidation(selectField, ALM0500000000, ROWS_E),
        genColPlusValidation(selectField, ALM0600000000, ROWS_F),
        genColMinusValidation(selectField, ALM0700000000, ROWS_G));
  }

  private static SegmentValidation genColPlusValidation(String selectField, IObject<KeyValueString> o, int[] rows) {
    return UtilSegmentValidation.genEqualsFormula(selectField, o.getObject().getKey(),
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(o.getObject().getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  private static SegmentValidation genColMinusValidation(String selectField, IObject<KeyValueString> o, int[] rows) {
    return UtilSegmentValidation.genEqualsFormula(selectField, o.getObject().getKey(),
        UtilMetadata.genMinusRow(getObjects(), rows),
        UtilMetadata.genMessage(o.getObject().getValue(), UtilMetadata.genMinusDesc(getObjects(), rows)));
  }

  /* -- ANTAR FORM -- */
  public static SegmentValidation genRowValidation26() {
    String selecPosCode = ALM0300000000.key;
    String comparatorPosCode = ER5000LPK.LPK0200000000.getKey();
    return UtilSegmentValidation.genEqualsForm("19", selecPosCode, LPK, "2", comparatorPosCode);
  }

  public static SegmentValidation genRowValidation40() {
    String selecPosCode = ALM0600000000.key;
    String comparatorPosCode = ER5000LPK.LPK0400000000.getKey();
    return UtilSegmentValidation.genEqualsForm("19", selecPosCode, LPK, "2", comparatorPosCode);
  }

  public static SegmentValidation genRowValidation41() {
    String selecPosCode = ALM0700000000.key;
    String comparatorPosCode = ER5000LPK.LPK0600000000.getKey();
    return UtilSegmentValidation.genEqualsForm("19", selecPosCode, LPK, "2", comparatorPosCode);
  }
}
