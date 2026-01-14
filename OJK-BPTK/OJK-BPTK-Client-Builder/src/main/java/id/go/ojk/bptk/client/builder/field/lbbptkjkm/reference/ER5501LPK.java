package id.go.ojk.bptk.client.builder.field.lbbptkjkm.reference;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.bptk.client.builder.field.EFormLbbptkjkk;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER5501LPK implements IObject<KeyValueString> {
  LPK0101000000("LPK0101000000", "Kas dan Bank"),
  LPK0102000000("LPK0102000000", "Piutang Iuran"),
  LPK0103000000("LPK0103000000", "Piutang Investasi"),
  LPK0104000000("LPK0104000000", "Piutang Hasil Investasi"),
  LPK0105000000("LPK0105000000", "Piutang Kontribusi BPJS"),
  LPK0106000000("LPK0106000000", "Piutang Lain"),
  LPK0107000000("LPK0107000000", "Deposito"),
  LPK0108000000("LPK0108000000", "Surat berharga yang diterbitkan oleh Bank Indonesia"),
  LPK0109000000("LPK0109000000", "Surat berharga yang diterbitkan oleh Negara RI"),
  LPK0110000000("LPK0110000000", "Tagihan reverse repo"),
  LPK0111000000("LPK0111000000", "Saham"),
  LPK0112000000("LPK0112000000", "Reksadana"),
  LPK0113000000("LPK0113000000", "Kontrak Investasi Kolektif Efek Beragun Aset (KIK EBA)"),
  LPK0114000000("LPK0114000000", "Sukuk"),
  LPK0115000000("LPK0115000000", "Obligasi"),
  LPK0116000000("LPK0116000000", "Aset Lain"),
  LPK0200000000("LPK0200000000", "TOTAL ASET"),
  LPK0301000000("LPK0301000000", "Utang Jaminan Kematian"),
  LPK0302000000("LPK0302000000", "Utang Kepada BPJS"),
  LPK0302010000("LPK0302010000", "Dana Operasional"),
  LPK0302020000("LPK0302020000", "Dana Talangan"),
  LPK0303000000("LPK0303000000", "Utang Kepada Pihak Lain"),
  LPK0304000000("LPK0304000000", "Cadangan Teknis"),
  LPK0304010000("LPK0304010000", "Liabilitas Jaminan Kematian Kerja Dalam Proses"),
  LPK0304020000("LPK0304020000", "Liabilitas Jaminan Kematian Kerja Belum Dilaporkan"),
  LPK0304030000("LPK0304030000", "Iuran Yang Belum Merupakan Pendapatan"),
  LPK0304040000("LPK0304040000", "Liabilitas Jaminan Kecelakaan Kerja Masa Depan"),
  LPK0305000000("LPK0305000000", "Liabilitas Lain"),
  LPK0400000000("LPK0400000000", "TOTAL LIABILITAS"),
  LPK0501000000("LPK0501000000", "Aset neto program tanpa pembatasan dari pemberi sumber daya"),
  LPK0502000000("LPK0502000000", "Aset neto program dengan pembatasan dari pemberi sumber daya"),
  LPK0600000000("LPK0600000000", "TOTAL ASET NETO"),
  LPK0700000000("LPK0700000000", "TOTAL LIABILITAS DAN ASET NETO"),;

  @Getter
  private String key;
  private String value;

  public static String getName() {
    return ER5501LPK.class.getSimpleName().substring(6);
  }

  public static int getRefNumber() {
    return Integer.parseInt(ER5501LPK.class.getSimpleName().substring(2, 6));
  }

  public String getKeyForm() {
    return EFormLbbptkjkk.LPK.getCode() + key;
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
    for (ER5501LPK eEnum : ER5501LPK.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static List<KeyValueString> getObjectsForm() {
    List<KeyValueString> res = new ArrayList<>();
    for (ER5501LPK eEnum : ER5501LPK.values()) {
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
    return UtilMetadata.genFieldSave("2", getObjects());
  }

  public static SegmentValidation genRowValidation18() {
    int[] rows = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
    return genPlusValidation("2", LPK0200000000, rows);
  }

  public static SegmentValidation genRowValidation20() {
    int[] rows = { 19, 20 };
    return genPlusValidation("2", LPK0302000000, rows);
  };

  public static SegmentValidation genRowValidation24() {
    int[] rows = { 23, 24, 25, 26 };
    return genPlusValidation("2", LPK0304000000, rows);
  };

  public static SegmentValidation genRowValidation30() {
    int[] rows = { 17, 18, 21, 22, 27 };
    return genPlusValidation("2", LPK0400000000, rows);
  };

  public static SegmentValidation genRowValidation33() {
    int[] rows = { 29 };
    return genPlusValidation("2", LPK0600000000, rows);
  };

  public static SegmentValidation genRowValidation34() {
    int[] rows = { 28, 31 };
    return genPlusValidation("2", LPK0700000000, rows);
  };

  private static SegmentValidation genPlusValidation(String selectField, IObject<KeyValueString> pos, int[] rows) {
    return UtilSegmentValidation.genEqualsFormula(selectField, pos.getObject().getKey(),
        UtilMetadata.genPlusRow(getObjects(), rows),
        UtilMetadata.genMessage(pos.getObject().getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
  }
}
