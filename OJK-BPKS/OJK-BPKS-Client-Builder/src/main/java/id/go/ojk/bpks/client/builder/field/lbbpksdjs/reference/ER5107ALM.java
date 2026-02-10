package id.go.ojk.bpks.client.builder.field.lbbpksdjs.reference;

import java.util.ArrayList;
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
public enum ER5107ALM implements IObject<KeyValueString> {
  ALM0101000000("ALM0101000000", "Kas dan Bank"),
  ALM0102000000("ALM0102000000", "Deposito"),
  ALM0103000000("ALM0103000000", "Piutang iuran"),
  ALM0104000000("ALM0104000000", "Piutang COB"),
  ALM0105000000("ALM0105000000", "Piutang investasi"),
  ALM0106000000("ALM0106000000", "Piutang hasil investasi"),
  ALM0107000000("ALM0107000000", "Piutang kontribusi BPJS"),
  ALM0108000000("ALM0108000000", "Piutang kepada BPJS"),
  ALM0109000000("ALM0109000000", "Piutang lain"),
  ALM0110000000("ALM0110000000", "Uang muka"),
  ALM0111000000("ALM0111000000", "Surat berharga yang diterbitkan oleh Bank Indonesia"),
  ALM0112000000("ALM0112000000", "Surat berharga yang diterbitkan oleh Negara RI"),
  ALM0113000000("ALM0113000000", "Sukuk"),
  ALM0114000000("ALM0114000000", "Obligasi"),
  ALM0115000000("ALM0115000000", "Aset lain"),
  ALM0200000000("ALM0200000000", "B. TOTAL ASET"),
  ALM0301000000("ALM0301000000", "Utang jaminan kesehatan"),
  ALM0302000000("ALM0302000000", "Pendapatan Diterima Dimuka"),
  ALM0303000000("ALM0303000000", "Akumulasi iuran yang belum dapat teridentifikasi pesertanya"),
  ALM0304000000("ALM0304000000", "Utang kepada BPJS"),
  ALM0304010000("ALM0304010000", "Dana operasional"),
  ALM0304020000("ALM0304020000", "Dana Talangan"),
  ALM0305000000("ALM0305000000", "Utang kepada pihak ketiga"),
  ALM0306000000("ALM0306000000", "Utang COB"),
  ALM0307000000("ALM0307000000", "Utang pajak"),
  ALM0308000000("ALM0308000000", "Cadangan teknis"),
  ALM0308010000("ALM0308010000", "Liabilitas pelayanan kesehatan dalam proses"),
  ALM0308020000("ALM0308020000", "Liabilitas pelayanan kesehatan belum dilaporkan"),
  ALM0308030000("ALM0308030000", "Iuran belum merupakan pendapatan"),
  ALM0309000000("ALM0309000000", "Liabilitas lain"),
  ALM0400000000("ALM0400000000", "D. TOTAL LIABILITAS"),
  ALM0500000000("ALM0500000000", "E. Selisih Total Aset dan Total Liabilitas (B-D)"),;

  @Getter
  private String key;
  @Getter
  private String value;

