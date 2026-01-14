package id.go.ojk.bptk.client.builder.field.lbbptkbdn.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.EFormLbbptkbdn;
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
public enum ER5308RASL implements IObject<KeyValueString> {
  RASL0100000000("RASL0100000000", "Aset Lancar"),
  RASL0101000000("RASL0101000000", "Kas dan setara Kas"),
  RASL0102000000("RASL0102000000", "Piutang Dana Operasional"),
  RASL0102010000("RASL0102010000", "Piutang Dana Operasional, Program Jaminan Hari Tua"),
  RASL0102020000("RASL0102020000", "Piutang Dana Operasional, Program Jaminan Kecelakaan Kerja"),
  RASL0102030000("RASL0102030000", "Piutang Dana Operasional, Program Jaminan Kematian"),
  RASL0102040000("RASL0102040000", "Piutang Dana Operasional, Program Jaminan Pensiun"),
  RASL0103000000("RASL0103000000", "Piutang Hasil Investasi"),
  RASL0104000000("RASL0104000000", "Piutang Usaha"),
  RASL0105000000("RASL0105000000", "Piutang SKP"),
  RASL0106000000("RASL0106000000", "Piutang Lain"),
  RASL0107000000("RASL0107000000", "Piutang Talangan"),
  RASL0108000000("RASL0108000000", "Piutang Investasi"),
  RASL0109000000("RASL0109000000", "Investasi Jangka Pendek"),
  RASL0109010000("RASL0109010000", "Investasi Jangka Pendek, Deposito"),
  RASL0109020000("RASL0109020000", "Investasi Jangka Pendek, Deposito SKP"),
  RASL0109030000("RASL0109030000", "Investasi Jangka Pendek, Deposito TJSL"),
  RASL0109040000("RASL0109040000", "Investasi Jangka Pendek, Saham"),
  RASL0109050000("RASL0109050000", "Investasi Jangka Pendek, Reksadana"),
  RASL0109060000("RASL0109060000", "Investasi Jangka Pendek, Surat Utang < 1 Tahun"),
  RASL0109070000("RASL0109070000", "Investasi Jangka Pendek, SBN"),
  RASL0110000000("RASL0110000000", "Pajak Dibayar Dimuka"),
  RASL0111000000("RASL0111000000", "Uang Muka"),
  RASL0112000000("RASL0112000000", "Beban Dibayar Dimuka"),
  RASL0113000000("RASL0113000000", "Perlengkapan Kantor"),
  RASL0114000000("RASL0114000000", "Aset dimiliki Untuk Dijual"),
  RASL0115000000("RASL0115000000", "Aset Lancar Lain"),
  RASL0200000000("RASL0200000000", "Aset Tidak Lancar"),
  RASL0201000000("RASL0201000000", "Investasi Jangka Panjang"),
  RASL0201010000("RASL0201010000", "Investasi Jangka Panjang, KIK EBA"),
  RASL0201020000("RASL0201020000", "Investasi Jangka Panjang, Sukuk Korporasi"),
  RASL0201030000("RASL0201030000", "Investasi Jangka Panjang, Obligasi Korporasi"),
  RASL0201040000("RASL0201040000", "Investasi Jangka Panjang, SBN"),
  RASL0202000000("RASL0202000000", "Investasi Pada Entitas Asosiasi dan entitas anak"),
  RASL0203000000("RASL0203000000", "Properti Investasi"),
  RASL0204000000("RASL0204000000", "Aset Tetap"),
  RASL0205000000("RASL0205000000", "Aset Hak Guna"),
  RASL0206000000("RASL0206000000", "Aset Tidak Berwujud"),
  RASL0207000000("RASL0207000000", "Klaim Pengembalian Pajak"),
  RASL0208000000("RASL0208000000", "Aset Pajak Tangguhan"),
  RASL0209000000("RASL0209000000", "Aset Tidak Lancar Lain"),
  RASL0300000000("RASL0300000000", "TOTAL ASET"),
  RASL0301000000("RASL0301000000", "Liabilitas Jangka Pendek"),
  RASL0302000000("RASL0302000000", "Utang Kepada Pihak Lain"),
  RASL0303000000("RASL0303000000", "Utang Pajak"),
  RASL0304000000("RASL0304000000", "Utang Kontribusi Kepada Program"),
  RASL0304010000("RASL0304010000", "Utang Kontribusi Kepada Program, Program Jaminan Hari Tua"),
  RASL0304020000("RASL0304020000", "Utang Kontribusi Kepada Program, Program Jaminan Kecelakaan Kerja"),
  RASL0304030000("RASL0304030000", "Utang Kontribusi Kepada Program, Program Jaminan Kematian"),
  RASL0304040000("RASL0304040000", "Utang Kontribusi Kepada Program, Program Jaminan Pensiun"),
  RASL0305000000("RASL0305000000", "Beban Akrual"),
  RASL0306000000("RASL0306000000", "Pendapatan Diterima Dimuka"),
  RASL0307000000("RASL0307000000", "Utang Bank"),
  RASL0308000000("RASL0308000000", "Liabilitas sewa jangka pendek"),
  RASL0309000000("RASL0309000000", "Liabilitas jangka pendek lain"),
  RASL0310000000("RASL0310000000", "Liabilitas Jangka Panjang"),
  RASL0311000000("RASL0311000000", "Liabilitas Sewa jangka panjang"),
  RASL0312000000("RASL0312000000", "Liabilitas Imbalan Pasca Kerja"),
  RASL0400000000("RASL0400000000", "TOTAL LIABILITAS"),
  RASL0500000000("RASL0500000000", "SELISIH TOTAL ASET DAN TOTAL LIABILITAS"),;

