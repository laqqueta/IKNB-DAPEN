package id.go.ojk.bptk.client.builder.field.lbbptkjht.reference;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.bptk.client.builder.field.EFormLbbptkjht;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER5601LAN implements IObject<KeyValueString> {
  LAN0101000000("LAN0101000000", "Kas dan Bank"),
  LAN0102000000("LAN0102000000", "Piutang Iuran"),
  LAN0103000000("LAN0103000000", "Piutang Investasi"),
  LAN0104000000("LAN0104000000", "Piutang Hasil Investasi"),
  LAN0105000000("LAN0105000000", "Piutang Kontribusi BPJS"),
  LAN0106000000("LAN0106000000", "Beban dibayar dimuka"),
  LAN0107000000("LAN0107000000", "Piutang Lain"),
  LAN0108000000("LAN0108000000", "Deposito"),
  LAN0109000000("LAN0109000000", "Instrumen Pasar Uang Lainnya"),
  LAN0110000000("LAN0110000000", "Surat berharga yang diterbitkan oleh Bank Indonesia"),
  LAN0111000000("LAN0111000000", "Surat berharga yang diterbitkan oleh Negara RI"),
  LAN0112000000("LAN0112000000", "Kerjasama Operasi (KSO)"),
  LAN0113000000("LAN0113000000", "Investasi Melalui Fund Manager"),
  LAN0114000000("LAN0114000000", "Saham"),
  LAN0115000000("LAN0115000000", "Reksadana"),
  LAN0116000000("LAN0116000000", "Kontrak Investasi Kolektif - Efek Beragun Aset (KIK EBA)"),
  LAN0117000000("LAN0117000000", "Sukuk"),
  LAN0118000000("LAN0118000000", "Obligasi"),
  LAN0119000000("LAN0119000000", "Penyertaan Langsung"),
  LAN0120000000("LAN0120000000", "Properti Investasi"),
  LAN0121000000("LAN0121000000", "Aset Lain"),
  LAN0200000000("LAN0200000000", "TOTAL ASET"),
  LAN0301000000("LAN0301000000", "Utang Jaminan Siap Bayar"),
  LAN0302000000("LAN0302000000", "Utang Jaminan Yang Diserahkan Kpd Balai Harta Peninggalan"),
  LAN0303000000("LAN0303000000", "Utang Biaya Operasional Kepada BPJS"),
  LAN0303010000("LAN0303010000", "Utang Talangan kepada BPJS"),
  LAN0304000000("LAN0304000000", "Utang Kepada Pihak Lain"),
  LAN0305000000("LAN0305000000", "Utang Pajak"),
  LAN0306000000("LAN0306000000", "Pendapatan Diterima Dimuka"),
  LAN0307000000("LAN0307000000", "Biaya Yang Masih Harus Dibayar"),
  LAN0308000000("LAN0308000000", "Liabilitas Lain"),
  LAN0400000000("LAN0400000000", "TOTAL LIABILITAS"),
  LAN0500000000("LAN0500000000", "ASET NETO TERSEDIA UNTUK MANFAAT JAMINAN HARI TUA"),
  LAN0600000000("LAN0600000000", "TOTAL LIABILITAS DAN ASET NETO"),;

  public static final String POS_SALDO = "2";

  @Getter
  private String key;
  private String value;

  public static String getName() {
    return ER5601LAN.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5601LAN.class.getSimpleName().substring(2, 6));
  }

  public String getKeyForm() {
    return EFormLbbptkjht.LAN.getCode() + key;
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
    for (ER5601LAN eEnum : ER5601LAN.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static List<KeyValueString> getObjectsForm() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5601LAN eEnum : ER5601LAN.values()) {
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

  public static SegmentValidation genRowValidation23() {
    int[] rows = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
    return genPlusValidation("2", LAN0200000000, rows);
  }

  public static SegmentValidation genRowValidation26() {
    int[] rows = { 25 };
    return genPlusValidation("2", LAN0303000000, rows);
  }

  public static SegmentValidation genRowValidation33() {
    int[] rows = { 22, 23, 24, 26, 27, 28, 29, 30 };
    return genPlusValidation("2", LAN0400000000, rows);
  }

  public static SegmentValidation genRowValidation34() {
    int[] rows = { 21, 31 };
    return genMinusValidation("2", LAN0500000000, rows);
  }

  public static SegmentValidation genRowValidation35() {
    int[] rows = { 31, 32 };
    return genPlusValidation("2", LAN0600000000, rows);
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