  public static final String LPK = EFormLbbpkslk.LPK.getCode();
  public static final int[] ALL_COLS = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 };
  public static final int[] NON_TOTAL_COLS = { 2, 3, 5, 6, 8, 9, 11, 12, 14, 15, 17, 18 };
  public static final int[] ROWS_A = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 18, 19, 20, 21, 22, 23,
      24, 25, 26, 27, 28, 29 };

  public static String getName() {
    return ER5107ALM.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5107ALM.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5107ALM eEnum : ER5107ALM.values()) {
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

  public static String genFieldSaveForm() {
    return UtilMetadata.genFieldSave("4", getObjects());
  }

  public static FieldValidation genFieldValidation05() {
    int[] cols = { 2, 3 };
    return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(cols),
        UtilMetadata.genPipeRow(getObjects(), ROWS_A));
  }

  public static FieldValidation genFieldValidation08() {
    int[] cols = { 5, 6 };
    return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(cols),
        UtilMetadata.genPipeRow(getObjects(), ROWS_A));
  }

  public static FieldValidation genFieldValidation11() {
    int[] cols = { 8, 9 };
    return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(cols),
        UtilMetadata.genPipeRow(getObjects(), ROWS_A));
  }

  public static FieldValidation genFieldValidation14() {
    int[] cols = { 11, 12 };
    return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(cols),
        UtilMetadata.genPipeRow(getObjects(), ROWS_A));
  }

  public static FieldValidation genFieldValidation17() {
    int[] cols = { 14, 15 };
    return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(cols),
        UtilMetadata.genPipeRow(getObjects(), ROWS_A));
  }

  public static FieldValidation genFieldValidation18() {
    int[] cols = { 2, 5, 8, 11, 14 };
    return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(cols),
        UtilMetadata.genPipeRow(getObjects(), ROWS_A));
  }

  public static FieldValidation genFieldValidation19() {
    int[] cols = { 3, 6, 9, 12, 15 };
    return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(cols),
        UtilMetadata.genPipeRow(getObjects(), ROWS_A));
  }

  public static FieldValidation genFieldValidation20() {
    int[] cols = { 4, 7, 10, 13, 16 };
    return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(cols),
        UtilMetadata.genPipeRow(getObjects(), ROWS_A));
  }

  public static SegmentValidation genRowValidation17() {
    int[] rows = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
    KeyValueString posCode = ALM0200000000.getObject();
    String selectFields = UtilMetadata.genDelimitedColumn(ALL_COLS, "|");
    String plusRows = UtilMetadata.genPlusRow(getObjects(), rows);
    String plusRowsDesc = UtilMetadata.genPlusDesc(getObjects(), rows);
    return UtilSegmentValidation.genEqualsFormula(selectFields, posCode.getKey(), plusRows,
        UtilMetadata.genMessage(posCode.getValue(), plusRowsDesc));
  }

  public static SegmentValidation genRowValidation21() {
    int[] rows = { 20, 21 };
    KeyValueString posCode = ALM0304000000.getObject();
    String plusRows = UtilMetadata.genPlusRow(getObjects(), rows);
    String plusRowsDesc = UtilMetadata.genPlusDesc(getObjects(), rows);
    return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genDelimitedColumn(NON_TOTAL_COLS, "|"),
        posCode.getKey(), plusRows, UtilMetadata.genMessage(posCode.getValue(), plusRowsDesc));
  }

  public static SegmentValidation genRowValidation27() {
    int[] rows = { 26, 27, 28 };
    KeyValueString posCode = ALM0308000000.getObject();
    String plusRows = UtilMetadata.genPlusRow(getObjects(), rows);
    String plusRowsDesc = UtilMetadata.genPlusDesc(getObjects(), rows);
    return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genDelimitedColumn(NON_TOTAL_COLS, "|"),
        posCode.getKey(), plusRows, UtilMetadata.genMessage(posCode.getValue(), plusRowsDesc));
  }

  public static SegmentValidation genRowValidation32a() {
    int[] rows = { 16, 17, 18, 19, 22, 23, 24, 25, 29 };
    KeyValueString posCode = ALM0400000000.getObject();
    String selectFields = UtilMetadata.genDelimitedColumn(ALL_COLS, "|");
    String plusRows = UtilMetadata.genPlusRow(getObjects(), rows);
    String plusRowsDesc = UtilMetadata.genPlusDesc(getObjects(), rows);
    return UtilSegmentValidation.genEqualsFormula(selectFields, posCode.getKey(), plusRows,
        UtilMetadata.genMessage(posCode.getValue(), plusRowsDesc));
  }

  public static SegmentValidation genRowValidation33a() {
    int[] rows = { 15, 30 };
    KeyValueString posCode = ALM0500000000.getObject();
    String selectFields = UtilMetadata.genDelimitedColumn(ALL_COLS, "|");
    String minusRows = UtilMetadata.genMinusRow(getObjects(), rows);
    String minusRowsDesc = UtilMetadata.genMinusDesc(getObjects(), rows);
    return UtilSegmentValidation.genEqualsFormula(selectFields, posCode.getKey(), minusRows,
        UtilMetadata.genMessage(posCode.getValue(), minusRowsDesc));
  }

  /* -- ANTAR FORM -- */
  public static SegmentValidation genRowValidation29() {
    String selecPosCode = ALM0200000000.key;
    String comparatorPosCode = ER5100LPK.LPK0200000000.getKey();
    return UtilSegmentValidation.genEqualsForm("19", selecPosCode, LPK, "2", comparatorPosCode);
  }

  public static SegmentValidation genRowValidation32b() {
    String selecPosCode = ALM0400000000.key;
    String comparatorPosCode = ER5100LPK.LPK0400000000.getKey();
    return UtilSegmentValidation.genEqualsForm("19", selecPosCode, LPK, "2", comparatorPosCode);
  }

  public static SegmentValidation genRowValidation33b() {
    String selecPosCode = ALM0500000000.key;
    String comparatorPosCode = ER5100LPK.LPK0500000000.getKey();
    return UtilSegmentValidation.genEqualsForm("19", selecPosCode, LPK, "2", comparatorPosCode);
  }

  public static SegmentValidation genRowValidation32c() {
    String selecPosCode = ALM0400000000.key;
    String comparatorPosCode = ER5100LPK.LPK0400000000.getKey();
    String errMsg = ALM0400000000.value + "|" + ER5100LPK.LPK0400000000.getValue() + " pada form " + LPK;
    return UtilSegmentValidation.genEqualsForm("19", selecPosCode, LPK, "2", comparatorPosCode, errMsg);
  }

  public static SegmentValidation genRowValidation33c() {
    KeyValueString selectPos = ALM0500000000.getObject();
    KeyValueString comparatorPos = ER5100LPK.LPK0500000000.getObject();
    String errMsg = selectPos.getValue() + "|" + comparatorPos.getValue() + " pada form " + LPK;
    return UtilSegmentValidation.genEqualsForm("19", selectPos.getKey(), LPK, "2", comparatorPos.getKey(), errMsg);
  }
}
