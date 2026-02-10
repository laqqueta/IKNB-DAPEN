package id.go.ojk.bptk.client.builder.field.lbbptkjp.reference;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.bptk.client.builder.field.EFormLbbptkjp;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER5801LAN implements IObject<KeyValueString> {
  LAN0101000000("LAN0101000000", "Kas dan Bank"),
  LAN0102000000("LAN0102000000", "Piutang Iuran"),
  LAN0103000000("LAN0103000000", "Piutang Investasi"),
  LAN0104000000("LAN0104000000", "Piutang Hasil Investasi"),
  LAN0105000000("LAN0105000000", "Piutang Kontribusi BPJS"),
  LAN0106000000("LAN0106000000", "Piutang Lain"),
  LAN0107000000("LAN0107000000", "Deposito"),
  LAN0108000000("LAN0108000000", "Surat berharga yang diterbitkan oleh Bank Indonesia"),
  LAN0109000000("LAN0109000000", "Surat berharga yang diterbitkan oleh Negara RI"),
  LAN0110000000("LAN0110000000", "Saham"),
  LAN0111000000("LAN0111000000", "Reksadana"),
  LAN0112000000("LAN0112000000", "Kontrak Investasi Kolektif - Efek Beragun Aset (KIK EBA)"),
  LAN0113000000("LAN0113000000", "Dana Investasi Real Estate"),
  LAN0114000000("LAN0114000000", "Sukuk"),
  LAN0115000000("LAN0115000000", "Obligasi"),
  LAN0116000000("LAN0116000000", "Repurchase agreement (REPO)"),
  LAN0117000000("LAN0117000000", "Penyertaan Langsung"),
  LAN0118000000("LAN0118000000", "Properti Investasi"),
  LAN0119000000("LAN0119000000", "Aset Lain"),
  LAN0200000000("LAN0200000000", "TOTAL ASET"),
  LAN0400000000("LAN0400000000", "Utang Jaminan Siap Bayar"),
  LAN0500000000("LAN0500000000", "Utang Jaminan Yang Diserahkan Kepada Balai Harta Peninggalan"),
  LAN0600000000("LAN0600000000", "Utang Kepada BPJS"),
  LAN0601000000("LAN0601000000", "Utang Biaya Operasional Kepada BPJS"),
  LAN0602000000("LAN0602000000", "Utang Biaya Operasional Kepada BPJS - Investasi"),
  LAN0603000000("LAN0603000000", "Utang Biaya Operasional Kepada BPJS - Pu - Layanan Syariah"),
  LAN0700000000("LAN0700000000", "Utang Kepada Pihak Lain"),
  LAN0800000000("LAN0800000000", "Utang Pajak"),
  LAN0900000000("LAN0900000000", "Pendapatan Diterima Dimuka"),
  LAN1000000000("LAN1000000000", "Biaya Yang Masih Harus Dibayar"),
  LAN1100000000("LAN1100000000", "Liabilitas JPN Usia Pensiun"),
  LAN1200000000("LAN1200000000", "Liabilitas Lain"),
  LAN1300000000("LAN1300000000", "TOTAL LIABILITAS"),
  LAN1400000000("LAN1400000000", "ASET NETO TERSEDIA UNTUK MANFAAT JAMINAN PENSIUN"),
  LAN1500000000("LAN1500000000", "TOTAL LIABILITAS DAN ASET NETO"),;

  public static final String POS_SALDO = "2";

  @Getter
  private String key;
  private String value;

  public static String getName() {
    return ER5801LAN.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5801LAN.class.getSimpleName().substring(2, 6));
  }

  public String getKeyForm() {
    return EFormLbbptkjp.LAN.getCode() + key;
  }

  public String getValue() {
    String marker = ". ";
    value = StringUtils.strip(value, "-").trim();
    int idx = value.indexOf(marker);
    return idx > -1 ? value.substring(idx + 1).trim() : value;
  }

  @Override
  public KeyValueString getObject() {
    return new KeyValueString(key, value, new String[] {});
  }

  public KeyValueString getObjectForm() {
    return new KeyValueString(getKeyForm(), getValue(), new String[] {});
  }

  public static List<KeyValueString> getObjects() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5801LAN eEnum : ER5801LAN.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static List<KeyValueString> getObjectsForm() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5801LAN eEnum : ER5801LAN.values()) {
      res.add(eEnum.getObjectForm());
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

  public static SegmentValidation genRowValidation21() {
    int[] rows = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18 };
    return genPlusValidation("2", LAN0200000000, rows);
  }

  public static SegmentValidation genRowValidation24() {
    int[] rows = { 23, 24, 25 };
    return genPlusValidation("2", LAN0600000000, rows);
  }

  public static SegmentValidation genRowValidation34() {
    int[] rows = { 20, 22, 26, 27, 28, 29, 30, 31 };
    return genPlusValidation("2", LAN1300000000, rows);
  }

  public static SegmentValidation genRowValidation35() {
    int[] rows = { 19, 32 };
    return genMinusValidation("2", LAN1400000000, rows);
  }

  public static SegmentValidation genRowValidation36() {
    int[] rows = { 32, 33 };
    return genPlusValidation("2", LAN1500000000, rows);
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
