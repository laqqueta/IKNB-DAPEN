package id.go.ojk.bptk.client.builder.field.lbbptkjht.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.EFormLbbptkjht;
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
public enum ER5606RASL implements IObject<KeyValueString> {
  RASL0101000000("RASL0101000000", "Kas dan Bank"),
  RASL0102000000("RASL0102000000", "Piutang Iuran"),
  RASL0103000000("RASL0103000000", "Piutang investasi"),
  RASL0104000000("RASL0104000000", "Piutang Hasil Investasi"),
  RASL0105000000("RASL0105000000", "Piutang Kontribusi BPJS"),
  RASL0106000000("RASL0106000000", "Beban dibayar dimuka"),
  RASL0107000000("RASL0107000000", "Piutang lain"),
  RASL0108000000("RASL0108000000", "Deposito"),
  RASL0109000000("RASL0109000000", "Instrumen Pasar Uang Lainnya"),
  RASL0110000000("RASL0110000000", "Surat berharga yang diterbitkan oleh Bank Indonesia"),
  RASL0111000000("RASL0111000000", "Surat berharga yang diterbitkan oleh Negara RI"),
  RASL0112000000("RASL0112000000", "Kerjasama Operasi (KSO)"),
  RASL0113000000("RASL0113000000", "Investasi Melalui Fund Manager"),
  RASL0114000000("RASL0114000000", "Saham"),
  RASL0115000000("RASL0115000000", "Reksadana"),
  RASL0116000000("RASL0116000000", "Kontrak Investasi Kolektif - Efek Beragun Aset (KIK EBA)"),
  RASL0117000000("RASL0117000000", "Sukuk"),
  RASL0118000000("RASL0118000000", "Obligasi"),
  RASL0119000000("RASL0119000000", "Penyertaan Langsung"),
  RASL0120000000("RASL0120000000", "Properti Investasi"),
  RASL0121000000("RASL0121000000", "Aset Lain"),
  RASL0200000000("RASL0200000000", "TOTAL ASET"),
  RASL0301000000("RASL0301000000", "Utang Jaminan Siap Bayar"),
  RASL0302000000("RASL0302000000", "Utang Jaminan Yang Diserahkan Kpd Balai Harta Peninggalan"),
  RASL0303000000("RASL0303000000", "Utang Biaya Operasional Kepada BPJS"),
  RASL0303010000("RASL0303010000", "Utang Talangan Kepada BPJS"),
  RASL0304000000("RASL0304000000", "Utang Kepada Pihak Lain"),
  RASL0305000000("RASL0305000000", "Utang Pajak"),
  RASL0306000000("RASL0306000000", "Pendapatan Diterima Dimuka"),
  RASL0307000000("RASL0307000000", "Biaya Yang Masih Harus Dibayar"),
  RASL0308000000("RASL0308000000", "Liabilitas Lain"),
  RASL0400000000("RASL0400000000", "TOTAL LIABILITAS"),
  RASL0500000000("RASL0500000000", "SELISIH TOTAL ASET DAN TOTAL LIABILITAS"),;

  @Getter
  private String key;
  private String value;

  public static final int[] COLS_NON_TOTAL = { 2, 3, 5, 6, 8, 9, 11, 12, 14, 15, 17, 18 };

  public static String getName() {
    return ER5606RASL.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5606RASL.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5606RASL eEnum : ER5606RASL.values()) {
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

  public static SegmentValidation genRowValidation23a() {
    int[] rows = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
    return genPlusValidation(UtilMetadata.genPipeColumn(COLS_NON_TOTAL), RASL0200000000, rows);
  };

  public static SegmentValidation genRowValidation26() {
    int[] rows = { 25 };
    return genPlusValidation(UtilMetadata.genPipeColumn(COLS_NON_TOTAL), RASL0303000000, rows);
  };

  public static SegmentValidation genRowValidation33() {
    int[] rows = { 22, 23, 24, 26, 27, 28, 29, 30 };
    return genPlusValidation(UtilMetadata.genPipeColumn(COLS_NON_TOTAL), RASL0400000000, rows);
  };

  public static SegmentValidation genRowValidation34() {
    int[] rows = { 21, 31 };
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
  public static SegmentValidation genRowValidation23b() {
    String selecPosCode = RASL0200000000.key;
    String comparatorPosCode = ER5601LAN.LAN0200000000.getKey();
    return UtilSegmentValidation.genEqualsForm("19", selecPosCode, EFormLbbptkjht.LAN.getCode(), "2",
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
