package id.go.ojk.bpks.client.builder.field.lbbpksdjs.reference;

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
public enum ER5101LAV implements IObject<KeyValueString> {
  LAV0101000000("LAV0101000000", "Pendapatan iuran"),
  LAV0102000000("LAV0102000000", "Kontribusi dari BPJS"),
  LAV0103000000("LAV0103000000", "Bantuan dari pemerintah"),
  LAV0104000000("LAV0104000000", "Pendapatan atas Hibah dari BPJS"),
  LAV0105000000("LAV0105000000", "Pendapatan atas Pajak Rokok"),
  LAV0106000000("LAV0106000000", "Pendapatan bunga dan bagi hasil"),
  LAV0107000000("LAV0107000000", "Keuntungan pelepasan investasi"),
  LAV0108000000("LAV0108000000", "Selisih penilaian investasi"),
  LAV0109000000("LAV0109000000", "Pendapatan lain"),
  LAV0200000000("LAV0200000000", "TOTAL PENDAPATAN"),
  LAV0301000000("LAV0301000000", "Beban jaminan kesehatan"),
  LAV0302000000("LAV0302000000", "Beban cadangan teknis"),
  LAV0302010000("LAV0302010000", "Kenaikan (penurunan) liabilitas pelayanan kesehatan dalam proses"),
  LAV0302020000("LAV0302020000", "Kenaikan (penurunan) liabilitas pelayanan kesehatan belum dilaporkan"),
  LAV0302030000("LAV0302030000", "Kenaikan (penurunan) iuran yang belum merupakan pendapatan"),
  LAV0303000000("LAV0303000000", "Biaya operasional BPJS"),
  LAV0304000000("LAV0304000000", "Beban investasi"),
  LAV0305000000("LAV0305000000", "Beban penyisihan piutang"),
  LAV0306000000("LAV0306000000", "Beban lain"),
  LAV0400000000("LAV0400000000", "TOTAL BEBAN"),
  LAV0500000000("LAV0500000000", "KENAIKAN (PENURUNAN) ASET NETO"),
  LAV0600000000("LAV0600000000", "ASET NETO AWAL PERIODE"),
  LAV0700000000("LAV0700000000", "ASET NETO AKHIR PERIODE"),;

  @Getter
  private String key;
  @Getter
  private String value;

  public static final String POS_SALDO = "2";

  public static String getName() {
    return ER5101LAV.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5101LAV.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5101LAV eEnum : ER5101LAV.values()) {
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
    return UtilMetadata.genFieldSave(POS_SALDO, getObjects());
  }

  public static SegmentValidation genRowValidation11() {
    KeyValueString posCode = LAV0200000000.getObject();
    int[] rows = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, posCode.getKey(),
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(posCode.getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation13() {
    KeyValueString posCode = LAV0302000000.getObject();
    int[] rows = {12, 13, 14};
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, posCode.getKey(),
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(posCode.getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation21() {
    KeyValueString posCode = LAV0400000000.getObject();
    int[] rows = {10, 12, 13, 14, 15, 16, 17, 18};
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, posCode.getKey(),
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(posCode.getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation22() {
    KeyValueString posCode = LAV0500000000.getObject();
    int[] rows = {9, 19};
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, posCode.getKey(),
        UtilMetadata.genMinusRow(getObjects(), rows),
        UtilMetadata.genMessage(posCode.getValue(), UtilMetadata.genMinusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation24() {
    KeyValueString posCode = LAV0700000000.getObject();
    int[] rows = {20, 21};
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, posCode.getKey(),
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(posCode.getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
  }
}
