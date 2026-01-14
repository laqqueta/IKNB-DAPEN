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
public enum ER5100LPK implements IObject<KeyValueString> {
  LPK0101000000("LPK0101000000", "Kas dan Bank"),
  LPK0102000000("LPK0102000000", "Deposito"),
  LPK0103000000("LPK0103000000", "Piutang iuran"),
  LPK0104000000("LPK0104000000", "Piutang COB"),
  LPK0105000000("LPK0105000000", "Piutang investasi"),
  LPK0106000000("LPK0106000000", "Piutang hasil investasi"),
  LPK0107000000("LPK0107000000", "Piutang kontribusi BPJS"),
  LPK0108000000("LPK0108000000", "Piutang kepada BPJS"),
  LPK0109000000("LPK0109000000", "Piutang lain"),
  LPK0110000000("LPK0110000000", "Uang muka"),
  LPK0111000000("LPK0111000000", "Surat berharga yang diterbitkan oleh Bank Indonesia"),
  LPK0112000000("LPK0112000000", "Surat berharga yang diterbitkan oleh Negara RI"),
  LPK0113000000("LPK0113000000", "Sukuk"),
  LPK0114000000("LPK0114000000", "Obligasi"),
  LPK0115000000("LPK0115000000", "Aset lain"),
  LPK0200000000("LPK0200000000", "TOTAL ASET"),
  LPK0301000000("LPK0301000000", "Utang jaminan kesehatan"),
  LPK0302000000("LPK0302000000", "Pendapatan Diterima Dimuka"),
  LPK0303000000("LPK0303000000", "Akumulasi iuran yang belum dapat teridentifikasi pesertanya"),
  LPK0304000000("LPK0304000000", "Utang kepada BPJS"),
  LPK0304010000("LPK0304010000", "Dana operasional"),
  LPK0304020000("LPK0304020000", "Dana Talangan"),
  LPK0305000000("LPK0305000000", "Utang kepada pihak ketiga"),
  LPK0306000000("LPK0306000000", "Utang COB"),
  LPK0307000000("LPK0307000000", "Utang pajak"),
  LPK0308000000("LPK0308000000", "Cadangan teknis"),
  LPK0308010000("LPK0308010000", "Liabilitas pelayanan kesehatan dalam proses"),
  LPK0308020000("LPK0308020000", "Liabilitas pelayanan kesehatan belum dilaporkan"),
  LPK0308030000("LPK0308030000", "Iuran belum merupakan pendapatan"),
  LPK0309000000("LPK0309000000", "Liabilitas lain"),
  LPK0400000000("LPK0400000000", "TOTAL LIABILITAS"),
  LPK0500000000("LPK0500000000", "ASET NETO"),
  LPK0600000000("LPK0600000000", "TOTAL ASET NETO"),
  LPK0700000000("LPK0700000000", "TOTAL LIABILITAS DAN ASET NETO"),;

  @Getter
  private String key;
  @Getter
  private String value;

  public static final String POS_SALDO = "2";
  public static final String RPI = EFormLbbpksdjs.RPI.getCode();

  public static String getName() {
    return ER5100LPK.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5100LPK.class.getSimpleName().substring(2, 6));
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5100LPK eEnum : ER5100LPK.values()) {
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

  public static SegmentValidation genRowValidation17() {
    KeyValueString posCode = LPK0200000000.getObject();
    int[] rows = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, posCode.getKey(),
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(posCode.getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation21() {
    KeyValueString posCode = LPK0304000000.getObject();
    int[] rows = { 20, 21 };
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, posCode.getKey(),
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(posCode.getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation27() {
    KeyValueString posCode = LPK0308000000.getObject();
    int[] rows = { 26, 27, 28 };
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, posCode.getKey(),
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(posCode.getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation32() {
    KeyValueString posCode = LPK0400000000.getObject();
    int[] rows = { 16, 17, 18, 19, 22, 23, 24, 25, 29 };
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, posCode.getKey(),
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(posCode.getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation33() {
    KeyValueString posCode = LPK0500000000.getObject();
    int[] rows = { 15, 30 };
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, posCode.getKey(),
        UtilMetadata.genMinusRow(getObjects(), rows),
        UtilMetadata.genMessage(posCode.getValue(), UtilMetadata.genMinusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation34() {
    KeyValueString posCode = LPK0600000000.getObject();
    int[] rows = { 31 };
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, posCode.getKey(),
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(posCode.getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  public static SegmentValidation genRowValidation35() {
    KeyValueString posCode = LPK0700000000.getObject();
    int[] rows = { 30, 32 };
    return UtilSegmentValidation.genEqualsFormula(POS_SALDO, posCode.getKey(),
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(posCode.getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
  }

  /* -- ANTAR FORM -- */
  public static SegmentValidation genRowValidation04() {
    return UtilSegmentValidation.genEqualsForm("2", LPK0103000000.key, RPI, "14", ER5109RPI.RPI0200000000.getKey());
  }
}
