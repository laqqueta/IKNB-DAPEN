package id.go.ojk.bptk.client.builder.field.lbbptkjkm.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.EFormLbbptkjkm;
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
public enum ER5508RASL implements IObject<KeyValueString> {
  RASL0101000000("RASL0101000000", "Kas dan Bank"),
  RASL0102000000("RASL0102000000", "Piutang Iuran"),
  RASL0103000000("RASL0103000000", "Piutang Investasi"),
  RASL0104000000("RASL0104000000", "Piutang Hasil Investasi"),
  RASL0105000000("RASL0105000000", "Piutang Kontribusi BPJS"),
  RASL0106000000("RASL0106000000", "Piutang Lain"),
  RASL0107000000("RASL0107000000", "Deposito"),
  RASL0108000000("RASL0108000000", "Surat berharga yang diterbitkan oleh Bank Indonesia"),
  RASL0109000000("RASL0109000000", "Surat berharga yang diterbitkan oleh Negara RI"),
  RASL0110000000("RASL0110000000", "Tagihan reverse repo"),
  RASL0111000000("RASL0111000000", "Saham"),
  RASL0112000000("RASL0112000000", "Reksadana"),
  RASL0113000000("RASL0113000000", "Kontrak Investasi Kolektif Efek Beragun Aset (KIK EBA)"),
  RASL0114000000("RASL0114000000", "Sukuk"),
  RASL0115000000("RASL0115000000", "Obligasi"),
  RASL0116000000("RASL0116000000", "Aset Lain"),
  RASL0200000000("RASL0200000000", "TOTAL ASET"),
  RASL0301000000("RASL0301000000", "Utang Jaminan Kematian"),
  RASL0302000000("RASL0302000000", "Utang Kepada BPJS"),
  RASL0302010000("RASL0302010000", "Dana Operasional"),
  RASL0302020000("RASL0302020000", "Dana Talangan"),
  RASL0303000000("RASL0303000000", "Utang Kepada Pihak Lain"),
  RASL0304000000("RASL0304000000", "Cadangan Teknis"),
  RASL0304010000("RASL0304010000", "Liabilitas Jaminan Kematian Kerja Dalam Proses"),
  RASL0304020000("RASL0304020000", "Liabilitas Jaminan Kematian Kerja Belum Dilaporkan"),
  RASL0304030000("RASL0304030000", "Iuran Yang Belum Merupakan Pendapatan"),
  RASL0304040000("RASL0304040000", "Liabilitas Jaminan Kematian Kerja Masa Depan"),
  RASL0305000000("RASL0305000000", "Liabilitas Lain"),
  RASL0400000000("RASL0400000000", "TOTAL LIABILITAS"),
  RASL0500000000("RASL0500000000", "SELISIH TOTAL ASET DAN TOTAL LIABILITAS"),;

  @Getter
  private String key;
  private String value;

  public static final int[] COLS_NON_TOTAL = { 2, 3, 5, 6, 8, 9, 11, 12, 14, 15, 17, 18 };

  public static String getName() {
    return ER5508RASL.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5508RASL.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5508RASL eEnum : ER5508RASL.values()) {
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

  public static SegmentValidation genRowValidation18a() {
    int[] rows = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
    return genPlusValidation(UtilMetadata.genPipeColumn(COLS_NON_TOTAL), RASL0200000000, rows);
  };

  public static SegmentValidation genRowValidation20() {
    int[] rows = { 19, 20 };
    return genPlusValidation(UtilMetadata.genPipeColumn(COLS_NON_TOTAL), RASL0302000000, rows);
  };

  public static SegmentValidation genRowValidation24() {
    int[] rows = { 23, 24, 25, 26 };
    return genPlusValidation(UtilMetadata.genPipeColumn(COLS_NON_TOTAL), RASL0304000000, rows);
  };

  public static SegmentValidation genRowValidation30() {
    int[] rows = { 17, 18, 21, 22, 27 };
    return genPlusValidation(UtilMetadata.genPipeColumn(COLS_NON_TOTAL), RASL0400000000, rows);
  };

  public static SegmentValidation genRowValidation31() {
    int[] rows = { 16, 28 };
    return genMinusValidation(UtilMetadata.genPipeColumn(COLS_NON_TOTAL), RASL0500000000, rows);
  };

  public static FieldValidation genFieldValidation05() {
    int[] cols = { 2, 3 };
    return UtilFieldValidation.genEqualsFormula(UtilMetadata.genPlusColumn(cols));
  }

  public static FieldValidation genFieldValidation08() {
    int[] cols = { 5, 6 };
    return UtilFieldValidation.genEqualsFormula(UtilMetadata.genPlusColumn(cols));
  }

  public static FieldValidation genFieldValidation11() {
    int[] cols = { 8, 9 };
    return UtilFieldValidation.genEqualsFormula(UtilMetadata.genPlusColumn(cols));
  }

  public static FieldValidation genFieldValidation14() {
    int[] cols = { 11, 12 };
    return UtilFieldValidation.genEqualsFormula(UtilMetadata.genPlusColumn(cols));
  }

  public static FieldValidation genFieldValidation17() {
    int[] cols = { 14, 15 };
    return UtilFieldValidation.genEqualsFormula(UtilMetadata.genPlusColumn(cols));
  }

  public static FieldValidation genFieldValidation20() {
    int[] cols = { 17, 18 };
    return UtilFieldValidation.genEqualsFormula(UtilMetadata.genPlusColumn(cols));
  }

  /* -- ANTAR FORM -- */
  public static SegmentValidation genRowValidation18b() {
    String selecPosCode = RASL0200000000.key;
    String comparatorPosCode = ER5501LPK.LPK0200000000.getKey();
    return UtilSegmentValidation.genEqualsForm("19", selecPosCode, EFormLbbptkjkm.LPK.getCode(), "2",
        comparatorPosCode);
  }

  public static SegmentValidation genRowValidation41() {
    String selecPosCode = RASL0400000000.key;
    String comparatorPosCode = ER5501LPK.LPK0400000000.getKey();
    return UtilSegmentValidation.genEqualsForm("19", selecPosCode, EFormLbbptkjkm.LPK.getCode(), "2",
        comparatorPosCode);
  }

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