  @Getter
  private String key;
  private String value;

  public static final int[] COLS_NON_TOTAL = { 2, 3, 5, 6, 8, 9, 11, 12, 14, 15, 17, 18 };

  public static String getName() {
    return ER5308RASL.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5308RASL.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5308RASL eEnum : ER5308RASL.values()) {
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

  public static SegmentValidation genRowValidation02() {
    int[] rows = { 1, 2, 7, 8, 9, 10, 11, 12, 13, 21, 22, 23, 24, 25, 26 };
    return genPlusValidation(UtilMetadata.genPipeColumn(COLS_NON_TOTAL), RASL0100000000, rows);
  };

  public static SegmentValidation genRowValidation04() {
    int[] rows = { 3, 4, 5, 6 };
    return genPlusValidation(UtilMetadata.genPipeColumn(COLS_NON_TOTAL), RASL0102000000, rows);
  };

  public static SegmentValidation genRowValidation15() {
    int[] rows = { 14, 15, 16, 17, 18, 19, 20 };
    return genPlusValidation(UtilMetadata.genPipeColumn(COLS_NON_TOTAL), RASL0109000000, rows);
  };

  public static SegmentValidation genRowValidation29() {
    int[] rows = { 28, 33, 34, 35, 36, 37, 38, 39, 40 };
    return genPlusValidation(UtilMetadata.genPipeColumn(COLS_NON_TOTAL), RASL0200000000, rows);
  };

  public static SegmentValidation genRowValidation30() {
    int[] rows = { 29, 30, 31, 32 };
    return genPlusValidation(UtilMetadata.genPipeColumn(COLS_NON_TOTAL), RASL0201000000, rows);
  };

  public static SegmentValidation genRowValidation43a() {
    int[] rows = { 0, 27 };
    return genPlusValidation(UtilMetadata.genPipeColumn(COLS_NON_TOTAL), RASL0300000000, rows);
  };

  public static SegmentValidation genRowValidation44() {
    int[] rows = { 43, 44, 45, 50, 51, 52, 53, 54 };
    return genPlusValidation(UtilMetadata.genPipeColumn(COLS_NON_TOTAL), RASL0301000000, rows);
  };

  public static SegmentValidation genRowValidation47() {
    int[] rows = { 46, 47, 48, 49 };
    return genPlusValidation(UtilMetadata.genPipeColumn(COLS_NON_TOTAL), RASL0304000000, rows);
  };

  public static SegmentValidation genRowValidation57() {
    int[] rows = { 56, 57 };
    return genPlusValidation(UtilMetadata.genPipeColumn(COLS_NON_TOTAL), RASL0310000000, rows);
  };

  public static SegmentValidation genRowValidation60() {
    int[] rows = { 42, 55 };
    return genPlusValidation(UtilMetadata.genPipeColumn(COLS_NON_TOTAL), RASL0400000000, rows);
  };

  public static SegmentValidation genRowValidation61() {
    int[] rows = { 41, 58 };
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

  /* -- ANTAR FORM -- */
  public static SegmentValidation genRowValidation43b() {
    String selecPosCode = RASL0300000000.key;
    String comparatorPosCode = ER5301LPK.LPK0200000000.getKey();
    return UtilSegmentValidation.genEqualsForm("19", selecPosCode, EFormLbbptkbdn.LPK.getCode(), "2",
        comparatorPosCode);
  }
}
